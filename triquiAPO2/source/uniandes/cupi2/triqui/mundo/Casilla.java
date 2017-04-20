/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Casilla.java,v 1.5 2005/12/02 12:26:03 pa-barvo Exp $
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
     * Cadena para representar que la casilla está vacía
     */
    final public static String CASILLA_VACIA = "";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Marca que indica que jugador tomó la casilla
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
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Indica que la casilla ha sido tomada por un jugador mediante la asignación de una marca. <br>
     * <b>pre: </b> Se debe haber inicializado una instancia de Triqui. <br>
     * <b>post: </b> Se asignó la marca a la casilla actual. <br>
     * @param unaMarca Marca que se asignará a la casilla actual. marca != null y marca != "".
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
     * Indica si la casilla está vacía. <br>
     * <b>pre: </b> Se debe haber inicializado una instancia de Triqui. <br>
     * @return true si la casilla está vacía, false si no lo está.
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