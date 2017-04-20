package interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mundo.Canon;

@SuppressWarnings("serial")
public class PanelFormulario extends JPanel implements ActionListener{
	
	public final static String DISPARAR = "DISPARAR";
	
	private InterfazCanon principal;
	private JLabel lblVelocidad;
	private JLabel lblAngulo;
	private JTextField txtFldVelocidad;
	private JTextField txtFldAngulo;
	private JButton btnDisparar;
	
	public PanelFormulario(InterfazCanon ventana){
		principal = ventana;

		setLayout(new BorderLayout());
		
		JPanel panelInterno = new JPanel();
		panelInterno.setLayout(new GridBagLayout());
		panelInterno.setBorder(new TitledBorder("Configuración del Disparo"));
		
		lblVelocidad         = new JLabel("Velocidad Inicial: ");
		lblAngulo     		 = new JLabel("Ángulo Inicial: ");
		txtFldVelocidad      = new JTextField(Canon.VELOCIDAD_INICIAL_DEFECTO+"");
		txtFldAngulo 		 = new JTextField(Canon.ANGULO_INICIAL_DEFECTO+"");
		btnDisparar       	 = new JButton("Disparar");
		
		btnDisparar.setActionCommand(DISPARAR);
		btnDisparar.addActionListener(this);
		
		txtFldVelocidad.setToolTipText("Define la velocidad del disparo");
		txtFldAngulo.setToolTipText("Define la ángulo del cañon con respecto a la horizontal para el disparo");
		txtFldVelocidad.setColumns(5);
		txtFldAngulo.setColumns(5);

		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		panelInterno.add(lblVelocidad,c);
		
		c.gridx = 1;
		c.gridy = 0;
		panelInterno.add(txtFldVelocidad,c);
		
		c.gridx = 0;
		c.gridy = 1;
		panelInterno.add(lblAngulo,c);
		
		c.gridx = 1;
		c.gridy = 1;
		panelInterno.add(txtFldAngulo,c);
		
		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = 2;
		panelInterno.add(btnDisparar,c);
		
		add(panelInterno, BorderLayout.WEST);
		add(new JLabel(), BorderLayout.CENTER);
	}
	
	public String getAngulo(){
		return txtFldAngulo.getText();
	}
	
	public String getVelocidad(){
		return txtFldVelocidad.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(DISPARAR)){
			principal.lanzarBala();
		}
	}

}
