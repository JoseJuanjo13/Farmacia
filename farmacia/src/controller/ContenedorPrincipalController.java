package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import aplicacion.FarmaciaAplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
    private TextField txtCantidadProducto;

    @FXML
    private TextField txtPrecioProducto;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtIdProducto;

    @FXML
    private ComboBox<String> boxDesInProducto;
    ObservableList<String> listaDesInProd = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> boxPresenProducto;
    ObservableList<String> listaPresen = FXCollections.observableArrayList();

    @FXML
    private DatePicker dateFecVenciProducto;

	ModelFactoryController modelFactoryController;
	Farmacia farmacia;
	FarmaciaAplicacion aplicacion;
	Persistencia persistencia;

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


	 }



    @FXML
    void crearProducto(ActionEvent event) {

    	String idProducto = txtIdProducto.getText();
    	String nombre = txtNombreProducto.getText();
    	String precio = txtPrecioProducto.getText();
    	String cantidad = txtCantidadProducto.getText();
    	LocalDate fechaVencimiento = dateFecVenciProducto.getValue();
    	String descInte = boxDesInProducto.getValue();
    	String presentacion = boxPresenProducto.getValue();

    	if(verificarDatos(nombre, precio, cantidad, fechaVencimiento, descInte, presentacion)){

    		Producto producto;
    		try {
				producto = modelFactoryController.crearProducto(idProducto, nombre, precio, cantidad, fechaVencimiento, descInte, presentacion);

				if (producto != null) {
					//listadoClientes.add(0, cliente);
					mostrarMensaje("Notificacion Usuario", "Producto Registrado", "El Producto ha sido registrado", AlertType.INFORMATION);
					//limpiarRegistros();
				}else{
					mostrarMensaje("Notificacion Usuario", "Producto No Registrado", "El Producto no ha sido registrado", AlertType.WARNING);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}

    }

    private boolean verificarDatos(String nombre, String precio, String cantidad, LocalDate fechaVencimiento,
			String descInte, String presentacion) {
		// TODO Auto-generated method stub
    	String notificacion = "";

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





	@FXML
    void actualizarProducto(ActionEvent event) {

    }

    @FXML
    void eliminarProducto(ActionEvent event) {

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

	}
}
