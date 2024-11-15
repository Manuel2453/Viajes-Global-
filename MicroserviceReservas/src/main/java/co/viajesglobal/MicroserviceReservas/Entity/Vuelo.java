package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVuelo;

    @Column(name = "stock_turista", nullable = false)
    private int stockTurista;

    @Column(name = "stock_business", nullable = false)
    private int stockBusiness;

    @Column(name = "origen", nullable = false)
    private String origen;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "fecha_salida", nullable = false)
    private LocalDateTime fechaSalida;

    @Column(name = "fecha_llegada", nullable = false)
    private LocalDateTime fechaLlegada;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "aerolinea", nullable = false)
    private String aerolinea;

    @Column(name = "precio", nullable = false)
    private double precio;

    // Getters y Setters

    public Long getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Long idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getStockTurista() {
        return stockTurista;
    }

    public void setStockTurista(int stockTurista) {
        this.stockTurista = stockTurista;
    }

    public int getStockBusiness() {
        return stockBusiness;
    }

    public void setStockBusiness(int stockBusiness) {
        this.stockBusiness = stockBusiness;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
