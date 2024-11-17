package co.viajesglobal.MicroserviceReservas.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

import co.viajesglobal.MicroserviceReservas.DTO.VueloDTO;

/**
 * Cliente Feign para interactuar con el servicio de vuelos.
 * 
 * Esta interfaz utiliza Feign, un cliente HTTP basado en interfaces, para realizar peticiones 
 * REST a un servicio externo (en este caso, el servicio de vuelos). Feign permite realizar 
 * llamadas a servicios de una manera declarativa, lo que facilita la integración con microservicios.
 * 
 * El cliente está configurado para acceder a un servicio RESTful ubicado en la URL `http://localhost:8083/api/vuelos`.
 * Utiliza el método HTTP GET para buscar vuelos disponibles con los parámetros proporcionados.
 * 
 * @see VueloDTO
 */
@FeignClient(name = "vuelos-service", url = "http://localhost:8083/api/vuelos")
public interface VuelosClient {

    /**
     * Realiza una solicitud GET al servicio de vuelos para obtener los vuelos disponibles.
     * 
     * Este método hace uso de Feign para enviar una petición HTTP GET al endpoint `/disponibles` 
     * del servicio de vuelos. Los parámetros necesarios incluyen el origen, el destino y la fecha 
     * de salida del vuelo. El servicio devuelve una lista de objetos `VueloDTO`, que representan 
     * los vuelos disponibles que coinciden con los criterios de búsqueda.
     * 
     * @param origen Ciudad o aeropuerto de origen del vuelo.
     * @param destino Ciudad o aeropuerto de destino del vuelo.
     * @param fechaSalida Fecha de salida del vuelo.
     * 
     * @return Una lista de objetos `VueloDTO` que contienen la información de los vuelos disponibles.
     */
    @GetMapping("/disponibles")
    List<VueloDTO> buscarVuelos(
            @RequestParam("origen") String origen,
            @RequestParam("destino") String destino,
            @RequestParam("fechaSalida") LocalDate fechaSalida
    );
}
