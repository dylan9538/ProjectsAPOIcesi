package uniandes.cupi2.senorCaraPapa.mundo;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Parte {
	
	//Declaracion de Atributos Privados
		private String tipoParte;
		private int cantidadDisponible;
		private double precioBase;
	

	//Declaracion de las Constantes
	public static final String ACCESORIO = "Accesorio";
	public static final String EXPRESION = "Expresion";
	public static final String BRAZOS = "Brazos";
	public static final String BOCA = "Boca";
	public static final String PIES = "Pies";
	
	//Metodos clase parte
	//Metodos dar y de cambio
	public String darTipo() {
		return tipoParte;
	}

	public int darCantidadDisponible() {
		return cantidadDisponible;
	}

	public void cambiarCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public double darPrecioBase() {
		return precioBase;
	}

	public void cambiarPrecioBase(double nPrecioBase){
		precioBase = nPrecioBase;
	}
	
	public double darPrecioConDescuento(){
		double descuento = 0;
		if (cantidadDisponible>10){
			descuento = precioBase * 0.90;
		}
		if (cantidadDisponible<10){
			descuento = precioBase*0.15 + precioBase;
		}
		if (cantidadDisponible==10){
			descuento = precioBase;
		}
		return descuento;
	}
	
	public Parte (String nTipo,int nCantidad, double nPrecioBase){
		tipoParte = nTipo;
		cantidadDisponible = nCantidad;
		precioBase = nPrecioBase;
	}
}
