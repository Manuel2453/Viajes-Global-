package co.viajesglobal.MicroserviceCarritoCompras.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Carrito")
    private Integer idCarrito;

    @Column(name = "ID_Usuario", nullable = false)
    private Long idUsuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", columnDefinition = "ENUM('Activo', 'Pagado', 'Cancelado') DEFAULT 'Activo'")
    private Estado estado; // Ahora usa el enum Estado definido dentro de la clase

    @Column(name = "Fecha_Creacion", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaCreacion;

    @Column(name = "Total", precision = 10, scale = 2, columnDefinition = "DECIMAL(10, 2) DEFAULT 0.00")
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "Cupon_Aplicado", length = 100)
    private String cuponAplicado;

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

    public enum Estado {
        Activo,
        Pagado,
        Cancelado
    }

}
