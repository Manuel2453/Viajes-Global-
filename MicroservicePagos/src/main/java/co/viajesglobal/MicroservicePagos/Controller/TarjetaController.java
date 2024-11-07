package co.viajesglobal.MicroservicePagos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class TarjetaController {
	
	/*
	 Valentina, necesito que en el frontend, porfa, en el formulario hagas que la fecha se pida Mes/Año, en tipo String
	 para que pruebes es con esto en postman:
	 {
    "numero_Tarjeta":"11111111111111111",
    "nomtitular":"Pepito",
    "Id_Cliente": 1,
    "cvv":123,
    "fechaVencimiento":"12/24"
    }
    la verdad, no sé pq no reconoce el pinche cliente, llevo rato tratando y na y me mamé
	*/
	
	@Autowired
	private TarjetaService tarjetaServicio;
	
	// Lo que quiero hacer con esto es que aparezca una lista desplegable para poder mostrar las tarjetas guardadas por un cliente
	@GetMapping("/pruebalista")
	public List<String> listarTarjetas(@RequestParam int idCliente){
		List<String> resultado = tarjetaServicio.listarporCliente(idCliente);
		return resultado;
		
	}
	
	// Imagina que desde el carrito le dan a pagar, entonces aparece un resumen y un espacio para ingresar los datos de la tarjeta, 
	// entonces sería chevere que deje guardar la tarjeta con un checkbox o que con la lista de arriba, se llene los campos automáticamente
	// luego que ahí si pase a generar el pago(eso casi que se hace solo)
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
