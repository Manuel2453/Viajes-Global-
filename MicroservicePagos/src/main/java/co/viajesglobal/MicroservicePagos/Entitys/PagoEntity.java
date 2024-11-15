package co.viajesglobal.MicroservicePagos.Entitys;

import java.time.LocalDateTime;

import co.viajesglobal.MicroservicePagos.Enum.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pago")
public class PagoEntity {
    @Id
    @Column(name = "Id_Pago", nullable = false)
    private String idPago;

    @Column(name = "Id_Cliente", nullable = false)
    private int idCliente;

    @Column(name = "Fecha_Pago", nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "Monto", nullable = false)
    private double monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", nullable = false)
    private Estado estado;

    @Column(name = "Id_Carrito", nullable = false) // Cambio de Id_Reserva a Id_Carrito
    private int idCarrito;

    public PagoEntity() {
        // Constructor vacío
    }

    public PagoEntity(String idPago, int idCliente, LocalDateTime fechaPago, double monto, Estado estado, int idCarrito) {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.estado = estado;
        this.idCarrito = idCarrito;
    }

    // Getters y Setters
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
