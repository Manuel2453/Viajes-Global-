package co.viajesglobal.MicroserviceCarritoCompras.DTO;

import java.util.Date;

import java.util.List;

/**
 * DTO (Data Transfer Object) que representa la información de un alojamiento (hotel).
 * Esta clase contiene todos los datos relevantes acerca de un alojamiento, como su
 * ubicación, características, precios, y servicios disponibles.
 */
public class AlojamientoDTO {
	
	private Integer id;
    private String ciudad;
    private String nombreHotel;
    private int estrellas;
    private String direccion;
    private int cantidadHabitaciones;
    private int cantidadPersonasMax;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String descripcion;
    private double precioNoche;
    private List<String> fotos;
    private List<String> servicios;
    private List<HabitacionDTO> habitaciones;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getNombreHotel() {
		return nombreHotel;
	}
	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCantidadHabitaciones() {
		return cantidadHabitaciones;
	}
	public void setCantidadHabitaciones(int cantidadHabitaciones) {
		this.cantidadHabitaciones = cantidadHabitaciones;
	}
	public int getCantidadPersonasMax() {
		return cantidadPersonasMax;
	}
	public void setCantidadPersonasMax(int cantidadPersonasMax) {
		this.cantidadPersonasMax = cantidadPersonasMax;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioNoche() {
		return precioNoche;
	}
	public void setPrecioNoche(double precioNoche) {
		this.precioNoche = precioNoche;
	}
	public List<String> getFotos() {
		return fotos;
	}
	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}
	public List<String> getServicios() {
		return servicios;
	}
	public void setServicios(List<String> servicios) {
		this.servicios = servicios;
	}
	public List<HabitacionDTO> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(List<HabitacionDTO> habitaciones) {
		this.habitaciones = habitaciones;
	}

}
