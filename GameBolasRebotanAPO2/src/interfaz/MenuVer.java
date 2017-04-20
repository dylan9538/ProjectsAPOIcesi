package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuVer extends JMenu implements ActionListener{
	
	private JMenuItem meitPuntajes;
	private JMenuItem meitAcercaDe;
	
	public final static String PUNTAJES = "Mejores puntajes";
	public final static String ACERCADE   = "acerca del juego";
	
	public InterfazJuegoBalones principal;
	
	public MenuVer(InterfazJuegoBalones ventada){
		super("Ver");
		principal = ventada;
		
		meitPuntajes = new JMenuItem("Mejores puntajes");
		meitAcercaDe = new JMenuItem("Acerca del juego");	
		
		meitPuntajes.addActionListener(this);
		meitAcercaDe.addActionListener(this);
		
		meitPuntajes.setActionCommand(PUNTAJES);
		meitAcercaDe.setActionCommand(ACERCADE);
		
		add(meitPuntajes);
		addSeparator();
		add(meitAcercaDe);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String even = evento.getActionCommand();
		
		if(even.equals(PUNTAJES)){
			principal.mostrarPuntajes();
		
		}else if(even.equals(ACERCADE)){
			principal.mostrarAcercaDelJuego();
			
		}
		
	}
	

}
