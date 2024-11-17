package co.viajesglobal.MicroserviceCarritoCompras.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Representa un carrito de compras en la base de datos.
 * 
 * Esta entidad contiene la información relacionada con un carrito de compras, incluyendo el ID del usuario
 * propietario, el estado del carrito (Activo, Pagado, Cancelado), la fecha de creación, el total del carrito,
 * el cupon aplicado y los ítems contenidos en el carrito. El carrito está relacionado con los ítems a través de una
 * relación uno a muchos.
 * 
 * La clase está mapeada a la tabla 'Carrito' en la base de datos.
 */
@Entity
@Table(name = "Carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Carrito")
    private Integer idCarrito;

    @Column(name = "ID_Usuario", nullable = false)
    private Long idUsuario;

    /**
     * Estado del carrito. Puede ser uno de los siguientes valores:
     * - Activo: El carrito está en uso.
     * - Pagado: El carrito ha sido pagado.
     * - Cancelado: El carrito ha sido cancelado.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", columnDefinition = "ENUM('Activo', 'Pagado', 'Cancelado') DEFAULT 'Activo'")
    private Estado estado;

    @Column(name = "Fecha_Creacion", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaCreacion;

    /**
     * El total del carrito. Representa la suma total de los productos en el carrito.
     */
    @Column(name = "Total", precision = 10, scale = 2, columnDefinition = "DECIMAL(10, 2) DEFAULT 0.00")
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "Cupon_Aplicado", length = 100)
    private String cuponAplicado;

    /**
     * Relación uno a muchos con la entidad Item_Carrito.
     * Esta lista contiene los ítems dentro del carrito de compras.
     */
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item_Carrito> items;

    // Getters y Setters
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
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

    public List<Item_Carrito> getItems() {
        return items;
    }

    public void setItems(List<Item_Carrito> items) {
        this.items = items;
    }

    /**
     * Enum que define los posibles estados de un carrito.
     */
    public enum Estado {
        Activo,
        Pagado,
        Cancelado
    }
}
