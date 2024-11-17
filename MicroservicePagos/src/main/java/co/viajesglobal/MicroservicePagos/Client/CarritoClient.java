package co.viajesglobal.MicroservicePagos.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.viajesglobal.MicroservicePagos.DTO.CarritoDTO;

/**
 * Cliente Feign utilizado para realizar peticiones al microservicio de carrito de compras.
 * Este cliente se comunica con el microservicio Carrito para obtener la información del carrito completo.
 */
@FeignClient(name = "microservicio-carrito", url = "http://localhost:8082/api/carrito")
public interface CarritoClient {

    /**
     * Obtiene un carrito de compras completo utilizando su ID.
     * Realiza una solicitud GET al microservicio Carrito para obtener los detalles completos de un carrito.
     * 
     * @param idCarrito El ID del carrito de compras que se desea obtener.
     * @return El carrito de compras completo en formato {@link CarritoDTO}.
     */
    @GetMapping("/{idCarrito}/completo")
    CarritoDTO obtenerCarrito(@PathVariable("idCarrito") int idCarrito);
}
