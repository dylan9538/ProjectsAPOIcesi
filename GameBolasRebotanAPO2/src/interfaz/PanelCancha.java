package interfaz;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import mundo.Balon;
import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class PanelCancha extends JPanel implements MouseListener {
	
	private ArrayList<Balon> balones;
	private InterfazJuegoBalones principal;
	
	private JLabel lbNumRebotes;

	public PanelCancha(InterfazJuegoBalones ventana) {
		principal = ventana;
		balones = new ArrayList<>();
		addMouseListener(this);
		lbNumRebotes = new JLabel("Rebotes:");
		
		add(lbNumRebotes);
	}

	public void cambiarBalones(ArrayList<Balon> bs) {
		balones = bs;
	}
	//FAlTA
	public void paintComponent(Graphics grafico){
		
		Graphics2D g= (Graphics2D)grafico;
		super.paintComponent(g);
		
			for (int i = 0; i < balones.size(); i++) {
			Balon balon = balones.get(i);
	
			g.fillOval(balon.darPosX(), balon.darPosY(), balon.darDiametro(), balon.darDiametro());
			g.setColor(balon.darColor());
			
		
	}				
}
	
	public  void actualizarRebotes (){
		int rebotes =0;
		
		if(principal.darTotalRebotes()>=0){
		rebotes = principal.darTotalRebotes();
		lbNumRebotes.setText("Rebotes:" + rebotes);
	}

	}

	@Override
	public void mouseClicked(MouseEvent evento) {

		int xClick = evento.getX();
		int yClick = evento.getY();		
		principal.atrapar(xClick, yClick);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	

}
