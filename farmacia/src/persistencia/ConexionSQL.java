package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {


	Connection conectar = null;

	public Connection conexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conectar = DriverManager.getConnection("jdbc:mysql://localhost/farmacia", "root", "admin");

			System.out.println("Conexi�n exitosa");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error de Conexi�n " + e.getMessage() );
		}
		return conectar;
	}

}
