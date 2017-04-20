package Mundo;

/**
 * Esta excepción se lanza cuando se presenta un error al leer o escribir el archivo con la información del estado del modelo del mundo. <br>
 * El mensaje asociado con la excepción debe describir el problema que se presentó.
 */

/**
 * Construye la excepción con el mensaje que se pasa como parámetro y que describe la causa del problema
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