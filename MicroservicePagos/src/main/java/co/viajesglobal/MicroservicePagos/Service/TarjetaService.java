package co.viajesglobal.MicroservicePagos.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroservicePagos.DTO.TarjetaDTO;
import co.viajesglobal.MicroservicePagos.Entitys.TarjetaEntity;
import co.viajesglobal.MicroservicePagos.Respository.TarjetaRepository;
import co.viajesglobal.MicroservicePagos.Utilities.MapperUtilities;

@Service
public class TarjetaService {
	@Autowired
	private TarjetaRepository tarjetarepo;
	
	public TarjetaDTO crearRegistroTarjeta(TarjetaDTO datos, boolean confirmacion) {
		TarjetaEntity tarjeta = new TarjetaEntity();
		tarjeta.setNumTarjeta(datos.getNumero_Tarjeta());
		tarjeta.setNomtitular(datos.getNomtitular());
		tarjeta.setCvv(datos.getCvv());
		tarjeta.setFechaVencimiento(datos.getFechaVencimiento());
		
		if(!verificarFechaVencimiento(datos.getFechaVencimiento()) || !verificarTarjeta(datos.getNumero_Tarjeta())){
			return null;
		}
		if(!confirmacion) {
			return MapperUtilities.mapearObjetos(tarjeta, TarjetaDTO.class);
		}
		tarjetarepo.save(tarjeta);
		return MapperUtilities.mapearObjetos(tarjeta, TarjetaDTO.class);
		
		
	}
	



	public boolean verificarFechaVencimiento(String fechaVencimientoStr) {
	    // Verificar el formato MM/yy con regex
	    if (!fechaVencimientoStr.matches("\\d{2}/\\d{2}")) {
	        System.err.println("Formato incorrecto: debe ser MM/yy");
	        return false;
	    }
	    
	    // Extraer el mes y el año
	    int mes = Integer.parseInt(fechaVencimientoStr.substring(0, 2));
	    int año = Integer.parseInt(fechaVencimientoStr.substring(3, 5)) + 2000; // Convertimos a año completo (ej. 34 -> 2034)
	    
	    // Verificar que el mes esté en el rango correcto
	    if (mes < 1 || mes > 12) {
	        System.err.println("Mes inválido: debe estar entre 01 y 12");
	        return false;
	    }
	    
	    // Obtener el año y mes actuales
	    LocalDate fechaActual = LocalDate.now();
	    int mesActual = fechaActual.getMonthValue();
	    int añoActual = fechaActual.getYear();
	    
	    // Verificar que la fecha de vencimiento no haya pasado
	    if (año < añoActual || (año == añoActual && mes < mesActual)) {
	        System.err.println("La fecha de vencimiento ya ha pasado");
	        return false;
	    }
	    
	    return true;
	}

	
	
	public List<String> listarporCliente (int id){
		List<String> resultado = tarjetarepo.listarporCliente(id);
		return resultado;
	}
	
	public boolean verificarTarjeta (String numTarjeta) {
		if(numTarjeta.length() != 16 ) {
			System.err.println("No sé pq putas no me muestra el error en la respuesta c:");
			return false;
		}
		return true;
	}
	
	


}
