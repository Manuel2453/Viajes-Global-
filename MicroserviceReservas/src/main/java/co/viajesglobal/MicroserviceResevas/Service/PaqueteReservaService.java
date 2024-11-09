package co.viajesglobal.MicroserviceResevas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceReservas.DTO.PaqueteReservaDTO;
import co.viajesglobal.MicroserviceResevas.Entity.HotelReserva;
import co.viajesglobal.MicroserviceResevas.Entity.PaqueteReserva;
import co.viajesglobal.MicroserviceResevas.Entity.VueloReserva;
import co.viajesglobal.MicroserviceResevas.Repository.HotelReservaRepository;
import co.viajesglobal.MicroserviceResevas.Repository.PaqueteReservaRepository;
import co.viajesglobal.MicroserviceResevas.Repository.VueloReservaRepository;

import java.util.Optional;

@Service
public class PaqueteReservaService {

    @Autowired
    private PaqueteReservaRepository paqueteReservaRepository;

    @Autowired
    private HotelReservaRepository hotelReservaRepository;

    @Autowired
    private VueloReservaRepository vueloReservaRepository;

    // Método para crear un paquete de reserva
    public PaqueteReservaDTO crearPaqueteReserva(Long idVuelo, Long idHotel, Long idCliente) {
        Optional<VueloReserva> vueloReservaEntity = vueloReservaRepository.findById(idVuelo);
        Optional<HotelReserva> hotelReservaEntity = hotelReservaRepository.findById(idHotel);

        if (vueloReservaEntity.isPresent() && hotelReservaEntity.isPresent()) {
            double precioVuelo = vueloReservaEntity.get().getPrecioTotal();
            double precioHotel = hotelReservaEntity.get().getPrecioPorNoche() * hotelReservaEntity.get().getNumeroNoches();
            double precioTotal = precioVuelo + precioHotel;

            PaqueteReserva paqueteReservaEntity = new PaqueteReserva();
            paqueteReservaEntity.setIdVuelo(idVuelo);
            paqueteReservaEntity.setIdHotel(idHotel);
            paqueteReservaEntity.setIdCliente(idCliente);
            paqueteReservaEntity.setPrecioVuelo(precioVuelo);
            paqueteReservaEntity.setPrecioHotel(precioHotel);
            paqueteReservaEntity.setPrecioTotal(precioTotal);

            // Guardar el paquete de reserva en la base de datos
            paqueteReservaRepository.save(paqueteReservaEntity);

            // Convertir la entidad a DTO
            PaqueteReservaDTO paqueteReservaDTO = new PaqueteReservaDTO();
            paqueteReservaDTO.setIdPaquete(paqueteReservaEntity.getIdPaquete());
            paqueteReservaDTO.setIdVuelo(idVuelo);
            paqueteReservaDTO.setIdHotel(idHotel);
            paqueteReservaDTO.setIdCliente(idCliente);
            paqueteReservaDTO.setPrecioVuelo(precioVuelo);
            paqueteReservaDTO.setPrecioHotel(precioHotel);
            paqueteReservaDTO.setPrecioTotal(precioTotal);

            return paqueteReservaDTO;
        }

        return null;  // Si no se encuentra el vuelo o el hotel, devuelve null
    }

    // Método para obtener un paquete por su id
    public Optional<PaqueteReservaDTO> obtenerPaquetePorId(Long idPaquete) {
        Optional<PaqueteReserva> paqueteReservaEntity = paqueteReservaRepository.findById(idPaquete);
        if (paqueteReservaEntity.isPresent()) {
            PaqueteReserva entity = paqueteReservaEntity.get();
            PaqueteReservaDTO dto = new PaqueteReservaDTO();
            dto.setIdPaquete(entity.getIdPaquete());
            dto.setIdVuelo(entity.getIdVuelo());
            dto.setIdHotel(entity.getIdHotel());
            dto.setIdCliente(entity.getIdCliente());
            dto.setPrecioVuelo(entity.getPrecioVuelo());
            dto.setPrecioHotel(entity.getPrecioHotel());
            dto.setPrecioTotal(entity.getPrecioTotal());
            return Optional.of(dto);
        }
        return Optional.empty();
    }
}
