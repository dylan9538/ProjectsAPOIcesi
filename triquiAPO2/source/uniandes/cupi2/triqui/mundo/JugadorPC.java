/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: JugadorPC.java,v 1.6 2005/12/02 12:26:03 pa-barvo Exp $
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
 * El jugador computador del triqui
 */
public class JugadorPC
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Juego del triqui que está jugando el jugador PC
     */
    private Triqui triqui;
    /**
     * Marca asignada al jugador PC
     */
    private String miMarca;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un jugador con el juego de triqui y la marca asignada. <br>
     * <b>post: </b> Se crea un jugador que será representado por el computador <br>
     * @param juegoTriqui Instancia del juego Triqui. juegoTriqui != null.
     * @param marca Marca que utilizará el computador. marca != null y marca != "".
     */
    public JugadorPC( Triqui juegoTriqui, String marca )
    {
        triqui = juegoTriqui;
        miMarca = marca;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Trata de efectuar la siguiente jugada del jugador "PC". <br>
     * <b>pre: </b> El objeto JugadorPc debe estar inicializado al igual que el Triqui. <br>
     * <b>post: </b> Se realiza una jugada, colocando una marca en la siguiente posición vacía que se encuentre. <br>
     * @return true si pudo hacer una jugada, false en caso contrario.
     */
    public boolean jugar( )
    {

        int siguienteCasilla = 0;
        boolean realizaJugada;

        if( triqui.casillaVacia( Triqui.SUPERIOR_IZQUIERDA ) )
            siguienteCasilla = Triqui.SUPERIOR_IZQUIERDA;
        else if( triqui.casillaVacia( Triqui.SUPERIOR_CENTRO ) )
            siguienteCasilla = Triqui.SUPERIOR_CENTRO;
        else if( triqui.casillaVacia( Triqui.SUPERIOR_DERECHA ) )
            siguienteCasilla = Triqui.SUPERIOR_DERECHA;
        else if( triqui.casillaVacia( Triqui.MEDIO_IZQUIERDA ) )
            siguienteCasilla = Triqui.MEDIO_IZQUIERDA;
        else if( triqui.casillaVacia( Triqui.MEDIO_CENTRO ) )
            siguienteCasilla = Triqui.MEDIO_CENTRO;
        else if( triqui.casillaVacia( Triqui.MEDIO_DERECHA ) )
            siguienteCasilla = Triqui.MEDIO_DERECHA;
        else if( triqui.casillaVacia( Triqui.INFERIOR_IZQUIERDA ) )
            siguienteCasilla = Triqui.INFERIOR_IZQUIERDA;
        else if( triqui.casillaVacia( Triqui.INFERIOR_CENTRO ) )
            siguienteCasilla = Triqui.INFERIOR_CENTRO;
        else if( triqui.casillaVacia( Triqui.INFERIOR_DERECHA ) )
            siguienteCasilla = Triqui.INFERIOR_DERECHA;

        if( siguienteCasilla == 0 )
        {
            realizaJugada = false;
        }
        else
        {
            triqui.marcarCasilla( siguienteCasilla, miMarca );
            realizaJugada = true;
        }

        return realizaJugada;
    }

}