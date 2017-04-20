package test;

import static org.junit.Assert.*;

import mundo.*;

import org.junit.*;

public class PaseoTest {

	private Paseo paseo;

	private void configurarEscenarioUno() {
		this.paseo = new Paseo();
	}

	@Test
	public void testConstructor() {
		this.configurarEscenarioUno();

		assertNotNull("El arraylist de estudiantes debe estar inicializado",
				this.paseo.darEstudiantes());
		assertNotNull("El arraylist de alojamientos debe estar inicializado",
				this.paseo.darAlojamientos());
		assertNotNull("El arraylist de vehiculos debe estar inicializado",
				this.paseo.darVehiculos());
	}

	@Test
	public void testRegistrarEstudiante() {
		this.configurarEscenarioUno();
		try {
			this.paseo.registrarEstudiante("123", "CC", "Pepito", "Perez", 20);
		} catch (Exception error) {
			fail("No debe lanzar excepcion.");
		}

		try {
			this.paseo.registrarEstudiante("123", "CC", "Pepito", "Perez", 20);
			fail("Debe lanzar excepcion. El estudiante ya esta registrado.");
		} catch (Exception error) {
			System.out.println("Excepcion lanzada correctamente: "
					+ error.getMessage());
		}
	}

	@Test
	public void testRegistrarAlojamiento() {
		this.configurarEscenarioUno();
		try {
			this.paseo.registrarAlojamiento("10001");
		} catch (Exception error) {
			fail("No debe lanzar excepcion.");
		}

		try {
			this.paseo.registrarAlojamiento("10001");
			fail("Debe lanzar excepcion. El alojamiento ya esta registrado.");
		} catch (Exception error) {
			System.out.println("Excepcion lanzada correctamente: "
					+ error.getMessage());
		}
	}

	@Test
	public void testRegistrarVehiculo() {
		this.configurarEscenarioUno();
		try {
			this.paseo.registrarVehiculo("AUI123", "Economico");
		} catch (Exception error) {
			fail("No debe lanzar excepcion.");
		}

		try {
			this.paseo.registrarVehiculo("AUI123", "Economico");
			fail("Debe lanzar excepcion. El vehiculo ya esta registrado.");
		} catch (Exception error) {
			System.out.println("Excepcion lanzada correctamente: "
					+ error.getMessage());
		}
	}

	@Test
	public void testAlojarEstudiante() {
		this.configurarEscenarioUno();
		try {
			this.paseo.registrarEstudiante("123", "CC", "Pepito", "Perez", 20);
			this.paseo.registrarAlojamiento("10001");
			assertEquals(
					"El estudiante debe ser alojado y el metodo debe retornar true",
					true, this.paseo.alojarEstudiante("10001", "CC", "123"));
		} catch (Exception error) {
			fail("No debe lanzar excepcion");
		}
	}

	@Test
	public void testAsignarAlojamientoVehiculo() {
		this.configurarEscenarioUno();
		try {
			this.paseo.registrarVehiculo("AUI123", "Economico");
			this.paseo.registrarAlojamiento("10001");
			this.paseo.registrarAlojamiento("10002");
			assertEquals(
					"El alojamiento debe ser asignado al vehiculo y debe retornar true",
					true,
					this.paseo.asignarAlojamientoVehiculo("10001", "AUI123"));
			assertEquals(
					"El alojamiento no puede ser asignado al vehiculo y debe retornar false",
					false,
					this.paseo.asignarAlojamientoVehiculo("10002", "AUI123"));
		} catch (Exception error) {
			fail("No debe lanzar excepcion");
		}
	}

	@Test
	public void testCalcularCostoTotalGasolina() {
		this.configurarEscenarioUno();
		try {
			this.paseo.registrarVehiculo("AUI123", "Economico");
			this.paseo.registrarVehiculo("AUI124", "Lujo");
			this.paseo.registrarAlojamiento("10001");
			this.paseo.registrarAlojamiento("10002");
			this.paseo.asignarAlojamientoVehiculo("10001", "AUI123");
			this.paseo.asignarAlojamientoVehiculo("10002", "AUI124");
			assertEquals("El costo no es el esperado. Revise los calculos.",
					32000, this.paseo.calcularCostoTotalGasolina(), 0.001);
		} catch (Exception error) {
			fail("No debe lanzar excepcion");
		}
	}

	@Test
	public void testCalcularCostoTotalAlojamiento() {
		this.configurarEscenarioUno();
		try {
			this.paseo.registrarAlojamiento("10001");
			this.paseo.registrarAlojamiento("10002");
			this.paseo.registrarEstudiante("123", "CC", "Pepito", "Perez", 20);
			this.paseo.registrarEstudiante("124", "CC", "Pepita", "Perez", 20);
			this.paseo.registrarEstudiante("125", "CC", "Pepitu", "Perez", 20);
			this.paseo.alojarEstudiante("10001", "CC", "123");
			this.paseo.alojarEstudiante("10001", "CC", "124");
			this.paseo.alojarEstudiante("10002", "CC", "125");
			assertEquals("El costo no es el esperado. Revise los calculos.",
					3 * 1.145 * 12000,
					this.paseo.calcularCostoTotalAlojamiento(), 0.001);
		} catch (Exception error) {
			fail("No debe lanzar excepcion");
		}
	}

	@Test
	public void testGenerarReporte() {
		this.configurarEscenarioUno();
		try {
			this.paseo.registrarAlojamiento("10001");
			this.paseo.registrarAlojamiento("10002");
			this.paseo.registrarEstudiante("123", "CC", "Pepito", "Perez", 20);
			this.paseo.registrarEstudiante("124", "CC", "Pepita", "Perez", 20);
			this.paseo.registrarEstudiante("125", "CC", "Pepitu", "Perez", 20);

			assertEquals("La cadena no es la esperada",
					"No hay estudiantes con alojamiento",
					this.paseo.generarReporteEstudiantesAlojados());

			this.paseo.alojarEstudiante("10001", "CC", "123");
			this.paseo.alojarEstudiante("10001", "CC", "124");
			this.paseo.alojarEstudiante("10002", "CC", "125");

			/*
			 * reporte += ++contador + ". " + estudiante.darTipoIdentificacion()
			 * + " - " + estudiante.darNumeroIdentificacion() + ", " +
			 * estudiante.darNombre() + " " + estudiante.darApellidos() +
			 * ", Alojamiento " + alojamiento.darIdentificador() + "\n\n";
			 */
			String reporte = "Estudiantes inscritos\n\n\n"
					+ "1. CC - 123, Pepito Perez, Alojamiento 10001\n\n"
					+ "2. CC - 124, Pepita Perez, Alojamiento 10001\n\n"
					+ "3. CC - 125, Pepitu Perez, Alojamiento 10002\n\n";
			assertEquals("La cadena no es la esperada", reporte,
					this.paseo.generarReporteEstudiantesAlojados());
		} catch (Exception error) {
			fail("No debe lanzar excepcion");
		}
	}

	@Test
	public void testConstantes() {
		assertEquals(
				"El valor de la constante PRECIO_GALON_GASOLINA debe tener como valor 8000",
				8000, Paseo.PRECIO_GALON_GASOLINA, 0);
	}

}
