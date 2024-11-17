package co.viajesglobal.MicroserviceCarritoCompras.DTO;


/**
 * DTO (Data Transfer Object) que representa los detalles de una habitación.
 * 
 * Esta clase contiene información sobre el tipo de habitación, la cantidad de camas
 * disponibles y la capacidad máxima de personas que puede alojar la habitación.
 * Se utiliza para transferir los datos entre las capas de la aplicación.
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
