package injeccion_dependencias;

public class Pizza implements Receta{

	
	private String tipo;
	

	public Pizza(String tipo) {
		this.tipo = tipo;
	}

	// Prepara la pizza...
	@Override
	public void preparar(Chef chef) {
		System.out.println("El chef " + chef.getNombre() +" prepara la pizza " + tipo + " ...");
		
	}

}
