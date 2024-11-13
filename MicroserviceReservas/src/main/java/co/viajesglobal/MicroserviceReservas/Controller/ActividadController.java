package co.viajesglobal.MicroserviceReservas.Controller;

import co.viajesglobal.MicroserviceReservas.DTO.ActividadDTO;
import co.viajesglobal.MicroserviceReservas.Service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/actividades")
@CrossOrigin(origins = "http://localhost:4200")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping("/disponibles")
    public ResponseEntity<List<ActividadDTO>> obtenerActividadesPorDestinoYFecha(
            @RequestParam(name = "destino") String destino,
            @RequestParam(name = "fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        System.out.println("Buscando actividades disponibles");
        List<ActividadDTO> actividades = actividadService.obtenerActividadesPorDestinoYFecha(destino, fecha);
        return ResponseEntity.ok(actividades);
    }


    @GetMapping("/destinos-disponibles")
    public ResponseEntity<List<String>> obtenerDestinosDisponibles() {
        List<String> destinosDisponibles = actividadService.obtenerDestinosDisponibles();
        return ResponseEntity.ok(destinosDisponibles);
    }
}