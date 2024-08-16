package injeccion_dependencias;

public class Chef {

	private String nombre;
	
	public Chef(String nombre) {
		this.nombre = nombre;
	}
	
	private Receta receta;

	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
	public void prepararComida()
	{
		try {
			receta.preparar(this);
		} catch(NullPointerException e) {
			System.err.println("El chef "+ nombre + " no tiene una receta con que trabajar...");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
