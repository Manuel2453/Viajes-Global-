package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicio_Alojamiento")
public class ServicioAlojamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Servicio") // Ajusta aquí al nombre correcto
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_alojamiento")
    private Alojamiento alojamiento;

    private String servicio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

}
