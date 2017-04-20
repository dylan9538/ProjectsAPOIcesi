/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_triangulo
 * Autor: Pablo Barvo - Oct 20, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.triangulo.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.geom.Line2D;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.triangulo.mundo.Punto;
import uniandes.cupi2.triangulo.mundo.Triangulo;

/**
 * Ventana principal de la aplicaci�n
 */
public class InterfazTriangulo extends JFrame
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Tri�ngulo
     */
    private Triangulo triangulo;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de los botones
     */
    private PanelBotones panelBotones;

    /**
     * Panel de visualizaci�n del tri�ngulo
     */
    private PanelTriangulo panelTriangulo;

    /**
     * Panel de extensiones
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con el encabezado
     */
    private PanelImagen panelImagen;

    /**
     * Di�logo de cambio de puntos
     */
    private DialogoPuntos dialogoPuntos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la interfaz
     */
    public InterfazTriangulo( )
    {
        //Crea el tri�ngulo
        triangulo = new Triangulo( );
        //TODO: cambie los datos de los puntos del Triangulo de tal forma que correspondan a un tri�ngulo recto 

        //Crea el punto 1
        Punto punto1 = new Punto( );
        punto1.inicializar( 120, 20 );

        //Crea el punto 2
        Punto punto2 = new Punto( );
        punto2.inicializar( 220, 200 );

        //Crea el punto 1
        Punto punto3 = new Punto( );
        punto3.inicializar( 20, 200 );

        //Inicializa el color del relleno en Azul
        // Valor RGB = (0, 0, 150)
        uniandes.cupi2.triangulo.mundo.Color colorRelleno = new uniandes.cupi2.triangulo.mundo.Color( );
        colorRelleno.inicializar( 0, 0, 150 );

        //Inicializa el color de las l�neas en negro
        // Valor RGB = (0, 0, 0)
        uniandes.cupi2.triangulo.mundo.Color colorLineas = new uniandes.cupi2.triangulo.mundo.Color( );
        colorLineas.inicializar( 0, 0, 0 );

        //Inicializa el tri�ngulo
        triangulo.inicializar( punto1, punto2, punto3, colorRelleno, colorLineas );

        //Crea la interfaz
        setTitle( "Tri�ngulo" );
        getContentPane( ).setLayout( new BorderLayout( ) );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

        panelBotones = new PanelBotones( this );
        getContentPane( ).add( panelBotones, BorderLayout.WEST );
        panelTriangulo = new PanelTriangulo( triangulo );
        getContentPane( ).add( panelTriangulo, BorderLayout.CENTER );

        panelOpciones = new PanelOpciones( this );
        getContentPane( ).add( panelOpciones, BorderLayout.SOUTH );

        panelImagen = new PanelImagen( );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );

        pack( );
        repintar( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Muestra el di�logo para cambiar los puntos del tri�ngulo
     */
    public void cambiarPuntos( )
    {
        dialogoPuntos = new DialogoPuntos( this );
        dialogoPuntos.setVisible( true );
        setEnabled( false );
    }

    /**
     * Cambia el color del fondo
     *  
     */
    public void cambiarColorFondo( )
    {
        Color colorActual = new Color( triangulo.darColorRelleno( ).darRojo( ), triangulo.darColorRelleno( ).darVerde( ), triangulo.darColorRelleno( ).darAzul( ) );
        Color nuevoColor = JColorChooser.showDialog( this, "Color Fondo", colorActual );
        if( nuevoColor != null )
        {
            //Cambia los valores
            triangulo.darColorRelleno( ).cambiarRojo( nuevoColor.getRed( ) );
            triangulo.darColorRelleno( ).cambiarVerde( nuevoColor.getGreen( ) );
            triangulo.darColorRelleno( ).cambiarAzul( nuevoColor.getBlue( ) );
        }
        repintar( );
    }
    /**
     * Cambia el color de las l�neas
     *  
     */
    public void cambiarColorLineas( )
    {
        Color colorActual = new Color( triangulo.darColorLineas( ).darRojo( ), triangulo.darColorLineas( ).darVerde( ), triangulo.darColorLineas( ).darAzul( ) );
        Color nuevoColor = JColorChooser.showDialog( this, "Color L�neas", colorActual );
        if( nuevoColor != null )
        {
            //Cambia los valores
            triangulo.darColorLineas( ).cambiarRojo( nuevoColor.getRed( ) );
            triangulo.darColorLineas( ).cambiarVerde( nuevoColor.getGreen( ) );
            triangulo.darColorLineas( ).cambiarAzul( nuevoColor.getBlue( ) );
        }
        repintar( );
    }

    /**
     * Repinta el tri�ngulo y los valores
     *  
     */
    public void repintar( )
    {
        panelTriangulo.repaint( );
        panelBotones.cambiarInformacion( triangulo.darPerimetro( ), triangulo.darArea( ), triangulo.darAltura( ) );
    }

    /**
     * Devuelve el tri�ngulo actual
     * @return Tri�ngulo
     */
    public Triangulo darTriangulo( )
    {
        return triangulo;
    }

    /**
     * Verifica si 3 puntos son colineales
     * @param p1x Valor X punto 1
     * @param p1y Valor Y punto 1
     * @param p2x Valor X punto 2
     * @param p2y Valor Y punto 2
     * @param p3x Valor X punto 3
     * @param p3y Valor Y punto 3
     * @return verdadero si los tres puntos dados son colineales
     */
    public boolean colineales( double p1x, double p1y, double p2x, double p2y, double p3x, double p3y )
    {
        //Verifica usando un Line2D
        Line2D linea = new Line2D.Double( p1x, p1y, p2x, p2y );
        return ( linea.ptLineDist( p3x, p3y ) == 0 );

    }

    //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = triangulo.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Ejecuta el punto de extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = triangulo.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Inicia la aplicaci�n
     * @param args Par�metros no utilizados
     */
    public static void main( String[] args )
    {
        InterfazTriangulo interfaz = new InterfazTriangulo( );
        interfaz.setVisible( true );
    }

}
