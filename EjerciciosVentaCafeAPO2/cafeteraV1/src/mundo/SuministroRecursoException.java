package mundo;

public class SuministroRecursoException extends Exception {

	private String nombreRecurso;
	private double cantidadActual;
	private double suministro;
	private double maximo;
	
public SuministroRecursoException (String nombreR, double cant , double sum , double max){
	
	
	nombreRecurso = nombreR;
	cantidadActual =  cant;
	suministro =  sum;
	maximo =  max;
  }

public String getNombreRecurso() {
	return nombreRecurso;
}

public double getCantidadActual() {
	return cantidadActual;
}

public double getSuministro() {
	return suministro;
}

public double getMaximo() {
	return maximo;
}
	
}
