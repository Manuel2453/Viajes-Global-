package co.viajesglobal.MicroservicePagos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.viajesglobal.MicroservicePagos.DTO.TarjetaDTO;
import co.viajesglobal.MicroservicePagos.Service.TarjetaService;

/**
 * Controlador que maneja las operaciones relacionadas con las tarjetas de los clientes.
 * Proporciona endpoints para listar las tarjetas guardadas por un cliente y para registrar una nueva tarjeta.
 */
@RestController
@RequestMapping("/tarjeta")
@CrossOrigin(origins = "http://localhost:4200")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaServicio;

    /**
     * Endpoint para obtener la lista de tarjetas guardadas por un cliente.
     * 
     * Este endpoint permite obtener una lista de los números o identificadores de tarjetas
     * guardadas por un cliente específico. La lista puede usarse para mostrar las tarjetas
     * en una interfaz de usuario, como una lista desplegable.
     * 
     * @param idCliente El ID del cliente cuyos registros de tarjetas se desean obtener.
     * @return Una lista de cadenas que representan las tarjetas guardadas por el cliente.
     */
    @GetMapping("/pruebalista")
    public List<String> listarTarjetas(@RequestParam int idCliente){
        // Llama al servicio para obtener las tarjetas del cliente
        List<String> resultado = tarjetaServicio.listarporCliente(idCliente);
        return resultado;
    }

    /**
     * Endpoint para registrar una nueva tarjeta para un cliente.
     * 
     * Este método permite guardar una nueva tarjeta en el sistema, utilizando los datos proporcionados
     * en el cuerpo de la solicitud. Además, permite verificar si el cliente desea guardar la tarjeta
     * para futuros pagos, según la confirmación recibida.
     * 
     * @param datos Los detalles de la tarjeta que se desea registrar, proporcionados como un objeto {@link TarjetaDTO}.
     * @param confirmacion Un valor booleano que indica si la tarjeta debe guardarse para futuros pagos (true) o no (false).
     * @return Una respuesta con el estado HTTP adecuado. Si el registro es exitoso, se devuelve un código HTTP 201 (CREATED).
     *         Si ocurre un error, se devuelve un código HTTP 500 (INTERNAL_SERVER_ERROR) con un mensaje de error.
     */
    @PostMapping("/insertarTarjeta")
    public ResponseEntity<?> crearTarjeta(@RequestBody TarjetaDTO datos, @RequestParam boolean confirmacion) {
        try {
            // Llama al servicio para registrar la tarjeta
            TarjetaDTO resultado = tarjetaServicio.crearRegistroTarjeta(datos, confirmacion);
            return new ResponseEntity<>(resultado, HttpStatus.CREATED);
        } catch(Exception e) {
            // Manejo de excepciones: si ocurre un error, se retorna un mensaje de error con el estado HTTP 500
            return new ResponseEntity<>("Ha ocurrido un error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
