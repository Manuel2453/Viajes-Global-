import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  selector: 'app-traslados-resultados',
  templateUrl: './traslado-resultado.component.html',
  styleUrls: ['./traslado-resultado.component.css']
})
export class TrasladosResultadosComponent implements OnInit {
  traslados: any[] = [];
  ciudadOrigen: string = '';
  ciudadDestino: string = '';

  constructor(private route: ActivatedRoute, private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    const state = history.state;
    this.traslados = state.traslados || [];
    this.ciudadOrigen = state.ciudadOrigen || '';
    this.ciudadDestino = state.ciudadDestino || '';
    const idUsuario = state.idUsuario || 1; // Obtén el idUsuario desde el estado
  }

  agregarAlCarrito(traslado: any): void {
    const item = {
      tipoItem: 'Traslado',
      idReferencia: traslado.id,
      ciudadOrigen: traslado.ciudadOrigen,
      ciudadDestino: traslado.ciudadDestino,
      tipoTransporte: traslado.tipoTransporte,
      precio: traslado.precio,
      cantidad: 1
    };
    console.log("Item enviado al carrito:", item); // Añade este log para verificar


    const idUsuario = this.getUsuarioId(); // Obtiene el idUsuario dinámico
    this.http.post(`/api/carrito/${idUsuario}/agregar`, item, { headers: { 'Content-Type': 'application/json' } })
      .subscribe({
        next: (response) => {
          console.log('Item agregado al carrito', response);
          alert(`Traslado "${traslado.tipoTransporte}" agregado al carrito.`);
          this.router.navigate([`/carrito/${idUsuario}`]);
        },
        error: (error) => {
          console.error('Error al agregar el item al carrito:', error);
        }
      });
  }

  // Método auxiliar para obtener idUsuario
  getUsuarioId(): number {
    return history.state.idUsuario || 1;
  }

  goToDashboard() {
    this.router.navigate(['/dashboard']);
  }

  navigateToCarrito() {
    const userId = 1; // Reemplazar con la lógica para obtener el ID real del usuario
    this.router.navigate([`/carrito/${userId}`]);
  }

}
