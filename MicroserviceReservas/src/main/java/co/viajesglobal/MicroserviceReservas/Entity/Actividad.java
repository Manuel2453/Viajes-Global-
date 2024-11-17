package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa una actividad disponible en el sistema de reservas.
 * Contiene información detallada sobre actividades turísticas o de ocio.
 */
@Entity
@Table(name = "Actividad")
public class Actividad {

    /**
     * Identificador único de la actividad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Actividad")
    private Long id;

    /**
     * Destino donde se lleva a cabo la actividad.
     */
    @Column(name = "Destino")
    private String destino;

    /**
     * Título de la actividad.
     */
    @Column(name = "Titulo")
    private String titulo;

    /**
     * Descripción detallada de la actividad.
     */
    @Column(name = "Descripcion")
    private String descripcion;

    /**
     * Indica si la actividad incluye traslado.
     */
    @Column(name = "Incluye_Traslado")
    private boolean incluyeTraslado;

    /**
     * Puntuación en estrellas de la actividad (1 a 5).
     */
    @Column(name = "Estrellas")
    private int estrellas;

    /**
     * Precio de la actividad.
     */
    @Column(name = "Precio")
    private BigDecimal precio;

    /**
     * Duración de la actividad en horas.
     */
    @Column(name = "Duracion_Horas")
    private int duracionHoras;

    /**
     * Fecha de inicio de la actividad.
     */
    @Column(name = "Fecha_Inicio")
    private LocalDate fechaInicio;

    /**
     * Fecha de finalización de la actividad.
     */
    @Column(name = "Fecha_Fin")
    private LocalDate fechaFin;

    /**
     * URL de la imagen representativa de la actividad.
     */
    @Column(name = "Url_Imagen")
    private String urlImagen;

    /**
     * Obtiene el ID de la actividad.
     * 
     * @return El ID de la actividad.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la actividad.
     * 
     * @param id El ID a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el destino de la actividad.
     * 
     * @return El destino de la actividad.
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Establece el destino de la actividad.
     * 
     * @param destino El destino a establecer.
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtiene el título de la actividad.
     * 
     * @return El título de la actividad.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la actividad.
     * 
     * @param titulo El título a establecer.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la descripción de la actividad.
     * 
     * @return La descripción de la actividad.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la actividad.
     * 
     * @param descripcion La descripción a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Verifica si la actividad incluye traslado.
     * 
     * @return {@code true} si incluye traslado, de lo contrario {@code false}.
     */
    public boolean isIncluyeTraslado() {
        return incluyeTraslado;
    }

    /**
     * Establece si la actividad incluye traslado.
     * 
     * @param incluyeTraslado {@code true} si incluye traslado, de lo contrario {@code false}.
     */
    public void setIncluyeTraslado(boolean incluyeTraslado) {
        this.incluyeTraslado = incluyeTraslado;
    }

    /**
     * Obtiene la puntuación en estrellas de la actividad.
     * 
     * @return La puntuación en estrellas.
     */
    public int getEstrellas() {
        return estrellas;
    }

    /**
     * Establece la puntuación en estrellas de la actividad.
     * 
     * @param estrellas La puntuación en estrellas a establecer.
     */
    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    /**
     * Obtiene el precio de la actividad.
     * 
     * @return El precio de la actividad.
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la actividad.
     * 
     * @param precio El precio a establecer.
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la duración de la actividad en horas.
     * 
     * @return La duración en horas.
     */
    public int getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Establece la duración de la actividad en horas.
     * 
     * @param duracionHoras La duración a establecer.
     */
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Obtiene la fecha de inicio de la actividad.
     * 
     * @return La fecha de inicio.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio de la actividad.
     * 
     * @param fechaInicio La fecha de inicio a establecer.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de finalización de la actividad.
     * 
     * @return La fecha de finalización.
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de finalización de la actividad.
     * 
     * @param fechaFin La fecha de finalización a establecer.
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene la URL de la imagen representativa de la actividad.
     * 
     * @return La URL de la imagen.
     */
    public String getUrlImagen() {
        return urlImagen;
    }

    /**
     * Establece la URL de la imagen representativa de la actividad.
     * 
     * @param urlImagen La URL de la imagen a establecer.
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
