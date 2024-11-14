import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule ],
  selector: 'app-actividad',
  templateUrl: './actividad.component.html',
  styleUrls: ['./actividad.component.css']
})

export class ActividadesComponent implements OnInit {
  selectedCiudad: string = '';
  selectedFecha: string = '';
  ciudadesDisponibles: string[] = [];
  filteredCiudades: string[] = [];
  actividades: any[] = [];

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    this.obtenerCiudadesDisponibles();
  }

  obtenerCiudadesDisponibles(): void {
    this.http.get<string[]>('http://localhost:8083/api/actividades/destinos-disponibles')
      .subscribe((ciudades) => {
        this.ciudadesDisponibles = ciudades;
        this.filteredCiudades = ciudades;
      });
  }

  buscarActividades(): void {
    if (this.selectedCiudad && this.selectedFecha) {
      console.log("Iniciando búsqueda para ciudad:", this.selectedCiudad, "y fecha:", this.selectedFecha);
      
      this.http.get<any[]>(`http://localhost:8083/api/actividades/disponibles`, {
        params: { destino: this.selectedCiudad, fecha: this.selectedFecha }
      })
      .subscribe((actividades) => {
        console.log("Actividades obtenidas:", actividades);
        this.actividades = actividades;
        
        // Navegar a la página de resultados pasando los datos de actividades
        this.router.navigate(['/actividades-resultado'], { state: { actividades: this.actividades } });
      }, (error) => {
        console.error("Error al obtener actividades:", error);
      });
    } else {
      alert('Por favor, selecciona una ciudad y una fecha.');
    }
  }  
  

  filterCiudades(event: any): void {
    const filterValue = event.target.value.toLowerCase();
    this.filteredCiudades = this.ciudadesDisponibles.filter(ciudad =>
      ciudad.toLowerCase().includes(filterValue)
    );
  }

  goToDashboard() {
    this.router.navigate(['/dashboard']);
}
navigateToCarrito() {
  const userId = 1; // Reemplazar con la lógica para obtener el ID real del usuario
  this.router.navigate([`/carrito/${userId}`]);
}
}

