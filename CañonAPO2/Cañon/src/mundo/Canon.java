package mundo;

public class Canon {
	
	public final static int ANCHO_PANEL_CANON          = 1100;
	public final static int ALTO_PANEL_CANON           = 500;
	public final static int DISTANCIA_HORIZONTAL_PARED = 850;

	public final static double GRAVEDAD = 10;
	
	public final static int X_INICIAL = 150;
	public final static int Y_INICIAL = 50;
	
	public final static int ARREGLOX []={60,160,160,60};
	public final static int ARREGLOY []={360,360,400,400};
	
	
	public final static double VELOCIDAD_INICIAL_DEFECTO = 30;
	public final static double ANGULO_INICIAL_DEFECTO    = Math.PI / 4;
	
	private Bala primeraBala;
	private double velocidadInicial;
	private double anguloInicial;

	public Canon() {
		velocidadInicial = VELOCIDAD_INICIAL_DEFECTO;
		anguloInicial    = ANGULO_INICIAL_DEFECTO;
	}

public int[] puntos(double angulo, int longitud){
		
		double cO2 = Math.sin(angulo)*longitud;
		double cA2 = Math.cos(angulo)*longitud;
		int a = 480-(int)(cO2);
		int b = (int)(cA2)+25;
		int[] nums = new int[]{a,b};
		return nums;
	}
	
	/*
	 * Método que crea una nueva bala y la añade como primera a su lista simple
	 * enlazada de balas
	 */
	public void cargarBala() {
		//TODO Implementar el cuerpo de este método que agrega (crea) una nueva bala y la pone al principio de la lista
		if(primeraBala == null){
			primeraBala = new Bala(X_INICIAL,Y_INICIAL, velocidadInicial,anguloInicial);
		}else{
			Bala tmp = primeraBala;
	        primeraBala = new Bala(X_INICIAL,Y_INICIAL, velocidadInicial,anguloInicial);
	        primeraBala.setBalaSiguiente(tmp);
		}	
	}
	/**
	 * @return the primeraBala
	 */
	public Bala getPrimeraBala() {
		return primeraBala;
	}

	/**
	 * @param primeraBala the primeraBala to set
	 */
	public void setPrimeraBala(Bala primeraBala) {
		this.primeraBala = primeraBala;
	}

	/**
	 * @return the velocidad inicial de la bala
	 */
	public double getVelocidadInicial() {
		return velocidadInicial;
	}

	/**
	 * @param velocidad the velocidad inicial de la bala to set
	 */
	public void setVelocidadInicial(double laVelocidadInicial) {
		velocidadInicial = laVelocidadInicial;
	}

	/**
	 * @return the ángulo
	 */
	public double getAnguloInicial() {
		return anguloInicial;
	}

	/**
	 * @param ángulo the ángulo inicial to set
	 */
	public void setAnguloInicial(double elAnguloInicial) {
		anguloInicial = elAnguloInicial;
	}

}
