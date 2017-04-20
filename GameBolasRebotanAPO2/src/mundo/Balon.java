package mundo;

import java.awt.Color;

public class Balon {
	public final static String IZQUIERDA = "IZQUIERDA"; 
	public final static String DERECHA   = "DERECHA"; 
	public final static String ARRIBA    = "ARRIBA"; 
	public final static String ABAJO     = "ABAJO";
	
	public final static int MOVIMIENTO = 1; //pixeles en cada movimiento
	
	private int diametro;
	private int posX;
	private int posY;
	private int espera;
	private String direccion;
	private int rebotes;
	private Color color;
	private boolean atrapado;
	
	public Balon(int d, int px, int py, int esp, String dir, int reb, boolean atr){
		diametro = d;
		posX = px;
		posY = py;
		espera = esp;
		direccion = dir;
		rebotes = reb;
		color = new Color(randColor(),randColor(),randColor());
		atrapado = atr;
	}
	
	private int randColor(){
		return (int)(Math.random()*256);
	}
	
	public int darDiametro(){
		return diametro;
	}
	
	public int darEspera(){
		return espera;
	}
	
	public int darRebotes(){
		return rebotes;
	}
	
	public int darPosX(){
		return posX;
	}
	
	public int darPosY(){
		return posY;
	}
	
	public Color darColor(){
		return color;
	}
	
	public boolean haSidoAtrapado(){
		return atrapado;
	}
	
	
	public String darDireccion() {
		return direccion;
	}

	public void cambiarDiametro(int diametro) {
		this.diametro = diametro;
	}

	public void cambiarPosX(int posX) {
		this.posX = posX;
	}

	public void cambiarPosY(int posY) {
		this.posY = posY;
	}

	public void cambiarEspera(int espera) {
		this.espera = espera;
	}

	public void cambiarDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void cambiarRebotes(int rebotes) {
		this.rebotes = rebotes;
	}

	public void cambiarColor(Color color) {
		this.color = color;
	}

	public void mover(int anchoActual, int altoActual){
		switch(direccion){
			case IZQUIERDA:
				posX -= MOVIMIENTO;
			break;
			case DERECHA:
				posX += MOVIMIENTO;
			break;
			case ARRIBA:
				posY -= MOVIMIENTO;
			break;
			case ABAJO:
				posY += MOVIMIENTO;
			break;
		}
		validarFueraDeCancha(anchoActual, altoActual);
	}

	private void validarFueraDeCancha(int anchoActual, int altoActual) {
		if(posX+diametro>anchoActual){
			direccion = IZQUIERDA;
			posX = anchoActual-diametro;
			rebotes++;
		}
		if(posX<0){
			direccion = DERECHA;
			posX=0;
			rebotes++;
		}
		if(posY+diametro>altoActual){
			direccion = ARRIBA;
			posY = altoActual-diametro;
			rebotes++;
		}
		if(posY<0){
			direccion = ABAJO;
			posY=0;
			rebotes++;
		}
	}
	
	public boolean atrapado(int x, int y){
		boolean estaAt = false;
		if(posX<=x && x<=posX+diametro && posY<=y && y<=posY+diametro){
			estaAt = true;
		}
		return estaAt;
	}
	
	public void cambiarAtrapado(boolean atr){
		atrapado = atr;
	}	
}
