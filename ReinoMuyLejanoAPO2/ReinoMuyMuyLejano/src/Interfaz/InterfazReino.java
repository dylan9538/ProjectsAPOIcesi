package Interfaz;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.*;
import Mundo.PersistenciaException;
import Mundo.Personificacion;
import Mundo.Reino;

public class InterfazReino extends JFrame {

	// CONSTANTES
	public final static String SUPERIOR = "Superior";
	public final static String SECUNDARIA = "Secundaria";
	public final static String PRIMARIA = "Primaria";
	public final static String DESEMPLEADO = "Desempleado";
	public final static String EMPLEADO = "Empleado";
	public final static String MASCULINO = "Masculino";
	public final static String FEMENINO = "Femenino";
	public final static String SOLTERO = "Soltero";
	public final static String CASADO = "Casado";
	public final static String DIVORCIADO = "Divorciado";
	public final static String RELACION = "Relacion";
	public final static String VIUDO = "Viudo";

	// ATRIBUTOS

	private PanelRegistro panelRegistro;
	private PanelBanner panelBanner;
	private PanelInformacion panelInformacion;
	public Reino reino;
	private String rutaArchivo;

	// CONSTRUCTOR
	
 public InterfazReino(Reino r) 
 {
		reino = r;

		setSize(900, 900);
		setTitle("Habitantes de Muy Muy Lejano");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setResizable(false);

		panelRegistro = new PanelRegistro(this);
		add(panelRegistro, BorderLayout.WEST);

		panelBanner = new PanelBanner();
		add(panelBanner, BorderLayout.NORTH);

		panelInformacion = new PanelInformacion(this);
		add(panelInformacion, BorderLayout.CENTER);
		pack();

	}
 
 //Metodo de registro
	public void registrar(String cadena) {
		String nombre = panelRegistro.darTxtNombre();
		String fecha = panelRegistro.darTxtFechaNacimiento();
		String id = panelRegistro.darTxtId();
		String sexo = panelRegistro.darSexoBox();
		String rh = panelRegistro.darRhBox();
		String direccion = panelRegistro.darTxtdDireccion();
		String estadoCivil = panelRegistro.darEstadoCivilBox();
		String telefono = panelRegistro.darTxtTelefono();
		String hijos = panelRegistro.darTxtCantidadHijos();
		String nivelEducativo = panelRegistro.darNivelEducativoBox();
		String profesion = panelRegistro.darTxtProfesion();
		String estadoLaboral = panelRegistro.darEstadoLaboralBox();
		String salario = panelRegistro.darTxtSalario();

		if (!nombre.equals("") && !fecha.equals("") && !id.equals("")
				&& !sexo.equals("") && !rh.equals("") && !direccion.equals("")
				&& !estadoCivil.equals("") && !telefono.equals("")
				&& !hijos.equals("") && !nivelEducativo.equals("")
				&& !profesion.equals("") && !estadoLaboral.equals("")
				&& !salario.equals("")) {
			try {

				boolean cumplePatron = Pattern.matches("\\d\\d-\\d\\d-\\d\\d\\d\\d", fecha);
				boolean cumplePatron10Digitos = Pattern.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d", telefono);
				boolean cumplePatron7Digitos = Pattern.matches("\\d\\d\\d\\d\\d\\d\\d", telefono);
				if (!cumplePatron) {
					JOptionPane.showMessageDialog(this,"Por favor llenar el campo de fecha con el formato " 
				+ "dd-mm-aaaa","Fecha error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String[] splitter = fecha.split("-");
					if (Integer.parseInt(splitter[0]) > 0
							&& Integer.parseInt(splitter[0]) <= 31
							&& Integer.parseInt(splitter[1]) > 0
							&& Integer.parseInt(splitter[1]) <= 12
							&& Integer.parseInt(splitter[2]) >= 0
							&& Integer.parseInt(splitter[2]) <= 3000) {
						if (Integer.parseInt(telefono) >= 0) {
							if (cumplePatron10Digitos || cumplePatron7Digitos) {
								if (Integer.parseInt(hijos) >= 0) {
									reino.registrarPersonificacion(
											panelRegistro.darTxtNombre(),
											panelRegistro.darTxtFechaNacimiento(),
											panelRegistro.darTxtId(),
											panelRegistro.darSexoBox(),
											panelRegistro.darRhBox(),
											panelRegistro.darTxtdDireccion(),
											panelRegistro.darTxtTelefono(),
											panelRegistro.darEstadoCivilBox(),
											panelRegistro.darTxtCantidadHijos(),
											panelRegistro.darNivelEducativoBox(),
											panelRegistro.darTxtProfesion(),
											panelRegistro.darEstadoLaboralBox(),
											Double.parseDouble(panelRegistro.darTxtSalario()));	
				reino.ordenarListadoPorFechaDeNacimiento();
				panelInformacion.refrescarArea(reino.darString(reino.darPersonificaciones()));
    JOptionPane.showMessageDialog(this,"Se ha registrado exitosamente","Registro",JOptionPane.PLAIN_MESSAGE);
								}
	else {
		JOptionPane.showMessageDialog(this,"Llenar el numero de hijos sin letras","error",JOptionPane.ERROR_MESSAGE);
		}
		} 
	else {
		JOptionPane.showMessageDialog(this,"el numero de digitos de telefono deben ser 7 o 10","Telefono error",JOptionPane.ERROR_MESSAGE);
		 }
		 }

	else {
		JOptionPane.showMessageDialog(this,"Digitar el telefono solo con numeros","Telefono error",JOptionPane.ERROR_MESSAGE);
		}
		}
	else {
		JOptionPane.showMessageDialog(this,"Digitar la fecha correctamente","Fecha error", JOptionPane.ERROR_MESSAGE);
		}
		}
	  } catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"El salario y telefono deben ser numericos", "Error",JOptionPane.ERROR_MESSAGE);
		}
		} else   JOptionPane.showMessageDialog(this, "Rellenar todos los campos","Error", JOptionPane.ERROR_MESSAGE);
	}
	
//Metodo Interfaz Lista de empleados
  public void listaDesempleadosConHijos() {
		reino.OrdenarPorHijosDesempleados();
		if (reino.darDesempleados().size() == 0) {
			JOptionPane.showMessageDialog(this,
					"No hay habitantes disponibles para generar el reporte");
		} else {

			ArrayList<Personificacion> desempleados = reino.darDesempleados();
			panelInformacion.refrescarArea(reino.darString(desempleados));
		}
	}
    
   // Metodo interfaz organizar por Rh
 public void organizarPorRH(String sexo) {
		reino.organizarPorRH(sexo);
		String reporte = "Las personificaciones del sexo " + sexo + " son:" + "\n";
		ArrayList<Personificacion> orga = null;

		if (sexo.equals(Personificacion.SEXO_FEMENINO) && reino.darRhMujeres().size() == 0)
		{
			JOptionPane.showMessageDialog(this,"No hay mujeres registradas para realizar el Listado");
		} 
		else if (sexo.equals(Personificacion.SEXO_MASCULINO) && reino.darRhHombres().size() == 0) 
		{
			JOptionPane.showMessageDialog(this,"No hay hombres registradas para realizar el Listado");
		} 
		else {
			for (int i = 0; i < reino.darPersonificaciones().size(); i++) {
				if (sexo.equals(Personificacion.SEXO_MASCULINO)) {
					orga = reino.darRhHombres();
				}
				if (sexo.equals(Personificacion.SEXO_FEMENINO)) {
					orga = reino.darRhMujeres();
				}
			}
			panelInformacion.refrescarArea(reino.darString(orga));
		}
	}
 
 
 //Metodo Organizar por edad
 
 public void organizarEdad()
    {
	 reino.ordenarListadoPorFechaDeNacimiento();
	 panelInformacion.refrescarArea(reino.darString(reino.darPersonificaciones()));
    }
 
 //Metodo Cargar de Interfaz para persistencia
public void cargar(String ruta) {
		try {
			reino.importarDatosReino(ruta);
			panelInformacion.refrescarArea(reino.darString(reino.darPersonificaciones()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "error",JOptionPane.ERROR_MESSAGE);
		}
	}

//Metodo guardar de Interfaz Persistencia
public void guardar(String ruta) {
		try {
			reino.exportarArchivo(ruta);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	
//	Metodo dispose de la interfaz para serializacion
public void dispose() {
		try {
			reino.salvarInfoReino();
			super.dispose();
		} catch (Exception e) {
			setVisible(true);
			int respuesta = JOptionPane.showConfirmDialog(
					this,
					"Problemas salvando la información del Reino:\n"
							+ e.getMessage()
							+ "\n¿Quiere cerrar el programa sin salvar?",
					"Error", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				super.dispose();
			}
		}
	}
 
//Metodo de Modificar el txtArea
 public void modificarTxtArea() {
	panelInformacion.refrescarArea(reino.darString(reino.darPersonificaciones()));
  }

//Metodo Main 
	public static void main(String[] args) {
		Reino reino = null;
		try {
			reino = new Reino("./data/reino.personificionees");
		} catch (PersistenciaException e) {
			e.printStackTrace();
			System.exit(1);
		}
		InterfazReino id = new InterfazReino(reino);
		id.setVisible(true);
	}

}