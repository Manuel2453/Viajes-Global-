package co.viajesglobal.MicroservicePagos.Entitys;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * Esta clase representa la entidad que mapea la tabla 'datos_tarjeta' en la base de datos. 
 * Es utilizada para almacenar la información de las tarjetas de pago asociadas a los clientes.
 * Cada instancia de la clase corresponde a un registro de una tarjeta de pago.
 */
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
	  /**
     * Constructor que inicializa todos los campos de la entidad TarjetaEntity.
     * 
     * @param numero_Tarjeta El número de la tarjeta de pago.
     * @param nomtitular El nombre del titular de la tarjeta.
     * @param idCliente El identificador del cliente asociado a la tarjeta.
     * @param cvv El código de seguridad CVV de la tarjeta.
     * @param fechaVencimiento La fecha de vencimiento de la tarjeta.
     */
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
