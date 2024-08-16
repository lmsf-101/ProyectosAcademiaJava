package injeccion_dependencias;

// Asistente (Inyector) que se encargará de proporcionar las dependencias (Recetas) que requieran
// los objetos (Chef)

public class Asistente {

	
	static void entregarReceta(Chef chef, Comida comida, String tipo) {
		
		// Si se pidieron tacos....
		if(comida == Comida.TACO)
			// ...entrega la receta correspondiente de Tacos
			chef.setReceta(new Tacos(tipo));
		
		// O una pizza...
		else if(comida == Comida.PIZZA)
			// ...entrega la receta correspondiente de Pizza
			chef.setReceta(new Pizza(tipo));
		
		// O una hamburguesa....
		else if(comida == Comida.HAMBURGUESA)
			// ...entrega la receta correspondiente de Pizza
			chef.setReceta(new Hamburguesa(tipo));
		
		// Si se recibio una orden invalida....
		else {
			// ...se debe rechazarla.
			throw new UnsupportedOperationException("Esta receta no existe. Intenta con otra receta");
		}
	}
		
}
