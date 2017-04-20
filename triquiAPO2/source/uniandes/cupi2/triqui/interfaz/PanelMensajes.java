/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelMensajes.java,v 1.4 2005/12/02 12:26:03 pa-barvo Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Triqui
 * Autor inicial: Katalina Marcos
 * Modificación: Jorge Jiménez- Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.triqui.interfaz;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel que despliega los mensajes del triqui
 */
public class PanelMensajes extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Mensaje en el juego
     */
    private JLabel mensajeJuego;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Inicializa el panel de mensajes para el usuario
     */
    public PanelMensajes( )
    {
        setLayout( new FlowLayout( ) );
        mensajeJuego = new JLabel( );
        mensajeJuego.setForeground( Color.blue );
        mensajeJuego.setHorizontalAlignment( JLabel.LEFT );
        add( mensajeJuego );
        setBackground( Color.white );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cambia el valor del campo de mensajeJuego.
     * @param valor Valor que tomara el nuevo campo. valor != null.
     */
    public void desplegarMensaje( String valor )
    {
        mensajeJuego.setText( valor );
    }

}
