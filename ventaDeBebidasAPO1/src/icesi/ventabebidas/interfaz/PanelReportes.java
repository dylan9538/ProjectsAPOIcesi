package icesi.ventabebidas.interfaz;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
public class PanelReportes extends JPanel {


	
	private JLabel labBebidaUna, labBebidaDos,labMayoresVentas,labUnVaso, labTransacciones;
	
	private JTextField txtBebidaUna, txtBebidaDos, txtMayoresVentas, txtUnVaso, txtTransacciones;
	
	
	
	public PanelReportes()
	{
		TitledBorder border = BorderFactory.createTitledBorder("Reportes");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		setLayout(new GridLayout(5,2));
		

		
		labBebidaUna = new JLabel("Naranja-Limón:");
        labBebidaDos = new JLabel ("Menta-Limón:");
        labMayoresVentas = new JLabel("Mayores Ventas:");
        labUnVaso = new JLabel("+ Vasos en 1 venta:");
        labTransacciones = new JLabel("Transacciones:");
        
        txtBebidaUna = new JTextField();
		txtBebidaUna.setForeground(Color.BLUE);
		txtBebidaUna.setEditable(false);
		txtBebidaDos =  new JTextField();
		txtBebidaDos.setForeground(Color.BLUE);
		txtBebidaDos.setEditable(false);
		txtMayoresVentas = new JTextField();
		txtMayoresVentas.setForeground(Color.BLUE);
		txtMayoresVentas.setEditable(false);
		txtUnVaso =  new JTextField();
		txtUnVaso.setForeground(Color.BLUE);
		txtUnVaso.setEditable(false);
		txtTransacciones =  new JTextField();
		txtTransacciones.setForeground(Color.BLUE);
		txtTransacciones.setEditable(false);
		
		
        
        add(labBebidaUna);
        add(txtBebidaUna);
        add(labBebidaDos);
        add(txtBebidaDos);
        add(labMayoresVentas);
        add(txtMayoresVentas);
        add(labUnVaso);
        add(txtUnVaso);
        add(labTransacciones);
        add(txtTransacciones);
		
		
	
		
	}
	
	
	public void refrescarVentasBebidaUno(double total)
	{

	   txtBebidaUna.setText(String.valueOf("$"+total));
	  
		
	}
	
	public void refrescarVentasBebidaDos(double total)
	{

	   txtBebidaDos.setText(String.valueOf("$"+total));
	  
		
	}
	
	public void refrescarBebidaConMasVentas(String masVentas)
	{
		txtMayoresVentas.setText(masVentas);
	}
	
	public void refrescarMayorVasosEn1Venta(String mayorVasos)
	{
		txtUnVaso.setText(mayorVasos);
	}
	
	public void refrescarMayorTransacciones(String mayorTransa)
	{
		txtTransacciones.setText(mayorTransa);
	}
	
}
