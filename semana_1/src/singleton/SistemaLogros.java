package singleton;

public class SistemaLogros {
	
	private static SistemaLogros sistemaLogros = new SistemaLogros();
	
	private Logro[] logros;
	
	private SistemaLogros() {
		String[] titulos = {
			"100% Completado",
			"El mejor de todos",
			"Mega-Combo!",
			"De poco a poco...",
			"Perfeccionista",
			"Por los pelos!"
		};
		
		logros = new Logro[titulos.length];
		
		for(int i = 0; i < titulos.length; i++)
		{
			logros[i] = new Logro(i, titulos[i]);
		}
	}
	
	public static SistemaLogros getInstance()
	{	
		return sistemaLogros;
	}
	
	public int getNumLogros()
	{
		return logros.length;
	}
	
	public void anadirLogro(Jugador jugador, int logroID)
	{
			System.out.println("El usuario " + jugador.getUsuario() + 
					" ganó un logro! : "+ logros[logroID].getTitulo() );

	}
	
}
