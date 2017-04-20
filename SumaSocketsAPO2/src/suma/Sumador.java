package suma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Sumador {
	private ServerSocket server;
	private Socket canal;
	
	public Sumador(){
		server = null;
		canal = null;
		try{
			server = new ServerSocket(7777);
		}catch(Exception e){
			System.out.println("No se pudo iniciar el sumador\n"+e.getMessage());
		}
	}
	
	public void atenderCliente(){
		String recibido;
		try{
			System.out.println("Escuchando (en espera de un cliente) ...");
			canal = server.accept();
			System.out.println("Conexión Establecida con el Cliente");
		}catch(Exception e){
			System.out.println("Ocurrió un problema al poner a escuchar al servidor"+e.getMessage());
		}
		
		PrintWriter out = null;
		BufferedReader in = null;
		if(canal!=null){
			try{
				in = new BufferedReader(new InputStreamReader(canal.getInputStream()));
				out = new PrintWriter(canal.getOutputStream(),true);
			}catch(Exception e){
				System.out.println("No se pudo abrir el flujo de salida y/o entrada para enviar y/o recibir datos por el socket "+e.getMessage());
			}
		}
		
		ArrayList<Integer> valores = new ArrayList<Integer>();
		try{
			
			do{
				System.out.println("\nEsperando informacion del cliente ...");
				recibido = in.readLine();
				System.out.println("Se ha recibido:'"+recibido+"' del cliente.");
				if(!recibido.equals("=")){
					int valor = Integer.parseInt(recibido);
					valores.add(valor);
				}
			}while(!recibido.equals("="));
			
			int resultado = sumar(valores);
			out.println(""+resultado);
			System.out.println("\nSe ha respondido al cliente: "+resultado);
			
		}catch(Exception e){
			System.out.println("Hubo problemas en la comunicación con el cliente");
		}
						
	}
	
	public int sumar(ArrayList<Integer> nums){
		int sumatoria = 0;
		for(int i=0;i<nums.size();i++){
			sumatoria += nums.get(i).intValue();
		}
		return sumatoria;
	}

	public static void main(String[] args){
		Sumador servidor = new Sumador();
		servidor.atenderCliente();
	}	
}
