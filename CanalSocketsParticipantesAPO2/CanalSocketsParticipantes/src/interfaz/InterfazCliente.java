package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

import mundo.Participante;


public class InterfazCliente extends JFrame implements ActionListener {

	public final static String LIMPIAR = "Limpiar";
	public final static String REGISTRAR = "registrar";
	public final static String LISTADO = "Generar Listado Codigos";

	private JButton but1, but2,but3;
	private JLabel lab1,lab2,lab3;
	private JTextField txt1;
	
	
	private JPanel panel1;
	
	private Participante participante;
	private static DataOutputStream escritor;
	private static DataInputStream lector ;
	private Socket cliente;

	public InterfazCliente() throws UnknownHostException, IOException {

		cliente = new Socket("localhost", 6666);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cliente");
		setResizable(false);
		setSize(440, 180);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());

		gbc.gridx = 1;
		gbc.gridy = 0;
		txt1 = new JTextField();
		txt1.setPreferredSize(new Dimension(180, 20));
		panel1.add(txt1, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		lab1 = new JLabel("   Nombre del participante:");
		lab1.setPreferredSize(new Dimension(200, 20));
		panel1.add(lab1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		lab2 = new JLabel("0");
		lab2.setPreferredSize(new Dimension(180, 20));
		panel1.add(lab2, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		lab3 = new JLabel("Total Participantes Registrados:");
		
		panel1.add(lab3,gbc);

		but1 = new JButton("Registrar");
		but1.setActionCommand(REGISTRAR);
		but1.setPreferredSize(new Dimension(180, 20));
		but1.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel1.add(but1, gbc);

		but2 = new JButton("Limpiar");
		but2.setActionCommand(LIMPIAR);
		but2.setPreferredSize(new Dimension(180, 20));
		but2.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel1.add(but2, gbc);

		but3 = new JButton("Generar Listado Codigos");
		but3.setActionCommand(LISTADO);
		but3.setPreferredSize(new Dimension(200, 20));
		but3.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		panel1.add(but3, gbc);
		
		add(panel1);

	}

	public Socket getCliente() {
		return cliente;
	}

	public void setCliente(Socket cliente) {
		this.cliente = cliente;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public JTextField getTxt1() {
		return txt1;
	}

	public void setTxt1(JTextField txt1) {
		this.txt1 = txt1;
	}
	
	public JLabel getLab2() {
		return lab2;
	}

	public void setLab2(JLabel lab2) {
		this.lab2 = lab2;
	}

	public void actionPerformed(ActionEvent ev) {
		String comando = ev.getActionCommand();

		if (comando.equals(LIMPIAR)) {
			txt1.setText("");
		} else if (comando.equals(REGISTRAR)) {
			try {
				if (txt1.getText() != null && !txt1.getText().equals(""))
				{
					escritor.writeUTF(REGISTRAR);
					escritor.writeUTF(getTxt1().getText());
					String leyo = lector.readUTF();
					lab2.setText(leyo);
					txt1.setText("");
					JOptionPane.showMessageDialog(this,
							"El participante se registro exitosamente");
				}
			} catch (IOException e) {	
				e.printStackTrace();
			}
		}
		else if(comando.equals(LISTADO)){
		
				try {
					escritor.writeUTF(LISTADO);
					int num = Integer.parseInt(lector.readUTF());
					String lista = lector.readUTF();
					if(num!= 0)
						JOptionPane.showMessageDialog(this,lista,"Listado",1);
					else{
						JOptionPane.showMessageDialog(this,"No hay ningun participante registrado",
								"Advertencia",JOptionPane.WARNING_MESSAGE);
					}
					
				} catch (IOException e) {
				
					e.printStackTrace();
				}
				txt1.setText("");
			}
		}
		
	

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		InterfazCliente in = new InterfazCliente();
		in.setVisible(true);

		escritor = new DataOutputStream(in.getCliente().getOutputStream());
		lector = new DataInputStream(in.getCliente().getInputStream());
		

	}


}
