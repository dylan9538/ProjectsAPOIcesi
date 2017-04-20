package Mundo;

/**
 * Extension de la clase 'Exception'.
 *
 * @author JorgeAndres. Created 23/01/2016.
 */
@SuppressWarnings("serial")
public class MiPropiaExepcion extends Exception {

	/**
	 * Metodo constructor de la clase 'MiProppiaExepcion'.
	 *
	 * @param causa
	 */
	public MiPropiaExepcion(String causa) {
		super(causa);
	}

}
