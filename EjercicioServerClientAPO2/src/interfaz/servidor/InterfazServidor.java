package interfaz.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import mundo.servidor.Torneo;

public class InterfazServidor {

	private Torneo torneo;
	private ServerSocket server;
	private Socket canal;
	private HiloBotones hilo;
	private int conectados;

	public InterfazServidor() throws IOException {
		server = new ServerSocket(8888);
		torneo = new Torneo();
		hilo = new HiloBotones(this);
		conectados = 0;
		//canal = server.accept();
	}

	public static void main(String[] args) {
		InterfazServidor in = null;
		try {
			in = new InterfazServidor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
////			in.setCanal(in.getServer().accept());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
////			lector = new DataInputStream(in.getCanal().getInputStream());
////			escritor = new DataOutputStream(in.getCanal().getOutputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		try {
			while (true) {
				in.setCanal(in.getServer().accept());
				in.getHilo().start();
				in.setConectados(in.getConectados()+1);
				
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	
	
	public int getConectados() {
		return conectados;
	}

	public void setConectados(int conectados) {
		this.conectados = conectados;
	}

	public HiloBotones getHilo() {
		return hilo;
	}

	public void setHilo(HiloBotones hilo) {
		this.hilo = hilo;
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

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

}
