package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelInformativo extends JPanel implements ActionListener {

	// -------------------------------------------------
	// Constantes
	// -------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 8375080542828827125L;

	public final static String INFO_VENTAS = "VENTAS";

	public final static String INFO_INVENTARIO = "INVENTARIO";

	// --------------------------------------------------
	// Atributos
	// --------------------------------------------------

	private JButton butInfoVentas;

	private JButton butInfoInventario;

	private InterfazMaquinaCafe principal;

	public PanelInformativo(InterfazMaquinaCafe v) {

		principal = v;

		setBorder(new TitledBorder("Panel Registros"));
		setLayout(new GridLayout(2, 1));

		butInfoInventario = new JButton("Informacion del inventario");
		butInfoInventario.setActionCommand(INFO_INVENTARIO);
		butInfoInventario.addActionListener(this);

		butInfoVentas = new JButton("Informacion de Ventas");
		butInfoVentas.setActionCommand(INFO_VENTAS);
		butInfoVentas.addActionListener(this);

		add(butInfoInventario);
		add(butInfoVentas);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		String evento = arg0.getActionCommand();

		if (evento.equals(INFO_INVENTARIO)) {
			principal.infoInventario();
		} else if (evento.equals(INFO_VENTAS)) {
			principal.infoVentas();
		}

	}

}
