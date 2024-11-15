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

@RestController
@RequestMapping("/descuentos")
@CrossOrigin(origins = "http://localhost:4200") // Permitir peticiones desde el frontend
public class DescuentoController {

    private final DescuentoService descuentoService;

    public DescuentoController(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    // Obtener todos los descuentos
    @GetMapping
    public List<Descuento> obtenerDescuentos() {
        return descuentoService.obtenerTodosLosDescuentos();
    }

    // Validar un cupón por su código
    @GetMapping("/{cupon}")
    public Optional<Descuento> validarCupon(@PathVariable String cupon) {
        return descuentoService.validarCupon(cupon);
    }
}
