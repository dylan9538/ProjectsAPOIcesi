package interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import hilos.HiloBalon;
import mundo.Balon;
import mundo.Cancha;
import mundo.PersistenciaException;

@SuppressWarnings("serial")
public class InterfazJuegoBalones extends JFrame{
	private Cancha miCancha;
	private PanelCancha panelCancha;
	private MenuArchivo menuArchivo;
	private MenuVer menuVer;
	private HiloBalon hiloBalon;
	
	public InterfazJuegoBalones(Cancha c){
		setTitle("Atrápalas Ya!");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		miCancha = c;
		panelCancha = new PanelCancha(this);
		menuArchivo = new MenuArchivo(this);
		menuVer = new MenuVer(this);
		
		JMenuBar miMenuBar = new JMenuBar();
		miMenuBar.add(menuArchivo);
		miMenuBar.add(menuVer);
		setJMenuBar(miMenuBar);
		
		add(panelCancha, BorderLayout.CENTER);
		
		setSize(500,400);
	}
	
	public boolean cargarDeArchivo(){
		boolean cargoArchivo = false;
		JFileChooser fileCh = new JFileChooser("./datos");
		int opcion = fileCh.showOpenDialog(this);
		
		switch(opcion){	
			case JFileChooser.APPROVE_OPTION:
				File f = fileCh.getSelectedFile();
				try{
					miCancha.cargarJuego(f);
					panelCancha.cambiarBalones(miCancha.darBalones());
					crearEIniciarHilos();
					panelCancha.repaint();
					
					cargoArchivo = true;
				}catch(IOException ioexc){
					JOptionPane.showMessageDialog(this, "Problemas leyendo el archivo\nEs probable que el formato no sea válido.");
				}
			break;
			case JFileChooser.CANCEL_OPTION:				
			break;
			case JFileChooser.ERROR_OPTION:
			break;
		}
		return cargoArchivo;
	}
	
	private void crearEIniciarHilos(){
		for (int i = 0; i < miCancha.darBalones().size();i++) {
		Balon b = miCancha.darBalones().get(i);
		hiloBalon =  new HiloBalon(b, this);
		hiloBalon.start();	
		}
		
}
	
	public void refrescarCancha() {
		panelCancha.actualizarRebotes();
		panelCancha.repaint();
	}
	
	public boolean guardarAArchivo(){
		boolean guardoArchivo = false;
		JFileChooser fileCh = new JFileChooser("./datos");
		fileCh.setSelectedFile(new File("JuegoGuardado_"+(new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date()))+".txt"));
		int opcion = fileCh.showSaveDialog(this);
		
		switch(opcion){	
			case JFileChooser.APPROVE_OPTION:
				File f = fileCh.getSelectedFile();
				try{
					miCancha.guardarJuego(f);
					guardoArchivo = true;
				}catch(Exception ioexc){
					JOptionPane.showMessageDialog(this, "Problemas guardando el archivo\nEs probable que no tenga permisos de escritura o\nel archivo puede estar bloqueado por otro programa.");
				}
			break;
			case JFileChooser.CANCEL_OPTION:				
			break;
			case JFileChooser.ERROR_OPTION:
			break;
		}
		return guardoArchivo;		
	}
	
	public void salir(){
		int opcion;
		boolean guardo=false;
		try {
			miCancha.guardarPuntaje();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		do{
			opcion = JOptionPane.showConfirmDialog(this, "¿Desea guardar el juego actual antes de salir?");
			if(opcion==JOptionPane.YES_OPTION){
				guardo = guardarAArchivo();
			}
		}while(opcion==JOptionPane.YES_OPTION && !guardo);
		
		if(opcion==JOptionPane.YES_OPTION ||opcion==JOptionPane.NO_OPTION){
			
			System.exit(0);
			
		}		
	}
	
	public void mostrarPuntajes(){
		String puntajes;
		puntajes = miCancha.darPuntajes();
		JOptionPane.showMessageDialog(this, puntajes);
		
	}
	
	public void mostrarAcercaDelJuego(){
		JOptionPane.showMessageDialog(this, "Desarrollado por:\nJuan Manuel Reyes\nDepartamento de TIC\nFacultad de Ingeniería\nUniversidad Icesi");
	}
	
	public int darAnchoActual(){
		return getContentPane().getWidth();
	}
	
	public int darAltoActual(){
		return getContentPane().getHeight();
	}
	
	public int darTotalRebotes(){
		int totRe;
		totRe = miCancha.calcularTotalRebotes();
		return totRe;
	}
	
	public void atrapar(int x, int y){
		miCancha.atrapar(x, y);
		if(miCancha.juegoTerminado()){
			if(miCancha.hayQueGuardarPuntaje()){
				int puntajeActual = miCancha.calcularTotalRebotes();
				String nombre;
				do{
					nombre = JOptionPane.showInputDialog("Su puntaje de: "+puntajeActual+" es uno de los 10 mejores.\nPor favor digite su nombre para el Hall de la Fama:");
				}while(nombre==null || nombre.equals(""));
				
				miCancha.guardarPuntajeActual(nombre);
			}
		}
	}
	
	public void dispose(){
		salir();
	}
	

	public static void main(String[] args){
		Cancha m = null;
		try {
			m = new Cancha("./datos/puntaje.atrapalos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		InterfazJuegoBalones ventana;
		ventana = new InterfazJuegoBalones(m);
		ventana.setVisible(true);
	}

}
