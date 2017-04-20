package Mundo;

import java.io.Serializable;

public class Personificacion implements Serializable {

	
	// CONSTANTES
	public static final String SEXO_FEMENINO = "Femenino";
	public static final String SEXO_MASCULINO = "Masculino";
	
	public static final String SOLTERO = "Soltero";
	public static final String CASADO = "Casado";
	public static final String VIUDO = "Viudo";
	public static final String RELACION ="Relación";
	public static final String DIVORCIADO = "Divorciado";
	
	public static final String PRIMARIA = "Primaria";
	public static final String SECUNDARIA = "Bachiller";
	public static final String TECNICO = "Tecnico";
	public static final String PROFESIONAL = "Profesional";
	
	public static final String EMPLEADO =  "Empleado";
	public static final String DESEMPLEADO = "Desempleado";
	
	public static final String RH_A_POSITIVO = "A+";
	public static final String RH_A_NEGATIVO = "A-";
	public static final String RH_O_POSITIVO = "O+";
	public static final String RH_O_NEGATIVO =" O-";
	public static final String RH_B_POSITIVO = "B+";
	public static final String RH_B_NEGATIVO = "B-";
	public static final String RH_NO_TIENE = "No tiene";
	
	
	// ATRIBUTOS
	
	private String nombreCompleto, identificacion, sexo, rh, residencia, telefono;
	private String fechaNacimiento;
	
	private String estadoCivil, nivelEducativo, profesion, estadoLaboral,cantidadHijos;
	
	
	private double salario;
	
	//CONSTRUCTOR
	
	public Personificacion(String nombreCompleto, String fechaNacimiento, String identificacion,
			String sexo, String rh, String residencia, String telefono, String estadoCivil, 
			String cantidadHijos, String nivelEducativo, String profesion,String estadoLaboral, double salario )
	{
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this. identificacion = identificacion;
		this.sexo = sexo;
		this.rh = rh;
		this.residencia = residencia;
		this.telefono = telefono;
		this.estadoCivil = estadoCivil;
		this.cantidadHijos = cantidadHijos;
		this.nivelEducativo = nivelEducativo;
		this.profesion = profesion;
		this.estadoLaboral = estadoLaboral;
		this.salario = salario;
		verificarInvariante();

	}

//METODOS DE DAR Y CAMBIAR
	
//..........
	public String darNombreCompleto() 
	{
		return nombreCompleto;
	}

	public void cambiarNombreCompleto(String nombreCompleto) 
	{
		this.nombreCompleto = nombreCompleto;
	}
//..........
	public String darFechaNacimiento()
	{
		return fechaNacimiento;
	}

	public void cambiarFechaNacimiento(String fechaNacimiento) 
	{
		this.fechaNacimiento = fechaNacimiento;
	}
//..........
	public String darIdentificacion() 
	{
		return identificacion;
		
	}
	public void cambiarIdentificacion(String identificacion) 
	{
		this.identificacion = identificacion;
	}
//..........
	public String darSexo() 
	{
		return sexo;
	}
	public void cambiarSexo(String sexo)
	{
		this.sexo = sexo;
	}
//..........
	public String darRh()
	{
		return rh;
	}

	public void cambiarRh(String rh)
	{
		this.rh = rh;
	}
//..........
	public String darResidencia() 
	{
		return residencia;
	}
	public void cambiarResidencia(String residencia) 
	{
		this.residencia = residencia;
	}
//..........
	public String darTelefono() 
	{
		return telefono;
	}
	public void cambiarTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
//..........
	public String darEstadoCivil()
	{
		return estadoCivil;
	}
	public void cambiarEstadoCivil(String estadoCivil) 
	{
		this.estadoCivil = estadoCivil;
	}
//..........
	public String darNivelEducativo()
	{
		return nivelEducativo;
	}
	public void cambiarNivelEducativo(String nivelEducativo) 
	{
		this.nivelEducativo = nivelEducativo;
	}
//..........
	public String darProfesion() 
	{
		return profesion;
	}
	public void cambiarProfesion(String profesion)
	{
		this.profesion = profesion;
	}
//..........
	public String darEstadoLaboral() 
	{
		return estadoLaboral;
	}
	public void cambiarEstadoLaboral(String estadoLaboral)
	{
		this.estadoLaboral = estadoLaboral;
	}
//..........
	public String darCantidadHijos() 
	{
		return cantidadHijos;
	}
	public void cambiarCantidadHijos(String cantidadHijos) 
	{
		this.cantidadHijos = cantidadHijos;
	}
//..........
	public double darSalario() 
	{
		return salario;
	}
	public void cambiarSalario(double salario) 
	{
		this.salario = salario;
	}

	
//Metodo comparar por rH	
	public int compararPorRH(Personificacion p)
	{
		return rh.compareTo(p.rh);
		}
	
//Metodo compara Fecha de nacimiento
	public int comparaFechaNacimiento(Personificacion p) 
	{
		
		String[] splitter1 = fechaNacimiento.split("-");
		String[] splitter =  p.darFechaNacimiento().split("-");
		if(splitter1[2].compareTo(splitter[2])==0)
		{
			if(splitter1[1].compareTo(splitter[1])==0)
			{
				return splitter1[0].compareTo(splitter[0]);
			}		
			else {
				return splitter1[1].compareTo(splitter[1]);
			}
		}
		else return splitter1[2].compareTo(splitter[2]);	
	}
	
//Metodo de comparar Por Hijos
  public int compararPorHijos(Personificacion p)
  {
	  return cantidadHijos.compareTo(p.darCantidadHijos());
  }

//Metodo toString que me retorna los datos de una personificacion
	
public String toString()
	{	
		return nombreCompleto +";"+fechaNacimiento+";"+ identificacion +";"+
	sexo+";"+rh+";"+residencia+";"+telefono+";"+estadoCivil+";"+cantidadHijos+";"+nivelEducativo
	+";"+profesion+";"+estadoLaboral+";"+salario +"\n";
	}
	
// invariantes
	
	public void verificarInvariante()
	{
		assert nombreCompleto != null &&  !nombreCompleto.equals(""): "el nombre es vacio o nulo";
		assert fechaNacimiento != null &&  !fechaNacimiento.equals(""): "La fecha de nacimiento es vacia o nula";
		assert identificacion != null &&  !identificacion.equals(""): "la uidentificacion  es vacia o nula";
		assert sexo != null &&  !sexo.equals(""): "el Sexoe es vacio o nulo";
		assert rh != null &&  !rh.equals(""): "el rh es vacio o nulo";
		assert residencia != null &&  !residencia.equals(""): "la residencia es vacia o nula";
		assert telefono != null &&  !telefono.equals(""): "el telefono es vacio o nulo";
		assert estadoCivil!= null &&  !estadoCivil.equals(""): "el estado civil es vacio o nulo";
		assert cantidadHijos != null &&  !cantidadHijos.equals(""): "la cantidad de hijos es vacio o nulo";
		assert nivelEducativo != null &&  !nivelEducativo.equals(""): "el nivel educativo es vacio o nulo";
		assert profesion != null &&  !profesion.equals(""): "la profesion es vacio o nulo";
		assert estadoLaboral != null &&  !estadoLaboral.equals(""): "el estado laboral es vacio o nulo";
		assert !String.valueOf(salario).equals("")&& salario!=0: "el salario es vacio o nulo";
	}
	
}
