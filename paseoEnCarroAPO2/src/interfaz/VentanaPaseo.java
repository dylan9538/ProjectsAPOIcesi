package interfaz;

import java.awt.*;

import javax.swing.*;

import mundo.*;

/**
 * Descripcion: esta es la ventana que permite al usuario interactuar con la
 * aplicacion.
 * 
 * @author <a href="mailto:alejandro.hurtado@correo.icesi.edu.co">Alejandro
 *         Hurtado</a> Fecha de creacion: 10-02-2013
 */
public class VentanaPaseo extends JFrame {

	private Paseo paseo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPaseo window = new VentanaPaseo();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private PanelEstudiantes panelEstudiantes;

	private PanelVehiculos panelVehiculos;

	private PanelAlojamientos panelAlojamientos;
	
	private PanelBotones panelBotones;

	/**
	 * Create the application.
	 */
	public VentanaPaseo() {
		this.paseo = new Paseo();

		this.panelEstudiantes = new PanelEstudiantes(this);
		this.panelVehiculos = new PanelVehiculos(this);
		this.panelAlojamientos = new PanelAlojamientos(this);
		this.panelBotones = new PanelBotones(this);

		JPanel contentPane = new JPanel();

		this.setBounds(100, 100, 800, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new BorderLayout());

		// Panel superior
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.WHITE);
		contentPane.add(panelSuperior);
		panelSuperior.setLayout(new BorderLayout(0, 0));

		JLabel lblIcesi = new JLabel("");
		lblIcesi.setIcon(new ImageIcon("./data/icesi.png"));
		panelSuperior.add(lblIcesi, BorderLayout.WEST);

		JLabel lblCupiDos = new JLabel("");
		lblCupiDos.setIcon(new ImageIcon("./data/cupidos.png"));
		panelSuperior.add(lblCupiDos, BorderLayout.EAST);

		JLabel lblElCupiViajero = new JLabel("EL PASEO");
		lblElCupiViajero.setHorizontalAlignment(SwingConstants.CENTER);
		lblElCupiViajero.setFont(new Font("Lithos Pro", Font.PLAIN, 26));
		panelSuperior.add(lblElCupiViajero, BorderLayout.CENTER);

		contentPane.add(panelSuperior, BorderLayout.NORTH);
		// Fin Panel superior
		
		contentPane.add(this.panelBotones, BorderLayout.SOUTH);

		// Panel central
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Gestion Estudiantes", new ImageIcon(
				"./data/estudiante.png"), this.panelEstudiantes);
		tabbedPane.addTab("Gestion Vehiculos", new ImageIcon(
				"./data/vehiculo.png"), this.panelVehiculos);
		tabbedPane.addTab("Gestion Alojamientos", new ImageIcon(
				"./data/alojamiento.png"), this.panelAlojamientos);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		// Fin panel central

		this.setContentPane(contentPane);
	}

	public String[] darTiposDocumento() {
		return new String[] { Estudiante.TIPO_IDENTIFICACION_CC,
				Estudiante.TIPO_IDENTIFICACION_TI };
	}

	public String[] darTiposVehiculo() {
		return new String[] { Vehiculo.TIPO_VEHICULO_ECONOMICO,
				Vehiculo.TIPO_VEHICULO_MEDIO, Vehiculo.TIPO_VEHICULO_LUJO };
	}

	public void registrarEstudiante(String numeroIdentificacion,
			String tipoIdentificacion, String nombre, String apellidos,
			String edad) throws Exception {

		if (nombre.trim().equals("")) {
			throw new Exception("El campo nombre no puede quedar vacio");
		}
		if (apellidos.trim().equals("")) {
			throw new Exception("El campo apellidos no puede quedar vacio");
		}
		if (numeroIdentificacion.trim().equals("")) {
			throw new Exception(
					"El campo numero de identificacion no puede quedar vacio");
		}

		int iEdad = 0;
		try {
			iEdad = Integer.parseInt(edad);
		} catch (Exception error) {
			throw new Exception("La edad debe ser un numero entero");
		}
		paseo.registrarEstudiante(numeroIdentificacion, tipoIdentificacion,
				nombre, apellidos, iEdad);
	}

	public void registrarVehiculo(String placa, String tipoVehiculo)
			throws Exception {
		this.paseo.registrarVehiculo(placa, tipoVehiculo);
	}

	public void registrarAlojamiento(String identificador) throws Exception {
		if (identificador.trim().equals("")) {
			throw new Exception("El campo identificador no puede quedar vacio");
		}
		this.paseo.registrarAlojamiento(identificador);
	}

	public void agregarAlojamientoPanelVehiculos(String identificador) {
		this.panelVehiculos.agregarAlojamiento(identificador);
	}

	public void agregarEstudiantesPanelAlojamientos(String tipoIdentificacion,
			String numeroIdentificacion) {
		this.panelAlojamientos.agregarEstudiante(tipoIdentificacion,
				numeroIdentificacion);
	}

	public boolean asignarAlojamientoVehiculo(String identificadorAlojamiento,
			String placaVehiculo) {
		return this.paseo.asignarAlojamientoVehiculo(identificadorAlojamiento,
				placaVehiculo);
	}

	public boolean alojarEstudiante(String identificadorAlojamiento,
			String tipoIdentificacion, String numeroIdentificacion)
			throws Exception {
		return this.paseo.alojarEstudiante(identificadorAlojamiento,
				tipoIdentificacion, numeroIdentificacion);
	}

	public double calcularCostoTotal() {
		return this.paseo.calcularCostoTotalAlojamiento()
				+ this.paseo.calcularCostoTotalGasolina();
	}
	
	public double calcularCostoGasolina(){
		return this.paseo.calcularCostoTotalGasolina();
	}
	
	public String generarReporteEstudiantesAlojados(){
		return this.paseo.generarReporteEstudiantesAlojados();
	}

}
