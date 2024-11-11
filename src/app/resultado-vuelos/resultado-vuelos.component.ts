import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-resultado-vuelos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './resultado-vuelos.component.html',
  styleUrls: ['./resultado-vuelos.component.css'],
})
export class ResultadosVuelosComponent implements OnInit {
  vuelos: any[] = [];
  vuelosIda: any[] = [];
  vuelosRegreso: any[] = [];
  tipoVuelo: string = '';
  claseSeleccionada: string = 'turista';

  constructor(private router: Router) {
    const navigation = this.router.getCurrentNavigation();
    const state = navigation?.extras?.state || {};
    this.vuelos = state['vuelos'] || [];
    this.tipoVuelo = state['tipoVuelo'] || 'solo-ida';
    this.claseSeleccionada = state['clase'] || 'turista';

    if (this.tipoVuelo === 'ida-vuelta') {
      this.vuelosIda = this.vuelos.filter((vuelo) => vuelo.tipo === 'ida');
      this.vuelosRegreso = this.vuelos.filter((vuelo) => vuelo.tipo === 'regreso');
    } else {
      this.vuelosIda = this.vuelos;
    }
  }

  seleccionarVueloIda(vuelo: any) {
    if (this.tipoVuelo === 'ida-vuelta') {
      this.router.navigate(['/resultado-vuelos-regreso'], {
        state: { vueloIda: vuelo, vuelosRegreso: this.vuelosRegreso, clase: this.claseSeleccionada },
      });
    } else {
      console.log('Vuelo de solo ida seleccionado:', vuelo);
    }
  }

  ngOnInit(): void {}
}
