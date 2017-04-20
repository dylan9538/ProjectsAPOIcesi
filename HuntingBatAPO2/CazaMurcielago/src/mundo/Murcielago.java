package mundo;

import java.util.Random;

public class Murcielago {

	public final static int ALTO = 90;
	public final static int ANCHO = 90;
	public final static String  MURCIELAGO_NEGRO = "negro";
	public final static String  MURCIELAGO_VIOLETA = "violeta";

	private int coordenaX, coordenaY;
	private boolean estaAdentro;
	private String tipo;
	private Murcielago este;

	public Murcielago( String nTipo, int X, int Y, int alto,int ancho) {
		tipo=nTipo;
		coordenaX=X;
		coordenaY=Y;
		alto = ALTO;
		ancho = ANCHO;
		
		estaAdentro = false;
	}

	public boolean estaAdentro(int ejex, int ejey) {
		if (ejex >= coordenaX && ejex <= coordenaX+ANCHO) {
			if (ejey >= coordenaY && ejey <= coordenaY+ALTO) {
				estaAdentro = true;
			}
		}
		return estaAdentro;
	}


	// metodos dar y cambiar

	

	public int getCoordenaX() {
		return coordenaX;
	}

	
	public void setCoordenaX(int coordenaX) {
		this.coordenaX = coordenaX;
	}

	public int getCoordenaY() {
		return coordenaY;
	}
	public Murcielago darMurci(){
		return este;
	}
	public void cambiarMurci(Murcielago nNuevo){
		este=nNuevo;
	}

	public void setCoordenaY(int coordenaY) {
		this.coordenaY = coordenaY;
	}



	
}
