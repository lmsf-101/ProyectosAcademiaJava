package injeccion_dependencias;

public class Hamburguesa implements Receta{

	
	private String tipo;
	

	public Hamburguesa(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public void preparar(Chef chef) {
		System.out.println("El chef " + chef.getNombre() + " prepara la hamburguesa tipo " + tipo + " ....");
		
	}

}
