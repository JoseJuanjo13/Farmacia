package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import aplicacion.FarmaciaAplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;
import modelo.DescuentoInteres;
import modelo.Farmacia;
import modelo.Presentacion;
import modelo.Producto;
import persistencia.Persistencia;

public class ContenedorPrincipalController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

    @FXML
    private TextField txtCantidadProducto, txtPrecioProducto, txtNombreProducto, txtIdProducto;

    @FXML
    private TableView<Producto> tableViewProducto;

    @FXML
    private TableColumn<Producto, Double> columnPrecioProducto;

    @FXML
    private TableColumn<Producto, Integer> columnCantidadProducto;

    @FXML
    private TableColumn<Producto, String> columnNombreProducto;

    @FXML
    private TableColumn<Producto, LocalDate> columnFechaVencimientoProducto;

    @FXML
    private TableColumn<Producto, String> columnIdProdcuto;

    @FXML
    private ComboBox<String> boxDesInProducto;
    ObservableList<String> listaDesInProd = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> boxPresenProducto;
    ObservableList<String> listaPresen = FXCollections.observableArrayList();

    @FXML
    private DatePicker dateFecVenciProducto;

    @FXML
    private TextField txtCedulaCliente, txtNombreCliente, txtApellidoCliente, txtTelefonoCliente, txtEmailCliente, txtCiudadCliente, txtDeptoCliente, txtDireccionCliente;

    @FXML
    private TableView<Cliente> tableViewCliente;

    @FXML
    private TableColumn<Cliente, String> columnCedulaCliente, columnNombreCliente, columnApellidoCliente, columnTelefonoCliente, columnEmailCliente;


    private Producto productoSeleccionado;
    private Cliente clienteSeleccionado;

	ModelFactoryController modelFactoryController;
	Farmacia farmacia;
	FarmaciaAplicacion aplicacion;
	Persistencia persistencia;

    ObservableList<Producto> listadoProductos = FXCollections.observableArrayList();
    ObservableList<Cliente> listadoClientes = FXCollections.observableArrayList();

	public ContenedorPrincipalController() {

		modelFactoryController = ModelFactoryController.getInstance();
		farmacia = modelFactoryController.getFarmacia();
	}


	@FXML
	 void initialize() {

		for (DescuentoInteres descuentoInteres : farmacia.getListaDescuentoInteres()) {
			listaDesInProd.add(descuentoInteres.getTipo());
		}
		boxDesInProducto.setItems(listaDesInProd);

		for (Presentacion presentacion : farmacia.getListaPresentaciones()) {
			listaPresen.add(presentacion.getNombrePresentacion());
		}
		boxPresenProducto.setItems(listaPresen);

		//producto
		this.columnNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnPrecioProducto.setCellValueFactory(new PropertyValueFactory<>("precio"));
		this.columnCantidadProducto.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
		this.columnFechaVencimientoProducto.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
		this.columnIdProdcuto.setCellValueFactory(new PropertyValueFactory<>("idProducto"));

	   	tableViewProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    	    if (newSelection != null) {
    	    	productoSeleccionado = newSelection;
    	    	cargarCampos();
    	    }
    	});

	   	//cliente
	   	this.columnCedulaCliente.setCellValueFactory(new PropertyValueFactory<>("cedula"));
	   	this.columnNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
	   	this.columnApellidoCliente.setCellValueFactory(new PropertyValueFactory<>("apellido"));
	   	this.columnTelefonoCliente.setCellValueFactory(new PropertyValueFactory<>("telefono"));
	   	this.columnEmailCliente.setCellValueFactory(new PropertyValueFactory<>("email"));

	   	tableViewCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    	    if (newSelection != null) {
    	    	clienteSeleccionado = newSelection;
    	    	cargarCampos2();
    	    }
    	});

	 }


    private void cargarCampos2() {
		if(clienteSeleccionado != null)
		{
		    txtCedulaCliente.setText(clienteSeleccionado.getCedula());
	    	txtNombreCliente.setText(clienteSeleccionado.getNombre());
	    	txtApellidoCliente.setText(clienteSeleccionado.getApellido());
	    	txtTelefonoCliente.setText(clienteSeleccionado.getTelefono());
	    	txtEmailCliente.setText(clienteSeleccionado.getEmail());
	    	txtCiudadCliente.setText(clienteSeleccionado.getCiudad());
	    	txtDeptoCliente.setText(clienteSeleccionado.getDepto());
	    	txtDireccionCliente.setText(clienteSeleccionado.getDireccion());

		}else{
			mostrarMensaje("Cliente Seleccion", "Cliente Seleccion", "NO se ha seleccionado ning�n Cliente", AlertType.WARNING);
		}
	}


	private void cargarCampos() {

    		if(productoSeleccionado != null)
    		{
    			String precioD = String.valueOf(productoSeleccionado.getPrecio());
    			String cantidad = String.valueOf(productoSeleccionado.getCantidad());

    	    	txtIdProducto.setText(productoSeleccionado.getIdProducto());
    	    	txtNombreProducto.setText(productoSeleccionado.getNombre());
    	    	txtPrecioProducto.setText(precioD);
    	    	txtCantidadProducto.setText(cantidad);
    	    	dateFecVenciProducto.setValue(productoSeleccionado.getFechaVencimiento());
    	    	boxDesInProducto.setId(productoSeleccionado.getDescuentoInteres().getTipo());
    	    	boxPresenProducto.setId(productoSeleccionado.getPresentacion().getNombrePresentacion());

    		}else{
    			mostrarMensaje("Producto Seleccion", "Producto Seleccion", "NO se ha seleccionado ning�n Producto", AlertType.WARNING);
    		}

	}

  //------------------------------------------------- PRODUCTO -----------------------------------------------------------------
	@FXML
    void crearProducto(ActionEvent event) {

    	String idProducto = txtIdProducto.getText();
    	String nombre = txtNombreProducto.getText();
    	String precio = txtPrecioProducto.getText();
    	String cantidad = txtCantidadProducto.getText();
    	LocalDate fechaVencimiento = dateFecVenciProducto.getValue();
    	String descInte = boxDesInProducto.getValue();
    	String presentacion = boxPresenProducto.getValue();

    	if(verificarDatos(idProducto, nombre, precio, cantidad, fechaVencimiento, descInte, presentacion)){
    		if (farmacia.obtenerProducto(idProducto) != null) {
    			mostrarMensaje("Notificacion Usuario", "Producto No Registrado", "El id del producto se encuentra registrado", AlertType.WARNING);
			}
    		else{
    			Producto producto;
    			try {
    				producto = modelFactoryController.crearProducto(idProducto, nombre, precio, cantidad, fechaVencimiento, descInte, presentacion);

    				if (producto != null) {
    					listadoProductos.add(0, producto);
    					mostrarMensaje("Notificacion Usuario", "Producto Registrado", "El Producto ha sido registrado", AlertType.INFORMATION);
    					limpiarRegistros();
    				}else{
    					mostrarMensaje("Notificacion Usuario", "Producto No Registrado", "El Producto no ha sido registrado", AlertType.WARNING);
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }

	@FXML
    void actualizarProducto(ActionEvent event) {

    	String idProducto = txtIdProducto.getText();
    	String nombre = txtNombreProducto.getText();
    	String precio = txtPrecioProducto.getText();
    	String cantidad = txtCantidadProducto.getText();
    	LocalDate fechaVencimiento = dateFecVenciProducto.getValue();
    	String descInte = boxDesInProducto.getValue();
    	String presentacion = boxPresenProducto.getValue();

		if(productoSeleccionado != null){
			if(verificarDatos(idProducto, nombre, precio, cantidad, fechaVencimiento, descInte, presentacion))
			{
				try {
					modelFactoryController.actualizarProducto(idProducto, nombre, precio, cantidad, fechaVencimiento, descInte, presentacion, productoSeleccionado.getIdProducto());
					productoSeleccionado.setIdProducto(idProducto);
					productoSeleccionado.setNombre(nombre);
					double precio_ = Double.valueOf(precio);
					productoSeleccionado.setPrecio(precio_);
					int cantidad_ = Integer.valueOf(cantidad);
					productoSeleccionado.setCantidad(cantidad_);
					productoSeleccionado.setFechaVencimiento(fechaVencimiento);
					DescuentoInteres descInte_ = farmacia.obtenerDescInte(descInte);
					productoSeleccionado.setDescuentoInteres(descInte_);
					Presentacion presentacion_ = farmacia.obtenerPresen(presentacion);
					productoSeleccionado.setPresentacion(presentacion_);

					tableViewProducto.refresh();
					limpiarRegistros();

					mostrarMensaje("Notificacion Usuario", "Producto Actualizado", "El Producto "+ idProducto +" ha sido actualizado exitosamente", AlertType.INFORMATION);
					//limpiarRegistros();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			mostrarMensaje("Producto Seleccion", "Producto Seleccion", "NO se ha seleccionado ning�n Producto", AlertType.WARNING);
		}


    }

    @FXML
    void eliminarProducto(ActionEvent event) {

    	if(productoSeleccionado != null){
			 int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Desea eliminar el producto "+productoSeleccionado.getIdProducto());
			 if(showConfirmDialog == 0){
				 try {
					if(modelFactoryController.eliminarProducto(productoSeleccionado.getIdProducto())){
						mostrarMensaje("Producto Eliminado", "Producto Eliminado", "El Producto ha sido eliminado", AlertType.WARNING);
					 }else{
						 mostrarMensaje("Producto Seleccion", "Producto Seleccion", "NO se ha seleccionado ning�n Producto", AlertType.INFORMATION);
					 }
				 listadoProductos.remove(productoSeleccionado);
				 limpiarRegistros();
				 tableViewProducto.refresh();;
				 } catch (Exception e){
					e.printStackTrace();
				 }
			}
		}else{
			mostrarMensaje("Producto Seleccion", "Producto Seleccion", "NO se ha seleccionado ning�n Producto", AlertType.WARNING);
		}

    }

	private void limpiarRegistros() {

    	txtIdProducto.clear(); txtNombreProducto.clear(); txtPrecioProducto.clear(); txtCantidadProducto.clear();
    	dateFecVenciProducto.setValue(null); boxDesInProducto.setValue(null); boxPresenProducto.setValue(null);
    	txtCedulaCliente.clear(); txtNombreCliente.clear();txtApellidoCliente.clear();txtTelefonoCliente.clear();
    	txtEmailCliente.clear();txtCiudadCliente.clear();txtDeptoCliente.clear();txtDireccionCliente.clear();
	}

    private boolean verificarDatos(String idProducto, String nombre, String precio, String cantidad, LocalDate fechaVencimiento,
 			String descInte, String presentacion) {
 		// TODO Auto-generated method stub
     	String notificacion = "";

     	if (idProducto== null || idProducto.equals("")) {
			notificacion += "El identificador producto es invalido\n";
		}
 		if(nombre == null || nombre.equals("")){
 			notificacion += "El nombre es invalido\n";
 		}
 		if(precio == null || precio.equals("")){
 			notificacion += "El precio es invalido\n";
 		}
 		if(cantidad == null || cantidad.equals("")){
 			notificacion += "La cantidad es invalida\n";
 		}
 		if(fechaVencimiento == null || fechaVencimiento.equals("")){
 			notificacion += "La fecha vencimiento es invalida\n";
 		}
 		if(descInte == null || descInte.equals("")){
 			notificacion += "El descuento o interes es invalido\n";
 		}
 		if(presentacion == null || presentacion.equals("")){
 			notificacion += "La presentacion es invalida\n";
 		}
 		if(notificacion.equals("")){
 			return true;
 		}

 		mostrarMensaje("Notificacion Producto", "Informacion del producto invalido", notificacion, AlertType.WARNING);


 		return false;
 	}

//------------------------------------------------- CLIENTE -----------------------------------------------------------------
    @FXML
    void crearCliente(ActionEvent event) {

    	String cedula = txtCedulaCliente.getText();
    	String nombre = txtNombreCliente.getText();
    	String apellido = txtApellidoCliente.getText();
    	String telefono = txtTelefonoCliente.getText();
    	String email = txtEmailCliente.getText();
    	String ciudad = txtCiudadCliente.getText();
    	String depto = txtDeptoCliente.getText();
    	String direccion = txtDireccionCliente.getText();

    	if(verificarDatosC(cedula, nombre, apellido, direccion, telefono, email, ciudad, depto)){

    		if (farmacia.obtenerCliente(cedula) != null) {
    			mostrarMensaje("Notificacion Usuario", "Cliente No Registrado", "La cedula se encuentra registrado", AlertType.WARNING);
			}
    		else{
        		Cliente cliente;
        		try {
    				cliente = modelFactoryController.crearCliente(cedula, nombre, apellido, direccion, telefono, email, ciudad, depto);
    				if (cliente != null) {
    					listadoClientes.add(0, cliente);
    					mostrarMensaje("Notificacion Usuario", "Cliente Registrado", "El Cliente ha sido registrado", AlertType.INFORMATION);
    					limpiarRegistros();
    				}else{
    					mostrarMensaje("Notificacion Usuario", "Cliente No Registrado", "El Cliente no ha sido registrado", AlertType.WARNING);
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}

    }

    @FXML
    void actualizarCliente(ActionEvent event) {

    	String cedula = txtCedulaCliente.getText();
    	String nombre = txtNombreCliente.getText();
    	String apellido = txtApellidoCliente.getText();
    	String telefono = txtTelefonoCliente.getText();
    	String email = txtEmailCliente.getText();
    	String ciudad = txtCiudadCliente.getText();
    	String depto = txtDeptoCliente.getText();
    	String direccion = txtDireccionCliente.getText();

		if(clienteSeleccionado != null){
			if(verificarDatosC(cedula, nombre, apellido, direccion, telefono, email, ciudad, depto))
			{
				try {
					modelFactoryController.actualizarCliente(cedula, nombre, apellido, direccion, telefono, email, ciudad, depto, clienteSeleccionado.getCedula());
					clienteSeleccionado.setCedula(cedula);
					clienteSeleccionado.setNombre(nombre);
					clienteSeleccionado.setApellido(apellido);
					clienteSeleccionado.setTelefono(telefono);
					clienteSeleccionado.setEmail(email);
					clienteSeleccionado.setCiudad(ciudad);
					clienteSeleccionado.setDepto(depto);

					tableViewCliente.refresh();
					limpiarRegistros();

					mostrarMensaje("Notificacion Usuario", "Cliente Actualizado", "El Cliente "+ cedula +" ha sido actualizado exitosamente", AlertType.INFORMATION);
					//limpiarRegistros();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			mostrarMensaje("Cliente Seleccion", "Cliente Seleccion", "NO se ha seleccionado ning�n Cliente", AlertType.WARNING);
		}

    }

    @FXML
    void eliminarCliente(ActionEvent event) {

    	if(clienteSeleccionado != null){
			 int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente "+clienteSeleccionado.getCedula());
			 if(showConfirmDialog == 0){
				 try {
					if(modelFactoryController.eliminarCliente(clienteSeleccionado.getCedula())){
						mostrarMensaje("Cliente Eliminado", "Cliente Eliminado", "El Cliente ha sido eliminado", AlertType.WARNING);
					 }else{
						 mostrarMensaje("Cliente Seleccion", "Cliente Seleccion", "NO se ha seleccionado ning�n Cliente", AlertType.INFORMATION);
					 }
				 listadoClientes.remove(clienteSeleccionado);
				 limpiarRegistros();
				 tableViewCliente.refresh();;
				 } catch (Exception e){
					e.printStackTrace();
				 }
			}
		}else{
			mostrarMensaje("Cliente Seleccion", "Cliente Seleccion", "NO se ha seleccionado ning�n Cliente", AlertType.WARNING);
		}


    }

	private boolean verificarDatosC(String cedula, String nombre, String apellido, String direccion, String telefono, String email,
		String ciudad, String depto) {
     	String notificacion = "";

     	if (cedula== null || cedula.equals("")) {
			notificacion += "La cedula es invalida\n";
		}
 		if(nombre == null || nombre.equals("")){
 			notificacion += "El nombre es invalido\n";
 		}
 		if(apellido == null || apellido.equals("")){
 			notificacion += "El apellido es invalido\n";
 		}
 		if(telefono == null || telefono.equals("")){
 			notificacion += "El telefono es invalido\n";
 		}
 		if(email == null || email.equals("")){
 			notificacion += "El email es invalido\n";
 		}
 		if(ciudad == null || ciudad.equals("")){
 			notificacion += "La ciudad es invalida\n";
 		}
 		if(depto == null || depto.equals("")){
 			notificacion += "El departamento es invalido\n";
 		}
 		if (direccion == null || direccion.equals("")) {
 			notificacion += "La direccion es invalida\n";
		}
 		if(notificacion.equals("")){
 			return true;
 		}

 		mostrarMensaje("Notificacion Cliente", "Informacion del cliente invalido", notificacion, AlertType.WARNING);


 		return false;
}


	private void mostrarMensaje(String titulo,String header,String contenido,AlertType alertType) {
		Alert alert = new Alert(alertType);
       	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
	}

	public void setAplicacion(FarmaciaAplicacion farmaciaAplicacion) {

		this.aplicacion = farmaciaAplicacion;
		this.farmacia = modelFactoryController.getFarmacia();

		//producto
		tableViewProducto.getItems().clear();
		tableViewProducto.setItems(getProductos());

		//cliente
		tableViewCliente.getItems().clear();
		tableViewCliente.setItems(getClientes());

	}


	private ObservableList<Cliente> getClientes() {
		// TODO Auto-generated method stub
		listadoClientes.clear();
		listadoClientes.addAll(farmacia.getListaClientes());
		return listadoClientes;
	}


	private ObservableList<Producto> getProductos() {
		// TODO Auto-generated method stub
		listadoProductos.clear();
		listadoProductos.addAll(farmacia.getListaProductos());
		return listadoProductos;
	}
}
