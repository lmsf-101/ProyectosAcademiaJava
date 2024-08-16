package singleton;

public class SistemaLogros {
	
	// Inicializar la única instancia estática de SistemaLogros:
	private static SistemaLogros sistemaLogros = new SistemaLogros();
	
	// Declarar un arreglo de logros que puede ganar el jugador: 
	private Logro[] logros;
	
	// CONSTRUCTOR PRIVADO:
	private SistemaLogros() {
		
		// Definir los titulos de los logros:
		String[] titulos = {
			"100% Completado",
			"El mejor de todos",
			"Mega-Combo!",
			"De poco a poco...",
			"Perfeccionista",
			"Por los pelos!"
		};
		
		// Inicializar el arreglo de logros:
		logros = new Logro[titulos.length];
		
		// Para cada uno de los titulos definidos anteriormente,
		// agregarlas al arreglo con un ID único:
		for(int i = 0; i < titulos.length; i++)
		{
			logros[i] = new Logro(i, titulos[i]);
		}
	}
	
	
	
	// Función para recuperar el número de logros disponibles en el juego: 
	int getNumLogros() {
		return logros.length;
	}

	// Función que retorna la única instancia de la clase:
	public static SistemaLogros getInstance()
	{	
		return sistemaLogros;
	}
	
	
	// Función para recompensar un logro al jugador correspondiente, de acuerdo con ID:
	void anadirLogro(Jugador jugador, int logroID)
	{
			System.out.println("El usuario " + jugador.getUsuario() + 
					" ganó un logro! : "+ logros[logroID].getTitulo() );

	}
	
}
