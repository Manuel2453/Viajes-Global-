package co.viajesglobal.MicroservicePromociones.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.viajesglobal.MicroservicePromociones.Entity.Promocion;
import co.viajesglobal.MicroservicePromociones.service.PromocionService;

@RestController
@RequestMapping("/promociones")
@CrossOrigin(origins = "http://localhost:4200") 
public class PromocionController {

    private final PromocionService promocionService;

    public PromocionController(PromocionService promocionService) {
        this.promocionService = promocionService;
    }

    @GetMapping
    public List<Promocion> listarPromociones() {
        return promocionService.listarPromociones();
    }
}
