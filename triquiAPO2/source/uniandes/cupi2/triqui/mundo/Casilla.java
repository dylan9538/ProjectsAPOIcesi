/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Casilla.java,v 1.5 2005/12/02 12:26:03 pa-barvo Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Triqui
 * Autor inicial: Katalina Marcos
 * Modificaci�n: Jorge Jim�nez- Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.triqui.mundo;

/**
 * Casilla del triqui
 */
public class Casilla
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Cadena para representar que la casilla est� vac�a
     */
    final public static String CASILLA_VACIA = "";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Marca que indica que jugador tom� la casilla
     */
    private String marca;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea una casilla con su marca inicializada en ""
     */
    public Casilla( )
    {
        marca = CASILLA_VACIA;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Indica que la casilla ha sido tomada por un jugador mediante la asignaci�n de una marca. <br>
     * <b>pre: </b> Se debe haber inicializado una instancia de Triqui. <br>
     * <b>post: </b> Se asign� la marca a la casilla actual. <br>
     * @param unaMarca Marca que se asignar� a la casilla actual. marca != null y marca != "".
     */
    public void asignarMarca( String unaMarca )
    {
        marca = unaMarca;
    }

    /**
     * Obtener la marca asignada a la casilla. <br>
     * <b>pre: </b> Se debe haber inicializado una instancia de Triqui. <br>
     * @return marca Marca que tiene la casilla actual. marca != null.
     */
    public String obtenerMarca( )
    {
        return marca;
    }

    /**
     * Indica si la casilla est� vac�a. <br>
     * <b>pre: </b> Se debe haber inicializado una instancia de Triqui. <br>
     * @return true si la casilla est� vac�a, false si no lo est�.
     */
    public boolean estaVacia( )
    {
        boolean esta = false;
        if( marca.equals( CASILLA_VACIA ) )
            esta = true;
        return esta;
    }

    /**
     * Borra la marca asignada a la casilla. <br>
     * <b>pre: </b> Se debe haber inicializado una instancia de Triqui. <br>
     * <b>post: </b> Se Asigna "" a la marca de la casilla actual. <br>
     */
    public void limpiar( )
    {
        marca = CASILLA_VACIA;
    }

    /**
     * Indica si la casilla contiene la marca dada. <br>
     * <b>pre: </b> Se debe haber inicializado una instancia de Triqui. <br>
     * @param unaMarca Marca a comparar. unaMarca != null.
     * @return true si contiene la marca, false en caso contrario.
     */
    public boolean contieneMarca( String unaMarca )
    {
        boolean esta = marca.equals( unaMarca );
        return esta;
    }
}