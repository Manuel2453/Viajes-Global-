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

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private Item_CarritoRepository itemCarritoRepository;

    @Autowired
    private DetalleItemService detalleItemService;

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

    public List<CarritoDTO> obtenerCarritosActivos(Long idUsuario) {
        List<Carrito> carritos = carritoRepository.findAllByIdUsuarioAndEstado(idUsuario, EstadoCarrito.Activo);
        return carritos.stream()
                .map(this::convertirACarritoDTO)
                .collect(Collectors.toList());
    }

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
