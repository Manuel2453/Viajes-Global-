package co.viajesglobal.MicroserviceCarritoCompras.Client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.viajesglobal.MicroserviceCarritoCompras.DTO.TrasladoDTO;

/**
 * Interface que define los métodos para consumir el servicio externo de traslados.
 * Utiliza Feign Client para realizar llamadas HTTP a un servicio de traslados.
 */

@FeignClient(name = "traslado-service", url = "http://localhost:8083/api/traslados")
public interface TrasladoClient {
    /**
     * Obtiene la información de un traslado mediante su ID.
     * 
     * Este método realiza una petición GET al servicio externo de traslados utilizando el
     * ID del traslado como parámetro en la URL. Devuelve un objeto de tipo {@link TrasladoDTO}.
     * 
     * @param id El ID del traslado que se desea obtener.
     * @return {@link TrasladoDTO} El objeto que contiene la información del traslado solicitado.
     */
    @GetMapping("/{id}")
    TrasladoDTO obtenerTrasladoPorId(@PathVariable("id") Long id);
}