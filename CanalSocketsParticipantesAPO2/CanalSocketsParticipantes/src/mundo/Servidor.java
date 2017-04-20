package mundo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Servidor {

	private ServerSocket server;
	private Socket canal;
	
	private ArrayList<Participante> participantes;

	public Servidor() {

		try {
			server = new ServerSocket(6666);
		} catch (IOException e) {
			e.printStackTrace();
		}
		participantes = new ArrayList<Participante>();
		
	}

	public String getCodigo(){
		String cadena = "";
		for (int i = 0; i < participantes.size(); i++) {
			if (participantes.get(i) != null)
				cadena +=  (i+1) +"" + participantes.get(i).getNombre().charAt(0) + ",\n";
		}
		return cadena;
	}

	public void RegistrarParticipante(String nombre)
			throws UnknownHostException, IOException {

			if (nombre != "" && nombre != null) {
				Participante part = new Participante(nombre);
			participantes.add(part);
				
			}
			canal.close();
		}

	
	public void eliminarParticipante(String nom)throws Exception{
		boolean encontro = false;
		if(nom!= null && !nom.equals("")){
			
			for (int i = 0; i < participantes.size() && !encontro; i++) {
				if (participantes.get(i).getNombre().equals(nom)){
					participantes.remove(i);
					encontro = true;
				}
			}
			if(!encontro)
			throw new Exception("El participante no se ha registrado aùn");
		}
		else {
			throw new Exception("Ingrese un nombre vàlido");
		}
	}

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}

	public Socket getCanal() {
		return canal;
	}

	public void setCanal(Socket canal) {
		this.canal = canal;
	}

    public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	
}
