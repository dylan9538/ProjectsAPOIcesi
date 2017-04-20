/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n1_triangulo
 * Autor: Pablo Barvo - 21-Oct-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.triangulo.test;

import junit.framework.TestCase;
import uniandes.cupi2.triangulo.mundo.Punto;
import uniandes.cupi2.triangulo.mundo.Triangulo;

/**
 * Esta es la clase usada para verificar que los m�todos de la clase Triangulo est�n correctamente implementados
 */
public class TrianguloTest extends TestCase
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es la clase donde se har�n las pruebas
     */
    private Triangulo triangulo;

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Construye un nuevo Triangulo vac�a
     *  
     */
    private void setupEscenario1( )
    {
        //Crea el tri�ngulo
        triangulo = new Triangulo( );

        //Crea el punto 1
        Punto punto1 = new Punto( );
        punto1.inicializar( 0, 4 );

        //Crea el punto 2
        Punto punto2 = new Punto( );
        punto2.inicializar( 0, 0 );

        //Crea el punto 1
        Punto punto3 = new Punto( );
        punto3.inicializar( 8, 4 );

        //Inicializa el color del relleno en Azul
        // Valor RGB = (0, 0, 150)
        uniandes.cupi2.triangulo.mundo.Color colorRelleno = new uniandes.cupi2.triangulo.mundo.Color( );
        colorRelleno.inicializar( 0, 0, 170 );

        //Inicializa el color de las l�neas en negro
        // Valor RGB = (0, 0, 0)
        uniandes.cupi2.triangulo.mundo.Color colorLineas = new uniandes.cupi2.triangulo.mundo.Color( );
        colorLineas.inicializar( 0, 0, 0 );

        //Inicializa el tri�ngulo
        triangulo.inicializar( punto1, punto2, punto3, colorRelleno, colorLineas );
    }

    /**
     * Prueba 1 - �rea del tri�ngulo
     */
    public void testArea( )
    {
        setupEscenario1( );

        assertEquals( "El �rea debe ser 16", 16, triangulo.darArea( ), 0 );
    }

    /**
     * Prueba 2 - Per�metro del Tri�ngulo
     */
    public void testPerimetro( )
    {
        setupEscenario1( );

        assertEquals( "El per�metro debe ser 20.94427190999916", 20.94427190999916, triangulo.darPerimetro( ), 0.0000000000001 );
    }

    /**
     * Prueba 3 - Altura del Tri�ngulo
     */
    public void testAltura( )
    {
        setupEscenario1( );

        assertEquals( "La altura debe ser 8", 8, triangulo.darAltura( ), 0 );
    }

}