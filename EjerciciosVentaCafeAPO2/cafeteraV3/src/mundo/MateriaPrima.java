package mundo;

public class MateriaPrima {
	
	//----CONSTANTES----//
	
		public final static int MAX_AZU = 100;
		public final static int MAX_CAFE=450;
		public final static int MAX_VASOS=50;
		public final static int MAX_PITILLOS= 50;
		public final static int AGUA= 18900;
		
		//-----ATRIBUTOS-----//
		
		private int azucar;
		private int cafe;
		private int vasos;
		private int pitillos;
		private int agua;
		
		public Maquina maquina;
		
		
		//-----CONSTRUCTOR DE LA CLASE----//
		
		/**
		 *Metodo constructor de clase MateriaPrima 
		 */
		
		public MateriaPrima(){
			
			azucar= 0;
			cafe= 0;
			vasos= 0;
			pitillos= 0;
			agua= 0;
			
		}		
		//---- METODOS DAR Y CAMBIAR-----//
		
		
		
		/**
		 * 
		 * @return la cantidad de azucar que hay actualmente
		 */
		public int darAzucar(){
			return azucar;
		}
		
		/**
		 * 
		 * @return la cantidad de cafe que hay actualmente
		 */
		public int darCafe(){
			return cafe;
		}
		
		/**
		 * 
		 * @return la cantidad de vasos que retorna actualmente
		 */
		
		public int darVasos(){
			return vasos;
		}
		
		/**
		 * la cantidad de pitillos que hay actualmente
		 * @return
		 */

		public int darPitillos(){
			return pitillos;
		}
		
		/**
		 * 
		 * @return la cantidad de agua que tiene actualmente
		 */
		public int darAgua(){
			return agua;
		}
		
		/**
		 * 
		 * @param pAzucar
		 */
		
		public void cambiarAzucar(int pAzucar){
			azucar = pAzucar;
		}
		
		/**
		 * 
		 * @param pCafe
		 */
		
		public void cambiarCafe(int pCafe){
		
			cafe = pCafe;		
		}
		
		/**
		 * 
		 * @param pVasos
		 */
		
		public void cambiarVasos(int pVasos){
			vasos = pVasos;
		}
		
		/**
		 * 
		 * @param pPitillos
		 */
		
		public void cambiarPitillos(int pPitillos){
			pitillos= pPitillos;
		}
		
		/**
		 * 
		 * @param pAgua
		 */
		public void cambiarAgua(int pAgua){
			agua= pAgua;
		}

}
