/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java,v 1.2 2009/05/11 21:54:18 davi-osp Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_senorCaraPapa
 * Autor: Silvia de la Torre Díaz - 19-ene-2009
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.senorCaraPapa.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones
 */
public class PanelExtension extends JPanel implements ActionListener
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
     * Comando Vender
     */
    private static final String VENDER = "Vender";

    /**
     * Comando Totalizar
     */
    private static final String TOTALIZAR = "Totalizar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazSenorCaraPapa principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón Opción 1
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2
     */
    private JButton btnOpcion2;

    /**
     * Botón Vender diseño
     */
    private JButton btnVender;

    /**
     * Botón Totalizar precio diseño
     */
    private JButton btnTotalizar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventana Ventana principal
     */
    public PanelExtension( InterfazSenorCaraPapa ventana )
    {
        principal = ventana;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 4, 5, 5 ) );

        // Botón totalizar
        btnTotalizar = new JButton( TOTALIZAR );
        btnTotalizar.setActionCommand( TOTALIZAR );
        btnTotalizar.addActionListener( this );
        add( btnTotalizar );

        // Botón vender
        btnVender = new JButton( VENDER );
        btnVender.setActionCommand( VENDER );
        btnVender.addActionListener( this );
        add( btnVender );

        // Botón opción 1
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        // Botón opción 2
        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( TOTALIZAR.equals( e.getActionCommand( ) ) )
        {
            principal.calcularTotalDisenoCaraPapa( );
        }
        else if( VENDER.equals( e.getActionCommand( ) ) )
        {
            principal.venderDisenoCaraDePapa( );
        }
        else if( OPCION_1.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion2( );
        }
    }

}
