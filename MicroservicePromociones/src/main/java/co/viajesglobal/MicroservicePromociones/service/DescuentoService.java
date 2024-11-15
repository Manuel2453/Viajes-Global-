package co.viajesglobal.MicroservicePromociones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.viajesglobal.MicroservicePromociones.Entity.Descuento;
import co.viajesglobal.MicroservicePromociones.Repository.DescuentoRepository;


@Service
public class DescuentoService {

    private final DescuentoRepository descuentoRepository;

    public DescuentoService(DescuentoRepository descuentoRepository) {
        this.descuentoRepository = descuentoRepository;
    }

    // Obtener todos los descuentos
    public List<Descuento> obtenerTodosLosDescuentos() {
        return descuentoRepository.findAll();
    }

    // Validar un cupón
    public Optional<Descuento> validarCupon(String cupon) {
        return descuentoRepository.findByCupon(cupon);
    }
}
