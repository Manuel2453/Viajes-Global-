package co.viajesglobal.MicroserviceResevas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceReservas.DTO.VueloReservaDTO;
import co.viajesglobal.MicroserviceResevas.Entity.VueloReserva;
import co.viajesglobal.MicroserviceResevas.Repository.VueloReservaRepository;

import java.util.Optional;

@Service
public class VueloReservaService {

    @Autowired
    private VueloReservaRepository vueloReservaRepository;

    // Método para crear una reserva de vuelo
    public VueloReservaDTO crearReserva(VueloReservaDTO vueloReservaDTO) {
        // Convertir DTO a entidad
        VueloReserva vueloReserva = new VueloReserva();
        vueloReserva.setIdReserva(vueloReservaDTO.getIdReserva());
        vueloReserva.setIdVuelo(vueloReservaDTO.getIdVuelo());
        vueloReserva.setIdCliente(vueloReservaDTO.getIdCliente());
        vueloReserva.setFechaSalida(vueloReservaDTO.getFechaSalida());
        vueloReserva.setFechaRegreso(vueloReservaDTO.getFechaRegreso());
        vueloReserva.setPrecioPorVuelo(vueloReservaDTO.getPrecioPorVuelo());

        // Calcular el precio total
        vueloReserva.calcularPrecioTotal();

        // Guardar la entidad en la base de datos
        VueloReserva reservaGuardada = vueloReservaRepository.save(vueloReserva);

        // Convertir la entidad de vuelta a DTO para devolverla
        vueloReservaDTO.setPrecioTotal(reservaGuardada.getPrecioTotal());
        return vueloReservaDTO;
    }

    // Método para obtener una reserva por ID
    public Optional<VueloReservaDTO> obtenerReserva(Long idReserva) {
        Optional<VueloReserva> reserva = vueloReservaRepository.findById(idReserva);

        if (reserva.isPresent()) {
            VueloReservaDTO vueloReservaDTO = new VueloReservaDTO();
            vueloReservaDTO.setIdReserva(reserva.get().getIdReserva());
            vueloReservaDTO.setIdVuelo(reserva.get().getIdVuelo());
            vueloReservaDTO.setIdCliente(reserva.get().getIdCliente());
            vueloReservaDTO.setFechaSalida(reserva.get().getFechaSalida());
            vueloReservaDTO.setFechaRegreso(reserva.get().getFechaRegreso());
            vueloReservaDTO.setPrecioPorVuelo(reserva.get().getPrecioPorVuelo());
            vueloReservaDTO.setPrecioTotal(reserva.get().getPrecioTotal());

            return Optional.of(vueloReservaDTO);
        }
        return Optional.empty();
    }
}
