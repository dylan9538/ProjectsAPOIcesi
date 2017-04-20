package Interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase de la interfaz Panel imagen.
 *
 * @author JorgeAndres. Created 22/01/2016.
 */
public class PanelImagen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -280631503322000606L;

	/**
	 * Constructor de la clase 'PanelImagen'.
	 *
	 */
	public PanelImagen() {
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("data/banner.jpg"));
		add(imagen);
	}
}
