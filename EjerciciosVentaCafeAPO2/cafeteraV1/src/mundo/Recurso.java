package mundo;

public class Recurso {
	private int identificador;
	private String nombre;
	private double cantidadMaxima;
	private double cantidadActual;
	private double cantidadXCafe;
	private String unidad;

	public Recurso(int id, String nom, double cM, double cA, double cxC,
			String un) {
		identificador = id;
		nombre = nom;
		cantidadMaxima = cM;
		cantidadActual = cA;
		cantidadXCafe = cxC;
		unidad = un;
	}

public void abastecer(double cantidadAbastecer)	throws SuministroRecursoException {
		
 if((cantidadActual+cantidadAbastecer)>cantidadMaxima){
	throw new SuministroRecursoException(nombre, cantidadActual,cantidadAbastecer,cantidadMaxima);
		}
  cantidadActual += cantidadAbastecer;
}

	
	public boolean hayDisponibilidad() {
		return cantidadActual >= cantidadXCafe;
	}

	/**
	 * pre: hayDisponibilidad()==true //Esto debe haberse verificado previamente
	 * a trav�s de excepciones
	 */
	public void usarParaHacerCafe() {
		cantidadActual -= cantidadXCafe;
	}

	/**
	 * 
	 * @param cA
	 *            , es la cantidad a asignar, cA>=0
	 */
	public void cambiarCantidadActual(double cA) {
		cantidadActual = cA;
	}

	public int darIdentificador() {
		return identificador;
	}

	public String darNombre() {
		return nombre;
	}

	public double darCantidadMaxima() {
		return cantidadMaxima;
	}

	public double darCantidadActual() {
		return cantidadActual;
	}

	public double darCantidadXCafe() {
		return cantidadXCafe;
	}

	public String darUnidad() {
		return unidad;
	}
}
