package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Descripcion: este es el panel que permite hacer la gestion de estudiantes.
 * 
 * @author <a href="mailto:alejandro.hurtado@correo.icesi.edu.co">Alejandro
 *         Hurtado</a> Fecha de creacion: 10-02-2013
 */
public class PanelEstudiantes extends JPanel implements ActionListener {
	private static final String AGREGAR = "Agregar";
	private static final String LIMPIAR = "Limpiar";

	private VentanaPaseo ventanaPaseo;

	private JTextField txtApellidos;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtNumeroidentificacion;

	private JComboBox comboBox;

	private DefaultListModel listModel;

	/**
	 * Create the panel.
	 */
	public PanelEstudiantes(VentanaPaseo ventanaPaseo) {
		this.ventanaPaseo = ventanaPaseo;

		setBackground(Color.WHITE);
		setSize(800, 400);
		setLayout(new GridLayout(1, 2, 0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(Color.WHITE);
		splitPane.setDividerLocation(400);

		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setBorder(BorderFactory
				.createTitledBorder("Ingresar estudiante: "));
		panelIzquierda.setLayout(new BorderLayout());

		JPanel panelNorte = new JPanel(new GridLayout(1, 2));
		panelNorte.add(new JLabel(new ImageIcon("./data/add.png")));
		panelNorte.add(new JLabel(new ImageIcon("./data/users.png")));

		JPanel panelSur = new JPanel(new GridLayout(2, 1));
		JLabel lblInfoUno = new JLabel(
				"NOTA: cuando agregue correctamente un estudiante");
		lblInfoUno.setForeground(Color.RED);
		lblInfoUno.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelSur.add(lblInfoUno);
		
		JLabel lblInfoDos = new JLabel(
				"debe aparecer en la lista de la derecha");
		lblInfoDos.setForeground(Color.RED);
		lblInfoDos.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelSur.add(lblInfoDos);

		panelIzquierda.add(panelNorte, BorderLayout.NORTH);
		panelIzquierda.add(panelSur, BorderLayout.SOUTH);

		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(8, 2, 0, 0));

		for (int i = 0; i < 2; i++) {
		panelCentro.add(new JLabel(""));
		}

		JLabel lblNombre = new JLabel("Nombre");
		panelCentro.add(lblNombre);

		txtNombre = new JTextField();
		panelCentro.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos");
		panelCentro.add(lblApellidos);

		txtApellidos = new JTextField();
		panelCentro.add(txtApellidos);
		txtApellidos.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		panelCentro.add(lblEdad);

		txtEdad = new JTextField();
		panelCentro.add(txtEdad);
		txtEdad.setColumns(10);

		JLabel lblTipoidentificacion = new JLabel("Tipo Identificacion");
		panelCentro.add(lblTipoidentificacion);

		comboBox = new JComboBox(this.ventanaPaseo.darTiposDocumento());
		panelCentro.add(comboBox);

		JLabel lblNumeroidentificacion = new JLabel("Numero Identificacion");
		panelCentro.add(lblNumeroidentificacion);

		txtNumeroidentificacion = new JTextField();
		panelCentro.add(txtNumeroidentificacion);
		txtNumeroidentificacion.setColumns(10);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setActionCommand(LIMPIAR);
		panelCentro.add(btnLimpiar);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setActionCommand(AGREGAR);
		btnAgregar.addActionListener(this);
		panelCentro.add(btnAgregar);

		this.listModel = new DefaultListModel();
		JList list = new JList(this.listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setSize(350, 400);
		scrollPane.setBorder(BorderFactory
				.createTitledBorder("Lista de estudiantes en el sistema: "));

		panelIzquierda.add(panelCentro, BorderLayout.CENTER);

		splitPane.setLeftComponent(panelIzquierda);
		splitPane.setRightComponent(scrollPane);
		add(splitPane);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(AGREGAR)) {
			String numeroIdentificacion = this.txtNumeroidentificacion
					.getText();
			String tipoIdentificacion = (String) this.comboBox
					.getSelectedItem();
			String nombre = this.txtNombre.getText();
			String apellidos = this.txtApellidos.getText();
			String edad = this.txtEdad.getText();

			try {
				this.ventanaPaseo.registrarEstudiante(numeroIdentificacion,
						tipoIdentificacion, nombre, apellidos, edad);

				this.listModel.addElement("" + tipoIdentificacion + ": "
						+ numeroIdentificacion + " - " + nombre);
				this.ventanaPaseo.agregarEstudiantesPanelAlojamientos(
						tipoIdentificacion, numeroIdentificacion);
			} catch (Exception error) {
				JOptionPane.showMessageDialog(this, error.getMessage(),
						"Ocurrio un error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (event.getActionCommand().equals(LIMPIAR)) {
			this.txtNombre.setText("");
			this.txtApellidos.setText("");
			this.txtNumeroidentificacion.setText("");
			this.txtEdad.setText("");
			this.comboBox.setSelectedIndex(0);
		}

	}

}
