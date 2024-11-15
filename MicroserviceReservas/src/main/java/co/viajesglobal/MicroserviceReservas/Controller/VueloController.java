package co.viajesglobal.MicroserviceReservas.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.viajesglobal.MicroserviceReservas.DTO.VueloDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Vuelo;
import co.viajesglobal.MicroserviceReservas.Service.VueloService;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

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
        LocalDate salida = LocalDate.parse(fechaSalida);
        LocalDate vuelta = fechaVuelta != null && !fechaVuelta.isEmpty() ? LocalDate.parse(fechaVuelta) : null;

        if ("ida-vuelta".equals(tipoVuelo) && vuelta != null) {
            return vueloService.buscarVueloIdaYVuelta(origen, destino, salida, vuelta);
        } else {
            return vueloService.buscarVueloIda(origen, destino, salida, salida.plusDays(1));
        }
    }

    @GetMapping("/aeropuertos")
    public List<String> obtenerAeropuertos() {
        return vueloService.obtenerCiudadesUnicasInternas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloDTO> obtenerVueloPorId(@PathVariable("id") Long id) {
        VueloDTO vuelo = vueloService.obtenerVueloPorId(id);
        return vuelo != null ? ResponseEntity.ok(vuelo) : ResponseEntity.notFound().build();
    }
}
