package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelBotones extends JPanel implements ActionListener {

	private final static String CALCULAR_COSTO_TOTAL = "Calcular costo total";
	private final static String CALCULAR_COSTO_GASOLINA = "Calcular costo gasolina";
	private final static String GENERAR_REPORTE_ESTUDIANTES_ALOJADOS = "Reporte de estudiantes alojados";

	private VentanaPaseo ventanaPaseo;

	/**
	 * Create the panel.
	 */
	public PanelBotones(VentanaPaseo ventanaPaseo) {
		this.ventanaPaseo = ventanaPaseo;

		this.setLayout(new GridLayout(1, 3));

		JButton btnCalcularCostoTotal = new JButton(CALCULAR_COSTO_TOTAL);
		btnCalcularCostoTotal.addActionListener(this);
		btnCalcularCostoTotal.setActionCommand(CALCULAR_COSTO_TOTAL);

		this.add(btnCalcularCostoTotal);

		JButton btnCalcularCostoGasolina = new JButton(CALCULAR_COSTO_GASOLINA);
		btnCalcularCostoGasolina.addActionListener(this);
		btnCalcularCostoGasolina.setActionCommand(CALCULAR_COSTO_GASOLINA);

		this.add(btnCalcularCostoGasolina);

		JButton btnGenerarReporteEstudiantesAlojados = new JButton(
				GENERAR_REPORTE_ESTUDIANTES_ALOJADOS);
		btnGenerarReporteEstudiantesAlojados.addActionListener(this);
		btnGenerarReporteEstudiantesAlojados
				.setActionCommand(GENERAR_REPORTE_ESTUDIANTES_ALOJADOS);
		
		this.add(btnGenerarReporteEstudiantesAlojados);

	}

	public void actionPerformed(ActionEvent event) {
		String respuesta = "";
		if (event.getActionCommand().equals(CALCULAR_COSTO_TOTAL)) {
			respuesta = "El costo total del paseo es "
					+ this.ventanaPaseo.calcularCostoTotal();
		} else if (event.getActionCommand().equals(CALCULAR_COSTO_GASOLINA)) {
			respuesta = "El costo en gasolina es "
					+ this.ventanaPaseo.calcularCostoGasolina();
		} else if (event.getActionCommand().equals(
				GENERAR_REPORTE_ESTUDIANTES_ALOJADOS)) {
			respuesta = this.ventanaPaseo.generarReporteEstudiantesAlojados();
		}

		JOptionPane.showMessageDialog(this.ventanaPaseo, respuesta, "Resultado",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
