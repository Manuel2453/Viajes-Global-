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


/**
 * Controlador REST para gestionar las operaciones relacionadas con los carritos de compras.
 * Proporciona endpoints para obtener carritos activos, obtener carritos completos y agregar elementos al carrito.
 */

@RestController
@RequestMapping("/carrito")
@CrossOrigin(origins = "http://localhost:4200")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    /**
     * Obtiene la lista de carritos activos para un usuario específico.
     * 
     * Este endpoint realiza una petición GET para obtener todos los carritos activos
     * de un usuario. Devuelve una lista de objetos {@link CarritoDTO} que representan
     * los carritos activos del usuario.
     * 
     * @param idUsuario El ID del usuario para el cual se desean obtener los carritos activos.
     * @return {@link ResponseEntity} Contiene la lista de {@link CarritoDTO} de los carritos activos del usuario.
     */
    
    @GetMapping("/{idUsuario}/activos")
    public ResponseEntity<List<CarritoDTO>> obtenerCarritosActivos(@PathVariable Long idUsuario) {
        List<CarritoDTO> carritosActivos = carritoService.obtenerCarritosActivos(idUsuario);
        return ResponseEntity.ok(carritosActivos);
    }


    /**
     * Obtiene el carrito completo por su ID.
     * 
     * Este endpoint realiza una petición GET para obtener la información completa de un carrito
     * específico utilizando su ID. Devuelve un objeto {@link CarritoDTO} que contiene la información
     * completa del carrito.
     * 
     * @param idCarrito El ID del carrito que se desea obtener.
     * @return {@link ResponseEntity} Contiene el objeto {@link CarritoDTO} del carrito solicitado.
     */
    
    @GetMapping("/{idCarrito}/completo")
    public ResponseEntity<CarritoDTO> obtenerCarritoCompleto(@PathVariable Long idCarrito) {
        CarritoDTO carritoCompleto = carritoService.obtenerCarritoCompleto(idCarrito);
        return ResponseEntity.ok(carritoCompleto);
    }

    /**
     * Agrega un nuevo ítem al carrito especificado.
     * 
     * Este endpoint realiza una petición POST para agregar un nuevo ítem a un carrito. Recibe un objeto
     * {@link Item_CarritoDTO} que contiene los detalles del ítem a agregar. El carrito al que se agregará
     * el ítem es identificado por el ID proporcionado en la URL.
     * 
     * @param idCarrito El ID del carrito al cual se desea agregar el ítem.
     * @param itemDTO El objeto {@link Item_CarritoDTO} que contiene la información del ítem a agregar.
     * @return {@link ResponseEntity} Contiene el objeto {@link Item_CarritoDTO} con los detalles del ítem agregado.
     */
    
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
