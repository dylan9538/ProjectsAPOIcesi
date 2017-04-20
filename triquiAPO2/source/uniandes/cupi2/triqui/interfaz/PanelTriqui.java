/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelTriqui.java,v 1.5 2005/12/02 12:26:03 pa-barvo Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Triqui
 * Autor inicial: Katalina Marcos
 * Modificación: Jorge Jiménez- Junio 2005
 * Modificación: Mario Sánchez - Marzo de 2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.triqui.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.cupi2.triqui.mundo.Triqui;

/**
 * Panel que despliega el triqui y sus casillas
 */
public class PanelTriqui extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Instancia del botón que representa una casilla
     */
    private JButton[] botonesCasilla;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Instancia de la clase principal de la interfaz
     */
    private InterfazTriqui principal;

    /**
     * Instancia de la clase que representa al tablero de juego
     */
    private Triqui triqui;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Inicializa el panel que contendrá al triqui
     * @param ventanaP Ventana principal. ventanaP != null.
     */

    public PanelTriqui( InterfazTriqui ventanaP, Triqui tablero )
    {
        triqui = tablero;
        principal = ventanaP;
        setLayout( new GridLayout( 3, 3, 3, 3 ) );
        setBackground( Color.black );
        inicializarTriqui( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa la rejilla de triqui colocando botones en cada casilla
     */
    private void inicializarTriqui( )
    {
        botonesCasilla = new JButton[9];

        for( int i = 1; i <= 9; i++ )
        {
            JButton botonTemp = new JButton( );

            botonTemp.setFocusable( false );
            botonTemp.setRolloverEnabled( false );
            botonTemp.setBorderPainted( true );

            botonTemp.setFont( botonTemp.getFont( ).deriveFont( ( float )50.0 ) );
            botonTemp.setPreferredSize( new Dimension( 15, 15 ) );
            botonTemp.setName( String.valueOf( i ) );
            botonTemp.addActionListener( this );
            botonTemp.setActionCommand( String.valueOf( i ) );
            add( botonTemp );
            botonesCasilla[ i - 1 ] = botonTemp;
        }
    }

    /**
     * Actualiza la visualización del tablero
     */
    public void actualizarTablero( )
    {
        // Prepara la interfaz del tablero del triqui
        for( int i = 1; i <= 9; i++ )
        {
            JButton boton = botonesCasilla[ i - 1 ];
            if( triqui.casillaVacia( i ) )
            {
                boton.setEnabled( true );
                boton.setText( "" );
            }
            else
            {
                boton.setEnabled( false );
                boton.setText( triqui.obtenerMarcaCasilla( i ) );
            }
        }
    }

    /**
     * Responde a los eventos ejecutados por el usuario sobre el tablero de triqui. <br>
     * @param evento Evento realizado por el usuario. evento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String actionCommand = evento.getActionCommand( );
        principal.procesaJugada( actionCommand );
    }

}
