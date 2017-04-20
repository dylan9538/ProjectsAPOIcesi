package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import mundo.Canon;
import mundo.Bala;

@SuppressWarnings("serial")
public class PanelCanon extends JPanel {

	private Canon elCanon;
	private int contador;
	private JLabel coords;
	private int x,y;
	
	
	public PanelCanon(Canon canon) {
		elCanon = canon;
		
		
		setBorder(new TitledBorder("Escenario de Disparo"));
		setPreferredSize(new Dimension(Canon.ANCHO_PANEL_CANON,Canon.ALTO_PANEL_CANON));
		
	}
	
	//Sobreescribe el método encargado de pintar la interfaz
	//Siempre tenga en cuenta:
	//1. el método se debe llamar paintComponent, y NO paintComponents
	//2. la primera instrucción en el método debe ser: super.paintComponent
	//Luego de esto realice todos los llamados para realizar el dibujo
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        contador=0;
		//Cañon
        g.fillOval(30,350,80, 80);
        double angulo = elCanon.getAnguloInicial();
        Polygon p = new Polygon();
   
    	p.addPoint(60,400);
    	p.addPoint(60,360);
    	p.addPoint(elCanon.puntos(angulo+0.1,200)[1], elCanon.puntos(angulo+0.1,200)[0]+20);
    	p.addPoint(elCanon.puntos(angulo-0.3,200)[1],elCanon.puntos(angulo-0.3,200)[0]-20);
    	g.fillPolygon(p);
        
        //-------------------------------
    	g.setColor(Color.BLACK);
    	g.setFont(new Font("lll",Font.CENTER_BASELINE,14));
        g.drawString("Lista De Balas",Canon.DISTANCIA_HORIZONTAL_PARED+130,40);
        g.setFont(new Font("nombre",Font.BOLD,12));
	       
        //
		
		g.setColor(Color.ORANGE);
		g.fillOval(50,380 ,70, 70);
		
		g.setColor(getBackground());
		g.fillOval(60,390, 50, 50);
		
		g.setColor(Color.ORANGE);
		g.drawLine(60, 415, 120, 415);
		g.drawLine(85, 385, 85, 450);

	
		//Muro
		g.setColor(Color.RED);
	
		g.fillRect(900, 35, 40,20);
		g.fillRect(900, 60, 40,20);
		g.fillRect(900, 85, 40,20);
       	g.fillRect(900, 110, 40,20);
		g.fillRect(900, 135, 40,20);
		g.fillRect(900, 160, 40,20);
		g.fillRect(900, 185, 40,20);
		g.fillRect(900, 210, 40,20);
		
		g.fillRect(900, 235, 40,20);
		g.fillRect(900, 260, 40,20);
       	g.fillRect(900, 285, 40,20);
		g.fillRect(900, 310, 40,20);
		g.fillRect(900, 335, 40,20);
		g.fillRect(900, 360, 40,20);
		g.fillRect(900, 385, 40,20);
		
		g.fillRect(900, 410, 40,20);
		g.fillRect(900, 435, 40,20);  
		g.fillRect(900, 460, 40,20);
		//-----------------------
    	g.setColor(Color.GRAY);
		g.fillRect(945, 35, 20,20);
		g.fillRect(945, 60, 20,20);
		g.fillRect(945, 85, 20,20);
        g.fillRect(945, 110,20,20);
		g.fillRect(945, 135, 20,20);
		g.fillRect(945, 160, 20,20);
		g.fillRect(945, 185, 20,20);
		g.fillRect(945, 210, 20,20);
		
		g.fillRect(945, 235, 20,20);
		g.fillRect(945, 260, 20,20);
        g.fillRect(945, 285, 20,20);
		g.fillRect(945, 310, 20,20);
		g.fillRect(945, 335, 20,20);
		g.fillRect(945, 360, 20,20);
		g.fillRect(945, 385, 20,20);
		
		g.fillRect(945, 410, 20,20);
		g.fillRect(945, 435, 20,20);  
		g.fillRect(945, 460, 20,20);
		
	if(elCanon.getPrimeraBala()!= null){
		
		int[] a = elCanon.getPrimeraBala().getColorRGB();
		g.setColor(new Color(a[0],a[1],a[2]));
		g.fillOval(elCanon.getPrimeraBala().getCoordenadaX(),elCanon.getPrimeraBala().getCoordenadaY(),
				                                Bala.ANCHO_BALA,Bala.ANCHO_BALA);
		
		Bala bala = elCanon.getPrimeraBala().getBalaSiguiente();
		   while(bala != null){
			int[] al = bala.getColorRGB();
			g.setColor(new Color(al[0],al[1],al[2]));
			g.fillOval(bala.getCoordenadaX(),bala.getCoordenadaY(),
					                                Bala.ANCHO_BALA,Bala.ANCHO_BALA);
			          		     		
	               g.setColor(new Color(bala.getColorRGB()[0],bala.getColorRGB()[1], bala.getColorRGB()[2]));
	 		       g.setFont(new Font("Serif",Font.BOLD,14));
	 		       g.drawString("Bala:"+(contador)+", VI: "+ bala.getVelocidadInicial()+"AN: "+ bala.getAnguloInicial(),
	 		    		                                                Canon.DISTANCIA_HORIZONTAL_PARED+120,
	 		                                                                                       80+contador*20);
	 		       
	 		       contador++;
	     	 bala = bala.getBalaSiguiente();
		   }
		   repaint();
	    }


	}
}