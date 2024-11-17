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

/**
 * Servicio encargado de gestionar las operaciones relacionadas con los vuelos.
 * Este servicio permite interactuar con microservicios externos y con la base de datos interna
 * para obtener información sobre vuelos disponibles desde y hacia distintas ciudades.
 */
@Service
public class VueloService {

    @Autowired
    private VuelosClient vueloClient;

    @Autowired
    private VueloRepository vueloRepository;

    /**
     * Busca vuelos disponibles en un microservicio externo usando Feign.
     * 
     * @param origen la ciudad de origen del vuelo.
     * @param destino la ciudad de destino del vuelo.
     * @param fechaSalida la fecha de salida del vuelo.
     * @return una lista de vuelos disponibles que cumplen con los criterios proporcionados.
     */
    public List<VueloDTO> buscarVuelosExternos(String origen, String destino, LocalDate fechaSalida) {
        return vueloClient.buscarVuelos(origen, destino, fechaSalida);
    }

    /**
     * Busca vuelos de ida disponibles en la base de datos interna.
     * 
     * @param origen la ciudad de origen del vuelo.
     * @param destino la ciudad de destino del vuelo.
     * @param fechaSalidaInicio la fecha de salida de inicio del intervalo.
     * @param fechaSalidaFin la fecha de salida de fin del intervalo.
     * @return una lista de vuelos de ida disponibles en el intervalo de fechas.
     */
    public List<Vuelo> buscarVueloIda(String origen, String destino, LocalDate fechaSalidaInicio, LocalDate fechaSalidaFin) {
        return vueloRepository.findByOrigenAndDestinoAndFechaSalidaBetween(
                origen, 
                destino, 
                fechaSalidaInicio.atStartOfDay(), 
                fechaSalidaFin.atTime(23, 59));
    }

    /**
     * Busca vuelos de ida y vuelta disponibles en la base de datos interna.
     * 
     * @param origen la ciudad de origen del vuelo de ida.
     * @param destino la ciudad de destino del vuelo de ida.
     * @param fechaSalida la fecha de salida del vuelo de ida.
     * @param fechaLlegada la fecha de salida del vuelo de regreso.
     * @return una lista combinada de vuelos de ida y regreso disponibles.
     */
    public List<Vuelo> buscarVueloIdaYVuelta(String origen, String destino, LocalDate fechaSalida, LocalDate fechaLlegada) {
        List<Vuelo> vuelosIda = vueloRepository.findByOrigenAndDestinoAndFechaSalidaBetween(
                origen, 
                destino, 
                fechaSalida.atStartOfDay(), 
                fechaSalida.atTime(23, 59));
        List<Vuelo> vuelosRegreso = vueloRepository.findByOrigenAndDestinoAndFechaSalidaBetween(
                destino, 
                origen, 
                fechaLlegada.atStartOfDay(), 
                fechaLlegada.atTime(23, 59));

        return Stream.concat(vuelosIda.stream(), vuelosRegreso.stream()).collect(Collectors.toList());
    }

    /**
     * Obtiene una lista de todas las ciudades disponibles para vuelos en la base de datos interna,
     * combinando tanto los orígenes como los destinos.
     * 
     * @return una lista de ciudades distintas que tienen vuelos disponibles.
     */
    public List<String> obtenerCiudadesUnicasInternas() {
        List<String> origenes = vueloRepository.findDistinctOrigen();
        List<String> destinos = vueloRepository.findDistinctDestino();
        return origenes.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Obtiene un vuelo específico por su ID desde la base de datos interna.
     * 
     * @param id el ID del vuelo a consultar.
     * @return el DTO del vuelo correspondiente, o null si no existe.
     */
    public VueloDTO obtenerVueloPorId(Long id) {
        return vueloRepository.findById(id)
                .map(this::convertirEntidadADTO)
                .orElse(null);  // Convierte la entidad a DTO si se encuentra, o retorna null
    }

    /**
     * Convierte una entidad Vuelo a un DTO (Data Transfer Object) para transferencia de datos.
     * 
     * @param vuelo la entidad Vuelo a convertir.
     * @return el DTO correspondiente del vuelo.
     */
    private VueloDTO convertirEntidadADTO(Vuelo vuelo) {
        VueloDTO dto = new VueloDTO();
        dto.setIdVuelo(vuelo.getIdVuelo());
        dto.setOrigen(vuelo.getOrigen());
        dto.setDestino(vuelo.getDestino());

        // Convierte LocalDateTime a Timestamp para representarlo como Date
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
