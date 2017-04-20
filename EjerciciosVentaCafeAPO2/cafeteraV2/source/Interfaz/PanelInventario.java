package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Mundo.MiPropiaExepcion;

public class PanelInventario extends JPanel implements ActionListener {

	// ---------------------------------------------
	// constantes
	// ---------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = -1420243466798793016L;

	public final static String AZUCAR = "Azucar";

	public final static String PITILLOS = "Pitillos";

	public final static String AGUA = "Agua";

	public final static String VASOS = "Vasos";

	public final static String CAFE = "Cafe";

	public final static String CARGAR = "CARGAR";

	// ---------------------------------------------
	// Atributos
	// ---------------------------------------------

	private JLabel labCantidad;

	private JTextField txtCantidad;

	private JButton butCargar;

	private JCheckBox chkAzucar;

	private JCheckBox chkPitillos;

	private JCheckBox chkAgua;

	private JCheckBox chkVasos;

	private JCheckBox chkCafe;

	private InterfazMaquinaCafe principal;

	public PanelInventario(InterfazMaquinaCafe v) {

		principal = v;

		setBorder(new TitledBorder("Panel Inventario"));
		setLayout(new GridLayout(3, 3));

		chkAgua = new JCheckBox(AGUA);
		chkAgua.setBounds(10, 90, 150, 30);
		chkAgua.setActionCommand(AGUA);
		chkAgua.addActionListener(this);

		chkAzucar = new JCheckBox(AZUCAR);
		chkAzucar.setBounds(10, 90, 150, 30);
		chkAzucar.setActionCommand(AZUCAR);
		chkAzucar.addActionListener(this);

		chkCafe = new JCheckBox(CAFE);
		chkCafe.setBounds(10, 90, 150, 30);
		chkCafe.setActionCommand(CAFE);
		chkCafe.addActionListener(this);

		chkPitillos = new JCheckBox(PITILLOS);
		chkPitillos.setBounds(10, 90, 150, 30);
		chkPitillos.setActionCommand(PITILLOS);
		chkPitillos.addActionListener(this);

		chkVasos = new JCheckBox(VASOS);
		chkVasos.setBounds(10, 90, 150, 30);
		chkVasos.setActionCommand(VASOS);
		chkVasos.addActionListener(this);

		butCargar = new JButton(CARGAR);
		butCargar.setActionCommand(CARGAR);
		butCargar.addActionListener(this);

		labCantidad = new JLabel("Cantidad : ");
		txtCantidad = new JTextField("");

		add(chkAzucar);
		add(chkAgua);
		add(chkCafe);
		add(chkPitillos);
		add(chkVasos);

		JPanel panelAux = new JPanel();
		panelAux.setLayout(new GridLayout(2, 2));
		panelAux.add(new JLabel(""));
		panelAux.add(butCargar);
		add(panelAux);
		add(labCantidad);
		add(txtCantidad);
		add(new JLabel(""));

	}

	public double cantidad() throws MiPropiaExepcion {

		double cantidad = 0;
		try {
			cantidad = Double.parseDouble(txtCantidad.getText());
		} catch (NumberFormatException e) {
			throw new MiPropiaExepcion("Eso no es una cantidad");
		}
		if (cantidad > 0) {
			return cantidad;
		} else {
			throw new MiPropiaExepcion("Esa no es una cantidad valida");
		}
	}

	public String materiaPrima() throws MiPropiaExepcion {

		if (chkAgua.isSelected()) {
			return AGUA;
		} else if (chkAzucar.isSelected()) {
			return AZUCAR;
		} else if (chkCafe.isSelected()) {
			return CAFE;
		} else if (chkPitillos.isSelected()) {
			return PITILLOS;
		} else if (chkVasos.isSelected()) {
			return VASOS;
		} else {
			throw new MiPropiaExepcion("Por favor seleccione una materia prima");
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		String evento = arg0.getActionCommand();

		if (evento.equals(AGUA)) {

			chkPitillos.setSelected(false);
			chkCafe.setSelected(false);
			chkAzucar.setSelected(false);
			chkVasos.setSelected(false);

		} else if (evento.equals(AZUCAR)) {

			chkAgua.setSelected(false);
			chkCafe.setSelected(false);
			chkPitillos.setSelected(false);
			chkVasos.setSelected(false);

		} else if (evento.equals(CAFE)) {

			chkAgua.setSelected(false);
			chkAzucar.setSelected(false);
			chkPitillos.setSelected(false);
			chkVasos.setSelected(false);

		} else if (evento.equals(PITILLOS)) {

			chkAgua.setSelected(false);
			chkCafe.setSelected(false);
			chkAzucar.setSelected(false);
			chkVasos.setSelected(false);

		} else if (evento.equals(VASOS)) {

			chkAgua.setSelected(false);
			chkPitillos.setSelected(false);
			chkCafe.setSelected(false);
			chkAzucar.setSelected(false);

		} else if (evento.equals(CARGAR)) {
			principal.cargar();
			txtCantidad.setText("");
		}

	}

}
