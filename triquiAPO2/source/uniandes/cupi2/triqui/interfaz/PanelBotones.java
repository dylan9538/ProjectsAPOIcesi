/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelBotones.java,v 1.5 2005/12/02 12:26:03 pa-barvo Exp $
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
package uniandes.cupi2.triqui.interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel que contiene los botones del triqui
 */
public class PanelBotones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Opción 1
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opción 2
     */
    private static final String OPCION_2 = "OPCION_2";

    /**
     * Comando juego nuevo
     */
    private static final String JUEGO_NUEVO = "JUEGO_NUEVO";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Botón de nuevo juego
     */
    private JButton botonNuevoJuego;
    /**
     * Botón de opción 1
     */
    private JButton botonOpcion1;
    /**
     * Botón de opción 2
     */
    private JButton botonOpcion2;
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Instancia de la clase principal de la interfaz
     */
    private InterfazTriqui principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el panel de mensajes para el usuario
     * @param ventana Ventana principal. ventana != null.
     */
    public PanelBotones( InterfazTriqui ventana )
    {
        principal = ventana;
        botonNuevoJuego = new JButton( );
        botonOpcion1 = new JButton( );
        botonOpcion2 = new JButton( );
        inicializarBoton( botonNuevoJuego, "Juego nuevo", PanelBotones.JUEGO_NUEVO, Color.BLACK );
        inicializarBoton( botonOpcion1, "Opción 1", PanelBotones.OPCION_1, Color.BLACK );
        inicializarBoton( botonOpcion2, "Opción 2", PanelBotones.OPCION_2, Color.BLACK );
        add( botonNuevoJuego );
        add( botonOpcion1 );
        add( botonOpcion2 );
    }
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Define las propiedades para un botón. <br>
     * @param boton Botón al cual se le definen las propiedades. boton !=null.
     * @param etiqueta Texto de presentación del boton. etiqueta != null.
     * @param comando Acción asociada al botón. comando != null.
     * @param colorTexto Color del texto de presentación. colorTexto != null.
     */

    private void inicializarBoton( JButton boton, String etiqueta, String comando, Color colorTexto )
    {
        boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( comando );
        boton.addActionListener( this );
        boton.setForeground( colorTexto );
    }

    /**
     * Se encarga de capturar eventos ejecutados por el usuario.
     * @param evento Evento realizado por el usuario. evento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String actionCommand = evento.getActionCommand( );
        if( actionCommand.equals( PanelBotones.JUEGO_NUEVO ) )
        {
            principal.nuevoJuego( );
        }
        else if( actionCommand.equals( PanelBotones.OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( actionCommand.equals( PanelBotones.OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
    }
}
