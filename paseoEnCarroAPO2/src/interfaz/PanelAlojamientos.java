package interfaz;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PanelAlojamientos extends JPanel implements ActionListener {

	private static final String AGREGAR = "Agregar", ASIGNAR = "Asignar";
	private static final String LIMPIAR = "Limpiar";

	private VentanaPaseo ventanaPaseo;

	private JTextField txtIdentificador;

	private JComboBox comboBoxEstudiantes, comboBoxAlojamientos;

	private DefaultComboBoxModel comboModelEstudiantes, comboModelAlojamientos;

	/**
	 * Create the panel.
	 */
	public PanelAlojamientos(VentanaPaseo ventanaPaseo) {
		this.ventanaPaseo = ventanaPaseo;

		setBackground(Color.WHITE);
		setSize(800, 400);
		setLayout(new GridLayout(1, 2, 0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(Color.WHITE);
		splitPane.setDividerLocation(400);

		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setBorder(BorderFactory
				.createTitledBorder("Ingresar vehiculo: "));
		panelIzquierda.setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel(new GridLayout(1, 2));
		panelNorte.add(new JLabel(new ImageIcon("./data/add.png")));
		panelNorte.add(new JLabel(new ImageIcon("./data/accommodations.png")));

		JPanel panelSur = new JPanel(new GridLayout(2, 1));
		JLabel lblInfoUno = new JLabel(
				"NOTA: cuando agregue correctamente un alojamiento");
		lblInfoUno.setForeground(Color.GREEN);
		lblInfoUno.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelSur.add(lblInfoUno);
		
		JLabel lblInfoDos = new JLabel(
				"debe aparecer en la caja de seleccion de la derecha");
		lblInfoDos.setForeground(Color.GREEN);
		lblInfoDos.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelSur.add(lblInfoDos);

		panelIzquierda.add(panelNorte, BorderLayout.NORTH);
		panelIzquierda.add(panelSur, BorderLayout.SOUTH);

		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(8, 2, 5, 5));
		
		panelIzquierda.add(panelCentro, BorderLayout.CENTER);

		for (int i = 0; i < 4; i++) {
			panelCentro.add(new JLabel(""));
		}

		JLabel lblIdentificador = new JLabel("Identificador");
		panelCentro.add(lblIdentificador);

		txtIdentificador = new JTextField();
		panelCentro.add(txtIdentificador);
		txtIdentificador.setColumns(10);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setActionCommand(LIMPIAR);
		panelCentro.add(btnLimpiar);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setActionCommand(AGREGAR);
		btnAgregar.addActionListener(this);
		panelCentro.add(btnAgregar);
		
		for (int i = 0; i < 8; i++) {
			panelCentro.add(new JLabel(""));
		}
		

		this.comboModelEstudiantes = new DefaultComboBoxModel();
		this.comboModelAlojamientos = new DefaultComboBoxModel();
		this.comboBoxEstudiantes = new JComboBox(this.comboModelEstudiantes);
		this.comboBoxAlojamientos = new JComboBox(this.comboModelAlojamientos);

		JButton btnAsignar = new JButton(ASIGNAR);
		btnAsignar.setActionCommand(ASIGNAR);
		btnAsignar.addActionListener(this);

		JPanel panel = new JPanel(new GridLayout(11, 2, 10, 10));
		panel.setBorder(BorderFactory
				.createTitledBorder("Asignacion de alojamientos: "));

		for (int i = 0; i < 2; i++) {
			panel.add(new JLabel(""));
		}
		
		panel.add(new JLabel("Seleccione el alojamiento"));
		panel.add(this.comboBoxAlojamientos);
		panel.add(new JLabel("Seleccione el estudiante"));
		panel.add(this.comboBoxEstudiantes);
		panel.add(new JLabel(""));
		panel.add(btnAsignar);
		
		for (int i = 0; i < 14; i++) {
			panel.add(new JLabel(""));
		}

		splitPane.setLeftComponent(panelIzquierda);
		splitPane.setRightComponent(panel);
		add(splitPane);

	}

	public void agregarEstudiante(String tipoIdentificacion,
			String numeroIdentificacion) {
		this.comboModelEstudiantes.addElement(tipoIdentificacion + ":"
				+ numeroIdentificacion);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(AGREGAR)) {

			String identificador = this.txtIdentificador.getText();

			try {
				this.ventanaPaseo.registrarAlojamiento(identificador);
				this.comboModelAlojamientos.addElement(identificador);
				this.ventanaPaseo
						.agregarAlojamientoPanelVehiculos(identificador);
				JOptionPane.showMessageDialog(this,
						"Se ha registrado correctamente el alojamiento",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception error) {
				JOptionPane.showMessageDialog(this, error.getMessage(),
						"Ocurrio un error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (event.getActionCommand().equals(ASIGNAR)) {
			String seleccion = (String) this.comboBoxEstudiantes
					.getSelectedItem();

			String seleccionAlojamiento = (String) this.comboBoxAlojamientos
					.getSelectedItem();
			if (seleccionAlojamiento != null) {
				if (seleccion != null) {

					String[] identificacion = seleccion.split(":");

					String tipoIdentificacion = identificacion[0];
					String numeroIdentificacion = identificacion[1];

					String identificadorAlojamiento = (String) this.comboBoxAlojamientos
							.getSelectedItem();

					try {
						if (this.ventanaPaseo.alojarEstudiante(
								identificadorAlojamiento, tipoIdentificacion,
								numeroIdentificacion)) {
							JOptionPane
									.showMessageDialog(
											this,
											"Se ha alojado correctamente al estudiante",
											"Resultado",
											JOptionPane.INFORMATION_MESSAGE);
							this.comboModelEstudiantes.removeElement(seleccion);
						} else {
							JOptionPane
									.showMessageDialog(
											this,
											"No se pudo alojar al estudiante. Revise los datos",
											"Ocurrio un error",
											JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception error) {
						JOptionPane.showMessageDialog(this, error.getMessage(),
								"Ocurrio un error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this,
							"Debe escoger un estudiante",
							"Ocurrio un error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(this,
						"Debe escoger un alojamiento",
						"Ocurrio un error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(event.getActionCommand().equals(LIMPIAR)){
			this.txtIdentificador.setText("");
		}
	}

}
