package co.viajesglobal.MicroserviceReservas.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.viajesglobal.MicroserviceReservas.DTO.VueloDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Vuelo;
import co.viajesglobal.MicroserviceReservas.Service.VueloService;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador que maneja las operaciones relacionadas con los vuelos.
 * Exponen servicios REST para consultar vuelos disponibles y obtener detalles específicos de vuelos.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes desde el origen especificado
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService vueloService; // Inyección del servicio para la lógica de negocios de vuelos

    /**
     * Constructor del controlador que recibe el servicio de vuelos.
     * 
     * @param vueloService Servicio que contiene la lógica de negocio para los vuelos.
     */
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    /**
     * Endpoint para buscar vuelos disponibles según los parámetros proporcionados.
     * 
     * @param origen Ciudad de origen del vuelo.
     * @param destino Ciudad de destino del vuelo.
     * @param fechaSalida Fecha de salida del vuelo.
     * @param fechaVuelta Fecha de regreso (opcional para vuelos de ida y vuelta).
     * @param personas Número de personas que realizarán el vuelo.
     * @param clase Clase de viaje (por ejemplo, económica, ejecutiva).
     * @param tipoVuelo Tipo de vuelo (ida, ida-vuelta).
     * @return Una lista de vuelos disponibles que coinciden con los parámetros.
     */
    @GetMapping
    public List<Vuelo> buscarVuelos(
            @RequestParam(name = "origen") String origen,
            @RequestParam(name = "destino") String destino,
            @RequestParam(name = "fechaSalida") String fechaSalida,
            @RequestParam(name = "fechaVuelta", required = false) String fechaVuelta,
            @RequestParam(name = "personas") int personas,
            @RequestParam(name = "clase") String clase,
            @RequestParam(name = "tipoVuelo") String tipoVuelo
    ) {
        // Convierte las fechas de salida y vuelta de String a LocalDate.
        LocalDate salida = LocalDate.parse(fechaSalida);
        LocalDate vuelta = fechaVuelta != null && !fechaVuelta.isEmpty() ? LocalDate.parse(fechaVuelta) : null;

        // Si el tipo de vuelo es "ida-vuelta", busca vuelos de ida y vuelta. Si no, busca solo el vuelo de ida.
        if ("ida-vuelta".equals(tipoVuelo) && vuelta != null) {
            return vueloService.buscarVueloIdaYVuelta(origen, destino, salida, vuelta);
        } else {
            return vueloService.buscarVueloIda(origen, destino, salida, salida.plusDays(1));
        }
    }

    /**
     * Endpoint para obtener la lista de aeropuertos disponibles.
     * 
     * @return Una lista de nombres de aeropuertos disponibles.
     */
    @GetMapping("/aeropuertos")
    public List<String> obtenerAeropuertos() {
        // Llama al servicio para obtener la lista de aeropuertos únicos disponibles.
        return vueloService.obtenerCiudadesUnicasInternas();
    }

    /**
     * Endpoint para obtener detalles de un vuelo por su ID.
     * 
     * @param id El identificador único del vuelo.
     * @return El vuelo correspondiente al ID proporcionado o un error 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<VueloDTO> obtenerVueloPorId(@PathVariable("id") Long id) {
        // Llama al servicio para obtener el vuelo por su ID.
        VueloDTO vuelo = vueloService.obtenerVueloPorId(id);
        // Si el vuelo existe, devuelve una respuesta con el detalle del vuelo. Si no, devuelve un error 404.
        return vuelo != null ? ResponseEntity.ok(vuelo) : ResponseEntity.notFound().build();
    }
}
