/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.contactos.mundo.Contacto;

/**
 * Panel donde se muestran o se editan los datos de un contacto
 */
public class PanelDatosContacto extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta Nombre
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta Tel�fono
     */
    private JLabel etiquetaTelefono;

    /**
     * Etiqueta Direcci�n
     */
    private JLabel etiquetaDireccion;

    /**
     * Etiqueta Email
     */
    private JLabel etiquetaEmail;

    /**
     * Campo de texto para el Nombre
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para el Tel�fono
     */
    private JTextField txtTelefono;

    /**
     * Campo de texto para la direcci�n
     */
    private JTextField txtDireccion;

    /**
     * Campo de texto para el email
     */
    private JTextField txtEmail;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel y deja los componentes ubicados
     */
    public PanelDatosContacto( )
    {
        setBorder( new TitledBorder( "Datos del Contacto" ) );

        setLayout( new GridBagLayout( ) );

        GridBagConstraints gbcI = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets( 5, 10, 5, 5 ), 0, 0 );
        GridBagConstraints gbcD = new GridBagConstraints( 1, 0, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets( 5, 5, 5, 10 ), 0, 0 );

        etiquetaNombre = new JLabel( "Nombre:" );
        txtNombre = new JTextField( "" );
        add( etiquetaNombre, gbcI );
        add( txtNombre, gbcD );

        gbcI.gridy = 1;
        gbcD.gridy = 1;

        etiquetaTelefono = new JLabel( "Tel�fono:" );
        txtTelefono = new JTextField( "" );
        add( etiquetaTelefono, gbcI );
        add( txtTelefono, gbcD );

        gbcI.gridy = 2;
        gbcD.gridy = 2;

        etiquetaDireccion = new JLabel( "Direcci�n:" );
        txtDireccion = new JTextField( "" );
        add( etiquetaDireccion, gbcI );
        add( txtDireccion, gbcD );

        gbcI.gridy = 3;
        gbcD.gridy = 3;

        etiquetaEmail = new JLabel( "Email:" );
        txtEmail = new JTextField( "" );
        add( etiquetaEmail, gbcI );
        add( txtEmail, gbcD );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Retorna el texto ingresado en el campo para el nombre
     * @return nombre
     */
    public String darNombre( )
    {
        return txtNombre.getText( );
    }

    /**
     * Retorna el texto ingresado en el campo para el tel�fono
     * @return tel�fono
     */
    public String darTelefono( )
    {
        return txtTelefono.getText( );
    }

    /**
     * Retorna el texto ingresado en el campo para la direcci�n
     * @return direcci�n
     */
    public String darDireccion( )
    {
        return txtDireccion.getText( );
    }

    /**
     * Retorna el texto ingresado en el campo para el email
     * @return email
     */
    public String darEmail( )
    {
        return txtEmail.getText( );
    }

    /**
     * Deshabilita los textos para que no se puedan editar en el modo de b�squeda
     * 
     */
    public void modoBusqueda( )
    {
        txtDireccion.setEnabled( false );
        txtEmail.setEnabled( false );
        txtNombre.setEnabled( false );
        txtTelefono.setEnabled( false );
    }

    /**
     * Habilita los textos para que no se puedan editar en el modo de inserci�n
     * 
     */
    public void modoInsercion( )
    {
        txtDireccion.setEnabled( true );
        txtEmail.setEnabled( true );
        txtNombre.setEnabled( true );
        txtTelefono.setEnabled( true );
        limpiar( );
    }

    /**
     * Muestra la informaci�n del contacto
     * @param c El contacto del que se va a mostrar la informaci�n
     */
    public void mostrarInformacionContacto( Contacto c )
    {
        txtNombre.setText( c.darNombre( ) );
        txtTelefono.setText( c.darTelefono( ) );
        txtDireccion.setText( c.darDireccion( ) );
        txtEmail.setText( c.darEmail( ) );
    }

    /**
     * Borra la informaci�n que se est� mostrando actualmente
     * 
     */
    public void limpiar( )
    {
        txtNombre.setText( "" );
        txtTelefono.setText( "" );
        txtDireccion.setText( "" );
        txtEmail.setText( "" );
    }
}