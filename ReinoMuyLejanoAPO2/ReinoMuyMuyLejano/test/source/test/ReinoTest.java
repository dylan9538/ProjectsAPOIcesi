package test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import junit.framework.TestCase;
import Mundo.*;

public class ReinoTest extends TestCase {
	private Reino reino1;
	private Reino reino2;
	private Personificacion Personificacion;
	private static final String MASCULINO = "Masculino";
	public static final String FEMENINO = "Femenino";

	// Escenario con datos
	private void setupEscenario1() {
		try {
			File archivo = new File(".data/reino.dat");
			if (archivo.exists()) {
				archivo.delete();
			}
			reino1 = new Reino(".data/reino.dat");

			// Personificaciones que se generan en el serializable (No carga usuarios repetidos)

			reino1.registrarPersonificacion("Burro", "26-03-0900",
					"1144062692", "Masculino", "O+", "Callejo diagon",
					"3768872", "Casado", "20", "Superior", "Amo de casa",
					"Desempleado", 12);

			reino1.registrarPersonificacion("Principe encantador", "11-01-0920", "8908920",
					"Masculino", "A+", "Palacio Hada magica ", "3753095", "Soltero",
					"0", "Primaria", "Guerrero", "Desempleado", 20);

			reino1.registrarPersonificacion("Dragona", "01-01-0001", "96011112768",
					"Femenino", "A+", "Castillo de Fiona ", "3753095", "Casado",
					"20", "Superior", "protectora", "Empleado", 5.0);

			reino1.registrarPersonificacion("Loba vieja", "03-10-0700", "31970295",
					"Femenino", "0+", "Cll 98b 100 45 ", "3750395", "Casado",
					"1", "Superior", "Medico", "loba", 20.0);

			reino1.registrarPersonificacion("Galletita", "23-09-0970", "145123480",
					"Masculino", "0+", "Cra 27 con calle 123", "3934407",
					"Viudo", "2", "Superior", "Programador", "Desempleado", 130.0);

		} catch (Exception e) {
			fail("No debería haber problemas cargando el archivo:"
					+ e.getMessage());
		}
	}

	// Escenario sin datos (Vacio)
	private void setupEscenario2() {
		try {
			File archivo = new File(".data/reino.dat");
			if (archivo.exists()) {
				archivo.delete();
			}

			reino1 = new Reino(".data/reino.dat");
		} catch (Exception e) {
			fail("No debería haber problemas cargando el archivo:"
					+ e.getMessage());
		}
	}

	public void testregistrarPersonificacion() {

		setupEscenario2();

		assertTrue(reino1.registrarPersonificacion("Burro", "26-03-0900",
				"1144062692", "Masculino", "O+", "Callejo diagon",
				"3768872", "Casado", "20", "Superior", "Estudiante",
				"Desempleado", 12));

		assertTrue(reino1.registrarPersonificacion("Principe encantador", "11-01-0920", "8908920",
				"Masculino", "A+", "Palacio Hada magica ", "3753095", "Soltero",
				"0", "Primaria", "Estudiante", "Desempleado", 20));

		assertTrue(reino1.registrarPersonificacion("Dragona", "01-01-0001", "96011112768",
				"Femenino", "A+", "Castillo de Fiona ", "3753095", "Casado",
				"20", "Superior", "Arquitecta", "Empleado", 5.0));

		assertTrue(reino1.registrarPersonificacion("Loba vieja", "03-10-0700", "31970295",
				"Femenino", "0+", "Cll 98b 100 45 ", "3750395", "Casado",
				"1", "Superior", "Medico", "Empleado", 20.0));

		assertTrue(reino1.registrarPersonificacion("Galletita", "23-09-0970", "145123480",
				"Masculino", "0+", "Cra 27 con calle 123", "3934407",
				"Viudo", "2", "Superior", "Programador", "Desempleado", 130.0));

		// assertEquals("El tamaño dado no corresponde al que deberia tener luego de registrar un usuario",reino1.listado().size()
		// > 0, reino1.listado().size() == 5);

	}

	public void testOrganizarTodos() {
		setupEscenario1();
		reino1.ordenarListadoPorFechaDeNacimiento();
		ArrayList<Personificacion> elArray = reino1.darPersonificaciones();
		Personificacion primero = elArray.get(0);
		Personificacion segundo = elArray.get(1);
		Personificacion tercero = elArray.get(2);
		Personificacion cuarto = elArray.get(3);

		assertTrue(
				"Despues de organizarlo el primero no corresponde al menor Personificacion",
				primero.darNombreCompleto().equalsIgnoreCase("Dragona"));

		assertTrue(
				"Despues de organizarlo el primero no corresponde al menor Personificacion",
				segundo.darNombreCompleto().equalsIgnoreCase("Loba vieja"));

		assertTrue(
				"Despues de organizarlo el primero no corresponde al menor Personificacion",
				tercero.darNombreCompleto().equalsIgnoreCase(
						"Burro"));

		assertTrue(
				"Despues de organizarlo el primero no corresponde al menor Personificacion",
				cuarto.darNombreCompleto().equalsIgnoreCase(
						"Principe encantador"));

	}

	public void testOrganizarMujeresPorRH() {
		setupEscenario1();
		reino1.organizarPorRH(FEMENINO);
		ArrayList<Personificacion> elArray = reino1.darRhMujeres();
		Personificacion primero = elArray.get(0);
		Personificacion segundo = elArray.get(1);
		assertTrue(
				"Despues de organizarlo el primero no corresponde al menor Personificacion",
				primero.darNombreCompleto()
						.equalsIgnoreCase("Loba vieja"));
		assertTrue(
				"Despues de organizarlo el primero no corresponde al menor Personificacion",
				segundo.darNombreCompleto().equalsIgnoreCase("Dragona"));

	}

	public void testOrganizarHombresPorRH() {
		setupEscenario1();
		reino1.organizarPorRH(MASCULINO);
		ArrayList<Personificacion> elArray = reino1.darRhHombres();
		Personificacion primero = elArray.get(0);
		Personificacion segundo = elArray.get(1);
		Personificacion tercero = elArray.get(2);

		assertTrue(
				"Despues de organizarlo el primero no corresponde al menor Personificacion",
				primero.darNombreCompleto().equalsIgnoreCase(
						"Galletita"));

		assertTrue(
				"Despues de organizarlo el primero no corresponde al menor Personificacion",
				segundo.darNombreCompleto().equalsIgnoreCase("Principe encantador"));

		assertTrue(
				"Despues de organizarlo el primero no corresponde al menor Personificacion",
				tercero.darNombreCompleto().equalsIgnoreCase(
						"Burro"));

	}

	public void testDesempleadosYConHijos() {
		setupEscenario1();
		reino1.OrdenarPorHijosDesempleados();
		ArrayList<Personificacion> elArray = reino1.darDesempleados();
		Personificacion primero = elArray.get(0);

		assertTrue(
				"Despues de organizarlo el primero no corresponde al menor Personificacion",
				primero.darNombreCompleto().equalsIgnoreCase(
						"Galletita"));

	}

	public void testGuardarResultados() throws IOException {

		setupEscenario1();

		reino1.exportarArchivo("data/ensayo.txt");

		// Usar un StringWriter para que la información de la c
	
		String datosGuardados = reino1.darString(reino1.darPersonificaciones());
		String datosEsperados = "Burro;26-03-0900;1144062692;Masculino;O+;Callejo diagon;3768872;Casado;20;Superior;Amo de casa;Desempleado;12.0"
				+ "\n"
				+ "Principe Encantador;11-01-0920;8908920;Masculino;A+;Palacio Hada magica ;3753095;Soltero;0;Primaria;guerrero;Desempleado;20.0"
				+ "\n"
				+ "Dragona;01-01-0001;96011112768;Femenino;A+;Castillo de Fiona ;3753095;Casado;20;Superior;protectora;Empleado;5.0"
				+ "\n"
				+ "Loba vieja;03-10-0700;31970295;Femenino;0+;Cll 98b 100 45 ;3750395;Casado;1;Superior;Medico;Empleado;20.0"
				+ "\n"
				+ "Galletita;23-09-0970;145123480;Masculino;0+;Cra 27 con calle 123;3934407;Viudo;3;Superior;Programador;Desempleado;130.0"
				+ "\n";

		assertEquals(
				"El formato usado para guardar los datos no es el correcto",
				datosEsperados, datosGuardados);
	}
	
	
	public void testdevolverParaReportes() throws IOException {

		setupEscenario1();

		String datosGuardados = reino1.darString(reino1.darPersonificaciones());
		String datosEsperados = "Burro;26-03-0900;1144062692;Masculino;O+;Callejo diagon;3768872;Casado;20;Superior;Amo de casa;Desempleado;12.0"
				+ "\n"
				+ "Principe Encantador;11-01-0920;8908920;Masculino;A+;Palacio Hada magica ;3753095;Soltero;0;Primaria;guerrero;Desempleado;20.0"
				+ "\n"
				+ "Dragona;01-01-0001;96011112768;Femenino;A+;Castillo de Fiona ;3753095;Casado;20;Superior;protectora;Empleado;5.0"
				+ "\n"
				+ "Loba vieja;03-10-0700;31970295;Femenino;0+;Cll 98b 100 45 ;3750395;Casado;1;Superior;Medico;Empleado;20.0"
				+ "\n"
				+ "Galletita;23-09-0970;145123480;Masculino;0+;Cra 27 con calle 123;3934407;Viudo;3;Superior;Programador;Desempleado;130.0"
				+ "\n";

		assertEquals(
				"El formato usado para guardar los datos no es el correcto",
				datosEsperados, datosGuardados);
	}
	
	

}
