package co.viajesglobal.MicroservicePagos.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.viajesglobal.MicroservicePagos.DTO.CarritoDTO;


@FeignClient(name = "microservicio-carrito", url = "http://localhost:8082/api/carrito")
public interface CarritoClient {
    @GetMapping("/{idCarrito}/completo")
    CarritoDTO obtenerCarrito(@PathVariable("idCarrito") int idCarrito);
}

