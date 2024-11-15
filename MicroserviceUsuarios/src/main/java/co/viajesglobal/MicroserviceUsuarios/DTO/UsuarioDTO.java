package co.viajesglobal.MicroserviceUsuarios.DTO;

import co.viajesglobal.MicroserviceUsuarios.Entity.NotificacionTipo;

public class UsuarioDTO {
    private String nombre;
    private String telefono;
    private String correoElectronico;
    private String usuario;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public UsuarioDTO(String nombre, String telefono, String correoElectronico, String usuario, String contrasena,
			NotificacionTipo preferenciasNotificacion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.preferenciasNotificacion = preferenciasNotificacion;
	}

}
