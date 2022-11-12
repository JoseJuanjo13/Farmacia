package modelo;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido;
	private String cedula;
	private String direccion;
	private String telefono;
	private String email;
	private String ciudad;
	private String depto;

	public Cliente(){

	}


	public Cliente(String cedula, String nombre, String apellido, String direccion, String telefono, String email,
			String ciudad, String depto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.ciudad = ciudad;
		this.depto = depto;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}


	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", direccion="
				+ direccion + ", telefono=" + telefono + ", email=" + email + ", ciudad=" + ciudad + ", depto=" + depto
				+ "]";
	}





}
