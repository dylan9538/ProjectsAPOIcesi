package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuArchivo extends JMenu implements ActionListener{
	
	
	private JMenuItem meitCargar;
	private JMenuItem meitGuardar;
	private JMenuItem meitSalir;
	
		
	public final static String CARGAR  = "CARGAR";
	public final static String GUARDAR = "GUARDAR";
	public final static String SALIR   = "SALIR";
	
	private InterfazJuegoBalones principal;
	
	public MenuArchivo(InterfazJuegoBalones ventana) {
		
		super("Archivo");
		
		principal = ventana;
		
		meitCargar  = new JMenuItem("Cargar Juego");
		meitGuardar = new JMenuItem("Guardar Juego");
		meitSalir   = new JMenuItem("Salir");
		
		
		
		meitCargar.addActionListener(this);
		meitGuardar.addActionListener(this);
		meitSalir.addActionListener(this);
		
		
		meitCargar.setActionCommand(CARGAR);
		meitGuardar.setActionCommand(GUARDAR);
		meitSalir.setActionCommand(SALIR);
		
		
		add(meitCargar);
		add(meitGuardar);
		addSeparator();
		add(meitSalir);
		
	
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(CARGAR)){
			principal.cargarDeArchivo();
		}else if(comando.equals(GUARDAR)){
			principal.guardarAArchivo();
		}else if(comando.equals(SALIR)){
			principal.salir();
		}
	}

}
