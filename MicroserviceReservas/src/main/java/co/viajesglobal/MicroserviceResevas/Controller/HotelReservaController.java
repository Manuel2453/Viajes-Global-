package co.viajesglobal.MicroserviceResevas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.viajesglobal.MicroserviceReservas.DTO.HotelReservaDTO;
import co.viajesglobal.MicroserviceResevas.Service.HotelReservaService;

import java.util.Optional;

@RestController
@RequestMapping("/api/hoteles")
public class HotelReservaController {

    @Autowired
    private HotelReservaService hotelReservaService;

    // Crear una nueva reserva de hotel
    @PostMapping("/reservar")
    public ResponseEntity<HotelReservaDTO> reservarHotel(@RequestBody HotelReservaDTO hotelReservaDTO) {
        try {
            HotelReservaDTO reservaCreada = hotelReservaService.crearReserva(hotelReservaDTO);
            return new ResponseEntity<>(reservaCreada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Obtener una reserva de hotel por ID
    @GetMapping("/reservas/{idReserva}")
    public ResponseEntity<HotelReservaDTO> obtenerReserva(@PathVariable Long idReserva) {
        Optional<HotelReservaDTO> reserva = hotelReservaService.obtenerReserva(idReserva);

        if (reserva.isPresent()) {
            return new ResponseEntity<>(reserva.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
