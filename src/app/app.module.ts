import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { RegisterComponent } from './registro/registro.component';
import { FormsModule } from '@angular/forms';  // Importa FormsModule aquí

const appRoutes: Routes = [
  { path: 'registrar', component: RegisterComponent },
  { path: '', redirectTo:'/registrar', pathMatch:'full' }
];

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    RouterModule.forRoot(appRoutes, { enableTracing: true }),
    FormsModule 
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
