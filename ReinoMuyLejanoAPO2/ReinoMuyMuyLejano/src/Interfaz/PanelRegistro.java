package Interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.File;
import java.io.PrintStream;

public class PanelRegistro extends JPanel implements ActionListener {

	// CONSTANTES

	public final static String GUARDAR = "Guardar";
	public final static String CARGAR = "Cargar";
	public final static String LIMPIAR = "Limpiar";
	public final static String REGISTRAR = "Registrar";

	// ATRIBUTOS

	private JPanel panelBotones, panelRegistro;
	private InterfazReino principal;
	private PanelInformacion panelInformacion;
	
	
	public DefaultListModel modeliLista;

	private JLabel labNombreCompleto, labEstadoLaboral, labFechaNacimiento,
			labId, labSexo, labDireccion, labTelefono, labEstadoCivil,
			labCantidadHijos, labNivelEducativo, labProfesion, labSalario,
			labTipoRh;

	private JTextField txtNombreCompleto, txtFechaNacimiento, txtId,
			txtdDireccion, txtTelefono, txtCantidadHijos,
			txtProfesion, txtSalario;

	private JComboBox boxRh, boxSexo, boxEstadoCivil, boxEstadoLaboral, boxNivelEducativo;

	private JButton butGuardar;
	private JButton butCargar;
	private JButton butLimpiar;
	private JButton butRegistrar;

	public PanelRegistro(InterfazReino v) {
		
		
		panelInformacion = new PanelInformacion(v);
		principal = v;
		setLayout(new BorderLayout());	
		panelRegistro =  new JPanel();
		panelRegistro.setLayout(new GridLayout(13,2,1,1));
		panelRegistro.setBorder(BorderFactory.createTitledBorder("Registro de Datos"));
		
		setLayout(new BorderLayout());	
		panelBotones =  new JPanel();
		panelBotones.setLayout(new GridLayout(3,1,1,1));
		panelBotones.setBorder(BorderFactory.createTitledBorder("Opciones"));
		
		
		labNombreCompleto = new JLabel("Nombres Completo:");
		txtNombreCompleto = new JTextField();

		labFechaNacimiento = new JLabel("Fecha De Nacimiento:(dd-mm-aaaa) " );
		txtFechaNacimiento = new JTextField();

		labId = new JLabel("Cédula");
		txtId = new JTextField();
		
	

		labSexo = new JLabel("Sexo");
		boxSexo = new JComboBox();
		boxSexo.addItem("");
		boxSexo.addItem(InterfazReino.MASCULINO);
		boxSexo.addItem(InterfazReino.FEMENINO);

		labDireccion = new JLabel("Dirección");
		txtdDireccion = new JTextField();

		labTelefono = new JLabel("Telefono");
		txtTelefono = new JTextField();

		// A+- B-+ AB+- O-+
		labTipoRh = new JLabel("Tipo RH:");
		boxRh = new JComboBox();
		boxRh.addItem("");
		boxRh.addItem("A+");
		boxRh.addItem("A-");
		boxRh.addItem("B+");
		boxRh.addItem("B-");
		boxRh.addItem("O+");
		boxRh.addItem("O-");
		boxRh.addItem("No Tiene");



		labEstadoCivil = new JLabel("Estado Civil");
		boxEstadoCivil = new JComboBox();
		boxEstadoCivil.addItem("");
		boxEstadoCivil.addItem(InterfazReino.CASADO);
		boxEstadoCivil.addItem(InterfazReino.DIVORCIADO);
		boxEstadoCivil.addItem(InterfazReino.VIUDO);
		boxEstadoCivil.addItem(InterfazReino.SOLTERO);
		boxEstadoCivil.addItem(InterfazReino.RELACION);

		labCantidadHijos = new JLabel("Cantidad De Hijos: ");
		txtCantidadHijos = new JTextField();

		labNivelEducativo = new JLabel("Nivel Educativo");
		boxNivelEducativo = new JComboBox();
		boxNivelEducativo.addItem("");
		boxNivelEducativo.addItem(InterfazReino.SUPERIOR);
		boxNivelEducativo.addItem(InterfazReino.PRIMARIA);
		boxNivelEducativo.addItem(InterfazReino.SECUNDARIA);

		labProfesion = new JLabel("Profesión");
		txtProfesion = new JTextField();

		labEstadoLaboral = new JLabel("Estado Laboral");
		boxEstadoLaboral = new JComboBox();
		boxEstadoLaboral.addItem("");
		boxEstadoLaboral.addItem(InterfazReino.EMPLEADO);
		boxEstadoLaboral.addItem(InterfazReino.DESEMPLEADO);

		labSalario = new JLabel("Salario");
		txtSalario = new JTextField();

		butGuardar = new JButton("Guardar");
		butGuardar.setActionCommand(GUARDAR);
		butGuardar.addActionListener(this);


		butCargar = new JButton("Cargar");
		butCargar.setActionCommand(CARGAR);
		butCargar.addActionListener(this);
		
		butLimpiar = new JButton("Limpiar");
		butLimpiar.setActionCommand(LIMPIAR);
		butLimpiar.addActionListener(this);

		butRegistrar = new JButton("Registrar");
		butRegistrar.setActionCommand(REGISTRAR);
		butRegistrar.addActionListener(this);

		panelBotones.add(butCargar);
		panelBotones.add(butGuardar);
		panelBotones.add(butLimpiar);
		panelBotones.add(butRegistrar);

		panelRegistro.add(labNombreCompleto);
		panelRegistro.add(txtNombreCompleto);
		panelRegistro.add(labFechaNacimiento);
		panelRegistro.add(txtFechaNacimiento);
		panelRegistro.add(labId);
		panelRegistro.add(txtId);
		panelRegistro.add(labSexo);
		panelRegistro.add(boxSexo);
		panelRegistro.add(labTipoRh);
		panelRegistro.add(boxRh);
		panelRegistro.add(labDireccion);
		panelRegistro.add(txtdDireccion);
		panelRegistro.add(labTelefono);
		panelRegistro.add(txtTelefono);
		panelRegistro.add(labEstadoCivil);
		panelRegistro.add(boxEstadoCivil);
		panelRegistro.add(labCantidadHijos);
		panelRegistro.add(txtCantidadHijos);
		panelRegistro.add(labNivelEducativo);
		panelRegistro.add(boxNivelEducativo);
		panelRegistro.add(labProfesion);
		panelRegistro.add(txtProfesion);
		panelRegistro.add(labEstadoLaboral);
		panelRegistro.add(boxEstadoLaboral);
		panelRegistro.add(labSalario);
		panelRegistro.add(txtSalario);
		
		
		add(panelRegistro, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);

	}
//Metodo Limpiar
	public void limpiar() {
		txtNombreCompleto.setText("");
		txtFechaNacimiento.setText("");
		txtdDireccion.setText("");
		txtTelefono.setText("");
		txtCantidadHijos.setText("");
		txtProfesion.setText("");
		txtSalario.setText("");
		txtId.setText("");
		boxEstadoCivil.setSelectedIndex(0);
		boxEstadoLaboral.setSelectedIndex(0);;
		boxNivelEducativo.setSelectedIndex(0);;
		boxRh.setSelectedIndex(0);;
		boxSexo.setSelectedIndex(0);;
		panelInformacion.actual.clear();
	}

//METODOS DAR DE INTERFAZ

//..........
	public String darTxtNombre() 
	{
		return txtNombreCompleto.getText();
	}
//..........
	public String darTxtFechaNacimiento() 
	{
		return txtFechaNacimiento.getText();
     }
//..........
	public String darTxtId()
	{
		return txtId.getText();
	}
//..........
	public String darTxtdDireccion() 
	{
		return txtdDireccion.getText();
	}
//..........
	public String darTxtTelefono() 
	{
		return txtTelefono.getText();
	}
//..........
	public String darTxtCantidadHijos() 
	{
		return txtCantidadHijos.getText();
	}
//..........
	public String darTxtProfesion()
	{
		return txtProfesion.getText();
	}
//..........	
	public String darTxtSalario() 
	{
		return txtSalario.getText();
	}
//..........
	public String darSexoBox()
	{
		return (String) boxSexo.getSelectedItem();		
	}
//..........
	public String darRhBox()
	{
		return (String) boxRh.getSelectedItem();		
	}
//..........
	public String darEstadoLaboralBox()
	{
		return (String) boxEstadoLaboral.getSelectedItem();		
	}
//..........
	public String darEstadoCivilBox()
	{
		return (String) boxEstadoCivil.getSelectedItem();		
	}
//..........
	public String darNivelEducativoBox()
	{
		return (String) boxNivelEducativo.getSelectedItem();		
	}

	@Override
	
  //Action perfomed
	public void actionPerformed(ActionEvent even) {
		
		String comando = even.getActionCommand();
		
  //Para boton Guardar	
		if (comando.equals(GUARDAR)) {

			JFileChooser directorio = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("txt", "txt");
			directorio.setFileFilter(filtro);
        String ruta = "";
			int respuesta = directorio.showOpenDialog(principal);
			if (respuesta == JFileChooser.APPROVE_OPTION) {
				File escogido = directorio.getSelectedFile();
				ruta = escogido.getAbsolutePath();
				principal.guardar(ruta);
		}
		}

  //Para boton cargar
		if (comando.equals(CARGAR)) {
			JFileChooser directorio = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("txt", "txt");
		    directorio.setFileFilter(filtro);
			
		    int respuesta = directorio.showOpenDialog(principal);
			if (respuesta == JFileChooser.APPROVE_OPTION) {
				File escogido = directorio.getSelectedFile();
				principal.cargar(escogido.getAbsolutePath());
				principal.modificarTxtArea();
		}
		}
		
  //Para boton Limpiar
		if (comando.equals(LIMPIAR)) {
         limpiar();
		}

  //Para boton registrar
		if(comando.equals(REGISTRAR))
		{
			String cadena = darTxtNombre() +";"+ darTxtFechaNacimiento()+";"
			+ darTxtId()+";"+ darSexoBox()+";"+ darRhBox()+";"+darTxtdDireccion()+";"
			+ darTxtTelefono()+";"+ darEstadoCivilBox()+";"+ darTxtCantidadHijos()+";"
		    +darNivelEducativoBox()+";"+darTxtProfesion()+";"+ darEstadoLaboralBox()+";" +
		    darTxtSalario()+"\n";
			principal.registrar(cadena);
			
		principal.modificarTxtArea();

		}
	}
}
