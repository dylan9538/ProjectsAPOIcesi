/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: tiendaDeAlquiler
 * Autor: Rafael Mu�oz Lattion - 05-mar-2012
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.tiendaDeAlquiler.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de acciones
 */
public class PanelAcciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para reiniciar
     */
    private final static String REINICIAR = "Reiniciar Tienda";

    /**
     * Comando para la opci�n 1
     */
    private final static String OPCION_1 = "Opci�n 1";

    /**
     * Comando para la opci�n 2
     */
    private final static String OPCION_2 = "Opci�n 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia a la interfaz de la aplicaci�n
     */
    private InterfazTiendaDeAlquiler principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para reiniciar
     */
    private JButton butReiniciar;

    /**
     * Bot�n para la opci�n 1
     */
    private JButton butOpcion1;

    /**
     * Bot�n para la opci�n 2
     */
    private JButton butOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel de las acciones con una referencia a la ventana principal de la aplicaci�n. <br>
     * <b>post: </b> Construy� el panel e principal = ventana. <br>
     * @param ventana Referencia a la ventana principal. ventana != null.
     */
    public PanelAcciones( InterfazTiendaDeAlquiler ventana )
    {
        principal = ventana;

        TitledBorder border = BorderFactory.createTitledBorder( "Acciones" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );

        setLayout( new GridLayout( 1, 3 ) );

        butReiniciar = new JButton( REINICIAR );
        butReiniciar.setActionCommand( REINICIAR );
        butReiniciar.addActionListener( this );
        add( butReiniciar );

        butOpcion1 = new JButton( OPCION_1 );
        butOpcion1.setActionCommand( OPCION_1 );
        butOpcion1.addActionListener( this );
        add( butOpcion1 );

        butOpcion2 = new JButton( OPCION_2 );
        butOpcion2.setActionCommand( OPCION_2 );
        butOpcion2.addActionListener( this );
        add( butOpcion2 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );

        if( comando.equals( REINICIAR ) )
        {
            principal.reiniciar( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
    }
}
