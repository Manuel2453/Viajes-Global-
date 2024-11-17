package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;

/**
 * Representa una habitación asociada a un alojamiento.
 * Una habitación incluye información sobre su tipo, cantidad de camas y capacidad para personas.
 */
@Entity
@Table(name = "Habitacion")
public class Habitacion {

    /**
     * Identificador único de la habitación.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Habitacion")
    private Integer id;

    /**
     * Relación muchos-a-uno con el alojamiento al que pertenece esta habitación.
     */
    @ManyToOne
    @JoinColumn(name = "id_alojamiento")
    private Alojamiento alojamiento;

    /**
     * Tipo de habitación (por ejemplo, "doble", "suite").
     */
    @Column(name = "tipo_habitacion")
    private String tipoHabitacion;

    /**
     * Cantidad de camas disponibles en la habitación.
     */
    @Column(name = "cantidad_camas")
    private int cantidadCamas;

    /**
     * Capacidad máxima de personas que pueden alojarse en la habitación.
     */
    @Column(name = "capacidad_personas")
    private int capacidadPersonas;

    /**
     * Obtiene el identificador único de la habitación.
     * 
     * @return el identificador de la habitación.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único de la habitación.
     * 
     * @param id el nuevo identificador de la habitación.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el alojamiento asociado a esta habitación.
     * 
     * @return el alojamiento asociado.
     */
    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    /**
     * Establece el alojamiento asociado a esta habitación.
     * 
     * @param alojamiento el nuevo alojamiento asociado.
     */
    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    /**
     * Obtiene el tipo de la habitación.
     * 
     * @return el tipo de habitación.
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * Establece el tipo de la habitación.
     * 
     * @param tipoHabitacion el nuevo tipo de habitación.
     */
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    /**
     * Obtiene la cantidad de camas en la habitación.
     * 
     * @return la cantidad de camas.
     */
    public int getCantidadCamas() {
        return cantidadCamas;
    }

    /**
     * Establece la cantidad de camas en la habitación.
     * 
     * @param cantidadCamas la nueva cantidad de camas.
     */
    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    /**
     * Obtiene la capacidad máxima de personas para la habitación.
     * 
     * @return la capacidad de personas.
     */
    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    /**
     * Establece la capacidad máxima de personas para la habitación.
     * 
     * @param capacidadPersonas la nueva capacidad de personas.
     */
    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }
}
