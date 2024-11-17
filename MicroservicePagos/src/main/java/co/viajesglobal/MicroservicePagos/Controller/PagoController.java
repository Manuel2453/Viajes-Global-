package co.viajesglobal.MicroservicePagos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.viajesglobal.MicroservicePagos.DTO.PagoDTO;
import co.viajesglobal.MicroservicePagos.Service.PagoService;

/**
 * Controlador que maneja las operaciones relacionadas con los pagos.
 * Proporciona endpoints para listar compras realizadas por un cliente y para generar un nuevo pago.
 */
@RestController
@RequestMapping("/pago")
@CrossOrigin(origins = "http://localhost:4200")
public class PagoController {

    @Autowired
    private PagoService pagoServicio;

    /**
     * Endpoint para listar todas las compras realizadas por un cliente específico.
     * 
     * @param idCliente El ID del cliente cuyos pagos se desean obtener.
     * @return Una lista de objetos {@link PagoDTO} que representan las compras realizadas por el cliente.
     *         Si el cliente no tiene compras, se retorna un código HTTP 204 (No Content).
     */
    @GetMapping("/listar")
    public ResponseEntity<?> listarCompras(@RequestParam int idCliente ) {
        try {
            List<PagoDTO> respuestapagoServicio = pagoServicio.listarCompras(idCliente);
            return new ResponseEntity<>(respuestapagoServicio, HttpStatus.FOUND);
        } catch(Exception e) {
            return new ResponseEntity<>("No has realizado ninguna compra", HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Endpoint para generar una compra (pago) a partir de los detalles proporcionados.
     * 
     * @param idCliente El ID del cliente que está realizando la compra.
     * @param total El total de la compra que está siendo procesada.
     * @param idCarrito El ID del carrito asociado a la compra.
     * @return Una respuesta con el estado HTTP adecuado y un mensaje indicando si el pago fue exitoso
     *         o si ocurrió un error.
     */
    @PostMapping("/generarCompra")
    public ResponseEntity<?> crearCompra(@RequestParam int idCliente, @RequestParam double total, @RequestParam int idCarrito) {
        try {
            // Impresión para depuración
            System.out.println("idCliente: " + idCliente);
            System.out.println("total: " + total);
            System.out.println("idCarrito: " + idCarrito);

            // Llamada al servicio para crear el pago
            PagoDTO pago = pagoServicio.crearCompra(idCliente, total, idCarrito);  
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Pago realizado exitosamente. ID del Pago: " + pago.getIdPago());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al realizar el pago: " + e.getMessage());
        }
    }
}
