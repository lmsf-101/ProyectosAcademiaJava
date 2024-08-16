package injeccion_dependencias;

public class Pizza implements Receta{

	
	private String tipo;
	

	public Pizza(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public void preparar() {
		System.err.println("Preparando la pizza " + tipo + " ...");
		
	}

}
