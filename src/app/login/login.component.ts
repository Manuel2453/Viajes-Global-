import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  usuario: string = '';
  contrasena: string = '';
  errorMessage: string = ''; // Variable para el mensaje de error

  constructor(private http: HttpClient, private router: Router) {}

  iniciarSesion() {
    const loginData = {
      usuario: this.usuario,
      contrasena: this.contrasena
    };

    this.http.post('http://localhost:8080/api/usuarios/login', loginData).subscribe(
      (response: any) => {
        console.log('Inicio de sesión exitoso:', response);

        // Extraer el mensaje y el idUsuario de la respuesta
        const mensaje = response.message;
        const idUsuario = response.idUsuario; // Aquí obtenemos el idUsuario

        // Almacena el idUsuario y el nombre del usuario en localStorage
        const nombreUsuario = mensaje.split(', ')[1].replace('!', ''); // Extrae "Valentina Becerra Sastoque"
        localStorage.setItem('usuarioNombre', nombreUsuario);
        localStorage.setItem('idUsuario', idUsuario); // Guarda el idUsuario

        // Redirigir al dashboard
        this.router.navigate(['/dashboard']);
      },
      (error: any) => {
        console.error('Error en el inicio de sesión:', error);
        this.errorMessage = 'Usuario o contraseña incorrectos. Inténtalo de nuevo.';
      }
    );
  }
}
