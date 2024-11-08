package co.viajesglobal.MicroserviceResevas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.viajesglobal.MicroserviceReservas.DTO.VueloReservaDTO;
import co.viajesglobal.MicroserviceResevas.Service.VueloReservaService;

import java.util.Optional;

@RestController
@RequestMapping("/api/vuelos")
public class VueloReservaController {

    @Autowired
    private VueloReservaService vueloReservaService;

    // Crear una nueva reserva de vuelo
    @PostMapping("/reservar")
    public ResponseEntity<VueloReservaDTO> reservarVuelo(@RequestBody VueloReservaDTO vueloReservaDTO) {
        try {
            VueloReservaDTO reservaCreada = vueloReservaService.crearReserva(vueloReservaDTO);
            return new ResponseEntity<>(reservaCreada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Obtener una reserva de vuelo por ID
    @GetMapping("/reservas/{idReserva}")
    public ResponseEntity<VueloReservaDTO> obtenerReserva(@PathVariable Long idReserva) {
        Optional<VueloReservaDTO> reserva = vueloReservaService.obtenerReserva(idReserva);

        if (reserva.isPresent()) {
            return new ResponseEntity<>(reserva.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
