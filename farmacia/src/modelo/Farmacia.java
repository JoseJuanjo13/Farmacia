package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Farmacia implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String nit;

	private ArrayList<Producto> listaProductos =  new ArrayList<>();
	private ArrayList<Presentacion> listaPresentaciones = new ArrayList<>();
	private ArrayList<DescuentoInteres> listaDescuentoInteres = new ArrayList<>();
	private ArrayList<Cliente> listaClientes = new ArrayList<>();
	private ArrayList<TipoProveedor> listaTipoProveedores = new ArrayList<>();
	private ArrayList<Proveedor> listaProveedores = new ArrayList<>();
	private ArrayList<Ciudad> listaCiudades = new ArrayList<>();
	private ArrayList<Sucursal> listaSucursales = new ArrayList<>();

	public Farmacia(){

	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ArrayList<Presentacion> getListaPresentaciones() {
		return listaPresentaciones;
	}

	public void setListaPresentaciones(ArrayList<Presentacion> listaPresentaciones) {
		this.listaPresentaciones = listaPresentaciones;
	}

	public ArrayList<DescuentoInteres> getListaDescuentoInteres() {
		return listaDescuentoInteres;
	}

	public void setListaDescuentoInteres(ArrayList<DescuentoInteres> listaDescuentoInteres) {
		this.listaDescuentoInteres = listaDescuentoInteres;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public ArrayList<TipoProveedor> getListaTipoProveedores() {
		return listaTipoProveedores;
	}

	public void setListaTipoProveedores(ArrayList<TipoProveedor> listaTipoProveedores) {
		this.listaTipoProveedores = listaTipoProveedores;
	}

	public ArrayList<Proveedor> getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public ArrayList<Ciudad> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(ArrayList<Ciudad> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

	public ArrayList<Sucursal> getListaSucursales() {
		return listaSucursales;
	}

	public void setListaSucursales(ArrayList<Sucursal> listaSucursales) {
		this.listaSucursales = listaSucursales;
	}

	public Producto agregarProducto(String idProducto, String nombre, String precio, String cantidad, LocalDate fechaVencimiento,
			String descInte, String presentacion) {

		DescuentoInteres descuentoInteres = obtenerDescInte(descInte);
		Presentacion presentacion_ = obtenerPresen(presentacion);
		double precio_ = Double.valueOf(precio);
		int cantidad_ = Integer.valueOf(cantidad);

		Producto producto = new Producto(idProducto, nombre, precio_, cantidad_, fechaVencimiento,presentacion_,descuentoInteres);
		listaProductos.add(producto);

		return producto;
	}


	public Presentacion obtenerPresen(String presentacion) {
		for (Presentacion presentacion_ : listaPresentaciones) {
			if(presentacion_.getNombrePresentacion().equalsIgnoreCase(presentacion))
				return presentacion_;
		}
		return null;
	}

	public Presentacion obtenerPresen2(Integer presentacion) {
		for (Presentacion presentacion_ : listaPresentaciones) {
			if(presentacion_.getIdPresentacion() == presentacion)
				return presentacion_;
		}
		return null;
	}

	public DescuentoInteres obtenerDescInte(String descInte) {
		for (DescuentoInteres descuentoInteres : listaDescuentoInteres) {
			if(descuentoInteres.getTipo().equalsIgnoreCase(descInte))
				return descuentoInteres;
		}
		return null;
	}

	public DescuentoInteres obtenerDescInte2(Integer descInte) {

		for (DescuentoInteres descuentoInteres : listaDescuentoInteres) {
			if(descuentoInteres.getIdDescInt() == descInte)
				return descuentoInteres;
		}
		return null;
	}

	public boolean eliminarProducto(String idProducto) {
		boolean productoEliminado = false;
		Producto producto = obtenerProducto(idProducto);

		if(producto != null) {
			getListaProductos().remove(producto);
			productoEliminado = true;
		}
		return productoEliminado;
	}

	public Producto obtenerProducto(String idProducto) {
		for (Producto producto : listaProductos) {
			if(producto.getIdProducto().equalsIgnoreCase(idProducto))
				return producto;
		}
		return null;
	}

	public Producto actualizarProducto(String idProducto, String nombre, String precio, String cantidad,
			LocalDate fechaVencimiento, String descInte, String presentacion, String idP)  {

		DescuentoInteres descuentoInteres = obtenerDescInte(descInte);
		Presentacion presentacion_ = obtenerPresen(presentacion);
		double precio_ = Double.valueOf(precio);
		int cantidad_ = Integer.valueOf(cantidad);

		Producto producto = obtenerProducto(idP);

		System.out.println(producto.toString());

		if(producto != null) {
			producto.setIdProducto(idProducto);
			producto.setNombre(nombre);
			producto.setPrecio(precio_);
			producto.setCantidad(cantidad_);
			producto.setFechaVencimiento(fechaVencimiento);
			producto.setDescuentoInteres(descuentoInteres);
			producto.setPresentacion(presentacion_);

		}

		return producto;
	}

	public Cliente agregarCliente(String cedula, String nombre, String apellido, String direccion, String telefono, String email,
			String ciudad, String depto) {
		// TODO Auto-generated method stub

		Cliente cliente = new Cliente(cedula, nombre, apellido, direccion, telefono, email, ciudad, depto);
		listaClientes.add(cliente);

		return cliente;
	}

	public boolean eliminarCliente(String cedula) {
		boolean clienteEliminado = false;
		Cliente cliente = obtenerCliente(cedula);

		if(cliente != null) {
			getListaClientes().remove(cliente);
			clienteEliminado = true;
		}
		return clienteEliminado;
	}

	public Cliente obtenerCliente(String cedula) {
		for (Cliente cliente : listaClientes) {
			if(cliente.getCedula().equalsIgnoreCase(cedula))
				return cliente;
		}
		return null;
	}

	public Cliente actualizarCliente(String cedula, String nombre, String apellido, String direccion, String telefono,
			String email, String ciudad, String depto, String cedu) {

		Cliente cliente = obtenerCliente(cedu);

		System.out.println(cliente.toString());

		if(cliente != null) {
			cliente.setCedula(cedula);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setDireccion(direccion);
			cliente.setTelefono(telefono);
			cliente.setEmail(email);
			cliente.setCiudad(ciudad);
			cliente.setDepto(depto);
		}

		return cliente;
	}

	public Proveedor obtenerProveedor(String nit) {
		for (Proveedor proveedor : listaProveedores) {
			if(proveedor.getNit().equalsIgnoreCase(nit))
				return proveedor;
		}
		return null;
	}

	public Proveedor agregarProveedor(String nit, String nombreProveedor, String tipoProveedor) {

		TipoProveedor tipoProveedor_ = obtenerTipoProveedor(tipoProveedor);

		Proveedor proveedor = new Proveedor(nit, nombreProveedor, tipoProveedor_);
		listaProveedores.add(proveedor);

		return proveedor;

	}

	public TipoProveedor obtenerTipoProveedor(String tipoProveedor) {
		for (TipoProveedor tipoProveedor_ : listaTipoProveedores) {
			if(tipoProveedor_.getTipoProveedor().equalsIgnoreCase(tipoProveedor))
				return tipoProveedor_;
		}
		return null;
	}


	public TipoProveedor obtenerTipoProveedor2(Integer tipoProveedor) {
		for (TipoProveedor tipoProveedor_ : listaTipoProveedores) {
			if(tipoProveedor_.getIdTipoProveedor() == tipoProveedor)
				return tipoProveedor_;
		}
		return null;
	}

	public boolean eliminarProveedor(String nit) {
		boolean proveedorEliminado = false;
		Proveedor proveedor = obtenerProveedor(nit);

		if(proveedor != null) {
			getListaProveedores().remove(proveedor);
			proveedorEliminado = true;
		}
		return proveedorEliminado;
	}

	public Proveedor actualizarProveedor(String nit, String nombreProveedor, String tipoProveedor, String nitA) {

		Proveedor proveedor = obtenerProveedor(nitA);
		TipoProveedor tipoProv_ = obtenerTipoProveedor(tipoProveedor);

		if(proveedor != null) {
			proveedor.setNit(nitA);
			proveedor.setNombreEmpresa(nombreProveedor);
			proveedor.setTipoProveedor(tipoProv_);

		}

		return proveedor;

	}

	public Producto obtenerMedicamento(String codigoProd) {
		for (Producto producto : listaProductos) {
			if(producto.getIdProducto().equalsIgnoreCase(codigoProd))
				return producto;
		}
		return null;
	}


	public Sucursal obtenerSucursal(String sucursalNombre) {
		for (Sucursal sucursal : listaSucursales) {
			if(sucursal.getNombre().equals(sucursalNombre))
				return sucursal;
		}
		return null;
	}

	public Ciudad obtenerCiudad(int ciudad_) {
		for (Ciudad ciudad : listaCiudades) {
			if(ciudad.getIdCiudad() == ciudad_)
				return ciudad;
		}
		return null;
	}

	public Ciudad obtenerCiudad2(String ciudad_) {
		for (Ciudad ciudad : listaCiudades) {
			if(ciudad.getNombre().equalsIgnoreCase(ciudad_))
				return ciudad;
		}
		return null;
	}

	public Sucursal agregarSucursal(String nombre, String telefono, Proveedor proveedor, Ciudad ciudad_) {

		Sucursal sucursal = new Sucursal(nombre, telefono, proveedor, ciudad_);

		listaSucursales.add(sucursal);

		return sucursal;
	}

	public Sucursal actualizarSucursal(String nombre, String telefono, Proveedor proveedor, Ciudad ciudad,
			String nombre_) {

		Sucursal sucursal = obtenerSucursal(nombre_);

		if(sucursal != null) {
			sucursal.setNombre(nombre);
			sucursal.setTelefono(telefono);
			sucursal.setProveedor(proveedor);
			sucursal.setCiudad(ciudad);
		}

		return sucursal;

	}

	public boolean eliminarSucursal(String nombre) {
		boolean sucursalEliminado = false;
		Sucursal sucursal = obtenerSucursal(nombre);

		if(sucursal != null) {
			getListaSucursales().remove(sucursal);
			sucursalEliminado = true;
		}
		return sucursalEliminado;
	}



}
