package interfaz;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelCarroTradicional extends JPanel implements ActionListener {

	private final static String PEDIR = "Pedir";
	private final static String CANCELAR = " Cancelar ";
	
	
	private DialogoCarroTradicional carro;
	
	private JButton butPedir,butCancelar;
	
	private JLabel labCombustion,labCilindraje,labTraccion,labTransmision,labColor,labTapiceria,labAire;
	private JComboBox<String> combCombustion,combTraccion,combTransmision,combAire;
	private JTextField textCilindraje, textColor,textTapiceria;
	
	public PanelCarroTradicional(DialogoCarroTradicional e)
	{
		carro = e;
		setLayout( new GridBagLayout( ) );
		
		GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.fill = GridBagConstraints.BOTH;
        
        labCombustion = new JLabel("Tipo de Combustión: ");
        add(labCombustion,gbc);
        
        combCombustion = new JComboBox<>();
        combCombustion.addItem("Gasolina");
        combCombustion.addItem("Diesel");
        gbc.gridx = 1;
        add(combCombustion,gbc);
        
        textCilindraje = new JTextField();
        gbc.gridy = 1;
        add(textCilindraje,gbc);
        
        labCilindraje = new JLabel("Cilindraje: ");
        gbc.gridx = 0;
        add(labCilindraje,gbc);
        
        labTraccion = new JLabel("Tipo de Tracción: ");
        gbc.gridy = 2;
        add(labTraccion,gbc);
        
        combTraccion = new JComboBox<>();
        combTraccion.addItem("4x4");
        combTraccion.addItem("2x4");
        gbc.gridx = 1;
        add(combTraccion,gbc);
        
        combTransmision = new JComboBox<>();
        combTransmision.addItem("Automática");
        combTransmision.addItem("Manual");
        gbc.gridy = 3;
        add(combTransmision,gbc);
        
        labTransmision = new JLabel("Transmisión: ");
        gbc.gridx = 0;
        add(labTransmision,gbc);
        
        labColor = new JLabel("Color: ");
        gbc.gridy = 4;
        add(labColor,gbc);
        
        textColor = new JTextField();
        gbc.gridx = 1;
        add(textColor,gbc);
        
        textTapiceria = new JTextField();
        gbc.gridy = 5;
        add(textTapiceria, gbc);
        
        labTapiceria = new JLabel("Tipo de tapicería: ");
        gbc.gridx = 0;
        add(labTapiceria,gbc);
        
        labAire = new JLabel("Tiene Aire acondicionado? ");
        gbc.gridy = 6;
        add(labAire,gbc);
        
        combAire = new JComboBox<>();
        combAire.addItem("Sí");
        combAire.addItem("No");
        gbc.gridx = 1;
        add(combAire,gbc);
        
        butCancelar = new JButton(CANCELAR);
		butCancelar.setActionCommand(CANCELAR);
		butCancelar.addActionListener(this);
		gbc.gridy = 7;
		add(butCancelar, gbc);
		
		butPedir = new JButton(PEDIR);
		butPedir.setActionCommand(PEDIR);
		butPedir.addActionListener(this);
		gbc.gridx = 0;
		add(butPedir,gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(comando.equals(CANCELAR))
			carro.dispose();
		
		else
		{
			
			boolean aire = false;
			if(combAire.getSelectedItem().equals("Sí"))
			{
				aire = true;
			}
			
			carro.generarPedido((String)combCombustion.getSelectedItem(),(String) combTraccion.getSelectedItem(), textColor.getText(), 
				(String)combTransmision.getSelectedItem(), textTapiceria.getText(), aire, textCilindraje.getText());
		}
			
	}
	
	
	
	
	
	
	
	
}
