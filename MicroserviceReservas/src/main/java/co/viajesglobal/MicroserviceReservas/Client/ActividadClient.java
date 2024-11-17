package co.viajesglobal.MicroserviceReservas.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.viajesglobal.MicroserviceReservas.DTO.ActividadDTO;

import java.util.List;

/**
 * Cliente Feign para interactuar con el servicio de actividades.
 * 
 * Esta interfaz define los métodos que permiten al microservicio de reservas comunicarse 
 * con el microservicio de actividades utilizando la tecnología Feign. Feign es un cliente HTTP 
 * declarativo que facilita las llamadas a servicios RESTful mediante la anotación `@FeignClient`.
 * 
 * El cliente utiliza los endpoints del servicio `actividad-service` para obtener información sobre 
 * actividades disponibles según el destino y la fecha, y también para obtener detalles de una 
 * actividad específica a través de su ID.
 * 
 * @see ActividadDTO
 */
@FeignClient(name = "actividad-service", url = "http://localhost:8083/api/actividades")
public interface ActividadClient {

    /**
     * Obtiene una lista de actividades disponibles para un destino y una fecha específica.
     * 
     * Este método consulta el servicio de actividades para obtener todas las actividades disponibles
     * en un destino específico para una fecha dada. La información es recuperada mediante los parámetros
     * de destino y fecha, ambos pasados como parámetros en la solicitud HTTP.
     * 
     * @param destino El destino para el cual se buscan actividades.
     * @param fecha La fecha en la que se desean realizar las actividades.
     * @return Una lista de objetos `ActividadDTO` que contienen la información de las actividades disponibles.
     */
    @GetMapping("/disponibles")
    List<ActividadDTO> obtenerActividadesPorDestinoYFecha(
        @RequestParam("destino") String destino,
        @RequestParam("fecha") String fecha
    );

    /**
     * Obtiene los detalles de una actividad específica mediante su ID.
     * 
     * Este método consulta el servicio de actividades para obtener información detallada sobre
     * una actividad en particular usando su identificador único.
     * 
     * @param id El ID de la actividad a obtener.
     * @return Un objeto `ActividadDTO` con los detalles de la actividad solicitada.
     */
    @GetMapping("/{id}")
    ActividadDTO obtenerActividadPorId(@PathVariable("id") Long id);
}
