package test;

import static org.junit.Assert.*;

import org.junit.*;

import mundo.*;

public class EstudianteTest {

	private Estudiante estudiante;

	public void configurarEscenarioUno() {
		this.estudiante = new Estudiante("123",
				Estudiante.TIPO_IDENTIFICACION_CC, "Pepito", "Perez", 20);
	}

	@Test
	public void testMetodosDar() {
		this.configurarEscenarioUno();
		assertEquals("El nombre no esta siendo asignado correctamente",
				"Pepito", this.estudiante.darNombre());
		assertEquals("Los apellidos no estan siendo asignados correctamente",
				"Perez", this.estudiante.darApellidos());
		assertEquals(
				"El tipo de identificacion no esta siendo asignado correctamente",
				Estudiante.TIPO_IDENTIFICACION_CC,
				this.estudiante.darTipoIdentificacion());
		assertEquals(
				"El numero de identificacion no esta siendo asignado correctamente",
				"123",
				this.estudiante.darNumeroIdentificacion());
		assertEquals(
				"La edad no esta siendo asignado correctamente",
				20,
				this.estudiante.darEdad());
	}

	@Test
	public void testConstantes() {
		assertEquals(
				"El valor de la constante TIPO_IDENTIFICACION_CC debe tener como valor CC",
				"CC", Estudiante.TIPO_IDENTIFICACION_CC);
		assertEquals(
				"El valor de la constante TIPO_IDENTIFICACION_TI debe tener como valor TI",
				"TI", Estudiante.TIPO_IDENTIFICACION_TI);
	}

}
