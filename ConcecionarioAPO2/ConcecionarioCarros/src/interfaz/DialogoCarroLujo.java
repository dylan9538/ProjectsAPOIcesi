package interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;

import mundo.Accesorios;
import mundo.Cliente;

public class DialogoCarroLujo extends JDialog {

	
	private InterfazMisCarritos principal;
	private PanelCarroLujo carro;
	
	
	public DialogoCarroLujo(InterfazMisCarritos i, ArrayList<Cliente> clientes, ArrayList accesorios)
	{
		super(i,true);
		principal = i;
		
		carro = new PanelCarroLujo(this,clientes,accesorios);
		add(carro);
		
		pack( );
		setResizable(false);
		setTitle("Pedido Lujo");
		centrar( );
	}
	
	public void generarPedido (String tipoCombustion, String tipoTraccion, String color, String transmision
			, String tipoTapiceria, boolean aireAcondicionado, String cilindraje, ArrayList accesorios,String cedulaCliente)
			{
				principal.generarPedidoLujo(this, tipoCombustion, tipoTraccion, color, 
						transmision, tipoTapiceria, aireAcondicionado, cilindraje, accesorios, cedulaCliente);
			}
	
	private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }
	
}
