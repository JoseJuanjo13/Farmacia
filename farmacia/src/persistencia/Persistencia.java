package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import modelo.DescuentoInteres;
import modelo.Farmacia;
import modelo.Presentacion;

public class Persistencia {

	static ConexionSQL conexion = new ConexionSQL();
	static Connection con = conexion.conexion();


	public static void guardarProducto(String idProducto, String nombre, double precio_, int cantidad_, LocalDate fechaVencimiento,
			DescuentoInteres descinte_, Presentacion presenta_) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechaVencimiento_ = fechaVencimiento.format(formatter);

		try {
			String insertProducto = "insert into producto(id_producto, nombre, precio, cantidad, idDescInt, idPresentacion, fechaVencimiento) "
					 + "values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(insertProducto);

			pst.setString(1, idProducto);
			pst.setString(2, nombre);
			pst.setDouble(3, precio_);
			pst.setInt(4, cantidad_);
			pst.setInt(5, descinte_.getIdDescInt());
			pst.setInt(6, presenta_.getIdPresentacion());
			pst.setString(7, fechaVencimiento_);

			pst.execute();
			System.out.println("Producto almacenado correctamente en la base de datos");

		} catch (Exception e) {
			System.out.println("Error al almacenar el producto en la base de datos " + e.getMessage());
		}


	}


	public static void cargarDatosDescInte(Farmacia farmacia) {
		DescuentoInteres descuentoInteres;
		String selectDescInte = "select * from descuentointeres";

		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(selectDescInte);

			while(rs.next()) {

				descuentoInteres = new DescuentoInteres(rs.getInt("idDescInt"), rs.getString("tipo"), rs.getDouble("cantidad"));
				System.out.println(descuentoInteres.toString());
				farmacia.getListaDescuentoInteres().add(descuentoInteres);
			}

		} catch (SQLException e) {
			System.out.println("Error al cargar el desc/int de la base de datos " + e.getMessage());
		}

	}


	public static void cargarDatosPresen(Farmacia farmacia) {

		Presentacion presentacion;
		String selectPresentacion = "select * from presentacion";

		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(selectPresentacion);

			while(rs.next()) {

				presentacion = new Presentacion(rs.getInt("idPresentacion"), rs.getString("nombrePresentacion"));
				System.out.println(presentacion.toString());
				farmacia.getListaPresentaciones().add(presentacion);
			}

		} catch (SQLException e) {
			System.out.println("Error al cargar la presentacion de la base de datos " + e.getMessage());
		}

	}


}
