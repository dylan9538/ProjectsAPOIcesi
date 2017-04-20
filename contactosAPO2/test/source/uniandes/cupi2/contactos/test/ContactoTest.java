/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ContactoTest.java,v 1.5 2006/10/22 16:29:38 da-romer Exp $
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
 * Clase de prueba de la clase Contacto
 */
public class ContactoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Contacto 1
     */
    private Contacto contacto1;
    /**
     * Nombre del contacto 1
     */
    private String nombre1;
    /**
     * Tel�fono del contacto 1
     */
    private String telefono1;
    /**
     * Direcci�n del contacto 1
     */
    private String direccion1;
    /**
     * Email del contacto 1
     */
    private String email1;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Crea un �rbol de contactos con la informaci�n b�sica de contacto
     */
    private void setupEscenario1( )
    {
        nombre1 = "Marta";
        direccion1 = "direcci�n";
        telefono1 = "1234567";
        email1 = "marta@email.com";
        contacto1 = new Contacto( nombre1, telefono1, direccion1, email1 );
    }

    /**
     * Crea un escenario donde al contacto inicial le inserta un contacto menor
     */
    private void setupEscenario2( )
    {
        setupEscenario1( );

        String nombre = "Alberto";
        String direccion = "direcci�n";
        String telefono = "1234567";
        String email = "alberto@email.com";
        Contacto contacto2 = new Contacto( nombre, telefono, direccion, email );

        try
        {
            contacto1.insertar( contacto2 );
        }
        catch( ContactoRepetidoException e )
        {
            fail( "El contacto debi� agregarse" );
        }
    }

    /**
     * Crea un escenario donde al contacto inicial le inserta un contacto menor, teniendo el �rbol ya dos nodos
     */
    private void setupEscenario3( )
    {
        setupEscenario2( );

        String nombre = "Paco";
        String direccion = "direcci�n";
        String telefono = "1234567";
        String email = "paco@email.com";
        Contacto contacto3 = new Contacto( nombre, telefono, direccion, email );

        try
        {
            contacto1.insertar( contacto3 );
        }
        catch( ContactoRepetidoException e )
        {
            fail( "El contacto debi� agregarse" );
        }
    }

    /**
     * Crea un escenario con un �rbol de contactos de 5 nodos teniendo el �rbol ya tres nodos
     */
    private void setupEscenario4( )
    {
        setupEscenario3( );

        String nombre = "Luis";
        String direccion = "direcci�n";
        String telefono = "1234567";
        String email = "luis@email.com";
        Contacto contacto = new Contacto( nombre, telefono, direccion, email );
        try
        {
            contacto1.insertar( contacto );
        }
        catch( ContactoRepetidoException e )
        {
            fail( "El contacto debi� agregarse" );
        }

        nombre = "Xiomara";
        direccion = "direcci�n";
        telefono = "1234567";
        email = "xiomara@email.com";
        contacto = new Contacto( nombre, telefono, direccion, email );
        try
        {
            contacto1.insertar( contacto );
        }
        catch( ContactoRepetidoException e )
        {
            fail( "El contacto debi� agregarse" );
        }
    }

    /**
     * Prueba la creaci�n inicial del �rbol. <br>
     * <b> M�todos a probar: </b> <br>
     * Contacto, darAltura, darPeso, darPesoIterativo. <br>
     * <b> Objetivo: </b> Probar que el m�todo Contacto() se capaz de crear correctamente el contacto. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear un contacto y pedir su peso y altura �stos deben ser igual a 1.
     */
    public void testCrearArbolContactos( )
    {
        setupEscenario1( );

        // La informaci�n debe estar consistente.
        assertEquals( nombre1, contacto1.darNombre( ) );
        assertEquals( telefono1, contacto1.darTelefono( ) );
        assertEquals( direccion1, contacto1.darDireccion( ) );
        assertEquals( email1, contacto1.darEmail( ) );

        // La profundidad del �rbol es 1
        assertEquals( 1, contacto1.darAltura( ) );

        // El peso del �rbol es 1
        assertEquals( 1, contacto1.darPeso( ) );
        assertEquals( 1, contacto1.darPesoIterativo( ) );
    }

    /**
     * Prueba la inserci�n al lado izquierdo del �rbol. <br>
     * <b> M�todos a probar: </b> <br>
     * Contacto, darAltura, darPeso, darPesoIterativo, insertar. <br>
     * <b> Objetivo: </b> Probar que el m�todo insertar() inserte correctamente un contacto en el �rbol de contactos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al insertar un contacto en un �rbol compuesto s�lo de un contacto se debe aumentar el peso y altura del �rbol.
     */
    public void testInsertarIzquierda( )
    {
        setupEscenario2( );

        // El �rbol tiene profundidad 2
        assertEquals( 2, contacto1.darAltura( ) );

        // El peso del �rbol es 2
        assertEquals( 2, contacto1.darPeso( ) );
        assertEquals( 2, contacto1.darPesoIterativo( ) );
    }

    /**
     * Prueba la inserci�n al lado derecho del �rbol en un �rbol con 2 nodos. <br>
     * <b> M�todos a probar: </b> <br>
     * Contacto, darAltura, darPeso, darPesoIterativo, insertar. <br>
     * <b> Objetivo: </b> Probar que el m�todo insertar() inserte correctamente un contacto en el �rbol de contactos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al insertar un contacto en un �rbol compuesto por la ra�z y el hijo izquierdo, se debe aumentar el peso y altura del �rbol.
     */
    public void testInsertarDerecha( )
    {
        setupEscenario3( );

        // El �rbol tiene profundidad 2
        assertEquals( 2, contacto1.darAltura( ) );

        // El peso del �rbol es 3
        assertEquals( 3, contacto1.darPeso( ) );
        assertEquals( 3, contacto1.darPesoIterativo( ) );
    }

    /**
     * Prueba la inserci�n de 5 nodos al �rbol. <br>
     * <b> M�todos a probar: </b> <br>
     * Contacto, darAltura, darPeso, darPesoIterativo, insertar. <br>
     * <b> Objetivo: </b> Probar que el m�todo insertar() inserte correctamente un contacto en el �rbol de contactos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al insertar dos contacto en un �rbol compuesto por la ra�z y sus dos hijos, se debe aumentar el peso y altura del �rbol.
     */
    public void testInsertar5Nodos( )
    {
        setupEscenario4( );

        // El �rbol tiene profundidad 3
        assertEquals( 3, contacto1.darAltura( ) );

        // El peso del �rbol es 5
        assertEquals( 5, contacto1.darPeso( ) );
        assertEquals( 5, contacto1.darPesoIterativo( ) );
    }

    /**
     * Prueba que al insertar un contacto repetido se genere el error. <br>
     * <b> M�todos a probar: </b> <br>
     * insertar. <br>
     * <b> Objetivo: </b> Probar que el m�todo insertar() arroje excepci�n cuando se trate de adicionar un contacto repetido. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al insertar un contacto previamente existente en el �rbol se debe arrojar excepci�n.
     */
    public void testInsertarRepetido( )
    {
        setupEscenario4( );
        String direccion = "direcci�n";
        String telefono = "1234567";
        String email = "nombre@email.com";
        Contacto contactoR = new Contacto( nombre1, telefono, direccion, email );
        try
        {
            contacto1.insertar( contactoR );
            fail( "El contacto estaba repetido y no pod�a ser insertado" );
        }
        catch( ContactoRepetidoException e )
        {
            assertTrue( "El contacto estaba repetido y deb�a generarse la excepci�n", true );
        }
    }

    /**
     * Prueba el m�todo de b�squeda de contactos de forma iterativa. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarIterativo. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarIterativo() busque correctamente los contactos dados. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un contacto que no existe se debe retornar null. <br>
     * 2. Al buscar un contacto que existe �ste debe ser retornado.
     */
    public void testBuscarIterativo( )
    {
        setupEscenario4( );

        Contacto c;

        // Busca un nombre que no existe
        c = contacto1.buscarIterativo( "Petronila" );
        assertNull( c );

        // Busca uno que si existe
        c = contacto1.buscarIterativo( "Marta" );
        assertNotNull( c );
        assertEquals( "Marta", c.darNombre( ) );

        // Busca a la ra�z del �rbol
        c = contacto1.buscarIterativo( nombre1 );
        assertNotNull( c );
        assertEquals( nombre1, c.darNombre( ) );

        // Busca al mayor
        c = contacto1.buscarIterativo( "Xiomara" );
        assertNotNull( c );
        assertEquals( "Xiomara", c.darNombre( ) );

        // Busca el menor
        c = contacto1.buscarIterativo( "Alberto" );
        assertNotNull( c );
        assertEquals( "Alberto", c.darNombre( ) );
    }

    /**
     * Prueba el m�todo de b�squeda de contactos. <br>
     * <b> M�todos a probar: </b> <br>
     * buscar. <br>
     * <b> Objetivo: </b> probar que el m�todo buscar() busque correctamente los contactos dados. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un contacto que no existe se debe retornar null. <br>
     * 2. Al buscar un contacto que existe �ste debe ser retornado.
     */
    public void testBuscar( )
    {
        setupEscenario4( );

        Contacto c;

        // Busca un nombre que no existe
        c = contacto1.buscar( "Petronila" );
        assertNull( c );

        // Busca uno que si existe
        c = contacto1.buscar( "Marta" );
        assertNotNull( c );
        assertEquals( "Marta", c.darNombre( ) );

        // Busca a la ra�z del �rbol
        c = contacto1.buscar( nombre1 );
        assertNotNull( c );
        assertEquals( nombre1, c.darNombre( ) );

        // Busca al mayor
        c = contacto1.buscar( "Xiomara" );
        assertNotNull( c );
        assertEquals( "Xiomara", c.darNombre( ) );

        // Busca el menor
        c = contacto1.buscar( "Alberto" );
        assertNotNull( c );
        assertEquals( "Alberto", c.darNombre( ) );
    }

    /**
     * Prueba los algoritmos que retornan el mayor y el menor del �rbol <b> M�todos a probar: </b> <br>
     * darMenor, darMayor. <br>
     * <b> Objetivo: </b> Probar que los m�todos darMayor() y darMenor() retornen correctamente los contactos con los nombres que sean mayor y menor (lexicograficamente)
     * respectivamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al pedir el elemento menor del �rbol se debe retornar el nombre menor lexicograficamente. <br>
     * 2. Al pedir el elemento mayor del �rbol se debe retornar el nombre mayor lexicograficamente.
     */
    public void testMayorYMenor( )
    {
        setupEscenario4( );

        // Busca el primero
        Contacto c = contacto1.darMenor( );
        assertEquals( "Alberto", c.darNombre( ) );

        // Busca el �ltimo
        c = contacto1.darMayor( );
        assertEquals( "Xiomara", c.darNombre( ) );

    }

    /**
     * Prueba la eliminaci�n de un nodo que es hoja del �rbol. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminar. <br>
     * <b> Objetivo: </b> Probar que el m�todo eliminar() elimine correctamente un elemento del �rbol. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al eliminar un elemento del �rbol, el peso del �rbol debe disminuir en 1. <br>
     * 2. Al eliminar un elemento del �rbol al buscarlo se debe obtener null.
     */
    public void testEliminarHoja( )
    {
        setupEscenario4( );

        // Elimina al �ltimo
        Contacto c = contacto1.darMayor( );
        contacto1 = contacto1.eliminar( c.darNombre( ) );
        // El �rbol tiene profundidad 3
        assertEquals( 3, contacto1.darAltura( ) );
        // El peso del �rbol es 4
        assertEquals( 4, contacto1.darPeso( ) );
        assertEquals( 4, contacto1.darPesoIterativo( ) );
        // Ya no se encuentra el contacto
        assertNull( contacto1.buscar( c.darNombre( ) ) );

    }

    /**
     * Prueba borrando nodos del medio. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminar. <br>
     * <b> Objetivo: </b> Probar que el m�todo eliminar() elimine correctamente un elemento del �rbol. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al eliminar un elemento del �rbol, el peso del �rbol debe disminuir en 1. <br>
     * 2. Al eliminar un elemento del �rbol al buscarlo se debe obtener null.
     */
    public void testEliminarMedios( )
    {
        setupEscenario4( );
        contacto1 = contacto1.eliminar( "Paco" );
        // El �rbol tiene profundidad 3
        assertEquals( 3, contacto1.darAltura( ) );
        // El peso del �rbol es 4
        assertEquals( 4, contacto1.darPeso( ) );
        assertEquals( 4, contacto1.darPesoIterativo( ) );
        // Ya no se encuentra el contacto
        assertNull( contacto1.buscar( "Paco" ) );

        contacto1 = contacto1.eliminar( "Alberto" );
        // El �rbol tiene profundidad 2
        assertEquals( 2, contacto1.darAltura( ) );
        // El peso del �rbol es 3
        assertEquals( 3, contacto1.darPeso( ) );
        // Ya no se encuentra el contacto
        assertNull( contacto1.buscar( "Alberto" ) );

    }

    /**
     * Borra la ra�z de todo el �rbol. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminar. <br>
     * <b> Objetivo: </b> Probar que el m�todo eliminar() elimine correctamente un elemento del �rbol. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al eliminar un elemento del �rbol, el peso del �rbol debe disminuir en 1. <br>
     * 2. Al eliminar un elemento del �rbol al buscarlo se debe obtener null.
     */
    public void testBorrarRaiz( )
    {
        setupEscenario4( );
        contacto1 = contacto1.eliminar( "Marta" );
        // El �rbol tiene profundidad 3
        assertEquals( 3, contacto1.darAltura( ) );
        // El peso del �rbol es 4
        assertEquals( 4, contacto1.darPeso( ) );
        assertEquals( 4, contacto1.darPesoIterativo( ) );
        // Ya no se encuentra el contacto
        assertNull( contacto1.buscar( "Marta" ) );
    }

    /**
     * Prueba el recorrido inorden del �rbol de contactos. <br>
     * <b> M�todos a probar: </b> <br>
     * inorden. <br>
     * <b> Objetivo: </b> Probar que el m�todo inorden() retorne correctamente el recorrido del �rbol en inorden. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al pedir el recorrido en inorden del �rbol, los elementos deben ser retornados en orden ascendente.
     */
    public void testInorden( )
    {
        setupEscenario4( );
        Collection lista = new ArrayList( );
        contacto1.inorden( lista );
        assertEquals( "[Alberto, Luis, Marta, Paco, Xiomara]", lista.toString( ) );
    }

    /**
     * Prueba que las hojas del �rbol se cuenten correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * contarHojas. <br>
     * <b> Objetivo: </b> Probar que el m�todo contarHojas() realice el conteo correcto del n�mero de hojas del �rbol. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el n�mero de hojas de un �rbol es X. Al pedir el n�mero de hojas se debe obtener X.
     */
    public void testContarHojas( )
    {
        setupEscenario1( );
        int numHojas = contacto1.contarHojas( );
        assertEquals( "El n�mero de hojas no es el esperado", 1, numHojas );

        setupEscenario2( );
        numHojas = contacto1.contarHojas( );
        assertEquals( "El n�mero de hojas no es el esperado", 1, numHojas );

        setupEscenario3( );
        numHojas = contacto1.contarHojas( );
        assertEquals( "El n�mero de hojas no es el esperado", 2, numHojas );

        setupEscenario4( );
        numHojas = contacto1.contarHojas( );
        assertEquals( "El n�mero de hojas no es el esperado", 2, numHojas );

    }

    /**
     * Prueba el m�todo para contar el n�mero de ocurrencias de un elemento dentro del �rbol <b> M�todos a probar: </b> <br>
     * contarOcurrencias. <br>
     * <b> Objetivo: </b> Probar que el m�todo contarOcurrencias() cuente correctamente las apariciones de un elemento en el �rbol. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al pedir el n�mero de ocurrencias de un elemento que existe en el �rbol, se debe obtener 1. <br>
     * 2. Al pedir el n�mero de ocurrencias de un elemento que no existe en el �rbol, se debe obtener 0.
     * 
     */
    public void testContarOcurrencias( )
    {
        setupEscenario4( );
        int ocurrencias = contacto1.contarOcurrencias( "Xiomara" );
        assertEquals( "El n�mero de ocurrencias del contacto no es el esperado", 1, ocurrencias );

        ocurrencias = contacto1.contarOcurrencias( "Paco" );
        assertEquals( "El n�mero de ocurrencias del contacto no es el esperado", 1, ocurrencias );

        ocurrencias = contacto1.contarOcurrencias( "Marta" );
        assertEquals( "El n�mero de ocurrencias del contacto no es el esperado", 1, ocurrencias );

        ocurrencias = contacto1.contarOcurrencias( "Alberto" );
        assertEquals( "El n�mero de ocurrencias del contacto no es el esperado", 1, ocurrencias );

        ocurrencias = contacto1.contarOcurrencias( "Luis" );
        assertEquals( "El n�mero de ocurrencias del contacto no es el esperado", 1, ocurrencias );

        ocurrencias = contacto1.contarOcurrencias( "Jos� Luis" );
        assertEquals( "El n�mero de ocurrencias del contacto no es el esperado", 0, ocurrencias );
    }

}