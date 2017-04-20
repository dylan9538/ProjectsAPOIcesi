package mundo.servidor;

import java.util.ArrayList;

public class Torneo {
	
	private ArrayList<String> jugadores;
	
	public Torneo(){
		jugadores = new ArrayList<String>();
	
	}

	public ArrayList<String> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<String> jugadores) {
		this.jugadores = jugadores;
	}

	

}
