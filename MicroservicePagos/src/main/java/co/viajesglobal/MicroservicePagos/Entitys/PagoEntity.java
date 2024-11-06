package co.viajesglobal.MicroservicePagos.Entitys;

import java.sql.Date;
import java.time.LocalDateTime;

import co.viajesglobal.MicroservicePagos.Enum.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pago")
public class PagoEntity {
	@Id
	private String Id_pago;
	@Column(name="id_Cliente")
	private int id_Cliente;	
	@Column(name="Fecha_Pago")
	private LocalDateTime  fecha_Pago;
	@Column(name="Monto")
	private double Monto;
    @Enumerated(EnumType.STRING)
	private Estado Estado;// este es el enum
	@Column(name="Id_Reserva")
	private int Id_Reserva ;
	
	public PagoEntity() {
		// TODO Auto-generated constructor stub
	}

	public PagoEntity(String id_pago, int id_Cliente, LocalDateTime fecha_Pago, double monto,
			Estado estado, int id_Reserva) {
		super();
		this.Id_pago = id_pago;
		this.id_Cliente = id_Cliente;
		this.fecha_Pago = fecha_Pago;
		this.Monto = monto;
		this.Estado = estado;
		this.Id_Reserva = id_Reserva;
	}

	public void setFecha_Pago(LocalDateTime fecha_Pago) {
		this.fecha_Pago = fecha_Pago;
	}



	public int getId_Cliente() {
		return id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}
	
	public String getId_pago() {
		return Id_pago;
	}

	public void setId_pago(String id_pago) {
		Id_pago = id_pago;
	}

	public double getMonto() {
		return Monto;
	}

	public void setMonto(double monto) {
		Monto = monto;
	}

	public Estado getEstado() {
		return Estado;
	}

	public void setEstado(Estado estado) {
		Estado = estado;
	}

	public int getId_Reserva() {
		return Id_Reserva;
	}

	public void setId_Reserva(int id_Reserva) {
		Id_Reserva = id_Reserva;
	}

	
	
	
	
	

}
