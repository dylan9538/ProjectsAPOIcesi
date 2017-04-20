package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelInformacion extends JPanel implements ActionListener {
	
	//----CONSTANTES-----//
	
	public final static String VENTAS= "ventas";
	public final static String DINERO= "Dinero";
	
	
	//----ATRIBUTOS------//
	

	private JButton butVentas;
	private JButton butDinero;
	private JLabel labCafe15;
	private JLabel labCafe35;
	private JLabel labDinero;
	private JLabel labVacio1;
	private JLabel labVacio2;
	private JTextField txtCafe15;
	private JTextField txtCafe35;
	private JTextField txtDinero;
	
	
	
	//----RELACION----//
	
	private InterfazVending principal;
	
	/**
	 * Metodo constructor de clase PanelInformación
	 * @param pPrinc permite la relacion con la interfaz
	 */
	
	
	public PanelInformacion(InterfazVending pPrinc){
	
		principal= pPrinc;
		
		setLayout(new GridLayout(3,4));
		TitledBorder border=  BorderFactory.createTitledBorder("Información");
		setBorder(border);
		
		butVentas= new JButton("Ventas");
		butVentas.setActionCommand(VENTAS);
		butVentas.addActionListener((ActionListener) this);
		butVentas.setBounds(new Rectangle(10,500,50,50));
		
		butDinero= new JButton("Dinero");
		butDinero.setActionCommand(DINERO);
		butDinero.addActionListener((ActionListener) this);
		butDinero.setBounds(new Rectangle(10,500,50,50));
		
		labCafe15 = new JLabel("Cafe de 15gr Vendidos");
		txtCafe15 = new JTextField();
		txtCafe15.setEditable(false);
		txtCafe15.setText("0");
		
		labCafe35 = new JLabel("Cafe de 35gr vendidos");
		txtCafe35 = new JTextField();
		txtCafe35.setEditable(false);
		txtCafe35.setText("0");
		
		labDinero = new JLabel("Dinero Recibido");
		txtDinero = new JTextField();
		txtDinero.setEditable(false);
		txtDinero.setText("");
		
		labVacio1 = new JLabel("");
		
		
		labVacio2 = new JLabel("");
		
		
		add(labVacio1);
		add(butVentas);
		add(labVacio2);
		add(butDinero);
		add(labCafe15);
		add(txtCafe15);
		add(labDinero);
		add(txtDinero);
		add(labCafe35);
		add(txtCafe35);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	/**
	 * MEtodo actionPerformsed
	 */

	// TODO Auto-generated method stub
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando= e.getActionCommand();
		
		if(comando.equals(DINERO)){
			txtDinero.setText(""+ principal.darDinero());
	 
		}
		
		else if(comando.equals(VENTAS)){
			txtCafe15.setText(""+principal.darVentas15());
			txtCafe35.setText(""+ principal.darVentas35());
		}
		
		
	}

}
