/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Contacto.java,v 1.13 2007/04/13 04:51:14 carl-veg Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n11_contactos
 * Autor: Katalina Marcos - 27/10/2005
 * Autor: Jorge Villalobos - 11/10/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.contactos.mundo;

import java.util.*;

/**
 * Informaci�n de contacto de una persona<br>
 * <b>inv:</b> <br>
 * nombre != null.
 */
public class Contacto implements Comparable
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Nombre del contacto
     */
    private String nombre;

    /**
     * Tel�fono del contacto
     */
    private String telefono;

    /**
     * Direcci�n del contacto
     */
    private String direccion;

    /**
     * Correo electr�nico del contacto
     */
    private String eMail;

    /**
     * Sub�rbol izquierdo de contactos
     */
    private Contacto izq;

    /**
     * Sub�rbol derecho de contactos
     */
    private Contacto der;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un contacto con toda la informaci�n b�sica
     * @param elNombre nombre de la persona a contactar - nombre != null
     * @param elTelefono tel�fono de contacto
     * @param laDireccion direcci�n de contacto
     * @param elEmail correo electr�nico de contacto
     */
    public Contacto( String elNombre, String elTelefono, String laDireccion, String elEmail )
    {
        nombre = elNombre;
        telefono = elTelefono;
        direccion = laDireccion;
        eMail = elEmail;
        izq = null;
        der = null;
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // M�todo interfaz Comparable
    // -----------------------------------------------------------------

    /**
     * Compara este contacto con otro
     * @param o es el otro contacto con el que se compara
     * @return -1 si este contacto es menor al otro, 0 si son iguales y 1 si este contacto es mayor al otro
     */
    public int compareTo( Object o )
    {
        Contacto otro = ( Contacto )o;
        return nombre.compareToIgnoreCase( otro.nombre );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del contacto
     * @return nombre del contacto
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el tel�fono del contacto
     * @return tel�fono del contacto
     */
    public String darTelefono( )
    {
        return telefono;
    }

    /**
     * Retorna la direcci�n del contacto
     * @return direcci�n del contacto
     */
    public String darDireccion( )
    {
        return direccion;
    }

    /**
     * Retorna la direcci�n electr�nica del contacto
     * @return direcci�n electr�nica del contacto
     */
    public String darEmail( )
    {
        return eMail;
    }

    /**
     * Indica si este nodo es una hoja
     * @return true si este nodo es una hoja y false en caso contrario
     */
    public boolean esHoja( )
    {
        return izq == null && der == null;
    }

    /**
     * Retorna el contacto que alfab�ticamente corresponde al menor contacto del �rbol que parte de este nodo
     * @return contacto con menor nombre
     */
    public Contacto darMenor( )
    {
        return ( izq == null ) ? this : izq.darMenor( );
    }

    /**
     * Retorna el contacto que alfab�ticamente corresponde al mayor contacto del �rbol que parte de este nodo
     * @return contacto con mayor nombre
     */
    public Contacto darMayor( )
    {
        return ( der == null ) ? this : der.darMayor( );
    }

    /**
     * Retorna la altura del �rbol de contactos que comienza en este nodo
     * @return altura del �rbol que comienza en este nodo
     */
    public int darAltura( )
    {
        if( esHoja( ) )
            return 1;
        else
        {
            int a1 = ( izq == null ) ? 0 : izq.darAltura( );
            int a2 = ( der == null ) ? 0 : der.darAltura( );
            return 1 + Math.max( a1, a2 );
        }
    }

    /**
     * Retorna el n�mero de contactos que hay en el �rbol que comienza en este nodo utilizando un algoritmo iterativo
     * @return n�mero de contactos en el �rbol que comienza en este nodo
     */
    public int darPesoIterativo( )
    {
        int peso = 0;
        ArrayList pila = new ArrayList( );
        Contacto p = this;
        while( p != null )
        {
            peso++;
            if( p.izq != null )
            {
                // Guarda el sub�rbol derecho en la pila, para recuperarlo m�s tarde
                if( p.der != null )
                    pila.add( p.der );

                // Baja por la izquierda
                p = p.izq;
            }
            else if( p.der != null )
            {
                // Baja por la derecha, puesto que no hay sub�rbol izquierdo
                p = p.der;
            }
            else if( pila.size( ) != 0 )
            {
                // Es una hoja, luego debemos sacar de la pila el �ltimo sub�rbol all� almacenado
                p = ( Contacto )pila.get( 0 );
                pila.remove( 0 );
            }
            else
            {
                p = null;
            }
        }
        return peso;
    }

    /**
     * Retorna el n�mero de contactos que hay en el �rbol que comienza en este nodo
     * @return n�mero de contactos en el �rbol que comienza en este nodo
     */
    public int darPeso( )
    {
        int p1 = ( izq == null ) ? 0 : izq.darPeso( );
        int p2 = ( der == null ) ? 0 : der.darPeso( );
        return 1 + p1 + p2;
    }

    /**
     * Retorna el n�mero de hojas que hay en el �rbol que comienza en este nodo
     * @return n�mero de hojas que hay en el �rbol que comienza en este nodo
     */
    public int contarHojas( )
    {
        if( esHoja( ) )
            return 1;
        else
        {
            int h1 = ( izq == null ) ? 0 : izq.contarHojas( );
            int h2 = ( der == null ) ? 0 : der.contarHojas( );
            return h1 + h2;
        }
    }

    /**
     * Inserta un nuevo contacto al �rbol que comienza en este nodo.
     * @param nuevo el el nuevo contacto que se va a insertar - nuevo != null
     * @throws ContactoRepetidoException se lanza esta excepci�n si el contacto que se quiere agregar ya est� en el directorio
     */
    public void insertar( Contacto nuevo ) throws ContactoRepetidoException
    {
        if( compareTo( nuevo ) == 0 )
            throw new ContactoRepetidoException( nuevo.nombre );

        if( compareTo( nuevo ) > 0 )
        {
            // Debe agregar el nuevo contacto por el sub�rbol izquierdo
            if( izq == null )
                izq = nuevo;
            else
                izq.insertar( nuevo );
        }
        else
        {
            // Debe agregar el nuevo contacto por el sub�rbol derecho
            if( der == null )
                der = nuevo;
            else
                der.insertar( nuevo );
        }
    }

    /**
     * Implementaci�n iterativa para localizar un contacto en el �rbol que comienza en este nodo
     * @param unNombre nombre que se va a buscar - unNombre != null
     * @return contacto asociado al nombre. Si no lo encuentra retorna null;
     */
    public Contacto buscarIterativo( String unNombre )
    {
        Contacto p = this;
        while( p != null )
        {
            int comp = p.nombre.compareToIgnoreCase( unNombre );
            if( comp == 0 )
                return p;
            else if( comp > 0 )
                p = p.izq;
            else
                p = p.der;
        }
        return null;
    }

    /**
     * Implementaci�n recursiva para localizar un contacto en el �rbol que comienza en este nodo
     * @param unNombre nombre que se va a buscar - unNombre != null
     * @return contacto asociado al nombre. Si no lo encuentra retorna null;
     */
    public Contacto buscar( String unNombre )
    {
        if( nombre.compareToIgnoreCase( unNombre ) == 0 )
            return this;
        else if( nombre.compareToIgnoreCase( unNombre ) > 0 )
            return ( izq == null ) ? null : izq.buscar( unNombre );
        else
            return ( der == null ) ? null : der.buscar( unNombre );
    }

    /**
     * Elimina un contacto del �rbol que comienza en este nodo.
     * @param unNombre nombre del contacto que se va a eliminar - hay un contacto en el �rbol que se llama unNombre
     * @return el �rbol de contactos despu�s de eliminar el contacto indicado
     */
    public Contacto eliminar( String unNombre )
    {
        if( esHoja( ) )
            // Tiene que ser el elemento que estamos buscando
            return null;
        if( nombre.compareToIgnoreCase( unNombre ) == 0 )
        {
            if( izq == null )
                return der;
            if( der == null )
                return izq;
            // Localiza el menor contacto del sub�rbol derecho
            Contacto sucesor = der.darMenor( );
            // Elimina del sub�rbol derecho el elemento que acaba de localizar
            der = der.eliminar( sucesor.darNombre( ) );
            // Deja el elemento localizado en la ra�z del �rbol de respuesta
            sucesor.izq = izq;
            sucesor.der = der;
            return sucesor;
        }
        else if( nombre.compareToIgnoreCase( unNombre ) > 0 )
            izq = izq.eliminar( unNombre );
        else
            der = der.eliminar( unNombre );
        return this;
    }

    /**
     * Retorna una colecci�n con los nombres de todos los contactos, ordenados alfab�ticamente en orden ascendente
     * @param acumulado colecci�n donde se van agregando los nombres de los contactos ordenadamente
     */
    public void inorden( Collection acumulado )
    {
        // Recorre en inorden el sub�rbol izquierdo
        if( izq != null )
            izq.inorden( acumulado );
        // Incluye en el recorrido el contacto de la ra�z
        acumulado.add( nombre );
        // Recorre en inorden el sub�rbol derecho
        if( der != null )
            der.inorden( acumulado );
    }

    /**
     * Indica si el �rbol que comienza en este nodo es ordenado
     * @return true si el �rbol que comienza en este nodo es ordenado
     */
    public boolean esOrdenado( )
    {
        if( esHoja( ) )
            return true;

        else if( izq == null )
            return der.esOrdenado( ) && nombre.compareTo( der.darMenor( ).darNombre( ) ) < 0;

        else if( der == null )
            return izq.esOrdenado( ) && nombre.compareTo( izq.darMayor( ).darNombre( ) ) > 0;

        else
            return der.esOrdenado( ) && nombre.compareTo( der.darMenor( ).darNombre( ) ) < 0 && izq.esOrdenado( ) && nombre.compareTo( izq.darMayor( ).darNombre( ) ) > 0;
    }

    /**
     * Cuenta el n�mero de veces que aparece un contacto con un nombre que se recibe como par�metro
     * @param nombreP nombre del contacto que se est� buscando - nombreP != null
     * @return n�mero de contactos con un nombre dado
     */
    public int contarOcurrencias( String nombreP )
    {
        int cuantos = 0;
        if( nombre.equals( nombreP ) )
            cuantos++;
        cuantos += ( izq == null ) ? 0 : izq.contarOcurrencias( nombreP );
        cuantos += ( der == null ) ? 0 : der.contarOcurrencias( nombreP );
        return cuantos;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv:</b> <br>
     * nombre != null.
     */
    public void verificarInvariante( )
    {
        assert nombre != null : "Nombre inv�lido";
    }
}