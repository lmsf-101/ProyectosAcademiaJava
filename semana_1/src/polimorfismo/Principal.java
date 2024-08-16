package polimorfismo;

/*
 * EJEMPLO DE POLIMORFISMO CON CLASES ABSTRACTAS
 * Creado por: Luis Miguel Sánchez Flores
 * 
 */


public class Principal {

	public static void main(String[] args) {
		
		// Generamos una lista de los superheroes disponibles:
		Superheroe[] superheroes = {
				new Spiderman(),
				new Superman(),
				new Batman(),
		};
		
		// Para cada uno de los superheroes incluidos en el listado:
		for(Superheroe superheroe : superheroes) {
			
			// Se imprime información acerca del superheroe correspondiente, incluyendo:
			
			// Nombre:
			System.out.println(superheroe);
			System.out.println();
			
			// Lugar de origen:
			superheroe.getLugarDeOrigen();
			System.out.println();
			
			// Su historia de origen:
			superheroe.historiaDeOrigen();
			System.out.println();
			
			// El equipo o alianza a la que pertenece:
			superheroe.getEquipo();
			System.out.println();
			
			// Los poderes que posee:
			superheroe.usarPoder();
			System.out.println();
			
			// Su mayor debilidad:
			superheroe.getDebilidad();
			System.out.println();
			
			System.out.println("\n\n-----------------------------------------------\n\n");
			
		}
		
	}

}
