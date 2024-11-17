package co.viajesglobal.MicroserviceCarritoCompras.DTO;

import java.math.BigDecimal;
/**
 * DTO (Data Transfer Object) que representa un artículo dentro de un carrito de compras.
 * 
 * Esta clase contiene información sobre un artículo en el carrito, como el tipo de artículo,
 * el precio, la cantidad, y detalles adicionales específicos del artículo.
 * Se utiliza para transferir los datos entre las capas de la aplicación.
 */

public class Item_CarritoDTO {
    private Integer idItem;
    private Integer idCarrito;
    private String tipoItem;
    private Integer idReferencia;
    private BigDecimal precio;
    private Integer cantidad;
    private Object detalle; // Campo para almacenar detalles específicos

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public Integer getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(Integer idReferencia) {
        this.idReferencia = idReferencia;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Object getDetalle() {
        return detalle;
    }

    public void setDetalle(Object detalle) {
        this.detalle = detalle;
    }
}
