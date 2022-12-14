package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Producto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String idProducto;
	private String nombre;
	private double precio;
	private int cantidad;
	private LocalDate fechaVencimiento;
	private Presentacion presentacion;
	private DescuentoInteres descuentoInteres;

	public Producto(){

	}

	public Producto(String idProducto, String nombre, double precio, int cantidad, LocalDate fechaVencimiento, Presentacion presentacion,
			DescuentoInteres descuentoInteres) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fechaVencimiento = fechaVencimiento;
		this.presentacion = presentacion;
		this.descuentoInteres = descuentoInteres;
	}


	public Producto(String idProducto, String nombre, double precio, int cantidad, LocalDate fechaVencimiento) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fechaVencimiento = fechaVencimiento;
	}



	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Presentacion getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public DescuentoInteres getDescuentoInteres() {
		return descuentoInteres;
	}

	public void setDescuentoInteres(DescuentoInteres descuentoInteres) {
		this.descuentoInteres = descuentoInteres;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", cantidad="
				+ cantidad + ", fechaVencimiento=" + fechaVencimiento + ", presentacion=" + presentacion
				+ ", descuentoInteres=" + descuentoInteres + "]";
	}



}
