package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Traslado")
public class Traslado {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID_Traslado") 
	    private Long id;

	    @Column(name = "Ciudad")
	    private String ciudad;

	    @Column(name = "tipo_transporte")
	    private String tipoTransporte;

	    @Column(name = "maximo_personas")
	    private int maximoPersonas;

	    private String descripcion;

	    @Column(name = "imagen_url")
	    private String imagenUrl;

	    @Column(name = "hora_inicio")
	    private LocalTime horaInicio;

	    @Column(name = "hora_fin")
	    private LocalTime horaFin;

	    @Column(name = "fecha_inicio_disponible")
	    private LocalDate fechaInicioDisponible;

	    @Column(name = "fecha_fin_disponible")
	    private LocalDate fechaFinDisponible;

	    private boolean disponible;

	    @Column(name = "precio")
	    private Double precio;

	    @Column(name = "descripcion_servicio")
	    private String descripcionServicio;

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
