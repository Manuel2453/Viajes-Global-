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

/**
 * Controlador que maneja las operaciones relacionadas con los traslados.
 * Exponen servicios REST para consultar traslados disponibles y ciudades.
 */
@RestController
@RequestMapping("/traslados")
@CrossOrigin(origins = "http://localhost:4200") // Permite las solicitudes desde el origen especificado
public class TrasladoController {

    @Autowired
    private TrasladoService trasladoService; // Inyección del servicio para la lógica de negocios de traslados

    /**
     * Endpoint para obtener todos los traslados registrados.
     * 
     * @return Una lista de traslados en formato DTO.
     */
    @GetMapping
    public ResponseEntity<List<TrasladoDTO>> obtenerTodos() {
        // Imprime en consola para debug
        System.out.println("Obteniendo todos los traslados");
        // Retorna todos los traslados disponibles en el sistema.
        return ResponseEntity.ok(trasladoService.obtenerTrasladosInternos());
    }

    /**
     * Endpoint para buscar traslados disponibles según la ciudad, fecha, hora y tipo de consulta.
     * 
     * @param ciudad Ciudad de destino del traslado.
     * @param fecha Fecha en la que se solicita el traslado.
     * @param hora Hora en la que se solicita el traslado.
     * @param tipoConsulta Tipo de consulta para la búsqueda de traslados (por ejemplo, disponibles, todos, etc.).
     * @return Lista de traslados disponibles para la fecha y hora especificadas.
     */
    @GetMapping("/disponibles")
    public ResponseEntity<List<TrasladoDTO>> buscarTrasladosDisponibles(
        @RequestParam(name = "ciudad") String ciudad,
        @RequestParam(name = "fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
        @RequestParam(name = "hora") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime hora,
        @RequestParam(name = "tipoConsulta") String tipoConsulta) {

        // Imprime en consola para debug
        System.out.println("Buscando traslados disponibles");
        // Llama al servicio para obtener los traslados disponibles según los parámetros.
        List<TrasladoDTO> trasladosDisponibles = trasladoService.buscarTrasladosInternos(ciudad, fecha, hora, tipoConsulta);
        // Devuelve los traslados encontrados como respuesta.
        return ResponseEntity.ok(trasladosDisponibles);
    }

    /**
     * Endpoint para obtener una lista de las ciudades disponibles para traslados.
     * 
     * @return Lista de ciudades donde se ofrecen traslados.
     */
    @GetMapping("/ciudades-disponibles")
    public ResponseEntity<List<String>> obtenerCiudadesDisponibles() {
        // Imprime en consola para debug
        System.out.println("Obteniendo ciudades disponibles");
        // Llama al servicio para obtener las ciudades disponibles.
        List<String> ciudadesDisponibles = trasladoService.obtenerCiudadesDisponiblesInternas();
        // Devuelve la lista de ciudades como respuesta.
        return ResponseEntity.ok(ciudadesDisponibles);
    }

    /**
     * Endpoint para obtener un traslado por su ID único.
     * 
     * @param id Identificador único del traslado.
     * @return Traslado correspondiente al ID proporcionado o un error 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TrasladoDTO> obtenerTrasladoPorId(@PathVariable("id") Long id) {
        // Llama al servicio para obtener el traslado por ID.
        TrasladoDTO traslado = trasladoService.obtenerTrasladoPorId(id);
        if (traslado != null) {
            // Si el traslado existe, devuelve la respuesta con los datos del traslado.
            return ResponseEntity.ok(traslado);
        } else {
            // Si el traslado no existe, devuelve un error 404.
            return ResponseEntity.notFound().build();
        }
    }
}
