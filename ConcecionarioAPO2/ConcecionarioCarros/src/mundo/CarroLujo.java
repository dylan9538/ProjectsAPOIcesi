package mundo;

import java.util.ArrayList;
import java.util.Date;

public class CarroLujo extends Carro {
	
	private ArrayList accesorios;
	private Date fechaEntrega;
	private String cedulaCliente;
	
	public CarroLujo (String identificacion,String cedulaCliente){
		super(identificacion);
		this.cedulaCliente = cedulaCliente;
	}
	
	public CarroLujo(String identificacion,String modeloA�o, String tipoCombustion, String tipoTraccion, String color, String transmision
			, String tipoTapiceria, boolean aireAcondicionado, int cilindraje, ArrayList accesorios)
	{
		super(identificacion, modeloA�o, tipoCombustion, tipoTraccion, color, transmision, tipoTapiceria, aireAcondicionado, cilindraje);
		this.accesorios = accesorios;
	}

	
	public ArrayList darAccesorios()
	{
		return accesorios;
	}
	
	public void cambiarAccesorios(ArrayList accesorios)
	{
		this.accesorios = accesorios;
	}
	
	public String darCedula()
	{
		return cedulaCliente;
	}
	
	public void verificarInvariantes(){ assert accesorios != null : ""; }
}
