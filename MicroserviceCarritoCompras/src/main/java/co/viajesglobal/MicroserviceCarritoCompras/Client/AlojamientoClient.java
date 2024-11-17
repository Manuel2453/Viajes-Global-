package co.viajesglobal.MicroserviceCarritoCompras.Client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.viajesglobal.MicroserviceCarritoCompras.DTO.AlojamientoDTO;

/**
 * Cliente Feign para interactuar con el servicio de alojamientos.
 * Este cliente permite consumir los endpoints del microservicio de alojamientos.
 */

@FeignClient(name = "alojamiento-service", url = "http://localhost:8083/api/alojamientos")
public interface AlojamientoClient {
	/**
     * Obtiene los detalles de un alojamiento por su ID.
     * 
     * @param id el identificador único del alojamiento.
     * @return un objeto {@link AlojamientoDTO} que contiene la información del alojamiento.
     */
    @GetMapping("/{id}")
    AlojamientoDTO obtenerAlojamientoPorId(@PathVariable("id") Long id);
}
