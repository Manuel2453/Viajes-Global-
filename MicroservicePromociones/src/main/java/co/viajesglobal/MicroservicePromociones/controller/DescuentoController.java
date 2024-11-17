package co.viajesglobal.MicroservicePromociones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.viajesglobal.MicroservicePromociones.Entity.Descuento;
import co.viajesglobal.MicroservicePromociones.service.DescuentoService;

/**
 * Controlador encargado de gestionar las solicitudes HTTP relacionadas con los descuentos y cupones.
 * Este controlador maneja las peticiones para obtener descuentos y validar cupones por su código.
 */
@RestController
@RequestMapping("/descuentos")
@CrossOrigin(origins = "http://localhost:4200") // Permitir peticiones desde el frontend
public class DescuentoController {

    private final DescuentoService descuentoService;

    /**
     * Constructor para inicializar el servicio de descuentos.
     * 
     * @param descuentoService El servicio de descuentos que se inyecta mediante Spring.
     */
    public DescuentoController(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    /**
     * Endpoint para obtener todos los descuentos disponibles en el sistema.
     * 
     * Este método gestiona las solicitudes GET a la ruta "/descuentos" y devuelve una lista de objetos `Descuento`.
     * 
     * @return Una lista de objetos `Descuento` con todos los descuentos disponibles.
     */
    @GetMapping
    public List<Descuento> obtenerDescuentos() {
        return descuentoService.obtenerTodosLosDescuentos();
    }

    /**
     * Endpoint para validar un cupón por su código.
     * 
     * Este método gestiona las solicitudes GET a la ruta "/descuentos/{cupon}" y valida un cupón por su código.
     * Si el cupón es válido, devuelve un objeto `Descuento`; si no, devuelve un `Optional.empty()`.
     * 
     * @param cupon El código del cupón a validar.
     * @return Un objeto `Optional<Descuento>` que puede contener el descuento asociado al cupón si es válido, o `Optional.empty()` si no se encuentra.
     */
    @GetMapping("/{cupon}")
    public Optional<Descuento> validarCupon(@PathVariable String cupon) {
        return descuentoService.validarCupon(cupon);
    }
}
