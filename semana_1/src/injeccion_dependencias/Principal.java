package injeccion_dependencias;

public class Principal {

	
	public static void main(String[] args) {
		
		Chef alberto = new Chef("Alberto");
		
		alberto.prepararComida();
		
		Inyector.InyectarReceta(alberto, Comida.TACO, "bistec");
		
		alberto.prepararComida();
		
		Chef mario = new Chef("Mario");
		
		Inyector.InyectarReceta(mario, Comida.PIZZA, "hawaiana");
		
		mario.prepararComida();
		
		Chef victor = new Chef("Victor");
		
		Inyector.InyectarReceta(victor, Comida.HAMBURGUESA, "Angus");
		
		victor.prepararComida();
		
	
		
	}
	
	
}
