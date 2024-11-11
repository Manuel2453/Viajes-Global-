package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Alojamiento")
public class Alojamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Alojamiento") 
    private Integer id;

    private String ciudad;

    @Column(name = "nombre_hotel")
    private String nombreHotel;

    private int estrellas;
    private String direccion;

    @Column(name = "cantidad_habitaciones")
    private int cantidadHabitaciones;

    @Column(name = "cantidad_personas_max")
    private int cantidadPersonasMax;

    @Column(name = "fecha_entrada")
    private Date fechaEntrada;

    @Column(name = "fecha_salida")
    private Date fechaSalida;

    private String descripcion;

    @Column(name = "precio_noche")
    private double precioNoche;

    // Relaciones
    @OneToMany(mappedBy = "alojamiento", cascade = CascadeType.ALL)
    private List<FotoAlojamiento> fotos;

    @OneToMany(mappedBy = "alojamiento", cascade = CascadeType.ALL)
    private List<ServicioAlojamiento> servicios;

    @OneToMany(mappedBy = "alojamiento", cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones;

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

	public List<FotoAlojamiento> getFotos() {
		return fotos;
	}

	public void setFotos(List<FotoAlojamiento> fotos) {
		this.fotos = fotos;
	}

	public List<ServicioAlojamiento> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioAlojamiento> servicios) {
		this.servicios = servicios;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

}
