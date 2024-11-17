package co.viajesglobal.MicroserviceCarritoCompras.DTO;

import java.math.BigDecimal;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import co.viajesglobal.MicroserviceCarritoCompras.Entity.Carrito;
import co.viajesglobal.MicroserviceCarritoCompras.Entity.Item_Carrito;

/**
 * DTO (Data Transfer Object) que representa un carrito de compras.
 * 
 * Esta clase contiene los detalles de un carrito, incluidos los elementos en el carrito,
 * el estado del carrito, la fecha de creación, el total y cualquier cupón aplicado.
 * Se utiliza para transferir los datos entre las capas de la aplicación.
 */

public class CarritoDTO {

    private Integer idCarrito;
    private Long idUsuario;
    private String estado;
    private Timestamp fechaCreacion;
    private BigDecimal total;
    private String cuponAplicado;
    private List<Item_CarritoDTO> items;
	public Integer getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(Integer idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getCuponAplicado() {
		return cuponAplicado;
	}
	public void setCuponAplicado(String cuponAplicado) {
		this.cuponAplicado = cuponAplicado;
	}
	public List<Item_CarritoDTO> getItems() {
		return items;
	}
	public void setItems(List<Item_CarritoDTO> items) {
		this.items = items;
	}
	
	private CarritoDTO convertirACarritoDTO(Carrito carrito) {
	    CarritoDTO carritoDTO = new CarritoDTO();
	    carritoDTO.setIdCarrito(carrito.getIdCarrito());
	    carritoDTO.setIdUsuario(carrito.getIdUsuario());
	    carritoDTO.setEstado(carrito.getEstado().name());
	    carritoDTO.setFechaCreacion(carrito.getFechaCreacion());
	    carritoDTO.setTotal(carrito.getTotal());
	    carritoDTO.setCuponAplicado(carrito.getCuponAplicado());
	    
	    List<Item_CarritoDTO> itemsDTO = carrito.getItems().stream()
	            .map(this::convertirAItemCarritoDTO)
	            .collect(Collectors.toList());
	    carritoDTO.setItems(itemsDTO);
	    
	    return carritoDTO;
	}

	private Item_CarritoDTO convertirAItemCarritoDTO(Item_Carrito item) {
	    Item_CarritoDTO itemDTO = new Item_CarritoDTO();
	    itemDTO.setIdItem(item.getIdItem());
	    itemDTO.setIdCarrito(item.getCarrito().getIdCarrito());
	    itemDTO.setTipoItem(item.getTipoItem().name());
	    itemDTO.setPrecio(item.getPrecio());
	    itemDTO.setCantidad(item.getCantidad());
	    return itemDTO;
	}

}

