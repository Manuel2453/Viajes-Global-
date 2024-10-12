import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vuelos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './vuelos.component.html',
  styleUrls: ['./vuelos.component.css']
})
export class VuelosComponent {
  tipoVuelo: string = 'ida-vuelta'; 
  mostrarFechaVuelta: boolean = true; 
  selectedAeropuertoOrigen: string = '';
  aeropuertos: string[] = [
    "Aeropuerto El Dorado (BOG) - Bogotá",
    "Aeropuerto José María Córdova (MDE) - Medellín",
    "Aeropuerto Internacional Alfonso Bonilla Aragón (CLO) - Cali",
    "Aeropuerto Rafael Núñez (CTG) - Cartagena",
    "Aeropuerto Internacional Simón Bolívar (SMR) - Santa Marta",
    "Aeropuerto Internacional Ernesto Cortissoz (BAQ) - Barranquilla",
    "Aeropuerto Internacional Palonegro (BGA) - Bucaramanga",
    "Aeropuerto Internacional Matecaña (PEI) - Pereira",
    "Aeropuerto Internacional La Nubia (MZL) - Manizales",
    "Aeropuerto El Edén (AXM) - Armenia",
    "Aeropuerto Gustavo Artunduaga (TLU) - Tuluá",
    "Aeropuerto Los Garzones (MTR) - Montería",
    "Aeropuerto El Caraño (PBM) - Quibdó",
    "Aeropuerto La Florida (APO) - Apía",
    "Aeropuerto Antonio Narino (PSO) - Pasto",
    "Aeropuerto de Valledupar (VUP) - Valledupar",
    "Aeropuerto de Cúcuta (CUC) - Cúcuta",
    "Aeropuerto de Sincelejo (CZU) - Sincelejo",
    "Aeropuerto de Barrancabermeja (EJA) - Barrancabermeja",
    "Aeropuerto de San Andrés (ADZ) - San Andrés",
    "Aeropuerto de Arauca (AUC) - Arauca",
    "Aeropuerto de Puerto Asís (PUU) - Puerto Asís",
    "Aeropuerto de Leticia (LET) - Leticia",
    "Aeropuerto de Villavicencio (VVC) - Villavicencio",
    "Aeropuerto de Ipiales (IPI) - Ipiales",
    "Aeropuerto de Tumaco (TCO) - Tumaco",
    "Aeropuerto de Yopal (EYP) - Yopal",
    "Aeropuerto de Puerto Carreño (PCR) - Puerto Carreño",
    "Aeropuerto de San Vicente (SVE) - San Vicente",
    "Aeropuerto de Tame (TME) - Tame",
  ];

  filteredAeropuertosOrigen: string[] = this.aeropuertos; // Inicialmente muestra todos los aeropuertos
  filteredAeropuertosDestino: string[] = this.aeropuertos; // Inicialmente muestra todos los aeropuertos

  onTipoVueloChange(event: Event) {
    const selectElement = event.target as HTMLSelectElement | null; // Aserción de tipo que permite null
    if (selectElement && selectElement.value) { // Verificar que no sea null y tenga value
      this.tipoVuelo = selectElement.value; // Acceder a la propiedad value
      this.mostrarFechaVuelta = this.tipoVuelo === 'ida-vuelta';
    }
  }

  // Método para filtrar aeropuertos según el término de búsqueda
  filterAeropuertos(event: Event, isDestino: boolean) {
    const inputElement = event.target as HTMLInputElement; // Aserción de tipo para un input
    const searchTerm = inputElement?.value.toLowerCase() || ''; // Usa encadenamiento opcional

    const filtered = this.aeropuertos.filter(aeropuerto => 
      aeropuerto.toLowerCase().includes(searchTerm)
    );

    if (isDestino) {
      this.filteredAeropuertosDestino = filtered;
    } else {
      this.filteredAeropuertosOrigen = filtered; // Este es el nombre correcto
    }
  }
}