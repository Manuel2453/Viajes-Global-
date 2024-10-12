import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './registro/registro.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { VuelosComponent } from './vuelos/vuelos.component';
import { AlojamientosComponent  } from './alojamiento/alojamiento.component';
import { NgModule } from '@angular/core';
import { TrasladosComponent } from './traslado/traslado.component';


export const routes: Routes = [
  { path: 'registrar', component: RegisterComponent },  // Ruta para registro
  { path: 'login', component: LoginComponent },
  { path: 'vuelos', component: VuelosComponent },
  { path: 'alojamiento', component: AlojamientosComponent },
//  { path: 'actividades', component: ActividadesComponent },
  { path: 'traslados', component: TrasladosComponent },
  { path: 'dashboard', component: DashboardComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
