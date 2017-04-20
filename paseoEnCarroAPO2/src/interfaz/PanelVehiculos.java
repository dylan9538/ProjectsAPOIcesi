package interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PanelVehiculos extends JPanel implements ActionListener {
	private static final String AGREGAR = "Agregar", ASIGNAR = "Asignar";
	private static final String LIMPIAR = "Limpiar";

	private VentanaPaseo ventanaPaseo;

	private JComboBox comboBoxTipoVehiculo, comboBoxVehiculos,
			comboBoxAlojamientos;

	private JTextField txtPlaca;

	private DefaultComboBoxModel comboModelVehiculos, comboModelAlojamientos;

	/**
	 * Create the panel.
	 */
	public PanelVehiculos(VentanaPaseo ventanaPaseo) {
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
		panelNorte.add(new JLabel(new ImageIcon("./data/cars.png")));

		JPanel panelSur = new JPanel(new GridLayout(2, 1));
		JLabel lblInfoUno = new JLabel(
				"NOTA: cuando agregue correctamente un vehiculo");
		lblInfoUno.setForeground(Color.BLUE);
		lblInfoUno.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelSur.add(lblInfoUno);
		
		JLabel lblInfoDos = new JLabel(
				"debe aparecer en la caja de seleccion de la derecha");
		lblInfoDos.setForeground(Color.BLUE);
		lblInfoDos.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelSur.add(lblInfoDos);

		panelIzquierda.add(panelNorte, BorderLayout.NORTH);
		panelIzquierda.add(panelSur, BorderLayout.SOUTH);

		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(9, 2, 1, 1));
		
		panelIzquierda.add(panelCentro, BorderLayout.CENTER);

		for (int i = 0; i < 2; i++) {
			panelCentro.add(new JLabel(""));
		}

		JLabel lblPlaca = new JLabel("Placa");
		panelCentro.add(lblPlaca);

		txtPlaca = new JTextField();
		panelCentro.add(txtPlaca);
		txtPlaca.setColumns(10);

		JLabel lblTipoVehiculo = new JLabel("Tipo Vehiculo");
		panelCentro.add(lblTipoVehiculo);

		comboBoxTipoVehiculo = new JComboBox(
				this.ventanaPaseo.darTiposVehiculo());
		panelCentro.add(comboBoxTipoVehiculo);

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

		this.comboModelVehiculos = new DefaultComboBoxModel();
		this.comboModelAlojamientos = new DefaultComboBoxModel();
		this.comboBoxVehiculos = new JComboBox(this.comboModelVehiculos);
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

		panel.add(new JLabel("Seleccione el vehiculo"));
		panel.add(this.comboBoxVehiculos);
		panel.add(new JLabel("Seleccione el alojamiento"));
		panel.add(this.comboBoxAlojamientos);
		panel.add(new JLabel(""));
		panel.add(btnAsignar);

		for (int i = 0; i < 14; i++) {
			panel.add(new JLabel(""));
		}

		splitPane.setLeftComponent(panelIzquierda);
		splitPane.setRightComponent(panel);
		add(splitPane);
	}

	public void agregarAlojamiento(String identificador) {
		this.comboModelAlojamientos.addElement(identificador);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(AGREGAR)) {
			String placa = this.txtPlaca.getText();
			String tipoVehiculo = (String) this.comboBoxTipoVehiculo
					.getSelectedItem();
			try {
				this.ventanaPaseo.registrarVehiculo(placa, tipoVehiculo);
				this.comboModelVehiculos.addElement(placa);
				JOptionPane.showMessageDialog(this,
						"Se ha registrado correctamente el vehiculo",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception error) {
				JOptionPane.showMessageDialog(this, error.getMessage(),
						"Ocurrio un error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (event.getActionCommand().equals(ASIGNAR)) {
			String placaVehiculo = (String) this.comboBoxVehiculos
					.getSelectedItem();
			String identificadorAlojamiento = (String) this.comboBoxAlojamientos
					.getSelectedItem();

			if (this.ventanaPaseo.asignarAlojamientoVehiculo(
					identificadorAlojamiento, placaVehiculo)) {
				JOptionPane
						.showMessageDialog(
								this,
								"Se ha asignado correctamente el alojamiento al vehiculo",
								"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane
						.showMessageDialog(
								this,
								"No se ha asignado el alojamiento. El vehiculo ya contaba con alojamiento.",
								"Resultado", JOptionPane.ERROR_MESSAGE);
			}
		} else if (event.getActionCommand().equals(LIMPIAR)) {
			this.txtPlaca.setText("");
			this.comboBoxTipoVehiculo.setSelectedIndex(0);
		}
	}

}
