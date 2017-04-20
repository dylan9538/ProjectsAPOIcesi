package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PanelModulo1 extends JPanel implements ActionListener {

	public final static String CLIENTE = "Registrar Cliente";
	public final static String EMPLEADO = "Registrar Empleado";
	
	
	private InterfazMisCarritos principal;
	
	JButton butCliente, butEmpleado;
	
	public PanelModulo1(InterfazMisCarritos c)
	{
		principal = c;
		
		
		 setBorder( new TitledBorder( "Manejo Informacion personal" ) );
	        setLayout( new GridBagLayout( ) );
	        
	        GridBagConstraints gbc = new GridBagConstraints( );
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.insets = new Insets( 5, 5, 5, 5 );
	        gbc.fill = GridBagConstraints.BOTH;
	        
	        butCliente = new JButton(CLIENTE);
	        butCliente.setActionCommand(CLIENTE);
	        butCliente.addActionListener(this);
	        add(butCliente,gbc);
	        
	        gbc.gridy = 1;
	        
	        butEmpleado = new JButton(EMPLEADO);
	        butEmpleado.setActionCommand(EMPLEADO);
	        butEmpleado.addActionListener(this);
	        add(butEmpleado, gbc);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals(CLIENTE))
		{
			principal.mostrarVentanaRegistrarCliente();
			
			
		}
		
		else
		{
			principal.mostrarVentanaRegistrarEmpleado();
		}
		
	}
	
	
	
	
	
	
}
