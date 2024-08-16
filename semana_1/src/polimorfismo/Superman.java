package polimorfismo;
					  //IS-A
public class Superman extends Superheroe{

	
	public Superman() {
		super("Superman", "Krypton", "La Liga de la Justicia");
	}
	
	/* Con la clase abstracta Superheroe heredada, se tienen que implementar
	   cada uno de los métodos solicitados */
	
	// Así, cada Superheroe implementa los poderes que posee, su historia de origen y su mayor debilidad:

	@Override
	void usarPoder() {
		System.out.println("¡" + nombre + " tiene superfuerza para recoger cualquier objeto que te imaginas!");
	}

	@Override
	void historiaDeOrigen() {
		System.out.println("Kal-El nació originalmente en la ciudad de Kryptonopolis, "
				+ "en el planeta Krypton. Su padre, el mejor científico del planeta, "
				+ "hizo muchos estudios desde antes que Kal-El naciera, "
				+ "que probaba que el planeta estaba alcanzando altas temperaturas en su núcleo...");
		
	}

	@Override
	void getDebilidad() {
		System.out.println("Superman es debil ante la kryptonia verde, anulando totalmente de sus poderes.");
	}

}
