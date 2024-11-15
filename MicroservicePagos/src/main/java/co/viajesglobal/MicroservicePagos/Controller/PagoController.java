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

@RestController
@RequestMapping("/pago")
@CrossOrigin(origins = "http://localhost:4200")
public class PagoController {
	@Autowired
	private PagoService pagoServicio;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarCompras(@RequestParam int idCliente ) {
		try {
			List<PagoDTO>respuestapagoServicio = pagoServicio.listarCompras(idCliente);
			return new ResponseEntity<>(respuestapagoServicio, HttpStatus.FOUND);

			
		}catch(Exception e) {
			return new ResponseEntity<>("No has realizado ninguna compra", HttpStatus.NO_CONTENT);
			
		}
	}
	@PostMapping("/generarCompra")
	public ResponseEntity<?> crearCompra(@RequestParam int idCliente, @RequestParam double total, @RequestParam int idCarrito) {
	    try {
	        System.out.println("idCliente: " + idCliente);
	        System.out.println("total: " + total);
	        System.out.println("idCarrito: " + idCarrito);

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