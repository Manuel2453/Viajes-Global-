package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;

/**
 * Representa una foto asociada a un alojamiento.
 * Cada foto está vinculada a un alojamiento específico y contiene una URL que apunta a la imagen.
 */
@Entity
@Table(name = "Foto_Alojamiento")
public class FotoAlojamiento {

    /**
     * Identificador único de la foto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Foto")
    private Integer id;

    /**
     * Relación muchos-a-uno con el alojamiento al que pertenece esta foto.
     */
    @ManyToOne
    @JoinColumn(name = "id_alojamiento")
    private Alojamiento alojamiento;

    /**
     * URL de la foto.
     */
    @Column(name = "url_foto")
    private String urlFoto;

    /**
     * Obtiene el identificador único de la foto.
     * 
     * @return el identificador de la foto.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único de la foto.
     * 
     * @param id el nuevo identificador de la foto.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el alojamiento asociado a esta foto.
     * 
     * @return el alojamiento asociado.
     */
    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    /**
     * Establece el alojamiento asociado a esta foto.
     * 
     * @param alojamiento el nuevo alojamiento asociado.
     */
    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    /**
     * Obtiene la URL de la foto.
     * 
     * @return la URL de la foto.
     */
    public String getUrlFoto() {
        return urlFoto;
    }

    /**
     * Establece la URL de la foto.
     * 
     * @param urlFoto la nueva URL de la foto.
     */
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
