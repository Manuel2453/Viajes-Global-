import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  imports: [CommonModule],
  selector: 'app-actividad-resultado',
  templateUrl: './actividad-resultado.component.html',
  styleUrls: ['./actividad-resultado.component.css']
})
export class ActividadesResultadoComponent implements OnInit {
  actividades: any[] = [];
  ciudad: string = '';
  fecha: string = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    const state = history.state;
    this.actividades = state.actividades || [];
    this.ciudad = state.ciudad || '';
    this.fecha = state.fecha || '';
  }

  agregarAlCarrito(actividad: any): void {
    console.log('Actividad agregada al carrito:', actividad);
    alert(`Actividad "${actividad.titulo}" agregada al carrito.`);
  }
}
