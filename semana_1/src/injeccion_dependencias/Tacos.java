package injeccion_dependencias;

public class Tacos implements Receta{

	
	private String tipo;
	

	public Tacos(String tipo) {
		this.tipo = tipo;
	}

	// Prepara la orden de tacos...
	@Override
	public void preparar(Chef chef) {
		System.out.println("El chef " + chef.getNombre() + " prepara los tacos de " + tipo + " ....");
		
	}

}
