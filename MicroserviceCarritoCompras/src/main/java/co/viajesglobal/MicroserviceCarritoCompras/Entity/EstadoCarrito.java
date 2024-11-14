package co.viajesglobal.MicroserviceCarritoCompras.Entity;

public enum EstadoCarrito {
	Activo("Activo"),
    Pagado("Pagado"),
    Cancelado("Cancelado");

    private final String estado;

    EstadoCarrito(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
