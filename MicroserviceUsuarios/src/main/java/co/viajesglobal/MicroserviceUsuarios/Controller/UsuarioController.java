package co.viajesglobal.MicroserviceUsuarios.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.viajesglobal.MicroserviceUsuarios.DTO.LoginRequest;
import co.viajesglobal.MicroserviceUsuarios.DTO.UsuarioDTO;
import co.viajesglobal.MicroserviceUsuarios.Entity.Usuario;
import co.viajesglobal.MicroserviceUsuarios.Service.UsuarioService;


@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crearUsuario")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        System.out.println("Preferencias de notificación recibidas: " + usuarioDTO.getPreferenciasNotificacion());
    	try {
            Usuario usuario = usuarioService.registrarUsuario(usuarioDTO);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el usuario: " + e.getMessage());
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        // Lógica de autenticación
        String usuario = loginRequest.getUsuario(); // Cambiado para usar el usuario
        String contrasena = loginRequest.getContrasena();
        
        // Autenticación con el servicio
        Usuario usuario1 = usuarioService.autenticarUsuario(usuario, contrasena); // Cambiado para usar el usuario
        
        if (usuario1 != null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Acceso exitoso. Bienvenido, " + usuario1.getNombre() + "!");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Credenciales inválidas. Intenta nuevamente.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
