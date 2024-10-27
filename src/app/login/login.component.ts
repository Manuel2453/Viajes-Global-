import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule,],  // Asegúrate de importar FormsModule y CommonModule
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  usuario: string = '';
  contrasena: string = '';
  errorMessage: string = ''; // Variable para el mensaje de error


  constructor(private http: HttpClient, private router: Router) {}

  iniciarSesion() {
    // Datos de login
    const loginData = {
      usuario: this.usuario,
      contrasena: this.contrasena
    };

    // Llamada al backend
    this.http.post('http://localhost:8080/api/usuarios/login', loginData).subscribe(
      (response: any) => {
        console.log('Inicio de sesión exitoso:', response);
           // Guarda el nombre del usuario en localStorage
      const mensaje = response.message;
      const nombreUsuario = mensaje.split(', ')[1].replace('!', ''); // Extrae "Valentina Becerra Sastoque"
      localStorage.setItem('usuarioNombre', nombreUsuario);
        // Extraer el mensaje de la respuesta
        this.errorMessage = response.message; // Cambiar a usar el mensaje del objeto
        // Redirigir al dashboard si las credenciales son correctas
        this.router.navigate(['/dashboard']);
      },
      (error: any) => {
        console.error('Error en el inicio de sesión:', error);
        // Mostrar mensaje de error si las credenciales son incorrectas
        this.errorMessage = 'Usuario o contraseña incorrectos. Inténtalo de nuevo.';
      }
    ); // Fin de la llamada al backend

  }
}