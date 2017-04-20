package mundo;

import java.util.ArrayList;

public class Sucursal {

	private Sucursal siguiente;
	private ArrayList<ICarro> listaCarros;
	
	private String nombre;

	
	public Sucursal(String nombre) {
		this.nombre = nombre;
		listaCarros = new ArrayList<ICarro>();
	}
	
	public void agregarPedido(ICarro a) 
	{
		listaCarros.add(a);
	}
	
	public void cambiarSiguiente(Sucursal sucursal )
	{
		siguiente = sucursal;
	}
	
	public Sucursal darSiguiente()
	{
		return siguiente;
	}
	
	public ArrayList<ICarro> darListaCarros()
	{
		return listaCarros;
	}
	
	
	public String darNombre( )
	{
		return nombre;
	}
	
	 public void verificarInvariantes (){ assert listaCarros != null : ""; }
}
