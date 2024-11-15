package co.viajesglobal.MicroserviceReservas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.viajesglobal.MicroserviceReservas.DTO.TrasladoDTO;
import co.viajesglobal.MicroserviceReservas.Service.TrasladoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/traslados")
@CrossOrigin(origins = "http://localhost:4200")
public class TrasladoController {

    @Autowired
    private TrasladoService trasladoService;

    @GetMapping
    public ResponseEntity<List<TrasladoDTO>> obtenerTodos() {
        System.out.println("Obteniendo todos los traslados");
        return ResponseEntity.ok(trasladoService.obtenerTrasladosInternos());
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<TrasladoDTO>> buscarTrasladosDisponibles(
        @RequestParam(name = "ciudad") String ciudad,
        @RequestParam(name = "fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
        @RequestParam(name = "hora") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime hora,
        @RequestParam(name = "tipoConsulta") String tipoConsulta) {

        System.out.println("Buscando traslados disponibles");
        List<TrasladoDTO> trasladosDisponibles = trasladoService.buscarTrasladosInternos(ciudad, fecha, hora, tipoConsulta);
        return ResponseEntity.ok(trasladosDisponibles);
    }

    @GetMapping("/ciudades-disponibles")
    public ResponseEntity<List<String>> obtenerCiudadesDisponibles() {
        System.out.println("Obteniendo ciudades disponibles");
        List<String> ciudadesDisponibles = trasladoService.obtenerCiudadesDisponiblesInternas();
        return ResponseEntity.ok(ciudadesDisponibles);
    }

    // Nuevo endpoint para obtener un traslado por ID
    @GetMapping("/{id}")
    public ResponseEntity<TrasladoDTO> obtenerTrasladoPorId(@PathVariable("id") Long id) {
        TrasladoDTO traslado = trasladoService.obtenerTrasladoPorId(id); // Implementar lógica en el servicio
        if (traslado != null) {
            return ResponseEntity.ok(traslado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
