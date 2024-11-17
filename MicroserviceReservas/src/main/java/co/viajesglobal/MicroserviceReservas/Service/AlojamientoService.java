package co.viajesglobal.MicroserviceReservas.Service;

import co.viajesglobal.MicroserviceReservas.Client.AlojamientoClient;
import co.viajesglobal.MicroserviceReservas.DTO.AlojamientoDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Alojamiento;
import co.viajesglobal.MicroserviceReservas.Repository.AlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio encargado de gestionar las operaciones relacionadas con los alojamientos.
 * Este servicio permite interactuar con microservicios externos y con la base de datos interna
 * para obtener información sobre alojamientos disponibles en distintas ciudades.
 */
@Service
public class AlojamientoService {

    @Autowired
    private AlojamientoClient alojamientoClient;

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    /**
     * Busca alojamientos externos mediante un cliente Feign.
     * 
     * @param ciudad la ciudad donde se desea buscar el alojamiento.
     * @param fechaEntrada la fecha de entrada del alojamiento.
     * @param fechaSalida la fecha de salida del alojamiento.
     * @return una lista de alojamientos disponibles en la ciudad y fechas indicadas.
     */
    public List<AlojamientoDTO> buscarAlojamientosExternos(String ciudad, Date fechaEntrada, Date fechaSalida) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaEntradaStr = sdf.format(fechaEntrada);
        String fechaSalidaStr = sdf.format(fechaSalida);
        return alojamientoClient.buscarAlojamientos(ciudad, fechaEntradaStr, fechaSalidaStr);
    }

    /**
     * Busca alojamientos internos en la base de datos.
     * 
     * @param ciudad la ciudad donde se desea buscar el alojamiento.
     * @param fechaEntrada la fecha de entrada del alojamiento.
     * @param fechaSalida la fecha de salida del alojamiento.
     * @return una lista de alojamientos disponibles en la ciudad y fechas indicadas.
     */
    public List<Alojamiento> buscarAlojamientosInternos(String ciudad, Date fechaEntrada, Date fechaSalida) {
        return alojamientoRepository.findByCiudadAndFechaEntradaLessThanEqualAndFechaSalidaGreaterThanEqual(
                ciudad, fechaEntrada, fechaSalida);
    }

    /**
     * Obtiene un alojamiento específico por su ID.
     * 
     * @param id el ID del alojamiento a consultar.
     * @return el DTO del alojamiento correspondiente, o null si no existe.
     */
    public AlojamientoDTO obtenerAlojamientoPorId(Long id) {
        return alojamientoRepository.findById(id)
                .map(this::convertirEntidadADTO)
                .orElse(null);
    }

    /**
     * Obtiene una lista de todas las ciudades disponibles para alojamiento en la base de datos interna.
     * 
     * @return una lista de ciudades distintas donde se encuentran alojamientos disponibles.
     */
    public List<String> obtenerCiudadesDisponiblesInternas() {
        return alojamientoRepository.findAll()
                .stream()
                .map(Alojamiento::getCiudad)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Convierte una entidad Alojamiento a un DTO (Data Transfer Object).
     * 
     * @param alojamiento la entidad Alojamiento a convertir.
     * @return el DTO correspondiente del alojamiento.
     */
    private AlojamientoDTO convertirEntidadADTO(Alojamiento alojamiento) {
        AlojamientoDTO dto = new AlojamientoDTO();
        dto.setId(alojamiento.getId());
        dto.setCiudad(alojamiento.getCiudad());
        dto.setNombreHotel(alojamiento.getNombreHotel());
        dto.setFechaEntrada(alojamiento.getFechaEntrada());
        dto.setFechaSalida(alojamiento.getFechaSalida());
        dto.setPrecioNoche(alojamiento.getPrecioNoche());
        return dto;
    }
}
