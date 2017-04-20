package mundo;

import java.io.Serializable;

public abstract class Carro implements ICarro , Serializable {

	public final static String GASOLINA =  "Gasolina";
	public final static String DIESEL = "Diesel";
	public final static int CILINDRAJE_4X4 =  4;
	public final static int cilindraje_2x4 =  2;
	public final static String AUTOMATICA  = "Automatico";
	public final static String MANUAL = "Manual";
	public String identificacion, modeloAño, tipoCombustion, tipoTraccion, color,
	                 transmision, tipoTapiceria;
	public boolean aireAcondicionado;
	public int cilindraje;
	public ICarro siguiente;
	
	public Carro(String identificacion){
		
		this.identificacion = identificacion;
		siguiente = null;
	}

	
	public Carro(String identificacion,String modeloAño, String tipoCombustion, String tipoTraccion, String color, String transmision
			, String tipoTapiceria, boolean aireAcondicionado, int cilindraje)
	{
		this.identificacion = identificacion;
		this.modeloAño = modeloAño;
		this.tipoCombustion = tipoCombustion;
		this.tipoTraccion = tipoTraccion;
		this.color = color;
		this.transmision = transmision;
		this.tipoTapiceria = tipoTapiceria;
		this.aireAcondicionado = aireAcondicionado;
		this.cilindraje = cilindraje;
	}
	
	
//Get & set
	public String getIdentificacion() {
		return identificacion;
	}

	public String getModeloAño() {
		return modeloAño;
	}

	public void setModeloAño(String modeloAño) {
		this.modeloAño = modeloAño;
	}

	public String getTipoCombustion() {
		return tipoCombustion;
	}

	public void setTipoCombustion(String tipoCombustion) {
		this.tipoCombustion = tipoCombustion;
	}

	public String getTipoTraccion() {
		return tipoTraccion;
	}

	public void setTipoTraccion(String tipoTraccion) {
		this.tipoTraccion = tipoTraccion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public String getTipoTapiceria() {
		return tipoTapiceria;
	}

	public void setTipoTapiceria(String tipoTapiceria) {
		this.tipoTapiceria = tipoTapiceria;
	}

	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = 0;
		
		this.cilindraje = cilindraje;
	}
	
	public ICarro darSiguiente( )
	{
		return siguiente;
	}
	
	public void cambiarSiguiente(ICarro a)
	{
		siguiente = a;
	}
	
	public void verificarInvariantes (){ assert identificacion != null && !identificacion.equals(""): "la identificacion es vacia o nula"; assert modeloAño != null && !modeloAño.equals(""): "El modelo año es vacio o nulo"; assert tipoCombustion != null && !tipoCombustion.equals(""): "El tipo combustion es vacia o nula"; assert tipoTraccion != null && !tipoTraccion.equals(""): "tipo traccion es vacio o nulo"; assert color!= null && !color.equals(""): "El color es vacio o nulo"; assert transmision != null && !transmision.equals(""): "la trasnmision es vacio o nulo"; assert tipoTapiceria != null && !tipoTapiceria.equals(""): "el tipo tapiceria es vacio o nulo"; assert !String.valueOf(cilindraje).equals(""): "tipo traccion es vacio o nulo"; }
}
