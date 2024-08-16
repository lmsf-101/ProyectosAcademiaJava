package polimorfismo;
					//IS-A
public class Batman extends Superheroe{

	
	public Batman() {
		super("Batman", "Ciudad Gótica", "");
	}
	
	/* Con la clase abstracta Superheroe heredada, se tienen que implementar
	   cada uno de los métodos solicitados */
	
	// Así, cada superheroe implementa los poderes que posee, su historia de origen y sus grandes debilidades:

	@Override
	void usarPoder() {
		System.out.println(nombre + " vence a sus oponentes con el uso de gadgets sofisticados" +
						" y su inteligencia suprema.");
	}

	@Override
	void historiaDeOrigen() {
		System.out.println(nombre + " es la identidad secreta de Bruce Wayne, un empresario multimillonario, "
				+ "galán y filántropo. Presenció el asesinato de sus padres cuando era niño lo marcó profundamente "
				+ "y lo llevó a entrenarse en la perfección física e intelectual para ponerse un disfraz de murciélago "
				+ "con el fin de combatir el crimen.");
		
	}

	@Override
	void getDebilidad() {
		System.out.println("El trauma psicológico por la muerte de sus padres y la dependencia en la tecnología podría ser explotada "
				+ "por sus enemigos para derrotarlo.");
	}

}
