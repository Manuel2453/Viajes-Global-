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

/**
 * Controlador REST para gestionar las actividades relacionadas con las reservas de viajes.
 * 
 * Este controlador maneja las solicitudes HTTP relacionadas con las actividades disponibles, 
 * permitiendo consultar todas las actividades, actividades por destino y fecha, detalles de una actividad 
 * por su ID, y destinos disponibles. Utiliza el servicio `ActividadService` para acceder a la lógica de negocio.
 * 
 * @see ActividadService
 */
@RestController
@RequestMapping("/actividades")
@CrossOrigin(origins = "http://localhost:4200")  // Permite solicitudes desde el frontend en localhost:4200
public class ActividadController {

    @Autowired
    private ActividadService actividadService;  // Servicio que gestiona las actividades

    /**
     * Obtiene todas las actividades disponibles.
     * 
     * Este método maneja las solicitudes GET al endpoint `/actividades`, y retorna una lista con todas 
     * las actividades disponibles en formato `ActividadDTO`.
     * 
     * @return Respuesta HTTP con una lista de `ActividadDTO` que representan todas las actividades.
     */
    @GetMapping
    public ResponseEntity<List<ActividadDTO>> obtenerTodasActividades() {
        System.out.println("Obteniendo todas las actividades");
        List<ActividadDTO> actividades = actividadService.obtenerTodasActividades();  // Llama al servicio para obtener todas las actividades
        return ResponseEntity.ok(actividades);  // Devuelve la respuesta con el código HTTP 200 OK
    }

    /**
     * Obtiene las actividades disponibles según un destino y una fecha específica.
     * 
     * Este método maneja las solicitudes GET al endpoint `/actividades/disponibles`, donde se 
     * proporcionan los parámetros `destino` y `fecha`. El controlador obtiene las actividades 
     * disponibles en ese destino para la fecha especificada.
     * 
     * @param destino El destino para el que se quieren consultar las actividades.
     * @param fecha La fecha en la que se quieren consultar las actividades disponibles.
     * @return Respuesta HTTP con una lista de `ActividadDTO` que representan las actividades disponibles.
     */
    @GetMapping("/disponibles")
    public ResponseEntity<List<ActividadDTO>> obtenerActividadesPorDestinoYFecha(
            @RequestParam(name = "destino") String destino,  // Parámetro de destino
            @RequestParam(name = "fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {  // Parámetro de fecha
        List<ActividadDTO> actividades = actividadService.obtenerActividadesInternas(destino, fecha);  // Llama al servicio para obtener las actividades según destino y fecha
        actividades.forEach(a -> System.out.println("Actividad enviada: " + a.getId()));  // Imprime los ID de las actividades enviadas
        return ResponseEntity.ok(actividades);  // Devuelve la respuesta con el código HTTP 200 OK
    }

    /**
     * Obtiene los detalles de una actividad específica por su ID.
     * 
     * Este método maneja las solicitudes GET al endpoint `/actividades/{id}`, donde el parámetro `id` 
     * es el identificador de la actividad que se quiere consultar. Si la actividad existe, devuelve sus detalles;
     * de lo contrario, devuelve una respuesta con el código HTTP 404 Not Found.
     * 
     * @param id El ID de la actividad que se quiere consultar.
     * @return Respuesta HTTP con el detalle de la actividad o un código 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ActividadDTO> obtenerActividadPorId(@PathVariable("id") Long id) {
        System.out.println("ID recibido en el controlador: " + id);  // Imprime el ID recibido
        ActividadDTO actividad = actividadService.obtenerActividadPorId(id);  // Llama al servicio para obtener la actividad por ID
        if (actividad == null) {
            return ResponseEntity.notFound().build();  // Devuelve 404 si no se encuentra la actividad
        }
        return ResponseEntity.ok(actividad);  // Devuelve la actividad encontrada con código 200 OK
    }

    /**
     * Obtiene los destinos disponibles para actividades.
     * 
     * Este método maneja las solicitudes GET al endpoint `/actividades/destinos-disponibles`, y 
     * devuelve una lista de destinos donde hay actividades disponibles.
     * 
     * @return Respuesta HTTP con una lista de destinos disponibles.
     */
    @GetMapping("/destinos-disponibles")
    public ResponseEntity<List<String>> obtenerDestinosDisponibles() {
        List<String> destinosDisponibles = actividadService.obtenerDestinosDisponiblesInternos();  // Llama al servicio para obtener los destinos disponibles
        return ResponseEntity.ok(destinosDisponibles);  // Devuelve la lista de destinos con código HTTP 200 OK
    }
}
