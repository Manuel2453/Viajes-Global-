package co.viajesglobal.MicroserviceReservas.Service;

import co.viajesglobal.MicroserviceReservas.DTO.ActividadDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Actividad;
import co.viajesglobal.MicroserviceReservas.Repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    public List<ActividadDTO> obtenerActividadesPorDestinoYFecha(String destino, LocalDate fecha) {
        List<Actividad> actividades = actividadRepository.findByDestinoAndFecha(destino, fecha);
        return actividades.stream().map(this::convertirEntidadADTO).collect(Collectors.toList());
    }

    public List<String> obtenerDestinosDisponibles() {
        return actividadRepository.findDistinctDestinos();
    }

    private ActividadDTO convertirEntidadADTO(Actividad actividad) {
        ActividadDTO dto = new ActividadDTO();
        dto.setId(actividad.getId());
        dto.setDestino(actividad.getDestino());
        dto.setTitulo(actividad.getTitulo());
        dto.setDescripcion(actividad.getDescripcion());
        dto.setIncluyeTraslado(actividad.isIncluyeTraslado());
        dto.setEstrellas(actividad.getEstrellas());
        dto.setPrecio(actividad.getPrecio());
        dto.setDuracionHoras(actividad.getDuracionHoras());
        dto.setFechaInicio(actividad.getFechaInicio());
        dto.setFechaFin(actividad.getFechaFin());
        dto.setUrlImagen(actividad.getUrlImagen());
        return dto;
    }
}
