package co.viajesglobal.MicroserviceCarritoCompras.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entidad que representa un artículo dentro de un carrito de compras.
 * 
 * Cada instancia de la clase `Item_Carrito` representa un producto o servicio (como un vuelo, alojamiento, actividad o traslado)
 * dentro de un carrito de compras. El artículo tiene un precio, una cantidad, y está asociado a un carrito específico.
 * Además, el tipo de artículo se clasifica mediante un enum `TipoItem`, que especifica si el artículo es un vuelo, alojamiento, actividad o traslado.
 * 
 * La clase está mapeada a la tabla "Item_Carrito" en la base de datos.
 */
@Entity
@Table(name = "Item_Carrito")
public class Item_Carrito {

    /**
     * Identificador único del artículo dentro del carrito.
     * Este campo es generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Item")
    private Integer idItem;

    /**
     * Relación ManyToOne con el carrito al que pertenece este artículo.
     * Un artículo pertenece a un solo carrito.
     */
    @ManyToOne
    @JoinColumn(name = "ID_Carrito", nullable = false)
    private Carrito carrito;

    /**
     * Tipo de artículo que puede ser uno de los siguientes:
     * - Vuelo
     * - Alojamiento
     * - Actividad
     * - Traslado
     * El tipo se almacena como un enum de tipo `TipoItem`.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo_Item", columnDefinition = "ENUM('Vuelo', 'Alojamiento', 'Actividad', 'Traslado')")
    private TipoItem tipoItem;

    /**
     * Referencia única al artículo en el sistema. Puede ser el ID de un vuelo, alojamiento, actividad o traslado,
     * dependiendo del tipo de artículo.
     */
    @Column(name = "ID_Referencia")
    private Long idReferencia;

    /**
     * Precio del artículo. Se define con una precisión de 10 dígitos y 2 decimales.
     */
    @Column(name = "Precio", precision = 10, scale = 2)
    private BigDecimal precio;

    /**
     * Cantidad del artículo en el carrito. Por defecto, se asigna el valor 1.
     */
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

    public Long getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(Long idReferencia) {
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

    /**
     * Enum que representa los posibles tipos de artículos en el carrito.
     * Los tipos posibles son:
     * - Vuelo
     * - Alojamiento
     * - Actividad
     * - Traslado
     */
    public enum TipoItem {
        Vuelo,
        Alojamiento,
        Actividad,
        Traslado;

        /**
         * Convierte un String en un valor del enum `TipoItem`. 
         * La conversión asegura que el primer carácter sea mayúscula y el resto en minúsculas.
         * 
         * @param tipo El tipo de artículo como un String.
         * @return El valor correspondiente del enum `TipoItem`.
         */
        public static TipoItem fromString(String tipo) {
            return TipoItem.valueOf(tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase());
        }
    }
}
