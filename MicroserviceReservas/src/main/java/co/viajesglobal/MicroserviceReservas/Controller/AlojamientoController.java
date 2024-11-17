package co.viajesglobal.MicroserviceReservas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.viajesglobal.MicroserviceReservas.DTO.AlojamientoDTO;
import co.viajesglobal.MicroserviceReservas.DTO.HabitacionDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Alojamiento;
import co.viajesglobal.MicroserviceReservas.Service.AlojamientoService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para gestionar los alojamientos relacionados con las reservas de viajes.
 * 
 * Este controlador maneja las solicitudes HTTP para consultar los alojamientos disponibles, 
 * obtener detalles de un alojamiento por ID y obtener las ciudades con alojamientos disponibles.
 * Utiliza el servicio `AlojamientoService` para acceder a la lógica de negocio relacionada con los alojamientos.
 * 
 * @see AlojamientoService
 */
@RestController
@RequestMapping("/alojamientos")
@CrossOrigin(origins = "http://localhost:4200")  // Permite solicitudes desde el frontend en localhost:4200
public class AlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;  // Servicio que gestiona los alojamientos

    /**
     * Busca los alojamientos disponibles en una ciudad para un rango de fechas específico.
     * 
     * Este método maneja las solicitudes GET al endpoint `/alojamientos`, donde se proporcionan 
     * los parámetros `ciudad`, `fechaEntrada` y `fechaSalida`. El controlador obtiene los alojamientos 
     * disponibles que cumplen con esos criterios y los convierte en objetos `AlojamientoDTO`.
     * 
     * @param ciudad El nombre de la ciudad en la que se busca alojamiento.
     * @param fechaEntrada La fecha de entrada al alojamiento.
     * @param fechaSalida La fecha de salida del alojamiento.
     * @return Lista de `AlojamientoDTO` que representan los alojamientos disponibles.
     */
    @GetMapping
    public List<AlojamientoDTO> buscarAlojamientos(
            @RequestParam(name = "ciudad") String ciudad,  // Parámetro de ciudad
            @RequestParam(name = "fechaEntrada") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaEntrada,  // Parámetro de fecha de entrada
            @RequestParam(name = "fechaSalida") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaSalida) {  // Parámetro de fecha de salida

        List<Alojamiento> alojamientos = alojamientoService.buscarAlojamientosInternos(ciudad, fechaEntrada, fechaSalida);  // Llama al servicio para obtener los alojamientos
        return alojamientos.stream().map(this::convertirAlojamientoADTO).collect(Collectors.toList());  // Convierte cada alojamiento en DTO
    }

    /**
     * Convierte un objeto `Alojamiento` a un `AlojamientoDTO`.
     * 
     * Este método privado es responsable de convertir un objeto `Alojamiento` en un objeto DTO, 
     * transformando las propiedades de la entidad a las propiedades de la transferencia de datos, 
     * para su posterior envío al cliente en formato JSON.
     * 
     * @param alojamiento El objeto `Alojamiento` que se desea convertir.
     * @return Un objeto `AlojamientoDTO` con los datos del alojamiento.
     */
    private AlojamientoDTO convertirAlojamientoADTO(Alojamiento alojamiento) {
        AlojamientoDTO dto = new AlojamientoDTO();  // Crea un nuevo DTO de alojamiento
        dto.setId(alojamiento.getId());
        dto.setCiudad(alojamiento.getCiudad());
        dto.setNombreHotel(alojamiento.getNombreHotel());
        dto.setEstrellas(alojamiento.getEstrellas());
        dto.setDireccion(alojamiento.getDireccion());
        dto.setCantidadHabitaciones(alojamiento.getCantidadHabitaciones());
        dto.setCantidadPersonasMax(alojamiento.getCantidadPersonasMax());
        dto.setFechaEntrada(alojamiento.getFechaEntrada());
        dto.setFechaSalida(alojamiento.getFechaSalida());
        dto.setDescripcion(alojamiento.getDescripcion());
        dto.setPrecioNoche(alojamiento.getPrecioNoche());
        dto.setFotos(alojamiento.getFotos().stream().map(f -> f.getUrlFoto()).collect(Collectors.toList()));  // Convierte fotos a lista de URLs
        dto.setServicios(alojamiento.getServicios().stream().map(s -> s.getServicio()).collect(Collectors.toList()));  // Convierte servicios a lista
        dto.setHabitaciones(alojamiento.getHabitaciones().stream().map(h -> {
            HabitacionDTO habitacionDTO = new HabitacionDTO();  // Crea un DTO para cada habitación
            habitacionDTO.setTipoHabitacion(h.getTipoHabitacion());
            habitacionDTO.setCantidadCamas(h.getCantidadCamas());
            habitacionDTO.setCapacidadPersonas(h.getCapacidadPersonas());
            return habitacionDTO;
        }).collect(Collectors.toList()));  // Convierte habitaciones a una lista de DTOs
        return dto;
    }

    /**
     * Obtiene las ciudades disponibles para alojamientos.
     * 
     * Este método maneja las solicitudes GET al endpoint `/alojamientos/ciudades-disponibles`, 
     * devolviendo una lista de ciudades en las que hay alojamientos disponibles.
     * 
     * @return Lista de nombres de ciudades con alojamientos disponibles.
     */
    @GetMapping("/ciudades-disponibles")
    public List<String> obtenerCiudadesDisponibles() {
        return alojamientoService.obtenerCiudadesDisponiblesInternas();  // Llama al servicio para obtener las ciudades disponibles
    }

    /**
     * Obtiene los detalles de un alojamiento específico por su ID.
     * 
     * Este método maneja las solicitudes GET al endpoint `/alojamientos/{id}`, donde el parámetro `id` 
     * es el identificador del alojamiento que se desea consultar. Si el alojamiento existe, devuelve sus detalles;
     * de lo contrario, devuelve una respuesta con el código HTTP 404 Not Found.
     * 
     * @param id El ID del alojamiento que se quiere consultar.
     * @return Respuesta HTTP con el detalle del alojamiento o un código 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AlojamientoDTO> obtenerAlojamientoPorId(@PathVariable("id") Long id) {
        AlojamientoDTO alojamiento = alojamientoService.obtenerAlojamientoPorId(id);  // Llama al servicio para obtener el alojamiento por ID
        return alojamiento != null ? ResponseEntity.ok(alojamiento) : ResponseEntity.notFound().build();  // Devuelve el alojamiento si existe, o un 404 si no
    }
}
