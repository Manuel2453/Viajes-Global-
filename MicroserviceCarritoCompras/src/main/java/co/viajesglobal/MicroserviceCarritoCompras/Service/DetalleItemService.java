package co.viajesglobal.MicroserviceCarritoCompras.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceCarritoCompras.Client.*;
import co.viajesglobal.MicroserviceCarritoCompras.DTO.*;

@Service
public class DetalleItemService {

    @Autowired
    private VuelosClient vuelosClient;

    @Autowired
    private AlojamientoClient alojamientoClient;

    @Autowired
    private ActividadClient actividadClient;

    @Autowired
    private TrasladoClient trasladoClient;

    public VueloDTO obtenerDetalleVuelo(Long idVuelo) {
        return vuelosClient.obtenerVueloPorId(idVuelo);
    }

    public AlojamientoDTO obtenerDetalleAlojamiento(Long idAlojamiento) {
        return alojamientoClient.obtenerAlojamientoPorId(idAlojamiento);
    }

    public ActividadDTO obtenerDetalleActividad(Long idActividad) {
        return actividadClient.obtenerActividadPorId(idActividad);
    }

    public TrasladoDTO obtenerDetalleTraslado(Long idTraslado) {
        return trasladoClient.obtenerTrasladoPorId(idTraslado);
    }
}
