package modelo;

import java.io.Serializable;

public class Sucursal implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int idSucursal;
	private String nombre;
	private String telefono;
	private Proveedor proveedor;
	private Ciudad ciudad;

	public Sucursal()
	{

	}

	public Sucursal(int idSucursal, String nombre, String telefono, Proveedor proveedor, Ciudad ciudad) {
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.telefono = telefono;
		this.proveedor = proveedor;
		this.ciudad = ciudad;
	}

	public Sucursal(String nombre, String telefono, Proveedor proveedor, Ciudad ciudad) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.proveedor = proveedor;
		this.ciudad = ciudad;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", nombre=" + nombre + ", telefono=" + telefono + ", proveedor="
				+ proveedor + ", ciudad=" + ciudad + "]";
	}



}
