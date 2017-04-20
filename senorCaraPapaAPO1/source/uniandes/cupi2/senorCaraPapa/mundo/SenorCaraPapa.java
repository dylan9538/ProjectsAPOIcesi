package uniandes.cupi2.senorCaraPapa.mundo;

public class SenorCaraPapa {

	// Declaracion de los Atributos
	private Parte accesorioActual;
	private Parte expresionActual;
	private Parte bocaActual;
	private Parte piesActual;
	private Parte brazosActual;
	private Parte boca1;
	private Parte boca2;
	private Parte boca3;
	private Parte brazos1;
	private Parte brazos2;
	private Parte brazos3;
	private Parte pies1;
	private Parte pies2;
	private Parte pies3;
	private Parte accesorio1;
	private Parte accesorio2;
	private Parte accesorio3;
	private Parte expresion1;
	private Parte expresion2;
	private Parte expresion3;

	//  Todos Metodos

	public String metodo1() {
		return "Respuesta 1"; 
		}
	

	public String metodo2() {
		return "Respuesta 2";
	}
 //crean objetos
	
	public SenorCaraPapa() {
		accesorio1 = new Parte(Parte.ACCESORIO, 5, 22000.5);
		accesorio2 = new Parte(Parte.ACCESORIO, 10, 12350);
		accesorio3 = new Parte(Parte.ACCESORIO, 18, 10300);
		expresion1 = new Parte(Parte.EXPRESION, 12, 35000);
		expresion2 = new Parte(Parte.EXPRESION, 17, 12300);
		expresion3 = new Parte(Parte.EXPRESION, 1, 17000.5);
		boca1 = new Parte(Parte.BOCA, 1, 23500.5);
		boca2 = new Parte(Parte.BOCA, 12, 22800.5);
		boca3 = new Parte(Parte.BOCA, 7, 25000.5);
		brazos1 = new Parte(Parte.BRAZOS, 22, 21500.5);
		brazos2 = new Parte(Parte.BRAZOS, 1, 29300);
		brazos3 = new Parte(Parte.BRAZOS, 8, 27200);
		pies1 = new Parte(Parte.PIES, 11, 66000.6);
		pies2 = new Parte(Parte.PIES, 3, 52250);
		pies3 = new Parte(Parte.PIES, 8, 47000.5);

	}

	public void seleccionarAccesorioCabeza(int identificadorParte) {
		if (identificadorParte == 1) {
			accesorioActual = accesorio1;
		}
		if (identificadorParte == 2) {
			accesorioActual = accesorio2;
		}
		if (identificadorParte == 3) {
			accesorioActual = accesorio3;
		}
	}

	public void seleccionarExpresionFacial(int identificadorParte) {
		if (identificadorParte == 1) {
			expresionActual = expresion1;
		}
		if (identificadorParte == 2) {
			expresionActual = expresion2;
		}
		if (identificadorParte == 3) {
			expresionActual = expresion3;
		}
	}

	public void seleccionarBoca(int identificadorParte) {
		if (identificadorParte == 1) {
			bocaActual = boca1;
		}
		if (identificadorParte == 2) {
			bocaActual = boca2;
		}
		if (identificadorParte == 3) {
			bocaActual = boca3;
		}
	}

	public void seleccionarBrazos(int identificadorParte) {
		if (identificadorParte == 1) {
			brazosActual = brazos1;
		}
		if (identificadorParte == 2) {
			brazosActual = brazos2;
		}
		if (identificadorParte == 3) {
			brazosActual = brazos3;
		}
	}

	public void seleccionarPies(int identificadorParte) {
		if (identificadorParte == 1) {
			piesActual = pies1;
		}
		if (identificadorParte == 2) {
			piesActual = pies2;
		}
		if (identificadorParte == 3) {
			piesActual = pies3;
		}
	}

	public double calcularPrecioTotal() {
		double accesorio = 0;
		if (accesorioActual != null) {
			accesorio = accesorioActual.darPrecioConDescuento();
		}
		double expresion = 0;
		if (expresionActual != null) {
			expresion = expresionActual.darPrecioConDescuento();
		}
		double boca = 0;
		if (bocaActual != null) {
			boca = bocaActual.darPrecioConDescuento();
		}
		double brazos = 0;
		if (brazosActual != null) {
			brazos = brazosActual.darPrecioConDescuento();
		}
		double pies = 0;
		if (piesActual != null) {
			pies = piesActual.darPrecioConDescuento();
		}

		double precio1 = accesorio + boca + expresion + brazos + pies;
		double precio2 = precio1;
		if (precio1 >= 50000 && precio1 < 100000) {
			precio2 = precio1 * 0.90;
		}
		if (precio1 >= 100000 && precio1 < 150000) {
			precio2 = precio1 * 0.85;
		}
		if (precio1 >= 150000) {
			precio2 = precio1 * 0.80;
		}
		return precio2;
	}

	public void venderDiseno() {
		accesorioActual.cambiarCantidadDisponible(accesorioActual
				.darCantidadDisponible() - 1);
		expresionActual.cambiarCantidadDisponible(expresionActual
				.darCantidadDisponible() - 1);
		bocaActual
				.cambiarCantidadDisponible(bocaActual.darCantidadDisponible() - 1);
		piesActual
				.cambiarCantidadDisponible(piesActual.darCantidadDisponible() - 1);
		brazosActual.cambiarCantidadDisponible(brazosActual
				.darCantidadDisponible() - 1);
	}

	public String darExistenciasDiseno() {
		return "Accesorio: "
				+ accesorioActual.darCantidadDisponible()
				+ "\nExpresion: "
				+ expresionActual.darCantidadDisponible()
				+ "\nBoca: "
				+ bocaActual.darCantidadDisponible()
				+ "\nBrazos: "
				+ brazosActual.darCantidadDisponible()
				+ "\nPies: "
				+ piesActual.darCantidadDisponible();

	}
}
