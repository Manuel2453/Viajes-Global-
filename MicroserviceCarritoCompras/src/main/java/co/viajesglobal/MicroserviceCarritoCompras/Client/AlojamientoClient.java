package co.viajesglobal.MicroserviceCarritoCompras.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.viajesglobal.MicroserviceCarritoCompras.DTO.AlojamientoDTO;



@FeignClient(name = "alojamiento-service", url = "http://localhost:8083/api/alojamientos")
public interface AlojamientoClient {
    @GetMapping("/{id}")
    AlojamientoDTO obtenerAlojamientoPorId(@PathVariable("id") Long id);
}
