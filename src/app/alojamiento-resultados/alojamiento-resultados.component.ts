import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  selector: 'app-alojamiento-resultados',
  templateUrl: './alojamiento-resultados.component.html',
  styleUrls: ['./alojamiento-resultados.component.css']
})
export class AlojamientoResultadosComponent implements OnInit {
  alojamientos: any[] = [];
  noches: number = 1;
  personas: number = 1;
  ciudad: string = '';

  constructor(private route: ActivatedRoute, private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    const state = history.state;
    this.alojamientos = state.alojamientos || [];
    this.ciudad = state.ciudad || '';
    this.noches = this.calcularNoches(state.fechaEntrada, state.fechaSalida);
    this.personas = state.personas || 1;
  }

  calcularNoches(fechaEntrada: string, fechaSalida: string): number {
    const entrada = new Date(fechaEntrada);
    const salida = new Date(fechaSalida);
    return Math.ceil((salida.getTime() - entrada.getTime()) / (1000 * 60 * 60 * 24));
  }

  anteriorImagen(alojamiento: any): void {
    if (alojamiento.imagenActual > 0) {
      alojamiento.imagenActual--;
    } else {
      alojamiento.imagenActual = alojamiento.fotos.length - 1;
    }
  }

  siguienteImagen(alojamiento: any): void {
    if (alojamiento.imagenActual < alojamiento.fotos.length - 1) {
      alojamiento.imagenActual++;
    } else {
      alojamiento.imagenActual = 0;
    }
  }

  agregarAlCarrito(alojamiento: any): void {
    const item = {
      tipoItem: 'Alojamiento',
      idReferencia: alojamiento.id,
      nombreHotel: alojamiento.nombreHotel,
      precio: alojamiento.precioNoche * this.noches,
      cantidad: this.noches
    };

    const idUsuario = this.getUsuarioId();
    this.http.post(`/api/carrito/${idUsuario}/agregar`, item, { headers: { 'Content-Type': 'application/json' } })
      .subscribe({
        next: (response) => {
          console.log('Alojamiento agregado al carrito', response);
          alert(`Alojamiento "${alojamiento.nombreHotel}" agregado al carrito.`);
          this.router.navigate([`/carrito/${idUsuario}`]);
        },
        error: (error) => {
          console.error('Error al agregar el alojamiento al carrito:', error);
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
    const userId = 1; // Reemplazar con la lógica para obtener el ID real del usuario
    this.router.navigate([`/carrito/${userId}`]);
  }

}
