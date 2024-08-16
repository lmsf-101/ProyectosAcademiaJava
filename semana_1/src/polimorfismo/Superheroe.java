package polimorfismo;

public abstract class Superheroe {

	// Se definen variables comunes entre los superheroes:
	String nombre; 
	String lugarDeOrigen;
	String equipo;
	
	// CONSTRUCTOR
	Superheroe(String nombre, String lugarDeOrigen, String equipo ) {
		this.nombre = nombre;
		this.lugarDeOrigen = lugarDeOrigen;
		this.equipo = equipo;
	}

	// Imprimir nombre del superheroe:
	@Override
	public String toString() {
		return "SUPERHEROE : " + nombre;
	}
	
	// Imprimir el lugar de origen del superheroe:
	void getLugarDeOrigen()
	{
		System.out.println("LUGAR DE ORIGEN : " + nombre + " nació en " + lugarDeOrigen + ".");
	}
	
	// Imprimir la alianza, facción o equipo que pertenece el superheroe, si aplica:
	void getEquipo()
	{
		if(equipo != null && !equipo.isEmpty())
			System.out.println(nombre + " pertenece al equipo de " + equipo);
		else
			System.out.println(nombre + " trabaja solo.....");
	}
	
	// MÉTODOS ABSTRACTOS:
	// Se declaran métodos / funciones cómunes entre los superheroes:
	abstract void usarPoder();
	
	abstract void historiaDeOrigen();
	
	abstract void getDebilidad();
	
}
