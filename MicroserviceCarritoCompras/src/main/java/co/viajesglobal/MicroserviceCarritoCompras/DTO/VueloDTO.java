package co.viajesglobal.MicroserviceCarritoCompras.DTO;

import java.util.Date;

/**
 * DTO (Data Transfer Object) que representa los detalles de un vuelo.
 * 
 * Esta clase contiene información sobre el vuelo, como el origen, el destino, las fechas de salida y regreso,
 * el stock de asientos disponibles en clases turísticas y de negocios, la duración del vuelo, la aerolínea y el precio.
 * Se utiliza para transferir los datos entre las capas de la aplicación.
 */
public class VueloDTO {
	
    private Long id_Vuelo;
    private int stockTurista;
    private int stockBuisness;
    private String origen;
    private String destino;
    private Date fechaSalida;
    private Date fechaRegreso;
    private int duracion;
    private String aerolinea;
    private double precio;
	public Long getIdVuelo() {
		return id_Vuelo;
	}
	public void setIdVuelo(Long idVuelo) {
		this.id_Vuelo = idVuelo;
	}
	public int getStockTurista() {
		return stockTurista;
	}
	public void setStockTurista(int stockTurista) {
		this.stockTurista = stockTurista;
	}
	public int getStockBuisness() {
		return stockBuisness;
	}
	public void setStockBuisness(int stockBuisness) {
		this.stockBuisness = stockBuisness;
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
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
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

	public VueloDTO() {
		// TODO Auto-generated constructor stub
	}
	public VueloDTO(Long id_Vuelo, int stockTurista, int stockBuisness, String origen, String destino, Date fechaSalida,
			Date fechaRegreso, int duracion, String aerolinea, double precio) {
		super();
		this.id_Vuelo = id_Vuelo;
		this.stockTurista = stockTurista;
		this.stockBuisness = stockBuisness;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaRegreso = fechaRegreso;
		this.duracion = duracion;
		this.aerolinea = aerolinea;
		this.precio = precio;
	}
}
