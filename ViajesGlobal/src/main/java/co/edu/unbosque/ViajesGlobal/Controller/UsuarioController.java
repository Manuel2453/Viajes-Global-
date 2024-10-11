package co.edu.unbosque.ViajesGlobal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.unbosque.ViajesGlobal.DTO.UsuarioDTO;
import co.edu.unbosque.ViajesGlobal.Entity.Usuario;
import co.edu.unbosque.ViajesGlobal.Service.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crearUsuario")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioService.registrarUsuario(usuarioDTO);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el usuario: " + e.getMessage());
        }
        
    }
}
