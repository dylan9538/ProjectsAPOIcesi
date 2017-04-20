package mundo;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Participante {

	
	private String nombre;
		
	public Participante(String nombre) throws UnknownHostException, IOException
	{
		this.nombre = nombre;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}