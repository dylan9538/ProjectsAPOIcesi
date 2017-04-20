package interfaz;
import java.awt.*;
import javax.swing.*;

public class PanelImagen extends JPanel {
	
	private JLabel pImagen;
	
	/**
	 * Metodo constructor de la clase PanelImagen
	 */
	
	public PanelImagen(){
		
		pImagen= new JLabel();
		ImageIcon imagen = new ImageIcon("./Data/logo.jpg");
		pImagen.setIcon(imagen);
		add(pImagen);
		
	}
	

}
