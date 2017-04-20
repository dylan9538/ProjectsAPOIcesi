package interfaz;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;


public class DialogoEmpleado extends JDialog{

	
	private InterfazMisCarritos principal;
	private PanelDialogoEmpleado empleado;
	
	public DialogoEmpleado(InterfazMisCarritos i )
	{
		super(i,true);
		principal = i;
		
		empleado = new PanelDialogoEmpleado(this);
		
		add(empleado);
		
		pack( );
		setResizable(false);
		setTitle("Registrar Empleado");
		centrar( );
	}
	
	public void registrarEmpleado(String nombre, String apellido, String numeroId,
			String direccion, String telefono, String celular, String ciudad,
			String pais, String correo, String cuenta, String contrato, String cargo)
	{
		principal.registrarEmpleado(this, nombre, apellido, numeroId, direccion, telefono, celular, ciudad, pais, correo, cuenta, contrato, cargo);
	}
	
	private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }
}
