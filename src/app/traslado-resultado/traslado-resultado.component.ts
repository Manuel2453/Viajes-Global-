import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';


@Component({
  standalone: true,
  imports: [CommonModule],
  selector: 'app-traslados-resultados',
  templateUrl: './traslado-resultado.component.html',
  styleUrls: ['./traslado-resultado.component.css']
})
export class TrasladosResultadosComponent implements OnInit {
  traslados: any[] = [];
  ciudadOrigen: string = '';
  ciudadDestino: string = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    const state = history.state;
    this.traslados = state.traslados || [];
    this.ciudadOrigen = state.ciudadOrigen || '';
    this.ciudadDestino = state.ciudadDestino || '';
  }

  agregarAlCarrito(traslado: any): void {
    alert(`Traslado "${traslado.tipoTransporte}" agregado al carrito.`);
  }
}
