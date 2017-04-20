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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.tiendaDeAlquiler.mundo.Producto;

/**
 * Panel con la información de cada producto
 */
public class PanelProducto extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para el botón de alquilar
     */
    private final static String ALQUILAR = "Alquilar";

    /**
     * Comando para el botón de cambiar el precio
     */
    private final static String CAMBIAR_PRECIO = "Cambiar Precio";

    /**
     * Comando para el botón de calificar
     */
    private final static String CALIFICAR = "Calificar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia a la interfaz de la aplicación
     */
    private InterfazTiendaDeAlquiler principal;

    /**
     * Es el producto que se está manejando
     */
    private int numProducto;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta de texto para la imagen del producto
     */
    private JLabel labImagen;

    /**
     * Etiqueta de texto para el título del producto
     */
    private JLabel labTitulo;

    /**
     * Etiqueta de texto para el tipo del producto
     */
    private JLabel labTipo;

    /**
     * Etiqueta de texto para el precio de alquiler del producto
     */
    private JLabel labPrecioAlquiler;

    /**
     * Etiqueta de texto para el total recaudado por el producto
     */
    private JLabel labTotalRecaudado;

    /**
     * Etiqueta de texto para la calificación del producto
     */
    private JLabel labCalificacion;

    /**
     * El botón de alquilar
     */
    private JButton butAlquilar;

    /**
     * El botón para cambiar el precio
     */
    private JButton butCambiarPrecio;

    /**
     * El botón de calificar
     */
    private JButton butCalificar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel del producto con una referencia a la ventana principal de la aplicación, un numero del producto que representa, la instancia del producto y la ruta
     * de su imagen. <br>
     * <b>post: </b> Construyó el panel e principal = ventana && numProducto == nNumProducto. <br>
     * @param ventana Referencia a la ventana principal. ventana != null.
     * @param nNumProducto El número del producto que se está representando. nNumProducto >= 1 && nNumProducto <= 3
     * @param nProducto El producto. nProducto != null
     * @param nRutaImagen La ruta de la imagen del producto. nRutaImagen != null && nRutaImagen != ""
     */
    public PanelProducto( InterfazTiendaDeAlquiler ventana, int nNumProducto, Producto nProducto, String nRutaImagen )
    {
        principal = ventana;
        numProducto = nNumProducto;

        TitledBorder border = BorderFactory.createTitledBorder( "Producto " + nNumProducto );
        border.setTitleColor( Color.BLUE );
        setBorder( border );

        setLayout( new BorderLayout( ) );

        labImagen = new JLabel( new ImageIcon( nRutaImagen ) );
        add( labImagen, BorderLayout.NORTH );

        JPanel aux = new JPanel( );
        aux.setLayout( new GridLayout( 8, 1 ) );

        labTitulo = new JLabel( "Título: " + nProducto.darTitulo( ) );
        aux.add( labTitulo );

        labTipo = new JLabel( "Tipo: " + nProducto.darTipo( ) );
        aux.add( labTipo );

        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###,###.##" );

        String precioBaseAlquiler = df.format( nProducto.darPrecioAquiler( ) );
        labPrecioAlquiler = new JLabel( "Precio Alquiler: $" + precioBaseAlquiler );
        aux.add( labPrecioAlquiler );

        String totalRecaudado = df.format( nProducto.darTotalRecaudado( ) );
        labTotalRecaudado = new JLabel( "Total Recaudado: $" + totalRecaudado );
        aux.add( labTotalRecaudado );

        labCalificacion = new JLabel( "Calificación: " + nProducto.darCalificacionGlobal( ) );
        aux.add( labCalificacion );

        butAlquilar = new JButton( ALQUILAR );
        butAlquilar.setActionCommand( ALQUILAR );
        butAlquilar.addActionListener( this );
        aux.add( butAlquilar );

        butCambiarPrecio = new JButton( CAMBIAR_PRECIO );
        butCambiarPrecio.setActionCommand( CAMBIAR_PRECIO );
        butCambiarPrecio.addActionListener( this );
        aux.add( butCambiarPrecio );

        butCalificar = new JButton( CALIFICAR );
        butCalificar.setActionCommand( CALIFICAR );
        butCalificar.addActionListener( this );
        aux.add( butCalificar );

        add( aux, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información del producto
     * @param nProducto El producto con la información actualizada. nProducto != null
     */
    public void actualizar( Producto nProducto )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###,###.##" );

        String precioAlquiler = df.format( nProducto.darPrecioAquiler( ) );
        labPrecioAlquiler.setText( "Precio Alquiler: $" + precioAlquiler );
        String totalRecaudado = df.format( nProducto.darTotalRecaudado( ) );
        labTotalRecaudado.setText( "Total Recaudado: $" + totalRecaudado );
        String calificacion = df.format( nProducto.darCalificacionGlobal( ) );
        labCalificacion.setText( "Calificación: " + calificacion );
    }

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );

        if( comando.equals( ALQUILAR ) )
        {
            principal.alquilar( numProducto );
        }
        else if( comando.equals( CAMBIAR_PRECIO ) )
        {
            principal.cambiarPrecioAlquiler( numProducto );
        }
        else if( comando.equals( CALIFICAR ) )
        {
            principal.calificar( numProducto );
        }
    }
}