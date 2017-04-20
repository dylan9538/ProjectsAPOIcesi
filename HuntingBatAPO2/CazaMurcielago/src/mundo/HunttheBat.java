package mundo;

import java.net.MalformedURLException;
import java.rmi.server.RMIClassLoader;
import java.util.ArrayList;
import java.util.Random;

public class HunttheBat {

	private int contadorCazados, contadorPerdidos;

	public static final String SELECCIONADO = "Seleccionado";
	public final static String ARASTRADO = "Arastrado";
	public final static String MURCIELAGO_NEGRO = "Negro";
	public final static String MURCIELAGO_VIOLETA = "Violeta";
	public final static int ALTO = 90;
	public final static int ANCHO = 90;

	private String queEs;
	int posicionX,posicionY,random;
	boolean valor;

	public HunttheBat() {
	}

	// Métodos.

	public String darQueEs() {

		if (valor == false) {
			setQueEs(MURCIELAGO_NEGRO);
		}
		if (valor == true) {
			setQueEs(MURCIELAGO_VIOLETA);
		}
		return queEs;

	}

	public int darPosicionX() {
		return posicionX;
	}

	public void cambiarCoordenadaX() {
		Random ra = new Random();
	 posicionX = ra.nextInt(400);
	 posicionY= ra.nextInt(400);
	}

	public int darPosicionY() {
		return posicionY;
	}

	public boolean estaAdentro(int ejex, int ejey) {
		boolean est;
		int corX = darPosicionX();
		int corY = darPosicionY();
		if (ejex >= corX && ejex <= corX + ANCHO && ejey >= corY
				&& ejey <= corY + ALTO) {

			contadorCazados++;

			est = true;

		} else {

			contadorPerdidos += 1;

			est = false;

		}
		return est;

	}

	public int darContadorGanados() {
		return contadorCazados;
	}

	public int darContadorPerdidos() {
		return contadorPerdidos;
	}

	public void setQueEs(String queEs) {
		this.queEs = queEs;
	}

	public void generarRandom(){
		Random random = new Random();
		this.valor = random.nextBoolean();
	}
	
}
 