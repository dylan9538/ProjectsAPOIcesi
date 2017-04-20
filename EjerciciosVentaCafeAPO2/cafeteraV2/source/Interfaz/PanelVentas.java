package Interfaz;

import java.awt.Color;
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

@SuppressWarnings("serial")
public class PanelVentas extends JPanel implements ActionListener {

	// -------------------------------------------------
	// Constantes
	// -------------------------------------------------

	public final static String COMPRAR = "COMPRAR";

	public final static String CAFE15 = "$ 1000";

	public final static String CAFE35 = "$ 1200";

	// -------------------------------------------------
	// Atributos
	// -------------------------------------------------

	private JLabel labPrecio;

	private JTextField txtPrecio;

	private JCheckBox chkCafe15;

	private JCheckBox chkCafe35;

	private JButton butComprar;

	private InterfazMaquinaCafe principal;

	public PanelVentas(InterfazMaquinaCafe v) {

		principal = v;

		setLayout(new GridLayout(3, 1));
		setBorder(new TitledBorder("Panel Ventas"));

		JPanel panelAux1 = new JPanel();
		panelAux1.setLayout(new GridLayout(1, 2));

		JPanel panelAux2 = new JPanel();
		panelAux2.setLayout(new GridLayout(1, 2));

		JPanel panelAux3 = new JPanel();
		panelAux1.setLayout(new GridLayout(1, 3));

		labPrecio = new JLabel("Precio :");

		txtPrecio = new JTextField("$ 0");
		txtPrecio.setEnabled(false);
		txtPrecio.setBackground(Color.GRAY);

		butComprar = new JButton("Comprar");
		butComprar.setActionCommand(COMPRAR);
		butComprar.addActionListener(this);

		chkCafe15 = new JCheckBox("15gr");
		chkCafe15.setBounds(10, 90, 150, 30);
		chkCafe15.setActionCommand(CAFE15);
		chkCafe15.addActionListener(this);

		chkCafe35 = new JCheckBox("35gr");
		chkCafe35.setBounds(10, 90, 150, 30);
		chkCafe35.setActionCommand(CAFE35);
		chkCafe35.addActionListener(this);

		panelAux1.add(labPrecio);
		panelAux1.add(txtPrecio);
		add(panelAux1);

		panelAux2.add(chkCafe15);
		panelAux2.add(chkCafe35);
		add(panelAux2);

		panelAux3.add(new JLabel(""));
		panelAux3.add(butComprar);
		panelAux3.add(new JLabel(""));
		add(panelAux3);

	}

	public int cantidadCafe() throws MiPropiaExepcion {

		if (chkCafe15.isSelected()) {
			return 15;
		} else if (chkCafe35.isSelected()) {
			return 35;
		} else {
			throw new MiPropiaExepcion("Por favor seleccione el cafe que desea comprar");
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		String evento = arg0.getActionCommand();

		if (evento.equals(CAFE15)) {
			chkCafe35.setSelected(false);
			txtPrecio.setText(CAFE15);
		} else if (evento.equals(CAFE35)) {
			chkCafe15.setSelected(false);
			txtPrecio.setText(CAFE35);
		} else if (evento.equals(COMPRAR)) {
			principal.comprarCafe();
			txtPrecio.setText("$ 0");
			chkCafe35.setSelected(false);
			chkCafe15.setSelected(false);
		}

	}

}
