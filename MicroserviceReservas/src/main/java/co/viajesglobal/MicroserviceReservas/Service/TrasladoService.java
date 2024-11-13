package co.viajesglobal.MicroserviceReservas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceReservas.DTO.TrasladoDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Traslado;
import co.viajesglobal.MicroserviceReservas.Repository.TrasladoRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrasladoService {

    @Autowired
    private TrasladoRepository trasladoRepository;

    public List<TrasladoDTO> obtenerTraslados() {
        return trasladoRepository.findAll()
                .stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    public List<TrasladoDTO> buscarTrasladosDisponibles(
            String ciudad,
            LocalDate fecha,
            LocalTime hora,
            String tipoConsulta) {

        System.out.println("Buscar traslados disponibles: ciudad=" + ciudad + ", fecha=" + fecha + ", hora=" + hora + ", tipoConsulta=" + tipoConsulta);

        boolean esDesdeAeropuerto = "Desde".equalsIgnoreCase(tipoConsulta);
        boolean esHastaAeropuerto = "Hasta".equalsIgnoreCase(tipoConsulta);

        List<Traslado> traslados;

        if (esDesdeAeropuerto || esHastaAeropuerto) {
            traslados = trasladoRepository.findAvailableTraslados(ciudad, fecha, hora);
            System.out.println("Traslados encontrados: " + traslados.size());
        } else {
            System.out.println("Tipo de consulta inválido: " + tipoConsulta);
            throw new IllegalArgumentException("Invalid airport direction.");
        }

        return traslados.stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    public List<String> obtenerCiudadesDisponibles() {
        List<String> ciudades = trasladoRepository.findAll()
                .stream()
                .map(Traslado::getCiudad)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Ciudades disponibles: " + ciudades);
        return ciudades;
    }

    private TrasladoDTO convertirEntidadADTO(Traslado traslado) {
        TrasladoDTO dto = new TrasladoDTO();
        dto.setId(traslado.getId());
        dto.setCiudad(traslado.getCiudad());
        dto.setTipoTransporte(traslado.getTipoTransporte());
        dto.setMaximoPersonas(traslado.getMaximoPersonas());
        dto.setDescripcion(traslado.getDescripcion());
        dto.setImagenUrl(traslado.getImagenUrl());
        dto.setHoraInicio(traslado.getHoraInicio());
        dto.setHoraFin(traslado.getHoraFin());
        dto.setFechaInicioDisponible(traslado.getFechaInicioDisponible());
        dto.setFechaFinDisponible(traslado.getFechaFinDisponible());
        dto.setDisponible(traslado.isDisponible());
        dto.setPrecio(traslado.getPrecio()); // Asignación del campo precio
        dto.setDescripcionServicio(traslado.getDescripcionServicio()); // Asignación del campo descripcionServicio
        return dto;
    }
}
