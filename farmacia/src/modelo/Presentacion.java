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


	public Presentacion(int idPresentacion, String nombrePresentacion) {
		this.idPresentacion = idPresentacion;
		this.nombrePresentacion = nombrePresentacion;
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


	@Override
	public String toString() {
		return "Presentacion [idPresentacion=" + idPresentacion + ", nombrePresentacion=" + nombrePresentacion + "]";
	}



}
