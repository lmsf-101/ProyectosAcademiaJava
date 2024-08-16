package injeccion_dependencias;

public class Chef {

	private String nombre;
	
	public Chef(String nombre) {
		this.nombre = nombre;
	}
	
	// objeto Receta que pueda requerir el chef:
	private Receta receta;

	// INYECCIÓN DE DEPENDENCIA MEDIANTE SETTER:
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
	// Preparar la comida con la receta proporcionada al chef:
	public void prepararComida()
	{
		// Intenta preparar la comida:
		try {
			receta.preparar(this);
			
	    // Si no tiene una receta con la que trabajar, envía un mensaje de error:
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
