package singleton;

import java.util.Random;

public class Jugador {
	
	private final int ID;
	private String usuario;

	public Jugador(String usuario) {
		this.usuario = usuario;
		ID = new Random().nextInt(20000);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "JUGADOR #"+ ID + " : " + usuario;
	}
	
	
	
	
	
	
}
