package mundo;

public class CarroTradicional extends Carro{

	public CarroTradicional(String identificacion) {
		super(identificacion);
	}

	
	public CarroTradicional(String identificacion,String modeloAño, String tipoCombustion, String tipoTraccion, String color, String transmision
			, String tipoTapiceria, boolean aireAcondicionado, int cilindraje)
	{
		super(identificacion, modeloAño, tipoCombustion, tipoTraccion, color, transmision, tipoTapiceria, aireAcondicionado, cilindraje);
	}
	
	
}
