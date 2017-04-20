package interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class DialogoAccesorio extends JDialog {

	private InterfazMisCarritos principal;
	private PanelDialogoAccesorio accesorio;
	
	public DialogoAccesorio(InterfazMisCarritos i)
	{
		super(i,true);
		
		principal = i;
		
		accesorio = new PanelDialogoAccesorio(this);
		add(accesorio);
		
		pack( );
		setResizable(false);
		setTitle("Registrar Accesorio");
		centrar( );
	}
	
	
	public void registrarAccesorio(String nombre,String descripcion, String codigo, String restricciones, String costo){
		
		principal.registrarAccesorio(this, nombre,descripcion, codigo, restricciones, costo);
	}
	
	private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }
}
