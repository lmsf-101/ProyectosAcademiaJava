package injeccion_dependencias;

public class Pizza implements Receta{

	
	private String tipo;
	

	public Pizza(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public void preparar(Chef chef) {
		System.out.println("El chef " + chef.getNombre() +" prepara la pizza " + tipo + " ...");
		
	}

}
