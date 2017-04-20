package interfaz;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelArchivos extends JPanel implements ActionListener {

	// CONSTANTES
	public final static String CARGAR = "Cargar archivos";
	public final static String GUARDAR = "guardar archivos";

	// ATRIBUTOS
	private JButton butCargar;
	private JButton butGuardar;

	private InterfazVending principal;

	public PanelArchivos(InterfazVending pPrinc) {

		principal = pPrinc;

		setLayout(new GridLayout(1, 2));
		TitledBorder border = BorderFactory.createTitledBorder("Archivos");
		setBorder(border);

		butCargar = new JButton("CARGAR");
		butCargar.setActionCommand(CARGAR);
		butCargar.addActionListener((ActionListener) this);
		butCargar.setBounds(new Rectangle(10, 500, 50, 50));

		butGuardar = new JButton("GUARDAR");
		butGuardar.setActionCommand(GUARDAR);
		butGuardar.addActionListener((ActionListener) this);
		butGuardar.setBounds(new Rectangle(10, 500, 50, 50));

		add(butCargar);
		add(butGuardar);

	}

	@Override
	public void actionPerformed(ActionEvent p) {
		String comando = p.getActionCommand();

		if (comando.equals(CARGAR)) {
			JFileChooser archivos = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("txt", "txt");
			archivos.setFileFilter(filtro);

			int respuesta = archivos.showOpenDialog(principal);
			if (respuesta == JFileChooser.APPROVE_OPTION) {
				File escogido = archivos.getSelectedFile();
				principal.cargar(escogido.getAbsolutePath());
				principal.darAgua();
				principal.darAzucar();
				principal.darCafe();
				principal.darDinero();
				principal.darPitillos();
				principal.darVasos();
				principal.darVentas15();
				principal.darVentas35();

			}

		} else if (comando.equals(GUARDAR)) {

			JFileChooser archivos = new JFileChooser();
			FileNameExtensionFilter prin = new FileNameExtensionFilter("txt", "txt");
			archivos.setFileFilter(prin);

			String ruta = "";
			int respuesta = archivos.showOpenDialog(principal);

			if (respuesta == JFileChooser.APPROVE_OPTION) {
				File escogido = archivos.getSelectedFile();
				ruta = escogido.getAbsolutePath();
				principal.guardar(ruta);
			}
		}
	}
}
