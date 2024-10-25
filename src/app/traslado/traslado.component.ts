import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-traslados',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './traslado.component.html',
  styleUrls: ['./traslado.component.css']
})
export class TrasladosComponent {
  aeropuertos: string[] = [
    'Aeropuerto El Dorado (Bogotá)',
    'Aeropuerto José María Córdova (Medellín)',
    'Aeropuerto Rafael Núñez (Cartagena)',
    'Aeropuerto Alfonso Bonilla Aragón (Cali)',
    'Aeropuerto Internacional Simón Bolívar (Santa Marta)',
    'Aeropuerto Internacional Palonegro (Bucaramanga)',
    'Aeropuerto Internacional Matecaña (Pereira)',
    // Más aeropuertos según sea necesario
  ];

  selectedCiudadOrigen: string = '';
  selectedCiudadDestino: string = '';
  tipoTransporte: string = '';
  fechaTraslado: string = '';
  horaTraslado: string = '';
  maximoPersonas: number = 1;

  esDesdeAeropuerto: boolean = false;
  esHastaAeropuerto: boolean = false;

  setAeropuertosOrigen() {
    this.esDesdeAeropuerto = true;
    this.esHastaAeropuerto = false;
  }

  setAeropuertosDestino() {
    this.esHastaAeropuerto = true;
    this.esDesdeAeropuerto = false;
  }

  // Método para manejar el envío del formulario
  enviarTraslado() {
    console.log('Traslado seleccionado:', {
      tipo: this.tipoTransporte,
      origen: this.selectedCiudadOrigen,
      destino: this.selectedCiudadDestino,
      fecha: this.fechaTraslado,
      hora: this.horaTraslado,
      cantidadPersonas: this.maximoPersonas
    });
    // Lógica adicional para manejar el traslado
  }
}
