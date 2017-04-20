package icesi.ventabebidas.interfaz;
import icesi.ventabebidas.mundo.VentaDeBebidas;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  
public class PanelVentaBebidaDos extends JPanel implements ActionListener {
	
	
		
		public final static String VASO = "1 vaso";
		public final static String VASOMAS = "+ vasos";
		
		
		private InterfazBebidas principal;
		private JLabel imagen;
		private JButton but1Vaso, butVasosMas;
		private JTextField txtVasos, txtCosto;
		private JLabel labCosto;
		private JPanel grid;
		
		
		public PanelVentaBebidaDos (InterfazBebidas v)
		{
			principal= v;
			
			TitledBorder border = BorderFactory.createTitledBorder("venta de Menta-Limón");
			border.setTitleColor(Color.BLACK);
			setBorder(border);
			
			setLayout(new BorderLayout());
			
			ImageIcon icono = new ImageIcon( "./img/bebidaDos.jpg" );
	        imagen = new JLabel( "" );
	        imagen.setIcon( icono );
	        imagen.setHorizontalAlignment( JLabel.CENTER );
	        imagen.setVerticalAlignment( JLabel.CENTER );
	        imagen.setIcon( icono );

	        add(imagen, BorderLayout.NORTH );
	        
	        but1Vaso = new JButton("1 vaso");
			but1Vaso.setActionCommand(VASO);
			but1Vaso.addActionListener(this);
			add(but1Vaso,BorderLayout.CENTER);
	      
		  grid = new JPanel();
		  grid.setLayout(new GridLayout(2,2));
		  
		  butVasosMas= new JButton("+ vasos");
		  butVasosMas.setActionCommand(VASOMAS);
		  butVasosMas.addActionListener(this);
		  grid.add(butVasosMas);
		  txtVasos = new JTextField();
		  grid.add(txtVasos);
		  
		  labCosto = new JLabel("Costo:");
		  txtCosto = new JTextField(String.valueOf(VentaDeBebidas.PRECIO_POR_DEFECTO_BEBIDA_DOS));
		  grid.add(labCosto);
		  grid.add(txtCosto);
		  
		  add(grid,BorderLayout.SOUTH);
			
			
		}
		
		
		   public String darCostoVaso()
		    {
		     
		    	return txtCosto.getText();
		    	
		    	
		    }
		    
		    public String darCantidadVasos()
		    {
		    	return txtVasos.getText();
		    }


		@Override
		public void actionPerformed(ActionEvent evento) {

			String comando = evento.getActionCommand();

			if (comando.equals(VASO)) {
				try {
					principal.gestionarVenta1VasoBebidaDos();
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this,
							"El costo debe ser numérico", "MATH_ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			if (comando.equals(VASOMAS)) {
				try {
					principal.gestionarVentaVariosVasosBebidaDos();
				} catch (NumberFormatException e) {
					JOptionPane
							.showMessageDialog(
									this,
									"La cantidad de vasos y/o el costo debe ser un valor numérico",
									"MATH_ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}

		}
	
	
	
	
	
	
	

}
