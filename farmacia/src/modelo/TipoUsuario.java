package modelo;

import java.io.Serializable;

public class TipoUsuario implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int idTipoUsuario;
	private String tipoUsuario;
	private Cliente cliente;

	public TipoUsuario(){

	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
