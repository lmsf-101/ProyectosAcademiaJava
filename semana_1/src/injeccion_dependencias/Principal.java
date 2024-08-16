package injeccion_dependencias;

/*
 * EJEMPLO DE INYECCIÓN POR DEPENDENCIA MEDIANTE FUNCIÓN SETTER
 * Creado por: Luis Miguel Sánchez Flores
 * 
 */


public class Principal {

	
	public static void main(String[] args) {
		
		
		// Entra el chef Alberto al restaurante...
		Chef alberto = new Chef("Alberto");
		
		// Sin ninguna receta proporcionada por el asistente, el chef Alberto
		// no puede preparar la comida por el momento....
		alberto.prepararComida();
		
		/*
		 * Al recibir una orden de tacos de bistec, el asistente proporciona
		 * la receta de tacos hacia Alberto:
		 */
		Asistente.entregarReceta(alberto, Comida.TACO, "bistec");
		
		
		// Ahora, el chef Alberto puede preparar los tacos sin ningún problema.
		alberto.prepararComida();
		
		// Entra el chef Mario...
		Chef mario = new Chef("Mario");
		
		// Con una orden de pizza hawaiana, el asistente le entrega la receta
		// de pizza hawaiana al chef Mario:
		Asistente.entregarReceta(mario, Comida.PIZZA, "hawaiana");
		
		// El chef Mario prepara la pizza...
		mario.prepararComida();
		
		
		// El chef Victor es el último en entrar:
		Chef victor = new Chef("Victor");
		
		// Con una orden de hamburguesa Angus pendiente, el asistente le entrega
		// la receta apropiada al chef Victor
		Asistente.entregarReceta(victor, Comida.HAMBURGUESA, "Angus");
		
		// El chef victor prepara la hamburguesa con gusto...
		victor.prepararComida();
		
	
	}
	
	
}
