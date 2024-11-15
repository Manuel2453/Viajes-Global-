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

@RestController
@RequestMapping("/tarjeta")
@CrossOrigin(origins = "http://localhost:4200")
public class TarjetaController {
	
	
	@Autowired
	private TarjetaService tarjetaServicio;
	
	// Lo que quiero hacer con esto es que aparezca una lista desplegable para poder mostrar las tarjetas guardadas por un cliente
	@GetMapping("/pruebalista")
	public List<String> listarTarjetas(@RequestParam int idCliente){
		List<String> resultado = tarjetaServicio.listarporCliente(idCliente);
		return resultado;
		
	}
	
	@PostMapping("/insertarTarjeta")
	public ResponseEntity<?> crearTarjeta(@RequestBody TarjetaDTO datos, @RequestParam boolean confirmacion ) {// lo que quiero hacer con confirmación es si a partir de un boton 
																					// o un checkbox, se guarde la tarjeta
	try {
		TarjetaDTO resultado = tarjetaServicio.crearRegistroTarjeta(datos, confirmacion);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
		
	}catch(Exception e){
		return new ResponseEntity<>("Ha ocurrido un error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
