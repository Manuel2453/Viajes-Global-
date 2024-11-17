package co.viajesglobal.MicroserviceReservas.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import co.viajesglobal.MicroserviceReservas.DTO.AlojamientoDTO;

/**
 * Cliente Feign para interactuar con el servicio de alojamiento.
 * 
 * Esta interfaz usa Feign para realizar llamadas HTTP al servicio de alojamiento. Feign es una 
 * librería que permite a los microservicios interactuar entre sí de manera sencilla mediante 
 * la anotación `@FeignClient` de Spring Cloud. Al ser un cliente Feign, esta interfaz se 
 * configura automáticamente para comunicarse con el servicio externo a través de HTTP.
 * 
 * El cliente está configurado para interactuar con el servicio que maneja la información 
 * sobre los alojamientos, específicamente con el endpoint de búsqueda de alojamientos disponibles.
 * 
 * @see AlojamientoDTO
 */
@FeignClient(name = "alojamiento-service", url = "http://localhost:8083/api/alojamientos")
public interface AlojamientoClient {

    /**
     * Realiza una llamada al servicio de alojamiento para obtener una lista de alojamientos 
     * disponibles en una ciudad específica dentro de un rango de fechas.
     * 
     * Este método se conecta al servicio de alojamiento en la URL proporcionada y le pasa 
     * parámetros de ciudad, fecha de entrada y fecha de salida. El servicio responderá con 
     * una lista de alojamientos que coinciden con los criterios proporcionados.
     * 
     * @param ciudad Ciudad donde se busca disponibilidad de alojamientos.
     * @param fechaEntrada Fecha de entrada al alojamiento (en formato String).
     * @param fechaSalida Fecha de salida del alojamiento (en formato String).
     * @return Lista de alojamientos disponibles que cumplen con los parámetros proporcionados.
     */
    @GetMapping("/disponibles")
    List<AlojamientoDTO> buscarAlojamientos(
            @RequestParam("ciudad") String ciudad,
            @RequestParam("fechaEntrada") String fechaEntrada,
            @RequestParam("fechaSalida") String fechaSalida
    );
}
