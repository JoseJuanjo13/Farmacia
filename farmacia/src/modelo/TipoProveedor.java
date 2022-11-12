package modelo;

import java.io.Serializable;

public class TipoProveedor implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int idTipoProveedor;
	private String tipoProveedor;

	public TipoProveedor() {

	}

	public TipoProveedor(int idTipoProveedor, String tipoProveedor) {
		super();
		this.idTipoProveedor = idTipoProveedor;
		this.tipoProveedor = tipoProveedor;
	}

	public int getIdTipoProveedor() {
		return idTipoProveedor;
	}

	public void setIdTipoProveedor(int idTipoProveedor) {
		this.idTipoProveedor = idTipoProveedor;
	}

	public String getTipoProveedor() {
		return tipoProveedor;
	}

	public void setTipoProveedor(String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}




}
