/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DirectorioTest.java,v 1.6 2006/10/22 16:29:38 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005
 *
 * Proyecto Cupi2
 * Ejercicio: n11_contactos
 * Autor: Katalina Marcos - 27/10/2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.contactos.test;

import java.util.*;

import junit.framework.*;
import uniandes.cupi2.contactos.mundo.*;

/**
 * Clase de prueba de Directorio
 */
public class DirectorioTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Directorio de prueba
     */
    private IDirectorio directorio;

    /**
     * Nombre de prueba
     */
    private String nombre1;

    /**
     * Nombre de prueba 2
     */
    private String nombre2;

    /**
     * Nombre de prueba 3
     */
    private String nombre3;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Crea un directorio vac�o
     */
    private void setupEscenario0( )
    {
        directorio = new Directorio( );
    }

    /**
     * Crea un directorio con 1 contacto
     */
    private void setupEscenario1( )
    {
        setupEscenario0( );
        nombre1 = "Marta";
        try
        {
            directorio.agregarContacto( nombre1, "tel" + nombre1, "dir" + nombre1, nombre1 + "@email.com" );
        }
        catch( ContactoRepetidoException e )
        {
            fail( "El contacto debi� agregarse" );
        }
    }

    /**
     * Crea un directorio con 3 contactos
     */
    private void setupEscenario2( )
    {
        setupEscenario1( );
        try
        {
            nombre2 = "Alberto";
            directorio.agregarContacto( nombre2, "tel" + nombre2, "dir" + nombre2, nombre2 + "@email.com" );
            nombre3 = "Xiomara";
            directorio.agregarContacto( nombre3, "tel" + nombre3, "dir" + nombre3, nombre3 + "@email.com" );
        }
        catch( ContactoRepetidoException e )
        {
            fail( "El contacto debi� agregarse" );
        }

    }

    /**
     * Prueba la creaci�n correcta de un directorio vac�o. <br>
     * <b> M�todos a probar: </b> <br>
     * Directorio. <br>
     * <b> Objetivo: </b> Probar que el m�todo Directorio() crea el directorio de forma correcta . <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al pedir crear un directorio �ste debe estar vac�o.
     */
    public void testDirectorioVacio( )
    {
        setupEscenario0( );

        // En el directorio no hay contactos
        assertNull( directorio.darListaContactos( ) );
    }

    /**
     * Prueba la b�squeda en el directorio. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarContacto. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarContacto() sea capaz de encontrar un contacto dado en el directorio. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un contacto previamente adicionado, �ste debe ser encontrado. <br>
     * 2. Al busca un contacto que no exista se debe retornar null.
     */
    public void testBuscarContacto( )
    {
        setupEscenario2( );

        // Busca un contacto que existe
        Contacto c = directorio.buscarContacto( nombre1 );
        assertNotNull( c );
        assertEquals( nombre1, c.darNombre( ) );

        // Busca un contacto que no existe
        c = directorio.buscarContacto( "Petronila" );
        assertNull( c );

    }

    /**
     * Prueba el m�todo para agregar contactos en el directorio. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarContacto, buscarContacto. <br>
     * <b> Objetivo: </b> Probar que el m�todo agregarContacto() sea capaz de agregar correctamente un contacto al directorio. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar un contacto este debe quedar en el �rbol de contactos. <br>
     * 2. Al buscar un contacto previamente adicionado, �ste debe ser encontrado.
     */
    public void testAgregarContacto( )
    {
        setupEscenario1( );

        assertEquals( 1, directorio.darListaContactos( ).size( ) );

        try
        {
            directorio.agregarContacto( "nombre2", "tel2", "dir2", "email2" );
        }
        catch( ContactoRepetidoException e )
        {
            fail( "El contacto debi� agregarse" );
        }
        assertEquals( 2, directorio.darListaContactos( ).size( ) );
        Contacto contacto = directorio.buscarContacto( "nombre2" );
        assertNotNull( contacto );
    }

    /**
     * Prueba la eliminaci�n de un contacto. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminarrContacto, buscarContacto. <br>
     * <b> Objetivo: </b> Probar que el m�todo eliminarContacto() sea capaz de eliminar un contacto del directorio. <br>
     * <b> Resultados esperados: </b> <br>
     * 2. Al buscar un contacto previamente eliminado se debe retornar null.
     */
    public void testEliminarContacto( )
    {
        setupEscenario2( );

        int contactosAntes = directorio.darListaContactos( ).size( );

        // Elimina un contacto que si existe
        directorio.eliminarContacto( nombre1 );
        assertEquals( contactosAntes - 1, directorio.darListaContactos( ).size( ) );
        Contacto c = directorio.buscarContacto( nombre1 );
        assertNull( c );

    }

    /**
     * Prueba que la lista de contactos est� ordenada. <br>
     * <b> M�todos a probar: </b> <br>
     * darListaContactos. <br>
     * <b> Objetivo: </b> Probar que el m�todo darListaContactos() retorne la lista de contactos ordenada ascendentemente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al pedir la lista de contactos esta debe ser retornada en orden ascendente.
     */
    public void testListaOrdenada( )
    {
        setupEscenario2( );

        Collection lista = directorio.darListaContactos( );

        assertEquals( 3, lista.size( ) );

        Iterator it = lista.iterator( );
        String anterior = ( String )it.next( );
        while( it.hasNext( ) )
        {
            if( anterior.compareTo( ( String )it.next( ) ) > 0 )
                fail( "la lista no est� ordenada" );

        }
    }

    /**
     * Prueba que las estad�sticas sean calculadas correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * darEstadisticas. <br>
     * <b> Objetivo: </b> Probar que el m�todo darEstadisticas() retorne las estad�sticas asociadas con el �rbol de contactos correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al pedir las estad�ssticas, estas deben ser retornadas completas y con el valor correcto.
     */
    public void testEstadisticas( )
    {
        setupEscenario2( );
        DatoEstadistico[] datosEstadisticos = directorio.darEstadisticas( );

        int cont;

        for( cont = 0; cont < datosEstadisticos.length; cont++ )
        {
            if( datosEstadisticos[ cont ].darNombre( ).equals( "Altura" ) )
            {
                assertEquals( "El dato estad�stico no es correcto", "2", datosEstadisticos[ cont ].darValor( ) );
            }
            else if( datosEstadisticos[ cont ].equals( "Mayor" ) )
            {
                assertEquals( "El dato estad�stico no es correcto", "Xiomara", datosEstadisticos[ cont ].darValor( ) );
            }
            else if( datosEstadisticos[ cont ].equals( "Menor" ) )
            {
                assertEquals( "El dato estad�stico no es correcto", "Alberto", datosEstadisticos[ cont ].darValor( ) );
            }
            else if( datosEstadisticos[ cont ].equals( "Peso" ) )
            {
                assertEquals( "El dato estad�stico no es correcto", "3", datosEstadisticos[ cont ].darValor( ) );
            }
            else if( datosEstadisticos[ cont ].equals( "Hojas" ) )
            {
                assertEquals( "El dato estad�stico no es correcto", "2", datosEstadisticos[ cont ].darValor( ) );
            }

        }
        assertEquals( "El n�mero de datos estad�sticos no es correcto", 5, cont );
    }
}