import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';


@Component({
  standalone: true,
  imports: [CommonModule, HttpClientModule, ],
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {
  items: any[] = [];
  total: number = 0;

  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    const userId = this.route.snapshot.params['idUsuario'];
    this.cargarCarrito(userId);
  }

  cargarCarrito(userId: number): void {
    this.http.get<any>(`http://localhost:8082/api/carrito/${userId}/completo`).subscribe(
      response => {
        // Verifica si response.items es un array y si contiene los items
        this.items = Array.isArray(response.items) ? response.items : []; // Accede directamente a los items
        this.calcularTotal();
      },
      error => {
        console.error('Error al cargar el carrito:', error);
      }
    );
  }
  

  calcularTotal(): void {
    this.total = this.items.reduce((sum, item) => sum + (item.precio * item.cantidad), 0);
  }

  realizarPago(): void {
    alert('Implementaremos el proceso de pago más adelante');
  }

  goToDashboard() {
    this.router.navigate(['/dashboard']); // Asegúrate de que '/dashboard' sea la ruta correcta
}
}
