package co.viajesglobal.MicroservicePromociones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.viajesglobal.MicroservicePromociones.Entity.Promocion;
import co.viajesglobal.MicroservicePromociones.Repository.PromocionRepository;

@Service
public class PromocionService {

    private final PromocionRepository promocionRepository;

    public PromocionService(PromocionRepository promocionRepository) {
        this.promocionRepository = promocionRepository;
    }

    public List<Promocion> listarPromociones() {
        return promocionRepository.findAll();
    }
}