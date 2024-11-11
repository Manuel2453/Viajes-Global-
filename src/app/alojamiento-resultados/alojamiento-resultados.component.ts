import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  imports: [CommonModule],
  selector: 'app-alojamiento-resultados',
  templateUrl: './alojamiento-resultados.component.html',
  styleUrls: ['./alojamiento-resultados.component.css']
})
export class AlojamientoResultadosComponent implements OnInit {
  alojamientos: any[] = [];
  noches: number = 1;
  personas: number = 1;
  ciudad: string = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    const state = history.state;
    this.alojamientos = state.alojamientos || [];
    this.ciudad = state.ciudad || '';
    this.noches = this.calcularNoches(state.fechaEntrada, state.fechaSalida);
    this.personas = state.personas || 1;

    // Inicializar índice de imagen actual en cada alojamiento
    this.alojamientos.forEach(alojamiento => {
      alojamiento.imagenActual = 0;
      // Asegurarse de que 'fotos', 'servicios', y 'habitaciones' estén definidos
      alojamiento.fotos = alojamiento.fotos || [];
      alojamiento.servicios = alojamiento.servicios || [];
      alojamiento.habitaciones = alojamiento.habitaciones || [];
    });
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
    console.log('Alojamiento agregado al carrito:', alojamiento);
    alert(`Alojamiento "${alojamiento.nombreHotel}" agregado al carrito.`);
  }
}
