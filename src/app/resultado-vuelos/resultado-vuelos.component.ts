import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-resultado-vuelos',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './resultado-vuelos.component.html',
  styleUrls: ['./resultado-vuelos.component.css'],
})
export class ResultadosVuelosComponent implements OnInit {
  vuelos: any[] = [];
  vuelosIda: any[] = [];
  vuelosRegreso: any[] = [];
  tipoVuelo: string = '';
  claseSeleccionada: string = 'turista';

  constructor(private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    const state = history.state;
    this.vuelos = state.vuelos || [];
    this.tipoVuelo = state.tipoVuelo || 'solo-ida';
    this.claseSeleccionada = state.clase || 'turista';
    this.vuelosIda = this.vuelos.filter(vuelo => vuelo.tipo === 'ida');
    this.vuelosRegreso = this.vuelos.filter(vuelo => vuelo.tipo === 'regreso');
  }

  agregarAlCarrito(vuelo: any): void {
    const item = {
        tipoItem: 'Vuelo',
        idReferencia: vuelo.idVuelo,
        aeropuertoOrigen: vuelo.origen,
        aeropuertoDestino: vuelo.destino,
        clase: this.claseSeleccionada,
        precio: vuelo.precio,
        cantidad: 1
    };
    console.log("Item enviado al carrito:", item);

    const idUsuario = this.getUsuarioId();
    this.http.post(`/api/carrito/${idUsuario}/agregar`, item, { headers: { 'Content-Type': 'application/json' } })
      .subscribe({
        next: () => {
          alert(`Vuelo de ${vuelo.origen} a ${vuelo.destino} agregado al carrito.`);
          if (this.tipoVuelo === 'ida-vuelta') {
            // Redirige solo después de que el vuelo de ida se ha agregado al carrito
            this.router.navigate(['/resultado-vuelos-regreso'], {
              state: { vueloIda: vuelo, vuelosRegreso: this.vuelosRegreso, clase: this.claseSeleccionada },
            });
          } else {
            this.router.navigate([`/carrito/${idUsuario}`]);
          }
        },
        error: (error) => {
          console.error('Error al agregar el vuelo al carrito:', error);
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

  seleccionarVueloIda(vuelo: any) {
    if (this.tipoVuelo === 'ida-vuelta') {
        this.agregarAlCarrito(vuelo);  // Llama a agregarAlCarrito primero
    } else {
        console.log('Vuelo de solo ida seleccionado:', vuelo);
        this.agregarAlCarrito(vuelo);  // Llama a agregarAlCarrito también para vuelos de solo ida
    }
}

}
