package co.viajesglobal.MicroserviceCarritoCompras.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceCarritoCompras.Client.*;
import co.viajesglobal.MicroserviceCarritoCompras.DTO.*;

/**
 * Servicio encargado de obtener los detalles de los diferentes tipos de ítems
 * que pueden estar en un carrito de compras.
 */
@Service
public class DetalleItemService {

    // Cliente para interactuar con el microservicio de vuelos
    @Autowired
    private VuelosClient vuelosClient;

    // Cliente para interactuar con el microservicio de alojamiento
    @Autowired
    private AlojamientoClient alojamientoClient;

    // Cliente para interactuar con el microservicio de actividades
    @Autowired
    private ActividadClient actividadClient;

    // Cliente para interactuar con el microservicio de traslados
    @Autowired
    private TrasladoClient trasladoClient;

    /**
     * Obtiene los detalles de un vuelo a partir del ID proporcionado.
     * 
     * @param idVuelo El ID del vuelo.
     * @return Detalles del vuelo en formato {@link VueloDTO}.
     */
    public VueloDTO obtenerDetalleVuelo(Long idVuelo) {
        // Llama al cliente de vuelos para obtener el detalle
        return vuelosClient.obtenerVueloPorId(idVuelo);
    }

    /**
     * Obtiene los detalles de un alojamiento a partir del ID proporcionado.
     * 
     * @param idAlojamiento El ID del alojamiento.
     * @return Detalles del alojamiento en formato {@link AlojamientoDTO}.
     */
    public AlojamientoDTO obtenerDetalleAlojamiento(Long idAlojamiento) {
        // Llama al cliente de alojamiento para obtener el detalle
        return alojamientoClient.obtenerAlojamientoPorId(idAlojamiento);
    }

    /**
     * Método comentado debido a que el servicio de actividades no está implementado
     * actualmente. En su momento, este método obtendría los detalles de una actividad
     * a partir del ID de referencia.
     * 
     * @param idReferencia El ID de referencia de la actividad.
     * @return Detalles de la actividad en formato {@link ActividadDTO}.
     */
    // public ActividadDTO obtenerDetalleActividad(Long idReferencia) {
    //     if (idReferencia == null) {
    //         throw new IllegalArgumentException("El ID de referencia no puede ser nulo.");
    //     }
    //     return actividadClient.obtenerActividadPorId(idReferencia);
    // }

    /**
     * Obtiene los detalles de un traslado a partir del ID proporcionado.
     * 
     * @param idTraslado El ID del traslado.
     * @return Detalles del traslado en formato {@link TrasladoDTO}.
     */
    public TrasladoDTO obtenerDetalleTraslado(Long idTraslado) {
        // Llama al cliente de traslados para obtener el detalle
        return trasladoClient.obtenerTrasladoPorId(idTraslado);
    }
}
