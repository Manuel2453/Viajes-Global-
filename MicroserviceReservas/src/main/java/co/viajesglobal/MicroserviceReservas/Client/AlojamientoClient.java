package co.viajesglobal.MicroserviceReservas.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

import co.viajesglobal.MicroserviceReservas.DTO.AlojamientoDTO;

@FeignClient(name = "alojamiento-service", url = "http://localhost:8083/api/alojamientos")
public interface AlojamientoClient {

    @GetMapping("/disponibles")
    List<AlojamientoDTO> buscarAlojamientos(
            @RequestParam("ciudad") String ciudad,
            @RequestParam("fechaEntrada") String fechaEntrada,
            @RequestParam("fechaSalida") String fechaSalida
    );
}
