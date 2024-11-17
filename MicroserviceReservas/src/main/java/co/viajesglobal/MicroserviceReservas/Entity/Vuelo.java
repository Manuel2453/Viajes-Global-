package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa la entidad de un Vuelo dentro del sistema de reservas.
 * Esta clase mapea la tabla "vuelos" en la base de datos.
 */
@Entity
@Table(name = "vuelos")
public class Vuelo {

    /**
     * Identificador único del vuelo. Es generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVuelo;

    /**
     * Cantidad de asientos disponibles en clase turista para este vuelo.
     */
    @Column(name = "stock_turista", nullable = false)
    private int stockTurista;

    /**
     * Cantidad de asientos disponibles en clase business para este vuelo.
     */
    @Column(name = "stock_business", nullable = false)
    private int stockBusiness;

    /**
     * Ciudad o aeropuerto de origen del vuelo.
     */
    @Column(name = "origen", nullable = false)
    private String origen;

    /**
     * Ciudad o aeropuerto de destino del vuelo.
     */
    @Column(name = "destino", nullable = false)
    private String destino;

    /**
     * Fecha y hora de salida del vuelo.
     */
    @Column(name = "fecha_salida", nullable = false)
    private LocalDateTime fechaSalida;

    /**
     * Fecha y hora estimada de llegada del vuelo.
     */
    @Column(name = "fecha_llegada", nullable = false)
    private LocalDateTime fechaLlegada;

    /**
     * Duración del vuelo en minutos.
     */
    @Column(name = "duracion")
    private Integer duracion;

    /**
     * Nombre de la aerolínea que opera el vuelo.
     */
    @Column(name = "aerolinea", nullable = false)
    private String aerolinea;

    /**
     * Precio del vuelo por pasajero.
     */
    @Column(name = "precio", nullable = false)
    private double precio;

    // Getters y Setters

    /**
     * Obtiene el identificador único del vuelo.
     * @return el identificador del vuelo.
     */
    public Long getIdVuelo() {
        return idVuelo;
    }

    /**
     * Establece el identificador único del vuelo.
     * @param idVuelo el identificador del vuelo.
     */
    public void setIdVuelo(Long idVuelo) {
        this.idVuelo = idVuelo;
    }

    /**
     * Obtiene la cantidad de asientos disponibles en clase turista.
     * @return la cantidad de asientos en clase turista.
     */
    public int getStockTurista() {
        return stockTurista;
    }

    /**
     * Establece la cantidad de asientos disponibles en clase turista.
     * @param stockTurista la cantidad de asientos en clase turista.
     */
    public void setStockTurista(int stockTurista) {
        this.stockTurista = stockTurista;
    }

    /**
     * Obtiene la cantidad de asientos disponibles en clase business.
     * @return la cantidad de asientos en clase business.
     */
    public int getStockBusiness() {
        return stockBusiness;
    }

    /**
     * Establece la cantidad de asientos disponibles en clase business.
     * @param stockBusiness la cantidad de asientos en clase business.
     */
    public void setStockBusiness(int stockBusiness) {
        this.stockBusiness = stockBusiness;
    }

    /**
     * Obtiene la ciudad o aeropuerto de origen del vuelo.
     * @return el origen del vuelo.
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Establece la ciudad o aeropuerto de origen del vuelo.
     * @param origen el origen del vuelo.
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * Obtiene la ciudad o aeropuerto de destino del vuelo.
     * @return el destino del vuelo.
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Establece la ciudad o aeropuerto de destino del vuelo.
     * @param destino el destino del vuelo.
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtiene la fecha y hora de salida del vuelo.
     * @return la fecha y hora de salida.
     */
    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Establece la fecha y hora de salida del vuelo.
     * @param fechaSalida la fecha y hora de salida.
     */
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Obtiene la fecha y hora de llegada del vuelo.
     * @return la fecha y hora de llegada.
     */
    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * Establece la fecha y hora de llegada del vuelo.
     * @param fechaLlegada la fecha y hora de llegada.
     */
    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * Obtiene la duración estimada del vuelo en minutos.
     * @return la duración del vuelo.
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración estimada del vuelo en minutos.
     * @param duracion la duración del vuelo.
     */
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    /**
     * Obtiene el nombre de la aerolínea que opera el vuelo.
     * @return el nombre de la aerolínea.
     */
    public String getAerolinea() {
        return aerolinea;
    }

    /**
     * Establece el nombre de la aerolínea que opera el vuelo.
     * @param aerolinea el nombre de la aerolínea.
     */
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    /**
     * Obtiene el precio del vuelo por pasajero.
     * @return el precio del vuelo.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del vuelo por pasajero.
     * @param precio el precio del vuelo.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
