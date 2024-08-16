package singleton;

import java.util.Random;

public class Jugador {
	
	private String usuario;

	public Jugador(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "JUGADOR : " + usuario;
	}
	
	
	
}
