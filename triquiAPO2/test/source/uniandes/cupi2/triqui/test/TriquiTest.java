/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: TriquiTest.java,v 1.5 2005/12/02 12:26:03 pa-barvo Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Triqui
 * Autor inicial: Katalina Marcos
 * Modificación: Jorge Jiménez- Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.triqui.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.triqui.mundo.Triqui;

/**
 * Clase de prueba para el juego del triqui
 */
public class TriquiTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Juego del triqui
     */
    private Triqui triqui;
    /**
     * Marca asignada al jugador 1
     */
    private String marcaJugador1;
    /**
     * Marca asignada al jugador 2
     */
    private String marcaJugador2;
    /**
     * Casillas del jugador 1
     */
    private ArrayList casillasJugador1;
    /**
     * Casillas del jugador 2
     */
    private ArrayList casillasJugador2;
    /**
     * Casillas sin marcar
     */
    private ArrayList casillasSinMarcar;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Prepara los datos de prueba para el escenario 1
     */
    private void setupEscenario1( )
    {
        String todasMarcadas, casillasSinMarca;
        String[] marcadas, noMarcadas;
        int casilla;
        // Prepara el tablero
        triqui = new Triqui( );

        // Primer jugador

        marcaJugador1 = "X";
        todasMarcadas = "1,3,5,9";
        marcadas = todasMarcadas.split( "," );
        casillasJugador1 = new ArrayList( );

        for( int i = 0; i < marcadas.length; i++ )
        {
            casilla = Integer.parseInt( marcadas[ i ] );
            triqui.marcarCasilla( casilla, marcaJugador1 );
            casillasJugador1.add( new Integer( casilla ) );
        }

        // Segundo jugador

        marcaJugador2 = "O";
        todasMarcadas = "2,6,7,8";
        marcadas = todasMarcadas.split( "," );
        casillasJugador2 = new ArrayList( );

        for( int i = 0; i < marcadas.length; i++ )
        {
            casilla = Integer.parseInt( marcadas[ i ] );
            triqui.marcarCasilla( casilla, marcaJugador2 );
            casillasJugador2.add( new Integer( casilla ) );
        }

        // Casillas sin marcar

        casillasSinMarca = "4";
        noMarcadas = casillasSinMarca.split( "," );
        casillasSinMarcar = new ArrayList( );

        for( int i = 0; i < noMarcadas.length; i++ )
        {
            casilla = Integer.parseInt( noMarcadas[ i ] );
            casillasSinMarcar.add( new Integer( casilla ) );
        }
    }

    /**
     * Prepara los datos de prueba para el escenario 2
     */
    private void setupEscenario2( )
    {
        String todasMarcadas, casillasSinMarca;
        String[] marcadas, noMarcadas;
        int casilla;
        // Prepara el tablero
        triqui = new Triqui( );

        // Primer jugador

        marcaJugador1 = "X";
        todasMarcadas = "1,2,3,4";
        marcadas = todasMarcadas.split( "," );
        casillasJugador1 = new ArrayList( );

        for( int i = 0; i < marcadas.length; i++ )
        {
            casilla = Integer.parseInt( marcadas[ i ] );
            triqui.marcarCasilla( casilla, marcaJugador1 );
            casillasJugador1.add( new Integer( casilla ) );
        }

        // Segundo jugador

        marcaJugador2 = "O";
        todasMarcadas = "5,6,7,8";
        marcadas = todasMarcadas.split( "," );
        casillasJugador2 = new ArrayList( );

        for( int i = 0; i < marcadas.length; i++ )
        {
            casilla = Integer.parseInt( marcadas[ i ] );
            triqui.marcarCasilla( casilla, marcaJugador2 );
            casillasJugador2.add( new Integer( casilla ) );
        }

        // Casillas sin marcar

        casillasSinMarca = "9";
        noMarcadas = casillasSinMarca.split( "," );
        casillasSinMarcar = new ArrayList( );

        for( int i = 0; i < noMarcadas.length; i++ )
        {
            casilla = Integer.parseInt( noMarcadas[ i ] );
            casillasSinMarcar.add( new Integer( casilla ) );
        }
    }
    /**
     * Prepara los datos de prueba para el escenario 3
     */
    private void setupEscenario3( )
    {
        String todasMarcadas, casillasSinMarca;
        String[] marcadas, noMarcadas;
        int casilla;
        // Prepara el tablero
        triqui = new Triqui( );

        // Primer jugador

        marcaJugador1 = "X";
        todasMarcadas = "1,3,7,9";
        marcadas = todasMarcadas.split( "," );
        casillasJugador1 = new ArrayList( );

        for( int i = 0; i < marcadas.length; i++ )
        {
            casilla = Integer.parseInt( marcadas[ i ] );
            triqui.marcarCasilla( casilla, marcaJugador1 );
            casillasJugador1.add( new Integer( casilla ) );
        }

        // Segundo jugador

        marcaJugador2 = "O";
        todasMarcadas = "2,4,6,8";
        marcadas = todasMarcadas.split( "," );
        casillasJugador2 = new ArrayList( );

        for( int i = 0; i < marcadas.length; i++ )
        {
            casilla = Integer.parseInt( marcadas[ i ] );
            triqui.marcarCasilla( casilla, marcaJugador2 );
            casillasJugador2.add( new Integer( casilla ) );
        }

        // Casillas sin marcar

        casillasSinMarca = "5";
        noMarcadas = casillasSinMarca.split( "," );
        casillasSinMarcar = new ArrayList( );

        for( int i = 0; i < noMarcadas.length; i++ )
        {
            casilla = Integer.parseInt( noMarcadas[ i ] );
            casillasSinMarcar.add( new Integer( casilla ) );
        }
    }
    /**
     * Verifica que las casillas del jugador 1 tengan su marca
     */
    public void testCasillasJugador1( )
    {
        setupEscenario1( );
        int tamanho = casillasJugador1.size( );
        int casilla;
        int i = 0;
        while( i < tamanho )
        {
            casilla = ( ( Integer )casillasJugador1.get( i ) ).intValue( );
            assertEquals( marcaJugador1, triqui.obtenerMarcaCasilla( casilla ) );
            i++;
        }
    }

    /**
     * Verifica que las casillas del jugador 2 tengan su marca
     */
    public void testCasillasJugador2( )
    {
        setupEscenario2( );
        int tamanho = casillasJugador2.size( );
        int casilla;
        int i = 0;
        while( i < tamanho )
        {
            casilla = ( ( Integer )casillasJugador2.get( i ) ).intValue( );
            assertEquals( marcaJugador2, triqui.obtenerMarcaCasilla( casilla ) );
            i++;
        }
    }

    /**
     * Verifica que todas las casillas sin marca estén vacías
     */
    public void testCasillasVacias( )
    {
        setupEscenario3( );
        int tamanho = casillasSinMarcar.size( );
        int casilla;
        int i = 0;
        while( i < tamanho )
        {
            casilla = ( ( Integer )casillasSinMarcar.get( i ) ).intValue( );
            assertTrue( triqui.casillaVacia( casilla ) );
            i++;
        }
    }

    /**
     * Verifica que después de limpiar el tablero todas las casillas estén vacías
     */
    public void testLimpiarTablero( )
    {
        setupEscenario1( );
        triqui.limpiarTablero( );
        for( int i = 1; i <= 9; i++ )
        {
            assertTrue( triqui.casillaVacia( i ) );
        }
    }

    /**
     * Verifica que cuando un jugador tenga toda la diagonal principal llena lo informe adecuadamente
     */
    public void testDiagonalPpalLlena( )
    {
        setupEscenario2( );
        triqui.limpiarTablero( );
        triqui.marcarCasilla( 1, marcaJugador1 );
        triqui.marcarCasilla( 5, marcaJugador1 );
        triqui.marcarCasilla( 9, marcaJugador1 );
        assertTrue( triqui.diagonalPrincipalLlena( marcaJugador1 ) );
        assertTrue( triqui.ganoJuego( marcaJugador1 ) );
    }

    /**
     * Verifica que cuando un jugador tenga toda la diagonal secundaria llena lo informe adecuadamente
     */
    public void testDiagonalSecundariaLlena( )
    {
        setupEscenario3( );
        triqui.limpiarTablero( );
        triqui.marcarCasilla( 3, marcaJugador1 );
        triqui.marcarCasilla( 5, marcaJugador1 );
        triqui.marcarCasilla( 7, marcaJugador1 );
        assertTrue( triqui.diagonalSecundariaLlena( marcaJugador1 ) );
        assertTrue( triqui.ganoJuego( marcaJugador1 ) );
    }

    /**
     * Verifica que cuando un jugador tenga toda la fila superior llena lo informe adecuadamente
     */
    public void testFilaSuperiorLlena( )
    {
        setupEscenario2( );
        triqui.limpiarTablero( );
        triqui.marcarCasilla( 1, marcaJugador1 );
        triqui.marcarCasilla( 2, marcaJugador1 );
        triqui.marcarCasilla( 3, marcaJugador1 );
        assertTrue( triqui.filaSuperiorLlena( marcaJugador1 ) );
        assertTrue( triqui.ganoJuego( marcaJugador1 ) );
    }
    /**
     * Verifica que cuando un jugador tenga toda la fila media llena lo informe adecuadamente
     */
    public void testFilaMediaLlena( )
    {
        setupEscenario3( );
        triqui.limpiarTablero( );
        triqui.marcarCasilla( 4, marcaJugador1 );
        triqui.marcarCasilla( 5, marcaJugador1 );
        triqui.marcarCasilla( 6, marcaJugador1 );
        assertTrue( triqui.filaMediaLlena( marcaJugador1 ) );
        assertTrue( triqui.ganoJuego( marcaJugador1 ) );
    }
    /**
     * Verifica que cuando un jugador tenga toda la fila inferior llena lo informe adecuadamente
     */
    public void testFilaInferiorLlena( )
    {
        setupEscenario1( );
        triqui.limpiarTablero( );
        triqui.marcarCasilla( 7, marcaJugador1 );
        triqui.marcarCasilla( 8, marcaJugador1 );
        triqui.marcarCasilla( 9, marcaJugador1 );
        assertTrue( triqui.filaInferiorLlena( marcaJugador1 ) );
        assertTrue( triqui.ganoJuego( marcaJugador1 ) );
    }

    /**
     * Verifica que cuando un jugador tenga toda la columna izquierda llena lo informe adecuadamente
     */
    public void testColumnaIzquierdaLlena( )
    {
        setupEscenario2( );
        triqui.limpiarTablero( );
        triqui.marcarCasilla( 1, marcaJugador1 );
        triqui.marcarCasilla( 4, marcaJugador1 );
        triqui.marcarCasilla( 7, marcaJugador1 );
        assertTrue( triqui.columnaIzquierdaLlena( marcaJugador1 ) );
        assertTrue( triqui.ganoJuego( marcaJugador1 ) );
    }

    /**
     * Verifica que cuando un jugador tenga toda la columna central llena lo informe adecuadamente
     */
    public void testColumnaCentralLlena( )
    {
        setupEscenario3( );
        triqui.limpiarTablero( );
        triqui.marcarCasilla( 2, marcaJugador1 );
        triqui.marcarCasilla( 5, marcaJugador1 );
        triqui.marcarCasilla( 8, marcaJugador1 );
        assertTrue( triqui.columnaCentralLlena( marcaJugador1 ) );
        assertTrue( triqui.ganoJuego( marcaJugador1 ) );
    }

    /**
     * Verifica que cuando un jugador tenga toda la columna derecha llena lo informe adecuadamente
     */
    public void testColumnaDerechaLlena( )
    {
        setupEscenario1( );
        triqui.limpiarTablero( );
        triqui.marcarCasilla( 3, marcaJugador1 );
        triqui.marcarCasilla( 6, marcaJugador1 );
        triqui.marcarCasilla( 9, marcaJugador1 );
        assertTrue( triqui.columnaDerechaLlena( marcaJugador1 ) );
        assertTrue( triqui.ganoJuego( marcaJugador1 ) );
    }

    /**
     * Verifica que cuando el tablero del triqui este lleno lo informe adecuadamente.
     */
    public void testTableroLleno( )
    {
        setupEscenario2( );
        for( int i = 1; i <= 9; i++ )
        {
            triqui.marcarCasilla( i, marcaJugador1 );
        }
        assertTrue( triqui.tableroLleno( ) );
    }
}