package hilos;

import interfaz.InterfazJuegoBalones;
import mundo.Balon;

public class HiloBalon extends Thread {
	
	private InterfazJuegoBalones principal;
	private Balon balon;
	
	public HiloBalon(Balon balon, InterfazJuegoBalones principal){
		this.principal = principal;
		this.balon = balon;
	}
	
	
	public void mover(){
		
		int x = principal.darAnchoActual();
		int y = principal.darAltoActual();
		
		while(!(balon.haSidoAtrapado())){
			
				balon.mover(x, y);	
				long velo = (long) balon.darEspera();
				try {
					sleep(velo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				principal.refrescarCancha();
		}	
		
	
	}
	

	@Override
	public void run() {	
		mover();
	}

}
