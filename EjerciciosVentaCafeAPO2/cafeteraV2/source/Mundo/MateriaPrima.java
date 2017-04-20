package Mundo;

/**
 * TODO Put here a description of what this class does.
 *
 * @author JorgeAndres. Created 23/01/2016.
 */
public class MateriaPrima {

	// ---------------------------------------
	// Atributos
	// ---------------------------------------

	private String nombre;

	private double cantidad;

	private double cantidadMaxima;

	/**
	 * Constructor de la clase 'MateriaPrima'.
	 *
	 * @param nombre
	 * @param cantidad
	 * @param medida
	 * @param cantidadMaxima
	 */
	public MateriaPrima(String nombre, int cantidadMaxima) {

		this.modificarNombre(nombre);
		this.modificarCantidad(0.0);
		this.modificarCantidadMaxima(cantidadMaxima);

	}

	/**
	 * Returns the value of the field called 'nombre'.
	 * 
	 * @return Returns the nombre.
	 */
	public String darNombre() {
		return this.nombre;
	}

	/**
	 * Sets the field called 'nombre' to the given value.
	 * 
	 * @param nombre
	 *            The nombre to set.
	 */
	public void modificarNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Returns the value of the field called 'cantidad'.
	 * 
	 * @return Returns the cantidad.
	 */
	public double darCantidad() {
		return this.cantidad;
	}

	/**
	 * Sets the field called 'cantidad' to the given value.
	 * 
	 * @param cantidad
	 *            The cantidad to set.
	 */
	public void modificarCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Returns the value of the field called 'cantidadMaxima'.
	 * 
	 * @return Returns the cantidadMaxima.
	 */
	public double darCantidadMaxima() {
		return this.cantidadMaxima;
	}

	/**
	 * Sets the field called 'cantidadMaxima' to the given value.
	 * 
	 * @param cantidadMaxima
	 *            The cantidadMaxima to set.
	 */
	public void modificarCantidadMaxima(double cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

}
