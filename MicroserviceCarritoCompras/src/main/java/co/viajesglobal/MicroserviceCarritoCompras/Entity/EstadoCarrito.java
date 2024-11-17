package co.viajesglobal.MicroserviceCarritoCompras.Entity;

/**
 * Enum que define los posibles estados de un carrito de compras.
 * 
 * Este enum permite representar los diferentes estados que un carrito de compras puede tener dentro del sistema.
 * Los estados posibles son:
 * - Activo: El carrito está activo y en uso.
 * - Pagado: El carrito ha sido pagado y ya no está disponible para modificaciones.
 * - Cancelado: El carrito ha sido cancelado y no está disponible para ser pagado o modificado.
 * 
 * Cada estado tiene un valor asociado de tipo String que representa su nombre.
 */
public enum EstadoCarrito {
    
    /**
     * El carrito está activo y en uso.
     */
    Activo("Activo"),
    
    /**
     * El carrito ha sido pagado.
     */
    Pagado("Pagado"),
    
    /**
     * El carrito ha sido cancelado.
     */
    Cancelado("Cancelado");

    // Valor asociado a cada estado.
    private final String estado;

    /**
     * Constructor del enum EstadoCarrito.
     * @param estado El valor que representa el estado del carrito.
     */
    EstadoCarrito(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el valor del estado como un String.
     * @return El nombre del estado del carrito.
     */
    public String getEstado() {
        return estado;
    }
}
