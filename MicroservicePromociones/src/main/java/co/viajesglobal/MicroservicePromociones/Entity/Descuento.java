package co.viajesglobal.MicroservicePromociones.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.util.Date;
/**
 * Clase de entidad que representa un descuento aplicable a las promociones en el sistema.
 * Esta clase se utiliza para mapear la tabla `Descuento` en la base de datos, donde se almacenan
 * los detalles de los descuentos disponibles.
 */
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
    /**
     * Constructor con parámetros que permite crear un objeto `Descuento` con valores iniciales.
     * 
     * @param idDescuento            El identificador único del descuento.
     * @param cupon                  El código del cupón de descuento.
     * @param porcentajeDescuento    El porcentaje de descuento aplicado.
     * @param fechaVencimiento       La fecha de vencimiento del descuento.
     * @param activo                 Indica si el descuento está activo.
     * @param descripcion            Descripción del descuento.
     */
    
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
