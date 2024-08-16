package injeccion_dependencias;

public class Chef {

	
	private Receta receta;

	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
	public void prepararComida()
	{
		receta.preparar();
		
		
	}
	
}
