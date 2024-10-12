import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Import FormsModule para ngModel

@Component({
  selector: 'app-traslados',
  standalone: true,
  imports: [CommonModule, FormsModule], // Import FormsModule
  templateUrl: './traslado.component.html',
  styleUrls: ['./traslado.component.css']
})
export class TrasladosComponent {
  ciudades: string[] = [
    'Bogotá', 'Medellín', 'Cartagena', 'Cali', 'Barranquilla',
    'Santa Marta', 'Bucaramanga', 'Pereira', 'Manizales', 'Armenia',
    'Montería', 'Villavicencio', 'Cúcuta', 'Pasto', 'Sincelejo',
    'Valledupar', 'San Andrés', 'Leticia', 'Yopal', 'Tunja'
  ];

  filteredCiudadesOrigen: string[] = this.ciudades;
  filteredCiudadesDestino: string[] = this.ciudades;

  selectedCiudadOrigen: string = '';
  selectedCiudadDestino: string = '';
  tipoTransporte: string = '';
  empresa: string = '';
  fechaTraslado: string = '';
  horaTraslado: string = '';
  cantidadPersonas: number = 1;

  // Filtrar las ciudades según el término de búsqueda
  filterCiudades(event: Event, isDestino: boolean) {
    const inputElement = event.target as HTMLInputElement;
    const searchTerm = inputElement.value.toLowerCase();

    const filtered = this.ciudades.filter(ciudad =>
      ciudad.toLowerCase().includes(searchTerm)
    );

    if (isDestino) {
      this.filteredCiudadesDestino = filtered;
    } else {
      this.filteredCiudadesOrigen = filtered;
    }
  }

  // Método para manejar el envío del formulario
  enviarTraslado() {
    console.log('Traslado seleccionado:', {
      tipo: this.tipoTransporte,
      empresa: this.empresa,
      origen: this.selectedCiudadOrigen,
      destino: this.selectedCiudadDestino,
      fecha: this.fechaTraslado,
      hora: this.horaTraslado,
      cantidadPersonas: this.cantidadPersonas
    });
    // Lógica adicional para manejar el traslado
  }
}
