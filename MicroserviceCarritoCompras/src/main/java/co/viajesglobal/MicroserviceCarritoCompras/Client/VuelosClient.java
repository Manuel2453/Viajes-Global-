package co.viajesglobal.MicroserviceCarritoCompras.Client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.viajesglobal.MicroserviceCarritoCompras.DTO.VueloDTO;
/**
 * Interface que define los métodos para consumir el servicio externo de vuelos.
 * Utiliza Feign Client para realizar llamadas HTTP a un servicio de vuelos.
 */
@FeignClient(name = "vuelos-service", url = "http://localhost:8083/api/vuelos")
public interface VuelosClient {   
    @GetMapping("/{id}")
    VueloDTO obtenerVueloPorId(@PathVariable("id") Long id);
}
