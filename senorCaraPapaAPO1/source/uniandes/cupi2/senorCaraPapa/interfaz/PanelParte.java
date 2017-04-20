/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelParte.java,v 1.6 2009/05/11 22:35:14 davi-osp Exp $
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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.senorCaraPapa.mundo.Parte;

/**
 * Panel que representa una parte del diseño de cara de papa con las opciones para cambiarla
 */
public class PanelParte extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para el botón siguiente parte
     */
    private final String SIGUIENTE = "Siguiente";

    /**
     * El comando para el botón anterior parte
     */
    private final String ANTERIOR = "Anterior";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana de la aplicación
     */
    private InterfazSenorCaraPapa principal;

    /**
     * Tipo de la parte que representa el panel
     */
    private String tipoParte;

    /**
     * Contador para identificar la posibilidad de la parte seleccionada
     */
    private int identificadorParte;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para cambiar a la anterior parte del mismo tipo
     */
    private JButton btnParteAnterior;

    /**
     * Botón para cambiar a la siguiente parte del mismo tipo
     */
    private JButton btnParteSiguiente;

    /**
     * Etiqueta para mostrar la imagen de la parte
     */
    private JLabel parte;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de la parte según el tipo
     * @param interfaz Ventana de la aplicación
     * @param elTipoParte El tipo de parte que representa
     */
    public PanelParte( InterfazSenorCaraPapa interfaz, String elTipoParte )
    {
        setOpaque( false );
        principal = interfaz;
        tipoParte = elTipoParte;
        identificadorParte = 0;

        // Se establece el layout
        setLayout( new GridBagLayout( ) );

        // Se crean los atributos gráficos
        ImageIcon icono = new ImageIcon( "data/imagenes/anterior.png" );
        btnParteAnterior = new JButton( "", icono );
        btnParteAnterior.setActionCommand( ANTERIOR );
        btnParteAnterior.setToolTipText( ANTERIOR + " posibilidad " + elTipoParte );
        btnParteAnterior.addActionListener( this );

        icono = new ImageIcon( "data/imagenes/siguiente.png" );
        btnParteSiguiente = new JButton( "", icono );
        btnParteSiguiente.setActionCommand( SIGUIENTE );
        btnParteSiguiente.setToolTipText( SIGUIENTE + " posibilidad " + elTipoParte );
        btnParteSiguiente.addActionListener( this );

        parte = new JLabel( "" );       
        inicializarParte( );

        // Se configuran las coordenadas de ubicación de los componentes gráficos
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 0, 6, 0, 6 ), 0, 0 );
        add( btnParteAnterior, gbc );

        gbc.gridx = 2;
        gbc.insets = new Insets( 0, 3, 0, 6 );
        add( btnParteSiguiente, gbc );

        gbc = new GridBagConstraints( 1, 0, 1, 1, 2, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 0, 0, 0, 0 ), 0, 0 );
        add( parte, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que inicializa la región de visualización de la parte con una imagen vacía
     */
    public void inicializarParte( )
    {
        identificadorParte = 0;
        parte.setIcon( new ImageIcon( "data/imagenes/" + tipoParte + "0.png" ) );
    }

    /**
     * Método que reacciona al evento en que se oprime algún botón del panel
     * @param evento El evento del click en el botón. evento!=null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( SIGUIENTE.equals( comando ) )
        {
            if( identificadorParte < 3 )
                identificadorParte++;
            else
                identificadorParte = 1;
        }
        else if( ANTERIOR.equals( comando ) )
        {
            if( identificadorParte > 1 )
                identificadorParte--;
            else
                identificadorParte = 3;
        }
        ImageIcon icono = new ImageIcon( "data/imagenes/" + tipoParte + identificadorParte + ".png" );
        parte.setIcon( icono );

        if( tipoParte.equals( Parte.ACCESORIO ) )
            principal.modificarAccesorioCabeza( identificadorParte );
        else if( tipoParte.equals( Parte.EXPRESION ) )
            principal.modificarExpresionFacial( identificadorParte );
        else if( tipoParte.equals( Parte.BOCA ) )
            principal.modificarBoca( identificadorParte );
        else if( tipoParte.equals( Parte.BRAZOS ) )
            principal.modificarBrazos( identificadorParte );
        else if( tipoParte.equals( Parte.PIES ) )
            principal.modificarPies( identificadorParte );
    }

    /**
     * Método que se encarga de verficar si se ha seleccionado alguna opción de la parte
     * @return Retorna true si se ha seleccionado alguna opción de la parte
     */
    public boolean estaSeleccionado( )
    {
        return identificadorParte > 0;
    }
}
