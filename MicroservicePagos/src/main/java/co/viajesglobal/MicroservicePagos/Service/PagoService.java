package co.viajesglobal.MicroservicePagos.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;



import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.viajesglobal.MicroservicePagos.DTO.PagoDTO;
import co.viajesglobal.MicroservicePagos.Entitys.PagoEntity;
import co.viajesglobal.MicroservicePagos.Enum.Estado;
import co.viajesglobal.MicroservicePagos.Respository.PagoRepository;
import co.viajesglobal.MicroservicePagos.Utilities.MapperUtilities;

@Service
public class PagoService {

	@Autowired
	private PagoRepository pagoRepo;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


	
	public List<PagoDTO> listarCompras(int id){
		List<PagoEntity>resultado = pagoRepo
				.listarporCliente(id);
		
		return MapperUtilities.mapList(resultado, PagoDTO.class);	
	}
	
	public PagoDTO crearCompra(int idCliente, double total, int idReserva) {
		PagoEntity pago = new PagoEntity();
		pago.setId_pago(UUID.randomUUID().toString());
		pago.setId_Cliente(idCliente);
		pago.setFecha_Pago(LocalDateTime.now());
		pago.setMonto(total);
		pago.setEstado(Estado.Pendiente);
		pago.setId_Reserva(idReserva);
		pagoRepo.save(pago);
		confirmacionOrden(pago.getId_pago());
		return MapperUtilities.mapearObjetos(pago, PagoDTO.class);
		
	}
	
	@Transactional
	public PagoDTO confirmarCompra(String id) throws Exception{
		PagoEntity pago = pagoRepo.findById(id)
				.orElseThrow(() -> new Exception("Pedido no encontrado: " + id));
		pago.setEstado(Estado.Completado);
		PagoEntity pagoCompletado =  pagoRepo.save(pago);
		return MapperUtilities.mapearObjetos(pagoCompletado, PagoDTO.class);
		
	}
	
	public void confirmacionOrden(String id) {
		scheduler.schedule(()->{
			try {
				PagoDTO pagoConfirmado = confirmarCompra(id);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		},10, TimeUnit.SECONDS);
	}

}
