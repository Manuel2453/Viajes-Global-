package co.viajesglobal.MicroserviceUsuarios.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Usuario") 
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Column(name = "correo_electronico")
    @Email(message = "El correo electrónico no es válido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    private String correoElectronico;

    @NotBlank(message = "El usuario es obligatorio")
    private String usuario;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Las preferencias de notificación son obligatorias")
    private NotificacionTipo preferenciasNotificacion; // Cambiado a NotificacionTipo

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	
    
}
