import { Component } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { RouterLink, RouterModule, RouterOutlet, NavigationEnd } from '@angular/router';
import { Router } from '@angular/router'; // Importa Router
import { CommonModule } from '@angular/common'; // Importa CommonModule para usar *ngIf

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [RouterModule, RouterOutlet, RouterLink, CommonModule]  // Agrega CommonModule aquí
})
export class AppComponent {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  showMainContent: boolean = true; // Nueva variable para controlar la visibilidad de la sección principal

  // Variables para los datos del usuario
  nombre: string = '';
  telefono: string = '';
  correoElectronico: string = '';
  usuario: string = '';
  contrasena: string = '';
  preferenciasNotificacion: string = ''; // Cambia esto según sea necesario
  usuarioService: any;

  constructor(private router: Router) {
    // Expresión regular para identificar rutas que incluyen `/carrito/` seguido de un ID numérico
    const carritoRegex = /^\/carrito\/\d+$/;

    // Escuchar cambios de ruta para ocultar/mostrar la sección principal
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.showMainContent = !(
          carritoRegex.test(event.url) || // Comprueba si la URL coincide con la expresión regular para el carrito
          event.url === '/registrar' ||
          event.url === '/actividades' ||
          event.url === '/actividades-resultado' ||
          event.url === '/resultado-vuelos' ||
          event.url === '/traslado-resultado' ||
          event.url === '/alojamiento-resultados' ||
          event.url === '/resultado-vuelos-regreso' ||
          event.url === '/login' ||
          event.url === '/resultados-vuelos' ||
          event.url === '/promociones' ||
          event.url === '/dashboard' ||
          event.url === '/vuelos' ||
          event.url === '/alojamiento' ||
          event.url === '/traslados'
        );
      }
    });
  }

  // Función que redirige al formulario de registro
  navigateToRegister() {
    console.log('Botón clickeado');
    this.router.navigate(['/registrar']); // Navega a la ruta '/registrar'
  }

  // Función que redirige al formulario de inicio de sesión
  navigateToLogin() {
    console.log('Navegando a la página de inicio de sesión');
    this.router.navigate(['/login']); // Navega a la ruta '/login'
  }

  registrarUsuario() {
    // Definir los parámetros a enviar
    const params = new HttpParams()
      .set('nombre', this.nombre)
      .set('telefono', this.telefono)
      .set('correoElectronico', this.correoElectronico)
      .set('usuario', this.usuario)
      .set('contrasena', this.contrasena)
      .set('preferenciasNotificacion', this.preferenciasNotificacion);
      
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
