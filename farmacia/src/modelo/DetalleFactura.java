package modelo;

import java.io.Serializable;

public class DetalleFactura implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int idDetalleFactura;
	private int unidades;
	private double subtotal;
	private double precioUnitario;
	private String codigoProducto;
	private String nombreProducto;
	private String codigoFactura;

	public DetalleFactura() {

	}

	public int getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(int idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
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

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(String codigoFactura) {
		this.codigoFactura = codigoFactura;
	}



	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public DetalleFactura(int idDetalleFactura, int unidades, double subtotal, double precioUnitario,
			String codigoProducto, String nombreProducto) {
		this.idDetalleFactura = idDetalleFactura;
		this.unidades = unidades;
		this.subtotal = subtotal;
		this.precioUnitario = precioUnitario;
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
	}





}
