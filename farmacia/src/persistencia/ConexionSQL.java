package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {

	private static final String CONTROLADOR= "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/farmacia";
	private static final String USUARIO = "root";
	private static final String CLAVE = "r00t";

	public Connection conexion() {

		Connection conectar = null;

		try {
			Class.forName(CONTROLADOR);
			conectar = DriverManager.getConnection(URL, USUARIO, CLAVE);

			System.out.println("Conexi�n exitosa");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error de Conexi�n " + e.getMessage() );
		}
		return conectar;
	}

}
