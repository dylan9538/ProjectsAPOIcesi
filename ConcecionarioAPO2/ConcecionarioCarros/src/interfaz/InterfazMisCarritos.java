package interfaz;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;





import mundo.Cliente;
import mundo.Concecionario;



public class InterfazMisCarritos extends JFrame {

	
	private Concecionario carritos;
	private PanelModulo1 modulo1;
	private PanelBanner banner;
	private PanelModulo2 modulo2;
	private PanelModulo3 modulo3;
	private PanelDibujo dibujo;
	
	public final static String ARCHIVO_CENTRAL = "./data/datos.dat";
	
	public InterfazMisCarritos(Concecionario c)
	{
		carritos = c;
		getContentPane( ).setLayout(new BorderLayout( )  );
		setSize( 650, 700 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "Mis Carritos" );
        
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BorderLayout());
        
        modulo1 = new PanelModulo1(this);
        modulo2 = new PanelModulo2(this);
        
        JPanel contenedor1 = new JPanel();
        contenedor1.setLayout(new GridLayout(1,2));
        contenedor1.add(modulo1);
        contenedor1.add(modulo2);
        
        banner = new PanelBanner();
        
        contenedor.add(banner,BorderLayout.CENTER);
        contenedor.add(contenedor1,BorderLayout.SOUTH);
        
        
        getContentPane( ).add(contenedor,BorderLayout.PAGE_START);
        
        dibujo = new PanelDibujo(this);
        getContentPane( ).add(dibujo,BorderLayout.CENTER);
        
        modulo3 = new PanelModulo3(this);
        
        
        getContentPane( ).add(modulo3, BorderLayout.PAGE_END);
        
        setResizable(false);
        centrar( );
	}
	
	public void mostrarVentanaRegistrarCliente( )
    {
        DialogoCliente d = new DialogoCliente( this);
        d.setVisible( true );
    }
	
	public void mostrarVentanaRegistrarEmpleado( )
    {
        DialogoEmpleado d = new DialogoEmpleado( this);
        d.setVisible( true );
    }
	
	public void mostrarVentanaRegistrarAccesorio( )
    {
        DialogoAccesorio d = new DialogoAccesorio( this);
        d.setVisible( true );
    }

	public void mostrarVentanaCarroTradicional( )
    {
        DialogoCarroTradicional d = new DialogoCarroTradicional( this);
        d.setVisible( true );
    }
	
	public void mostrarVentanaCarroLujo( )
    {
		if(carritos.darClientes().size()>0){
			DialogoCarroLujo d = new DialogoCarroLujo(this, carritos.darClientes(), carritos.darAccesorios());
	        d.setVisible( true );
		}
		
		else JOptionPane.showMessageDialog(this, "No hay clientes registrados", "Error", JOptionPane.INFORMATION_MESSAGE);
    }
	
	
	public void registrarCliente(DialogoCliente cliente, String nombre, String apellido, String numeroId,
			String direccion, String telefono, String celular, String ciudad,
			String pais, String correo)
	{
		if(nombre.equals("")||apellido.equals("")||apellido.equals("")|| numeroId.equals("") || direccion.equals("") || telefono.equals("")
				 || celular.equals("") || ciudad.equals("") || pais.equals("") || correo.equals("")){
			
			JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "Rellenar los campos", JOptionPane.INFORMATION_MESSAGE);
		}
		
		try{
			
			int cedula = Integer.parseInt(numeroId);
			
			if(cedula>0){
				if(carritos.registrarCliente(nombre, apellido, numeroId, direccion, telefono, celular, ciudad, pais, correo)){
					JOptionPane.showMessageDialog(this, "Se ha agregado correctamente", ":D", JOptionPane.INFORMATION_MESSAGE);
					cliente.dispose();
					}
				else JOptionPane.showMessageDialog(this, "ya existe una persona con esa cedula", "Corregir", JOptionPane.INFORMATION_MESSAGE);
			}
			else JOptionPane.showMessageDialog(this, "La cedula debe ser positiva", "Corregir", JOptionPane.INFORMATION_MESSAGE);
			
			
		} catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "La cedula debe ser numerica", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void registrarEmpleado(DialogoEmpleado empleado, String nombre, String apellido, String numeroId,
			String direccion, String telefono, String celular, String ciudad,
			String pais, String correo, String numeroCuenta, String tipoContrato, String cargo)
	{
		if(nombre.equals("")||apellido.equals("")||apellido.equals("")|| numeroId.equals("") || direccion.equals("") || telefono.equals("")
				 || celular.equals("") || ciudad.equals("") || pais.equals("") || correo.equals("") ||numeroCuenta.equals("")||
				 tipoContrato.equals("") || cargo.equals("")){
			
			JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "Rellenar los campos", JOptionPane.INFORMATION_MESSAGE);
		}
		
		try{
			
			int cedula = Integer.parseInt(numeroId);
			
			if(cedula>0){
				if(carritos.registrarEmpleado(nombre, apellido, numeroId, direccion, telefono, celular, ciudad, pais, correo, numeroCuenta, tipoContrato, cargo)){
					JOptionPane.showMessageDialog(this, "Se ha agregado correctamente", ":D", JOptionPane.INFORMATION_MESSAGE);
					empleado.dispose();
				}
				
				else JOptionPane.showMessageDialog(this, "Ya existe una persona con esa cedula", "Corregir", JOptionPane.INFORMATION_MESSAGE);
				
			}
			else JOptionPane.showMessageDialog(this, "La cedula debe ser positiva", "Corregir", JOptionPane.INFORMATION_MESSAGE);
			
			
		} catch(Exception e){
			JOptionPane.showMessageDialog(this, "La cedula debe ser numerica", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void registrarAccesorio(DialogoAccesorio accesorio, String nombre,String descripcion, String codigo, String restricciones, String costo){
		
		if(nombre.equals("") || descripcion.equals("") || codigo.equals("")|| restricciones.equals("")||costo.equals("")){
			JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "Rellenar los campos", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else{
			
			try{
				
				int costico = Integer.parseInt(costo);
				
				if(costico>0){
					
					carritos.registrarAccesorio(nombre,descripcion, codigo, restricciones, costico);
					JOptionPane.showMessageDialog(this, "se ha registrado correctamente", ":D", JOptionPane.INFORMATION_MESSAGE);
					accesorio.dispose();
				}
				else JOptionPane.showMessageDialog(this, "el costo debe ser positivo", "Corregir", JOptionPane.INFORMATION_MESSAGE);
				
			}catch(Exception e){
				
				JOptionPane.showMessageDialog(this, "el costo debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public void generarPedidoTradicional(DialogoCarroTradicional carro, String tipoCombustion, String tipoTraccion, String color, String transmision
			, String tipoTapiceria, boolean aireAcondicionado, String cilindrajito ){
		
		if(tipoCombustion == null || tipoCombustion.equals("") || tipoTraccion == null ||  tipoTraccion.equals("") ||color == null 
			||color.equals("") || transmision==null || transmision.equals("") || tipoTapiceria == null || tipoTapiceria.equals("")
			|| cilindrajito == null || cilindrajito.equals("")){
			JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else{
			try{
				int cilindraje = Integer.parseInt(cilindrajito);
				
				carritos.realizarPedidoTradicional(tipoCombustion, tipoTraccion, color, transmision, tipoTapiceria, aireAcondicionado, cilindraje);
				
				JOptionPane.showMessageDialog(this, "Se ha generado el pedido correctamente", ":D", JOptionPane.INFORMATION_MESSAGE);
				
				carro.dispose();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(this, "El cilindraje debe ser numerico","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	//---------------
	public void generarPedidoLujo(DialogoCarroLujo dialogoCarroLujo, String tipoCombustion, String tipoTraccion, String color, String transmision
			, String tipoTapiceria, boolean aireAcondicionado, String cilindrajito,ArrayList accesorios, String cedulaCliente){
		
		if(tipoCombustion == null || tipoCombustion.equals("") || tipoTraccion == null ||  tipoTraccion.equals("") ||color == null 
			||color.equals("") || transmision==null || transmision.equals("") || tipoTapiceria == null || tipoTapiceria.equals("")
			|| cilindrajito == null || cilindrajito.equals("")){
			JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			try{
				int cilindraje = Integer.parseInt(cilindrajito);
				
				carritos.realizarPedidoLujo(tipoCombustion, tipoTraccion, color, transmision, tipoTapiceria, aireAcondicionado, cilindraje,accesorios,cedulaCliente);
				
				JOptionPane.showMessageDialog(this, "Se ha generado el pedido correctamente", ":)", JOptionPane.INFORMATION_MESSAGE);
				
				dialogoCarroLujo.dispose();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(this, "El cilindraje debe ser numerico","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void verListaCarrosListosVender()
	{
		String lista = carritos.darListaCarrosListoVender();
		modulo3.refrescarArea(lista);
	}
	
	public void CambiarSeleccionada(int numero)
	{
		carritos.cambiarSeleccionada(numero);
	}
	
	public void verListaCarros( ){
		
		if(carritos.darSeleccionada()==null){
			JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna sucursal", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else{
			
			String lista = carritos.verListaCarros();
			modulo3.refrescarArea(lista);
		}
	}
	
	public void verResultados( ){
		if(carritos.darSeleccionada()==null){
			JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna sucursal", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else{
			
			String lista = carritos.generarResultados();
			modulo3.refrescarArea(lista);
		}
	}
	public void promover( ){
		
		if(carritos.darSeleccionada()==null){
			JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna sucursal", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else{
			if(!carritos.promover())
				JOptionPane.showMessageDialog(this, "No hay carros para promover", "Error", JOptionPane.INFORMATION_MESSAGE);
			else{
				verListaCarros();
				JOptionPane.showMessageDialog(this, "Se ha promovido el carro a la siguiente", ":D", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	
	
	
	private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }

	
	
	public static void main(String[] args) {
		
		Concecionario c = new Concecionario(ARCHIVO_CENTRAL);
		
		InterfazMisCarritos ventana = new InterfazMisCarritos(c);
		ventana.setVisible(true);
	

	}
	
}
