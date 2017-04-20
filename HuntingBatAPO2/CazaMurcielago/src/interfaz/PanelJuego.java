package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import mundo.HunttheBat;
import mundo.Murcielago;

public class PanelJuego extends JPanel implements MouseListener {

	private InterfazJuego pricipal;


	public PanelJuego(InterfazJuego v) {
		pricipal = v;
		addMouseListener(this);

	}

	public void paintComponent(Graphics dibujo) {

		super.paintComponent(dibujo);

		if (pricipal.darQueEs().equalsIgnoreCase(HunttheBat.MURCIELAGO_NEGRO)) {

			Toolkit ambiente = Toolkit.getDefaultToolkit();
			Image img = ambiente.getImage("./data/bat.png");

			int posicio =pricipal.darPosicionX();
			int poso = pricipal.darPosicionY();

			dibujo.drawImage(img, posicio, poso, 90, 90, this);

		} else {

			Toolkit ambiente = Toolkit.getDefaultToolkit();
			Image imge = ambiente.getImage("./data/batcolor.png");
			int posicio = pricipal.darPosicionX();
			int poso = pricipal.darPosicionY();

			dibujo.drawImage(imge, posicio, poso, 90, 90, this);
		}
	}

	public void refrescar() {
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (e.getButton() == MouseEvent.BUTTON1) {

			if (pricipal.estaAdentro(x, y) == true) {

				pricipal.refrescarGanadados();
				pricipal.cambiarPosicionX();
		
			} else {

				pricipal.refrescarPerdidos();
				pricipal.cambiarPosicionX();
				
			}
		}
		pricipal.getJu().generarRandom();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseDraggued(MouseEvent e) {
		
	}
}
