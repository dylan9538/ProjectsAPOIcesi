/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazSenorCaraPapa.java,v 1.8 2009/05/11 21:54:18 davi-osp Exp $
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

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.senorCaraPapa.mundo.SenorCaraPapa;

/**
 * Esta es la ventana principal de la aplicación
 */
public class InterfazSenorCaraPapa extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private SenorCaraPapa caraDePapa;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la imagen del encabezado
     */
    private PanelImagen panelImagen;

    /**
     * Panel con el diseño de cara de papa
     */
    private PanelCaraPapa panelCaraDePapa;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Descripción <br>
     * <b>post: </b> Descripción
     */
    public InterfazSenorCaraPapa( )
    {
        // Crea la clase principal
        caraDePapa = new SenorCaraPapa( );
        // Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 500, 684 );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Creación de los paneles aquí
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelCaraDePapa = new PanelCaraPapa( this );
        add( panelCaraDePapa, BorderLayout.CENTER );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );
        setTitle( "Creador Cara de Papa" );
        // Centrar la ventana
        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que modifica el accesorio de la cabeza del diseño de cara de papa
     * @param identificadorParte Identificador de la posibilidad de la parte que se quiere seleccionar
     */
    public void modificarAccesorioCabeza( int identificadorParte )
    {
        caraDePapa.seleccionarAccesorioCabeza( identificadorParte );
    }

    /**
     * Método que modifica la expresión facial del diseño de cara de papa
     * @param identificadorParte Identificador de la posibilidad de la parte que se quiere seleccionar
     */
    public void modificarExpresionFacial( int identificadorParte )
    {
        caraDePapa.seleccionarExpresionFacial( identificadorParte );
    }

    /**
     * Método que modifica la boca del diseño de cara de papa
     * @param identificadorParte Identificador de la posibilidad de la parte que se quiere seleccionar
     */
    public void modificarBoca( int identificadorParte )
    {
        caraDePapa.seleccionarBoca( identificadorParte );
    }

    /**
     * Método que modifica los brazos del diseño de cara de papa
     * @param identificadorParte Identificador de la posibilidad de la parte que se quiere seleccionar
     */
    public void modificarBrazos( int identificadorParte )
    {
        caraDePapa.seleccionarBrazos( identificadorParte );
    }

    /**
     * Método que modifica los pies del diseño de cara de papa
     * @param identificadorParte Identificador de la posibilidad de la parte que se quiere seleccionar
     */
    public void modificarPies( int identificadorParte )
    {
        caraDePapa.seleccionarPies( identificadorParte );
    }

    /**
     * Método que calcula y muestra el precio total del diseño actual de cara de papa
     */
    public void calcularTotalDisenoCaraPapa( )
    {
        panelCaraDePapa.mostrarTotalPrecio( caraDePapa.calcularPrecioTotal( ) );
    }

    /**
     * Método que se encarga de vender una unidad de cada una de las partes en el diseño del señor cara de papa. <br>
     * También actualiza la vista del diseño para que no se muestre ninguna parte.
     */
    public void venderDisenoCaraDePapa( )
    {
        if( panelCaraDePapa.todasLasPartesSeleccionadas( ) )
        {
            calcularTotalDisenoCaraPapa( );
            String existencias = caraDePapa.darExistenciasDiseno( );
            if( existencias.contains( ": 0" ) )
                JOptionPane.showMessageDialog( this, "No hay partes suficientes para vender el diseño del Señor Cara de Papa: \n"+existencias, "Vender Diseño", JOptionPane.INFORMATION_MESSAGE );
            else
            {
                int opcion = JOptionPane.showConfirmDialog( this, "Estas son las cantidades disponibles de cada parte seleccionada: \n" + existencias, "¿Desea confirmar la venta?", JOptionPane.YES_NO_OPTION );
                if( opcion == JOptionPane.YES_OPTION )
                {
                    caraDePapa.venderDiseno( );
                    panelCaraDePapa.inicializarPartes( );
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "El diseño del Señor Cara de Papa no está completo. \n Seleccione todas las parte e intente de nuevo.", "Vender Diseño", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = caraDePapa.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = caraDePapa.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Argumentos no utilizados
     */
    public static void main( String[] args )
    {
        InterfazSenorCaraPapa interfaz = new InterfazSenorCaraPapa( );
        interfaz.setVisible( true );
    }

}