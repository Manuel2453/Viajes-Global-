package co.viajesglobal.MicroserviceResevas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceReservas.DTO.HotelReservaDTO;
import co.viajesglobal.MicroserviceResevas.Entity.HotelReserva;
import co.viajesglobal.MicroserviceResevas.Repository.HotelReservaRepository;

import java.util.Optional;

@Service
public class HotelReservaService {

    @Autowired
    private HotelReservaRepository hotelReservaRepository;

    // Método para crear una reserva de hotel
    public HotelReservaDTO crearReserva(HotelReservaDTO hotelReservaDTO) {
        // Convertir DTO a entidad
        HotelReserva hotelReserva = new HotelReserva();
        hotelReserva.setIdReserva(hotelReservaDTO.getIdReserva());
        hotelReserva.setIdHotel(hotelReservaDTO.getIdHotel());
        hotelReserva.setIdCliente(hotelReservaDTO.getIdCliente());
        hotelReserva.setFechaIngreso(hotelReservaDTO.getFechaIngreso());
        hotelReserva.setFechaSalida(hotelReservaDTO.getFechaSalida());
        hotelReserva.setNumeroNoches(hotelReservaDTO.getNumeroNoches());
        hotelReserva.setPrecioPorNoche(hotelReservaDTO.getPrecioPorNoche());

        // Calcular el precio total
        hotelReserva.calcularPrecioTotal();

        // Guardar la entidad en la base de datos
        HotelReserva reservaGuardada = hotelReservaRepository.save(hotelReserva);

        // Convertir la entidad de vuelta a DTO para devolverla
        hotelReservaDTO.setPrecioTotal(reservaGuardada.getPrecioTotal());
        return hotelReservaDTO;
    }

    // Método para obtener una reserva por ID
    public Optional<HotelReservaDTO> obtenerReserva(Long idReserva) {
        Optional<HotelReserva> reserva = hotelReservaRepository.findById(idReserva);

        if (reserva.isPresent()) {
            HotelReservaDTO hotelReservaDTO = new HotelReservaDTO();
            hotelReservaDTO.setIdReserva(reserva.get().getIdReserva());
            hotelReservaDTO.setIdHotel(reserva.get().getIdHotel());
            hotelReservaDTO.setIdCliente(reserva.get().getIdCliente());
            hotelReservaDTO.setFechaIngreso(reserva.get().getFechaIngreso());
            hotelReservaDTO.setFechaSalida(reserva.get().getFechaSalida());
            hotelReservaDTO.setNumeroNoches(reserva.get().getNumeroNoches());
            hotelReservaDTO.setPrecioPorNoche(reserva.get().getPrecioPorNoche());
            hotelReservaDTO.setPrecioTotal(reserva.get().getPrecioTotal());

            return Optional.of(hotelReservaDTO);
        }
        return Optional.empty();
    }
}

