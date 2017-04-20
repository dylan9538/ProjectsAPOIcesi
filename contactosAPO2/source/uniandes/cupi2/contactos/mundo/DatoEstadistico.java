/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DatoEstadistico.java,v 1.6 2006/10/22 16:28:48 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n11_contactos
 * Autor: Jorge Villalobos - 14/10/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.contactos.mundo;

/**
 * Representa un dato estad�stico asociado con un dato de la estructura interna de informaci�n del directorio
 */
public class DatoEstadistico
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del dato
     */
    private String nombreDato;

    /**
     * Valor del dato
     */
    private Object valorDato;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del dato estad�stico
     * @param nom Nombre del dato
     * @param val Valor del dato
     */
    public DatoEstadistico( String nom, Object val )
    {
        nombreDato = nom;
        valorDato = val;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del dato
     * @return Nombre del dato
     */
    public String darNombre( )
    {
        return nombreDato;
    }

    /**
     * Retorna el valor del dato
     * @return Valor del dato
     */
    public String darValor( )
    {
        return valorDato.toString( );
    }
}