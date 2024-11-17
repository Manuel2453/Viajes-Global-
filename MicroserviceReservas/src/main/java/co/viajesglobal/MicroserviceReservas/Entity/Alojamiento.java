package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Representa una entidad de alojamiento en el sistema de reservas.
 * Esta clase almacena información detallada sobre los alojamientos disponibles, 
 * incluyendo su ubicación, características, servicios y habitaciones asociadas.
 */
@Entity
@Table(name = "Alojamiento")
public class Alojamiento {

    /**
     * Identificador único del alojamiento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Alojamiento")
    private Integer id;

    /**
     * Ciudad donde se encuentra ubicado el alojamiento.
     */
    private String ciudad;

    /**
     * Nombre del hotel asociado al alojamiento.
     */
    @Column(name = "nombre_hotel")
    private String nombreHotel;

    /**
     * Número de estrellas del alojamiento.
     */
    private int estrellas;

    /**
     * Dirección física del alojamiento.
     */
    private String direccion;

    /**
     * Cantidad total de habitaciones disponibles en el alojamiento.
     */
    @Column(name = "cantidad_habitaciones")
    private int cantidadHabitaciones;

    /**
     * Capacidad máxima de personas que puede alojar.
     */
    @Column(name = "cantidad_personas_max")
    private int cantidadPersonasMax;

    /**
     * Fecha de entrada al alojamiento.
     */
    @Column(name = "fecha_entrada")
    private Date fechaEntrada;

    /**
     * Fecha de salida del alojamiento.
     */
    @Column(name = "fecha_salida")
    private Date fechaSalida;

    /**
     * Descripción del alojamiento.
     */
    private String descripcion;

    /**
     * Precio por noche en el alojamiento.
     */
    @Column(name = "precio_noche")
    private double precioNoche;

    // Relaciones

    /**
     * Lista de fotos asociadas al alojamiento.
     */
    @OneToMany(mappedBy = "alojamiento", cascade = CascadeType.ALL)
    private List<FotoAlojamiento> fotos;

    /**
     * Lista de servicios ofrecidos por el alojamiento.
     */
    @OneToMany(mappedBy = "alojamiento", cascade = CascadeType.ALL)
    private List<ServicioAlojamiento> servicios;

    /**
     * Lista de habitaciones disponibles en el alojamiento.
     */
    @OneToMany(mappedBy = "alojamiento", cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones;

    // Métodos Getters y Setters

    /**
     * Obtiene el identificador único del alojamiento.
     * 
     * @return id del alojamiento.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del alojamiento.
     * 
     * @param id identificador único.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene la ciudad donde se encuentra el alojamiento.
     * 
     * @return ciudad del alojamiento.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del alojamiento.
     * 
     * @param ciudad ciudad del alojamiento.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el nombre del hotel asociado al alojamiento.
     * 
     * @return nombre del hotel.
     */
    public String getNombreHotel() {
        return nombreHotel;
    }

    /**
     * Establece el nombre del hotel asociado al alojamiento.
     * 
     * @param nombreHotel nombre del hotel.
     */
    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    /**
     * Obtiene el número de estrellas del alojamiento.
     * 
     * @return número de estrellas.
     */
    public int getEstrellas() {
        return estrellas;
    }

    /**
     * Establece el número de estrellas del alojamiento.
     * 
     * @param estrellas número de estrellas.
     */
    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    /**
     * Obtiene la dirección del alojamiento.
     * 
     * @return dirección del alojamiento.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del alojamiento.
     * 
     * @param direccion dirección del alojamiento.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la cantidad total de habitaciones del alojamiento.
     * 
     * @return cantidad de habitaciones.
     */
    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    /**
     * Establece la cantidad total de habitaciones del alojamiento.
     * 
     * @param cantidadHabitaciones cantidad de habitaciones.
     */
    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    /**
     * Obtiene la capacidad máxima de personas que puede alojar.
     * 
     * @return capacidad máxima de personas.
     */
    public int getCantidadPersonasMax() {
        return cantidadPersonasMax;
    }

    /**
     * Establece la capacidad máxima de personas que puede alojar.
     * 
     * @param cantidadPersonasMax capacidad máxima de personas.
     */
    public void setCantidadPersonasMax(int cantidadPersonasMax) {
        this.cantidadPersonasMax = cantidadPersonasMax;
    }

    /**
     * Obtiene la fecha de entrada al alojamiento.
     * 
     * @return fecha de entrada.
     */
    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * Establece la fecha de entrada al alojamiento.
     * 
     * @param fechaEntrada fecha de entrada.
     */
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * Obtiene la fecha de salida del alojamiento.
     * 
     * @return fecha de salida.
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Establece la fecha de salida del alojamiento.
     * 
     * @param fechaSalida fecha de salida.
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Obtiene la descripción del alojamiento.
     * 
     * @return descripción del alojamiento.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del alojamiento.
     * 
     * @param descripcion descripción del alojamiento.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio por noche del alojamiento.
     * 
     * @return precio por noche.
     */
    public double getPrecioNoche() {
        return precioNoche;
    }

    /**
     * Establece el precio por noche del alojamiento.
     * 
     * @param precioNoche precio por noche.
     */
    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    /**
     * Obtiene la lista de fotos asociadas al alojamiento.
     * 
     * @return lista de fotos.
     */
    public List<FotoAlojamiento> getFotos() {
        return fotos;
    }

    /**
     * Establece la lista de fotos asociadas al alojamiento.
     * 
     * @param fotos lista de fotos.
     */
    public void setFotos(List<FotoAlojamiento> fotos) {
        this.fotos = fotos;
    }

    /**
     * Obtiene la lista de servicios ofrecidos por el alojamiento.
     * 
     * @return lista de servicios.
     */
    public List<ServicioAlojamiento> getServicios() {
        return servicios;
    }

    /**
     * Establece la lista de servicios ofrecidos por el alojamiento.
     * 
     * @param servicios lista de servicios.
     */
    public void setServicios(List<ServicioAlojamiento> servicios) {
        this.servicios = servicios;
    }

    /**
     * Obtiene la lista de habitaciones disponibles en el alojamiento.
     * 
     * @return lista de habitaciones.
     */
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    /**
     * Establece la lista de habitaciones disponibles en el alojamiento.
     * 
     * @param habitaciones lista de habitaciones.
     */
    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}
