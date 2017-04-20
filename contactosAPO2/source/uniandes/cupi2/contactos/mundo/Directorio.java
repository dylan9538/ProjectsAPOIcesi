/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Directorio.java,v 1.8 2007/04/13 04:51:14 carl-veg Exp $
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
 * Directorio de contactos, representado como un �rbol binario ordenado <br>
 * <b>inv:</b> <br>
 * No hay dos contactos con el mismo nombre en el directorio <br>
 * El �rbol de contactos es un �rbol binario ordenado <br>
 * numContactos es el n�mero de contactos presentes en el directorio
 */
public class Directorio implements IDirectorio
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ra�z del �rbol de contactos presentes en el directorio
     */
    private Contacto contactoRaiz;

    /**
     * N�mero de contactos en el directorio
     */
    private int numContactos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el directorio sin ning�n contacto
     */
    public Directorio( )
    {
        contactoRaiz = null;
        numContactos = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Agrega un contacto al directorio <br>
     * <b>post: </b>El contacto ha sido agregado al directorio.
     * @param nom nombre del contacto - nom != null
     * @param tel tel�fono del contacto
     * @param dir direcci�n del contacto
     * @param email direcci�n electr�nica del contacto
     * @throws ContactoRepetidoException cuando ya existe un contacto con ese nombre
     */
    public void agregarContacto( String nom, String tel, String dir, String email ) throws ContactoRepetidoException
    {
        Contacto c = new Contacto( nom, tel, dir, email );
        if( contactoRaiz == null )
            contactoRaiz = c;
        else
            contactoRaiz.insertar( c );
        numContactos++;
        verificarInvariante( );
    }

    /**
     * Elimina del directorio el contacto con el nombre indicado <br>
     * <b>post: </b>El contacto ha sido eliminado del directorio <br>
     * @param nombre nombre del contacto a eliminar - existe en el directorio un contacto con dicho nombre
     */
    public void eliminarContacto( String nombre )
    {
        contactoRaiz = contactoRaiz.eliminar( nombre );
        numContactos--;
        verificarInvariante( );
    }

    /**
     * Busca y retorna el contacto del nombre indicado. Si no lo encuentra retorna null.
     * @param nombre nombre del contacto a buscar - nombre != null
     * @return contacto correspondiente al nombre, si no existe retorna null
     */
    public Contacto buscarContacto( String nombre )
    {
        return contactoRaiz == null ? null : contactoRaiz.buscar( nombre );
    }

    /**
     * Retorna una lista ordenada con los nombres de los contactos
     * @return lista de contactos ordenada por orden alfab�tico. Si la lista est� vac�a retorna null
     */
    public Collection darListaContactos( )
    {
        if( contactoRaiz == null )
            return null;
        else
        {
            Collection resp = new ArrayList( );
            contactoRaiz.inorden( resp );
            return resp;
        }
    }

    /**
     * Retorna las estad�sticas
     * @return Estadisticas
     */
    public DatoEstadistico[] darEstadisticas( )
    {
        Contacto menor = darMenor( );
        Contacto mayor = darMayor( );

        DatoEstadistico[] estadisticas = new DatoEstadistico[5];
        estadisticas[ 0 ] = new DatoEstadistico( "Altura", new Integer( darAltura( ) ) );
        estadisticas[ 1 ] = new DatoEstadistico( "Peso", new Integer( numContactos ) );
        estadisticas[ 2 ] = new DatoEstadistico( "Menor", menor == null ? "" : menor.darNombre( ) );
        estadisticas[ 3 ] = new DatoEstadistico( "Mayor", mayor == null ? "" : mayor.darNombre( ) );
        estadisticas[ 4 ] = new DatoEstadistico( "Hojas", new Integer( contarHojas( ) ) );
        return estadisticas;
    }

    // -----------------------------------------------------------------
    // M�todos privados
    // -----------------------------------------------------------------

    /**
     * Retorna la altura del �rbol de contactos
     * @return La altura del �rbol de contactos
     */
    private int darAltura( )
    {
        return contactoRaiz == null ? 0 : contactoRaiz.darAltura( );
    }

    /**
     * Retorna el menor contacto del directorio, teniendo en cuenta el orden alfab�tico de los nombres
     * @return El contacto con menor nombre del directorio o null si el directorio es vac�o
     */
    private Contacto darMenor( )
    {
        return contactoRaiz == null ? null : contactoRaiz.darMenor( );
    }

    /**
     * Retorna el mayor contacto del directorio, teniendo en cuenta el orden alfab�tico de los nombres
     * @return El contacto con mayor nombre del directorio o null si el directorio es vac�o
     */
    private Contacto darMayor( )
    {
        return contactoRaiz == null ? null : contactoRaiz.darMayor( );
    }

    /**
     * Retorna el n�mero de hojas que tiene el �rbol de contactos
     * @return N�mero de hojas que tiene el �rbol de contactos
     */
    private int contarHojas( )
    {
        return contactoRaiz == null ? 0 : contactoRaiz.contarHojas( );
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica que en el directorio no haya dos contactos con el mismo nombre
     */
    private boolean sinRepetidos( )
    {
        if( contactoRaiz == null )
            return true;
        else
        {
            Iterator itera = darListaContactos( ).iterator( );
            while( itera.hasNext( ) )
            {
                String nombre = ( String )itera.next( );
                if( contarOcurrencias( nombre ) != 1 )
                    return false;
            }
            return true;
        }
    }

    /**
     * Cuenta el n�mero de contactos en el directorio que tienen el nombre dado como par�metro <br>
     * <b>pre: </b> El �rbol de contactos no es vac�o
     * @param nombre nombre del contacto del cual se est� contando el n�mero de ocurrencias
     */
    private int contarOcurrencias( String nombre )
    {
        return contactoRaiz.contarOcurrencias( nombre );
    }

    /**
     * Verifica que el �rbol binario est� ordenado
     */
    private boolean esOrdenado( )
    {
        return contactoRaiz == null ? true : contactoRaiz.esOrdenado( );
    }

    /**
     * Retorna el n�mero de contactos que est�n en el directorio
     * @return n�mero de contactos presentes en el �rbol
     */
    private int darPeso( )
    {
        return contactoRaiz == null ? 0 : contactoRaiz.darPeso( );
    }

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv:</b> <br>
     * No hay dos contactos con el mismo nombre en el directorio <br>
     * El �rbol de contactos es un �rbol binario ordenado <br>
     * numContactos es el n�mero de contactos presentes en el directorio
     */
    private void verificarInvariante( )
    {
        assert sinRepetidos( ) : "Contactos repetidos";
        assert esOrdenado( ) : "No es un �rbol ordenado";
        assert numContactos == darPeso( ) : "N�mero incorrecto de contactos";
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     * @param valor 
     * @return respuesta extensi�n 1
     */
    public String metodo1( int valor )
    {
        return "respuesta1";
    }

    /**
     * M�todo para la extensi�n 2
     * @param valor 
     * @return respuesta extensi�n 2
     */
    public String metodo2( int valor )
    {
        return "respuesta2";
    }

    /**
     * M�todo para la extensi�n 3
     * @param valor 
     * @return respuesta extensi�n 3
     */
    public String metodo3( String valor )
    {
        return "respuesta3";
    }

    /**
     * M�todo para la extensi�n 4
     * @param valor 
     * @return respuesta extensi�n 4
     */
    public String metodo4( String valor )
    {
        return "respuesta4";
    }

    /**
     * M�todo para la extensi�n 5
     * @param valor 
     * @return respuesta extensi�n 5
     */
    public String metodo5( String valor )
    {
        return "respuesta5";
    }
}