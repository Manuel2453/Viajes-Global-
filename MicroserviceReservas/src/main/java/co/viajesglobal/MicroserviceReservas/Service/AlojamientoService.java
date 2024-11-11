package co.viajesglobal.MicroserviceReservas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceReservas.Entity.Alojamiento;
import co.viajesglobal.MicroserviceReservas.Repository.AlojamientoRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlojamientoService {

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    public List<Alojamiento> buscarAlojamientos(String ciudad, Date fechaEntrada, Date fechaSalida) {
        return alojamientoRepository.findByCiudadAndFechaEntradaLessThanEqualAndFechaSalidaGreaterThanEqual(
                ciudad, fechaEntrada, fechaSalida);
    }

    public List<String> obtenerCiudadesDisponibles() {
        // Obtenemos todas las ciudades sin duplicados
        return alojamientoRepository.findAll()
                .stream()
                .map(Alojamiento::getCiudad) // Suponiendo que el modelo tiene un campo ciudad
                .distinct()
                .collect(Collectors.toList());
    }
}
