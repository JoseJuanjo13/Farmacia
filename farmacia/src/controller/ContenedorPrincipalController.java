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
    private TextField txtCedulaCliente, txtNombreCliente, txtApellidoCliente, txtTelefonoCliente, txtEmailCliente, txtCiudadCliente, txtDeptoCliente;

    private Producto productoSeleccionado;
    private Cliente clienteSeleccionado;

	ModelFactoryController modelFactoryController;
	Farmacia farmacia;
	FarmaciaAplicacion aplicacion;
	Persistencia persistencia;

    ObservableList<Producto> listadoProductos = FXCollections.observableArrayList();


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

	}


	private ObservableList<Producto> getProductos() {
		// TODO Auto-generated method stub
		listadoProductos.clear();
		listadoProductos.addAll(farmacia.getListaProductos());
		return listadoProductos;
	}
}
