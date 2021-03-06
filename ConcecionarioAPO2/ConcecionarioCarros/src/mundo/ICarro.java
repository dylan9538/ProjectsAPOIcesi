package mundo;

public interface ICarro {

	
	public String getIdentificacion();

	public String getModeloAņo();

	public void setModeloAņo(String modeloAņo);

	public String getTipoCombustion();

	public void setTipoCombustion(String tipoCombustion);

	public String getTipoTraccion();

	public void setTipoTraccion(String tipoTraccion);

	public String getColor();

	public void setColor(String color);

	public String getTransmision();

	public void setTransmision(String transmision);

	public String getTipoTapiceria();

	public void setTipoTapiceria(String tipoTapiceria);

	public boolean isAireAcondicionado();

	public void setAireAcondicionado(boolean aireAcondicionado);

	public int getCilindraje();

	public void setCilindraje(int cilindraje);
	
	public ICarro darSiguiente();
	
	public void cambiarSiguiente(ICarro a);
	
}
