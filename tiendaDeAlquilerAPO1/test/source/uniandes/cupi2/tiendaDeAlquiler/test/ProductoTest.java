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

package uniandes.cupi2.tiendaDeAlquiler.test;

import junit.framework.TestCase;
import uniandes.cupi2.tiendaDeAlquiler.mundo.Producto;

/**
 * Clase de prueba para Producto
 */
public class ProductoTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El producto de ProductoTest
     */
    private Producto producto;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Prepara el escenario 1
     */
    public void setupEscenario1( )
    {
        producto = new Producto( );
        producto.inicializar( "titulo", "tipo", 1000 );
    }

    /**
     * Verifica que se retornen correctamente los atributos
     */
    public void testDarAtributos( )
    {
        setupEscenario1( );

        assertEquals( "El título del producto debe ser titulo", "titulo", producto.darTitulo( ) );
        assertEquals( "El tipo debe ser tipo", "tipo", producto.darTipo( ) );
        assertEquals( "El precio del alquiler debe ser de 1000", 1000, producto.darPrecioAquiler( ), .0 );
        assertEquals( "El total recaudado debe ser 0", 0, producto.darTotalRecaudado( ), .0 );
        assertEquals( "El número de calificaciones debe ser 0", 0, producto.darNumeroCalificaciones( ) );
        assertEquals( "La calificación global debe ser 0", 0, producto.darCalificacionGlobal( ), .0 );
    }

    /**
     * Verifica que se cambie correctamente el precio de alquiler de un producto
     */
    public void testCambiarPrecioAlquiler( )
    {
        setupEscenario1( );

        producto.cambiarPrecioAlquiler( 5000 );

        assertEquals( "El precio del alquiler debe ser de 5000", 5000, producto.darPrecioAquiler( ), .0 );
    }

    /**
     * Verifica que se alquile correctamente un producto
     */
    public void testAlquilar( )
    {
        setupEscenario1( );

        producto.alquilar( );
        assertEquals( "El total recaudado debe ser $1000", 1000, producto.darTotalRecaudado( ), .0 );

        producto.alquilar( );
        producto.alquilar( );
        assertEquals( "El total recaudado debe ser $3000", 3000, producto.darTotalRecaudado( ), .0 );
    }

    /**
     * Verifica que se califique correctamente el producto
     */
    public void testCalificar( )
    {
        setupEscenario1( );

        producto.calificar( 3 );
        producto.calificar( 2 );
        producto.calificar( 5 );
        producto.calificar( 1 );

        assertTrue( "Deben haber cuatro calificaciones", producto.darNumeroCalificaciones( ) == 4 );
        assertEquals( "La calificación global del producto debe ser 2.75", 2.75, producto.darCalificacionGlobal( ), .0 );
    }

    /**
     * Verifica que el producto se reinicie correctamente
     */
    public void testReiniciar( )
    {
        setupEscenario1( );

        producto.alquilar( );
        producto.calificar( 3 );
        producto.reiniciar( );

        assertEquals( "El número de calificaciones debe ser 0", 0, producto.darNumeroCalificaciones( ) );
        assertEquals( "La calificación global debe ser 0", 0, producto.darCalificacionGlobal( ), .0 );
        assertEquals( "El total recaudado debe ser 0", 0, producto.darTotalRecaudado( ), .0 );
    }
}