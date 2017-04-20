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
import uniandes.cupi2.tiendaDeAlquiler.mundo.TiendaDeAlquiler;

/**
 * Clase de prueba para TiendaDeAlquiler
 */
public class TiendaDeAlquilerTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * La tiendaDeAlquiler de TiendaDeAlquilerTest
     */
    private TiendaDeAlquiler tiendaDeAlquiler;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Prepara el escenario 1
     */
    public void setupEscenario1( )
    {
        tiendaDeAlquiler = new TiendaDeAlquiler( );
        tiendaDeAlquiler.inicializar( );
    }

    /**
     * Verifica que se retorne correctamente el producto 1
     */
    public void testDarProducto1( )
    {
        setupEscenario1( );

        assertNotNull( "El producto 1 no puede ser nulo", tiendaDeAlquiler.darProducto1( ) );
        assertEquals( "El título del producto 1 debe ser Kill Bill Vol.1", "Kill Bill Vol.1", tiendaDeAlquiler.darProducto1( ).darTitulo( ) );
    }

    /**
     * Verifica que se retorne correctamente el producto 2
     */
    public void testDarProducto2( )
    {
        setupEscenario1( );

        assertNotNull( "El producto 2 no puede ser nulo", tiendaDeAlquiler.darProducto2( ) );
        assertEquals( "El título del producto 2 debe ser El Señor de los Anillos: La Trilogía", "El Señor de los Anillos: La Trilogía", tiendaDeAlquiler.darProducto2( ).darTitulo( ) );
    }

    /**
     * Verifica que se retorne correctamente el producto 1
     */
    public void testDarProducto3( )
    {
        setupEscenario1( );

        assertNotNull( "El producto 3 no puede ser nulo", tiendaDeAlquiler.darProducto3( ) );
        assertEquals( "El título del producto 3 debe ser Call of Duty: Modern Warfare 2", "Call of Duty: Modern Warfare 2", tiendaDeAlquiler.darProducto3( ).darTitulo( ) );
    }

    /**
     * Verifica que se alquile correctamente el producto 1
     */
    public void testAlquilarProducto1( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.alquilarProducto1( );
        assertEquals( "El total recaudado del producto 1 debe ser $3000", 3000, tiendaDeAlquiler.darProducto1( ).darTotalRecaudado( ), .0 );

        tiendaDeAlquiler.alquilarProducto1( );
        tiendaDeAlquiler.alquilarProducto1( );
        assertEquals( "El total recaudado del producto 1 debe ser $9000", 9000, tiendaDeAlquiler.darProducto1( ).darTotalRecaudado( ), .0 );
    }

    /**
     * Verifica que se alquile correctamente el producto 2
     */
    public void testAlquilarProducto2( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.alquilarProducto2( );
        assertEquals( "El total recaudado del producto 2 debe ser $5000", 5000, tiendaDeAlquiler.darProducto2( ).darTotalRecaudado( ), .0 );

        tiendaDeAlquiler.alquilarProducto2( );
        tiendaDeAlquiler.alquilarProducto2( );
        assertEquals( "El total recaudado del producto 2 debe ser $9000", 15000, tiendaDeAlquiler.darProducto2( ).darTotalRecaudado( ), .0 );
    }

    /**
     * Verifica que se alquile correctamente el producto 3
     */
    public void testAlquilarProducto3( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.alquilarProducto3( );
        assertEquals( "El total recaudado del producto 3 debe ser $7000", 7000, tiendaDeAlquiler.darProducto3( ).darTotalRecaudado( ), .0 );

        tiendaDeAlquiler.alquilarProducto3( );
        tiendaDeAlquiler.alquilarProducto3( );
        assertEquals( "El total recaudado del producto 3 debe ser $9000", 21000, tiendaDeAlquiler.darProducto3( ).darTotalRecaudado( ), .0 );
    }

    /**
     * Verifica que se cambie correctamente el precio de alquiler del producto 1
     */
    public void testCambiarPrecioAlquilerProducto1( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.cambiarPrecioAlquilerProducto1( 1000 );

        assertEquals( "El precio de alquiler del producto 1 debe ser de 1000", 1000, tiendaDeAlquiler.darProducto1( ).darPrecioAquiler( ), .0 );
    }

    /**
     * Verifica que se cambie correctamente el precio de alquiler del producto 2
     */
    public void testCambiarPrecioAlquilerProducto2( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.cambiarPrecioAlquilerProducto2( 1000 );

        assertEquals( "El precio de alquiler del producto 2 debe ser de 1000", 1000, tiendaDeAlquiler.darProducto2( ).darPrecioAquiler( ), .0 );
    }

    /**
     * Verifica que se cambie correctamente el precio de alquiler del producto 3
     */
    public void testCambiarPrecioAlquilerProducto3( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.cambiarPrecioAlquilerProducto3( 1000 );

        assertEquals( "El precio de alquiler del producto 3 debe ser de 1000", 1000, tiendaDeAlquiler.darProducto3( ).darPrecioAquiler( ), .0 );
    }

    /**
     * Verifica que se califique correctamente el producto 1
     */
    public void testCalificarProducto1( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.calificarProducto1( 3 );
        tiendaDeAlquiler.calificarProducto1( 2 );
        tiendaDeAlquiler.calificarProducto1( 5 );
        tiendaDeAlquiler.calificarProducto1( 1 );

        assertEquals( "La calificación global del producto 1 debe ser 2.75", 2.75, tiendaDeAlquiler.darProducto1( ).darCalificacionGlobal( ), .0 );
    }

    /**
     * Verifica que se califique correctamente el producto 2
     */
    public void testCalificarProducto2( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.calificarProducto2( 3 );
        tiendaDeAlquiler.calificarProducto2( 2 );
        tiendaDeAlquiler.calificarProducto2( 5 );
        tiendaDeAlquiler.calificarProducto2( 1 );

        assertEquals( "La calificación global del producto 2 debe ser 2.75", 2.75, tiendaDeAlquiler.darProducto2( ).darCalificacionGlobal( ), .0 );
    }

    /**
     * Verifica que se califique correctamente el producto 3
     */
    public void testCalificarProducto3( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.calificarProducto3( 3 );
        tiendaDeAlquiler.calificarProducto3( 2 );
        tiendaDeAlquiler.calificarProducto3( 5 );
        tiendaDeAlquiler.calificarProducto3( 1 );

        assertEquals( "La calificación global del producto 3 debe ser 2.75", 2.75, tiendaDeAlquiler.darProducto3( ).darCalificacionGlobal( ), .0 );
    }

    /**
     * Verifica que se calcule correctamente el total recaudado por los tres productos
     */
    public void testDarTotalRecaudado( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.alquilarProducto1( );
        tiendaDeAlquiler.alquilarProducto2( );
        tiendaDeAlquiler.alquilarProducto2( );
        tiendaDeAlquiler.alquilarProducto3( );
        tiendaDeAlquiler.alquilarProducto3( );
        tiendaDeAlquiler.alquilarProducto3( );

        assertEquals( "La tienda de alquiler de tener recaudado $34000", 34000, tiendaDeAlquiler.darTotalRecaudado( ), .0 );
    }

    /**
     * Verifica que se calcule correctamente el promedio recaudado por los tres productos
     */
    public void testDarPromedioRecaudado( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.alquilarProducto1( );
        tiendaDeAlquiler.alquilarProducto2( );
        tiendaDeAlquiler.alquilarProducto2( );
        tiendaDeAlquiler.alquilarProducto3( );
        tiendaDeAlquiler.alquilarProducto3( );
        tiendaDeAlquiler.alquilarProducto3( );
        assertEquals( "Cada producto de la tienda de alquiler recauda alrededor de $11333.33", 11333.33, tiendaDeAlquiler.darPromedioRecaudoPorProducto( ), .01 );
    }

    /**
     * Verifica que se reinicie correctamente la tienda de alquiler
     */
    public void testReiniciar( )
    {
        setupEscenario1( );

        tiendaDeAlquiler.alquilarProducto1( );
        tiendaDeAlquiler.alquilarProducto2( );
        tiendaDeAlquiler.alquilarProducto3( );
        tiendaDeAlquiler.calificarProducto1( 4 );
        tiendaDeAlquiler.calificarProducto2( 4 );
        tiendaDeAlquiler.calificarProducto3( 4 );

        tiendaDeAlquiler.reiniciar( );

        assertEquals( "El número de calificaciones del producto 1 debe ser 0", 0, tiendaDeAlquiler.darProducto1( ).darNumeroCalificaciones( ) );
        assertEquals( "La calificación global del producto 1 debe ser 0", 0, tiendaDeAlquiler.darProducto1( ).darCalificacionGlobal( ), .0 );
        assertEquals( "El total recaudado del producto 1 debe ser 0", 0, tiendaDeAlquiler.darProducto1( ).darTotalRecaudado( ), .0 );

        assertEquals( "El número de calificaciones del producto 2 debe ser 0", 0, tiendaDeAlquiler.darProducto2( ).darNumeroCalificaciones( ) );
        assertEquals( "La calificación global del producto 2 debe ser 0", 0, tiendaDeAlquiler.darProducto2( ).darCalificacionGlobal( ), .0 );
        assertEquals( "El total recaudado del producto 2 debe ser 0", 0, tiendaDeAlquiler.darProducto2( ).darTotalRecaudado( ), .0 );

        assertEquals( "El número de calificaciones del producto 3 debe ser 0", 0, tiendaDeAlquiler.darProducto3( ).darNumeroCalificaciones( ) );
        assertEquals( "La calificación global del producto 3 debe ser 0", 0, tiendaDeAlquiler.darProducto3( ).darCalificacionGlobal( ), .0 );
        assertEquals( "El total recaudado del producto 3 debe ser 0", 0, tiendaDeAlquiler.darProducto3( ).darTotalRecaudado( ), .0 );

        assertEquals( "El total recaudado de la tienda debe ser 0", 0, tiendaDeAlquiler.darTotalRecaudado( ), .0 );

        assertEquals( "El promedio recaudado por cada producto debe ser 0", 0, tiendaDeAlquiler.darPromedioRecaudoPorProducto( ), .0 );
    }
}