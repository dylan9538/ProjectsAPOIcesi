package interfaz;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.JobName;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PanelModulo3 extends JPanel implements ActionListener {

	public final static String VER_LISTA = "Ver lista Carros";
	public final static String PROMOVER = "Promover carro";
	public final static String VER_RESULTADOS = "Ver Resultados";
	public final static String GUARDAR_RESULTADOS = "Guardar Resultados";
	public final static String VER_VENDIDOS = "Ver Carros listos para vender";
	
	
	private InterfazMisCarritos principal;
	
	private JButton butEstaciones, butVerResultados, butGuardar,butVendidos;
	
	private JTextArea area;
	
	public PanelModulo3 (InterfazMisCarritos c)
	{
		principal = c;
		
		setBorder( new TitledBorder( "Seguimiento y Control de pedidos" ) );
		setLayout( new GridBagLayout( ) );

        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.fill = GridBagConstraints.BOTH;
        
        
        butEstaciones = new JButton(VER_LISTA);
        butEstaciones.setActionCommand(VER_LISTA);
        butEstaciones.addActionListener(this);
        add(butEstaciones,gbc);
        
        butEstaciones = new JButton(PROMOVER);
        butEstaciones.setActionCommand(PROMOVER);
        butEstaciones.addActionListener(this);
        gbc.gridy = 1;
        add(butEstaciones,gbc);
        
       
        butVerResultados = new JButton(VER_RESULTADOS);
        butVerResultados.setActionCommand(VER_RESULTADOS);
        butVerResultados.addActionListener(this);
        gbc.gridy = 2;
        add(butVerResultados,gbc);
        
        butGuardar = new JButton(GUARDAR_RESULTADOS);
        butGuardar.setActionCommand(GUARDAR_RESULTADOS);
        butGuardar.addActionListener(this);
        gbc.gridy = 3;
        add(butGuardar, gbc);
        
        butVendidos = new JButton(VER_VENDIDOS);
        butVendidos.setActionCommand(VER_VENDIDOS);
        butVendidos.addActionListener(this);
        gbc.gridy = 4;
        add(butVendidos, gbc);
        
        area= new JTextArea();
        area.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setPreferredSize(new Dimension(410, 150));
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        add(scrollPane, gbc);
        
	}

	public void refrescarArea(String lista)
	{
		area.setText(lista);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals(VER_LISTA)){
			principal.verListaCarros();
		}
		
		else if(comando.equals(PROMOVER)){
			principal.promover();
		}
		
		else if(comando.equals(VER_VENDIDOS)){
			principal.verListaCarrosListosVender();
		}
		
		else if(comando.equals(VER_RESULTADOS)){
			principal.verResultados();
		}
	}
}
