package mundo.cliente;

import java.io.IOException;
import java.net.UnknownHostException;

public class Jugador {
	
	private String nombre;
	
	
	public Jugador(String nombre) throws UnknownHostException, IOException {
		this.nombre = nombre;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
