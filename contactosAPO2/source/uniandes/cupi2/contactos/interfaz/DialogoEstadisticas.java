/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoEstadisticas.java,v 1.9 2007/04/13 04:51:14 carl-veg Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n11_contactos
 * Autor: Mario S�nchez - 28/10/2005
 * Autor: Daniel Romero - 19/10/2006 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.contactos.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.contactos.mundo.DatoEstadistico;

/**
 * Es el di�logo usado para mostrar las estad�sticas y las extensiones
 */
public class DialogoEstadisticas extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private final static String CERRAR = "Cerrar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazContactos ventanaPrincipal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel donde se muestran las estad�sticas
     */
    private PanelDatosEstadisticas panelDatosEstadisticas;

    /**
     * Es el panel para las extensiones
     */
    private PanelExtension panelExtension;

    /**
     * Es el bot�n para cerrar el di�logo
     */
    private JButton botonCerrar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el di�logo para visualizar las estad�sticas
     * @param ic Es una referencia a la clase principal de la interfaz
     * @param datos Datos de la estad�stica
     */
    public DialogoEstadisticas( InterfazContactos ic, DatoEstadistico[] datos )
    {
        super( ic, true );
        ventanaPrincipal = ic;

        panelDatosEstadisticas = new PanelDatosEstadisticas( datos );
        add( panelDatosEstadisticas, BorderLayout.CENTER );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.NORTH );

        JPanel panelBotones = new JPanel( );
        botonCerrar = new JButton( "Cerrar" );
        botonCerrar.addActionListener( this );
        botonCerrar.setActionCommand( CERRAR );
        panelBotones.add( botonCerrar );
        add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Estad�sticas Directorio Contactos" );
        setSize( 257, 405 );
        centrar( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Centra el di�logo en la pantalla
     */
    private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }

    /**
     * Cierra el di�logo
     */
    private void cerrarDialogo( )
    {
        dispose( );
    }

    /**
     * M�todo para la extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String valor = panelExtension.darTextoOpcion1( );

        if( valor == null || "".equals( valor ) )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar el valor", "Directorio Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            try
            {
                int valorEnt = Integer.parseInt( valor );
                ventanaPrincipal.reqFuncOpcion1( valorEnt );
                panelExtension.cambiarTextoOpcion1( "" );
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un n�mero", "Directorio Contactos", JOptionPane.ERROR_MESSAGE );
            }

        }
    }

    /**
     * M�todo para la extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String valor = panelExtension.darTextoOpcion2( );

        if( valor == null || "".equals( valor ) )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar el valor", "Directorio Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            try
            {
                int valorEnt = Integer.parseInt( valor );
                ventanaPrincipal.reqFuncOpcion2( valorEnt );
                panelExtension.cambiarTextoOpcion2( "" );
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un n�mero", "Directorio Contactos", JOptionPane.ERROR_MESSAGE );
            }

        }
    }

    /**
     * M�todo para la extensi�n 3
     */
    public void reqFuncOpcion3( )
    {
        String valor = panelExtension.darTextoOpcion3( );

        if( valor == null || "".equals( valor ) )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar el valor", "Directorio Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            ventanaPrincipal.reqFuncOpcion3( valor );
            panelExtension.cambiarTextoOpcion3( "" );
        }
    }

    /**
     * M�todo para la extensi�n 4
     */
    public void reqFuncOpcion4( )
    {
        String valor = panelExtension.darTextoOpcion4( );

        if( valor == null || "".equals( valor ) )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar el valor", "Directorio Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            ventanaPrincipal.reqFuncOpcion4( valor );
            panelExtension.cambiarTextoOpcion4( "" );
        }
    }

    /**
     * M�todo para la extensi�n 5
     */
    public void reqFuncOpcion5( )
    {
        String valor = panelExtension.darTextoOpcion5( );

        if( valor == null || "".equals( valor ) )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar el valor", "Directorio Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            ventanaPrincipal.reqFuncOpcion5( valor );
            panelExtension.cambiarTextoOpcion5( "" );
        }
    }

    /**
     * Ejecuta la acci�n correspondiente al bot�n que fue presionado
     * @param evento El evento del click sobre uno de los botones. evento != null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( CERRAR.equals( comando ) )
        {
            cerrarDialogo( );
        }

    }
}