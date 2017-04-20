package mundo;

public class Alojamiento {

	
	
	/**
	* Capacidad maxima de estudiantes
	*/
	public final static int CAPACIDAD = 5;
	
	/**
	* Precio por estudiante
	*/
	public final static double PRECIO_POR_PERSONA = 12000;
	
	/**
	* valor porcentual del impuesto del alojamiento
	*/
	public final static double PORCENTAJE_IMPUESTO = 14.5;
	
	/**
	* Distancia del alojamiento
	*/
	public final static double DISTANCIA = 80;
	
	/**
	* Identificador del alojamiento
	*/
	private String identificador;
	
	/**
	* capacidad del alojamiento
	*/
	private int capacidad;
	
	/**
	* Precio por persona del alojamiento
	*/
	private double precioPorPersona;
	
	
	/**
	* distancia del alojamiento
	*/
	private double distancia;
	
	/**
	* Arreglo de estudiantes
	*/
	private Estudiante[] estudiantes;
	
	/**
	 * Nombre del metodo: Alojamiento (constructor)<br />
	 * <br />
	 * Descripcion: este metodo se encarga de crear un nuevo objeto Alojamiento.
	 * Inicializa los atributos capacidad, precioPorPersona y distancia con los
	 * valores de las constantes. Inicializa el arreglo de estudiantes<br />
	 * 
	 */
	public Alojamiento(String identificador)
	{
		this.identificador = identificador;
		estudiantes = new Estudiante[CAPACIDAD];
		capacidad = CAPACIDAD;
		precioPorPersona = PRECIO_POR_PERSONA;
		distancia = DISTANCIA;
	}
	
	/**
	 * Nombre del metodo: albergarEstudiante<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de guardar en una posicion libre del
	 * arreglo de estudiantes el estudiante recibido como
	 * parametro<br />
	 * <br />
	 * <b>Pre: </b> el arreglo de estudiantes debe estar inicializado. <br />
	 * <b>Post: </b> el arreglo de estudiantes debe quedar con una posicion mas
	 * ocupada.
	 * 
	 * @param Estudiante
	 *            - objeto de tipo estudiante que representa al nuevo huesped
	 *            del alojamiento. estudiante != null
	 * 
	 * @throws Exception
	 *             - lanza una excepcion si no se puede asignar al estudiante.
	 *             Puede utilizarse el metodo calcularOcupacion como ayuda.
	 * 
	 */
	public void albergarEstudiante(Estudiante estudiante) throws Exception
	{
		int contador = calcularOcupacion();
		
		if(contador<CAPACIDAD)
		{
			estudiantes[contador]= estudiante;
		}
		
		else {
			throw new Exception("No se pueden agregar mas estudiantes");
		}
	}
	
	/**
	 * Nombre del metodo: calcularOcupacion<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de retornar un valor entero que
	 * indica cuantos estudiantes hay registrados en el alojamiento<br />
	 * <br />
	 * <b>Pre: </b> el arreglo de estudiantes debe estar inicializado.
	 * 
	 * @return int - valor que representa el numero de estudiantes albergados en
	 *         el alojamiento.
	 * 
	 */
	
	public int calcularOcupacion()
	{
		int contador = 0;
		
		for(int i = 0; i < estudiantes.length; i++)
		{
			if(estudiantes[i]!= null)
			{
				contador++;
			}
		}
		
		return contador;
		
	}
	
	/**
	 * Nombre del metodo: calcularPrecioTotal<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de retornar el valor que se debe
	 * pagar por el alojamiento. Para ello se tiene en cuenta solo los
	 * estudiantes albergados y el precio por persona. Debe incluir un impuesto
	 * sobre el valor total. Este impuesto esta en la contante
	 * PORCENTAJE_IMPUESTO. Si esa constante tiene como valor, 20.4, entonces el
	 * porcentaje de impuesto es 20.4%<br />
	 * <b>Pre: </b> el arreglo de estudiantes debe estar inicializado.
	 * 
	 * @return double - valor que representa el precio a pagar por el
	 *         alojamiento de los estudiantes.
	 * 
	 */
	public double calcularPrecioTotal()
	{
		int cantidadPersonas = calcularOcupacion();
		return ((cantidadPersonas*PRECIO_POR_PERSONA)+(((cantidadPersonas*PRECIO_POR_PERSONA)*PORCENTAJE_IMPUESTO)/100));
		
	}

	/**
	 * Nombre del metodo: darIdentificador<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * identificador.<br />
	 * 
	 * @return String que contiene el valor del atributo identificador
	 */
	public String darIdentificador() {
		return identificador;
	}



	/**
	 * Nombre del metodo: darCapacidad<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * capacidad.<br />
	 * 
	 * @return int que contiene el valor del atributo capacidad
	 */

	public int darCapacidad() {
		return capacidad;
	}


	/**
	 * Nombre del metodo: darPrecioPorPersona<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * precioPorPersona.<br />
	 * 
	 * @return double que contiene el valor del atributo precioPorPersona
	 */
	public double darPrecioPorPersona() {
		return precioPorPersona;
	}


	/**
	 * Nombre del metodo: darDistancia<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * distancia.<br />
	 * 
	 * @return double que contiene el valor del atributo distancia
	 */
	public double darDistancia() {
		return distancia;
	}

	/**
	 * Nombre del metodo: darEstudiantes<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor de la relacion
	 * estudiantes.<br />
	 * 
	 * @return Estudiante[] que representa la relacion con los
	 *         estudiantes
	 */
	public Estudiante[] darEstudiantes() {
		return estudiantes;
	}
	
	
	
}
