/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: tiendaDeAlquiler
 * Autor: Rafael Muñoz Lattion - 05-mar-2012
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.tiendaDeAlquiler.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con la información de los totales que maneja la tienda
 */
public class PanelTotales extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia a la interfaz de la aplicación
     */
    private InterfazTiendaDeAlquiler principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta de texto para el total recaudado
     */
    private JLabel labTotalRecaudado;

    /**
     * Etiqueta de texto para el promedio recaudado
     */
    private JLabel labPromedioRecaudado;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel de los totales con una referencia a la ventana principal de la aplicación. <br>
     * <b>post: </b> Construyó el panel e principal = ventana. <br>
     * @param ventana Referencia a la ventana principal. ventana != null.
     */
    public PanelTotales( InterfazTiendaDeAlquiler ventana )
    {
        principal = ventana;

        TitledBorder border = BorderFactory.createTitledBorder( "Totales" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );

        setLayout( new GridLayout( 2, 1 ) );

        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###,###.##" );

        String totalRecaudado = df.format( principal.darTotalRecaudado( ) );
        labTotalRecaudado = new JLabel( "Total Recaudado: $" + totalRecaudado );
        labTotalRecaudado.setHorizontalAlignment( JLabel.CENTER );
        labTotalRecaudado.setForeground( Color.RED );
        labTotalRecaudado.setFont( new Font( "Tahoma", Font.BOLD, 20 ) );
        add( labTotalRecaudado );

        String promedioRecaudado = df.format( principal.darPromedioRecaudado( ) );
        labPromedioRecaudado = new JLabel( "Cada producto en promedio recauda: $" + promedioRecaudado );
        labPromedioRecaudado.setHorizontalAlignment( JLabel.CENTER );
        labPromedioRecaudado.setForeground( Color.RED );
        labPromedioRecaudado.setFont( new Font( "Tahoma", Font.BOLD, 20 ) );
        add( labPromedioRecaudado );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza los totales de la tienda de alquiler
     */
    public void actualizar( )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###,###.##" );
        String totalRecaudado = df.format( principal.darTotalRecaudado( ) );
        labTotalRecaudado.setText( "Total Recaudado: $" + totalRecaudado );
        String promedioRecaudado = df.format( principal.darPromedioRecaudado( ) );
        labPromedioRecaudado.setText( "Cada producto en promedio recauda: $" + promedioRecaudado );
    }
}
