import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vuelos',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './vuelos.component.html',
  styleUrls: ['./vuelos.component.css'],
})
export class VuelosComponent implements OnInit {
  tipoVuelo: string = 'ida-vuelta';
  mostrarFechaVuelta: boolean = true;
  origen: string = '';
  destino: string = '';
  fechaSalida: string = '';
  fechaVuelta: string = '';
  personas: number = 1;
  clase: string = 'turista';

  aeropuertos: string[] = [];
  filteredAeropuertosOrigen: string[] = [];
  filteredAeropuertosDestino: string[] = [];

  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.obtenerAeropuertos();
    this.route.queryParams.subscribe((params) => {
      this.cargarParametrosBusqueda(params);
    });
  }

  onTipoVueloChange() {
    this.mostrarFechaVuelta = this.tipoVuelo === 'ida-vuelta';
  }

  obtenerAeropuertos() {
    this.http.get<string[]>('http://localhost:8083/api/vuelos/aeropuertos').subscribe(
      (data) => {
        this.aeropuertos = data;
        this.filteredAeropuertosOrigen = data;
        this.filteredAeropuertosDestino = data;
      },
      (error) => console.error('Error al cargar aeropuertos:', error)
    );
  }

  cargarParametrosBusqueda(params: any): void {
    this.clase = params['clase'] || 'turista';
    this.tipoVuelo = params['tipoVuelo'] || 'solo-ida';
    this.fechaSalida = params['fechaSalida'];
    this.fechaVuelta = params['fechaVuelta'];
  }

  buscarVuelos() {
    const params = new HttpParams()
      .set('origen', this.origen)
      .set('destino', this.destino)
      .set('fechaSalida', this.fechaSalida)
      .set('fechaVuelta', this.tipoVuelo === 'ida-vuelta' ? this.fechaVuelta : '')
      .set('personas', this.personas.toString())
      .set('clase', this.clase)
      .set('tipoVuelo', this.tipoVuelo);

    this.http.get<any[]>('http://localhost:8083/api/vuelos', { params }).subscribe(
      (vuelos) => {
        const origenBusqueda = this.origen.trim().toLowerCase();
        const destinoBusqueda = this.destino.trim().toLowerCase();
    
        // Clasificación de vuelos como ida o regreso
        const vuelosConTipo = vuelos.map(vuelo => {
          const origenVuelo = vuelo.origen.trim().toLowerCase();
          const destinoVuelo = vuelo.destino.trim().toLowerCase();
    
          if (origenVuelo === origenBusqueda && destinoVuelo === destinoBusqueda) {
            vuelo.tipo = 'ida';
          } else if (origenVuelo === destinoBusqueda && destinoVuelo === origenBusqueda) {
            vuelo.tipo = 'regreso';
          }
          return vuelo;
        });
    
        // Redirigir al componente de resultados de vuelos
        this.router.navigate(['/resultado-vuelos'], { 
          state: { 
            vuelos: vuelosConTipo, 
            tipoVuelo: this.tipoVuelo, 
            clase: this.clase,
            origen: this.origen,
            destino: this.destino
          } 
        });

      },
      error => console.error('Error al buscar vuelos:', error)
    );    
  }

  goToDashboard() {
    this.router.navigate(['/dashboard']); // Asegúrate de que '/dashboard' sea la ruta correcta
}

navigateToCarrito() {
  const userId = 1; // Reemplazar con la lógica para obtener el ID real del usuario
  this.router.navigate([`/carrito/${userId}`]);
}
}
