package injeccion_dependencias;

public class Taco implements Receta{

	
	private String tipo;
	

	public Taco(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public void preparar() {
		System.err.println("Preparando los tacos de " + tipo + " ....");
		
	}

}
