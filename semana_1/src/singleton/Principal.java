package singleton;

import java.util.Random;

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
		
		Random rand = new Random();
		
		
		for(Jugador jugador : jugadores)
		{
			SistemaLogros sistemaLogros = SistemaLogros.getInstance();
			
			sistemaLogros.anadirLogro(jugador,
										rand.nextInt(sistemaLogros.getNumLogros()));
			
		
			Thread.sleep(rand.nextInt(5000));
		}
		
		

	}

}
