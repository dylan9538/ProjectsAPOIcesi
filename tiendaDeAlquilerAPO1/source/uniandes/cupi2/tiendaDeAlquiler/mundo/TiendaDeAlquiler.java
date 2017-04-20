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
 * Clase que representa la tienda de alquiler
 */
public class TiendaDeAlquiler
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El producto 1
     */
    private Producto producto1;

    /**
     * El producto 2
     */
   private Producto producto2;
    
    /**
     * El producto 3
     */
    private Producto producto3;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Inicializa la tienda de alquiler con sus tres productos.
     */
    public void inicializar( )
    {
        producto1 = new Producto();
        producto1.inicializar( "Kill Bill Vol.1", "DVD", 3000 );

        producto2 = new Producto( );
        producto2.inicializar( "El Señor de los Anillos: La Trilogía","Blu-Ray", 5000 );
        
        producto3 = new Producto( );
        producto3.inicializar( "Call of Duty: Modern Warfare 2", "Video Juego PS3", 7000 );
        
     
    }

    /**
     * Retorna el producto 1
     * @return producto1
     */
    public Producto darProducto1( )
    {
        return producto1;
    }

    /**
     * Retorna el producto 2
     * @return producto2
     */
    public Producto darProducto2( )
    {
    	return producto2;
    }

    /**
     * Retorna el producto 3
     * @return producto3
     */
    public Producto darProducto3( )
    {
    	return producto3;
    }

    /**
     * Alquila el producto 1
     */
    public void alquilarProducto1( )
    {
        producto1.alquilar( );
    }

    /**
     * Alquila el producto 2
     */
    public void alquilarProducto2( )
    {
    	producto2.alquilar ();
    }

    /**
     * Alquila el producto 3
     */
    public void alquilarProducto3( )
    {
    	producto3.alquilar ();
    }

    /**
     * Cambia el precio de alquiler del producto 1.
     * @param nPrecioAlquiler El nuevo precio de alquiler del producto. nPrecioAlquiler > 0
     */
    public void cambiarPrecioAlquilerProducto1( double nPrecioAlquiler )
    {
        producto1.cambiarPrecioAlquiler( nPrecioAlquiler );
    }

    /**
     * Cambia el precio de alquiler del producto 2.
     * @param nPrecioAlquiler El nuevo precio de alquiler del producto. nPrecioAlquiler > 0
     */
    public void cambiarPrecioAlquilerProducto2( double nPrecioAlquiler )
    {
    	 producto2.cambiarPrecioAlquiler( nPrecioAlquiler );
    }

    /**
     * Cambia el precio de alquiler del producto 3.
     * @param nPrecioAlquiler El nuevo precio de alquiler del producto. nPrecioAlquiler > 0
     */
    public void cambiarPrecioAlquilerProducto3( double nPrecioAlquiler )
    {
    	 producto3.cambiarPrecioAlquiler( nPrecioAlquiler );
    }

    /**
     * Califica el producto 1.
     * @param nCalificacion La nueva calificación del producto. nCalificación >= 1 && nCalificacion <= 5
     */
    public void calificarProducto1( int nCalificacion )
    {
        producto1.calificar( nCalificacion );
    }

    /**
     * Califica el producto 2.
     * @param nCalificacion La nueva calificación del producto. nCalificación >= 1 && nCalificacion <= 5
     */
    public void calificarProducto2( int nCalificacion )
    {
    	 producto2.calificar( nCalificacion );
    }

    /**
     * Califica el producto 3.
     * @param nCalificacion La nueva calificación del producto. nCalificación >= 1 && nCalificacion <= 5
     */
    public void calificarProducto3( int nCalificacion )
    {
    	 producto3.calificar( nCalificacion );
    }

    /**
     * Retorna la suma del recaudo total de los tres productos.
     * @return El recaudo total de la tienda
     */
    public double darTotalRecaudado( )
    {
    	
    	return producto1.darTotalRecaudado()+ producto2.darTotalRecaudado()+ producto3.darTotalRecaudado();
    	
    }

    /**
     * Retorna el promedio del recaudo de cada producto.
     * @return El promedio del recaudo de cada producto de la tienda
     */
    public double darPromedioRecaudoPorProducto( )
    {
    	return darTotalRecaudado()/3;
    	
    	
    }

    /**
     * Reinicia la tienda. Reinicia sus tres productos
     */
    public void reiniciar( )
    {
  
    	producto1.reiniciar();
    	producto2.reiniciar();
    	producto3.reiniciar();
    	
    	
    	    }
    

    // -------------------------------------------------------------
    // Puntos de extensión
    // -------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}