package suma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	
	private Socket canal;
	
	public void conectar(){
		canal = null;
		try{
			canal = new Socket("localhost",7777);
		}catch(Exception e){
			System.out.println("No pudo conectarse con el servidor");
		}
	}
	
	public int pedirSuma(int valores[]){
		int resultado = 0;
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
		
		if(out!=null){
			for(int i=0;i<valores.length;i++){
				System.out.println("\nEnviando al servidor el dato: "+valores[i]);
				out.println(""+valores[i]);
			}
			System.out.println("\nEnviando al servidor el dato: =");
			out. println("=");
		}
		
		if(canal!=null){
			try{
				String res = in.readLine();
				resultado = Integer.parseInt(res);
				System.out.println("\nSe ha recibido del servidor: "+resultado);
				in.close();
			}catch(Exception e){
				System.out.println("No se pudo abrir el flujo de salida y/o entrada para enviar y/o recibir datos por el socket o Hubo problemas al recibir la respuesta del servidor\n"+e.getMessage());
			}
		}

		return resultado;
	}

	public static void main(String[] args){
		
		int[] numeros = {3, 7, 2, 9, 1, 0, 4, 8};
		
		Cliente cliente = new Cliente();
		cliente.conectar();
		
		int suma = cliente.pedirSuma(numeros);

		System.out.println("\n========\nEl servidor ha retornado que la suma es: "+suma);
	}
}
