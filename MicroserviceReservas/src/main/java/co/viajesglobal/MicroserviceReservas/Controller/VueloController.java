package co.viajesglobal.MicroserviceReservas.Controller;

import org.springframework.web.bind.annotation.*;

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
            @RequestParam String origen,
            @RequestParam String destino,
            @RequestParam String fechaSalida,
            @RequestParam(required = false) String fechaVuelta,
            @RequestParam int personas,
            @RequestParam String clase,
            @RequestParam String tipoVuelo
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
        return vueloService.obtenerCiudadesUnicas();
    }
}
