package modelo;

import java.io.Serializable;

public class Farmacia implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String nit;

	public Farmacia(){

	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}




}
