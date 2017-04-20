package Mundo;

/**
 * Esta excepci�n se lanza cuando se presenta un error al leer o escribir el archivo con la informaci�n del estado del modelo del mundo. <br>
 * El mensaje asociado con la excepci�n debe describir el problema que se present�.
 */

/**
 * Construye la excepci�n con el mensaje que se pasa como par�metro y que describe la causa del problema
 * @param causa el mensaje que describe el problema
 */
public class PersistenciaException extends Exception
{
    // Constructor
    
    public PersistenciaException( String causa )
    {
        super( causa );
    }
}