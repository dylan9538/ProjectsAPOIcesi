package Mundo;
import java.util.*;

import java.io.*;

import javax.swing.JOptionPane;

public class Reino {

	  private static final String LOG_FILE = "./data/error.log";
	
	//RELACIÓN
	
	private ArrayList <Personificacion> personificaciones;
	private String rutaArchivo;
	private ArrayList <Personificacion> rhHombres, rhMujeres, desempleados;

	//CONSTRUCTOR
	
	public Reino (String nArchivo) throws PersistenciaException
	{
		rutaArchivo = nArchivo;
		cargarInfoReino();
		
		verificarInvariante();		
	}

	//Metodo registrar Personificacion 
	public boolean registrarPersonificacion (String nombreCompleto, String fechaNacimiento, String identificacion,
			String sexo, String rh, String residencia, String telefono, String estadoCivil, 
			String cantidadHijos, String nivelEducativo, String profesion,String estadoLaboral, double salario )
	{
		boolean registro = false;
		
		if(existeNombre(nombreCompleto))
		{
			JOptionPane.showMessageDialog(null, "La person ya se encuentra registrada"); 			
		}
		
		else {
			Personificacion personificacion = new Personificacion(nombreCompleto, fechaNacimiento, identificacion, sexo, 
					rh, residencia, telefono, estadoCivil, cantidadHijos, nivelEducativo, profesion, estadoLaboral, salario);
			
			personificaciones.add(personificacion);
			ordenarListadoPorFechaDeNacimiento();
			registro = true;
		}
		verificarInvariante();
		return registro;
		
	}
	
//metodo por binario.. buscar una personificacion
	public boolean buscarBinario(Personificacion p)
	{
		boolean encontre = false;	
		int inicio = 0;
		int fin = personificaciones.size()-1;
		   while(inicio<= fin && !encontre)
		      {
			   int medio = (inicio + fin)/2;
			      if(personificaciones.get(medio).comparaFechaNacimiento(p)==0)
			  {
				encontre = true;
			   }
			  else if(personificaciones.get(medio).comparaFechaNacimiento(p)>0)
			  {
				fin = medio -1;
			  }		
			 else {
				inicio = medio+1;
			 }	
		}
		return encontre;
	}
	
// Metodo ordenar por fecha de nacimiento
	//Insercion
		public void ordenarListadoPorFechaDeNacimiento (){
	
			for(int i= 1; i<personificaciones.size();i++)
			{
				Personificacion porInsertar = personificaciones.get(i);
				boolean termino = false;
				for (int j = i; j > 0 && !termino ; j--) {	
					Personificacion actual = personificaciones.get(j-1);		
				    	if(actual.comparaFechaNacimiento(porInsertar)>0)
					{
						personificaciones.set(j, actual);
						personificaciones.set(j-1, porInsertar);
					}			
					else termino = true;
				}
			}
	}
//metodo para dar listado de sexos
     public ArrayList<Personificacion> darListadoSexos(String sexo) {

	   ArrayList<Personificacion> vector = null;
	   rhMujeres = new ArrayList<Personificacion>();
	   rhHombres = new ArrayList<Personificacion>();

         for (int i = 0; i < personificaciones.size(); i++) {
		    Personificacion unPersonificacion = personificaciones.get(i);
		       if (unPersonificacion.darSexo().equals(Personificacion.SEXO_MASCULINO)) 
		      {
			   rhHombres.add(unPersonificacion);
		      }
		        if (unPersonificacion.darSexo().equals(Personificacion.SEXO_FEMENINO))
		        {
			    rhMujeres.add(unPersonificacion);
		          }
	            }
               if (sexo.equals(Personificacion.SEXO_FEMENINO)) {
		          vector = rhMujeres;
			     }
		       if (sexo.equals(Personificacion.SEXO_MASCULINO)) {
			     vector = rhHombres;
			 }
		 return vector;
	}
// Metodo organizar por Rh segun el sexo dado como parametro
   //Metodo burbuja
		public void organizarPorRH(String sexo) {
				
			ArrayList<Personificacion> Personificaciones = darListadoSexos(sexo);

		 for (int i = Personificaciones.size(); i > 0; i--) {
			  for (int j = 0; j < i - 1; j++) {
			      Personificacion uno =  Personificaciones.get(j);
			      Personificacion dos =  Personificaciones.get(j + 1);
			          if (uno.compararPorRH(dos) > 0) {
			           Personificacion temp = uno;
			           Personificaciones.set(j, dos);
			           Personificaciones.set(j + 1, temp);
			           }
			         }
			   }
			verificarInvariante();
			}

// metodo que da todas las personificaciones que son desempleados y tienen hijos
		public void ListaDesempleadosConHijos() {
				
			desempleados = new ArrayList<Personificacion>();
			for (int i = 0; i < personificaciones.size(); i++) {
			Personificacion p = personificaciones.get(i);
			if (Integer.parseInt(p.darCantidadHijos()) > 0
			&& p.darEstadoLaboral().equalsIgnoreCase(Personificacion.DESEMPLEADO)) {
			desempleados.add(p);
			}
		}
			verificarInvariante();
	}

// Organizar Personificacions desempleados y con hijos 
	  // metodo de seleccion
	public void OrdenarPorHijosDesempleados() {
			ListaDesempleadosConHijos();
			  for (int i = 0; i < desempleados.size(); i++) {
			    Personificacion menor = (Personificacion) desempleados.get(i);
			    int cual = i;
			      for (int j = i + 1; j < desempleados.size(); j++) {
			           Personificacion elPersonificacionJ =  desempleados.get(j);
			             if (elPersonificacionJ.compararPorHijos(menor) < 0) {
			               menor = elPersonificacionJ;
			               cual = j;
			                 }
			                }
			                Personificacion temp =  desempleados.get(i);
			                desempleados.set(i, menor);
			                desempleados.set(cual, temp);
			         }
			verificarInvariante();
	}

//Metodo dar string que me da los datos del parametro
	public String darString (ArrayList<Personificacion> a)
	{
		String cadena= "";
		for(int i = 0; i<a.size(); i++)
		{
			Personificacion p = a.get(i);
			cadena+= p.darNombreCompleto()+";"+p.darFechaNacimiento()+";"+p.darIdentificacion()+";"+p.darSexo()+
					";"+p.darRh()+";"+p.darResidencia()+";"+p.darTelefono()+";"+p.darEstadoCivil()+";"+p.darCantidadHijos()
					+";"+p.darNivelEducativo()+";"+p.darProfesion()+";"+p.darEstadoLaboral()+";"+p.darSalario() + "\n";
		}	
		return cadena;
	}
	
	//METODOS DE DAR
	
  // metodo dar Personificaciones
	public ArrayList<Personificacion> darPersonificaciones() {
		return personificaciones;
	}
	// metodo dar rhHombre
	public ArrayList<Personificacion> darRhHombres() {
		return rhHombres;
	}
	// metodo dar rhMujeres
	public ArrayList<Personificacion> darRhMujeres() {
		return rhMujeres;
	}
	// metodo dar darDesempleados
	public ArrayList<Personificacion> darDesempleados() {
		return desempleados;
	}

	//PERSISTENCIA Y SERIALIZACION
	
//Metodo de cargar de persistencia
	public void importarDatosReino(String ruta) throws IOException
	  {
		String reporte = "no se ha podido agregar las sgtes personas: " +"\n";
		File archivo = new File(ruta);
		FileReader reader = new FileReader(archivo);
		BufferedReader lector = new BufferedReader(reader);
		
		String linea = lector.readLine();
		  while(linea!= null)
		    {
		      String [] splitter = linea.split(";");
		        if(existeNombre(splitter[0]))
		     {
			reporte += splitter[0] + "\n";
		  }
		else{
			registrarPersonificacion(splitter[0], splitter[1], splitter[2], splitter[3], splitter[4],
					splitter[5], splitter[6], splitter[7], splitter[8], splitter[9], splitter[10], splitter[11], Double.parseDouble(splitter[12]));	
		  }		
		linea = lector.readLine();
		 }
	lector.close();
	reader.close();
	JOptionPane.showMessageDialog(null, reporte);
 }
	
//Metodo guardar de persistencia
	public void exportarArchivo(String ruta) throws FileNotFoundException
	{
		File archivo = new File(ruta);
		
		PrintWriter escritor = new PrintWriter(archivo);
      	for (int i = 0; i < personificaciones.size(); i++) {
      		Personificacion p= personificaciones.get(i);
      		escritor.println(p.darNombreCompleto()+";"+p.darFechaNacimiento()+";"+p.darIdentificacion()+";"+p.darSexo()+";"+
			p.darRh()+";"+p.darResidencia()+";"+p.darTelefono()+";"+p.darEstadoCivil()+";"+p.darCantidadHijos()
			+";"+p.darNivelEducativo()+";"+p.darProfesion()+";"+p.darEstadoLaboral()+";"+p.darSalario());
		}		
		escritor.close();
	}
	
	
	//Metodo de serializacion 1
public void cargarInfoReino()throws PersistenciaException
		{
			File archivo = new File(rutaArchivo);
			if(archivo.exists())
			{
				try
				{
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
					personificaciones =(ArrayList<Personificacion>) ois.readObject();
					ois.close();
				}catch(Exception e)
				{
					registrarError(e);
					
					throw new PersistenciaException("Imposible restaurar el estado del programa (" + e.getMessage()+ ")");
				}
			}
			else
			{
			personificaciones = new ArrayList<Personificacion>();
			}
			verificarInvariante();
		}
	//Metodo de salvar el archivo de serializacion 1
public void salvarInfoReino( ) throws PersistenciaException
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( rutaArchivo ) );
            oos.writeObject( personificaciones );
            oos.close( );
        }
        catch( IOException e )
        {
            registrarError( e );
            throw new PersistenciaException( "Error al salvar: " );
        }
        verificarInvariante();
    }
	
//Metodo de registrar error de serializacion 3 
   public void registrarError(Exception e)
    {
	try
	{
		FileWriter out = new FileWriter(LOG_FILE, true);
		PrintWriter log = new PrintWriter(out);
		
		log.println("---------------------------------------------");
		log.println("Reino muy muy Lejano:" + new Date().toString());
		log.println("---------------------------------------------");
		e.printStackTrace(log);
		
		log.close();
		out.close();
	}
	catch(IOException ex)
	{
		e.printStackTrace();
		ex.printStackTrace();
	}
}
	
//Metodo que da la ruta 
 public String  darRutaArchivo()
  {
	return rutaArchivo;
  }
 
     //INVARIANTES Y METODOS PRIVADOS

// Metodo existe nombre

  private boolean existeNombre(String nombreCompleto)
   {
	boolean encontre = false;
	for(int i=0; i <personificaciones.size() && !encontre;i++)
	{
		if(nombreCompleto.equalsIgnoreCase(personificaciones.get(i).darNombreCompleto()))
		{
			encontre = true;
		}
	}
	
	return encontre;
}

//Invariantes
   private void verificarInvariante ()
   {
	assert personificaciones != null: "la lista de personificaciones es null";
  }

}