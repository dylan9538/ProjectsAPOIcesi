package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Panelbarra extends JMenuBar implements ActionListener {

	private InterfazJuego principal;
	
	public final static String NUEVO_JUEGO="Nuevo Juego";
	public final static String SALIR="Salir";
	public final static String INSTRUCCIONES="Instruccion";

	//barra  de menu.
	
	private JMenu archivo, ayuda;
	private JMenuItem nuevojuego, salir,instrucciones;
	
	public Panelbarra(InterfazJuego v) {
		// inicializacion de atributos del juego.
		principal = v;

		archivo= new JMenu("Archivo");
		
		nuevojuego= new JMenuItem("Nuevo Juego");
		nuevojuego.addActionListener(this);
		nuevojuego.setActionCommand(NUEVO_JUEGO);
		
		salir= new JMenuItem("Salir");
		salir.addActionListener(this);
		salir.setActionCommand(SALIR);
		
		archivo.add(nuevojuego);
		archivo.add(salir);
		
		ayuda= new JMenu("Ayuda");
		
		instrucciones= new JMenuItem("Instrucciones");
		instrucciones.addActionListener(this);
		instrucciones.setActionCommand(INSTRUCCIONES);
		
		ayuda.add(instrucciones);
		
		add(archivo);
		add(ayuda);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando=evento.getActionCommand();
		
		if(comando.equalsIgnoreCase(INSTRUCCIONES))
		{
			principal.instrucciones();
		}
		else if(comando.equalsIgnoreCase(NUEVO_JUEGO))
		{
			principal.setVisible(false);
			principal = new InterfazJuego();
		
		}
		else if(comando.equalsIgnoreCase(SALIR))
		{
			principal.dispose();
		}	
	}	

}
