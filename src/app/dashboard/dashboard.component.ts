import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, HttpClientModule], // Importar HttpClientModule aquí
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  usuarioNombre: string = ''; // Inicializa la variable para el nombre del usuario
  promociones: any[] = [];
  descuentos: any[] = [];

  private apiUrl = 'http://localhost:8081/api/promociones';
  private descuentosUrl = 'http://localhost:8081/api/descuentos';

  constructor(private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    // Obtener el nombre del usuario de localStorage
    this.usuarioNombre = localStorage.getItem('usuarioNombre') || '(Falta nombre usuario)';

    // Llamadas para obtener promociones y descuentos
    this.obtenerPromociones();
    this.obtenerDescuentos();
  }

  obtenerPromociones() {
    this.http.get<any[]>(this.apiUrl).subscribe(
      (data) => {
        console.log('Promociones recibidas:', data);
        this.promociones = data;
      },
      (error) => {
        console.error('Error al obtener promociones:', error);
      }
    );
  }

  obtenerDescuentos() {
    this.http.get<any[]>(this.descuentosUrl).subscribe(
      (data) => {
        console.log('Descuentos recibidos:', data);
        this.descuentos = data;
      },
      (error) => {
        console.error('Error al obtener descuentos:', error);
      }
    );
  }

  navigateToVuelos() {
    this.router.navigate(['/vuelos']);
  }

  navigateToAlojamientos() {
    this.router.navigate(['/alojamiento']);
  }

  navigateToActividades() {
    this.router.navigate(['/actividades']);
  }

  navigateToTraslados() {
    this.router.navigate(['/traslados']);
  }
}
