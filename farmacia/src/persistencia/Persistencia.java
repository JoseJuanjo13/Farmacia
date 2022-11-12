package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import controller.ModelFactoryController;
import modelo.DescuentoInteres;
import modelo.Farmacia;
import modelo.Presentacion;
import modelo.Producto;

public class Persistencia {

	ModelFactoryController modelFactoryController;
	Farmacia farmacia;

	static ConexionSQL conexion = new ConexionSQL();
	static Connection con = conexion.conexion();

	public Persistencia(){
		modelFactoryController = ModelFactoryController.getInstance();
		farmacia = modelFactoryController.getFarmacia();
	}


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
				//System.out.println(descuentoInteres.toString());
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
				//System.out.println(presentacion.toString());
				farmacia.getListaPresentaciones().add(presentacion);
			}

		} catch (SQLException e) {
			System.out.println("Error al cargar la presentacion de la base de datos " + e.getMessage());
		}

	}


	public static void cargarProductos(Farmacia farmacia) {
		Producto producto;
		String selectProducto = "select * from producto";
		int presentacion, descInt;
		LocalDate fechaVencimiento_;
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(selectProducto);

			while(rs.next()) {

				presentacion = rs.getInt("idPresentacion");
				descInt = rs.getInt("idDescInt");
				fechaVencimiento_ = rs.getDate("fechaVencimiento").toLocalDate();

				Presentacion presentacion_ = farmacia.obtenerPresen2(presentacion);
				DescuentoInteres descint_ = farmacia.obtenerDescInte2(descInt);

				producto = new Producto(rs.getString("id_producto"), rs.getString("nombre"),
						rs.getDouble("precio"), rs.getInt("cantidad"), fechaVencimiento_,
						presentacion_, descint_);

				farmacia.getListaProductos().add(producto);

				System.out.println(producto.toString());
			}

		} catch (SQLException e) {
			System.out.println("Error al cargar los productos de la base de datos " + e.getMessage());
		}

	}


	public static void eliminarProducto(String idProducto) {

		try {
			String deleteProducto = "delete from producto where id_producto = " + idProducto;
			Statement st = con.createStatement();

			int flag = st.executeUpdate(deleteProducto);

			if(flag >= 0) System.out.println("Producto eliminado");

		} catch (SQLException e) {
			System.out.println("Error al eliminar el producto de la base de datos " + e.getMessage());
		}
	}


	public static void actualizarProducto(String idProducto, String nombre, double precio_, int cantidad_,
			LocalDate fechaVencimiento, DescuentoInteres descinte_, Presentacion presenta_, String idP) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechaVencimiento_ = fechaVencimiento.format(formatter);

		try {
			String updateProducto = "update producto set id_producto = ?, nombre = ?, "
					+ "precio = ?, cantidad = ?, idDescInt = ?, idPresentacion = ?,"
					+ "fechaVencimiento = ? where id_producto = ?";

			PreparedStatement pst = con.prepareStatement(updateProducto);

			pst.setString(1, idProducto);
			pst.setString(2, nombre);
			pst.setDouble(3, precio_);
			pst.setInt(4, cantidad_);
			pst.setInt(5, descinte_.getIdDescInt());
			pst.setInt(6, presenta_.getIdPresentacion());
			pst.setString(7, fechaVencimiento_);
			pst.setString(8, idP);

			pst.execute();

			System.out.println("Se actualiz� el producto correctamente en la base de datos");

		} catch (SQLException e) {
			System.out.println("Error al actualizar el producto en la base de datos " + e.getMessage());
		}

	}


}
