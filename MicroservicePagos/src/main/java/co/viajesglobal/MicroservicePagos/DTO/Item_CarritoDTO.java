package co.viajesglobal.MicroservicePagos.DTO;

import java.math.BigDecimal;

/**
 * Esta clase representa el objeto de transferencia de datos (DTO) para los items en el carrito de compras.
 * Contiene la información sobre cada item (producto) agregado al carrito, como el precio, cantidad, tipo, y detalles específicos del item.
 */
public class Item_CarritoDTO {
    private Integer idItem;
    private Integer idCarrito;
    private String tipoItem;
    private Integer idReferencia;
    private BigDecimal precio;
    private Integer cantidad;
    private Object detalle;

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
