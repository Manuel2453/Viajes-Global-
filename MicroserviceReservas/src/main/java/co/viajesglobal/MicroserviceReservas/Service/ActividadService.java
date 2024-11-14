package co.viajesglobal.MicroserviceReservas.Service;

import co.viajesglobal.MicroserviceReservas.Client.ActividadClient;
import co.viajesglobal.MicroserviceReservas.DTO.ActividadDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Actividad;
import co.viajesglobal.MicroserviceReservas.Repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActividadService {

    @Autowired
    private ActividadClient actividadClient;

    @Autowired
    private ActividadRepository actividadRepository;

    public List<ActividadDTO> obtenerActividadesExternas(String destino, LocalDate fecha) {
        String fechaStr = fecha.format(DateTimeFormatter.ISO_DATE);
        return actividadClient.obtenerActividadesPorDestinoYFecha(destino, fechaStr);
    }
  
    public List<ActividadDTO> obtenerActividadesInternas(String destino, LocalDate fecha) {
        List<Actividad> actividades = actividadRepository.findByDestinoAndFecha(destino, fecha);
        return actividades.stream().map(this::convertirEntidadADTO).collect(Collectors.toList());
    }

    public List<String> obtenerDestinosDisponiblesInternos() {
        return actividadRepository.findDistinctDestinos();
    }
    
    public ActividadDTO obtenerActividadPorId(Long id) {
        return actividadRepository.findById(id)
                .map(this::convertirEntidadADTO)
                .orElse(null);
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
