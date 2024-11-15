package co.viajesglobal.MicroserviceReservas.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Habitacion")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Habitacion") // Ajusta aquí al nombre correcto
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_alojamiento")
    private Alojamiento alojamiento;

    @Column(name = "tipo_habitacion")
    private String tipoHabitacion;

    @Column(name = "cantidad_camas")
    private int cantidadCamas;

    @Column(name = "capacidad_personas")
    private int capacidadPersonas;

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

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getCantidadCamas() {
		return cantidadCamas;
	}

	public void setCantidadCamas(int cantidadCamas) {
		this.cantidadCamas = cantidadCamas;
	}

	public int getCapacidadPersonas() {
		return capacidadPersonas;
	}

	public void setCapacidadPersonas(int capacidadPersonas) {
		this.capacidadPersonas = capacidadPersonas;
	}

}
