package co.viajesglobal.MicroserviceReservas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceReservas.Client.TrasladoClient;
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
    private TrasladoClient trasladoClient;

    @Autowired
    private TrasladoRepository trasladoRepository;

    // Método para buscar traslados en otro microservicio usando Feign
    public List<TrasladoDTO> buscarTrasladosExternos(String ciudad, LocalDate fecha, LocalTime hora, String tipoConsulta) {
        return trasladoClient.buscarTrasladosDisponibles(ciudad, fecha, hora, tipoConsulta);
    }

    // Método para buscar traslados disponibles en la propia base de datos
    public List<TrasladoDTO> buscarTrasladosInternos(String ciudad, LocalDate fecha, LocalTime hora, String tipoConsulta) {
        boolean esDesdeAeropuerto = "Desde".equalsIgnoreCase(tipoConsulta);
        boolean esHastaAeropuerto = "Hasta".equalsIgnoreCase(tipoConsulta);

        if (!esDesdeAeropuerto && !esHastaAeropuerto) {
            throw new IllegalArgumentException("Invalid airport direction.");
        }

        List<Traslado> traslados = trasladoRepository.findAvailableTraslados(ciudad, fecha, hora);
        return traslados.stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    // Método para obtener todos los traslados desde la base de datos interna
    public List<TrasladoDTO> obtenerTrasladosInternos() {
        return trasladoRepository.findAll()
                .stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    // Método para obtener todas las ciudades disponibles desde la base de datos interna
    public List<String> obtenerCiudadesDisponiblesInternas() {
        return trasladoRepository.findAll()
                .stream()
                .map(Traslado::getCiudad)
                .distinct()
                .collect(Collectors.toList());
    }
    
    public TrasladoDTO obtenerTrasladoPorId(Long id) {
        return trasladoRepository.findById(id)
                .map(this::convertirEntidadADTO)
                .orElse(null);  // Convierte la entidad a DTO si se encuentra, o retorna null
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
        dto.setPrecio(traslado.getPrecio());
        dto.setDescripcionServicio(traslado.getDescripcionServicio());
        return dto;
    }
}
