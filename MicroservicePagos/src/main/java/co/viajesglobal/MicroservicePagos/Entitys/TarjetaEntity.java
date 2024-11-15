package co.viajesglobal.MicroservicePagos.Entitys;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="datos_tarjeta")
public class TarjetaEntity {
	@Id
	private String Numero_Tarjeta;
	@Column(name="Nombre_Titular")
	private String nomtitular;
	@Column(name="Id_Cliente")
	private int idCliente;
	@Column(name="CVV")
	private int cvv;
	@Column(name="Fecha_Vencimiento")
	private String fechaVencimiento;

	public TarjetaEntity(String numero_Tarjeta, String nomtitular, int idCliente, int cvv, String fechaVencimiento) {
		super();
		this.Numero_Tarjeta = numero_Tarjeta;
		this.nomtitular = nomtitular;
		this.idCliente = idCliente;
		this.cvv = cvv;
		this.fechaVencimiento = fechaVencimiento;
	}


	public TarjetaEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getNumero_Tarjeta() {
		return Numero_Tarjeta;
	}


	public void setNumero_Tarjeta(String numero_Tarjeta) {
		Numero_Tarjeta = numero_Tarjeta;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNumTarjeta() {
		return Numero_Tarjeta;
	}



	public void setNumTarjeta(String Numero_Tarjeta) {
		this.Numero_Tarjeta = Numero_Tarjeta;
	}



	public String getNomtitular() {
		return nomtitular;
	}



	public void setNomtitular(String nomtitular) {
		this.nomtitular = nomtitular;
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
