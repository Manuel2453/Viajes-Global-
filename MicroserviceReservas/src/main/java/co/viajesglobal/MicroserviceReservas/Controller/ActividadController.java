package co.viajesglobal.MicroserviceReservas.Controller;

import co.viajesglobal.MicroserviceReservas.DTO.ActividadDTO;
import co.viajesglobal.MicroserviceReservas.Service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping
    public ResponseEntity<List<ActividadDTO>> obtenerTodasActividades() {
        System.out.println("Obteniendo todas las actividades");
        List<ActividadDTO> actividades = actividadService.obtenerTodasActividades();
        return ResponseEntity.ok(actividades);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<ActividadDTO>> obtenerActividadesPorDestinoYFecha(
            @RequestParam(name = "destino") String destino,
            @RequestParam(name = "fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        List<ActividadDTO> actividades = actividadService.obtenerActividadesInternas(destino, fecha);
        actividades.forEach(a -> System.out.println("Actividad enviada: " + a.getId()));
        return ResponseEntity.ok(actividades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadDTO> obtenerActividadPorId(@PathVariable("id") Long id) {
        System.out.println("ID recibido en el controlador: " + id);
        ActividadDTO actividad = actividadService.obtenerActividadPorId(id);
        if (actividad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actividad);
    }


    @GetMapping("/destinos-disponibles")
    public ResponseEntity<List<String>> obtenerDestinosDisponibles() {
        List<String> destinosDisponibles = actividadService.obtenerDestinosDisponiblesInternos();
        return ResponseEntity.ok(destinosDisponibles);
    }
}
