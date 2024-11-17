package co.viajesglobal.MicroservicePagos.DTO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta clase representa el objeto de transferencia de datos (DTO) para el Carrito de Compras.
 * Contiene información relacionada con el carrito de compras de un usuario, como su estado, fecha de creación, total y los items agregados.
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

}
