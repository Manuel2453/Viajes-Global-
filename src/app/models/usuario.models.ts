export type PreferenciasNotificacion = 'Correo' | 'SMS' | 'Push';

export interface Usuario {
  nombre: string;
  telefono: string;
  correoElectronico: string;
  contrasena: string;
  preferenciasNotificacion: PreferenciasNotificacion; 
}
