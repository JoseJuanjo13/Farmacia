package modelo;

import java.io.Serializable;

public class DescuentoInteres implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int idDescInt;
	private String tipo;
	private double cantidad;

	public DescuentoInteres(){

	}

	public DescuentoInteres(int idDescInt, String tipo, double cantidad) {
		this.idDescInt = idDescInt;
		this.tipo = tipo;
		this.cantidad = cantidad;
	}



	public int getIdDescInt() {
		return idDescInt;
	}

	public void setIdDescInt(int idDescInt) {
		this.idDescInt = idDescInt;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "DescuentoInteres [idDescInt=" + idDescInt + ", tipo=" + tipo + ", cantidad=" + cantidad + "]";
	}


}
