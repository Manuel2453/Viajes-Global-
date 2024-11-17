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

/**
 * Servicio que maneja la lógica de negocio relacionada con los pagos.
 * Este servicio incluye la creación, listado y confirmación de compras realizadas por los clientes.
 * También maneja la interacción con otros microservicios como el carrito de compras.
 */
@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepo; // Repositorio para acceder a los pagos en la base de datos.

    @Autowired
    private CarritoClient carritoClient; // Cliente para interactuar con el microservicio de carrito de compras.

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1); // Scheduler para tareas programadas.

    /**
     * Lista todas las compras (pagos) realizadas por un cliente.
     * 
     * @param idCliente El identificador del cliente cuyos pagos se desean listar.
     * @return Una lista de objetos PagoDTO que representan las compras realizadas por el cliente.
     */
    public List<PagoDTO> listarCompras(int idCliente) {
        // Recupera los pagos realizados por el cliente desde el repositorio y los mapea a PagoDTO.
        List<PagoEntity> resultado = pagoRepo.listarporCliente(idCliente);
        return MapperUtilities.mapList(resultado, PagoDTO.class);
    }

    /**
     * Crea una nueva compra (pago) para un cliente, verificando si el carrito está activo.
     * 
     * @param idCliente El identificador del cliente que realiza la compra.
     * @param total El monto total de la compra.
     * @param idCarrito El identificador del carrito asociado a la compra.
     * @return Un objeto PagoDTO que representa el pago creado.
     * @throws Exception Si el carrito no está activo o no existe.
     */
    public PagoDTO crearCompra(int idCliente, double total, int idCarrito) throws Exception {
        System.out.println("Iniciando creación de compra...");
        System.out.println("ID Cliente: " + idCliente);
        System.out.println("Total: " + total);
        System.out.println("ID Carrito: " + idCarrito);

        // Llama al microservicio de carrito para obtener el estado del carrito.
        CarritoDTO carrito = carritoClient.obtenerCarrito(idCarrito);
        if (carrito == null || !carrito.getEstado().equals("Activo")) {
            throw new Exception("El carrito no está activo o no existe.");
        }

        System.out.println("Carrito recibido: " + carrito);

        // Crea una nueva entidad de pago y la configura con los detalles de la compra.
        PagoEntity pago = new PagoEntity();
        pago.setIdPago(UUID.randomUUID().toString()); // Genera un ID único para el pago.
        pago.setIdCliente(idCliente);
        pago.setMonto(total);
        pago.setEstado(Estado.Pendiente); // Inicializa el estado del pago como "Pendiente".
        pago.setFechaPago(LocalDateTime.now());
        pago.setIdCarrito(idCarrito);

        // Guarda el pago en la base de datos.
        pagoRepo.save(pago);
        System.out.println("Pago guardado con éxito.");

        // Devuelve el pago como un DTO.
        return MapperUtilities.mapearObjetos(pago, PagoDTO.class);
    }

    /**
     * Confirma la compra (pago) cambiando su estado a "Completado".
     * 
     * @param id El identificador del pago que se desea confirmar.
     * @return Un objeto PagoDTO que representa el pago confirmado.
     * @throws Exception Si el pago no se encuentra en la base de datos.
     */
    @Transactional
    public PagoDTO confirmarCompra(String id) throws Exception {
        // Busca el pago por su ID y lanza una excepción si no se encuentra.
        PagoEntity pago = pagoRepo.findById(id)
                .orElseThrow(() -> new Exception("Pedido no encontrado: " + id));
        
        // Cambia el estado del pago a "Completado".
        pago.setEstado(Estado.Completado);
        PagoEntity pagoCompletado = pagoRepo.save(pago); // Guarda el pago actualizado.

        // Devuelve el pago confirmado como un DTO.
        return MapperUtilities.mapearObjetos(pagoCompletado, PagoDTO.class);
    }

    /**
     * Programa la confirmación de una orden de pago en un tiempo determinado.
     * Este método utiliza un `ScheduledExecutorService` para ejecutar la confirmación de pago después de un retraso de 10 segundos.
     * 
     * @param id El identificador del pago que se desea confirmar.
     */
    public void confirmacionOrden(String id) {
        // Programación de la confirmación del pago después de un retraso de 10 segundos.
        scheduler.schedule(() -> {
            try {
                PagoDTO pagoConfirmado = confirmarCompra(id); // Confirma el pago.
                System.out.println("Pago confirmado: " + pagoConfirmado.getIdPago());
            } catch (Exception e) {
                e.printStackTrace(); // Manejo de excepciones.
            }
        }, 10, TimeUnit.SECONDS); // 10 segundos de retraso.
    }
}
