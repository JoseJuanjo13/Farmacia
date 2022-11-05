package controller;

import java.net.URL;
import java.util.ResourceBundle;

import aplicacion.FarmaciaAplicacion;
import javafx.fxml.FXML;
import modelo.Farmacia;
import persistencia.Persistencia;

public class ContenedorPrincipalController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	 void initialize() {

	 }


	ModelFactoryController modelFactoryController;
	Farmacia farmacia;
	FarmaciaAplicacion aplicacion;
	Persistencia persistencia;

	public ContenedorPrincipalController() {

		modelFactoryController = ModelFactoryController.getInstance();
		farmacia = modelFactoryController.getFarmacia();
	}



	public void setAplicacion(FarmaciaAplicacion farmaciaAplicacion) {

		this.aplicacion = farmaciaAplicacion;
		this.farmacia = modelFactoryController.getFarmacia();

	}
}
