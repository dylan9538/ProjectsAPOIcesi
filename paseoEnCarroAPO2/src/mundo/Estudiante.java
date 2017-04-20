package mundo;

public class Estudiante {


	/**
	* Tipo de indentificacion, cédula
	*/
	public final static  String TIPO_IDENTIFICACION_CC = "CC";
	
	
	/**
	* Tipo de indentificacion, Tarjeta de identidad
	*/
	public final static  String TIPO_IDENTIFICACION_TI = "TI";
	
	
	/**
	* Número de identificación del estudiante
	*/
	private String numeroIdentificacion;
	
	/**
	* Tipo de identificación del estudiante
	*/
	private String tipoIdentificacion;
	
	/**
	* Nombre del estudiante
	*/
	private String nombre;
	
	
	/**
	* Apellido del estudiante
	*/
	private String apellidos;
	
	/**
	* Edad el estudiante
	*/
	private int edad;


	
	
	
	/** Nombre del metodo: Estudiante (constructor)<br />
	* <br />
	* Descripcion: este metodo se encarga de crear un nuevo objeto Estudiante.
	* Inicializa los atributos con los valores que vienen como parametro<br />
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
	*/

	public Estudiante(String numeroIdentificacion, String tipoIdentificacion, String nombre,
			          String apellidos, int edad)
	{
		this.numeroIdentificacion = numeroIdentificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	/**
	 * Nombre del metodo: darNumeroIdentificacion<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * numeroIdentificacion.<br />
	 * 
	 * @return String que contiene el valor del atributo numeroIdentificacion
	 */
	
	public String darNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	
	
	/**
	 * Nombre del metodo: darTipoIdentificacion<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * tipoIdentificacion.<br />
	 * 
	 * @return String que contiene el valor del atributo tipoIdentificacion
	 */
	
	public String darTipoIdentificacion() {
		return tipoIdentificacion;
	}
	
	
	
	/**
	 * Nombre del metodo: darNombre<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * nombre.<br />
	 * 
	 * @return String que contiene el valor del atributo nombre
	 */

	public String darNombre() {
		return nombre;
	}


	/**
	 * Nombre del metodo: darApellidos<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * apellidos.<br />
	 * 
	 * @return String que contiene el valor del atributo apellidos
	 */
	
	public String darApellidos() {
		return apellidos;
	}

	
	/**
	 * Nombre del metodo: darEdad<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * edad.<br />
	 * 
	 * @return int que contiene el valor del atributo edad
	 */
	
	public int darEdad() {
		return edad;
	}
	
	
	
}
