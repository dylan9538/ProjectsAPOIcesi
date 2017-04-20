package mundo;

public class CafeIncompletoException extends Exception {

	private String recursoAgotado = "";

public CafeIncompletoException(String recursoA) {
	recursoAgotado =  recursoA;
		
  }

public String getRecursoAgotado() {
	return recursoAgotado;

 }
}
