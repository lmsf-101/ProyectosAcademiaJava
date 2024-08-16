package injeccion_dependencias;

public class Taco implements Receta{

	
	private String tipo;
	

	public Taco(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public void preparar(Chef chef) {
		System.out.println("El chef " + chef.getNombre() + " prepara los tacos de " + tipo + " ....");
		
	}

}
