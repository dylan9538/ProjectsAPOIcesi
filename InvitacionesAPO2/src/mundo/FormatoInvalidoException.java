package mundo;

@SuppressWarnings("serial")
public class FormatoInvalidoException extends Exception{
	private String nombreArchivo;
	private int numeroLineaPrimerError;
	
	public FormatoInvalidoException(String mensaje, String nomArch, int numeroLinea){
		super(mensaje);
		nombreArchivo = nomArch;
		numeroLineaPrimerError = numeroLinea;
	}

	public String darNombreArchivo() {
		return nombreArchivo;
	}

	public int darNumeroLineaPrimerError() {
		return numeroLineaPrimerError;
	}
}
