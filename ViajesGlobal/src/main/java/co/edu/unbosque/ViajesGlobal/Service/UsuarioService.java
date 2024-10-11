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
//        if (usuarioRepository.findByCorreoElectronico(usuarioDTO.getCorreoElectronico()) != null) {
//            throw new RuntimeException("El correo electrónico ya está registrado.");
//        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(usuarioDTO.getNombre());
        nuevoUsuario.setTelefono(usuarioDTO.getTelefono());
        nuevoUsuario.setCorreoElectronico(usuarioDTO.getCorreoElectronico());
        nuevoUsuario.setContrasena(usuarioDTO.getContrasena());
        nuevoUsuario.setPreferenciasNotificacion(usuarioDTO.getPreferenciasNotificacion()); // Esto ahora es de tipo NotificacionTipo

        return usuarioRepository.save(nuevoUsuario);
    }

}
