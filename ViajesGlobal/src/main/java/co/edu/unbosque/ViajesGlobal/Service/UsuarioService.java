package co.edu.unbosque.ViajesGlobal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.ViajesGlobal.DTO.UsuarioDTO;
import co.edu.unbosque.ViajesGlobal.Entity.Usuario;
import co.edu.unbosque.ViajesGlobal.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(usuarioDTO.getNombre());
        nuevoUsuario.setTelefono(usuarioDTO.getTelefono());
        nuevoUsuario.setCorreoElectronico(usuarioDTO.getCorreoElectronico());
        nuevoUsuario.setUsuario(usuarioDTO.getUsuario()); // Asegúrate de que UsuarioDTO tenga el nuevo campo
        nuevoUsuario.setContrasena(usuarioDTO.getContrasena());
        nuevoUsuario.setPreferenciasNotificacion(usuarioDTO.getPreferenciasNotificacion()); // Esto ahora es de tipo NotificacionTipo

        return usuarioRepository.save(nuevoUsuario);
    }

    
    public Usuario autenticarUsuario(String usuario, String contrasena) {
        Usuario usuario1 = usuarioRepository.findByUsuario(usuario); // Cambiado para buscar por nombre de usuario
        if (usuario1 != null && usuario1.getContrasena().equals(contrasena)) {
            return usuario1;
        } else {
            return null; // Si no coincide o no existe, retorna null.
        }
    }
}
