package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Factura implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int idFactura;
	private double total;
	private LocalDate fecha;
	private Cliente cliente;

	public Factura(){

	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
