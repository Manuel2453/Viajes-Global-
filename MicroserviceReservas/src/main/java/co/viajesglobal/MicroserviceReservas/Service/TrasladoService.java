package co.viajesglobal.MicroserviceReservas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceReservas.Client.TrasladoClient;
import co.viajesglobal.MicroserviceReservas.DTO.TrasladoDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Traslado;
import co.viajesglobal.MicroserviceReservas.Repository.TrasladoRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio encargado de gestionar las operaciones relacionadas con los traslados.
 * Este servicio permite interactuar con microservicios externos y con la base de datos interna
 * para obtener información sobre traslados disponibles en distintas ciudades y fechas.
 */
@Service
public class TrasladoService {

    @Autowired
    private TrasladoClient trasladoClient;

    @Autowired
    private TrasladoRepository trasladoRepository;

    /**
     * Busca traslados disponibles a través de un microservicio externo usando Feign.
     * 
     * @param ciudad la ciudad donde se desea buscar el traslado.
     * @param fecha la fecha en la que se requiere el traslado.
     * @param hora la hora en la que se requiere el traslado.
     * @param tipoConsulta indica si el traslado es "Desde" o "Hasta" el aeropuerto.
     * @return una lista de traslados disponibles que cumplen con los criterios.
     */
    public List<TrasladoDTO> buscarTrasladosExternos(String ciudad, LocalDate fecha, LocalTime hora, String tipoConsulta) {
        return trasladoClient.buscarTrasladosDisponibles(ciudad, fecha, hora, tipoConsulta);
    }

    /**
     * Busca traslados disponibles en la base de datos interna.
     * Valida el tipo de consulta (si es desde o hasta el aeropuerto).
     * 
     * @param ciudad la ciudad donde se desea buscar el traslado.
     * @param fecha la fecha en la que se requiere el traslado.
     * @param hora la hora en la que se requiere el traslado.
     * @param tipoConsulta indica si el traslado es "Desde" o "Hasta" el aeropuerto.
     * @return una lista de traslados disponibles en la base de datos interna.
     * @throws IllegalArgumentException si el tipo de consulta es inválido.
     */
    public List<TrasladoDTO> buscarTrasladosInternos(String ciudad, LocalDate fecha, LocalTime hora, String tipoConsulta) {
        boolean esDesdeAeropuerto = "Desde".equalsIgnoreCase(tipoConsulta);
        boolean esHastaAeropuerto = "Hasta".equalsIgnoreCase(tipoConsulta);

        if (!esDesdeAeropuerto && !esHastaAeropuerto) {
            throw new IllegalArgumentException("Invalid airport direction.");
        }

        List<Traslado> traslados = trasladoRepository.findAvailableTraslados(ciudad, fecha, hora);
        return traslados.stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene todos los traslados disponibles en la base de datos interna.
     * 
     * @return una lista de todos los traslados disponibles.
     */
    public List<TrasladoDTO> obtenerTrasladosInternos() {
        return trasladoRepository.findAll()
                .stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene una lista de todas las ciudades disponibles para traslados en la base de datos interna.
     * 
     * @return una lista de ciudades distintas donde se encuentran traslados disponibles.
     */
    public List<String> obtenerCiudadesDisponiblesInternas() {
        return trasladoRepository.findAll()
                .stream()
                .map(Traslado::getCiudad)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un traslado específico por su ID.
     * 
     * @param id el ID del traslado a consultar.
     * @return el DTO del traslado correspondiente, o null si no existe.
     */
    public TrasladoDTO obtenerTrasladoPorId(Long id) {
        return trasladoRepository.findById(id)
                .map(this::convertirEntidadADTO)
                .orElse(null);  // Convierte la entidad a DTO si se encuentra, o retorna null
    }

    /**
     * Convierte una entidad Traslado a un DTO (Data Transfer Object).
     * 
     * @param traslado la entidad Traslado a convertir.
     * @return el DTO correspondiente del traslado.
     */
    private TrasladoDTO convertirEntidadADTO(Traslado traslado) {
        TrasladoDTO dto = new TrasladoDTO();
        dto.setId(traslado.getId());
        dto.setCiudad(traslado.getCiudad());
        dto.setTipoTransporte(traslado.getTipoTransporte());
        dto.setMaximoPersonas(traslado.getMaximoPersonas());
        dto.setDescripcion(traslado.getDescripcion());
        dto.setImagenUrl(traslado.getImagenUrl());
        dto.setHoraInicio(traslado.getHoraInicio());
        dto.setHoraFin(traslado.getHoraFin());
        dto.setFechaInicioDisponible(traslado.getFechaInicioDisponible());
        dto.setFechaFinDisponible(traslado.getFechaFinDisponible());
        dto.setDisponible(traslado.isDisponible());
        dto.setPrecio(traslado.getPrecio());
        dto.setDescripcionServicio(traslado.getDescripcionServicio());
        return dto;
    }
}
