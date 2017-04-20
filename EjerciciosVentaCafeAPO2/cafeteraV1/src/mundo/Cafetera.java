package mundo;

import java.io.*;
import java.util.ArrayList;

public class Cafetera {
	
	private static final String LOG_FILE = "./data/error.log";
	
	
	private ArrayList<Recurso> ingredientes;
	private double dineroEnVentas;
	private int cafesVendidos15gr;
	private int cafesVendidos30gr;

	public static final double COSTO_CAFE15gr = 1000;
	public static final double COSTO_CAFE30gr = 1200;

	public Cafetera() {
		
		
		
		dineroEnVentas = 0;
		cafesVendidos15gr = 0;
		cafesVendidos30gr = 0;

		ingredientes = new ArrayList<Recurso>();

		// El identificador de cada recurso es la posición que ocupan en
		// el arreglo de ingredientes
		ingredientes.add(new Recurso(ingredientes.size(), "Cafe", 450, 0, 15,"kg"));
		ingredientes.add(new Recurso(ingredientes.size(), "Agua", 18900, 0, 10,"ml"));
		ingredientes.add(new Recurso(ingredientes.size(), "Vasos", 50, 0, 1,"unidades"));
		ingredientes.add(new Recurso(ingredientes.size(), "Azucar", 100, 0, 2,"unidades"));
		ingredientes.add(new Recurso(ingredientes.size(), "Pitillos", 50, 0,1, "unidades"));
	}

	public void venderCafe(double cantidadCafe) throws ImposiblePrepararCafeException, CafeIncompletoException {

		// Cada posición del arreglo indica la disponibilidad de un recurso.
		// Ejemplo: posición 0 indica la disponibilidad del café
 if(!ingredientes.get(0).hayDisponibilidad()){
	throw new ImposiblePrepararCafeException("No hay suficiente cafe","Cafe");
	}
 if(!ingredientes.get(1).hayDisponibilidad()){
	throw new ImposiblePrepararCafeException("No hay suficiente agua","Agua");
	  }
   if(!ingredientes.get(2).hayDisponibilidad()){
	throw new ImposiblePrepararCafeException("No hay suficientes vasos","Vasos");
	   }
    if(!ingredientes.get(3).hayDisponibilidad()){
	throw new CafeIncompletoException("Azucar");
	    }
     if(!ingredientes.get(4).hayDisponibilidad()){
	throw new CafeIncompletoException("pitillos");
     }
	for (int i = 0; i < ingredientes.size(); i++) {
		Recurso in = ingredientes.get(i);	    
	
		if(in.darNombre().equals(ingredientes.get(0).darNombre()) && cantidadCafe == 30){
			in.usarParaHacerCafe();
			in.usarParaHacerCafe();	
		}else{
			in.usarParaHacerCafe();
		}
	}
	if (cantidadCafe == 15) {
			cafesVendidos15gr++;
			dineroEnVentas+=COSTO_CAFE15gr;		
	} else {
			cafesVendidos30gr++;
			dineroEnVentas+=COSTO_CAFE30gr;
	}
		
}

public void venderCafeIncompleto(double cantidadCafe) {
		// Agregue lo que haga falta para generar las excepciones
		// mas las instrucciones que son responsabilidad del método

	for (int i = 0; i < ingredientes.size(); i++) {
	Recurso in =	 ingredientes.get(i);	    

if(in.darNombre().equals(ingredientes.get(3).darNombre())){
		if(in.darCantidadActual()>=in.darCantidadXCafe()){
			in.usarParaHacerCafe();
		}
	}
if(in.darNombre().equals(ingredientes.get(4).darNombre())){
	if(in.darCantidadActual()>=in.darCantidadXCafe()){
		in.usarParaHacerCafe();
	}
}
else{
	in.usarParaHacerCafe();
}
	}
	if (cantidadCafe == 15) {
			cafesVendidos15gr++;
			dineroEnVentas+=COSTO_CAFE15gr;
	} else {
			cafesVendidos30gr++;
			dineroEnVentas+=COSTO_CAFE30gr;
		}
	}





public void resgistrarError(Exception e){
	try{
		FileWriter out =  new FileWriter(LOG_FILE,true);
	    PrintWriter log = new PrintWriter(out);

	    log.println("---------------------------------------");
	    log.println("LALA");
        log.println("--------------------------------------");
	   

	       log.close();
	       out.close();
	}catch(IOException ex){
		e.printStackTrace();
		ex.printStackTrace();
	}
	
}
	/**
	 * @return the ingredientes
	 */
	public ArrayList<Recurso> getIngredientes
	() {
		return ingredientes;
	}

	/**
	 * @param ingredientes the ingredientes to set
	 */
	public void setIngredientes(ArrayList<Recurso> ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * @return the dineroEnVentas
	 */
	public double getDineroEnVentas() {
		return dineroEnVentas;
	}

	/**
	 * @param dineroEnVentas the dineroEnVentas to set
	 */
	public void setDineroEnVentas(double dineroEnVentas) {
		this.dineroEnVentas = dineroEnVentas;
	}

	/**
	 * @return the cafesVendidos15gr
	 */
	public int getCafesVendidos15gr() {
		return cafesVendidos15gr;
	}

	/**
	 * @param cafesVendidos15gr the cafesVendidos15gr to set
	 */
	public void setCafesVendidos15gr(int cafesVendidos15gr) {
		this.cafesVendidos15gr = cafesVendidos15gr;
	}

	/**
	 * @return the cafesVendidos30gr
	 */
	public int getCafesVendidos30gr() {
		return cafesVendidos30gr;
	}

	/**
	 * @param cafesVendidos30gr the cafesVendidos30gr to set
	 */
	public void setCafesVendidos30gr(int cafesVendidos30gr) {
		this.cafesVendidos30gr = cafesVendidos30gr;
	}


}