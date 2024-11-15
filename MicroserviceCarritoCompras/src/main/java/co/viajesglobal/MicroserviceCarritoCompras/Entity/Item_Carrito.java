package co.viajesglobal.MicroserviceCarritoCompras.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Item_Carrito")
public class Item_Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Item")
    private Integer idItem;

    @ManyToOne
    @JoinColumn(name = "ID_Carrito", nullable = false)
    private Carrito carrito;

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo_Item", columnDefinition = "ENUM('Vuelo', 'Alojamiento', 'Actividad', 'Traslado')")
    private TipoItem tipoItem;

    @Column(name = "ID_Referencia")
    private Long idReferencia;  // Cambiado a Long para mayor compatibilidad

    @Column(name = "Precio", precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "Cantidad", columnDefinition = "INT DEFAULT 1")
    private Integer cantidad = 1;

    // Getters y Setters
    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    public Long getIdReferencia() {  // Cambiado a Long
        return idReferencia;
    }

    public void setIdReferencia(Long idReferencia) {  // Cambiado a Long
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

    public enum TipoItem {
        Vuelo,
        Alojamiento,
        Actividad,
        Traslado;

        public static TipoItem fromString(String tipo) {
            return TipoItem.valueOf(tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase());
        }
    }
}
