package co.viajesglobal.MicroserviceCarritoCompras.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.viajesglobal.MicroserviceCarritoCompras.DTO.*;

@FeignClient(name = "actividad-service", url = "http://localhost:8083/api/actividades/disponibles")
public interface ActividadClient {
    @GetMapping("/{id}")
    ActividadDTO obtenerActividadPorId(@PathVariable("id") Long id);
}


