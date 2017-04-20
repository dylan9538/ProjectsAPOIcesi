package interfaz.cliente;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InterfazCliente extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private JPanel panel;
	public final static String REGISTRAR = "Registrar",LIMPIAR = "Limpiar",CONSULTAR = "Consultar";
	private Socket cliente;
	private int contador;
	private static DataOutputStream escritor;
	private static DataInputStream lector;
	private JLabel nombre,conexion;
	private JButton butRegistrar,butLimpiar,butConsulta;
	private JTextField txtNombre;
	
	public InterfazCliente() throws IOException {

		cliente = new Socket("localhost",8888);
		contador = 0;
		
		
		//---Interfaz
		
		setSize(400, 250);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cliente");

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		nombre = new JLabel("Nombre");
		nombre.setPreferredSize(new Dimension(100,20));
		panel.add(nombre,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		txtNombre = new JTextField();
		txtNombre.setPreferredSize(new Dimension(100,20));
		panel.add(txtNombre,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		butRegistrar = new JButton("Registrar");
		butRegistrar.setPreferredSize(new Dimension(100,20));
		butRegistrar.setActionCommand(REGISTRAR);
		butRegistrar.addActionListener(this);
		panel.add(butRegistrar,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		butLimpiar = new JButton("Limpiar");
		butLimpiar.setPreferredSize(new Dimension(100,20));
		butLimpiar.setActionCommand(LIMPIAR);
		butLimpiar.addActionListener(this);
		panel.add(butLimpiar,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		butConsulta = new JButton("Consultar Listado");
		butConsulta.setPreferredSize(new Dimension(150,20));
		butConsulta.setActionCommand(CONSULTAR);
		butConsulta.addActionListener(this);
		panel.add(butConsulta,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		conexion = new JLabel("Conectados: "+contador);
		conexion.setPreferredSize(new Dimension(100,20));
		panel.add(conexion,gbc);
		
		add(panel);
		

	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals(LIMPIAR))
			txtNombre.setText("");
		else if(comando.equals(REGISTRAR)){
			String nombre = txtNombre.getText();
			try {
				if( nombre != null && !nombre.equals("")){
				escritor.writeUTF(REGISTRAR);
				escritor.writeUTF(txtNombre.getText());
				String leyo = lector.readUTF();
				txtNombre.setText("");
				System.out.println(leyo);
				String leyo2 = lector.readUTF();
				conexion.setText("Conectados: "+leyo2);
				}else{
					System.out.println("Error");
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if(comando.equals(CONSULTAR)){
			
			try{
				escritor.writeUTF(CONSULTAR);
				JOptionPane.showMessageDialog(this, lector.readUTF());
			}catch (IOException e2){
				e2.getStackTrace();
			}
		}
		
			

	}

	public static void main(String[] args) throws IOException {
		InterfazCliente in = new InterfazCliente();
		in.setVisible(true);
		
		escritor = new DataOutputStream(in.getCliente().getOutputStream());
		lector = new DataInputStream(in.getCliente().getInputStream());
		
	}

	public Socket getCliente() {
		return cliente;
	}

	public void setCliente(Socket cliente) {
		this.cliente = cliente;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
}
