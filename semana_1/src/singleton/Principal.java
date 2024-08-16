package singleton;

import java.util.Random;

/*
 * EJEMPLO DE SINGLETON
 * Creado por: Luis Miguel Sánchez Flores
 * 
 */

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// Creación de jugadores
		
		Jugador[] jugadores = {
				new Jugador("panchito_23"),
				new Jugador("vanguarMX"),
				new Jugador("messilover98"),
				new Jugador("FedericoM9"),
				new Jugador("maestrodetodos"),
		};
		
		
		// Creación de objeto Random:
		Random rand = new Random();
		
		
		// Para cada uno de los jugadores de la lista:
		for(Jugador jugador : jugadores)
		{
			
			// Pausar el programa durante un tiempo aleatorio (max 5 seg) para simular una partida del juego:
			Thread.sleep(rand.nextInt(5000));
			
			// Se recupera la única instancia de SistemaLogros:
			SistemaLogros sistemaLogros = SistemaLogros.getInstance();
			
			// Se añade un logro aleatorio al jugador:
			sistemaLogros.anadirLogro(jugador,
										rand.nextInt(sistemaLogros.getNumLogros()));
		}
		
		

	}

}
