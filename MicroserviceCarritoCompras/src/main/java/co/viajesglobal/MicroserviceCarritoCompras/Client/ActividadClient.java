package co.viajesglobal.MicroserviceCarritoCompras.Client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.viajesglobal.MicroserviceCarritoCompras.DTO.*;


@FeignClient(name = "actividad-service", url = "http://localhost:8083/api/actividades")
public interface ActividadClient {
    @GetMapping("/disponibles")
    List<ActividadDTO> obtenerActividadesPorDestinoYFecha(
        @RequestParam("destino") String destino,
        @RequestParam("fecha") String fecha
    );

    @GetMapping("/{id}")
    ActividadDTO obtenerActividadPorId(@PathVariable("id") Long id);
}


