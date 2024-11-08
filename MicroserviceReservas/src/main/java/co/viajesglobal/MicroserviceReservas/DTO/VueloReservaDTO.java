package co.viajesglobal.MicroserviceReservas.DTO;

import java.util.Date;

public class VueloReservaDTO {
    private Long idReserva;
    private Long idVuelo;
    private Long idCliente;
    private Date fechaSalida;
    private Date fechaRegreso;
    private double precioPorVuelo;
    private double precioTotal;

    // Getters y setters
    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Long idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public double getPrecioPorVuelo() {
        return precioPorVuelo;
    }

    public void setPrecioPorVuelo(double precioPorVuelo) {
        this.precioPorVuelo = precioPorVuelo;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
