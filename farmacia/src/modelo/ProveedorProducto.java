package modelo;

import java.io.Serializable;

public class ProveedorProducto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Proveedor proveedor;
	private Producto producto;
	private double precioCompra;

	public ProveedorProducto(){

	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}


}
