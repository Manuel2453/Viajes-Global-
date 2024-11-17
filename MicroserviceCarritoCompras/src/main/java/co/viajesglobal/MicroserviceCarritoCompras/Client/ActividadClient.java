package co.viajesglobal.MicroserviceCarritoCompras.Client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.viajesglobal.MicroserviceCarritoCompras.DTO.*;

/**
 * Cliente Feign para interactuar con el servicio de actividades.
 * Este cliente permite obtener información sobre actividades disponibles
 * y consultar detalles de una actividad específica.
 */

@FeignClient(name = "actividad-service", url = "http://localhost:8083/api/actividades")
public interface ActividadClient {
	  /**
     * Obtiene una lista de actividades disponibles para un destino y fecha específicos.
     *
     * @param destino El destino para el cual se desean buscar actividades.
     * @param fecha   La fecha en formato "yyyy-MM-dd" para filtrar actividades disponibles.
     * @return Una lista de objetos {@link ActividadDTO} con las actividades disponibles.
     */
    
    @GetMapping("/disponibles")
    List<ActividadDTO> obtenerActividadesPorDestinoYFecha(
        @RequestParam("destino") String destino,
        @RequestParam("fecha") String fecha
    );

    @GetMapping("/{id}")
    ActividadDTO obtenerActividadPorId(@PathVariable("id") Long id);
}


