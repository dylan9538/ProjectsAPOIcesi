package mundo;

import java.util.Random;

public class Bala {

	public final static int CANTIDAD_COMPONENTES_COLOR = 3;
	public final static int ANCHO_BALA = 50;
	
	private int[] colorRGB;
	
	private int coordenadaXActual;
	private int coordenadaYActual;

	private int coordenadaYInicial;
	private double velocidadInicial;
	private double anguloInicial;

	private Bala balaSiguiente;

	public Bala(int coordX, int coordY, double velIni, double angIni) {
		coordenadaXActual  = coordX;
		coordenadaYActual  = coordY;
		coordenadaYInicial = coordY;//este atributo no se vuelve a cambiar durante la vida de este objeto.
		velocidadInicial   = velIni;
		anguloInicial      = angIni;

		generarColor();
	}

	/*
	 * Método encargado de cambiar aleatoriamente los valores (entre 0 y 255)
	 * para la definición del color de la bala
	 */
	public void generarColor() {
		colorRGB =  new int[3];
		int n = 0;
		Random r = new Random();		
	
		n = r.nextInt(255); 		
		colorRGB[0] = n;
		
		n = r.nextInt(255); 		
		colorRGB[1] = n;
		
		n = r.nextInt(255); 		
	    colorRGB[2] = n;	
	}

	/*
	 * Método que actualiza la posición Y de la bala de acuerdo a la
	 * coordenada X pasada por parámetro.
	 * @param coordX Nueva posición en X para la bala
	 */
	public void cambiarCoordenadaX(int coordX) {
		coordenadaXActual = coordX;
		coordenadaYActual = calcularCoordenadaY();
	}
	
	private int calcularCoordenadaY(){
		double y;
		
		double vi = velocidadInicial+40;
		
		y = coordenadaYInicial 
		  + (vi*Math.sin(anguloInicial)*coordenadaXActual)/(vi*Math.cos(anguloInicial)) 
		  - 0.5 * Canon.GRAVEDAD * ((coordenadaXActual)/(vi*Math.cos(anguloInicial)))*((coordenadaXActual)/(vi*Math.cos(anguloInicial)));
		
		y = Canon.ALTO_PANEL_CANON - y;
		
		return (int)y;
	}


	/**
	 * @return the colorRGB
	 */
	public int[] getColorRGB() {
		return colorRGB;
	}

	/**
	 * @param colorRGB
	 *            the colorRGB to set
	 */
	public void setColorRGB(int[] colorRGB) {
		this.colorRGB = colorRGB;
	}

	/**
	 * @return the coordenadaX
	 */
	public int getCoordenadaX() {
		return coordenadaXActual;
	}

	/**
	 * @param coordenadaX
	 *            the coordenadaX to set
	 */
	public void setCoordenadaX(int coordX) {
		coordenadaXActual = coordX;
	}

	/**
	 * @return the coordenadaY
	 */
	public int getCoordenadaY() {
		return coordenadaYActual;
	}

	public void setCoordenadaY(int coordY) {
		coordenadaYActual = coordY;
	}
	/**
	 * @return the balaSiguiente
	 */
	public Bala getBalaSiguiente() {
		return balaSiguiente;
	}

	/**
	 * @return the velocidadInicial
	 */
	public double getVelocidadInicial() {
		return velocidadInicial;
	}

	/**
	 * @return the anguloInicial
	 */
	public double getAnguloInicial() {
		return anguloInicial;
	}

	/**
	 * @param balaSiguiente the balaSiguiente to set
	 */
	public void setBalaSiguiente(Bala balaSiguiente) {
		this.balaSiguiente = balaSiguiente;
	}

}
