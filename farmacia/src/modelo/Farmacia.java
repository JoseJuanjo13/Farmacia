package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Farmacia implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String nit;

	private ArrayList<Producto> listaProductos;
	private ArrayList<Presentacion> listaPresentaciones;
	private ArrayList<DescuentoInteres> listaDescuentoInteres;

	public Farmacia(){

		this.listaProductos = new ArrayList<>();
		this.listaDescuentoInteres = new ArrayList<>();
		this.listaPresentaciones = new ArrayList<>();
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ArrayList<Presentacion> getListaPresentaciones() {
		return listaPresentaciones;
	}

	public void setListaPresentaciones(ArrayList<Presentacion> listaPresentaciones) {
		this.listaPresentaciones = listaPresentaciones;
	}

	public ArrayList<DescuentoInteres> getListaDescuentoInteres() {
		return listaDescuentoInteres;
	}

	public void setListaDescuentoInteres(ArrayList<DescuentoInteres> listaDescuentoInteres) {
		this.listaDescuentoInteres = listaDescuentoInteres;
	}

	public Producto agregarProducto(String idProducto, String nombre, String precio, String cantidad, LocalDate fechaVencimiento,
			String descInte, String presentacion) {

		DescuentoInteres descuentoInteres = obtenerDescInte(descInte);
		Presentacion presentacion_ = obtenerPresen(presentacion);
		double precio_ = Double.valueOf(precio);
		int cantidad_ = Integer.valueOf(cantidad);

		Producto producto = new Producto(idProducto, nombre, precio_, cantidad_, fechaVencimiento,presentacion_,descuentoInteres);
		listaProductos.add(producto);

		return producto;
	}


	public Presentacion obtenerPresen(String presentacion) {
		for (Presentacion presentacion_ : listaPresentaciones) {
			if(presentacion_.getNombrePresentacion().equalsIgnoreCase(presentacion))
				return presentacion_;
		}
		return null;
	}

	public DescuentoInteres obtenerDescInte(String descInte) {

		for (DescuentoInteres descuentoInteres : listaDescuentoInteres) {
			if(descuentoInteres.getTipo().equalsIgnoreCase(descInte))
				return descuentoInteres;
		}

		return null;

	}




}
