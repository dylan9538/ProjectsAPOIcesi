package interfaz;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelDialogoEmpleado extends JPanel implements ActionListener {

	private final static String REGISTRAR = "Registrar";
	private final static String CANCELAR = "Cancelar";
	
	private DialogoEmpleado empleado;
	
	private JLabel labNombre, labApellido, labCedula, labDireccion,labTelefono,labCiudad,labPais,labCelular,labCorreo,labCuenta,labBanco,
	labContrato,labCargo;
	
	private JTextField textNombre, textApellido,textCedula, textDirecc, textTele,textCiudad,textPais,textCel,textCorreo,textCuenta,textBanco,
	textContrato,textCargo;

	private JButton butRegistrar,butCancelar;
	
	public PanelDialogoEmpleado(DialogoEmpleado e)
	{
		
		empleado = e;
		
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
        gbc.gridx = 3;
        add(textApellido,gbc);
        
        labApellido = new JLabel("Apellido: ");
        gbc.gridx = 2;
        add(labApellido,gbc);
        
        labCedula = new JLabel("Cedula: ");
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(labCedula,gbc);
        
        textCedula = new JTextField(2);
        gbc.gridx = 1;
        add(textCedula,gbc);
        
        textDirecc = new JTextField(2);
        gbc.gridx = 3;
        add(textDirecc,gbc);
        
        labDireccion = new JLabel("Direccion: ");
        gbc.gridx = 2;
        add(labDireccion,gbc);
        
        labTelefono = new JLabel("Telefono: ");
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(labTelefono,gbc);
        
        textTele = new JTextField();
        gbc.gridx = 1;
        add(textTele,gbc);
        
        textCiudad = new JTextField();
        gbc.gridx = 3;
        add(textCiudad, gbc);
        
        labCiudad = new JLabel("Ciudad: ");
        gbc.gridx = 2;
        add(labCiudad, gbc);
        
        labPais = new JLabel("Pais: ");
        gbc.gridy = 3;
        gbc.gridx = 0;
        add(labPais,gbc);
        
        textPais = new JTextField();
        gbc.gridx = 1;
        add(textPais,gbc);
        
        textCel = new JTextField();
        gbc.gridx = 3;
        add(textCel,gbc);
        
        labCelular = new JLabel("Celular: ");
        gbc.gridx = 2;
        add(labCelular, gbc);
        
        labCorreo = new JLabel("Correo: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(labCorreo, gbc);
        
        textCorreo = new JTextField();
        gbc.gridx = 1;
        add(textCorreo, gbc);
        
        labCuenta = new JLabel("Cuenta: ");
        gbc.gridx = 2;
        add(labCuenta,gbc);
        
        textCuenta = new JTextField();
        gbc.gridx = 3;
        add(textCuenta,gbc);
        
        labBanco = new JLabel("Banco: ");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(labBanco,gbc);
        
        textBanco = new JTextField();
        gbc.gridx = 1;
        add(textBanco, gbc);
        
        labContrato = new JLabel("Tipo de contrato: ");
        gbc.gridx = 2;
        add(labContrato,gbc);
        
        textContrato = new JTextField();
        gbc.gridx = 3;
        add(textContrato,gbc);
        
        labCargo = new JLabel("Cargo: ");
        gbc.gridy = 6;
        gbc.gridx = 0;
        add(labCargo, gbc);
        
        textCargo = new JTextField();
        gbc.gridx = 1;
        add(textCargo,gbc);
        
       butRegistrar = new JButton(REGISTRAR);
       butRegistrar.setActionCommand(REGISTRAR);
       butRegistrar.addActionListener(this);
       gbc.gridy = 7;
       gbc.gridx = 1;
       add(butRegistrar, gbc);
       
       butCancelar = new JButton(CANCELAR);
       butCancelar.setActionCommand(CANCELAR);
       butCancelar.addActionListener(this);
       gbc.gridx = 3;
       add(butCancelar, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		// TODO Auto-generated method stub
		if(comando.equals(CANCELAR))
			empleado.dispose();
	else{
			empleado.registrarEmpleado(textNombre.getText(), textApellido.getText(), textCedula.getText(), textDirecc.getText(), 
					textTele.getText(), textCel.getText(), textCiudad.getText(), textPais.getText(), textCorreo.getText(),textCuenta.getText(),
					     textContrato.getText(), textCargo.getText());
		}
	}
	
	
}
