/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazTriqui.java,v 1.6 2005/12/02 12:26:03 pa-barvo Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Triqui
 * Autor inicial: Katalina Marcos
 * Modificaci�n: Jorge Jim�nez- Junio 2005
 * Modificaci�n: Mario S�nchez - Marzo de 2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.triqui.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.triqui.mundo.JugadorPC;
import uniandes.cupi2.triqui.mundo.Triqui;

/**
 * Interfaz gr�fica del juego del triqui
 */
public class InterfazTriqui extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------


    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Panel triqui
     */
    private PanelTriqui triquiPanel;

    /**
     * Panel botones
     */
    private PanelBotones botonesPanel;

    /**
     * Panel barra de mensajes
     */
    private PanelMensajes mensajesPanel;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Juego de triqui
     */
    private Triqui juegoTriqui;

    /**
     * Jugador PC
     */
    private JugadorPC jugadorPC;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz del triqui
     * @param titulo Nombre que tendr� el Frame que se despliega. t�tulo != null.
     */
    public InterfazTriqui( String titulo )
    {
        // Juego Triqui
        juegoTriqui = new Triqui( );
        // Jugador PC del Triqui
        jugadorPC = new JugadorPC( juegoTriqui, Triqui.MARCA_PC );

        // Tablero del Triqui
        triquiPanel = new PanelTriqui( this, juegoTriqui );
        // Botones
        botonesPanel = new PanelBotones( this );
        // Mensajes
        mensajesPanel = new PanelMensajes( );

        setPreferredSize( new Dimension( 300, 300 ) );
        add( mensajesPanel, BorderLayout.NORTH );
        add( triquiPanel, BorderLayout.CENTER );
        add( botonesPanel, BorderLayout.SOUTH );
        setTitle( titulo );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        mensajesPanel.desplegarMensaje( "Listo para jugar!" );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Prepara para iniciar otro juego
     */
    public void nuevoJuego( )
    {
        // Limpia el tablero del triqui
        juegoTriqui.limpiarTablero( );
        triquiPanel.actualizarTablero( );
    }

    /**
     * Procesa la jugada del humano. Si es v�lido invita a jugar al PC
     * @param casillaJugada Jugada por el humano. casillaJugada != null y casillaJugada != "".
     */
    public void procesaJugada( String casillaJugada )
    {
        int casilla;

        // Obtiene el n�mero de casilla
        casilla = Integer.valueOf( casillaJugada ).intValue( );

        // Indica al juego del triqui la casilla se�alada por el humano
        juegoTriqui.marcarCasilla( casilla, Triqui.MARCA_JUGADOR );
        triquiPanel.actualizarTablero( );

        // Verifica si el humano gan� el juego
        if( juegoTriqui.ganoJuego( Triqui.MARCA_JUGADOR ) )
        {
            mensajesPanel.desplegarMensaje( "Ganaste!" );
        }
        else
        // Si no gan� el humano invita a jugar al PC
        {
            mensajesPanel.desplegarMensaje( "Mi turno!" );

            // si el PC pudo realizar una jugada
            if( jugadorPC.jugar( ) )
            {
                triquiPanel.actualizarTablero( );

                // Verifica si gan� el jugador PC
                if( juegoTriqui.ganoJuego( Triqui.MARCA_PC ) )
                {
                    mensajesPanel.desplegarMensaje( "Gan�!" );
                }
                else
                    // si no gan� el PC cede el turno
                    mensajesPanel.desplegarMensaje( "Tu turno" );
            }
            else
            {
                // Si el jugador PC no pudo realizar la jugada es porque el
                // juego ha terminado
                mensajesPanel.desplegarMensaje( "Se acab� el juego..." );
            }
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Ejecuta la operaci�n 1.<br>
     * <b>post: </b>Se retorna el valor de la operaci�n 1 y se muestra en pantalla.
     */

    public void reqFuncOpcion1( )
    {
        String respuesta = juegoTriqui.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );

    }

    /**
     * Ejecuta la operaci�n 2.<br>
     * <b>post: </b> Se retorna el valor de la operaci�n 2 y se muestra en pantalla.
     */

    public void reqFuncOpcion2( )
    {
        String respuesta = juegoTriqui.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );

    }

    /**
     * M�todo principal de ejecuci�n
     * @param args Argumentos de entrada para el programa. No se utilizan.
     */
    public static void main( String[] args )
    {
        InterfazTriqui gui = new InterfazTriqui( "Juego de Triqui" );
        gui.setVisible( true );
    }
}