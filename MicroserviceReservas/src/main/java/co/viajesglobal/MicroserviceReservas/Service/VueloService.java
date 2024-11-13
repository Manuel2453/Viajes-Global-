package co.viajesglobal.MicroserviceReservas.Service;

import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceReservas.Entity.Vuelo;
import co.viajesglobal.MicroserviceReservas.Repository.VueloRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    // Método para buscar vuelos de solo ida
    public List<Vuelo> buscarVueloIda(String origen, String destino, LocalDate fechaSalidaInicio, LocalDate fechaSalidaFin) {
        return vueloRepository.findByOrigenAndDestinoAndFechaSalidaBetween(origen, destino, fechaSalidaInicio.atStartOfDay(), fechaSalidaFin.atStartOfDay());
    }

    // Método para buscar vuelos de ida y vuelta
    public List<Vuelo> buscarVueloIdaYVuelta(String origen, String destino, LocalDate fechaSalida, LocalDate fechaLlegada) {
        List<Vuelo> vuelosIda = vueloRepository.findByOrigenAndDestinoAndFechaSalidaBetween(origen, destino, fechaSalida.atStartOfDay(), fechaSalida.atTime(23, 59));
        List<Vuelo> vuelosRegreso = vueloRepository.findByOrigenAndDestinoAndFechaSalidaBetween(destino, origen, fechaLlegada.atStartOfDay(), fechaLlegada.atTime(23, 59));

        vuelosIda.addAll(vuelosRegreso); // Agrega los vuelos de regreso a la lista
        return vuelosIda;
    }


    // Método para obtener una lista de ciudades de origen y destino únicas
    public List<String> obtenerCiudadesUnicas() {
        List<String> origenes = vueloRepository.findDistinctOrigen();
        List<String> destinos = vueloRepository.findDistinctDestino();
        
        // Combina ambas listas (orígenes y destinos) y elimina duplicados
        return Stream.concat(origenes.stream(), destinos.stream())
                     .distinct()
                     .collect(Collectors.toList());
    }
}

