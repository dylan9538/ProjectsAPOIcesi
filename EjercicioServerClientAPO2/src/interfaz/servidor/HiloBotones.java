package interfaz.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class HiloBotones extends Thread{

	private InterfazServidor interfaz;
	private static DataOutputStream escritor;
	private static DataInputStream lector;
	
	public HiloBotones(InterfazServidor interfaz){
		this.interfaz = interfaz;
	}
	
	
	public void run() {
	try{
		while (true) {
			lector = new DataInputStream(interfaz.getCanal().getInputStream());
			escritor = new DataOutputStream(interfaz.getCanal().getOutputStream());
			
			String leyo = lector.readUTF();
//			System.out.println(leyo);
			if (leyo.equalsIgnoreCase("Registrar")) {
				String leyo2 = lector.readUTF();
//				System.out.println(leyo2);
				interfaz.getTorneo().getJugadores().add(leyo2);
				escritor.writeUTF("Se agrego correctamente a: " + leyo2);
				escritor.writeUTF(""+interfaz.getConectados());
			}else if(leyo.equalsIgnoreCase("Consultar")){
				escritor.writeUTF(""+interfaz.getTorneo().getJugadores().toString());
			}
		}
	}catch (IOException e){
		e.getStackTrace();
	}
	}
	

}
