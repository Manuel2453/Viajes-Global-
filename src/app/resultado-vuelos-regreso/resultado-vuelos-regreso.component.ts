import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  selector: 'app-resultado-vuelos-regreso',
  templateUrl: './resultado-vuelos-regreso.component.html',
  styleUrls: ['./resultado-vuelos-regreso.component.css'],
})
export class ResultadoVuelosRegresoComponent implements OnInit {
  vueloIda: any;
  vuelosRegreso: any[] = [];
  claseSeleccionada: string = '';

  constructor(private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    const state = history.state;
    this.vueloIda = state.vueloIda || null;
    this.vuelosRegreso = state.vuelosRegreso || [];
    this.claseSeleccionada = state.clase || 'turista';

    console.log("Vuelo de ida seleccionado:", this.vueloIda);
    console.log("Vuelos de regreso disponibles:", this.vuelosRegreso);
  }

  agregarAlCarrito(vuelo: any): void {
    const item = {
        tipoItem: 'Vuelo',
        idReferencia: vuelo.idVuelo, // Cambiado para usar idVuelo
        aeropuertoOrigen: vuelo.origen,
        aeropuertoDestino: vuelo.destino,
        clase: this.claseSeleccionada,
        precio: vuelo.precio,
        cantidad: 1
    };
    console.log("Item enviado al carrito:", item); // Añade este log para verificar

    const idUsuario = this.getUsuarioId();
    this.http.post(`/api/carrito/${idUsuario}/agregar`, item, { headers: { 'Content-Type': 'application/json' } })
      .subscribe({
        next: () => {
          alert(`Vuelo de regreso de ${vuelo.origen} a ${vuelo.destino} agregado al carrito.`);
          this.router.navigate([`/carrito/${idUsuario}`]);
        },
        error: (error) => {
          console.error('Error al agregar el vuelo de regreso al carrito:', error);
        }
      });
}

  getUsuarioId(): number {
    return history.state.idUsuario || 1;
  }

  goToDashboard() {
    this.router.navigate(['/dashboard']);
  }

  navigateToCarrito() {
    const userId = 1;
    this.router.navigate([`/carrito/${userId}`]);
  }
}
