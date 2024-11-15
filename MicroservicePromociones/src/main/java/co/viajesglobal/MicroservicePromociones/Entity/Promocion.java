package co.viajesglobal.MicroservicePromociones.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPromocion;
    private String origen;
    private String destino;
    private double precio;
    private int dias;
    private int noches;
    private String vueloDirectoEscala;
    private String hotel;
    private Date fechaInicio;
    private Date fechaFin;
    private String imagen_url;

    public Promocion() {
		// TODO Auto-generated constructor stub
	}


	public Promocion(int idPromocion, String origen, String destino, double precio, int dias, int noches,
			String vueloDirectoEscala, String hotel, Date fechaInicio, Date fechaFin, String imagen_url) {
		super();
		this.idPromocion = idPromocion;
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.dias = dias;
		this.noches = noches;
		this.vueloDirectoEscala = vueloDirectoEscala;
		this.hotel = hotel;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.imagen_url = imagen_url;
	}

	public int getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getNoches() {
		return noches;
	}

	public void setNoches(int noches) {
		this.noches = noches;
	}

	public String getVueloDirectoEscala() {
		return vueloDirectoEscala;
	}

	public void setVueloDirectoEscala(String vueloDirectoEscala) {
		this.vueloDirectoEscala = vueloDirectoEscala;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getImagen_url() {
		return imagen_url;
	}


	public void setImagen_url(String imagen_url) {
		this.imagen_url = imagen_url;
	}
}

