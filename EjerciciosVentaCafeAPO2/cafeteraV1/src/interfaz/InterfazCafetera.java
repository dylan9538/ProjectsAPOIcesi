package interfaz;

import java.awt.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import mundo.*;

@SuppressWarnings("serial")
public class InterfazCafetera extends JFrame {

	private static final String LOG_FILE = "./data/error.log";
	
	private Cafetera cafetera;
	private ArrayList<PanelRecurso> panelesRecurso;
	private PanelVenta panelVenta;

	public InterfazCafetera() {
		setTitle("Cafetería Autoservicio Dr. Café S.A. soportada por Vending Inc.");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		cafetera = new Cafetera();
		panelesRecurso = new ArrayList<PanelRecurso>();

		JPanel arriba = new JPanel();
		arriba.add(new JLabel(new ImageIcon("data/img/encabezado.jpg")));
		add(arriba, BorderLayout.NORTH);

		JPanel panRecursos = new JPanel();
		panRecursos.setLayout(new GridLayout(2, 0));
		panRecursos.setBorder(new TitledBorder("Recursos"));

		ArrayList<Recurso> recursos = cafetera.getIngredientes();
		for (int i = 0; i < recursos.size(); i++) {
			PanelRecurso panelRecursoActual = new PanelRecurso(this,
					recursos.get(i));
			panelesRecurso.add(panelRecursoActual);
			panRecursos.add(panelRecursoActual);
		}

		add(panRecursos, BorderLayout.CENTER);

		panelVenta = new PanelVenta(this);
		add(panelVenta, BorderLayout.EAST);

		pack();
	}

	public void abastecerRecurso(int idRecurso)  {
		PanelRecurso elPanelRecurso = panelesRecurso.get(idRecurso);
		Recurso elRecurso = cafetera.getIngredientes().get(idRecurso);

		String suministroDigitado = elPanelRecurso.darCantidadAbastecer();
		try {
			double suministro = Double.parseDouble(suministroDigitado);
			try {
				elRecurso.abastecer(suministro);
				JOptionPane.showMessageDialog(this,
						"Se han agregado correctamente " + suministro + " "
								+ elRecurso.darUnidad() + " a las reservas de "
								+ elRecurso.darNombre());
				elPanelRecurso.limpiarCantidadAbastecer();
				elPanelRecurso.actualizarRecurso();
				
			} catch (SuministroRecursoException e) {
				JOptionPane.showMessageDialog(this,"El valor a suministrar supera el maximo permitido");
	                 }
		
		} catch (NumberFormatException ex) {

			JOptionPane
					.showMessageDialog(
							this,
							ex.getClass()
									+ "\nEl valor digitado en el campo de\ntexto debe ser un número real");

		}
	}

	public void venderCafe() {
		try {
			String numero = JOptionPane
					.showInputDialog(
							"Por favor confirme (o modifique) la cantidad de café (en gr)\na usar en su pedido. 15gr o 30gr",
							/*
							 * Este es el valor por defecto para el café
							 * (posición 0)
							 */
							cafetera.getIngredientes().get(0)
									.darCantidadXCafe());

			if (numero == null) {

				JOptionPane
						.showMessageDialog(this,
								"Parece que se ha arrepentido de pedir\nel café pues ha cancelado la operación");

			} else {

				double cantidadCafe = Double.parseDouble(numero);
				
				if(cantidadCafe ==15.0 || cantidadCafe == 30.0){
					try {
						cafetera.venderCafe(cantidadCafe); 
						actualizarRecursos();
						
					} catch (ImposiblePrepararCafeException ex) {
						JOptionPane
						.showMessageDialog(this,"Imposible preparar cafe");
						cafetera.resgistrarError(ex);

					} catch (CafeIncompletoException e) {
						int se = JOptionPane.showOptionDialog(null,
								"¿Desea comprar el cafe de todas maneras?",
								"Seleccione una opción",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,
								new Object[] { "Si", "No" },
								"Si");
						
					if (se != -1)
						{
						   if((se + 1)==1)
						   {
						     cafetera.venderCafeIncompleto(cantidadCafe);
						     actualizarRecursos();
						   }
						    }               
				      }
		}else{
					JOptionPane
					.showMessageDialog(
							this,
							"Lo sentimos, la máquina de café sólo trabaja con cargas de café de 15gr o 30gr.");
					
				}
			}
		} catch (NumberFormatException ex) {

			JOptionPane
					.showMessageDialog(
							this,
							ex.getClass()
									+ "\nEl valor digitado en el campo de\ntexto debe ser un número real");

		}
	}
	
	public void resgistrarError(Exception e){
		try{
			FileWriter out =  new FileWriter(LOG_FILE,true);
		    PrintWriter log = new PrintWriter(out);

		    log.println("---------------------------------------");
		    log.println("LALA");
	        log.println("--------------------------------------");
		    e.printStackTrace(log);

		       log.close();
		       out.close();
		}catch(Exception ex){
			e.printStackTrace();
			ex.printStackTrace();
		}
		
	}

	public void reporteDineroVentas() {
		JOptionPane.showMessageDialog(
				this,
				"El dinero gerado por las ventas es: $"
						+ cafetera.getDineroEnVentas());
	}

	public void reporteCafesVendidos() {
		JOptionPane.showMessageDialog(
				this,
				"La cantidad de cafés vendidos de 15gr: "
						+ cafetera.getCafesVendidos15gr() + " y de 35gr es: "
						+ cafetera.getCafesVendidos30gr());
	}

	public void actualizarRecursos() {
		for (int i = 0; i < panelesRecurso.size(); i++) {
			panelesRecurso.get(i).actualizarRecurso();
		}
	}
	
	

	public static void main(String[] args) {
		InterfazCafetera ventana = new InterfazCafetera();
		ventana.setVisible(true);
	}
}
