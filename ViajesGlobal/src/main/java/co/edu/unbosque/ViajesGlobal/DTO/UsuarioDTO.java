package co.edu.unbosque.ViajesGlobal.DTO;

import co.edu.unbosque.ViajesGlobal.Entity.NotificacionTipo;

public class UsuarioDTO {
    private String nombre;
    private String telefono;
    private String correoElectronico;
    private String contrasena;
    private NotificacionTipo preferenciasNotificacion; // Asegúrate de que sea del tipo correcto

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public NotificacionTipo getPreferenciasNotificacion() {
        return preferenciasNotificacion;
    }

    public void setPreferenciasNotificacion(NotificacionTipo preferenciasNotificacion) {
        this.preferenciasNotificacion = preferenciasNotificacion;
    }
}
