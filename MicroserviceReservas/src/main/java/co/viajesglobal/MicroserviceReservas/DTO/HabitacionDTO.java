package co.viajesglobal.MicroserviceReservas.DTO;
/**
 * DTO (Data Transfer Object) que representa los detalles de una habitacion.
 * Este objeto es utilizado para transferir la información relevante de la habitacion
 * entre las capas de la aplicación.
 */
public class HabitacionDTO {
	
    private String tipoHabitacion;
    private int cantidadCamas;
    private int capacidadPersonas;
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
