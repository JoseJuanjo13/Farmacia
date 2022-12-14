package modelo;

import java.io.Serializable;

public class DetallePedido implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int idDetallePedido;
	private int unidades;
	private double subtotal;
	private ProveedorProducto proveedorProducto;

	public DetallePedido(){

	}

	public int getIdDetallePedido() {
		return idDetallePedido;
	}

	public void setIdDetallePedido(int idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public ProveedorProducto getProveedorProducto() {
		return proveedorProducto;
	}

	public void setProveedorProducto(ProveedorProducto proveedorProducto) {
		this.proveedorProducto = proveedorProducto;
	}



}
