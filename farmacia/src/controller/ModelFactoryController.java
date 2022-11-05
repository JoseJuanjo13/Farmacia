package controller;

import modelo.Farmacia;
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



}
