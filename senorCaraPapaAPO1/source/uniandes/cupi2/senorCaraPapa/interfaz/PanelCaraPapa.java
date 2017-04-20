/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelCaraPapa.java,v 1.1 2009/05/11 21:54:18 davi-osp Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_senorCaraPapa
 * Autor: Silvia de la Torre D�az - 19-ene-2009
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.senorCaraPapa.interfaz;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.senorCaraPapa.mundo.Parte;

/**
 * Panel con las partes del dise�o de cara de papa
 */
public class PanelCaraPapa extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Ventana de la aplicaci�n
     */
    private InterfazSenorCaraPapa principal;

    /**
     * Panel para el accesorio de la cabeza del se�or cara de papa dise�ado
     */
    private PanelParte panelAccesorio;

    /**
     * Panel para la expresi�n del se�or cara de papa dise�ado
     */
    private PanelParte panelExpresion;

    /**
     * Panel para la boca del se�or cara de papa dise�ado
     */
    private PanelParte panelBoca;

    /**
     * Panel para los brazos del se�or cara de papa dise�ado
     */
    private PanelParte panelBrazos;

    /**
     * Panel para los pies del se�or cara de papa dise�ado
     */
    private PanelParte panelPies;

    /**
     * Etiqueta que indica el precio total
     */
    private JLabel etiquetaTotalPrecio;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel donde se muestra el dise�o de cara de papa
     * @param interfaz Interfaz de la aplicaci�n
     */
    public PanelCaraPapa( InterfazSenorCaraPapa interfaz )
    {
        principal = interfaz;
        setPreferredSize( new Dimension( 540, 180 ) );
        setMinimumSize( new Dimension( 540, 180 ) );
        setSize( 540, 180 );
        // Se establece el layout
        setLayout( new GridBagLayout( ) );

        // Se crean los atributos gr�ficos
        etiquetaTotalPrecio = new JLabel( " ", JLabel.RIGHT );
        Font fuente = etiquetaTotalPrecio.getFont( ).deriveFont( 18.0f );
        fuente = etiquetaTotalPrecio.getFont( ).deriveFont( 20.0f );
        etiquetaTotalPrecio.setFont( fuente );

        panelAccesorio = new PanelParte( principal, Parte.ACCESORIO );
        panelExpresion = new PanelParte( principal, Parte.EXPRESION );
        panelBoca = new PanelParte( principal, Parte.BOCA );
        panelBrazos = new PanelParte( principal, Parte.BRAZOS );
        panelPies = new PanelParte( principal, Parte.PIES );

        // Se configuran las coordenadas de ubicaci�n de los componentes gr�ficos
        GridBagConstraints gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 0, 15, 0, 15 ), 0, 0 );
        add( panelAccesorio, gbc );
        gbc.gridy++;
        add( panelExpresion, gbc );
        gbc.gridy++;
        add( panelBoca, gbc );
        gbc.gridy++;
        add( panelBrazos, gbc );
        gbc.gridy++;
        add( panelPies, gbc );
        gbc.gridy++;
        gbc.insets = new Insets( 3, 15, 5, 100 );
        add( etiquetaTotalPrecio, gbc );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * M�todo que muestra el precio total del dise�o de cara de papa
     * @param total El precio correspondiente al total despu�s de descuentos
     */
    public void mostrarTotalPrecio( double total )
    {
        etiquetaTotalPrecio.setText( "TOTAL: " + formatearValor( total ) );
    }

    /**
     * Formatea un valor num�rico para presentar en la interfaz
     * @param valor El valor num�rico a ser formateado
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValor( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

    /**
     * Este es el m�todo llamado por la m�quina virtual cuando hay que volver a pintar el panel y se sobrecarga para pintar la gr�fica del cuerpo de cara de papa
     * @param g @param g Es el componente gr�fico para dibujar que corresponde a la superficie del panel
     */
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2 = ( Graphics2D )g;
        Image cuerpo = Toolkit.getDefaultToolkit( ).getImage( "data/imagenes/cuerpo.png" );
        g2.drawImage( cuerpo, 78, 5, null );
        validate( );
        principal.repaint( );
    }

    /**
     * M�todo que deja de mostrar las im�genes del dise�o de cara de papa y el total
     */
    public void inicializarPartes( )
    {
        etiquetaTotalPrecio.setText( " " );
        panelAccesorio.inicializarParte( );
        panelExpresion.inicializarParte( );
        panelBoca.inicializarParte( );
        panelBrazos.inicializarParte( );
        panelPies.inicializarParte( );
    }

    /**
     * M�todo que verifica si todas las partes del dise�o est�n seleccionadas
     * @return Retorna true si todas las partes han sido seleccionadas
     */
    public boolean todasLasPartesSeleccionadas( )
    {
        return panelAccesorio.estaSeleccionado() && panelExpresion.estaSeleccionado() &&panelBoca.estaSeleccionado() &&panelBrazos.estaSeleccionado() &&panelPies.estaSeleccionado();
    }
}
