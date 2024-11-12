import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-traslados',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './traslado.component.html',
  styleUrls: ['./traslado.component.css']
})
export class TrasladosComponent implements OnInit {
  ciudades: string[] = [];
  esDesdeAeropuerto: boolean = false;
  esHastaAeropuerto: boolean = false;
  selectedCiudadOrigen: string = '';
  selectedCiudadDestino: string = '';
  fechaTraslado: string = '';
  horaTraslado: string = '';
  trasladosDisponibles: any[] = []; // Para almacenar los traslados disponibles con precio y descripción del servicio

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    this.obtenerCiudadesDisponibles();
  }

  obtenerCiudadesDisponibles() {
    this.http.get<string[]>('http://localhost:8083/api/traslados/ciudades-disponibles').subscribe(
      (data) => {
        this.ciudades = data;
      },
      (error) => console.error('Error al cargar ciudades:', error)
    );
  }

  setAeropuertoOrigen() {
    this.esDesdeAeropuerto = true;
    this.esHastaAeropuerto = false;
    this.selectedCiudadDestino = ''; // Limpiamos el campo de destino
  }

  setAeropuertoDestino() {
    this.esDesdeAeropuerto = false;
    this.esHastaAeropuerto = true;
    this.selectedCiudadOrigen = ''; // Limpiamos el campo de origen
  }

  buscarTraslados() {
    const tipoConsulta = this.esDesdeAeropuerto ? 'Desde' : 'Hasta';
    const ciudad = this.esDesdeAeropuerto ? this.selectedCiudadOrigen : this.selectedCiudadDestino; // Cambiado para considerar ciudad de origen

    const params = new HttpParams()
      .set('ciudad', ciudad)
      .set('fecha', this.fechaTraslado)
      .set('hora', this.horaTraslado)
      .set('tipoConsulta', tipoConsulta); // Añadimos el parámetro tipoConsulta

    this.http.get<any[]>('http://localhost:8083/api/traslados/disponibles', { params }).subscribe(
      (data) => {
        // Asumimos que los datos incluyen precio y descripcionServicio
        this.trasladosDisponibles = data.map((traslado) => ({
          ...traslado,
          precio: traslado.precio,
          descripcionServicio: traslado.descripcionServicio
        }));
        this.router.navigate(['/traslado-resultado'], { state: { traslados: this.trasladosDisponibles } });
      },
      (error) => console.error('Error al buscar traslados disponibles:', error)
    );
  }
}
