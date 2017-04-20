package interfaz;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class DialogoCarroTradicional extends JDialog {

	private InterfazMisCarritos principal;
	private PanelCarroTradicional carro;
	
	
	public DialogoCarroTradicional(InterfazMisCarritos i )
	{
		super(i,true);
		principal = i;
		
		carro = new PanelCarroTradicional(this);
		add(carro);
		
		pack( );
		setResizable(false);
		setTitle("Pedido Tradicional");
		centrar( );
	}
	
	public void generarPedido (String tipoCombustion, String tipoTraccion, String color, String transmision
			, String tipoTapiceria, boolean aireAcondicionado, String cilindraje)
			{
				principal.generarPedidoTradicional(this, tipoCombustion, tipoTraccion, color, 
						transmision, tipoTapiceria, aireAcondicionado, cilindraje);
			}
	
	private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }
}
