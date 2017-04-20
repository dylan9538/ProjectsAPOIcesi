package interfaz;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelDialogoAccesorio extends JPanel implements ActionListener {

	private final static String REGISTRAR = "Registrar";
	private final static String CANCELAR = "Cancelar";
	
	private DialogoAccesorio accesorio;
	
	private JLabel labCodigo,labNombre,labDescripcion,labRestricciones,labCosto;
	
	private JTextField textCodigo,textNombre,textDescripcion,textRestricciones,textCosto;
	
	private JButton butRegistrar, butCancelar;
	
	
	public PanelDialogoAccesorio(DialogoAccesorio e)
	{
		setLayout( new GridBagLayout( ) );
		accesorio = e;
		
		GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.fill = GridBagConstraints.BOTH;
        
        labCodigo = new JLabel("Codigo: ");
        add(labCodigo,gbc);
        
        textCodigo = new JTextField();
        gbc.gridx = 1;
        add(textCodigo,gbc);
        
        textNombre = new JTextField();
        gbc.gridy = 1;
        add(textNombre, gbc);
        
        labNombre = new JLabel("Nombre: ");
        gbc.gridx = 0;
        add(labNombre,gbc);
        
        labDescripcion = new JLabel("Descripcion: ");
        gbc.gridy = 2;
        add(labDescripcion, gbc);
        
        textDescripcion = new JTextField();
        gbc.gridx = 1;
        add(textDescripcion, gbc);
        
        textRestricciones = new JTextField();
        gbc.gridy = 3;
        add(textRestricciones, gbc);
        
        labRestricciones = new JLabel("Restricciones: ");
        gbc.gridx = 0;
        add(labRestricciones, gbc);
        
        labCosto = new JLabel("Costo: ");
        gbc.gridy = 4;
        add(labCosto, gbc);
        
        textCosto = new JTextField();
        gbc.gridx = 1;
        add(textCosto,gbc);
        
        butRegistrar = new JButton(REGISTRAR);
        butRegistrar.setActionCommand(REGISTRAR);
        butRegistrar.addActionListener(this);
        gbc.gridy = 5;
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
			accesorio.dispose();
		else
		{
			accesorio.registrarAccesorio(textNombre.getText(),textDescripcion.getText(), textCodigo.getText(),textRestricciones.getText() , textCosto.getText());
		}
	}

	
	
	
}
