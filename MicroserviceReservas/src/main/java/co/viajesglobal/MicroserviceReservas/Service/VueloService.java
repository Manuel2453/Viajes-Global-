package co.viajesglobal.MicroserviceReservas.Service;

import co.viajesglobal.MicroserviceReservas.Client.VuelosClient;
import co.viajesglobal.MicroserviceReservas.DTO.VueloDTO;
import co.viajesglobal.MicroserviceReservas.Entity.Vuelo;
import co.viajesglobal.MicroserviceReservas.Repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VueloService {

    @Autowired
    private VuelosClient vueloClient;

    @Autowired
    private VueloRepository vueloRepository;

    public List<VueloDTO> buscarVuelosExternos(String origen, String destino, LocalDate fechaSalida) {
        return vueloClient.buscarVuelos(origen, destino, fechaSalida);
    }

    // Método para buscar vuelos solo de ida
    public List<Vuelo> buscarVueloIda(String origen, String destino, LocalDate fechaSalidaInicio, LocalDate fechaSalidaFin) {
        return vueloRepository.findByOrigenAndDestinoAndFechaSalidaBetween(origen, destino, fechaSalidaInicio.atStartOfDay(), fechaSalidaFin.atTime(23, 59));
    }

    // Método para buscar vuelos de ida y vuelta
    public List<Vuelo> buscarVueloIdaYVuelta(String origen, String destino, LocalDate fechaSalida, LocalDate fechaLlegada) {
        List<Vuelo> vuelosIda = vueloRepository.findByOrigenAndDestinoAndFechaSalidaBetween(origen, destino, fechaSalida.atStartOfDay(), fechaSalida.atTime(23, 59));
        List<Vuelo> vuelosRegreso = vueloRepository.findByOrigenAndDestinoAndFechaSalidaBetween(destino, origen, fechaLlegada.atStartOfDay(), fechaLlegada.atTime(23, 59));

        return Stream.concat(vuelosIda.stream(), vuelosRegreso.stream()).collect(Collectors.toList());
    }

    public List<String> obtenerCiudadesUnicasInternas() {
        List<String> origenes = vueloRepository.findDistinctOrigen();
        List<String> destinos = vueloRepository.findDistinctDestino();
        return origenes.stream().distinct().collect(Collectors.toList());
    }
    
    public VueloDTO obtenerVueloPorId(Long id) {
        return vueloRepository.findById(id)
                .map(this::convertirEntidadADTO)
                .orElse(null);
    }

    private VueloDTO convertirEntidadADTO(Vuelo vuelo) {
        VueloDTO dto = new VueloDTO();
        dto.setIdVuelo(vuelo.getIdVuelo());
        dto.setOrigen(vuelo.getOrigen());
        dto.setDestino(vuelo.getDestino());

        // Convierte LocalDateTime a Date
        dto.setFechaSalida(Timestamp.valueOf(vuelo.getFechaSalida()));
        dto.setFechaRegreso(Timestamp.valueOf(vuelo.getFechaLlegada()));

        dto.setAerolinea(vuelo.getAerolinea());
        dto.setPrecio(vuelo.getPrecio());
        dto.setDuracion(vuelo.getDuracion());  // Asegúrate de que `duracion` exista en la entidad
        dto.setStockTurista(vuelo.getStockTurista());  // Asegúrate de que `stockTurista` exista en la entidad
        dto.setStockBuisness(vuelo.getStockBusiness());  // Asegúrate de que `stockBuisness` exista en la entidad

        return dto;
    }
}
