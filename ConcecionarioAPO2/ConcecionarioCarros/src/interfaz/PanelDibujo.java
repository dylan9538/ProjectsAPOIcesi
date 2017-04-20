package interfaz;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class PanelDibujo extends JPanel implements MouseListener {
	
	InterfazMisCarritos principal;
	
	public final static int [][] COORDENADAS ={
		{150,70},
		{220,160},
		{330,140},
		{430,100}
	};
	
	private boolean [] pintar;
	
	public PanelDibujo(InterfazMisCarritos ars )
	{
		principal = ars;
		
		pintar = new boolean[4];
		pintar[0] = false;
		pintar[1] = false;
		pintar[2] = false;
		pintar[3] = false;
		
		addMouseListener(this);
	}
	

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Toolkit ambiente = Toolkit.getDefaultToolkit();
		Image imagen =ambiente.getImage("data/mapa.png");
		g.drawImage(imagen, 120,10,this);
		
		for(int i = 0; i < 4; i++)
		{
			if(!pintar[i])
			{
				g.setColor(Color.BLACK);
				g.fillOval(COORDENADAS[i][0], COORDENADAS[i][1], 20, 20);
			}
			
			else
			{
				g.setColor(Color.RED);
				g.fillOval(COORDENADAS[i][0], COORDENADAS[i][1], 20, 20);
			}
			
		}
		
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
			if((e.getX()>=COORDENADAS[0][0] && e.getX()<=(COORDENADAS[0][0]+20))
					&& (e.getY()>=COORDENADAS[0][1] && e.getY()<=(COORDENADAS[0][1]+20)))
			{
				
				pintar[0] = true;
				pintar[1] = false;
				pintar[2] = false;
				pintar[3] = false;
				principal.CambiarSeleccionada(0);
				
				repaint();
			}
		
			
			else if((e.getX()>=COORDENADAS[1][0] && e.getX()<=(COORDENADAS[1][0]+20))
					&& (e.getY()>=COORDENADAS[1][1] && e.getY()<=(COORDENADAS[1][1]+20)))
			{
				pintar[1] = true;
				pintar[0] = false;
				pintar[2] = false;
				pintar[3] = false;
				principal.CambiarSeleccionada(1);
				repaint();
			}
			
			else if((e.getX()>=COORDENADAS[2][0] && e.getX()<=(COORDENADAS[2][0]+20))
					&& (e.getY()>=COORDENADAS[2][1] && e.getY()<=(COORDENADAS[2][1]+20)))
			{
				pintar[0] = false;
				pintar[1] = false;
				pintar[2] = true;
				pintar[3] = false;
				principal.CambiarSeleccionada(2);
				repaint();
			}
			
			else if((e.getX()>=COORDENADAS[3][0] && e.getX()<=(COORDENADAS[3][0]+20))
					&& (e.getY()>=COORDENADAS[3][1] && e.getY()<=(COORDENADAS[3][1]+20)))
			{
				pintar[0] = false;
				pintar[1] = false;
				pintar[2] = false;
				pintar[3] = true;
				principal.CambiarSeleccionada(3);
				repaint();
			}
	}

	public boolean [] darBooleanos()
	{
		return pintar;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
