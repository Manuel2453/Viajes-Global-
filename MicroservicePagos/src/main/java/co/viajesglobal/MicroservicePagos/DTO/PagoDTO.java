package co.viajesglobal.MicroservicePagos.DTO;

import java.time.LocalDateTime;

import co.viajesglobal.MicroservicePagos.Enum.Estado;

/**
 * Esta clase representa el objeto de transferencia de datos (DTO) utilizado para almacenar la información de un pago realizado por un cliente.
 * Incluye datos como el identificador del pago, el cliente que realiza el pago, la fecha y el monto del pago, el estado del pago y el identificador del carrito asociado.
 */

public class PagoDTO {

    private String idPago;
    private int idCliente; // Identificador del cliente
    private LocalDateTime fechaPago;
    private double monto; // Monto total
    private Estado estado; // Estado del pago
    private int idCarrito; // Cambio de Id_Reserva a Id_Carrito

    public PagoDTO() {
        // Constructor vacío
    }

    public PagoDTO(String idPago, int idCliente, LocalDateTime fechaPago, double monto, Estado estado, int idCarrito) {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.estado = estado;
        this.idCarrito = idCarrito;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }
}
