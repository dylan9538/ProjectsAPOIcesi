package interfaz;

import java.awt.*;
import javax.swing.*;
import mundo.ExceptionNueva;
import mundo.Maquina;

public class InterfazVending extends JFrame {

	// ---ATRIBUTOS---//

	private Maquina maquina;

	private PanelBotones panelBotones;
	private PanelOpciones panelOpciones;
	private PanelImagen panelImagen;
	private PanelInformacion panelInformacion;
	private PanelArchivos panelArchivos;

	// ------CONSTRUCTOR------//

	/**
	 * Metodo constructor
	 */

	public InterfazVending(Maquina m) {

		maquina = m;

		setTitle("Vending");
		setSize(780, 513);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		panelBotones = new PanelBotones(this);
		add(panelBotones, BorderLayout.CENTER);

		panelOpciones = new PanelOpciones(this);
		add(panelOpciones, BorderLayout.WEST);

		panelImagen = new PanelImagen();
		add(panelImagen, BorderLayout.NORTH);

		panelInformacion = new PanelInformacion(this);
		add(panelInformacion, BorderLayout.SOUTH);

		panelArchivos = new PanelArchivos(this);

		add(panelArchivos, BorderLayout.EAST);
	}

	// PERSISTENCIA

	public void cargar(String ruta) {
		try {
			maquina.cargarInfoMaquina(ruta);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, JOptionPane.ERROR_MESSAGE);
		}
	}

	public void guardar(String ruta) {
		try {
			maquina.guardarInfoMaquina(ruta);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, JOptionPane.ERROR_MESSAGE);
		}
	}

	// SERIALIZACION
	// dispose para serialización
	public void dispose() {
		try {
			maquina.salvarInfo();
			super.dispose();
		} catch (Exception e) {
			setVisible(true);
			int respuesta = JOptionPane.showConfirmDialog(this, "Problemas salvando la información :\n" + e.getMessage()
					+ "\n¿Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				super.dispose();
			}
		}
	}

	// Numero de Ventas

	public int darDinero() {
		return maquina.darDineroRecibido();
	}

	public int darVentas15() {
		return maquina.darNumeroCafeVend15();
	}

	public int darVentas35() {
		return maquina.darNumeroCafeVend35();
	}

	// vender

	public void venderCafes() {
		int queCafe;
		if (maquina.getMateriaPrima().darPitillos() == 0 || maquina.getMateriaPrima().darAzucar() < 2) {
			int a = JOptionPane.showConfirmDialog(this,
					"No hay pitillos o no hay azucar ¿Quiere comprar de todas formas?", "", JOptionPane.YES_NO_OPTION);
			if (a == JOptionPane.YES_OPTION)
				try {
					queCafe = panelBotones.seleccionoBoton();
					maquina.venderCafes(queCafe);
					JOptionPane.showMessageDialog(this, "Gracias por su compra");
				} catch (ExceptionNueva e) {
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
			else if (a == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(this, "Okay");
			}
		} else {
			try {
				queCafe = panelBotones.seleccionoBoton();
				maquina.venderCafes(queCafe);
				JOptionPane.showMessageDialog(this, "Gracias por su compra");
			} catch (ExceptionNueva e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

	// actualizar
	public void actualizarAgua(int agu) {
		maquina.actualizaAgua(agu);
	}

	public void actualizarAzucar(int azu) {
		maquina.actualizaAzucar(azu);
	}

	public void actualizarCafe(int cafe) {
		maquina.actualizarCafe(cafe);
		;
	}

	public void actualizarVasos(int vasos) {
		maquina.actualizaVasos(vasos);
	}

	public void actualizarPitillos(int pitillos) {
		maquina.actualizarPitillos(pitillos);
	}

	// dar

	public int darAgua() {
		return maquina.getMateriaPrima().darAgua();
	}

	public int darAzucar() {
		return maquina.getMateriaPrima().darAzucar();
	}

	public int darPitillos() {
		return maquina.getMateriaPrima().darPitillos();
	}

	public int darVasos() {
		return maquina.getMateriaPrima().darVasos();
	}

	public int darCafe() {
		return maquina.getMateriaPrima().darCafe();
	}

	/**
	 * Metodo main
	 * 
	 * @param args
	 */
	// TODO Auto-generated method stub
	public static void main(String[] args) {
		Maquina m = null;
		try {
			m = new Maquina("./data/materiaprima");
		} catch (mundo.PersistenciaException e) {
			e.printStackTrace();
			System.exit(1);
		}
		InterfazVending ventana = new InterfazVending(m);
		ventana.setVisible(true);

	}

}
