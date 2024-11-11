import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  standalone: true,
  imports: [CommonModule],
  selector: 'app-resultado-vuelos-regreso',
  templateUrl: './resultado-vuelos-regreso.component.html',
  styleUrls: ['./resultado-vuelos-regreso.component.css'],
})
export class ResultadoVuelosRegresoComponent implements OnInit {
  vueloIda: any;
  vuelosRegreso: any[] = [];
  claseSeleccionada: string = '';

  constructor(private router: Router) {
    const navigation = this.router.getCurrentNavigation();
    const state = navigation?.extras?.state || {};
    this.vueloIda = state['vueloIda'];
    this.vuelosRegreso = state['vuelosRegreso'] || [];
    this.claseSeleccionada = state['clase'] || 'turista';
  }

  seleccionarVueloRegreso(vueloRegreso: any) {
    console.log('Vuelo de regreso seleccionado:', vueloRegreso);
    // Aquí puedes redirigir a la página de confirmación o cualquier otra lógica
  }

  ngOnInit(): void {
    console.log("Vuelo de ida seleccionado:", this.vueloIda);
    console.log("Vuelos de regreso disponibles:", this.vuelosRegreso);
  }
}
