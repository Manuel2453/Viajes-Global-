package co.viajesglobal.MicroserviceReservas.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

import co.viajesglobal.MicroserviceReservas.DTO.VueloDTO;

@FeignClient(name = "vuelos-service", url = "http://localhost:8083/api/vuelos")
public interface VuelosClient {

	@GetMapping("/disponibles")
    List<VueloDTO> buscarVuelos(
            @RequestParam("origen") String origen,
            @RequestParam("destino") String destino,
            @RequestParam("fechaSalida") LocalDate fechaSalida
    );
}
