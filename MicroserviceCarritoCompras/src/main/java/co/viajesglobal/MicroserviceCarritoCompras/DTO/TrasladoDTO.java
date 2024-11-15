package co.viajesglobal.MicroserviceCarritoCompras.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrasladoDTO {

	private Long id;
    private String ciudad;
    private String origen;
    private String destino;
    private String tipoTransporte;
    private int maximoPersonas;
    private String descripcion;
    private String imagenUrl;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fechaInicioDisponible;
    private LocalDate fechaFinDisponible;
    private boolean disponible;
    private Double precio;
    private String descripcionServicio;

    
    public TrasladoDTO() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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


	public String getTipoTransporte() {
		return tipoTransporte;
	}


	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}


	public int getMaximoPersonas() {
		return maximoPersonas;
	}


	public void setMaximoPersonas(int maximoPersonas) {
		this.maximoPersonas = maximoPersonas;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getImagenUrl() {
		return imagenUrl;
	}


	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}


	public LocalTime getHoraFin() {
		return horaFin;
	}


	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}


	public LocalDate getFechaInicioDisponible() {
		return fechaInicioDisponible;
	}


	public void setFechaInicioDisponible(LocalDate fechaInicioDisponible) {
		this.fechaInicioDisponible = fechaInicioDisponible;
	}


	public LocalDate getFechaFinDisponible() {
		return fechaFinDisponible;
	}


	public void setFechaFinDisponible(LocalDate fechaFinDisponible) {
		this.fechaFinDisponible = fechaFinDisponible;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public String getDescripcionServicio() {
		return descripcionServicio;
	}


	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}
	
}
