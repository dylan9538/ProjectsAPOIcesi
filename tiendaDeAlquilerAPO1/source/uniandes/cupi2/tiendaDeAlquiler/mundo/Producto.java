/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: tiendaDeAlquiler
 * Autor: Rafael Muñoz Lattion - 05-mar-2012
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.tiendaDeAlquiler.mundo;

/**
 * Esta clase representa un producto de la tienda de alquiler
 */
public class Producto
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El título del producto
     */
    private String titulo;

    /**
     * El tipo del producto
     */
    private String tipo;

    /**
     * El precio de alquiler del producto
     */
    private double precioAlquiler;
    /**
     * El total recaudado por el producto
     */
    private double totalRecaudado;

    /**
     * El número de veces que el producto ha sido calificado
     */
    private int numeroCalificaciones;

    /**
     * Calificación global del producto
     */
    private double calificacionGlobal;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Inicializa un producto con su información básica dada por parámetro. 
     * El número de calificaciones, la calificación global del producto y su recaudo total deben ser inicializados en 0.
     * @param nTitulo El título del producto. nTitulo != null && nTitulo != ""
     * @param nTipo El tipo del producto. nTipo != null && nTipo != ""
     * @param nPrecioAlquiler El precio de alquiler del producto. nPrecioAlquiler > 0
     */
    public void inicializar( String nTitulo, String nTipo, double nPrecioAlquiler )
    {
    	
    	titulo = nTitulo;
    	tipo = nTipo;
    	precioAlquiler = nPrecioAlquiler;
     totalRecaudado = 0;
	numeroCalificaciones = 0;
	calificacionGlobal = 0;
		
		
    }

    /**
     * Retorna el título del producto.
     * @return titulo
     */
    public String darTitulo( )
    {
        return titulo;
    }

    /**
     * Retorna el tipo del producto.
     * @return tipo
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el precio de alquiler del producto.
     * @return precioAlquiler
     */
    public double darPrecioAquiler( )
    {
    	return precioAlquiler; 
    }

    /**
     * Retorna el número de calificaciones que tiene el producto.
     * @return numeroCalificaciones
     */
    public int darNumeroCalificaciones( )
    {
        return numeroCalificaciones;
    }

    /**
     * Retorna la calificación del producto.
     * @return calificacionGlobal
     */
    public double darCalificacionGlobal( )
    {
        return calificacionGlobal;
    }

    /**
     * Retorna el total recaudado por el producto.
     * @return totalRecaudado
     */
    public double darTotalRecaudado( )
    {
        return totalRecaudado;
    }

    /**
     * Cambia el precio de alquiler del producto por el valor dado por parámetro.
     * @param nPrecioAlquiler El nuevo precio de alquiler del producto. nPrecioAlquiler > 0
     */
    public void cambiarPrecioAlquiler( double nPrecioAlquiler )
    {
    	precioAlquiler = nPrecioAlquiler;
    }

    /**
     * Se aumenta el total recaudado con el precio de alquiler del producto.
     */
    public void alquilar( )
    {
    	totalRecaudado = precioAlquiler + totalRecaudado;
   
    }
    /**
     * Califica un producto y actualiza su calificación global de acuerdo a la calificación que llega por parámetro.
     * La calificación global del producto se obtiene calculando el promedio de todas las calificaciones que ha recibido el producto.
     * Debe incrementar en uno el número de calificaciones y después debe volver a calcular la calificación global.
     * @param nCalificacion La nueva calificación del producto. nCalificacion >= 1 && nCalificacion <= 5
     */
    public void calificar( int nCalificacion )
    {
    	
    
    	numeroCalificaciones = numeroCalificaciones + 1;
    	calificacionGlobal = ((numeroCalificaciones-1)* calificacionGlobal + nCalificacion)/numeroCalificaciones;
    	
    }
    
   

    /**
     * Reinicia el producto. El número de calificaciones, su calificación global y su total recaudado vuelven a ser 0.
     */
    public void reiniciar( )
    {
    	numeroCalificaciones = 0;
    	calificacionGlobal = 0;
    	totalRecaudado = 0;
    }
}