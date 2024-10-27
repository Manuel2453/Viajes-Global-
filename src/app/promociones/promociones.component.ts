// src/app/promociones/promociones.component.ts
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-promociones',
  standalone: true,
  imports: [CommonModule, HttpClientModule], // Asegura los módulos necesarios
  templateUrl: './promociones.component.html',
  styleUrls: ['./promociones.component.css'],
})
export class PromocionesComponent implements OnInit {
  promociones: any[] = [];
  private apiUrl = 'http://localhost:8081/api/promociones';
  private descuentosUrl = 'http://localhost:8081/api/descuentos';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.getPromociones();
    this.getDescuentos();
  }

  getPromociones() {
    this.http.get<any[]>(this.apiUrl).subscribe(
      (data) => {
        console.log('Promociones recibidas:', data);
        this.promociones = data;
      },
      (error) => console.error('Error al obtener promociones:', error)
    );
  }

  getDescuentos() {
    this.http.get<any[]>(this.descuentosUrl).subscribe(
      (data) => {
        console.log('Descuentos recibidos:', data);
      },
      (error) => console.error('Error al obtener descuentos:', error)
    );
  }
}
