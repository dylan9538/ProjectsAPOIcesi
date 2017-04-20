package interfaz;

import java.awt.BorderLayout;
import java.awt.JobAttributes;

import javax.swing.*;

import mundo.HunttheBat;

public class InterfazJuego extends JFrame {

	private  Panelbarra barra;
	private  PanelContador contador;
	private  PanelJuego hojajuego;

	private HunttheBat ju;

	// asociacion mundo

	public InterfazJuego() {

		ju = new HunttheBat();
		setTitle("Juego Murcielago");
		setSize(600, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setResizable(false);

		barra = new Panelbarra(this);
		setJMenuBar(barra);
		contador = new PanelContador();
		hojajuego = new PanelJuego(this);

		add(contador, BorderLayout.EAST);
		add(hojajuego, BorderLayout.CENTER);
		
		setVisible(true);

	}

	public void instrucciones() {
		JOptionPane
				.showMessageDialog(
						this,
						"Hunt The Bat”. El juego consiste en cazar pequeños murciélagos "
								+ "\n"
								+ "que aparecen en la pantalla. Existen dos tipos, los cuales se "
								+ "\n"
								+ "identifican por su color: negro y violeta. Cada uno de ellos se"
								+ "\n"
								+ "debe cazar de una forma diferente, el vampiro negro se caza dando "
								+ "\n"
								+ "un clic sobre él y el vampiro violeta se caza arrastrando el mouse "
								+ "\n" + "sobre él. ", "Instrucciones",
						JOptionPane.INFORMATION_MESSAGE);
	}

	public void refrescarGanadados() {

		String conta = String.valueOf(ju.darContadorGanados());
		contador.refrecarCazados(conta);

	}

	public void cambiarPosicionX() {
		ju.cambiarCoordenadaX();
		hojajuego.repaint();
	}

	public void refrescarPerdidos() {
		String conta2 = String.valueOf(ju.darContadorPerdidos());
		contador.refrecarPerdidos(conta2);
	}

	public boolean estaAdentro(int xe, int ye) {
		return ju.estaAdentro(xe, ye);
	}

	public void dispose() {
		super.dispose();
	}

	public void reiniciar() {
		
		contador.refrecarCazados("0");
		contador.refrecarPerdidos("0");

	}

	public int darPosicionX() {
		return ju.darPosicionX();
	}

	public int darPosicionY() {
		return ju.darPosicionY();
	}

	public String darQueEs() {
		ju.generarRandom();
		return ju.darQueEs();
	}

	public static void main(String[] args) {
		InterfazJuego ventana = new InterfazJuego();

		ventana.setVisible(true);

	}

	public HunttheBat getJu() {
		return ju;
	}

	public void setJu(HunttheBat ju) {
		this.ju = ju;
	}

	public Panelbarra getBarra() {
		return barra;
	}

	public void setBarra(Panelbarra barra) {
		this.barra = barra;
	}

	public PanelContador getContador() {
		return contador;
	}

	public void setContador(PanelContador contador) {
		this.contador = contador;
	}

	public PanelJuego getHojajuego() {
		return hojajuego;
	}

	public void setHojajuego(PanelJuego hojajuego) {
		this.hojajuego = hojajuego;
	}
	
	
	
}
