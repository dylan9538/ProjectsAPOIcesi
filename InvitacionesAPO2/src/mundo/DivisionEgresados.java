package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DivisionEgresados {
	public final static String SEPARADOR = ";";
	private ArrayList<Egresado> egresados;
	
	public DivisionEgresados(){
		egresados = new ArrayList<Egresado>();
	}
	
	public void agregarEgresado(String nom, String ape, String ced, String tel, String correoE){
		Egresado e = new Egresado(nom,ape,ced,tel,correoE);
		egresados.add(e);
	}
	
	public ArrayList<Egresado> darEgresados(){
		return egresados;
	}
	
	public void cargarListaEgresados(String nombreArchivo) throws FormatoInvalidoException{
		egresados = new ArrayList<Egresado>(); //Lo inicializo nuevamente para que si ya tiene
										       //datos cargados no los tome en cuenta y solo
											   //trabaje ahora con los leidos desde el archivo
		int numeroLinea = 0;
		try {
			FileReader reader = new FileReader(nombreArchivo);
			BufferedReader lector = new BufferedReader(reader);
			
			String linea = lector.readLine();
			while(linea!=null){
				numeroLinea++;
				if(!linea.trim().equals("") && linea.charAt(0)!='%'){
					String[] campos = linea.split(SEPARADOR);
					if(campos.length!=6){
						lector.close();
						reader.close();
						egresados = new ArrayList<Egresado>();
						throw new FormatoInvalidoException("Falló la carga del archivo!",nombreArchivo,numeroLinea);
					}
					agregarEgresado(campos[1],campos[2],campos[3],campos[4],campos[5]);
				}
				linea= lector.readLine();
			}
			lector.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new FormatoInvalidoException("Falló la carga del archivo!",nombreArchivo,numeroLinea);
		}
	}
	
	public void asignarPuestoAInvitados(){
		//Defino dos estrategias distintas
		//modifique el número a continuacion para
		//cambiar de estrategia
		int estrategia = 1;

		switch(estrategia){
			case 1:
				asignarPuestoAInvitadosEstrategia1();
			break;
			case 2:
				asignarPuestoAInvitadosEstrategia2();
			break;
		}
	}
	
	//Hagan una pequena prueba de escritorio (puede ser sobre 10 egresados)
	//para entender con mas facilidad la estrategia planteada aqui
	private void asignarPuestoAInvitadosEstrategia1(){
		ArrayList<Integer> puestos = new ArrayList<Integer>();
		for(int i=1;i<=egresados.size();i++){
			puestos.add(i);
		}
		
		int i=0;
		while(puestos.size()>0){
			int posicion = (int)(Math.random()*puestos.size());
			int puestoGenerado = puestos.get(posicion);
			egresados.get(i).cambiarNumeroPuesto(puestoGenerado);
			puestos.remove(posicion);
			i++;
		}
	}
	
	//Mucho mas ineficiente
	private void asignarPuestoAInvitadosEstrategia2(){
		for(int i=0;i<egresados.size();i++){
			
			boolean fueGeneradoAntes;
			int puesto;
			do{
				//genero el número aleatorio del puesto
				puesto = (int)(Math.random()*egresados.size()) + 1;
				
				fueGeneradoAntes = false;
				//ahora busco si ya lo he asignado antes
				for(int j=0;j < i; j++){
					if(puesto == egresados.get(j).darNumeroPuesto()){
						fueGeneradoAntes = true;
					}
				}
				
			}while(fueGeneradoAntes);//si ya lo he generado antes vuelvo a generar otro número
			
			egresados.get(i).cambiarNumeroPuesto(puesto);
		}
	}
	
	public String generaTarjetasInvitacion(){
		String tarjetas = "";
		for(int i=0;i<egresados.size();i++){
			Egresado e = egresados.get(i);
			tarjetas += "=========== INVITADO "+(i+1)+" ==============\n"
					 +  "Nombre: "+e.darNombres()+" "+e.darApellidos()+"\n"
					 +  "Cedula: "+e.darCedula()+"\n"
					 +  "Telefono: "+e.darTelefono()+"\n"
					 +  "Correo: "+e.darCorreoElectronico()+"\n\n"
					 +  "La universidad tiene el gusto de invitarlo a su aniversario.\n"
					 +  "Contamos con su importante asistencia!\n\n";
		}
		return tarjetas;
	}
	
	public void guardarTarjetasInvitacion(String tarjetas,String nombreArchivo) throws IOException{
		PrintWriter escritor = new PrintWriter(nombreArchivo);
		escritor.println(tarjetas);
		escritor.close();
	}
	
	public String obtenerCadenaInfoEgresados(){
		String infoEgresados = "Puesto - Nombres, Apellidos, Cedula, Telefono, Correo\n";
		for(int i=0;i<egresados.size();i++){
			infoEgresados += egresados.get(i) + "\n"; //Se aprovecha el metodo toString
		}
		return infoEgresados;
	}
	
	public String generarLista(){
		String[] nombres = {
				"Santiago", "Natalia", "Juan", "Manuel", "David",
				"Maryi", "Angela", "Liliana", "Lorena", "Idalia",
				"Viviana"
		};
		String[] apellidos1 = {
				"Reyes", "Garcia", "Hurtado", "Bustamante", "Arciniegas",
				"Lopez", "Villota", "Piedrahita", "Gomez", "Arana",
				"Buitrago"
		};
		String[] apellidos2 = {
				"Alvarez", "Perez", "Sanchez", "Ruiz", "Quintero",
				"Lourido", "Jurado", "Dinas", "Villegas", "Fernandez"
		};
		String[] frases = {
				"tiene reconocimiento en el medio politico.",
				"tuvo uno de los mejores promedios de su promocion.",
				"colabora con la universidad constantemente.",
				"participa activamente en los eventos.",
				"tiene un gran compromiso con la institucion.",
				"debe actualizar la información de contacto."
		};
		
		String listado = "";
		int consecutivo = 1;
		for(String apellido2:apellidos2){
			for(String apellido1:apellidos1){
				for(String nombre:nombres){
					
					String cedula = "11"+(int)(Math.random()*100000000);
					String movil  = "31"+(int)(Math.random()*100000000);
					int correo = (int)(Math.random()*4);
					String servidor = "wala";
					switch(correo){
						case 0: servidor="hotmail.com";break;
						case 1: servidor="gmail.com";break;
						case 2: servidor="correo.icesi.edu.co";break;
						case 3: servidor="icesi.edu.co";break;
					}
					String correoE = nombre.toLowerCase()+"."+apellido1.toLowerCase()+"."+apellido2.toLowerCase()+"@"+servidor;
					
					String comentario = "";
					if((int)(Math.random()) % 5 == 0){
						comentario = "%"+nombre+" "+apellido1+" "+frases[(int)(Math.random()*frases.length)]+"\n";
					}
					String saltoDeLinea = "";
					int nsdl = (int)(Math.random()*3);
					for(int i=0;i<nsdl;i++){
						saltoDeLinea += "\n";
					}
					String s = SEPARADOR;
					listado += saltoDeLinea+comentario+consecutivo + s + nombre + s + apellido1 + " " + apellido2 + s + cedula + s + movil + s + correoE + "\n";
					consecutivo++;
				}
			}
		}
		
		try{
			PrintWriter escritor = new PrintWriter(new File("./data/egresados.txt"));
			escritor.println(listado);
			escritor.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return listado;
	}
	
}
