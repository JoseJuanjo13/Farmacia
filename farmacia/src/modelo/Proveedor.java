package modelo;

import java.io.Serializable;

public class Proveedor implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String nit;
	private String nombreEmpresa;
	private TipoProveedor tipoProveedor;

	public Proveedor(){

	}


	public Proveedor(String nit, String nombreEmpresa, TipoProveedor tipoProveedor) {
		this.nit = nit;
		this.nombreEmpresa = nombreEmpresa;
		this.tipoProveedor = tipoProveedor;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public TipoProveedor getTipoProveedor() {
		return tipoProveedor;
	}

	public void setTipoProveedor(TipoProveedor tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}


}
