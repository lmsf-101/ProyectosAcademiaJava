package injeccion_dependencias;

public interface Receta {
	
	void preparar();
	
	static void prepararComida()
	{
		System.out.println("Preparando la comida...");
	}
}
