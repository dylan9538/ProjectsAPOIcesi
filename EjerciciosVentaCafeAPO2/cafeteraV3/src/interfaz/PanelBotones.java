package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale.Category;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import org.omg.CORBA.Principal;

public class PanelBotones extends JPanel implements ActionListener {

	// ------CONSTANTES-------//
	public final static String CAFE15 = "Cafe de 15gr";
	public final static String CAFE35 = "cafe de 35gr";

	// -----ATRIBUTOS-------//
	private InterfazVending inter;
	private JButton cafe15gr;
	private JButton cafe35gr;

	// ------RELACION------//

	private InterfazVending principal;

	/**
	 * Metodo constructor de la clase PanelBotones
	 * 
	 * @param p
	 *            relacion con la interfaz
	 */

	public PanelBotones(InterfazVending p) {

		principal = p;

		setLayout(new GridLayout());
		TitledBorder border = BorderFactory.createTitledBorder("CAFE");
		setBorder(border);

		cafe15gr = new JButton("Cafe 15gr - $1000");
		cafe15gr.setActionCommand(CAFE15);
		cafe15gr.addActionListener((ActionListener) this);
		cafe15gr.setBounds(new Rectangle(10, 500, 50, 50));

		cafe35gr = new JButton("Cafe 35gr - $1200");
		cafe35gr.setActionCommand(CAFE35);
		cafe35gr.addActionListener((ActionListener) this);
		cafe35gr.setBounds(new Rectangle(10, 500, 50, 50));

		add(cafe15gr);
		add(cafe35gr);

	}

	public int seleccionoBoton() {
		if (cafe15gr.isSelected()) {
			return 15;
		} else {
			return 35;
		}
	}

	/**
	 * Metodo actionPerformed
	 */

	// TODO Auto-generated method stub
	@Override

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(CAFE15)) {
			principal.venderCafes();

			cafe15gr.setSelected(true);
			cafe35gr.setSelected(false);

		} else if (comando.equals(CAFE35)) {
			principal.venderCafes();
			cafe15gr.setSelected(false);
			cafe35gr.setSelected(true);

		}
	}

}
