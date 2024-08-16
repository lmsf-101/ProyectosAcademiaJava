package polimorfismo;
					   //IS-A
public class Spiderman extends Superheroe{

	public Spiderman() {
		super("Spider-Man", "Queens, Nueva York", "Los Vengadores");
	}
	
	/* Con la clase abstracta Superheroe heredada, se tienen que implementar
	   cada uno de los métodos solicitados */
	
	// Así, cada superheroe implementa los poderes que posee, su historia de origen y sus grandes debilidades:

	@Override
	void usarPoder() {
		System.out.println(nombre + " usa su poderes arácnidos para treparse en los muros");
	}

	@Override
	void historiaDeOrigen() {
		System.out.println("Peter Parker es un adolescente como otro cualquiera. "
				+ "Vive con su tía May y su tío Ben, va al instituto y le encantan las clases de ciencias. "
				+ "Sin embargo, todo cambia el día que, durante una excursión del insituto a un laboratorio, "
				+ "¡Peter es mordido por una araña radioactiva y se convierte en " + nombre + "!");
		
	}

	@Override
	void getDebilidad() {
		System.out.println("La culpa y el amor por los demas es la mayor debilidad de " + nombre + 
				" y sus sentimientos esencialmente convierten al héroe en su peor enemigo...");
	}

}
