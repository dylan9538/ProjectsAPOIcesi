package mundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona implements Serializable {

	private ArrayList <CarroLujo> carros;
	
	//constructor
	public Cliente(String nombre, String apellido, String numeroId,
			String direccion, String telefono, String celular, String ciudad,
			String pais, String correo) {
		super(nombre, apellido, numeroId, direccion, telefono, celular, ciudad, pais,
				correo);
		
		carros = new ArrayList<CarroLujo>();
	}
	
	public void añadirCarro(CarroLujo carro)
	{
		carros.add(carro);
	}
	
	public ArrayList<CarroLujo> darCarros()
	{
		return carros;
	}
	
	public void verificarInvariantes(){ assert carros != null : ""; }
}
