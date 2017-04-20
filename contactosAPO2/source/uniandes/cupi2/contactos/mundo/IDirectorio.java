/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: IDirectorio.java,v 1.8 2007/04/13 04:51:14 carl-veg Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n11_contactos
 * Autor: Jorge Villalobos - 26/09/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.contactos.mundo;

import java.util.*;

/**
 * Esta interfaz especifica los servicios que deben ser proporcionados por el directorio de contactos
 */
public interface IDirectorio
{
    /**
     * Agrega un contacto al directorio <br>
     * <b>post: </b>El contacto ha sido agregado al directorio.
     * @param nombre nombre del contacto - nombre != null
     * @param telefono tel�fono del contacto
     * @param direccion direcci�n del contacto
     * @param email direcci�n electr�nica del contacto
     * @throws ContactoRepetidoException cuando ya existe un contacto con ese nombre
     */
    public void agregarContacto( String nombre, String telefono, String direccion, String email ) throws ContactoRepetidoException;

    /**
     * Busca y retorna el contacto del nombre indicado. Si no lo encuentra retorna null.
     * @param nombre nombre del contacto a buscar - nombre != null
     * @return contacto correspondiente al nombre, si no existe retorna null
     */
    public Contacto buscarContacto( String nombre );

    /**
     * Elimina del directorio el contacto con el nombre indicado <br>
     * <b>post: </b>El contacto ha sido eliminado del directorio <br>
     * @param nombre nombre del contacto a eliminar - existe en el directorio un contacto con dicho nombre
     */
    public void eliminarContacto( String nombre );

    /**
     * Retorna una lista ordenada con los nombres de los contactos
     * @return lista de contactos ordenada por orden alfab�tico. Si la lista est� vac�a retorna null
     */
    public Collection darListaContactos( );

    /**
     * Retorna las estad�sticas asociadas con la estructura interna de informaci�n del directorio
     * @return Las estad�sticas asociadas con la estructura interna de informaci�n del directorio
     */
    public DatoEstadistico[] darEstadisticas( );

    /**
     * M�todo para la extensi�n 1
     * @param valor 
     * @return respuesta extensi�n 1
     */
    public String metodo1( int valor );

    /**
     * M�todo para la extensi�n 2
     * @param valor 
     * @return respuesta extensi�n 2
     */
    public String metodo2( int valor );

    /**
     * M�todo para la extensi�n 3
     * @param valor 
     * @return respuesta extensi�n 3
     */
    public String metodo3( String valor );

    /**
     * M�todo para la extensi�n 4
     * @param valor 
     * @return respuesta extensi�n 4
     */
    public String metodo4( String valor );

    /**
     * M�todo para la extensi�n 5
     * @param valor 
     * @return respuesta extensi�n 5
     */
    public String metodo5( String valor );
}