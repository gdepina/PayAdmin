package uade.ioo.modelo;

import java.util.Date;


public abstract class Cheque {
	private int ultimoNumero = 0;
	
	public enum Estado {
		DEFEATED,
	    RECEIVED,
	    DELIVERED,
	    DEPOSITED,
	}

	private int numero;
	private double monto;
	private Date fechaEmision;	
	Estado estado;
	
	public Cheque(int numero, double monto, Date fechaEmision, Estado estado) {
		super();	
		this.numero = numero;
		this.monto = monto;
		this.fechaEmision = fechaEmision;
		this.estado = estado;
	}
	
	public Cheque(double monto, int nro) {
		super();		
		this.numero = nro;
		this.monto = monto;
		this.fechaEmision = new Date();
		this.estado = Estado.DELIVERED;
	}
	
	public int getUltimoNumero() {
		return ultimoNumero++;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}
	public double getMonto() {
		return monto;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}
	
	
}
