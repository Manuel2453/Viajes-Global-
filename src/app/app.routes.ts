import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './registro/registro.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { VuelosComponent } from './vuelos/vuelos.component';
import { ResultadosVuelosComponent} from './resultado-vuelos/resultado-vuelos.component';
import { ResultadoVuelosRegresoComponent} from './resultado-vuelos-regreso/resultado-vuelos-regreso.component';
import { AlojamientosComponent  } from './alojamiento/alojamiento.component';
import {NgModule } from '@angular/core';
import { TrasladosComponent } from './traslado/traslado.component';
import { PromocionesComponent } from './promociones/promociones.component'; // Importa el componente
import { AlojamientoResultadosComponent } from './alojamiento-resultados/alojamiento-resultados.component';
import { TrasladosResultadosComponent } from './traslado-resultado/traslado-resultado.component';
import { ActividadesComponent } from './actividad/actividad.component';
import { ActividadesResultadoComponent } from './actividad-resultado/actividad-resultado.component';
import { CarritoComponent } from './carrito/carrito.component';

export const routes: Routes = [
  { path: 'registrar', component: RegisterComponent },  // Ruta para registro
  { path: 'login', component: LoginComponent },
  { path: 'vuelos', component: VuelosComponent },
  { path: 'resultados-vuelos', component: ResultadosVuelosComponent },
  { path: 'alojamiento', component: AlojamientosComponent },
  { path: 'alojamiento-resultados', component: AlojamientoResultadosComponent },
 { path: 'actividades', component: ActividadesComponent},
  { path: 'traslados', component: TrasladosComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'promociones', component: PromocionesComponent }, // Ruta para promociones
  { path: 'resultado-vuelos', component: ResultadosVuelosComponent },
  { path: 'resultado-vuelos-regreso', component: ResultadoVuelosRegresoComponent },
  { path: 'traslado-resultado', component: TrasladosResultadosComponent },
  {path: 'actividades-resultado', component: ActividadesResultadoComponent},
  { path: 'carrito/:idUsuario', component: CarritoComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
