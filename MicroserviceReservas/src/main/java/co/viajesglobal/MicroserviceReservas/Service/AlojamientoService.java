package co.viajesglobal.MicroserviceReservas.Service;

import co.viajesglobal.MicroserviceReservas.Client.AlojamientoClient;
import co.viajesglobal.MicroserviceReservas.DTO.AlojamientoDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Alojamiento;
import co.viajesglobal.MicroserviceReservas.Repository.AlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlojamientoService {

    @Autowired
    private AlojamientoClient alojamientoClient;

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    // Método para buscar alojamientos en otro microservicio usando Feign
    public List<AlojamientoDTO> buscarAlojamientosExternos(String ciudad, Date fechaEntrada, Date fechaSalida) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaEntradaStr = sdf.format(fechaEntrada);
        String fechaSalidaStr = sdf.format(fechaSalida);
        return alojamientoClient.buscarAlojamientos(ciudad, fechaEntradaStr, fechaSalidaStr);
    }
    // Método para buscar alojamientos en la base de datos interna
    public List<Alojamiento> buscarAlojamientosInternos(String ciudad, Date fechaEntrada, Date fechaSalida) {
        return alojamientoRepository.findByCiudadAndFechaEntradaLessThanEqualAndFechaSalidaGreaterThanEqual(
                ciudad, fechaEntrada, fechaSalida);
    }
    
    public AlojamientoDTO obtenerAlojamientoPorId(Long id) {
        return alojamientoRepository.findById(id)
                .map(this::convertirEntidadADTO)
                .orElse(null);
    }


    public List<String> obtenerCiudadesDisponiblesInternas() {
        return alojamientoRepository.findAll()
                .stream()
                .map(Alojamiento::getCiudad)
                .distinct()
                .collect(Collectors.toList());
    }

    private AlojamientoDTO convertirEntidadADTO(Alojamiento alojamiento) {
        AlojamientoDTO dto = new AlojamientoDTO();
        dto.setId(alojamiento.getId());
        dto.setCiudad(alojamiento.getCiudad());
        dto.setNombreHotel(alojamiento.getNombreHotel());
        dto.setFechaEntrada(alojamiento.getFechaEntrada());
        dto.setFechaSalida(alojamiento.getFechaSalida());
        dto.setPrecioNoche(alojamiento.getPrecioNoche());
        return dto;
    }
}
