package test;

import static org.junit.Assert.*;

import org.junit.*;

import mundo.*;

public class VehiculoTest {

	private Vehiculo vehiculo;
	
	private Alojamiento alojamiento;
	
	private void configurarEscenarioUno() {
		try{
			this.alojamiento = new Alojamiento("10001");
			this.vehiculo = new Vehiculo("AUI123", "Economico");
			this.vehiculo.cambiarAlojamiento(this.alojamiento);
		}catch(Exception error){
			fail("No debe lanzar excepcion. El formato de placa es correcto y el tipo de vehiculo es valido.");
		}
	}
	
	private void configurarEscenarioDos() {
		try{
			this.vehiculo = new Vehiculo("AUI123", "Economicos");
			fail("Debe lanzar excepcion porque el tipo de vehiculo no es valido");
		}catch(Exception error){
			System.out.println("Excepcion lanzada correctamente: " + error.getMessage());
		}
	}
	
	private void configurarEscenarioTres() {
		try{
			this.vehiculo = new Vehiculo("aeI123", "Economico");
			fail("Debe lanzar excepcion porque la placa no respeta el formato");
		}catch(Exception error){
			System.out.println("Excepcion lanzada correctamente: " + error.getMessage());
		}
	}
	
	private void configurarEscenarioCuatro() {
		try{
			this.vehiculo = new Vehiculo("AUI123", "Medio");
		}catch(Exception error){
			fail("No debe lanzar excepcion. El formato de placa es correcto y el tipo de vehiculo es valido.");
		}
	}
	
	private void configurarEscenarioCinco() {
		try{
			this.vehiculo = new Vehiculo("AUI123", "Lujo");
		}catch(Exception error){
			fail("No debe lanzar excepcion. El formato de placa es correcto y el tipo de vehiculo es valido.");
		}
	}
	
	@Test
	public void testConstructor(){
		this.configurarEscenarioUno();
		this.configurarEscenarioDos();
		this.configurarEscenarioTres();
	}
	
	@Test
	public void testMetodosDar(){
		this.configurarEscenarioUno();
		
		assertEquals("La capacidad de kilometros por galon no esta siendo asignada correctamente",
				60, this.vehiculo.darCapacidadKilometrosPorGalon(), 0);
		assertEquals("El alojamiento no esta siendo asignado correctamente",
				this.alojamiento, this.vehiculo.darAlojamiento());
		
		this.configurarEscenarioCuatro();
		
		assertEquals("La capacidad de kilometros por galon no esta siendo asignada correctamente",
				45, this.vehiculo.darCapacidadKilometrosPorGalon(), 0);
		
		this.configurarEscenarioCinco();
		
		assertEquals("La capacidad de kilometros por galon no esta siendo asignada correctamente",
				30, this.vehiculo.darCapacidadKilometrosPorGalon(), 0);
	}
	
	@Test
	public void testCalcularCantidadGasolinaNecesaria(){
		this.configurarEscenarioUno();
		
		assertEquals("La cantidad de gasolina necesaria no es correcta. Revise los calculos.",
				1.333, this.vehiculo.calcularCantidadGasolinaNecesaria(), 0.001);
	}

}
