import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-alojamientos',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule ],
  templateUrl: './alojamiento.component.html',
  styleUrls: ['./alojamiento.component.css']
})
export class AlojamientosComponent implements OnInit {
  selectedCiudad: string = '';
  ciudades: string[] = [];
  filteredCiudades: string[] = [];
  fechaEntrada: string = '';
  fechaSalida: string = '';
  habitaciones: number = 1;
  personas: number = 1;

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    this.obtenerCiudadesDisponibles();
  }

  obtenerCiudadesDisponibles() {
    this.http.get<string[]>('http://localhost:8083/api/alojamientos/ciudades-disponibles').subscribe(
      (data) => {
        this.ciudades = data;
        this.filteredCiudades = data;
      },
      (error) => console.error('Error al cargar ciudades:', error)
    );
  }

  buscarAlojamientos() {
    const params = new HttpParams()
      .set('ciudad', this.selectedCiudad)
      .set('fechaEntrada', this.fechaEntrada)
      .set('fechaSalida', this.fechaSalida)
      .set('habitaciones', this.habitaciones.toString())
      .set('personas', this.personas.toString());

    this.http.get<any[]>('http://localhost:8083/api/alojamientos', { params }).subscribe(
      (alojamientos) => {
        // Redirige al componente de resultados con el estado necesario
        this.router.navigate(['/alojamiento-resultados'], { 
          state: { alojamientos, ciudad: this.selectedCiudad, fechaEntrada: this.fechaEntrada, fechaSalida: this.fechaSalida }
        });
      },
      (error) => console.error('Error al buscar alojamientos:', error)
    );
  }

  // Método para filtrar ciudades según el término de búsqueda
  filterCiudades(event: Event) {
    const inputElement = event.target as HTMLInputElement;
    const searchTerm = inputElement.value.toLowerCase();
    this.filteredCiudades = this.ciudades.filter(ciudad =>
      ciudad.toLowerCase().includes(searchTerm)
    );
  }

  goToDashboard() {
    this.router.navigate(['/dashboard']); // Asegúrate de que '/dashboard' sea la ruta correcta
}
}
