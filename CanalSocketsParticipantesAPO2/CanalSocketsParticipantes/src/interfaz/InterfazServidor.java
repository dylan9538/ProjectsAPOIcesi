package interfaz;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

import mundo.Participante;
import mundo.Servidor;

public class InterfazServidor extends JFrame implements ActionListener {

	public final static String LISTADO = "Generar Listado Codigos",
			ELIMINAR = "Eliminar";

	private JButton but1, but2;
	private JLabel lab1, lab2;

	private JPanel panel1;
	private Servidor servidor;

	public InterfazServidor() throws IOException {

		servidor = new Servidor();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servidor");
		setResizable(false);
		setSize(400, 100);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 10, 5, 10);

		panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());

		gbc.gridx = 1;
		gbc.gridy = 0;
		lab1 = new JLabel("0");
		lab1.setPreferredSize(new Dimension(100, 20));
		panel1.add(lab1, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		lab2 = new JLabel("Total Participantes Registrados");
		panel1.add(lab2, gbc);

		but1 = new JButton("Generar Listado Codigos");
		but1.setActionCommand(LISTADO);
		but1.setPreferredSize(new Dimension(300, 50));
		but1.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel1.add(but1, gbc);

		but2 = new JButton("Eliminar Participante");
		but2.setActionCommand(ELIMINAR);
		but2.setPreferredSize(new Dimension(250, 50));
		but2.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel1.add(but2, gbc);

		add(panel1);

	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public JLabel getLab1() {
		return lab1;
	}

	public void setLab1(JLabel lab1) {
		this.lab1 = lab1;
	}

	public void actionPerformed(ActionEvent ev) {
		String comando = ev.getActionCommand();

		if (comando.equals(LISTADO)) {
			String listado = "";

			if (servidor.getParticipantes().size() != 0) {
				listado = servidor.getCodigo();
				JOptionPane.showMessageDialog(this, listado, "Listado", 1);
			} else {
				JOptionPane.showMessageDialog(this,
						"No hay participantes registrados", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		} else if (comando.equals(ELIMINAR)) {
			String nom = JOptionPane.showInputDialog(this,
					"Ingrese el nombre del participante a eliminar");
			try {
				if (nom.equalsIgnoreCase("removeall")) {

					servidor.getParticipantes().removeAll(
							servidor.getParticipantes());
					getLab1().setText("" + servidor.getParticipantes().size());
				} else {
					servidor.eliminarParticipante(nom);
					getLab1().setText("" + servidor.getParticipantes().size());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "" + e.getMessage());
			}
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		InterfazServidor in = null;
		try {
			in = new InterfazServidor();
		} catch (IOException e) {
			e.printStackTrace();
		}
		in.setVisible(true);
		try {
			in.getServidor().setCanal(in.getServidor().getServer().accept());
		} catch (IOException e) {
			e.printStackTrace();
		}

		DataInputStream lector = null;
		try {
			lector = new DataInputStream(in.getServidor().getCanal()
					.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		String orden = null;
		try {
			while (true) {

				orden = lector.readUTF();
				DataOutputStream escritor = new DataOutputStream(in
						.getServidor().getCanal().getOutputStream());
				if (orden.equals(InterfazCliente.REGISTRAR)) {
					String nombreParticipante = lector.readUTF();
					Participante participante = new Participante(
							nombreParticipante);
					in.getServidor().getParticipantes().add(participante);
					escritor.writeUTF(""
							+ in.getServidor().getParticipantes().size());

					in.getLab1().setText(
							"" + in.getServidor().getParticipantes().size());

				} else if (orden.equals(InterfazCliente.LISTADO)) {
					String lista = in.getServidor().getCodigo();
					escritor.writeUTF(""
							+ in.getServidor().getParticipantes().size());
					escritor.writeUTF(lista);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(orden);
	}
}
