package co.viajesglobal.MicroserviceCarritoCompras.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.viajesglobal.MicroserviceCarritoCompras.DTO.*;
import co.viajesglobal.MicroserviceCarritoCompras.Entity.*;
import co.viajesglobal.MicroserviceCarritoCompras.Entity.Item_Carrito.TipoItem;
import co.viajesglobal.MicroserviceCarritoCompras.Repository.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio que gestiona las operaciones relacionadas con el carrito de compras,
 * incluyendo la obtención de carritos, la adición de artículos al carrito, 
 * y la conversión de entidades a objetos DTO.
 */
@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private Item_CarritoRepository itemCarritoRepository;

    @Autowired
    private DetalleItemService detalleItemService;

    /**
     * Obtiene un carrito completo con todos sus artículos y detalles asociados.
     * 
     * @param idCarrito El identificador único del carrito.
     * @return Un objeto `CarritoDTO` que contiene la información del carrito y sus artículos.
     * @throws RuntimeException Si el carrito no se encuentra.
     */
    public CarritoDTO obtenerCarritoCompleto(Long idCarrito) {
        Carrito carrito = carritoRepository.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        
        CarritoDTO carritoDTO = convertirACarritoDTO(carrito);

        carritoDTO.setItems(
            carrito.getItems().stream().map(item -> {
                Item_CarritoDTO itemDTO = convertirAItemCarritoDTO(item);
                Long idReferencia = item.getIdReferencia(); // Usar idReferencia en lugar de idItem

                switch (item.getTipoItem()) {
                    case Vuelo:
                        VueloDTO vuelo = detalleItemService.obtenerDetalleVuelo(idReferencia);
                        itemDTO.setDetalle(vuelo);
                        break;
                    case Alojamiento:
                        AlojamientoDTO alojamiento = detalleItemService.obtenerDetalleAlojamiento(idReferencia);
                        itemDTO.setDetalle(alojamiento);
                        break;
//                    case Actividad:
//                        ActividadDTO actividad = detalleItemService.obtenerDetalleActividad(idReferencia);
//                        itemDTO.setDetalle(actividad);
//                        break;
                    case Traslado:
                        TrasladoDTO traslado = detalleItemService.obtenerDetalleTraslado(idReferencia);
                        itemDTO.setDetalle(traslado);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de ítem desconocido");
                }
                return itemDTO;
            }).collect(Collectors.toList())
        );

        return carritoDTO;
    }

    /**
     * Obtiene una lista de carritos activos de un usuario.
     * 
     * @param idUsuario El identificador único del usuario.
     * @return Una lista de objetos `CarritoDTO` que representan los carritos activos del usuario.
     */
    public List<CarritoDTO> obtenerCarritosActivos(Long idUsuario) {
        List<Carrito> carritos = carritoRepository.findAllByIdUsuarioAndEstado(idUsuario, EstadoCarrito.Activo);
        return carritos.stream()
                .map(this::convertirACarritoDTO)
                .collect(Collectors.toList());
    }

    /**
     * Agrega un artículo a un carrito de compras específico.
     * 
     * @param idCarrito El identificador del carrito en el que se agregará el artículo.
     * @param tipoItem El tipo de ítem (Vuelo, Alojamiento, Traslado, etc.).
     * @param precio El precio del artículo.
     * @param idReferencia El identificador de referencia del artículo.
     * @return El objeto `Item_Carrito` creado y guardado en la base de datos.
     * @throws RuntimeException Si el carrito no se encuentra.
     */
    public Item_Carrito agregarItem(Long idCarrito, TipoItem tipoItem, BigDecimal precio, Long idReferencia) {
        Carrito carrito = carritoRepository.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        
        Item_Carrito item = new Item_Carrito();
        item.setCarrito(carrito);
        item.setTipoItem(tipoItem);
        item.setPrecio(precio);
        item.setCantidad(1);
        item.setIdReferencia(idReferencia);
        
        return itemCarritoRepository.save(item);
    }

    /**
     * Convierte un objeto `Carrito` a su correspondiente objeto DTO `CarritoDTO`.
     * 
     * @param carrito El objeto `Carrito` a convertir.
     * @return El objeto `CarritoDTO` correspondiente.
     */
    private CarritoDTO convertirACarritoDTO(Carrito carrito) {
        CarritoDTO carritoDTO = new CarritoDTO();
        carritoDTO.setIdCarrito(carrito.getIdCarrito());
        carritoDTO.setIdUsuario(carrito.getIdUsuario());
        carritoDTO.setEstado(carrito.getEstado().name());
        carritoDTO.setFechaCreacion(carrito.getFechaCreacion());
        carritoDTO.setTotal(carrito.getTotal());
        carritoDTO.setCuponAplicado(carrito.getCuponAplicado());
        carritoDTO.setItems(carrito.getItems().stream()
                .map(this::convertirAItemCarritoDTO)
                .collect(Collectors.toList())
        );
        return carritoDTO;
    }

    /**
     * Convierte un objeto `Item_Carrito` a su correspondiente objeto DTO `Item_CarritoDTO`.
     * 
     * @param item El objeto `Item_Carrito` a convertir.
     * @return El objeto `Item_CarritoDTO` correspondiente.
     */
    public Item_CarritoDTO convertirAItemCarritoDTO(Item_Carrito item) {
        Item_CarritoDTO itemDTO = new Item_CarritoDTO();
        itemDTO.setIdItem(item.getIdItem());
        itemDTO.setIdCarrito(item.getCarrito().getIdCarrito());
        itemDTO.setTipoItem(item.getTipoItem().name());
        itemDTO.setPrecio(item.getPrecio());
        itemDTO.setCantidad(item.getCantidad());
        return itemDTO;
    }
}
