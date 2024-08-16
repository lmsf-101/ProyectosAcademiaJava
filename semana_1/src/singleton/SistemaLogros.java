package singleton;

public class SistemaLogros {
	
	private static SistemaLogros sistemaLogros = new SistemaLogros();
	
	private SistemaLogros() {
		
	}
	
	public static SistemaLogros getInstance()
	{	
		return sistemaLogros;
	}
	
	public void anadirLogro(Jugador jugador, String logro)
	{
		System.out.println("El usuario " + jugador.getUsuario() + 
				"[" + jugador.getID() + "] ganó un logro! : "+ logro );
	}
	
}
