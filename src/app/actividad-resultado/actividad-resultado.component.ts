import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  selector: 'app-actividad-resultado',
  templateUrl: './actividad-resultado.component.html',
  styleUrls: ['./actividad-resultado.component.css']
})
export class ActividadesResultadoComponent implements OnInit {
  actividades: any[] = [];
  ciudad: string = '';
  fecha: string = '';

  constructor(private route: ActivatedRoute, private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    const state = history.state;
    this.actividades = state.actividades || [];
    this.ciudad = state.ciudad || '';
    this.fecha = state.fecha || '';
  }

  agregarAlCarrito(actividad: any): void {
    const item = {
      tipoItem: 'Actividad',
      idReferencia: actividad.id,
      titulo: actividad.titulo,
      precio: actividad.precio,
      cantidad: 1
    };

    const idUsuario = this.getUsuarioId();
    this.http.post(`/api/carrito/${idUsuario}/agregar`, item, { headers: { 'Content-Type': 'application/json' } })
      .subscribe({
        next: (response) => {
          console.log('Actividad agregada al carrito', response);
          alert(`Actividad "${actividad.titulo}" agregada al carrito.`);
          this.router.navigate([`/carrito/${idUsuario}`]);
        },
        error: (error) => {
          console.error('Error al agregar la actividad al carrito:', error);
        }
      });
  }

  getUsuarioId(): number {
    return history.state.idUsuario || 1;
  }

  goToDashboard() {
    this.router.navigate(['/dashboard']);
  }

  navigateToCarrito() {
    const userId = 1;
    this.router.navigate([`/carrito/${userId}`]);
  }
}
