package co.viajesglobal.MicroserviceReservas.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import co.viajesglobal.MicroserviceReservas.DTO.TrasladoDTO;

/**
 * Cliente Feign para interactuar con el servicio de traslados.
 * 
 * Esta interfaz se utiliza para realizar solicitudes HTTP al microservicio `traslado-service`, 
 * específicamente a la URL proporcionada (http://localhost:8083/api/traslados), usando 
 * la tecnología OpenFeign. OpenFeign es una herramienta que facilita la invocación de servicios REST
 * a través de una interfaz Java, reduciendo la necesidad de escribir código adicional para las peticiones HTTP.
 * 
 * El cliente se configura con la anotación `@FeignClient`, que permite que el microservicio de reservas
 * consulte el servicio de traslados para obtener los traslados disponibles en una fecha y hora específicas.
 * 
 * @see TrasladoDTO
 */
@FeignClient(name = "traslado-service", url = "http://localhost:8083/api/traslados")
public interface TrasladoClient {

    /**
     * Busca los traslados disponibles en función de los parámetros proporcionados.
     * 
     * Este método realiza una solicitud HTTP GET al endpoint `/disponibles` del servicio de traslados
     * para obtener una lista de traslados disponibles. Se utiliza el objeto `TrasladoDTO` para representar
     * los traslados retornados por la API externa.
     * 
     * @param ciudad El nombre de la ciudad en la que se busca el traslado.
     * @param fecha La fecha para la cual se solicita el traslado disponible.
     * @param hora La hora exacta en la que se solicita el traslado.
     * @param tipoConsulta El tipo de consulta que se desea realizar, como "próximos", "disponibles", etc.
     * @return Una lista de objetos `TrasladoDTO` que representan los traslados disponibles para los criterios
     *         proporcionados.
     */
    @GetMapping("/disponibles")
    List<TrasladoDTO> buscarTrasladosDisponibles(
            @RequestParam("ciudad") String ciudad,
            @RequestParam("fecha") LocalDate fecha,
            @RequestParam("hora") LocalTime hora,
            @RequestParam("tipoConsulta") String tipoConsulta
    );
}
