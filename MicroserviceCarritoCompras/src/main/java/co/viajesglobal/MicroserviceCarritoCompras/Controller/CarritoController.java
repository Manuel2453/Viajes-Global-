package co.viajesglobal.MicroserviceCarritoCompras.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.viajesglobal.MicroserviceCarritoCompras.DTO.CarritoDTO;
import co.viajesglobal.MicroserviceCarritoCompras.DTO.Item_CarritoDTO;
import co.viajesglobal.MicroserviceCarritoCompras.Entity.Item_Carrito;
import co.viajesglobal.MicroserviceCarritoCompras.Entity.Item_Carrito.TipoItem;
import co.viajesglobal.MicroserviceCarritoCompras.Service.CarritoService;

import java.util.List;

@RestController
@RequestMapping("/carrito")
@CrossOrigin(origins = "http://localhost:4200")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/{idUsuario}/activos")
    public ResponseEntity<List<CarritoDTO>> obtenerCarritosActivos(@PathVariable Long idUsuario) {
        List<CarritoDTO> carritosActivos = carritoService.obtenerCarritosActivos(idUsuario);
        return ResponseEntity.ok(carritosActivos);
    }

    @GetMapping("/{idCarrito}/completo")
    public ResponseEntity<CarritoDTO> obtenerCarritoCompleto(@PathVariable Long idCarrito) {
        CarritoDTO carritoCompleto = carritoService.obtenerCarritoCompleto(idCarrito);
        return ResponseEntity.ok(carritoCompleto);
    }

    @PostMapping("/{idCarrito}/agregar")
    public ResponseEntity<Item_CarritoDTO> agregarItemAlCarrito(
            @PathVariable Long idCarrito,
            @RequestBody Item_CarritoDTO itemDTO) {
        System.out.println("Recibiendo itemDTO con idReferencia: " + itemDTO.getIdReferencia());

        Long idReferencia = itemDTO.getIdReferencia() != null ? itemDTO.getIdReferencia().longValue() : null;

        Item_Carrito item = carritoService.agregarItem(
                idCarrito,
                TipoItem.valueOf(itemDTO.getTipoItem()),
                itemDTO.getPrecio(),
                idReferencia);

        Item_CarritoDTO responseDTO = carritoService.convertirAItemCarritoDTO(item);
        return ResponseEntity.ok().body(responseDTO);
    }



}
