package co.viajesglobal.MicroserviceResevas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.viajesglobal.MicroserviceReservas.DTO.PaqueteReservaDTO;
import co.viajesglobal.MicroserviceResevas.Service.PaqueteReservaService;

import java.util.Optional;

@RestController
@RequestMapping("/reservas/paquete")
public class PaqueteReservaController {

    @Autowired
    private PaqueteReservaService paqueteReservaService;

    @PostMapping("/crear")
    public ResponseEntity<PaqueteReservaDTO> crearPaqueteReserva(@RequestParam Long idVuelo, @RequestParam Long idHotel, @RequestParam Long idCliente) {
        PaqueteReservaDTO paqueteReservaDTO = paqueteReservaService.crearPaqueteReserva(idVuelo, idHotel, idCliente);
        if (paqueteReservaDTO != null) {
            return ResponseEntity.ok(paqueteReservaDTO);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaqueteReservaDTO> obtenerPaquetePorId(@PathVariable Long id) {
        Optional<PaqueteReservaDTO> paqueteReservaDTO = paqueteReservaService.obtenerPaquetePorId(id);
        if (paqueteReservaDTO.isPresent()) {
            return ResponseEntity.ok(paqueteReservaDTO.get());
        }
        return ResponseEntity.notFound().build();
    }
}
