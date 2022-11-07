package persistencia;

import java.sql.Connection;

public class Persistencia {

	static ConexionSQL conexion = new ConexionSQL();
	static Connection con = conexion.conexion();


}
