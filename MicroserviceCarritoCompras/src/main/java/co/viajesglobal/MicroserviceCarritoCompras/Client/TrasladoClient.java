package co.viajesglobal.MicroserviceCarritoCompras.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.viajesglobal.MicroserviceCarritoCompras.DTO.TrasladoDTO;

@FeignClient(name = "traslado-service", url = "http://localhost:8083/api/traslados")
public interface TrasladoClient {
    @GetMapping("/{id}")
    TrasladoDTO obtenerTrasladoPorId(@PathVariable("id") Long id);
}