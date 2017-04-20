package test;

import static org.junit.Assert.*;

import org.junit.*;

import mundo.*;

public class AlojamientoTest {

	private Alojamiento alojamiento;

	public void configurarEscenarioUno() {
		this.alojamiento = new Alojamiento("10001");
	}

	public void configurarEscenarioDos() {
		this.alojamiento = new Alojamiento("10001");
		try {
			this.alojamiento.albergarEstudiante(new Estudiante("123",
					Estudiante.TIPO_IDENTIFICACION_CC, "Pepito", "Perez", 20));
		} catch (Exception error) {
			fail("No se debe lanzar excepcion");
		}
	}

	public void configurarEscenarioTres() {
		this.alojamiento = new Alojamiento("10001");
		try {
			Estudiante estudianteUno = new Estudiante("123",
					Estudiante.TIPO_IDENTIFICACION_CC, "Pepito", "Perez", 20);
			Estudiante estudianteDos = new Estudiante("124",
					Estudiante.TIPO_IDENTIFICACION_CC, "Pepita", "Perez", 21);
			Estudiante estudianteTres = new Estudiante("125",
					Estudiante.TIPO_IDENTIFICACION_CC, "Pepite", "Perez", 22);
			Estudiante estudianteCuatro = new Estudiante("126",
					Estudiante.TIPO_IDENTIFICACION_CC, "Pepiti", "Perez", 23);
			Estudiante estudianteCinco = new Estudiante("127",
					Estudiante.TIPO_IDENTIFICACION_CC, "Pepitu", "Perez", 24);
			Estudiante estudianteSeis = new Estudiante("128",
					Estudiante.TIPO_IDENTIFICACION_CC, "Pepitos", "Perez", 25);
			this.alojamiento.albergarEstudiante(estudianteUno);
			this.alojamiento.albergarEstudiante(estudianteDos);
			this.alojamiento.albergarEstudiante(estudianteTres);
			this.alojamiento.albergarEstudiante(estudianteCuatro);
			this.alojamiento.albergarEstudiante(estudianteCinco);
			this.alojamiento.albergarEstudiante(estudianteSeis);
			fail("No debe dejar albergar mas estudiantes ya que se ha excedido la capacidad de alojamiento");
		} catch (Exception error) {
			System.out.println("Excepcion lanzada correctamente: "
					+ error.getMessage());
		}
	}

	@Test
	public void testMetodosDar() {
		this.configurarEscenarioUno();
		assertEquals("El identitifador no esta siendo asignado correctamente",
				"10001", this.alojamiento.darIdentificador());
		assertEquals("La capacidad no esta siendo asignado correctamente", 5,
				this.alojamiento.darCapacidad());
		assertEquals("La distancia no esta siendo asignado correctamente", 80,
				this.alojamiento.darDistancia(), 0);
		assertEquals(
				"El arreglo de estudiantes no esta siendo inicializado correctamente",
				5, this.alojamiento.darEstudiantes().length);
		assertEquals(
				"El precio por persona no esta siendo asignado correctamente",
				12000, this.alojamiento.darPrecioPorPersona(), 0);
	}

	@Test
	public void testCalcularOcupacion() {
		this.configurarEscenarioUno();
		assertEquals("El metodo no retorna el valor esperado", 0,
				this.alojamiento.calcularOcupacion());
		this.configurarEscenarioDos();
		assertEquals("El metodo no retorna el valor esperado", 1,
				this.alojamiento.calcularOcupacion());
		this.configurarEscenarioTres();
		assertEquals("El metodo no retorna el valor esperado", 5,
				this.alojamiento.calcularOcupacion());
	}

	@Test
	public void testCalcularPrecioTotal() {
		this.configurarEscenarioUno();
		assertEquals("El metodo no retorna el valor esperado", 0,
				this.alojamiento.calcularPrecioTotal(), 0);
		this.configurarEscenarioDos();
		assertEquals("El metodo no retorna el valor esperado", 12000 * 1.145,
				this.alojamiento.calcularPrecioTotal(), 0.001);
		this.configurarEscenarioTres();
		assertEquals("El metodo no retorna el valor esperado",
				12000 * 1.145 * 5, this.alojamiento.calcularPrecioTotal(),
				0.001);
	}
	
	@Test
	public void testConstantes() {
		assertEquals(
				"El valor de la constante PORCENTAJE_IMPUESTO debe tener como valor 14.5",
				14.5, Alojamiento.PORCENTAJE_IMPUESTO, 0);
		
	}

}
