package icesi.ventabebidas.interfaz;

import icesi.ventabebidas.mundo.VentaDeBebidas;

import javax.swing.*;
import java.awt.*;

public class InterfazBebidas extends JFrame {

	private VentaDeBebidas ventaBebidas;
	private PanelEncabezado banner;
	private PanelVentaBebidaUno bebidaUno;
	private PanelVentaBebidaDos bebidaDos;
	private PanelReportes reportes;

	public InterfazBebidas() {

		ventaBebidas= new VentaDeBebidas();
		
		setTitle("Venta de Refrescos");
		setSize(610, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		banner = new PanelEncabezado();
		add(banner, BorderLayout.NORTH);

		bebidaUno = new PanelVentaBebidaUno(this);
		add(bebidaUno, BorderLayout.WEST);

		bebidaDos = new PanelVentaBebidaDos(this);
		add(bebidaDos, BorderLayout.EAST);

		reportes = new PanelReportes();
		add(reportes, BorderLayout.CENTER);

	}

	public void gestionarVenta1VasoBebidaUno() {
		

			String numero = bebidaUno.darCostoVaso();
			double valor = Double.parseDouble(numero);
			
			ventaBebidas.registrarVenta(VentaDeBebidas.NOMBRE_BEBIDA_UNO, 1, valor);
               
			double total = ventaBebidas.calcularTotalVentasPorBebida(VentaDeBebidas.NOMBRE_BEBIDA_UNO);
			reportes.refrescarVentasBebidaUno(total);
			
	     String mayorVenta = ventaBebidas.calcularBebidaMayoresVentas();
	     reportes.refrescarBebidaConMasVentas(mayorVenta);
	     
	     String mayorVasos = ventaBebidas.calcularMayorCantidadVasosEn1Venta();
	     reportes.refrescarMayorVasosEn1Venta(mayorVasos);
	     
	     String mayorTransa = ventaBebidas.calcularMayorCantidadTransacciones();
	     reportes.refrescarMayorTransacciones(mayorTransa);

	}

	public void gestionarVentaVariosVasosBebidaUno() {

		String numero = bebidaUno.darCantidadVasos();
		String valor = bebidaUno.darCostoVaso();
		
		int vasos = Integer.parseInt(numero);
		double valorReal = Double.parseDouble(valor);
		
		ventaBebidas.registrarVenta(VentaDeBebidas.NOMBRE_BEBIDA_UNO,vasos, valorReal);
		
		double total = ventaBebidas.calcularTotalVentasPorBebida(VentaDeBebidas.NOMBRE_BEBIDA_UNO);
		
		reportes.refrescarVentasBebidaUno(total);
		
		 String mayorVenta = ventaBebidas.calcularBebidaMayoresVentas();
	     reportes.refrescarBebidaConMasVentas(mayorVenta);
	     
	     String mayorVasos = ventaBebidas.calcularMayorCantidadVasosEn1Venta();
	     reportes.refrescarMayorVasosEn1Venta(mayorVasos);
	     
	     String mayorTransa = ventaBebidas.calcularMayorCantidadTransacciones();
	     reportes.refrescarMayorTransacciones(mayorTransa);
		
		
		
	}
	
	public void gestionarVenta1VasoBebidaDos() {
		

		String numero = bebidaDos.darCostoVaso();
		double valor = Double.parseDouble(numero);
		
		ventaBebidas.registrarVenta(VentaDeBebidas.NOMBRE_BEBIDA_DOS, 1, valor);
           
		double total = ventaBebidas.calcularTotalVentasPorBebida(VentaDeBebidas.NOMBRE_BEBIDA_DOS);
		
		reportes.refrescarVentasBebidaDos(total);
		
		 String mayorVenta = ventaBebidas.calcularBebidaMayoresVentas();
	     reportes.refrescarBebidaConMasVentas(mayorVenta);
	     
	     String mayorVasos = ventaBebidas.calcularMayorCantidadVasosEn1Venta();
	     reportes.refrescarMayorVasosEn1Venta(mayorVasos);
	     
	     String mayorTransa = ventaBebidas.calcularMayorCantidadTransacciones();
	     reportes.refrescarMayorTransacciones(mayorTransa);
     

}

public void gestionarVentaVariosVasosBebidaDos() {

	String numero = bebidaDos.darCantidadVasos();
	String valor = bebidaDos.darCostoVaso();
	
	int vasos = Integer.parseInt(numero);
	double valorReal = Double.parseDouble(valor);
	
	ventaBebidas.registrarVenta(VentaDeBebidas.NOMBRE_BEBIDA_DOS,vasos, valorReal);
	
	double total = ventaBebidas.calcularTotalVentasPorBebida(VentaDeBebidas.NOMBRE_BEBIDA_DOS);
	
	reportes.refrescarVentasBebidaDos(total);
	
	 String mayorVenta = ventaBebidas.calcularBebidaMayoresVentas();
     reportes.refrescarBebidaConMasVentas(mayorVenta);
     
     String mayorVasos = ventaBebidas.calcularMayorCantidadVasosEn1Venta();
     reportes.refrescarMayorVasosEn1Venta(mayorVasos);
     
     String mayorTransa = ventaBebidas.calcularMayorCantidadTransacciones();
     reportes.refrescarMayorTransacciones(mayorTransa);
	
	
	
}


	public static void main(String[] args) {
		InterfazBebidas contc = new InterfazBebidas();
		contc.setVisible(true);
	}

}
