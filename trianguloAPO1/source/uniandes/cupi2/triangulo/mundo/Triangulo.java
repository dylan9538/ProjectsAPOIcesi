/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n1_triangulo
 * Autor inicial: Pablo Barvo - Oct 20, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.triangulo.mundo;

/**
 * Tri�ngulo
 */
public class Triangulo
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	// -----------------------------------------------------------------
    // Relaciones
    // -----------------------------------------------------------------

    /**
     * Primer punto del tri�ngulo
     */
	private Punto punto1;

    /**
     * Segundo punto del tri�ngulo
     */
	
    private Punto punto2;
    
   	
    /**
     * Tercer punto del tri�ngulo
     */
	private Punto punto3; 

    /**
     * Color de las lineas
     */
    private Color colorLineas;

    /**
     * Color del relleno
     */
    private Color colorRelleno;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa el tri�ngulo
     * @param elPunto1 Punto 1 del tri�ngulo
     * @param elPunto2 Punto 2 del tri�ngulo
     * @param elPunto3 Punto 3 del tri�ngulo
     * @param relleno Color de relleno
     * @param lineas Color de las l�neas
     */
    public void inicializar( Punto elPunto1, Punto elPunto2, Punto elPunto3, Color relleno, Color lineas )
    {
        //Inicializa los puntos
        punto1 = elPunto1;
        punto2 = elPunto2;
        punto3 = elPunto3;

        //Inicializa los colores
        colorRelleno = relleno;
        colorLineas = lineas;
    }

    /**
     * Devuelve el punto 1 del tri�ngulo
     * @return Punto 1
     */
    public Punto darPunto1( )
    {
        return punto1;
    }

    /**
     * Devuelve el punto 2 del tri�ngulo
     * @return Punto 2
     */
    public Punto darPunto2( )
    {
        return punto2;
    }

    /**
     * Devuelve el punto 3 del tri�ngulo
     * @return Punto 3
     */
    public Punto darPunto3( )
    {
        return punto3;
    }

    /**
     * Devuelve el color de las l�neas del tri�ngulo
     * @return Color de las l�neas
     */
    public Color darColorLineas( )
    {
        return colorLineas;
    }

    /**
     * Devuelve el color del relleno del tri�ngulo
     * @return Color del relleno
     */
    public Color darColorRelleno( )
    {
        return colorRelleno;
    }

    /**
     * Devuelve el per�metro del tri�ngulo.
     * @return Per�metro del tri�ngulo
     */
    public double darPerimetro( )
    {
        //Devuelve la suma de todos los lados
    	return darLado1()+ darLado2()+ darLado3();
    	
    }
    

    /**
     * Devuelve el �rea del tri�ngulo, calculada utilizando la formula de Her�n: <br>
     * http://en.wikipedia.org/wiki/Heron's_formula
     * @return �rea del tri�ngulo
     */
    public double darArea( )
    {
        //Calcula el valor S para la formula
        double perimetro = darPerimetro( );
        double s = perimetro / 2;

        //Calcula las restas para cada uno de los lados
        double valorLado1 = s - darLado1( );
        double valorLado2 = s - darLado2( );
        double valorLado3 = s - darLado3( );

        //Calcula y devuelve el �rea
        // RaizCuadrada( s * (s - Lado1) * (s - Lado2) * (s - Lado3) )
        double area = Math.sqrt( s * valorLado1 * valorLado2 * valorLado3 );
        return area;
    }
 public double trasladarPunto1EnX( double valor){
	  
	 //obtengo valor actual de la cordenada x del punto 1
	 double xActual = punto1.darX();
			 //calculamos el nuevo valor de la cordenada x
	double xNuevo = valor + xActual;
	 
	//asignar nuevo valor a x
	 punto1.cambiarX(valor);
	 
	 //retornamos el valor de la nueva cordenada x
	 
	 return xNuevo;
			 
 }
                  
                
 
 /**
     * Calcula la altura del tri�ngulo, teniendo en cuenta como base la l�nea entre el punto 1 y 2.<br>
     * Tenga en cuenta que �rea = (Base * Altura) / 2
     * @return Altura del tri�ngulo
     */
    public double darAltura( )
    {

   double area= darArea();
   double base = darLado1();
   double altura= (area/base)*2;
   return altura;
    
    }

    /**
     * Calcula la distancia entre el punto 1 y 2
     * @return la distancia entre el punto 1 y el punto 2
     */
    private double darLado1( )
    {
        //Calcula las restas
        double valorX = Math.pow( punto1.darX( ) - punto2.darX( ), 2 );
        double valorY = Math.pow( punto1.darY( ) - punto2.darY( ), 2 );

        //calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 2 y 3
     * @return la distancia entre el punto 2 y 3
     */
    private double darLado2( )
    {
        //Calcula las restas
        double valorX = Math.pow( punto2.darX( ) - punto3.darX( ), 2 );
        double valorY = Math.pow( punto2.darY( ) - punto3.darY( ), 2 );

        //calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 3 y 1
     * @return la distancia entre el punto 3 y 1
     */
    private double darLado3( )
    {
        //Calcula las restas
        double valorX = Math.pow( punto3.darX( ) - punto1.darX( ), 2 );
        double valorY = Math.pow( punto3.darY( ) - punto1.darY( ), 2 );

        //calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     * 
     * @return respuesta1
     */
    public String metodo1( )
    {
    	double respuesta =trasladarPunto1EnX(0);
    	
    	
    	//1. declare una variable de tipo real
    	//2. asigne a la variable que acaba de declarar el resultado de llamar el m�todo trasladarPunto1EnX
    	//3. modifique el String que est� en la instrucci�n de retorno, cambielo por: 
    	//  "La coordenada x del punto 1 despu�s de ser tralsadado es: " + XXXX;
    	// cambie las XXXX por el nombre de la variable que declar� en el primer punto
        return "La coordenada x del punto 1 despues de ser tralsadado es: " + respuesta;
    }

    /**
     * M�todo para la extensi�n2
     * 
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "respuesta2";
    }

}
