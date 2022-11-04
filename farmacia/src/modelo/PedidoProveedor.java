package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class PedidoProveedor implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int idPedidoProveedor;
	private LocalDate fecha;
	private double total;
	private DetallePedido detallePedido;
	private Sucursal sucursal;
	private Proveedor proveedor;


	public PedidoProveedor(){

	}

	public int getIdPedidoProveedor() {
		return idPedidoProveedor;
	}

	public void setIdPedidoProveedor(int idPedidoProveedor) {
		this.idPedidoProveedor = idPedidoProveedor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public DetallePedido getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(DetallePedido detallePedido) {
		this.detallePedido = detallePedido;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


}
