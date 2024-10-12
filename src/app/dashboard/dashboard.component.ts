import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  usuarioNombre: string = '(Falta nombre usuario)'; // Reemplaza 'c' por el nombre real del usuario
  showMainContent: boolean = false; // Siempre ocultar el contenido principal

  constructor(private router: Router) {}

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
