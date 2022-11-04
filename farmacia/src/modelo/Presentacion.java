package modelo;

import java.io.Serializable;

public class Presentacion implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int idPresentacion;
	private String nombrePresentacion;

	public Presentacion(){

	}

	public int getIdPresentacion() {
		return idPresentacion;
	}

	public void setIdPresentacion(int idPresentacion) {
		this.idPresentacion = idPresentacion;
	}

	public String getNombrePresentacion() {
		return nombrePresentacion;
	}

	public void setNombrePresentacion(String nombrePresentacion) {
		this.nombrePresentacion = nombrePresentacion;
	}



}
