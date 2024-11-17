package co.viajesglobal.MicroservicePromociones.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.viajesglobal.MicroservicePromociones.Entity.Promocion;
import co.viajesglobal.MicroservicePromociones.service.PromocionService;

/**
 * Controlador REST para gestionar las promociones en el microservicio de promociones.
 * Este controlador maneja las solicitudes HTTP relacionadas con la gestión de promociones,
 * proporcionando un endpoint para obtener todas las promociones disponibles.
 */
@RestController
@RequestMapping("/promociones")
@CrossOrigin(origins = "http://localhost:4200") 
public class PromocionController {

    // Servicio para la gestión de las promociones
    private final PromocionService promocionService;

    /**
     * Constructor para inyectar el servicio de promociones.
     * 
     * @param promocionService Servicio para gestionar las promociones.
     */
    public PromocionController(PromocionService promocionService) {
        this.promocionService = promocionService;
    }

    /**
     * Endpoint que devuelve una lista de todas las promociones disponibles.
     * 
     * Este método maneja solicitudes GET a la URL "/promociones", llamando al servicio 
     * de promociones para obtener las promociones almacenadas en el sistema.
     * 
     * @return Una lista de objetos `Promocion` que representan las promociones disponibles.
     */
    @GetMapping
    public List<Promocion> listarPromociones() {
        return promocionService.listarPromociones();
    }
}
