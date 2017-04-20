package interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class DialogoCliente extends JDialog {

	private InterfazMisCarritos principal;
	private PanelDialogoCliente cliente;
	
	public DialogoCliente(InterfazMisCarritos i)
	{
		super(i,true);
		
		principal = i;
		cliente = new PanelDialogoCliente(this);
		add(cliente);

		pack( );
		setResizable(false);
		setTitle("Registrar Cliente");
		centrar( );
		
	}
	
	public void registrarCliente(String nombre, String apellido, String numeroId,
			String direccion, String telefono, String celular, String ciudad,
			String pais, String correo)
	{
		principal.registrarCliente(this, nombre, apellido, numeroId, direccion, telefono, celular, ciudad, pais, correo);
	}
	
	private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }
	
}
