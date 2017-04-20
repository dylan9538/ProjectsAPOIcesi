/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ParteTest.java,v 1.2 2009/02/07 21:32:23 sil-de Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_senorCaraPapa
 * Autor: Silvia de la Torre Díaz - 19-ene-2009
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.senorCaraPapa.test;

import junit.framework.TestCase;
import uniandes.cupi2.senorCaraPapa.mundo.Parte;

/**
 * Esta es la clase usada para verificar que los métodos de la clase Parte estén correctamente implementados
 */
public class ParteTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos de prueba
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private Parte parte;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------

    /**
     * Construye una parte de tipo accesorio con unidades disponibles
     */
    private void setupEscenario1( )
    {
        parte = new Parte( Parte.ACCESORIO, 78, 1234.56 );
    }

    /**
     * Construye una parte de tipo expresión facial con una unidad disponible
     */
    private void setupEscenario2( )
    {
        parte = new Parte( Parte.EXPRESION, 1, 30570.55 );
    }

    /**
     * Construye una parte de tipo brazos sin unidades disponibles
     */
    private void setupEscenario3( )
    {
        parte = new Parte( Parte.BRAZOS, 0, 16490 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Prueba que al Construir una parte, se asignen bien los valores dados por parámetro.<br>
     * <b> Métodos a probar:</b>constructor, darTipo(), darCantidadDisponible(), darPrecioBase()<br>
     * <b> Objetivo:</b>Probar que el método constructor funciona correctamente <br>
     * <b> Resultados esperados: </b> Los atributos de la parte no son intercambiados en el constructor ni tampoco en los método que los retornan<br>
     */
    public void testParte( )
    {
        setupEscenario1( );
        assertEquals( "El tipo de parte no está siendo asignado correctamente.", Parte.ACCESORIO, parte.darTipo( ) );
        assertEquals( "La cantidad disponible de la parte no está siendo asignada correctamente..", 78, parte.darCantidadDisponible( ) );
        assertEquals( "El precio base de la parte no está siendo asignado correctamente.", 1234.56, parte.darPrecioBase( ), parte.darPrecioBase( ) - 1234.56 );

        setupEscenario2( );
        assertEquals( "El tipo de parte no está siendo asignado correctamente.", Parte.EXPRESION, parte.darTipo( ) );
        assertEquals( "La cantidad disponible de la parte no está siendo asignada correctamente.", 1, parte.darCantidadDisponible( ) );
        assertEquals( "El precio base de la parte no está siendo asignado correctamente.", 30570.55, parte.darPrecioBase( ), parte.darPrecioBase( ) - 30570.55 );

        setupEscenario3( );
        assertEquals( "El tipo de parte no está siendo asignado correctamente.", Parte.BRAZOS, parte.darTipo( ) );
        assertEquals( "La cantidad disponible de la parte no está siendo asignada correctamente.", 0, parte.darCantidadDisponible( ) );
        assertEquals( "El precio base de la parte no está siendo asignado correctamente.", 16490, ( int )parte.darPrecioBase( ) );
    }

    /**
     * Prueba que al cambiar la cantidad disponible de unidades de una parte siempre se verifique que es un valor válido y solo en estos casos se modifique.<br>
     * <b> Métodos a probar:</b>cambiarCantidadDisponible(), darCantidadDisponible()<br>
     * <b> Objetivo:</b>Probar que el método cambiarCantidadDisponible() funciona correctamente <br>
     * <b> Resultados esperados: </b> Se cambia la cantidad de unidades disponibles de la parte siempre que el nuevo valor sea mayor o igual a cero<br>
     */
    public void testCambiarCantidadDisponible( )
    {
        setupEscenario1( );
        parte.cambiarCantidadDisponible( 12 );
        assertEquals( "La cantidad disponible de la parte no está siendo cambiada correctamente.", 12, parte.darCantidadDisponible( ) );

        setupEscenario2( );
        parte.cambiarCantidadDisponible( parte.darCantidadDisponible( ) - 1 );
        assertEquals( "La cantidad disponible de la parte no está siendo cambiada correctamente.", 0, parte.darCantidadDisponible( ) );

        setupEscenario3( );
        parte.cambiarCantidadDisponible( parte.darCantidadDisponible( ) - 1 );
        assertEquals( "La cantidad disponible de la parte no debería permitir valores negativos. No ha debido cambiar.", 0, parte.darCantidadDisponible( ) );
    }

    /**
     * Prueba que al cambiar el precio base de una parte siempre se verifique que es un valor válido y solo en estos casos se modifique.<br>
     * <b> Métodos a probar:</b>cambiarPrecioBase(), darPrecioBase()<br>
     * <b> Objetivo:</b>Probar que el método cambiarPrecioBase() funciona correctamente <br>
     * <b> Resultados esperados: </b> Se cambia el precio base siempre que el nuevo valor sea mayor a cero<br>
     */
    public void testCambiarPrecioBase( )
    {
        setupEscenario1( );
        parte.cambiarPrecioBase( 17350 );
        assertEquals( "La cantidad disponible de la parte no está siendo cambiada correctamente.", 17350, ( int )parte.darPrecioBase( ) );

        setupEscenario2( );
        parte.cambiarPrecioBase( 0 );
        assertEquals( "La cantidad disponible de la parte no debería permitir un valor de cero. No ha debido cambiar.", 30570.55, parte.darPrecioBase( ), parte.darPrecioBase( ) - 30570.55 );

        setupEscenario3( );
        parte.cambiarPrecioBase( -parte.darPrecioBase( ) );
        assertEquals( "La cantidad disponible de la parte no debería permitir valores negativos. No ha debido cambiar.", 16490, ( int )parte.darPrecioBase( ) );
    }
}