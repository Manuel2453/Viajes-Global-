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

/**
 * Servicio que maneja la lógica de negocio relacionada con las actividades.
 * Este servicio interactúa con clientes externos (para obtener actividades) 
 * y con la base de datos para obtener actividades internas.
 */
@Service
public class ActividadService {

    @Autowired
    private ActividadClient actividadClient;

    @Autowired
    private ActividadRepository actividadRepository;

    /**
     * Obtiene actividades externas de un destino y fecha específicos mediante un cliente externo.
     * 
     * @param destino el destino de las actividades a consultar.
     * @param fecha la fecha de las actividades a consultar.
     * @return una lista de actividades externas disponibles para el destino y fecha proporcionados.
     */
    public List<ActividadDTO> obtenerActividadesExternas(String destino, LocalDate fecha) {
        String fechaStr = fecha.format(DateTimeFormatter.ISO_DATE);
        return actividadClient.obtenerActividadesPorDestinoYFecha(destino, fechaStr);
    }

    /**
     * Obtiene actividades internas disponibles para un destino y fecha específicos desde la base de datos.
     * 
     * @param destino el destino de las actividades a consultar.
     * @param fecha la fecha de las actividades a consultar.
     * @return una lista de actividades internas disponibles en la base de datos.
     */
    public List<ActividadDTO> obtenerActividadesInternas(String destino, LocalDate fecha) {
        List<Actividad> actividades = actividadRepository.findByDestinoAndFecha(destino, fecha);
        return actividades.stream()
                .map(this::convertirEntidadADTO)
                .peek(dto -> System.out.println("Actividad DTO construida: " + dto.getId()))
                .collect(Collectors.toList());
    }

    /**
     * Obtiene todas las actividades internas disponibles desde la base de datos.
     * 
     * @return una lista de todas las actividades internas disponibles.
     */
    public List<ActividadDTO> obtenerTodasActividades() {
        List<Actividad> actividades = actividadRepository.findAll();
        return actividades.stream().map(this::convertirEntidadADTO).collect(Collectors.toList());
    }

    /**
     * Obtiene una lista de destinos disponibles para actividades internas desde la base de datos.
     * 
     * @return una lista de destinos distintos disponibles para actividades internas.
     */
    public List<String> obtenerDestinosDisponiblesInternos() {
        return actividadRepository.findDistinctDestinos();
    }

    /**
     * Obtiene una actividad interna a partir de su ID.
     * 
     * @param id el ID de la actividad a consultar.
     * @return un objeto DTO de la actividad correspondiente al ID proporcionado, o null si no se encuentra.
     */
    public ActividadDTO obtenerActividadPorId(Long id) {
        return actividadRepository.findById(id)
                .map(this::convertirEntidadADTO)
                .orElse(null);
    }

    /**
     * Convierte una entidad Actividad a un DTO (Data Transfer Object) para su posterior uso.
     * 
     * @param actividad la entidad Actividad a convertir.
     * @return el DTO correspondiente de la actividad.
     */
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
