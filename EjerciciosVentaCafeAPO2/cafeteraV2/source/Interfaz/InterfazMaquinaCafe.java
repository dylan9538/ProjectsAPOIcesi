package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Mundo.Maquina;
import Mundo.MiPropiaExepcion;
import Mundo.VenderExepcion;
import Mundo.VentaOpcionalExepcion;

public class InterfazMaquinaCafe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9032432001858869434L;

	private Maquina maquina;

	private PanelImagen panelImagen;

	private PanelVentas panelVentas;

	private PanelInformativo panelInformativo;

	private PanelInventario panelInventario;

	public InterfazMaquinaCafe() {

		setTitle("Maquina de cafe - Icesi");
		setLayout(new BorderLayout());
		setResizable(true);
		setSize(600, 330);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		maquina = new Maquina();

		panelImagen = new PanelImagen();
		add(panelImagen, BorderLayout.NORTH);

		panelVentas = new PanelVentas(this);
		add(panelVentas, BorderLayout.WEST);

		panelInventario = new PanelInventario(this);
		add(panelInventario, BorderLayout.CENTER);

		panelInformativo = new PanelInformativo(this);
		add(panelInformativo, BorderLayout.EAST);

	}

	public void comprarCafe() {

		int cantidad = 0;

		try {
			cantidad = panelVentas.cantidadCafe();
			maquina.venderCafe(cantidad);
		} catch (MiPropiaExepcion e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (VenderExepcion e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (VentaOpcionalExepcion e) {
			if (JOptionPane.showConfirmDialog(null, e.getMessage()) == JOptionPane.YES_OPTION) {
				maquina.venderCafeOpcional(cantidad);
			}
		}

	}

	public void cargar() {

		try {

			double cantidad = panelInventario.cantidad();
			String materia = panelInventario.materiaPrima();

			maquina.recargarMateriaPrima(materia, cantidad);

		} catch (MiPropiaExepcion e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public void infoInventario() {
		JOptionPane.showMessageDialog(null, maquina.informacionInventario());

	}

	public void infoVentas() {
		JOptionPane.showMessageDialog(null, maquina.informacionVentas());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InterfazMaquinaCafe interfaz = new InterfazMaquinaCafe();
		interfaz.setVisible(true);

	}

}
