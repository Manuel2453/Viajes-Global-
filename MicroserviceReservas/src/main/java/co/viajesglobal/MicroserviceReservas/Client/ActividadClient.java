package co.viajesglobal.MicroserviceReservas.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

import co.viajesglobal.MicroserviceReservas.DTO.ActividadDTO;

@FeignClient(name = "actividad-service", url = "http://localhost:8083/api/actividades")
public interface ActividadClient {

    @GetMapping("/disponibles")
    List<ActividadDTO> obtenerActividadesPorDestinoYFecha(
            @RequestParam("destino") String destino,
            @RequestParam("fecha") String fecha  // Cambia a String
    );
}


