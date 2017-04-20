package mundo;

public class Vehiculo {

	public static final String TIPO_VEHICULO_ECONOMICO = "Economico";
	public static final String TIPO_VEHICULO_MEDIO = "Medio";
	public static final String TIPO_VEHICULO_LUJO = "Lujo";
	private static final double CAPACIDAD_30 = 30;
	private static final double CAPACIDAD_45 = 45;
	private static final double CAPACIDAD_60 = 60;
	
	/**
	* Placa del vehiculo
	*/
	private String placa;
	
	/**
	* tipo de vehiculo
	*/
	private String tipoVehiculo;
	
	/**
	* Capacidad de kilometros por galon
	*/
	private double capacidadKilometrosPorGalon;
	
	private Alojamiento alojamiento;
	
	/**
	 * Nombre del metodo: Vehiculo (constructor)<br />
	 * <br />
	 * Descripcion: este metodo se encarga de crear un nuevo objeto Vehiculo.
	 * Igualmente, se encarga de hacer el llamado a los metodos definidos para
	 * inicializar los atributos capacidadKilometrosPorGalon.<br />
	 * <br />
	 * 
	 * @param placa
	 *            - String que contiene la placa del vehiculo
	 * @param tipoVehiculo
	 *            - String que indica el tipo del vehiculo
	 * @throws Exception
	 *             - Lanza una excepcion si la placa no tiene el formato AAA###
	 *             (tres vocales en mayúscula seguido de tres numeros enteros)
	 * @throws Exception
	 *             - Lanza una excepción si el tipo de vehiculo NO es una cadena
	 *             con alguno de los valores definidos en las constantes
	 */

	
	public Vehiculo(String placa, String tipoVehiculo) throws Exception
	{ 
		if(placa.equals("")|| !esVocalMayuscula(placa.charAt(0)) || !esVocalMayuscula(placa.charAt(1)) || !esVocalMayuscula(placa.charAt(2)) ||
				!esDigito(placa.charAt(3)) || !esDigito(placa.charAt(4)) || !esDigito(placa.charAt(5)))
		{
		  throw new Exception ("la placa no posee el formato AAA### (tres vocales en mayúscula seguido de tres numeros enteros)");
		}
		
		
		else if(!tipoVehiculo.equalsIgnoreCase(TIPO_VEHICULO_ECONOMICO) && !tipoVehiculo.equalsIgnoreCase(TIPO_VEHICULO_MEDIO)
				&& !tipoVehiculo.equalsIgnoreCase(TIPO_VEHICULO_LUJO))
		{
			throw new Exception ("Asegurese de escribir bien los tipos de vehiculo : Economico, Medio, Lujo (no importa mayuscula)");
		}
		
		else {
			this.placa = placa;
			this.tipoVehiculo = tipoVehiculo;
			asignarCapacidades();
		}
		
		
	}
	
	
	/**
	 * Nombre del metodo: asignarCapacidades<br />
	 * <br />
	 * Descripcion: Este metodo se encarga de inicializar el atributo que hace
	 * referencia a la capacidad de kilometros por galon del vehiculo. Todo
	 * depende del tipo de vehiculo: si es un vehiculo tipo economico tiene un
	 * rendimiento de 60 kilometros por galon; si es un vehiculo tipo medio
	 * tiene un rendimiento de 45 kilometros por galon; si es un vehiculo tipo
	 * lujo, tiene un rendimiento de 30 kilometros por galon.<br />
	 * <br />
	 * <b>Pre: </b> el atributo tipoVehiculo debe estar inicializado con uno de
	 * los valores definidos en las constantes.
	 */

	private void asignarCapacidades ()
	{
		if(tipoVehiculo.equalsIgnoreCase(TIPO_VEHICULO_ECONOMICO))
		{
			capacidadKilometrosPorGalon = CAPACIDAD_60;
		}
		
		else if(tipoVehiculo.equalsIgnoreCase(TIPO_VEHICULO_MEDIO))
		{
			capacidadKilometrosPorGalon = CAPACIDAD_45;
		}
		
		else capacidadKilometrosPorGalon = CAPACIDAD_30;
	}
	
	/**
	 * Nombre del metodo: calcularCantidadGasolinaNecesaria<br />
	 * <br />
	 * Descripcion: Este metodo determina la cantidad de galones de gasolina
	 * necesaria para recorrer la distancia al alojamiento. Para ello se tiene
	 * en cuenta la capacidad de kilometros por galon del vehiculo.<br />
	 * 
	 * @return double que corresponde a la cantidad de galones necesaria para
	 *         recorrer la distancia hasta el alojamiento. Si no hay alojamiento
	 *         asignado, entonces la cantidad a retornar es 0.
	 */
	public double calcularCantidadGasolinaNecesaria()
	{
		if(alojamiento == null)
			return 0;
		
		else 
			return alojamiento.darDistancia()/capacidadKilometrosPorGalon;
	}

	/**
	 * Nombre del metodo: cambiarAlojamiento<br />
	 * <br />
	 * Descripcion: este metodo se encarga de asignar el parametro a la
	 * relacion alojamiento.<br />
	 * 
	 * @param Alojamiento
	 *            - objeto que representa la relacion que va a tener el vehiculo
	 *            con un alojamiento<br />
	 * <br />
	 *            <b>Post:</b> la relacion alojamiento debe cambiar por el
	 *            parametro recibido
	 */
	
	public void cambiarAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}
	
	
	
	/**
	 * Nombre del metodo: esVocalMayuscula (opcional)<br />
	 * <br />
	 * Descripcion: este metodo opcional permite determinar si un caracter es
	 * una vocal o no.<br />
	 * <br />
	 * 
	 * @param letra
	 *            - char que corresponde al caracter que se desea evaluar
	 * @return boolean que indica si es vocal (true) o si no lo es (false)
	 */
	private boolean esVocalMayuscula(char letra)
	{
		
		boolean esVocal;
		switch (letra) {
		case 'A':
			 esVocal=true;
			 break;
		case 'E':
			 esVocal=true;
			 break;
		case 'I':
			 esVocal=true;
			 break;
		case 'O':
			 esVocal=true;
			 break;
		case 'U':
			 esVocal=true;
			break;

		default: esVocal = false;
			break;
		}
		
		return esVocal;
	}

	

	/**
	 * Nombre del metodo: esDigito (opcional)<br />
	 * <br />
	 * Descripcion: este metodo opcional permite determinar si un caracter es
	 * un digito o no.<br />
	 * <br />
	 * 
	 * @param letra
	 *            - char que corresponde al caracter que se desea evaluar
	 * @return boolean que indica si es digito (true) o si no lo es (false)
	 */
	
	private boolean esDigito(char letra)
	{
		
		boolean esDigito;
		switch (letra) {
		case '0':
			 esDigito=true;
			 break;
		case '1':
			 esDigito=true;
			 break;
		case '2':
			 esDigito=true;
			 break;
		case '3':
			 esDigito=true;
			 break;
		case '4':
			 esDigito=true;
			break;
		case '5':
			 esDigito=true;
			break;
		case '6':
			 esDigito=true;
			break;
		case '7':
			 esDigito=true;
			break;
		case '8':
			 esDigito=true;
			break;
		case '9':
			 esDigito=true;
			break;

		default: esDigito = false;
			break;
		}
	
		return esDigito;
	}
	
	/**
	 * Nombre del metodo: darTipoVehiculo<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * tipoVehiculo.<br />
	 * 
	 * @return String que contiene el valor del atributo tipoVehiculo
	 */
	public String darTipoVehiculo() {
		return tipoVehiculo;
	}
		
	/**
	 * Nombre del metodo: darAlojamiento<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor de la relacion
	 * alojamiento.<br />
	 * 
	 * @return Alojamiento que representa la relacion con el alojamiento
	 */
	public Alojamiento darAlojamiento() {
		return alojamiento;
	}

	
	/**
	 * Nombre del metodo: darPlaca<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * placa.<br />
	 * 
	 * @return String que contiene el valor del atributo placa
	 */
	public String darPlaca() {
		return placa;
	}


	
	
	/**
	 * Nombre del metodo: darCapacidadKilometrosPorGalon<br />
	 * <br />
	 * Descripcion: este metodo se encarga de retornar el valor del atributo
	 * capacidadKilometrosPorGalon.<br />
	 * 
	 * @return double que contiene el valor del atributo
	 *         capacidadKilometrosPorGalon
	 */
	public double darCapacidadKilometrosPorGalon() {
		return capacidadKilometrosPorGalon;
	}
	
	
}
