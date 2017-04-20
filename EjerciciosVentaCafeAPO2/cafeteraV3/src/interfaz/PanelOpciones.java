package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel implements ActionListener {

	// -----CONSTANTES-------//

	public final static String CARGAR1AZUC = "Actualizar1";
	public final static String CARGAR2AGUA = "Actualizar2";
	public final static String CARGAR3PITI = "Actualizar3";
	public final static String CARGAR4VASO = "Actualizar4";
	public final static String CARGAR5CAFE = "Actualizar5";
	public final static String ACTUALIZAR_DATOS= "actualizar6";

	// --------ATRIBUTOS----//

	private InterfazVending Interf;
	private JLabel labCafe;
	private JLabel labAgua;
	private JLabel labAzucar;
	private JLabel labPitillos;
	private JLabel labVasos;
	private JLabel labVacio1;
	private JLabel labVacio2;
	private JTextField txtCafe;
	private JTextField txtAgua;
	private JTextField txtAzucar;
	private JTextField txtVasos;
	private JTextField txtPitillos;
	private JButton butCafe;
	private JButton butAgua;
	private JButton butAzucar;
	private JButton butPitillos;
	private JButton butVasos;
	private JButton butActualiza;

	// --------RELACIÓN----//

	private InterfazVending principal;

	/**
	 * Metodo contructor de la clase PanelOpciones
	 * 
	 * @param pPrin
	 *            permite la relacion con la interfaz
	 */

	public PanelOpciones(InterfazVending pPrin) {

		principal = pPrin;

		setLayout(new GridLayout(6, 3));
		TitledBorder border = BorderFactory.createTitledBorder("Agregar Datos");
		setBorder(border);

		butAgua = new JButton("Agregar");
		butAgua.setActionCommand(CARGAR2AGUA);
		butAgua.addActionListener((ActionListener) this);
		butAgua.setBounds(new Rectangle(10, 500, 50, 50));

		butCafe = new JButton("Agregar");
		butCafe.setActionCommand(CARGAR5CAFE);
		butCafe.addActionListener((ActionListener) this);
		butCafe.setBounds(new Rectangle(10, 500, 50, 50));

		butAzucar = new JButton("Agregar");
		butAzucar.setActionCommand(CARGAR1AZUC);
		butAzucar.addActionListener((ActionListener) this);
		butAzucar.setBounds(new Rectangle(10, 500, 50, 50));

		butPitillos = new JButton("Agregar");
		butPitillos.setActionCommand(CARGAR3PITI);
		butPitillos.addActionListener((ActionListener) this);
		butPitillos.setBounds(new Rectangle(10, 500, 50, 50));

		butVasos = new JButton("Agregar");
		butVasos.setActionCommand(CARGAR4VASO);
		butVasos.addActionListener((ActionListener) this);
		butVasos.setBounds(new Rectangle(10, 500, 50, 50));
		
		butActualiza = new JButton("Actualizar");
		butActualiza.setActionCommand(ACTUALIZAR_DATOS);
		butActualiza.addActionListener((ActionListener) this);
		butActualiza.setBounds(new Rectangle(10, 500, 50, 50));

		labCafe = new JLabel("Cafe");
		txtCafe = new JTextField();
		txtCafe.setEditable(false);
		txtCafe.setText("0");

		labAgua = new JLabel("Agua (ml)");
		txtAgua = new JTextField();
		txtAgua.setEditable(false);
		txtAgua.setText("0");

		labPitillos = new JLabel("Pitillos");
		txtPitillos = new JTextField();
		txtPitillos.setEditable(false);
		txtPitillos.setText("0");

		labAzucar = new JLabel("Azucar");
		txtAzucar = new JTextField();
		txtAzucar.setEditable(false);
		txtAzucar.setText("0");

		labVasos = new JLabel("Vasos");
		txtVasos = new JTextField();
		txtVasos.setEditable(false);
		txtVasos.setText("0");
		
		labVacio1 = new JLabel("");
		
		labVacio2 = new JLabel("");

		add(labVacio1);
		add(butActualiza);
		add(labVacio2);
		add(labCafe);
		add(txtCafe);
		add(butCafe);
		add(labAgua);
		add(txtAgua);
		add(butAgua);
		add(labAzucar);
		add(txtAzucar);
		add(butAzucar);
		add(labPitillos);
		add(txtPitillos);
		add(butPitillos);
		add(labVasos);
		add(txtVasos);
		add(butVasos);

	}

	/**
	 * Metodo actionPerformed
	 */
	// TODO Auto-generated method stub

	@Override
	public void actionPerformed(ActionEvent e){

		String comando = e.getActionCommand();


		if (comando.equals(CARGAR2AGUA)) {

			String resultado = JOptionPane.showInputDialog("ingresar Agua");
			JOptionPane.showMessageDialog(this, "El numero ingresado es: " + resultado);
	
			int nuevaCantidad = Integer.parseInt(resultado) + principal.darAgua();
			if(nuevaCantidad <=18900){
			principal.actualizarAgua(nuevaCantidad);
		    txtAgua.setText(""+nuevaCantidad);
			}else{
				JOptionPane.showMessageDialog(this, "se pasa del limite");
			}

		} else if (comando.equals(CARGAR1AZUC)) {

			String resultado2 = JOptionPane.showInputDialog("ingresar Azucar");
			JOptionPane.showMessageDialog(null, "El numero ingresado es: " + resultado2);
		
			int nuevaCantidad = Integer.parseInt(resultado2) + principal.darAzucar();
			if(nuevaCantidad <=100){
			principal.actualizarAzucar(nuevaCantidad);
			txtAzucar.setText(""+nuevaCantidad);
			}else{
				JOptionPane.showMessageDialog(this, "Se pasa del limite :c");
			}

		} else if (comando.equals(CARGAR3PITI)) {

			String resultado3 = JOptionPane.showInputDialog(this, "ingresar Pitillos");
			JOptionPane.showMessageDialog(this, "El numero ingresado es: " + resultado3);
			
			int nuevaCantidad = Integer.parseInt(resultado3) + principal.darPitillos();
			if(nuevaCantidad<= 50){
			principal.actualizarPitillos(nuevaCantidad);
			txtPitillos.setText(""+nuevaCantidad);
			}else {
				
				JOptionPane.showMessageDialog(this, "Se pasa dle limete");
				
			}
			

		}else if (comando.equals(CARGAR4VASO)) {

			String resultado4 = JOptionPane.showInputDialog(this, "ingresar Vasos");
			JOptionPane.showMessageDialog(this, "El numero ingresado es: " + resultado4);
	
			int nuevaCantidad = Integer.parseInt(resultado4) + principal.darVasos();
			if(nuevaCantidad<=50){
			principal.actualizarVasos(nuevaCantidad);
			txtVasos.setText(""+nuevaCantidad);

			}else{
				JOptionPane.showMessageDialog(this,"Se pasa del limite");
			}
			
		}else if (comando.equals(CARGAR5CAFE)) {

			String resultado5 = JOptionPane.showInputDialog(this, "ingresar Cafe");
			JOptionPane.showMessageDialog(this, "El numero ingresado es: " + resultado5);
			
			int nuevaCantidad = Integer.parseInt(resultado5) + principal.darCafe();
			
			if(nuevaCantidad<=450){
			principal.actualizarCafe(nuevaCantidad);
			txtCafe.setText(""+nuevaCantidad);
			}else{
				JOptionPane.showMessageDialog(this, "Se pasa del limite");
			}
				
		}else if(comando.equals(ACTUALIZAR_DATOS)){
			txtAgua.setText("" + principal.darAgua());
			txtAzucar.setText("" + principal.darAzucar());
			txtCafe.setText("" + principal.darCafe());
			txtPitillos.setText("" + principal.darPitillos());
			txtVasos.setText("" + principal.darVasos());
			
		}

	}

}
