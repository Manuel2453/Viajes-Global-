package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;

/**
 * Representa un servicio asociado a un alojamiento. 
 * Un servicio puede incluir opciones como desayuno, piscina, gimnasio, entre otros.
 */
@Entity
@Table(name = "Servicio_Alojamiento")
public class ServicioAlojamiento {

    /**
     * Identificador único del servicio de alojamiento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Servicio")
    private Integer id;

    /**
     * Relación muchos-a-uno con el alojamiento que ofrece este servicio.
     */
    @ManyToOne
    @JoinColumn(name = "id_alojamiento")
    private Alojamiento alojamiento;

    /**
     * Descripción del servicio ofrecido (por ejemplo, "WiFi", "Desayuno incluido").
     */
    private String servicio;

    /**
     * Obtiene el identificador único del servicio.
     * 
     * @return el identificador del servicio.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del servicio.
     * 
     * @param id el nuevo identificador del servicio.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el alojamiento asociado a este servicio.
     * 
     * @return el alojamiento asociado.
     */
    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    /**
     * Establece el alojamiento asociado a este servicio.
     * 
     * @param alojamiento el nuevo alojamiento asociado.
     */
    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    /**
     * Obtiene la descripción del servicio ofrecido.
     * 
     * @return la descripción del servicio.
     */
    public String getServicio() {
        return servicio;
    }

    /**
     * Establece la descripción del servicio ofrecido.
     * 
     * @param servicio la nueva descripción del servicio.
     */
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

}
