package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Actividad")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Actividad")
    private Long id;

    @Column(name = "Destino")
    private String destino;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Incluye_Traslado")
    private boolean incluyeTraslado;

    @Column(name = "Estrellas")
    private int estrellas;

    @Column(name = "Precio")
    private BigDecimal precio;

    @Column(name = "Duracion_Horas")
    private int duracionHoras;

    @Column(name = "Fecha_Inicio")
    private LocalDate fechaInicio;

    @Column(name = "Fecha_Fin")
    private LocalDate fechaFin;

    @Column(name = "Url_Imagen")
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

