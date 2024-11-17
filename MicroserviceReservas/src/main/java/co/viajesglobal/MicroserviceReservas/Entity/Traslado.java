package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa un traslado que puede ser reservado en el sistema.
 * Un traslado incluye detalles sobre el tipo de transporte, la disponibilidad, 
 * horarios, capacidad, y precio.
 */
@Entity
@Table(name = "Traslado")
public class Traslado {

    /**
     * Identificador único del traslado.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Traslado")
    private Long id;

    /**
     * Ciudad donde se ofrece el traslado.
     */
    @Column(name = "Ciudad")
    private String ciudad;

    /**
     * Tipo de transporte utilizado para el traslado (por ejemplo, "Auto", "Bus").
     */
    @Column(name = "tipo_transporte")
    private String tipoTransporte;

    /**
     * Capacidad máxima de personas que pueden usar el traslado.
     */
    @Column(name = "maximo_personas")
    private int maximoPersonas;

    /**
     * Descripción breve del traslado.
     */
    private String descripcion;

    /**
     * URL de la imagen representativa del traslado.
     */
    @Column(name = "imagen_url")
    private String imagenUrl;

    /**
     * Hora de inicio de la disponibilidad del traslado.
     */
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    /**
     * Hora de fin de la disponibilidad del traslado.
     */
    @Column(name = "hora_fin")
    private LocalTime horaFin;

    /**
     * Fecha inicial en la que el traslado estará disponible.
     */
    @Column(name = "fecha_inicio_disponible")
    private LocalDate fechaInicioDisponible;

    /**
     * Fecha final en la que el traslado estará disponible.
     */
    @Column(name = "fecha_fin_disponible")
    private LocalDate fechaFinDisponible;

    /**
     * Indica si el traslado está actualmente disponible para reservas.
     */
    private boolean disponible;

    /**
     * Precio del traslado.
     */
    @Column(name = "precio")
    private Double precio;

    /**
     * Descripción detallada del servicio asociado al traslado.
     */
    @Column(name = "descripcion_servicio")
    private String descripcionServicio;

    // Métodos Getter y Setter

    /**
     * Obtiene el identificador único del traslado.
     * 
     * @return el identificador del traslado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del traslado.
     * 
     * @param id el nuevo identificador del traslado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la ciudad donde se ofrece el traslado.
     * 
     * @return la ciudad del traslado.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad donde se ofrece el traslado.
     * 
     * @param ciudad la nueva ciudad del traslado.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el tipo de transporte utilizado.
     * 
     * @return el tipo de transporte.
     */
    public String getTipoTransporte() {
        return tipoTransporte;
    }

    /**
     * Establece el tipo de transporte utilizado.
     * 
     * @param tipoTransporte el nuevo tipo de transporte.
     */
    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    /**
     * Obtiene la capacidad máxima de personas.
     * 
     * @return la capacidad máxima de personas.
     */
    public int getMaximoPersonas() {
        return maximoPersonas;
    }

    /**
     * Establece la capacidad máxima de personas.
     * 
     * @param maximoPersonas la nueva capacidad máxima de personas.
     */
    public void setMaximoPersonas(int maximoPersonas) {
        this.maximoPersonas = maximoPersonas;
    }

    /**
     * Obtiene la descripción breve del traslado.
     * 
     * @return la descripción del traslado.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece una descripción breve del traslado.
     * 
     * @param descripcion la nueva descripción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la URL de la imagen representativa.
     * 
     * @return la URL de la imagen.
     */
    public String getImagenUrl() {
        return imagenUrl;
    }

    /**
     * Establece la URL de la imagen representativa.
     * 
     * @param imagenUrl la nueva URL de la imagen.
     */
    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    /**
     * Obtiene la hora de inicio de disponibilidad.
     * 
     * @return la hora de inicio.
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio de disponibilidad.
     * 
     * @param horaInicio la nueva hora de inicio.
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de fin de disponibilidad.
     * 
     * @return la hora de fin.
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     * Establece la hora de fin de disponibilidad.
     * 
     * @param horaFin la nueva hora de fin.
     */
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Obtiene la fecha inicial de disponibilidad.
     * 
     * @return la fecha inicial de disponibilidad.
     */
    public LocalDate getFechaInicioDisponible() {
        return fechaInicioDisponible;
    }

    /**
     * Establece la fecha inicial de disponibilidad.
     * 
     * @param fechaInicioDisponible la nueva fecha inicial.
     */
    public void setFechaInicioDisponible(LocalDate fechaInicioDisponible) {
        this.fechaInicioDisponible = fechaInicioDisponible;
    }

    /**
     * Obtiene la fecha final de disponibilidad.
     * 
     * @return la fecha final de disponibilidad.
     */
    public LocalDate getFechaFinDisponible() {
        return fechaFinDisponible;
    }

    /**
     * Establece la fecha final de disponibilidad.
     * 
     * @param fechaFinDisponible la nueva fecha final.
     */
    public void setFechaFinDisponible(LocalDate fechaFinDisponible) {
        this.fechaFinDisponible = fechaFinDisponible;
    }

    /**
     * Verifica si el traslado está disponible para reservas.
     * 
     * @return {@code true} si está disponible, {@code false} de lo contrario.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece si el traslado está disponible para reservas.
     * 
     * @param disponible el nuevo estado de disponibilidad.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Obtiene el precio del traslado.
     * 
     * @return el precio del traslado.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del traslado.
     * 
     * @param precio el nuevo precio.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la descripción detallada del servicio.
     * 
     * @return la descripción del servicio.
     */
    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    /**
     * Establece la descripción detallada del servicio.
     * 
     * @param descripcionServicio la nueva descripción.
     */
    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }
}
