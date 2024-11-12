package co.viajesglobal.MicroserviceReservas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import co.viajesglobal.MicroserviceReservas.DTO.AlojamientoDTO;
import co.viajesglobal.MicroserviceReservas.DTO.HabitacionDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Alojamiento;
import co.viajesglobal.MicroserviceReservas.Service.AlojamientoService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alojamientos")
@CrossOrigin(origins = "http://localhost:4200")
public class AlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;

    @GetMapping
    public List<AlojamientoDTO> buscarAlojamientos(
            @RequestParam String ciudad,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaEntrada,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaSalida) {

        List<Alojamiento> alojamientos = alojamientoService.buscarAlojamientos(ciudad, fechaEntrada, fechaSalida);
        return alojamientos.stream().map(this::convertirAlojamientoADTO).collect(Collectors.toList());
    }

    private AlojamientoDTO convertirAlojamientoADTO(Alojamiento alojamiento) {
        AlojamientoDTO dto = new AlojamientoDTO();
        dto.setId(alojamiento.getId());
        dto.setCiudad(alojamiento.getCiudad());
        dto.setNombreHotel(alojamiento.getNombreHotel());
        dto.setEstrellas(alojamiento.getEstrellas());
        dto.setDireccion(alojamiento.getDireccion());
        dto.setCantidadHabitaciones(alojamiento.getCantidadHabitaciones());
        dto.setCantidadPersonasMax(alojamiento.getCantidadPersonasMax());
        dto.setFechaEntrada(alojamiento.getFechaEntrada());
        dto.setFechaSalida(alojamiento.getFechaSalida());
        dto.setDescripcion(alojamiento.getDescripcion());
        dto.setPrecioNoche(alojamiento.getPrecioNoche());
        dto.setFotos(alojamiento.getFotos().stream().map(f -> f.getUrlFoto()).collect(Collectors.toList()));
        dto.setServicios(alojamiento.getServicios().stream().map(s -> s.getServicio()).collect(Collectors.toList()));
        dto.setHabitaciones(alojamiento.getHabitaciones().stream().map(h -> {
            HabitacionDTO habitacionDTO = new HabitacionDTO();
            habitacionDTO.setTipoHabitacion(h.getTipoHabitacion());
            habitacionDTO.setCantidadCamas(h.getCantidadCamas());
            habitacionDTO.setCapacidadPersonas(h.getCapacidadPersonas());
            return habitacionDTO;
        }).collect(Collectors.toList()));
        return dto;
    }
    
    @GetMapping("/ciudades-disponibles")
    public List<String> obtenerCiudadesDisponibles() {
        return alojamientoService.obtenerCiudadesDisponibles();
    }

}
