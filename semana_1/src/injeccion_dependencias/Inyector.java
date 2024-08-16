package injeccion_dependencias;

public class Inyector {

	
	static void InyectarReceta(Chef chef, Comida comida, String tipo) {
		if(comida == Comida.TACO)
			chef.setReceta(new Taco(tipo));
		else if(comida == Comida.PIZZA)
			chef.setReceta(new Pizza(tipo));
		else if(comida == Comida.HAMBURGUESA)
			chef.setReceta(new Hamburguesa(tipo));
		else {
			throw new UnsupportedOperationException("Esta receta no existe. Intenta con otra receta");
		}
	}
		
}
