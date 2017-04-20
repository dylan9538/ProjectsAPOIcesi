/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazSenorCaraPapa.java,v 1.8 2009/05/11 21:54:18 davi-osp Exp $
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

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.senorCaraPapa.mundo.SenorCaraPapa;

/**
 * Esta es la ventana principal de la aplicaci�n
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
     * Panel con el dise�o de cara de papa
     */
    private PanelCaraPapa panelCaraDePapa;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Descripci�n <br>
     * <b>post: </b> Descripci�n
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

        // Creaci�n de los paneles aqu�
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
    // M�todos
    // -----------------------------------------------------------------

    /**
     * M�todo que modifica el accesorio de la cabeza del dise�o de cara de papa
     * @param identificadorParte Identificador de la posibilidad de la parte que se quiere seleccionar
     */
    public void modificarAccesorioCabeza( int identificadorParte )
    {
        caraDePapa.seleccionarAccesorioCabeza( identificadorParte );
    }

    /**
     * M�todo que modifica la expresi�n facial del dise�o de cara de papa
     * @param identificadorParte Identificador de la posibilidad de la parte que se quiere seleccionar
     */
    public void modificarExpresionFacial( int identificadorParte )
    {
        caraDePapa.seleccionarExpresionFacial( identificadorParte );
    }

    /**
     * M�todo que modifica la boca del dise�o de cara de papa
     * @param identificadorParte Identificador de la posibilidad de la parte que se quiere seleccionar
     */
    public void modificarBoca( int identificadorParte )
    {
        caraDePapa.seleccionarBoca( identificadorParte );
    }

    /**
     * M�todo que modifica los brazos del dise�o de cara de papa
     * @param identificadorParte Identificador de la posibilidad de la parte que se quiere seleccionar
     */
    public void modificarBrazos( int identificadorParte )
    {
        caraDePapa.seleccionarBrazos( identificadorParte );
    }

    /**
     * M�todo que modifica los pies del dise�o de cara de papa
     * @param identificadorParte Identificador de la posibilidad de la parte que se quiere seleccionar
     */
    public void modificarPies( int identificadorParte )
    {
        caraDePapa.seleccionarPies( identificadorParte );
    }

    /**
     * M�todo que calcula y muestra el precio total del dise�o actual de cara de papa
     */
    public void calcularTotalDisenoCaraPapa( )
    {
        panelCaraDePapa.mostrarTotalPrecio( caraDePapa.calcularPrecioTotal( ) );
    }

    /**
     * M�todo que se encarga de vender una unidad de cada una de las partes en el dise�o del se�or cara de papa. <br>
     * Tambi�n actualiza la vista del dise�o para que no se muestre ninguna parte.
     */
    public void venderDisenoCaraDePapa( )
    {
        if( panelCaraDePapa.todasLasPartesSeleccionadas( ) )
        {
            calcularTotalDisenoCaraPapa( );
            String existencias = caraDePapa.darExistenciasDiseno( );
            if( existencias.contains( ": 0" ) )
                JOptionPane.showMessageDialog( this, "No hay partes suficientes para vender el dise�o del Se�or Cara de Papa: \n"+existencias, "Vender Dise�o", JOptionPane.INFORMATION_MESSAGE );
            else
            {
                int opcion = JOptionPane.showConfirmDialog( this, "Estas son las cantidades disponibles de cada parte seleccionada: \n" + existencias, "�Desea confirmar la venta?", JOptionPane.YES_NO_OPTION );
                if( opcion == JOptionPane.YES_OPTION )
                {
                    caraDePapa.venderDiseno( );
                    panelCaraDePapa.inicializarPartes( );
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "El dise�o del Se�or Cara de Papa no est� completo. \n Seleccione todas las parte e intente de nuevo.", "Vender Dise�o", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = caraDePapa.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2
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
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
     * @param args Argumentos no utilizados
     */
    public static void main( String[] args )
    {
        InterfazSenorCaraPapa interfaz = new InterfazSenorCaraPapa( );
        interfaz.setVisible( true );
    }

}