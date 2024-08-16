package singleton;

import java.util.Random;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// Creación de jugadores
		
		Jugador[] jugadores = {
				new Jugador("panchito_23"),
				new Jugador("elpanamiguel"),
				new Jugador("messilover98"),
		};
		
		String[] logros = {
				"100% Completado",
				"El mejor de todos",
				"Mega-Combo!",
				"De poco a poco...",
				"Perfeccionista",
				"Por los pelos!"
		};
		
		Random rand = new Random();
		
		
		for(Jugador jugador : jugadores)
		{
			SistemaLogros.getInstance().anadirLogro(jugador,
										logros[rand.nextInt(logros.length)]);
		
			Thread.sleep(rand.nextInt(5000));
		}
		
		

	}

}
