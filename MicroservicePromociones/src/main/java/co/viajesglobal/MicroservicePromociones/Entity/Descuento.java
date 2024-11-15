package co.viajesglobal.MicroservicePromociones.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDescuento;
    private String cupon;
    private double porcentajeDescuento;
    private Date fechaVencimiento;
    private boolean activo;
    private String descripcion;

    public Descuento() {
		// TODO Auto-generated constructor stub
	}


	public Descuento(int idDescuento, String cupon, double porcentajeDescuento, Date fechaVencimiento, boolean activo,
			String descripcion) {
		super();
		this.idDescuento = idDescuento;
		this.cupon = cupon;
		this.porcentajeDescuento = porcentajeDescuento;
		this.fechaVencimiento = fechaVencimiento;
		this.activo = activo;
		this.descripcion = descripcion;
	}




	public int getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

	public String getCupon() {
		return cupon;
	}

	public void setCupon(String cupon) {
		this.cupon = cupon;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
