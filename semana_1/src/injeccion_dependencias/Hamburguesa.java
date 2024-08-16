package injeccion_dependencias;

public class Hamburguesa implements Receta{

	
	private String tipo;
	

	public Hamburguesa(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public void preparar() {
		System.err.println("Preparando la hamburguesa tipo " + tipo + " ....");
		
	}

}
