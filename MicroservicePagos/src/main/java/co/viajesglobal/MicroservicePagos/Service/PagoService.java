package co.viajesglobal.MicroservicePagos.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.viajesglobal.MicroservicePagos.DTO.CarritoDTO;
import co.viajesglobal.MicroservicePagos.DTO.PagoDTO;
import co.viajesglobal.MicroservicePagos.Entitys.PagoEntity;
import co.viajesglobal.MicroservicePagos.Enum.Estado;
import co.viajesglobal.MicroservicePagos.Respository.PagoRepository;
import co.viajesglobal.MicroservicePagos.Utilities.MapperUtilities;
import co.viajesglobal.MicroservicePagos.Client.CarritoClient;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepo;

    @Autowired
    private CarritoClient carritoClient;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public List<PagoDTO> listarCompras(int idCliente) {
        List<PagoEntity> resultado = pagoRepo.listarporCliente(idCliente);
        return MapperUtilities.mapList(resultado, PagoDTO.class);
    }

    public PagoDTO crearCompra(int idCliente, double total, int idCarrito) throws Exception {
        System.out.println("Iniciando creación de compra...");
        System.out.println("ID Cliente: " + idCliente);
        System.out.println("Total: " + total);
        System.out.println("ID Carrito: " + idCarrito);

        // Llama al microservicio de carrito
        CarritoDTO carrito = carritoClient.obtenerCarrito(idCarrito);
        if (carrito == null || !carrito.getEstado().equals("Activo")) {
            throw new Exception("El carrito no está activo o no existe.");
        }

        System.out.println("Carrito recibido: " + carrito);

        PagoEntity pago = new PagoEntity();
        pago.setIdPago(UUID.randomUUID().toString());
        pago.setIdCliente(idCliente);
        pago.setMonto(total);
        pago.setEstado(Estado.Pendiente);
        pago.setFechaPago(LocalDateTime.now());
        pago.setIdCarrito(idCarrito);

        pagoRepo.save(pago);
        System.out.println("Pago guardado con éxito.");

        return MapperUtilities.mapearObjetos(pago, PagoDTO.class);
    }

    @Transactional
    public PagoDTO confirmarCompra(String id) throws Exception {
        PagoEntity pago = pagoRepo.findById(id)
                .orElseThrow(() -> new Exception("Pedido no encontrado: " + id));
        pago.setEstado(Estado.Completado);
        PagoEntity pagoCompletado = pagoRepo.save(pago);
        return MapperUtilities.mapearObjetos(pagoCompletado, PagoDTO.class);
    }

    public void confirmacionOrden(String id) {
        scheduler.schedule(() -> {
            try {
                PagoDTO pagoConfirmado = confirmarCompra(id);
                System.out.println("Pago confirmado: " + pagoConfirmado.getIdPago());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 10, TimeUnit.SECONDS);
    }
}
