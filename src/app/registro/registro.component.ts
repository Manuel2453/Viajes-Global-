import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css'],
  standalone: true,
  imports: [FormsModule,  HttpClientModule]
})
export class RegisterComponent {
  private apiUrl = 'http://localhost:8080/api/usuarios/crearUsuario'; // Cambia a tu URL correcta

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit(form: any) {
    // Crear el objeto usuario a partir del formulario
    const usuario = {
      nombre: form.value.nombre,
      telefono: form.value.telefono,
      correoElectronico: form.value.correoElectronico,
      usuario: form.value.usuario,
      contrasena: form.value.contrasena,
      preferenciasNotificacion: form.value.preferenciasNotificacion
    };

    console.log("Datos del usuario antes de enviar:", usuario); 
    console.log("preferencia de notificación: ", form.value.preferenciasNotificacion  )

    // Enviar la solicitud POST con el cuerpo (usuario) en formato JSON
    this.http.post(this.apiUrl, usuario)
      .subscribe({
        next: (response) => {
          console.log('Usuario creado:', response);
          alert('Usuario registrado con éxito');
          this.router.navigate(['/']);
        },
        error: (error) => {
          console.error('Error al crear el usuario:', error);
          alert('Hubo un error al registrar el usuario. Inténtalo de nuevo.');
        }
      });
  }
}