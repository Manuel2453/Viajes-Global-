package co.viajesglobal.MicroserviceUsuarios.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @Email(message = "El usuario no es válido")
    @NotBlank(message = "El usuario es obligatorio")
    private String usuario;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public LoginRequest(
			@Email(message = "El usuario no es válido") @NotBlank(message = "El usuario es obligatorio") String usuario,
			@NotBlank(message = "La contraseña es obligatoria") String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

}
