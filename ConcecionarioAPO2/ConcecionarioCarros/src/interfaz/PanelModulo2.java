package interfaz;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PanelModulo2 extends JPanel implements ActionListener{

	public final static String LINEA_TRADICIONAL = "Linea Tradicional";
	public final static String LINEA_DEPORTIVA_LUJO = "Linea Deportiva de Lujo";
	public final static String REGISTRAR_ACCESORIO = "Registrar Accesorio";
	
	private InterfazMisCarritos principal;
	
	private JButton butTradi, butLujo, butAccesorio;
	
	public PanelModulo2(InterfazMisCarritos c)
	{
		principal = c;
		
		setBorder( new TitledBorder( "Manejo de pedidos" ) );
        setLayout( new GridBagLayout( ) );
        
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.fill = GridBagConstraints.BOTH;
        
        butTradi = new JButton(LINEA_TRADICIONAL);
        butTradi.setActionCommand(LINEA_TRADICIONAL);
        butTradi.addActionListener(this);
        add(butTradi, gbc);
        
        butLujo = new JButton(LINEA_DEPORTIVA_LUJO);
        butLujo.setActionCommand(LINEA_DEPORTIVA_LUJO);
        butLujo.addActionListener(this);
        gbc.gridy = 1;
        add(butLujo, gbc);
        
        butAccesorio = new JButton(REGISTRAR_ACCESORIO);
        butAccesorio.setActionCommand(REGISTRAR_ACCESORIO);
        butAccesorio.addActionListener(this);
        gbc.gridy = 2;
        add(butAccesorio,gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals(REGISTRAR_ACCESORIO))
		{
			principal.mostrarVentanaRegistrarAccesorio();
		}
		
		else if(comando.equals(LINEA_TRADICIONAL))
		{
			principal.mostrarVentanaCarroTradicional();
		}
		
		else
		{
			principal.mostrarVentanaCarroLujo();
		}
	}
	
	
}
