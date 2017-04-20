package mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;


public class Concecionario {

	public final static String UNO ="1";
	public final static String DOS ="2";
	public final static String TRES ="3";
	public final static String CUATRO ="4";
	
	
	private ArrayList <Cliente> clientes;
	private ArrayList <Empleado>  empleados;
	private Sucursal primera;
	private Sucursal seleccionada;
	private ArrayList <Accesorios> accesorios;
	private ArrayList <ICarro>  carrosAtributos;
	private ICarro primeroVender;
	
	private String rutaArchivo;
	
	
	public Concecionario(String ruta )
	
	{
	    rutaArchivo = ruta;
		clientes = new ArrayList<>();
		empleados = new ArrayList<>();
		accesorios = new ArrayList<>();
		inicializarSucursales();
		carrosAtributos = new ArrayList<>();
		seleccionada = null;
		primeroVender = null;
	}
	
	private void inicializarSucursales( )
	{
		primera = new Sucursal(UNO);
		primera.cambiarSiguiente(new Sucursal(DOS));
		primera.darSiguiente().cambiarSiguiente(new Sucursal(TRES));
		primera.darSiguiente().darSiguiente().cambiarSiguiente(new Sucursal(CUATRO));
	}
//--------------------------	
	public boolean registrarCliente(String nombre, String apellido, String numeroId,
			String direccion, String telefono, String celular, String ciudad,
			String pais, String correo )
	{
		boolean registro = false;
		
		Cliente cliente = new Cliente(nombre, apellido, numeroId, direccion, telefono, celular, ciudad, pais, correo);
		if(!verificarCedulaPersona(numeroId))
		{
			clientes.add(cliente);	
			
			registro = true;
		}
		
		
		return registro;
	}
	
	public boolean registrarEmpleado(String nombre, String apellido, String numeroId,
			String direccion, String telefono, String celular, String ciudad,
			String pais, String correo,String numeroCuenta, String tipoContrato, String cargo)
	{
		boolean registro = false;
		
			Empleado empleado = new Empleado(nombre, apellido, numeroId, direccion, telefono, celular, ciudad, pais, correo,
					        numeroCuenta, tipoContrato, cargo);
		
			if(!verificarCedulaPersona(numeroId))
		{
			empleados.add(empleado);
			registro = true;
		}
		return registro;
	}
	//----------------------------
	private boolean verificarCedulaPersona(String cedula)
	{
		boolean esta = false;
		
		Iterator iter = clientes.iterator();
		
		while(iter.hasNext())
		{
			Cliente cliente = (Cliente) iter.next();
			
			if(cliente.getNumeroId().equals(cedula))
			{
				esta = true;
			}
		}
		
        boolean esta1 = false;
		
		Iterator iterador = empleados.iterator();
		while(iterador.hasNext())
		{
			Empleado e = (Empleado) iterador.next();
			
			if(e.getNumeroId().equals(cedula))
			{
				esta1 = true;
			}
		}
		
		return (esta||esta1);
	}
	
	
	public void registrarAccesorio(String nombre,String descripcion, String codigo, String restricciones, int costo){
		
		accesorios.add(new Accesorios(nombre,descripcion, codigo, restricciones, costo));
	}
	
	public void realizarPedidoTradicional(String tipoCombustion, String tipoTraccion, String color, String transmision
			, String tipoTapiceria, boolean aireAcondicionado, int cilindraje)
	{	
		String identificacion = generarCodigo();
		
		int modeloAño = Calendar.YEAR;
		
		ICarro b = new CarroTradicional(identificacion, String.valueOf(modeloAño), tipoCombustion, tipoTraccion, color, transmision, tipoTapiceria, 
				aireAcondicionado, cilindraje);
		
		carrosAtributos.add(b);
		
		ICarro a = new CarroTradicional(identificacion);
		primera.agregarPedido(a);

	}
	
	
	public void realizarPedidoLujo(String tipoCombustion, String tipoTraccion, String color, String transmision
			, String tipoTapiceria, boolean aireAcondicionado, int cilindraje, ArrayList accesorios, String cedulaCliente)
	{
        
		String identificacion = generarCodigo();
		
		int modeloA = Calendar.YEAR;
		
		ICarro b = new CarroLujo(identificacion, String.valueOf(modeloA), tipoCombustion, tipoTraccion, color, transmision, tipoTapiceria, 
				aireAcondicionado, cilindraje, accesorios);
		
		carrosAtributos.add(b);
	
		ICarro a = new CarroLujo(identificacion,cedulaCliente);
		primera.agregarPedido(a);

		
	}
	
	private String generarCodigo( )
	{ 
		return "A" + (carrosAtributos.size()+1);
	}
	
	public boolean promover()
	{
		boolean hecho = false;
		
		if(seleccionada.darNombre().equals(UNO))
		{
			if(primera.darListaCarros().size()>0)
			{
				ICarro carro = primera.darListaCarros().get(0);
				 
				 primera.darListaCarros().remove(0);
				 
				 primera.darSiguiente().agregarPedido(carro);
				 
				 hecho = true;
			}	 
		}
		
		else if(seleccionada.darNombre().equals(DOS)){
			Sucursal segunda = primera.darSiguiente();
			
			if(segunda.darListaCarros().size()>0)
			{

				ICarro carro = segunda.darListaCarros().get(0);
				
				if(carro instanceof CarroTradicional)
				{
					ICarro atributo = darCarroBuscado(carro.getIdentificacion());
					carro.setCilindraje(atributo.getCilindraje());
					carro.setAireAcondicionado(atributo.isAireAcondicionado());
				    carro.setTipoCombustion(atributo.getTipoCombustion());
					carro.setTipoTraccion(atributo.getTipoTraccion());
					carro.setTransmision(atributo.getTransmision());
					
					segunda.darListaCarros().remove(0);
					
					segunda.darSiguiente().agregarPedido(carro);
					
					hecho = true;
					
				}
				//-.------------------------------
				if(carro instanceof CarroLujo)
				{
					ICarro atributo = darCarroBuscado(carro.getIdentificacion());
					carro.setCilindraje(atributo.getCilindraje());
					carro.setAireAcondicionado(atributo.isAireAcondicionado());
				    carro.setTipoCombustion(atributo.getTipoCombustion());
					carro.setTipoTraccion(atributo.getTipoTraccion());
					carro.setTransmision(atributo.getTransmision());
					
					CarroLujo carrito = (CarroLujo) carro;
					
					CarroLujo atributo2 = (CarroLujo) atributo;
					
					carrito.cambiarAccesorios(atributo2.darAccesorios());
					
					segunda.darListaCarros().remove(0);
					
					segunda.darSiguiente().agregarPedido(carro);
					
					hecho = true;
					
				}
				
			}
			
		}
		
		else if(seleccionada.darNombre().equals(TRES))
		{
			Sucursal tercera = primera.darSiguiente().darSiguiente();
			
			if(tercera.darListaCarros().size()>0)
			{
				ICarro carro = tercera.darListaCarros().get(0);
				
				if(carro instanceof CarroTradicional)
				{
					ICarro atributo = darCarroBuscado(carro.getIdentificacion());
					
					carro.setColor(atributo.getColor());
					carro.setTipoTapiceria(atributo.getTipoTapiceria());
					
					tercera.darListaCarros().remove(0);
					tercera.darSiguiente().agregarPedido(carro);
					
					hecho = true;
				}
				
				if(carro instanceof CarroLujo)
				{
					ICarro atributo = darCarroBuscado(carro.getIdentificacion());
					
					carro.setColor(atributo.getColor());
					carro.setTipoTapiceria(atributo.getTipoTapiceria());
					
					
					
					tercera.darListaCarros().remove(0);				
					tercera.darSiguiente().agregarPedido(carro);
		
					hecho = true;
				}
			}
		}
		
		else
		{
			Sucursal cuarta = primera.darSiguiente().darSiguiente().darSiguiente();
			if(cuarta.darListaCarros().size()>0){
				ICarro carro = cuarta.darListaCarros().get(0);
				
				if(carro instanceof CarroLujo){
					CarroLujo lujo = (CarroLujo) carro;
					cuarta.darListaCarros().remove(0);
					eliminarCarro(carro.getIdentificacion());
					Cliente cliente = darClienteBuscado(lujo.darCedula());
					
					cliente.añadirCarro(lujo);
					
					hecho = true;
				}
				
				else{
					cuarta.darListaCarros().remove(0);
					eliminarCarro(carro.getIdentificacion());
					agregarListaCarrosParaVender(carro);	
					hecho = true;	
				}
				
			}
		}
		return hecho;
	}
	
	private Cliente darClienteBuscado(String cedula){
		
		boolean encontro = false;
		Cliente cliente = null;
		for(int i = 0; i< clientes.size()&&!encontro;i++){
			if(clientes.get(i).getNumeroId().equals(cedula)){
				cliente = clientes.get(i);
				encontro = true;
			}
		}
		return cliente;
	}
	
	public void agregarListaCarrosParaVender(ICarro carro){
		
		if(primeroVender == null){
			primeroVender = carro;
		}
		else
		{
			ICarro actual = primeroVender;
			
			while(actual.darSiguiente()!= null)
			{
				actual = actual.darSiguiente();
			}
			
			actual.cambiarSiguiente(carro);
		}
	}
	
	public String darListaCarrosListoVender( )
	{
		String cadena = "Aun no hay carros listos para vender";
		
		if(primeroVender!= null){
			
			cadena = "La lista de carros listos para vender es: " + "\n";
			
			ICarro a = primeroVender;
			
			while(a != null){
				if(a instanceof CarroTradicional){
					
					cadena += "Carro: " + a.getIdentificacion() + ";" + a.getTipoCombustion() + ";" + a.getCilindraje() + ";" + 
							a.getTipoTraccion() + ";" + a.getTransmision() + ";" + a.isAireAcondicionado() + ";" + a.getColor()
							+ ";" + a.getTipoTapiceria() + "\n";		
					a = a.darSiguiente();
				}
			}
		}
		return cadena;
	}
	
	private void eliminarCarro(String codigo)
	{
		boolean encontro = false;
		int index = 0;
		
		for(int i = 0; i< carrosAtributos.size() && !encontro; i++)
		{
			if(codigo.equals(carrosAtributos.get(i).getIdentificacion())){
				
				index = i;
				encontro = true;		
			}
		}	
		carrosAtributos.remove(index);
	}
	
	private ICarro darCarroBuscado(String codigo)
	{
		boolean encontro = false;
		ICarro buscado = null;
		for(int i = 0; i< carrosAtributos.size() && !encontro;i++)
		{
			if(codigo.equals(carrosAtributos.get(i).getIdentificacion()))
			{
				buscado = carrosAtributos.get(i);
				encontro = true;
			}
		}
		
		return buscado;
	}
	
	public String verListaCarros(){
		String cadena = "No Hay Lista de carros";
			
			if(seleccionada.darListaCarros().size()>0){
				cadena = "La lista de carros es: " + "\n";
			}
			
			for(int i=0; i< seleccionada.darListaCarros().size(); i++){
				
				ICarro a = seleccionada.darListaCarros().get(i);
				
				if(seleccionada == primera.darSiguiente().darSiguiente()){
					
					if(a instanceof CarroLujo){
						
						CarroLujo b =(CarroLujo) a;
						
						String accesorios = "";
						
						for(int j = 0; j< b.darAccesorios().size(); j++)
						{
							if(j>=1){
								if(b.darAccesorios().get(j) instanceof Accesorios)
								{
									Accesorios c = (Accesorios) b.darAccesorios().get(j);
									accesorios += "-" + c.getNombre();
								}
								
								else{
									String d = (String) b.darAccesorios().get(j);
									accesorios += "-" + d;
								}
							}
							else{
								if(b.darAccesorios().get(j) instanceof Accesorios)
								{
									Accesorios c = (Accesorios) b.darAccesorios().get(j);
									accesorios += c.getNombre();
								}
								
								else{
									String d = (String) b.darAccesorios().get(j);
									accesorios += d;
								}
							}
							
						}
						
						cadena += "Carro: " + a.getIdentificacion() + ";" + a.getTipoCombustion() + ";" + a.getCilindraje() + ";" + 
								a.getTipoTraccion() + ";" + a.getTransmision() + ";" + a.isAireAcondicionado() + ";" + accesorios + "\n";
					}
					
					else{
						cadena += "Carro: " + a.getIdentificacion() + ";" + a.getTipoCombustion() + ";" + a.getCilindraje() + ";" + 
								a.getTipoTraccion() + ";" + a.getTransmision() + ";" + a.isAireAcondicionado() + "\n";
					}
				    
				}
				
				else if(seleccionada == primera.darSiguiente().darSiguiente().darSiguiente()){
					
					if(a instanceof CarroLujo){
						
						CarroLujo b =(CarroLujo) a;
						
						String accesorios = "";
						
						for(int j = 0; j< b.darAccesorios().size(); j++)
						{
							if(j>=1){
								if(b.darAccesorios().get(j) instanceof Accesorios)
								{
									Accesorios c = (Accesorios) b.darAccesorios().get(j);
									accesorios += "-" + c.getNombre();
								}
								
								else{
									String d = (String) b.darAccesorios().get(j);
									accesorios += "-" + d;
								}
							}
							else{
								if(b.darAccesorios().get(j) instanceof Accesorios)
								{
									Accesorios c = (Accesorios) b.darAccesorios().get(j);
									accesorios += c.getNombre();
								}
								
								else{
									String d = (String) b.darAccesorios().get(j);
									accesorios += d;
								}
							}
							
						}
						
						cadena += "Carro: " + a.getIdentificacion() + ";" + a.getTipoCombustion() + ";" + a.getCilindraje() + ";" + 
								a.getTipoTraccion() + ";" + a.getTransmision() + ";" + a.isAireAcondicionado() + ";" + accesorios +
								 ";" + a.getColor() + ";" + a.getTipoTapiceria() + "\n";;
					}
					else{
						cadena += "Carro: " + a.getIdentificacion() + ";" + a.getTipoCombustion() + ";" + a.getCilindraje() + ";" + 
								a.getTipoTraccion() + ";" + a.getTransmision() + ";" + a.isAireAcondicionado() + ";" + a.getColor()
								+ ";" + a.getTipoTapiceria() + "\n";
					}
					
				}
				
				else cadena += "Carro: " + a.getIdentificacion() + "\n";
			}

		return cadena;
	}
	
	public String generarResultados( )
	{
		String cadena = "No Hay Lista de carros";
		
		if(seleccionada.darListaCarros().size()>0){
			cadena = "Los resultados de la estacion son: " + "\n";
		}
		
		for(int i=0; i< seleccionada.darListaCarros().size(); i++){
			
			ICarro a = seleccionada.darListaCarros().get(i);
			if(seleccionada == primera)
			{
				cadena += "Se ha generado el esqueleto del carro: " + a.getIdentificacion() +"/n";
			}
			
			else if(seleccionada == primera.darSiguiente())
			{
				ICarro atributo = darCarroBuscado(a.getIdentificacion());
				
				if(a instanceof CarroLujo){
					CarroLujo b = (CarroLujo) atributo;
					
					String accesorios = "";
					for(int j = 0; j< b.darAccesorios().size(); j++){
						if(j>=1){
							if(b.darAccesorios().get(j) instanceof Accesorios)
							{
								Accesorios c = (Accesorios) b.darAccesorios().get(j);
								accesorios += "-" + c.getNombre();
							}
							
							else{
								String d = (String) b.darAccesorios().get(j);
								accesorios += "-" + d;
							}
						}
						
					}
					cadena += "se ha proseguido a construir la carroceria interna del carro " + a.getIdentificacion() + " con los accesorios: " + accesorios + " pedidos por el Cliente"+"/n";
				}
				else cadena += "El esqueleto ha llegado y se ha empezado a proseguir con los elementos de la carroceria interna pedida por produccion, Carro: " + a.getIdentificacion()+"/n";
			}
			
			else if(seleccionada == primera.darSiguiente().darSiguiente()){
				
				ICarro b = darCarroBuscado(a.getIdentificacion());
				cadena += "El carro: " + a.getIdentificacion() + "solo falta ser pintado de " +  b.getColor() + " Y terminar su tapiceria de " + b.getTipoTapiceria()+"/n";
			}
			
			else{
				if(a instanceof CarroLujo){
					
					CarroLujo b = (CarroLujo) a;
					
					cadena += "El carro: " + a.getIdentificacion() + " Cumple con todos los requisitos y puede ser entregado al cliente con cedula " + b.darCedula()+"/n";
				}
				
				else cadena += "El carro: " + a.getIdentificacion() + "Cumple con todos los requisitos y puede ser añadido a la lista de carros para vender"+"/n";
			}
		}
		
		return cadena;
	}
	
	public void guardarResultados( )
	{
		//TODO 
	}
	public void cambiarSeleccionada(int numero )
	{
		if(numero == 0)
			seleccionada = primera;
		else if(numero == 1)
			seleccionada = primera.darSiguiente();
		else if(numero == 2)
			seleccionada = primera.darSiguiente().darSiguiente();
		else
			seleccionada = primera.darSiguiente().darSiguiente().darSiguiente();
	}
	
	//serialización
	//---------------------------------------------------------------------------------------
	public void cargarInfo(){
		   
		   File f = new File(rutaArchivo);
		   if (f.exists()){
			   try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				clientes = (ArrayList<Cliente>) ois.readObject();
				empleados = (ArrayList<Empleado>) ois.readObject();
				accesorios = (ArrayList<Accesorios>)ois.readObject();
				carrosAtributos = (ArrayList<ICarro>)ois.readObject();
				ois.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,this,e.getMessage(), 0);		
			}
		} else{	
			clientes = new ArrayList<Cliente>();
			empleados = new ArrayList<Empleado>();
			accesorios = new ArrayList<Accesorios>();
			carrosAtributos = new ArrayList<ICarro>();
			}
		   verificarInvariantes();
	   }
	   
	   
	   public void salvarInfo () throws Exception{
		   try {
			   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
			   oos.writeObject(clientes);
			   oos.writeObject(empleados);
			   oos.writeObject(accesorios);
			   oos.writeObject(carrosAtributos);
			   oos.close();
			
		} catch (IOException e) {
			throw new Exception("No se pudo salvar el archivo" + e.getMessage());
		}
		   verificarInvariantes();
	   }
	   
	   
	   //---------------------------------------------------------
	public Sucursal darSeleccionada()
	{
		return seleccionada;
	}
	
	public Sucursal darPrimera()
	{
		return primera;
	}

	public ArrayList<Cliente> darClientes() {
		return clientes;
	}

	public ArrayList<Accesorios> darAccesorios() {
		return accesorios;
	}
	
	
	
	public void verificarInvariantes (){ assert clientes != null : ""; assert empleados != null: ""; assert accesorios != null : ""; assert carrosAtributos != null : ""; }
}
