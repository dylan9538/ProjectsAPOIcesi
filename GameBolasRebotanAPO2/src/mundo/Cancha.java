package mundo;

import java.util.ArrayList;
import java.io.*;


public class Cancha {
	public final static String RUTA_PUNTAJE = "./datos/puntaje.atrapalos";

	private String rutaA;
	private ArrayList<Balon> balones;
	private Puntaje elPuntaje;
	private int nivel;

	public Cancha(String ruta) throws Exception{
		rutaA  = ruta;
		balones = new ArrayList<Balon>();
		elPuntaje = new Puntaje();
		nivel = 0;
		cargarPuntaje();
	}
		

	// SERIALIZACIÓN

	public void cargarPuntaje() throws PersistenciaException {

		File archivo = new File(rutaA);

		if (archivo.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
				elPuntaje = (Puntaje) ois.readObject();
				ois.close();

			} catch (Exception e) {

				throw new PersistenciaException("Imposible restaurar el estado del programa (" + e.getMessage() + ")");
			}
		}
	}
	
	
	
	public void guardarPuntaje( ) throws PersistenciaException
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(RUTA_PUNTAJE) );
            oos.writeObject( elPuntaje );
            oos.close( );
        
        }
        catch( IOException e )
        {
        	e.printStackTrace();
            throw new PersistenciaException( "Error al salvar: " );
        }
    }
	
	

	
	// PERSISTENCIA

	public void cargarJuego(File archivo) throws IOException {

		FileReader fr = new FileReader(archivo);
		BufferedReader lector = new BufferedReader(fr);
		
		balones = new ArrayList<Balon>();
		String linea = lector.readLine();
		while (linea != null && !linea.equals("")) {
			if (!(linea.startsWith("#"))) {				
				String[] split = linea.split("\t");
				if(split.length == 1){
					nivel  = Integer.parseInt(split[0]);
				}else{
					boolean b = false;
					if(split[6].equalsIgnoreCase("false")){
						b = false;
					}else{
						b = true;
					}
					Balon balon = new Balon(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1]), Integer.parseInt(split[2]),
						Integer.parseInt(split[3]), split[4], Integer.parseInt(split[5]), b);	

						balones.add(balon);
				}
			}
			linea = lector.readLine();
		}
		
		lector.close();
		fr.close();
	}
	// PERSISTENCIA

	public void guardarJuego(File f) throws IOException {

		PrintWriter escritor = new PrintWriter(f);
		String cadena = "#nivel\n"+  nivel + "\n" + "#radio posX posY espera direccion rebotes\n";
		
		for (int i = 0; i < balones.size(); i++) {
			Balon balon = balones.get(i);
			cadena += balon.darDiametro() + "\t" + balon.darPosX() + "\t" + balon.darPosY() + "\t"
					+ balon.darEspera() + "\t" + balon.darDireccion() + "\t" + balon.darRebotes() + "\t"
					+ balon.haSidoAtrapado() + "\n";
		}
		escritor.println(cadena);
		escritor.close();
	}
	

	public ArrayList<Balon> darBalones() {
		return balones;
	}

	public Puntaje darPuntaje() {
		return elPuntaje;
	}

	public int calcularTotalRebotes() {
		int totalReb = 0;
		for (Balon b : balones) {
			totalReb += b.darRebotes();
		}
		return totalReb;
	}

	public void atrapar(int x, int y) {
		for (int i = 0; i < balones.size(); i++) {
			Balon b = balones.get(i);
			if (b.atrapado(x, y)) {
				b.cambiarAtrapado(true);
			}
		}
	}

	public boolean juegoTerminado() {
		boolean atrapados = true;
		for (int i = 0; i < balones.size() && atrapados; i++) {
			Balon b = balones.get(i);
			if (!b.haSidoAtrapado()) {
				atrapados = false;
			}
		}
		return atrapados;
	}

	public boolean hayQueGuardarPuntaje() {
		int totalReb = calcularTotalRebotes();
		boolean hayQueGuardar = elPuntaje.entreLosMejores(nivel, totalReb);
		return hayQueGuardar;
	}

	public void guardarPuntajeActual(String nom) {
		elPuntaje.agregarPuntaje(nivel, nom, calcularTotalRebotes());
	}

	public String darPuntajes() {
		String reportePuntaje;
		reportePuntaje = elPuntaje.darPuntajes();
		return reportePuntaje;
	}

	public int getNivel() {
		return nivel;
	}
	
	
}
