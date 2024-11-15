package co.viajesglobal.MicroserviceReservas.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import co.viajesglobal.MicroserviceReservas.DTO.TrasladoDTO;

@FeignClient(name = "traslado-service", url = "http://localhost:8083/api/traslados")
public interface TrasladoClient {

	 @GetMapping("/disponibles")
	    List<TrasladoDTO> buscarTrasladosDisponibles(
	            @RequestParam("ciudad") String ciudad,
	            @RequestParam("fecha") LocalDate fecha,
	            @RequestParam("hora") LocalTime hora,
	            @RequestParam("tipoConsulta") String tipoConsulta
	    );
}