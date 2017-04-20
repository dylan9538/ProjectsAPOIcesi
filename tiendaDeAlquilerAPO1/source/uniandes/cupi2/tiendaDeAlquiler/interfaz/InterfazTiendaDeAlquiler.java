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
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.tiendaDeAlquiler.mundo.Producto;
import uniandes.cupi2.tiendaDeAlquiler.mundo.TiendaDeAlquiler;

/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazTiendaDeAlquiler extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private TiendaDeAlquiler tiendaDeAlquiler;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de la imagen
     */
    private PanelImagen panelImagen;

    /**
     * Panel de los totales
     */
    private PanelTotales panelTotales;

    /**
     * Panel del producto 1
     */
    private PanelProducto panelProducto1;

    /**
     * Panel del producto 2
     */
    private PanelProducto panelProducto2;

    /**
     * Panel del producto 3
     */
    private PanelProducto panelProducto3;

    /**
     * Panel de las acciones
     */
    private PanelAcciones panelAcciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva interfaz. <br>
     * <b>post: </b> El objeto InterfazTiendaDeAlquiler está inicializado.
     */
    public InterfazTiendaDeAlquiler( )
    {
        tiendaDeAlquiler = new TiendaDeAlquiler( );
        tiendaDeAlquiler.inicializar( );

        setTitle( "Tienda de Alquiler" );
        setLayout( new BorderLayout( ) );
        setSize( 780, 750 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );

        panelImagen = new PanelImagen( );
        panelImagen.setPreferredSize( new Dimension( 0, 150 ) );
        add( panelImagen, BorderLayout.NORTH );

        JPanel aux1 = new JPanel( );
        aux1.setLayout( new BorderLayout( ) );

        panelTotales = new PanelTotales( this );
        aux1.add( panelTotales, BorderLayout.NORTH );

        JPanel aux2 = new JPanel( );
        aux2.setLayout( new GridLayout( 1, 3 ) );

        panelProducto1 = new PanelProducto( this, 1, tiendaDeAlquiler.darProducto1( ), "./data/imagenes/p1.png" );
        aux2.add( panelProducto1 );

        panelProducto2 = new PanelProducto( this, 2, tiendaDeAlquiler.darProducto2( ), "./data/imagenes/p2.png" );
        aux2.add( panelProducto2 );

        panelProducto3 = new PanelProducto( this, 3, tiendaDeAlquiler.darProducto3( ), "./data/imagenes/p3.png" );
        aux2.add( panelProducto3 );

        aux1.add( aux2, BorderLayout.CENTER );

        add( aux1, BorderLayout.CENTER );

        panelAcciones = new PanelAcciones( this );
        add( panelAcciones, BorderLayout.SOUTH );
        
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Alquila un producto dado su número por parámetro
     * @param nNumProducto El número del producto que se quiere alquilar
     */
    public void alquilar( int nNumProducto )
    {
        if( nNumProducto == 1 )
        {
            tiendaDeAlquiler.alquilarProducto1( );
            actualizar( 1, tiendaDeAlquiler.darProducto1( ) );
        }
        else if( nNumProducto == 2 )
        {
            tiendaDeAlquiler.alquilarProducto2( );
            actualizar( 2, tiendaDeAlquiler.darProducto2( ) );
        }
        else
        {
            tiendaDeAlquiler.alquilarProducto3( );
            actualizar( 3, tiendaDeAlquiler.darProducto3( ) );
        }
    }

    /**
     * Cambia el precio de alquiler de un producto dado su número por parámetro
     * @param nNumProducto El número del producto que se quiere alquilar
     */
    public void cambiarPrecioAlquiler( int nNumProducto )
    {
        try
        {
            String strPrecioAlquiler = JOptionPane.showInputDialog( "Ingrese el nuevo precio de alquiler del producto" );

            if( strPrecioAlquiler != null )
            {
                if( !strPrecioAlquiler.equals( "" ) )
                {
                    double precioAlquiler = Double.parseDouble( strPrecioAlquiler );

                    if( precioAlquiler > 0 )
                    {
                        if( nNumProducto == 1 )
                        {
                            tiendaDeAlquiler.cambiarPrecioAlquilerProducto1( precioAlquiler );
                            actualizar( 1, tiendaDeAlquiler.darProducto1( ) );
                        }
                        else if( nNumProducto == 2 )
                        {
                            tiendaDeAlquiler.cambiarPrecioAlquilerProducto2( precioAlquiler );
                            actualizar( 2, tiendaDeAlquiler.darProducto2( ) );
                        }
                        else
                        {
                            tiendaDeAlquiler.cambiarPrecioAlquilerProducto3( precioAlquiler );
                            actualizar( 3, tiendaDeAlquiler.darProducto3( ) );
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "Debe ingresar un valor positivo", "Información", JOptionPane.INFORMATION_MESSAGE );
                    }
                }
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar un valor númerico", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Califica un producto dado su número por parámetro
     * @param nNumProducto El número del producto que se quiere alquilar
     */
    public void calificar( int nNumProducto )
    {
        try
        {
            String strCalificacion = JOptionPane.showInputDialog( "Ingrese la calificación del producto con un valor entero entre 1 y 5" );

            if( strCalificacion != null )
            {
                if( !strCalificacion.equals( "" ) )
                {
                    int calificacion = Integer.parseInt( strCalificacion );

                    if( calificacion >= 1 && calificacion <= 5 )
                    {
                        if( nNumProducto == 1 )
                        {
                            tiendaDeAlquiler.calificarProducto1( calificacion );
                            actualizar( 1, tiendaDeAlquiler.darProducto1( ) );
                        }
                        else if( nNumProducto == 2 )
                        {
                            tiendaDeAlquiler.calificarProducto2( calificacion );
                            actualizar( 2, tiendaDeAlquiler.darProducto2( ) );
                        }
                        else
                        {
                            tiendaDeAlquiler.calificarProducto3( calificacion );
                            actualizar( 3, tiendaDeAlquiler.darProducto3( ) );
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "Debe ingresar un valor entero entre 1 y 5", "Información", JOptionPane.INFORMATION_MESSAGE );
                    }
                }
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar un valor númerico entero entre 1 y 5", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Retorna el total recaudado por la tienda de alquiler
     * @return El total recaudado
     */
    public double darTotalRecaudado( )
    {
        return tiendaDeAlquiler.darTotalRecaudado( );
    }

    /**
     * Retorna el promedio recaudado por cada producto de la tienda de alquiler
     * @return El promedio recaudado
     */
    public double darPromedioRecaudado( )
    {
        return tiendaDeAlquiler.darPromedioRecaudoPorProducto( );
    }

    /**
     * Reinicia la tienda de alquiler
     */
    public void reiniciar( )
    {
        tiendaDeAlquiler.reiniciar( );
        actualizar( 1, tiendaDeAlquiler.darProducto1( ) );
        actualizar( 2, tiendaDeAlquiler.darProducto2( ) );
        actualizar( 3, tiendaDeAlquiler.darProducto3( ) );
    }

    /**
     * Actualiza el panel del producto dado por parámetro y el panel de los totales
     * @param nNumProducto El número del producto que se quiere actualizar
     * @param nProducto El producto con la información actualizada
     */
    private void actualizar( int nNumProducto, Producto nProducto )
    {
        if( nNumProducto == 1 )
        {
            panelProducto1.actualizar( nProducto );
        }
        else if( nNumProducto == 2 )
        {
            panelProducto2.actualizar( nProducto );
        }
        else
        {
            panelProducto3.actualizar( nProducto );
        }

        panelTotales.actualizar( );
    }

    // -----------------------------------------------------------------
    // Puntos de extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = tiendaDeAlquiler.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = tiendaDeAlquiler.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {
        InterfazTiendaDeAlquiler interfaz = new InterfazTiendaDeAlquiler( );
        interfaz.setVisible( true );
    }
}
