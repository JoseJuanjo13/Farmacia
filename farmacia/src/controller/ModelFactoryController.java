package controller;

import java.time.LocalDate;

import modelo.DescuentoInteres;
import modelo.Farmacia;
import modelo.Presentacion;
import modelo.Producto;
import persistencia.Persistencia;

public class ModelFactoryController implements Runnable {

	Farmacia farmacia;
	Persistencia persistencia;

	//-------------------------Singleton---------------------------------------------------
	//Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder{
		//El constructor de Singleton puede ser llamado desde aqui al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	//Metodo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		System.out.println("invocacion clase singleton");
		inicializarDatos();
	}

	private void inicializarDatos() {
		// TODO Auto-generated method stub
		farmacia = new Farmacia();

		Persistencia.cargarDatosDescInte(farmacia);
		Persistencia.cargarDatosPresen(farmacia);
		Persistencia.cargarProductos(farmacia);
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public Producto crearProducto(String idProducto, String nombre, String precio, String cantidad, LocalDate fechaVencimiento,
			String descInte, String presentacion) {

		Producto producto = farmacia.agregarProducto(idProducto, nombre, precio, cantidad, fechaVencimiento, descInte, presentacion);

		DescuentoInteres descinte_ = farmacia.obtenerDescInte(descInte);
		Presentacion presenta_ = farmacia.obtenerPresen(presentacion);
		double precio_ = Double.valueOf(precio);
		int cantidad_ = Integer.valueOf(cantidad);

		Persistencia.guardarProducto(idProducto, nombre, precio_, cantidad_, fechaVencimiento, descinte_, presenta_);


		return producto;
	}

	public boolean eliminarProducto(String idProducto) {

		if (farmacia.eliminarProducto(idProducto)) {
			Persistencia.eliminarProducto(idProducto);
			return true;
		}

		return false;
	}

	public void actualizarProducto(String idProducto, String nombre, String precio, String cantidad,
			LocalDate fechaVencimiento, String descInte, String presentacion, String idP) throws Exception {

		farmacia.actualizarProducto(idProducto, nombre, precio, cantidad, fechaVencimiento, descInte, presentacion, idP);

		DescuentoInteres descinte_ = farmacia.obtenerDescInte(descInte);
		Presentacion presenta_ = farmacia.obtenerPresen(presentacion);
		double precio_ = Double.valueOf(precio);
		int cantidad_ = Integer.valueOf(cantidad);

		Persistencia.actualizarProducto(idProducto, nombre, precio_, cantidad_, fechaVencimiento, descinte_, presenta_, idP);

	}



}
