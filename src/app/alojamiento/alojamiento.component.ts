import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-alojamientos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './alojamiento.component.html',
  styleUrls: ['./alojamiento.component.css']
})
export class AlojamientosComponent {
  selectedCiudad: string = '';
  ciudades: string[] = [
    "Bogotá", "Medellín", "Cali", "Cartagena", "Santa Marta",
    "Barranquilla", "Bucaramanga", "Pereira", "Manizales", "Armenia",
    "Tuluá", "Montería", "Quibdó", "Apía", "Pasto", "Valledupar",
    "Cúcuta", "Sincelejo", "Barrancabermeja", "San Andrés", "Arauca",
    "Puerto Asís", "Leticia", "Villavicencio", "Ipiales", "Tumaco",
    "Yopal", "Puerto Carreño", "San Vicente", "Tame", "Bello",
    "Soledad", "Palmira", "Cúcuta", "Riohacha", "Caldas", 
    "Zipaquirá", "Tunja", "Bucaramanga", "Sogamoso", "Neiva",
    "Cali", "Cartago", "Samaná", "Santiago de Cali", "Carmen de Viboral"
  ];

  filteredCiudades: string[] = this.ciudades; // Inicialmente muestra todas las ciudades
  showDropdown: boolean = false; // Controla la visibilidad del dropdown

  // Método para filtrar ciudades según el término de búsqueda
filterCiudades(event: Event, isCiudad: boolean) {
  const inputElement = event.target as HTMLInputElement; // Aserción de tipo para un input
  const searchTerm = inputElement.value.toLowerCase(); // Convertir a minúsculas para búsqueda insensible a mayúsculas

  if (isCiudad) {
    // Filtrar la lista de ciudades solo si se está buscando una ciudad
    this.filteredCiudades = this.ciudades.filter(ciudad =>
      ciudad.toLowerCase().includes(searchTerm)
    );
  }

  // Mostrar el dropdown solo si hay ciudades filtradas
  this.showDropdown = isCiudad && this.filteredCiudades.length > 0;
}
}
