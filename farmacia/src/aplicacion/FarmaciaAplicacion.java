package aplicacion;

import controller.ContenedorPrincipalController;
import controller.ModelFactoryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Farmacia;

public class FarmaciaAplicacion extends Application{

	private Stage primaryStage;
	//private Banco banco;

	Farmacia farmacia;
	ModelFactoryController modelFactoryController;

	public FarmaciaAplicacion() {

		modelFactoryController = ModelFactoryController.getInstance();
		farmacia = modelFactoryController.getFarmacia();
	}


	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		//Abrir la venta principal
		mostrarVentanaPrincipal();
	}

	private void mostrarVentanaPrincipal() {
		// TODO Auto-generated method stub
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FarmaciaAplicacion.class.getResource("/views/ContenedorPrincipal.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			ContenedorPrincipalController contenedorController = loader.getController();
			contenedorController.setAplicacion(this);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}


}
