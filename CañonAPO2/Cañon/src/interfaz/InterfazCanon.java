package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.Bala;
import mundo.Canon;

@SuppressWarnings("serial")
public class InterfazCanon extends JFrame {
	
	
	private Canon elCanon;
	
	private PanelCanon panelCanon;
	private PanelFormulario panelFormulario;
	
	/**
	 * Crea la ventana
	 */
	public InterfazCanon() {
		setTitle("Ca\u00F1on");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		
		elCanon = new Canon();
		
		panelCanon  = new PanelCanon(elCanon);
		panelFormulario = new PanelFormulario(this);

		add(panelCanon,BorderLayout.CENTER);
		add(panelFormulario,BorderLayout.SOUTH);
		
		pack();
	}
	
	public void lanzarBala(){
		try{
			double velocidad = Double.parseDouble(panelFormulario.getVelocidad());
			double angulo    = Double.parseDouble(panelFormulario.getAngulo());

			
			elCanon.setAnguloInicial(angulo);
			elCanon.setVelocidadInicial(velocidad);

			elCanon.cargarBala();
			/************************/
			new Thread(){
				
				
		public void run(){
			/************************/
			//TODO Escriba a continuación el código para mover paso a paso la bala lanzada	
			/************************/
			Bala b = elCanon.getPrimeraBala();
			
			int x = b.getCoordenadaX();
              while(x< Canon.DISTANCIA_HORIZONTAL_PARED && 
            		  b.getCoordenadaY()< Canon.ALTO_PANEL_CANON-Bala.ANCHO_BALA
            		          && b.getCoordenadaY()>15){
            	  int a = 10;
            	  x =  x +a;
            	  b.cambiarCoordenadaX(x);
            	  panelCanon.repaint();
            	  repaint();
            	  try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
              }	
              while(b.getCoordenadaY()<Canon.ALTO_PANEL_CANON-Bala.ANCHO_BALA){
         		 int a = 10;
         		 int lb = b.getCoordenadaY();
         		 lb += a;
         		 b.setCoordenadaY(lb);  
         	  repaint();
         	  try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
           }	
			/************************/
			// Fin del espacio para el código de mover la bala recien lanzada
			/************************/
				}
			}.start();
			/************************/
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Los valores de velocidad e inclinación deben ser numéricos");
		}
	}
	/**
	 * Lanza la aplicación.
	 */
	public static void main(String[] args) {
		final InterfazCanon ventana = new InterfazCanon();
		ventana.setVisible(true);
	}
}