package co.viajesglobal.MicroservicePagos.DTO;

import java.util.Date;

/**
 * Esta clase representa el objeto de transferencia de datos (DTO) utilizado para almacenar la información de un pago realizado por un cliente.
 * Incluye datos de la tarjeta que vaya a utilizar como numero de la tarjeta, nombre del titular, id del cliente,
 * el cvv y la fecha de vencimiento.
 */
public class TarjetaDTO {
	private String Numero_Tarjeta;
	private String nomtitular;
	private int idCliente;
	private int cvv;
	private String fechaVencimiento;
	

	public TarjetaDTO() {
		// TODO Auto-generated constructor stub
	}

	public TarjetaDTO(String numero_Tarjeta, String nomtitular, int idCliente, int cvv, String fechaVencimiento) {
		super();
		Numero_Tarjeta = numero_Tarjeta;
		this.nomtitular = nomtitular;
		this.idCliente = idCliente;
		this.cvv = cvv;
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNumero_Tarjeta() {
		return Numero_Tarjeta;
	}

	public void setNumero_Tarjeta(String numero_Tarjeta) {
		Numero_Tarjeta = numero_Tarjeta;
	}

	public String getNomtitular() {
		return nomtitular;
	}

	public void setNomtitular(String nomtitular) {
		this.nomtitular = nomtitular;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	


}
