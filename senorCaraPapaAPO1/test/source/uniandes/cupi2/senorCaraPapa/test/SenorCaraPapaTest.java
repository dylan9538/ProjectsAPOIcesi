/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: SenorCaraPapaTest.java,v 1.1 2009/05/11 21:54:17 davi-osp Exp $
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
import uniandes.cupi2.senorCaraPapa.mundo.SenorCaraPapa;

/**
 * Esta es la clase usada para verificar que los métodos de la clase SenorCaraPapa estén correctamente implementados
 */
public class SenorCaraPapaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos de prueba
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private SenorCaraPapa caraDePapa;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------

    /**
     * Construye una nueva SenorCaraPapa con las 3 posibilidades paras los 5 tipos de partes
     */
    private void setupEscenario1( )
    {
        caraDePapa = new SenorCaraPapa( );
    }

    /**
     * Construye una nueva CaraDePapa con un diseño con las 5 partes
     */
    private void setupEscenario2( )
    {
        caraDePapa = new SenorCaraPapa( );
        seleccionarPartes( 2, 1, 1, 2, 1 );
    }

    /**
     * Método auxiliar que selecciona un accesorio, boca, brazos y pies para el diseño de cara de papa
     * @param accesorio Identificador de la parte accesorio a seleccionar
     * @param expresion Identificador de la parte expresión a seleccionar
     * @param boca Identificador de la parte boca a seleccionar
     * @param brazos Identificador de la parte brazos a seleccionar
     * @param pies Identificador de la parte pies a seleccionar
     */
    private void seleccionarPartes( int accesorio, int expresion, int boca, int brazos, int pies )
    {
        caraDePapa.seleccionarAccesorioCabeza( accesorio );
        caraDePapa.seleccionarExpresionFacial( expresion );
        caraDePapa.seleccionarBoca( boca );
        caraDePapa.seleccionarBrazos( brazos );
        caraDePapa.seleccionarPies( pies );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Prueba que al seleccionar un accesorio, se puede comprobar el cambio al calcular correctamente el valor total del diseño.<br>
     * <b> Métodos a probar:</b> calcularPrecioTotal(), seleccionarAccesorioCabeza()<br>
     * <b> Objetivo:</b>Probar que el método seleccionarAccesorioCabeza() funciona correctamente <br>
     * <b> Resultados esperados: </b><br>
     * 1.Al calcular el precio del diseño, con una sola parte (ACCESORIO) se obtiene el valor esperado. <br>
     */
    public void testSeleccionarAccesorioCabeza( )
    {
        setupEscenario1( );
        try
        {
            caraDePapa.seleccionarAccesorioCabeza( 1 );
            double subtotal = caraDePapa.calcularPrecioTotal( );
            assertEquals( "El precio final no fue calculado correctamente respecto a la única parte del diseño.", 18700.425, subtotal, subtotal - 18700.425 );
        }
        catch( NullPointerException npe )
        {
            fail( "No se están haciendo las verificaciones de null completas." );
        }
    }
    /**
     * Prueba que al seleccionar un accesorio, se puede comprobar el cambio al calcular correctamente el valor total del diseño.<br>
     * <b> Métodos a probar:</b> calcularPrecioTotal(), seleccionarExpresionFacial()<br>
     * <b> Objetivo:</b>Probar que el método seleccionarAccesorioCabeza() funciona correctamente <br>
     * <b> Resultados esperados: </b><br>
     * 1.Al calcular el precio del diseño, con una sola parte (EXPRESION) se obtiene el valor esperado. <br>
     */
    public void testSeleccionarExpresionFacial( )
    {
        setupEscenario1( );
        try
        {
            caraDePapa.seleccionarExpresionFacial( 2 );
            double subtotal = caraDePapa.calcularPrecioTotal( );
            assertEquals( "El precio final no fue calculado correctamente respecto a la única parte del diseño.", 11070, ( int )subtotal );
        }
        catch( NullPointerException npe )
        {
            fail( "No se están haciendo las verificaciones de null completas." );
        }
    }

    /**
     * Prueba que al seleccionar un accesorio, se puede comprobar el cambio al calcular correctamente el valor total del diseño.<br>
     * <b> Métodos a probar:</b> calcularPrecioTotal(), seleccionarBoca ()<br>
     * <b> Objetivo:</b>Probar que el método seleccionarBoca() funciona correctamente <br>
     * <b> Resultados esperados: </b><br>
     * 1.Al calcular el precio del diseño, con una sola parte (BOCA) se obtiene el valor esperado. <br>
     */
    public void testSeleccionarBoca( )
    {
        setupEscenario1( );
        try
        {
            caraDePapa.seleccionarBoca( 1 );
            double subtotal = caraDePapa.calcularPrecioTotal( );
            assertEquals( "El precio final no fue calculado correctamente respecto a la única parte del diseño.", 27025, ( int )subtotal );
        }
        catch( NullPointerException npe )
        {
            fail( "No se están haciendo las verificaciones de null completas." );
        }
    }

    /**
     * Prueba que al seleccionar un accesorio, se puede comprobar el cambio al calcular correctamente el valor total del diseño.<br>
     * <b> Métodos a probar:</b> calcularPrecioTotal(), seleccionarBrazos()<br>
     * <b> Objetivo:</b>Probar que el método seleccionarBrazos() funciona correctamente <br>
     * <b> Resultados esperados: </b><br>
     * 1.Al calcular el precio del diseño, con una sola parte (BRAZOS) se obtiene el valor esperado. <br>
     */
    public void testSeleccionarBrazos( )
    {
        setupEscenario1( );
        try
        {
            caraDePapa.seleccionarBrazos( 3 );
            double subtotal = caraDePapa.calcularPrecioTotal( );
            assertEquals( "El precio final no fue calculado correctamente respecto a la única parte del diseño.", 31280, ( int )subtotal );
        }
        catch( NullPointerException npe )
        {
            fail( "No se están haciendo las verificaciones de null completas." );
        }
    }

    /**
     * Prueba que al seleccionar un accesorio, se puede comprobar el cambio al calcular correctamente el valor total del diseño.<br>
     * <b> Métodos a probar:</b> calcularPrecioTotal(), seleccionarPies()<br>
     * <b> Objetivo:</b>Probar que el método seleccionarPies() funciona correctamente <br>
     * <b> Resultados esperados: </b><br>
     * 1.Al calcular el precio del diseño, con una sola parte (PIES) se obtiene el valor esperado. <br>
     */
    public void testSeleccionarPies( )
    {
        setupEscenario1( );
        try
        {
            caraDePapa.seleccionarPies( 1 );
            double subtotal = caraDePapa.calcularPrecioTotal( );
            assertEquals( "El precio final no fue calculado correctamente respecto a la única parte del diseño.", 53460, ( int )subtotal );
        }
        catch( NullPointerException npe )
        {
            fail( "No se están haciendo las verificaciones de null completas." );
        }
    }

    /**
     * Prueba que al calcular el precio final del diseño con 5 partes se obtiene el resultado adecuado<br>
     * <b> Métodos a probar:</b> calcularPrecioTotal()<br>
     * <b> Objetivo:</b>Probar que el método calcularPrecioTotal() funciona correctamente <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Si no están todas las partes se calcula correctamente el precio. <br>
     * 2. Si el total está entre 50000 y 100000 se aplica correctamente el descuento. <br>
     * 3. Si el total está entre 100000 y 150000 se aplica correctamente el descuento. <br>
     * 4. Si el total es mayor a 150000 se aplica correctamente el descuento. <br>
     */
    public void testCalcularPrecioTotal( )
    {
        setupEscenario2( );
        assertEquals( "El precio final no fue calculado correctamente.", 131176, ( int )caraDePapa.calcularPrecioTotal( ) );

        seleccionarPartes( 2, 3, 1, 2, 1 );
        assertEquals( "El precio final no fue calculado correctamente.", 121617, ( int )caraDePapa.calcularPrecioTotal( ) );
        seleccionarPartes( 3, 2, 1, 1, 2 );
        assertEquals( "El precio final no fue calculado correctamente.", 107782, ( int )caraDePapa.calcularPrecioTotal( ) );
        seleccionarPartes( 1, 1, 3, 3, 3 );
        assertEquals( "El precio final no fue calculado correctamente.", 136705, ( int )caraDePapa.calcularPrecioTotal( ) );

    }

    /**
     * Prueba que se vendan las partes que se encuentren en el diseño seleccionado.<br>
     * <b> Métodos a probar:</b>seleccionarExpresionFacial, seleccionarAccesorioCabeza(), seleccionarBoca(), seleccionarBrazos(), seleccionarPies(), calcularPrecioTotal()<br>
     * <b> Objetivo:</b>Probar que el método venderDisenio() funciona correctamente <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Después de vender un diseño el precio total con todas las partes es calculado correctamente. <br>
     */
    public void testVenderDiseno( )
    {
        setupEscenario1( );

        seleccionarPartes( 2, 3, 1, 2, 1 );
        caraDePapa.venderDiseno( );

        seleccionarPartes( 2, 3, 1, 2, 1 );
        assertEquals( "El precio final no fue calculado correctamente.", 72182, ( int )caraDePapa.calcularPrecioTotal( ) );
        caraDePapa.venderDiseno( );
    }
}