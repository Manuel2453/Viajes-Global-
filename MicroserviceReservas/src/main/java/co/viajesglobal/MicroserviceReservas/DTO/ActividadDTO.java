package co.viajesglobal.MicroserviceReservas.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
/**
 * DTO (Data Transfer Object) que representa una actividad disponible en el sistema de reservas.
 * Este objeto se utiliza para transferir información acerca de las actividades entre diferentes capas del sistema.
 */
public class ActividadDTO {
    private Long id;
    private String destino;
    private String titulo;
    private String descripcion;
    private boolean incluyeTraslado;
    private int estrellas;
    private BigDecimal precio;
    private int duracionHoras;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String urlImagen;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isIncluyeTraslado() {
		return incluyeTraslado;
	}
	public void setIncluyeTraslado(boolean incluyeTraslado) {
		this.incluyeTraslado = incluyeTraslado;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public int getDuracionHoras() {
		return duracionHoras;
	}
	public void setDuracionHoras(int duracionHoras) {
		this.duracionHoras = duracionHoras;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
}
