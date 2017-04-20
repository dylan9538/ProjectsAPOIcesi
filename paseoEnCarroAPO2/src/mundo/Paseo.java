package mundo;

import java.util.ArrayList;

public class Paseo {

	/**
	* Precio de la gasolina por galon
	*/
	public static final double PRECIO_GALON_GASOLINA = 8000;
	
	/**
	* Vehiculos del paseo
	*/
	private ArrayList<Vehiculo> vehiculos;
	
	/**
	* alojamientos del paseo
	*/
	private ArrayList<Alojamiento> alojamientos;
	
	/**
	* estudiantes que hacen parte del paseo
	*/
	private ArrayList<Estudiante> estudiantes;
	
	/**
	 * Nombre del metodo: Paseo (constructor)<br />
	 * <br />
	 * Descripcion: este metodo se encarga de crear un nuevo objeto Paseo.
	 * Inicializa las relaciones<br />
	 * 
	 */
	
	public Paseo()
	{
		vehiculos = new ArrayList<Vehiculo>();
		alojamientos = new ArrayList<Alojamiento>();
		estudiantes = new ArrayList<Estudiante>();
	}
	
	/**
	 * 
	 * Nombre del metodo: registrarEstudiante<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de registrar un nuevo estudiante y
	 * guardar su referencia en el arraylist de estudiantes<br />
	 * <b>Pre: </b> el arraylist de estudiantes debe estar inicializado. <br />
	 * <b>Post: </b> el arraylist de estudiantes debe aumentar su tamano en una
	 * unidad
	 * 
	 * @param numeroIdentificacion
	 *            - String que representa el numero de identificacion del
	 *            estudiante. numeroIdentificacion != null, numeroIdentificacion
	 *            != null
	 * @param tipoIdentificacion
	 *            - String que representa el tipo de identificacion del
	 *            estudiante. .   tipoIdentificacion ==
	 *            Estudiante.TIPO_IDENTIFCACION_CC || tipoIdentificacion ==
	 *            Estudiante.TIPO_IDENTIFCACION_CC
	 * @param nombre
	 *            - String que representa el nombre del estudiante.  
	 *            nombre != null, nombre != ""
	 * @param apellidos
	 *            - String que representa el nombre del estudiante.  
	 *            apellidos != null, apellidos != ""
	 * @param edad
	 *            - int que representa la edad del estudiante.   edad
	 *            > 15
	 * @throws Exception
	 *             - lanza una excepcion si ya existe un estudiante con el mismo
	 *             tipo y numero de identificacion
	 */

	public void registrarEstudiante(String numeroIdentificacion, String tipoIdentificacion, String nombre,
	          String apellidos, int edad) throws Exception
	{
		if(buscarEstudiante(numeroIdentificacion, tipoIdentificacion)!= null)
		{
			throw new Exception("Ya se ha registrado un estudiante con el mismo numero y tipo de identificacion");
		}
		
		else {
			estudiantes.add(new Estudiante(numeroIdentificacion, tipoIdentificacion, nombre, apellidos, edad));
		}
	}
	
	
	
	/**
	 * 
	 * Nombre del metodo: buscarEstudiante (opcional)<br />
	 * <br />
	 * Descripcion: Este metodo opcional se encarga de buscar un estudiante en el
	 * arraylist de estudiantes. La busqueda se basa en el tipo y numero de
	 * identificacion<br />
	 * 
	 * @param numeroIdentificacion
	 *            - String que representa el numero de identificacion del
	 *            estudiante. numeroIdentificacion != null, numeroIdentificacion
	 *            != null
	 * @param tipoIdentificacion
	 *            - String que representa el tipo de identificacion del
	 *            estudiante. .   tipoIdentificacion ==
	 *            Estudiante.TIPO_IDENTIFCACION_CC || tipoIdentificacion ==
	 *            Estudiante.TIPO_IDENTIFCACION_CC
	 * @return Estudiante - retorna un objeto de tipo Estudiante si encuentra un
	 *         estudiante en el arraylist con el tipo y numero de identificacion
	 *         dados. Retorna null en caso contrario.
	 */

	public Estudiante buscarEstudiante(String numeroIdentificacion, String tipoIdentificacion)
	{
		Estudiante buscado = null;
		boolean encontrado = false;
		
		for(int i = 0; i < estudiantes.size() && !encontrado; i++)
		{
			Estudiante estudiante = estudiantes.get(i);
			
			if(estudiante.darNumeroIdentificacion().equals(numeroIdentificacion) &&
					estudiante.darTipoIdentificacion().equals(tipoIdentificacion))
			{
				buscado = estudiante;
				encontrado = true;
			}
		}
		
		return buscado;
	}


	
	/**
	 * Nombre del metodo: generarReporteEstudiantesAlojados<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de generar una cadena de texto que
	 * contiene la informacion de los estudiantes que estan registrados en algun
	 * alojamiento. La cadena debe seguir el siguiente formato<br />
	 * Estudiantes inscritos<br />
	 * <br />
	 * <br />
	 * 1. CC - 20030123, Pepito Perez Mendoza, Alojamiento 1001<br />
	 * <br />
	 * 2. TI - 20030124, Pepita Perez Ruiz, Alojamiento 1002<br />
	 * <br />
	 * <br />
	 * <br />
	 * Si no hay estudiantes registrados aun, entonces se debe mostrar: <br />
	 * <br />
	 * No hay estudiantes con alojamiento 
            * <b>Pre: </b> el arraylist de vehiculos
	 * debe estar inicializado. <br />
	 * 
	 * @return String - cadena que contiene la informacion sobre los estudiantes
	 *         alojados
	 */
	public String generarReporteEstudiantesAlojados()
	{
		String reporte = "Estudiantes inscritos\n\n\n";
		int contador = 0;
		if(!hayEstudiantesAlojados())
		{
			reporte = "No hay estudiantes con alojamiento";
		}
		
		else {
			for(int i= 0; i < alojamientos.size(); i++)
			{
				Alojamiento alojamiento = alojamientos.get(i);
				if(alojamiento.calcularOcupacion()>0)
				{
					Estudiante[]estudiantes = alojamiento.darEstudiantes();
					for(int j =0; j< estudiantes.length; j++)
					{
						Estudiante  estudiante = estudiantes[j];
						if(estudiante != null)
						{
							
							  reporte += ++contador + ". " + estudiante.darTipoIdentificacion()
							  + " - " + estudiante.darNumeroIdentificacion() + ", " +
							 estudiante.darNombre() + " " + estudiante.darApellidos() +
							  ", Alojamiento " + alojamiento.darIdentificador() + "\n\n";
						}
					}
				}
			}
			
		}
		
		return reporte;
	}
	
	
	
	/**
	 * Nombre del metodo: hayEstudiantesAlojadoso<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de verifiar que hallan estudiantes
	 * que esten alojados<br />
	 * <b>Pre: </b> el arraylist de alojamientos debe estar inicializado. <br />
	 * @return booelan
	 *             - true/ si hay estudiantes que esten alojados
	 */
	private boolean hayEstudiantesAlojados ()
	{
		boolean a = false;
		
		for(int i = 0; i< alojamientos.size() && !a; i++)
		{
			if(alojamientos.get(i).calcularOcupacion()>0)
			{
				a  = true;
			}
		}
		
		return a;
	}
	
	/**
	 * Nombre del metodo: registrarVehiculo<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de registrar un nuevo vehiculo y
	 * guardar su referencia en el arraylist de vehiculos<br />
	 * <b>Pre: </b> el arraylist de vehiculos debe estar inicializado. <br />
	 * <b>Post: </b> el arraylist de vehiculos debe aumentar su tamano en una
	 * unidad
	 * 
	 * @param placa
	 *            - String que corresponde a la placa del vehiculo
	 * @param tipoVehiculo
	 *            - String que indica el tipo del vehiculo
	 * @throws Exception
	 *             - Si el vehiculo ya se encuentra registrado
	 */
	
	public void registrarVehiculo(String placa, String tipoVehiculo) throws Exception
	{
		if(buscarVehiculo(placa)!= null)
		{
			throw new Exception("Ya hay un vehiculo registrado con tal placa");
		}
		
		else {
			
			
				Vehiculo vehiculo = new Vehiculo(placa, tipoVehiculo);
				
				vehiculos.add(vehiculo);
			
		}
	}
	
	/**
	 * 
	 * Nombre del metodo: buscarVehiculo (opcional)<br />
	 * <br />
	 * Descripcion: Este metodo opcional se encarga de buscar un vehiculo en el
	 * arraylist de vehiculos. La busqueda se basa en la placa <br />
	 * @param placa
	 *            -String que corresponde a la placa del vehiculo, placa != null && placa!= ""
	 * @return boolean - booleano que indica si ya hay un vehiculo con la misma
	 * placa registrado
	 */
	private Vehiculo buscarVehiculo(String placa)
	{
		Vehiculo buscado = null;
		boolean encontre = false;
		
		for(int i = 0; i < vehiculos.size() && !encontre; i++)
		{
			Vehiculo vehiculo = vehiculos.get(i);
			
			if(vehiculo.darPlaca().equals(placa))
			{
				encontre = true;
				buscado = vehiculo;
			}
		}
		
		return buscado;
	}

	/**
	 * Nombre del metodo: registrarAlojamiento<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de registrar un nuevo alojamiento y
	 * guardar su referencia en el arraylist de alojamientos<br />
	 * <b>Pre: </b> el arraylist de alojamientos debe estar inicializado. <br />
	 * <b>Post: </b> el arraylist de alojamientos debe aumentar su tamano en una
	 * unidad
	 * 
	 * @param identificador
	 *            - String que corresponde al identificador del alojamiento
	 * @throws Exception
	 *             - Si el alojamiento ya se encuentra registrado
	 */
	public void registrarAlojamiento(String identificador) throws Exception
	{
		if(buscarAlojamiento(identificador)!= null)
		{
			throw new Exception ("Ya hay un Alojamiento registrado con tal identificador");
		}
		
		else
		{
			alojamientos.add(new Alojamiento(identificador));
		}
	}
	
	/**
	 * 
	 * Nombre del metodo: buscarAlojamiento (opcional)<br />
	 * <br />
	 * Descripcion: Este metodo opcional se encarga de buscar un alojamiento en el
	 * arraylist de alojamientos. La busqueda se basa en el identificador <br />
	 * @param identificador
	 *            -String que corresponde al identificador del alojamiento
	 *            identificador != null && placa!= ""
	 * @return boolean - booleano que indica si ya hay un alojamiento con el mismo
	 * indicador registrado
	 */
	
	private Alojamiento buscarAlojamiento(String identificador)
	{
		Alojamiento buscado = null;
		boolean encontre = false;
		
		for(int i = 0; i < alojamientos.size() && !encontre; i++)
		{
		   if(alojamientos.get(i).darIdentificador().equals(identificador))
		   {
			   buscado = alojamientos.get(i);
			   encontre = true;
		   }
		}
		
		return buscado;
	}
	
	/**
	 * Nombre del metodo: calcularCostoTotalAlojamiento<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de calcular el costo total en
	 * alojamiento. Solo se tienen en cuenta los alojamientos que tienen
	 * asignados algun estudiante.<br />
	 * <b>Pre: </b> el arraylist de alojamientos debe estar inicializado. <br />
	 * 
	 * @return double que corresponde al valor total que se debe pagar en el
	 *         paseo por concepto de alojamiento para los estudiantes
	 */
	
	public double calcularCostoTotalAlojamiento()
	{
		double total = 0;
		
		for(int i =0; i< alojamientos.size(); i++)
		{
			if(alojamientos.get(i).calcularOcupacion()>0)
			{
				total += alojamientos.get(i).calcularPrecioTotal();
			}
		}
		
		return total;
	}
	
	/**
	 * Nombre del metodo: calcularCostoTotalGasolina<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de calcular el costo total en
	 * gasolina. Solo se tienen en cuenta los vehiculos que tienen asignado un
	 * alojamiento.Recuerde utilizar la constante para el 
     *  precio de galon de gasolina<br />
	 * <b>Pre: </b> el arraylist de vehiculos debe estar inicializado. <br />
	 * 
	 * @return double que corresponde al valor total que se debe pagar en el
	 *         paseo por concepto de combustible para los vehiculos
	 */
	public double calcularCostoTotalGasolina()
	{
		double total = 0;
		for(int i=0; i< vehiculos.size(); i++)
		{
			if(vehiculos.get(i).darAlojamiento()!= null)
			{
				total += (vehiculos.get(i).calcularCantidadGasolinaNecesaria()*PRECIO_GALON_GASOLINA);
			}
		}
		
		
		return total;
	}
	
	/**
	 * Nombre del metodo: asignarAlojamientoVehiculo<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de buscar un vehiculo por la placa,
	 * buscar un alojamiento por el identificador y asignar este ultimo al
	 * vehiculo encontrado<br />
	 * 
	 * * <b>Pre: </b> el arraylist de vehiculos debe estar inicializado. <br />
	 * * <b>Pre: </b> el arraylist de alojamientos debe estar inicializado. <br />
	 * 
	 * @param identificadorAlojamiento
	 *            - String que corresponde al identificador del alojamiento
	 *              el identificador del vehiculo existe
	 * @param placaVehiculo
	 *            - String que corresponde a la placa del vehiculo  
	 *            la placa del vehiculo existe
	 * @return boolean - true si el vehiculo no tenia alojamiento asignado -
	 *         false en caso contrario
	 */
	public boolean asignarAlojamientoVehiculo(String identificadorAlojamiento, String placaVehiculo)
	{
		boolean sePudo = false;
		
		Alojamiento alojamiento = buscarAlojamiento(identificadorAlojamiento);
		Vehiculo vehiculo = buscarVehiculo(placaVehiculo);
		
		if(vehiculo.darAlojamiento()== null)
		{
			vehiculo.cambiarAlojamiento(alojamiento);
			sePudo = true;
		}
		
		return sePudo;
	}
	
	/**
	 * Nombre del metodo: alojarEstudiante<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de buscar un alojamiento dado el
	 * identificador, buscar un estudiante por tipo y numero de identificacion y
	 * albergar este ultimo en el alojamiento encontrado<br />
	 * 
	 * <b>Pre: </b> el arraylist de alojamientos debe estar inicializado. <br />
	 * <b>Pre: </b> el arraylist de estudiantes debe estar inicializado. <br />
	 * <b>Pre: </b> el estudiante no ha sido alojado aun.
	 * 
	 * @param identificadorAlojamiento
	 *            - String que corresponde al identificador del alojamiento
	 *              El identificador existe
	 * @param tipoIdentificacion
	 *            - String que corresponde al tipo de identificacion <b>Pre:
	 *            </b> El tipo existe
	 * @param numeroIdentificacion
	 *            - String que corresponde al numero de identificacion <b>Pre:
	 *            </b> El numero existe
	 * @return boolean - true si se puede albergar al estudiante, false en caso
	 *         contrario
	 * 
	 */
	public boolean alojarEstudiante(String identificadorAlojamiento, String tipoIdentificacion, String numeroIdentificacion)
	{
		
		boolean sePudo = false;
		Alojamiento alojamiento = buscarAlojamiento(identificadorAlojamiento);
		Estudiante estudiante = buscarEstudiante(numeroIdentificacion, tipoIdentificacion);
		if(alojamiento.calcularOcupacion()< Alojamiento.CAPACIDAD)
		{
			try{
				
				alojamiento.albergarEstudiante(estudiante);
				sePudo = true;
				
			}catch(Exception e)
			{
				e.getMessage();
			}
		}
		
		return sePudo;
	}
	
	/**
	 * Nombre del metodo: darEstudiantes<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor de la relacion
	 * estudiantes.<br />
	 * 
	 * @return ArrayList<Estudiante> que representa la relacion con los
	 *         estudiantes
	 */
	public ArrayList<Estudiante> darEstudiantes() {
		return estudiantes;
	}
	
	
	/**
	 * Nombre del metodo: darVehiculos<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor de la relacion
	 * vehiculos.<br />
	 * 
	 * @return ArrayList<Vehiculo> que representa la relacion con los
	 *         vehiculos
	 */
	public ArrayList<Vehiculo> darVehiculos() {
		return vehiculos;
	}

	
	/**
	 * Nombre del metodo: darAlojamientos<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor de la relacion
	 * alojamientos.<br />
	 * 
	 * @return ArrayList<Alojamiento> que representa la relacion con los
	 *         alojamientos
	 */
	public ArrayList<Alojamiento> darAlojamientos() {
		return alojamientos;
	}

	
	
}
