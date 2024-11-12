package co.viajesglobal.MicroserviceReservas.DTO;

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
