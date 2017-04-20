package interfaz;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelDialogoCliente extends JPanel implements ActionListener{


	
	private final static String REGISTRAR = "Registrar";
	private final static String CANCELAR = "Cancelar";
	
	private DialogoCliente cliente;
	
	private JLabel labNombre, labApellido, labCedula, labDireccion,labTelefono,labCiudad,labPais,labCelular,labCorreo;
	
	private JTextField textNombre, textApellido,textCedula, textDirecc, textTele,textCiudad,textPais,textCel,textCorreo;

	private JButton butRegistrar,butCancelar;
	
	public PanelDialogoCliente(DialogoCliente c)
	{
		
		cliente = c;
		setLayout( new GridBagLayout( ) );
		
		GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.fill = GridBagConstraints.BOTH;
        
        labNombre = new JLabel("Nombre: ");
        add(labNombre,gbc);
        
        textNombre = new JTextField(2);
        gbc.gridx = 1;
        add(textNombre,gbc);
        
        textApellido = new JTextField(2);
        gbc.gridy = 1;
        add(textApellido,gbc);
        
        labApellido = new JLabel("Apellido: ");
        gbc.gridx = 0;
        add(labApellido,gbc);
        
        labCedula = new JLabel("Cedula: ");
        gbc.gridy = 2;
        add(labCedula,gbc);
        
        textCedula = new JTextField(2);
        gbc.gridx = 1;
        add(textCedula,gbc);
        
        textDirecc = new JTextField(2);
        gbc.gridy = 3;
        add(textDirecc,gbc);
        
        labDireccion = new JLabel("Direccion: ");
        gbc.gridx = 0;
        add(labDireccion,gbc);
        
        labTelefono = new JLabel("Telefono: ");
        gbc.gridy = 4;
        add(labTelefono,gbc);
        
        textTele = new JTextField();
        gbc.gridx = 1;
        add(textTele,gbc);
        
        textCiudad = new JTextField();
        gbc.gridy = 5;
        add(textCiudad, gbc);
        
        labCiudad = new JLabel("Ciudad: ");
        gbc.gridx = 0;
        add(labCiudad, gbc);
        
        labPais = new JLabel("Pais: ");
        gbc.gridy = 6;
        add(labPais,gbc);
        
        textPais = new JTextField();
        gbc.gridx = 1;
        add(textPais,gbc);
        
        textCel = new JTextField();
        gbc.gridy = 7;
        add(textCel,gbc);
        
        labCelular = new JLabel("Celular: ");
        gbc.gridx = 0;
        add(labCelular, gbc);
        
        labCorreo = new JLabel("Correo: ");
        gbc.gridy = 8;
        add(labCorreo, gbc);
        
        textCorreo = new JTextField();
        gbc.gridx = 1;
        add(textCorreo, gbc);
        
       butRegistrar = new JButton(REGISTRAR);
       butRegistrar.setActionCommand(REGISTRAR);
       butRegistrar.addActionListener(this);
       gbc.gridy = 9;
       gbc.gridx = 0;
       add(butRegistrar, gbc);
       
       butCancelar = new JButton(CANCELAR);
       butCancelar.setActionCommand(CANCELAR);
       butCancelar.addActionListener(this);
       gbc.gridx = 1;
       add(butCancelar, gbc);
       
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        String comando = e.getActionCommand();
		
		if(comando.equals(CANCELAR))
			cliente.dispose();
		
		else
		{
			cliente.registrarCliente(textNombre.getText(), textApellido.getText(), textCedula.getText(), textDirecc.getText(), 
					textTele.getText(), textCel.getText(), textCiudad.getText(), textPais.getText(), textCorreo.getText());
		}
	}
	
	
	
}
