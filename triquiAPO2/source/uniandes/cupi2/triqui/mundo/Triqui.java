/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Triqui.java,v 1.6 2005/12/02 12:26:03 pa-barvo Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Triqui
 * Autor inicial: Katalina Marcos
 * Modificación: Jorge Jiménez- Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.triqui.mundo;

/**
 * Tablero del Triqui
 */
public class Triqui
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    /**
     * Marca para el jugador humano
     */
    public final static String MARCA_JUGADOR = "X";

    /**
     * Marca para el jugador PC
     */
    public final static String MARCA_PC = "O";

    /**
     * Casilla superior izquierda del triqui
     */
    final public static int SUPERIOR_IZQUIERDA = 1;
    /**
     * Casilla superior central del triqui
     */
    final public static int SUPERIOR_CENTRO = 2;
    /**
     * Casilla superior derecha del triqui
     */
    final public static int SUPERIOR_DERECHA = 3;
    /**
     * Casilla media izquierda del triqui
     */
    final public static int MEDIO_IZQUIERDA = 4;
    /**
     * Casilla media central del triqui
     */
    final public static int MEDIO_CENTRO = 5;
    /**
     * Casilla media derecha del triqui
     */
    final public static int MEDIO_DERECHA = 6;
    /**
     * Casilla inferior izquierda del triqui
     */
    final public static int INFERIOR_IZQUIERDA = 7;
    /**
     * Casilla inferior central del triqui
     */
    final public static int INFERIOR_CENTRO = 8;
    /**
     * Casilla inferior derecha del triqui
     */
    final public static int INFERIOR_DERECHA = 9;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Casilla 1
     */
    private Casilla casilla1;
    /**
     * Casilla 2
     */
    private Casilla casilla2;
    /**
     * Casilla 3
     */
    private Casilla casilla3;
    /**
     * Casilla 4
     */
    private Casilla casilla4;
    /**
     * Casilla 5
     */
    private Casilla casilla5;
    /**
     * Casilla 6
     */
    private Casilla casilla6;
    /**
     * Casilla 7
     */
    private Casilla casilla7;
    /**
     * Casilla 8
     */
    private Casilla casilla8;
    /**
     * Casilla 9
     */
    private Casilla casilla9;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el tablero del triqui preparando todas las casillas
     */
    public Triqui( )
    {
        casilla1 = new Casilla( );
        casilla2 = new Casilla( );
        casilla3 = new Casilla( );
        casilla4 = new Casilla( );
        casilla5 = new Casilla( );
        casilla6 = new Casilla( );
        casilla7 = new Casilla( );
        casilla8 = new Casilla( );
        casilla9 = new Casilla( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Asigna una marca a una de las casillas del tablero. Las casillas se numeran del 1 al 9 empezando por la fila superior y de izquierda a derecha. <br>
     * <b>post: </b> La casilla ingresada tiene asignada la marca que llegó como parámetro. <br>
     * @param casilla Número de la casilla. 1 <= casilla <= 9
     * @param marca Marca por asignar a la casilla. marca != null y marca != "".
     */
    public void marcarCasilla( int casilla, String marca )
    {
        switch( casilla )
        {
            case SUPERIOR_IZQUIERDA:
                casilla1.asignarMarca( marca );
                break;
            case SUPERIOR_CENTRO:
                casilla2.asignarMarca( marca );
                break;
            case SUPERIOR_DERECHA:
                casilla3.asignarMarca( marca );
                break;
            case MEDIO_IZQUIERDA:
                casilla4.asignarMarca( marca );
                break;
            case MEDIO_CENTRO:
                casilla5.asignarMarca( marca );
                break;
            case MEDIO_DERECHA:
                casilla6.asignarMarca( marca );
                break;
            case INFERIOR_IZQUIERDA:
                casilla7.asignarMarca( marca );
                break;
            case INFERIOR_CENTRO:
                casilla8.asignarMarca( marca );
                break;
            case INFERIOR_DERECHA:
                casilla9.asignarMarca( marca );
        }
    }
    /**
     * Retorna la marca asignada a una casilla del tablero. <br>
     * @param casilla Número de la casilla. 1 <= casilla <= 9.
     * @return marca Marca de la casilla. marca en la casilla.
     */
    public String obtenerMarcaCasilla( int casilla )
    {
        switch( casilla )
        {
            case SUPERIOR_IZQUIERDA:
                return casilla1.obtenerMarca( );
            case SUPERIOR_CENTRO:
                return casilla2.obtenerMarca( );
            case SUPERIOR_DERECHA:
                return casilla3.obtenerMarca( );
            case MEDIO_IZQUIERDA:
                return casilla4.obtenerMarca( );
            case MEDIO_CENTRO:
                return casilla5.obtenerMarca( );
            case MEDIO_DERECHA:
                return casilla6.obtenerMarca( );
            case INFERIOR_IZQUIERDA:
                return casilla7.obtenerMarca( );
            case INFERIOR_CENTRO:
                return casilla8.obtenerMarca( );
            case INFERIOR_DERECHA:
                return casilla9.obtenerMarca( );
            default:
                return Casilla.CASILLA_VACIA;
        }
    }

    /**
     * Indica si la diagonal principal (de la casilla superior izquierda a la inferior derecha) está llena para un jugador. <br>
     * @param marcaJugador Marca a buscar. marcaJugador != null.
     * @return true si todas las casillas de la diagonal tienen la marca del jugador, false en caso contrario.
     */
    public boolean diagonalPrincipalLlena( String marcaJugador )
    {
        boolean contiene = false;
        if( casilla1.contieneMarca( marcaJugador ) && casilla5.contieneMarca( marcaJugador ) && casilla9.contieneMarca( marcaJugador ) )
            contiene = true;

        return contiene;
    }

    /**
     * Indica si la diagonal secundaria (de la casilla superior derecha a la inferior izquierda) está llena para un jugador. <br>
     * @param marcaJugador Marca a buscar. marcaJugador != null.
     * @return true si todas las casillas de la diagonal tienen la marca del jugador, false en caso contrario.
     */
    public boolean diagonalSecundariaLlena( String marcaJugador )
    {
        boolean contiene = false;
        if( casilla3.contieneMarca( marcaJugador ) && casilla5.contieneMarca( marcaJugador ) && casilla7.contieneMarca( marcaJugador ) )
            contiene = true;

        return contiene;
    }

    /**
     * Indica si la fila superior está llena para un jugador. <br>
     * @param marcaJugador Marca a buscar. marcaJugador != null.
     * @return true si todas las casillas de la fila tienen la marca del jugador, false en caso contrario.
     */
    public boolean filaSuperiorLlena( String marcaJugador )
    {
        boolean contiene = false;
        if( casilla1.contieneMarca( marcaJugador ) && casilla2.contieneMarca( marcaJugador ) && casilla3.contieneMarca( marcaJugador ) )
            contiene = true;

        return contiene;
    }

    /**
     * Indica si la fila media está llena para un jugador. <br>
     * @param marcaJugador Marca a buscar. marcaJugador !=null.
     * @return true si todas las casillas de la fila tienen la marca del jugador, false en caso contrario.
     */
    public boolean filaMediaLlena( String marcaJugador )
    {
        boolean contiene = false;
        if( casilla4.contieneMarca( marcaJugador ) && casilla5.contieneMarca( marcaJugador ) && casilla6.contieneMarca( marcaJugador ) )
            contiene = true;

        return contiene;
    }

    /**
     * Indica si la fila media está llena para un jugador. <br>
     * @param marcaJugador Marca a buscar. marcaJugador != null.
     * @return true si todas las casillas de la fila tienen la marca del jugador, false en caso contrario.
     */
    public boolean filaInferiorLlena( String marcaJugador )
    {
        boolean contiene = false;
        if( casilla7.contieneMarca( marcaJugador ) && casilla8.contieneMarca( marcaJugador ) && casilla9.contieneMarca( marcaJugador ) )
            contiene = true;

        return contiene;
    }

    /**
     * Indica si la columna izquierda está llena para un jugador. <br>
     * @param marcaJugador Marca a buscar. marcaJugador != null.
     * @return true si todas las casillas de la columna tienen la marca del jugador, false en caso contrario.
     */
    public boolean columnaIzquierdaLlena( String marcaJugador )
    {
        boolean contiene = false;
        if( casilla1.contieneMarca( marcaJugador ) && casilla4.contieneMarca( marcaJugador ) && casilla7.contieneMarca( marcaJugador ) )
            contiene = true;

        return contiene;
    }

    /**
     * Indica si la columna central está llena para un jugador. <br>
     * @param marcaJugador. Marca a buscar. marcaJugador != null.
     * @return true si todas las casillas de la columna tienen la marca del jugador, false en caso contrario.
     */
    public boolean columnaCentralLlena( String marcaJugador )
    {
        boolean contiene = false;
        if( casilla2.contieneMarca( marcaJugador ) && casilla5.contieneMarca( marcaJugador ) && casilla8.contieneMarca( marcaJugador ) )
            contiene = true;

        return contiene;
    }

    /**
     * Indica si la columna derecha está llena para un jugador. <br>
     * @param marcaJugador Marca a buscar - marcaJugador != null.
     * @return true si todas las casillas de la columna tienen la marca del jugador, false en caso contrario.
     */
    public boolean columnaDerechaLlena( String marcaJugador )
    {
        boolean contiene = false;
        if( casilla3.contieneMarca( marcaJugador ) && casilla6.contieneMarca( marcaJugador ) && casilla9.contieneMarca( marcaJugador ) )
            contiene = true;

        return contiene;
    }

    /**
     * Indica si una casilla está vacía o no. Las casillas se numeran del 1 al 9 empezando por la fila superior y de izquierda a derecha. <br>
     * @param casilla Número que representa la casilla. 1 < casilla < 9.
     * @return true si la casilla está vacía, false si no lo está.
     */
    public boolean casillaVacia( int casilla )
    {
        switch( casilla )
        {
            case SUPERIOR_IZQUIERDA:
                return casilla1.estaVacia( );
            case SUPERIOR_CENTRO:
                return casilla2.estaVacia( );
            case SUPERIOR_DERECHA:
                return casilla3.estaVacia( );
            case MEDIO_IZQUIERDA:
                return casilla4.estaVacia( );
            case MEDIO_CENTRO:
                return casilla5.estaVacia( );
            case MEDIO_DERECHA:
                return casilla6.estaVacia( );
            case INFERIOR_IZQUIERDA:
                return casilla7.estaVacia( );
            case INFERIOR_CENTRO:
                return casilla8.estaVacia( );
            case INFERIOR_DERECHA:
                return casilla9.estaVacia( );
            default:
                return false;
        }
    }

    /**
     * Informa si el tablero está lleno, es decir que tiene todas las casillas marcadas. <br>
     * @return true si el tablero está lleno, false si no lo está.
     */
    public boolean tableroLleno( )
    {
        boolean estaLleno = ! ( casilla1.estaVacia( ) || casilla2.estaVacia( ) || casilla3.estaVacia( ) || casilla4.estaVacia( ) || casilla5.estaVacia( ) || casilla6.estaVacia( ) || casilla7.estaVacia( ) || casilla8.estaVacia( ) || casilla9
                .estaVacia( ) );
        return estaLleno;
    }

    /**
     * Indica si un jugador (según su marca) ganó el juego. Gana quien complete las casillas de alguna diagonal o fila o columna con su marca. <br>
     * @param marca Marca del jugador actual (O,X), marca != null y marca != "".
     * @return true si el jugador actual ganó el juego, false en caso contrario.
     */
    public boolean ganoJuego( String marca )
    {
        boolean gano = ( diagonalPrincipalLlena( marca ) || diagonalSecundariaLlena( marca ) || filaSuperiorLlena( marca ) || filaMediaLlena( marca ) || filaInferiorLlena( marca ) || columnaIzquierdaLlena( marca ) || columnaCentralLlena( marca ) || columnaDerechaLlena( marca ) );
        return gano;

    }

    /**
     * Limpia todas las marcas en las casillas del tablero. <br>
     * <b>post: </b> Se limpian todas las casillas de marcas. <br>
     */
    public void limpiarTablero( )
    {
        casilla1.limpiar( );
        casilla2.limpiar( );
        casilla3.limpiar( );
        casilla4.limpiar( );
        casilla5.limpiar( );
        casilla6.limpiar( );
        casilla7.limpiar( );
        casilla8.limpiar( );
        casilla9.limpiar( );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método 1 de extensión al ejemplo
     * @return respuesta 1
     */

    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método 2 de extensión al ejemplo
     * @return respuesta
     */

    public String metodo2( )
    {
        return "Respuesta 2";
    }
}