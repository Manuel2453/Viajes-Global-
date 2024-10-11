import { Component } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { RouterLink, RouterModule, RouterOutlet } from '@angular/router';
import { Router } from '@angular/router'; // Importa Router

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [RouterModule, RouterOutlet, RouterLink]
})
export class AppComponent {
  usuarioService: any;
  constructor(private router: Router) {}

  navigateToRegister() {
    console.log('Botón clickeado');
    this.router.navigate(['/registrar']); // Navega a la ruta '/registrar'
  }
  registrarUsuario() {
    // Definir los parámetros a enviar
    const params = new HttpParams()
      .set('nombre', 'Nombre Ejemplo')
      .set('telefono', '3010000000')
      .set('correoElectronico', 'ejemplo@correo.com')
      .set('contrasena', '123456')
      .set('preferenciasNotificacion', 'SMS'); // Asegúrate de que coincide con el enum

    // Enviar la solicitud POST con los parámetros
    this.usuarioService.crearUsuario(params).subscribe(
      (response: any) => {
        console.log('Usuario registrado:', response);
        // Redirige o realiza alguna acción después de registrar el usuario
      },
      (error: any) => {
        console.error('Error al registrar el usuario:', error);
      }
    );
  }
}
