package mundo;
import static org.junit.Assert.*;
import mundo.DivisionEgresados;

import org.junit.Test;


public class DivisionEgresadosTest {
	
	private DivisionEgresados de;
	
	public void setupEscenario1(){
		de = new DivisionEgresados();
		for(int i=0;i<200;i++){
			de.agregarEgresado("A", "B", "123", "300", "@");
		}
	}
	
	@Test
	public void testAsignarPuestoAInvitados() {
		setupEscenario1();
		
		de.asignarPuestoAInvitados();

		//Bloque de Verificación 1
		//Verificar que todos los valores son distintos entre si
		boolean distintos = true;
		for(int i=0;i<de.darEgresados().size() && distintos;i++){
			int puestoI = de.darEgresados().get(i).darNumeroPuesto();
			for(int j=i+1;j<de.darEgresados().size() && distintos;j++){
				int puestoJ = de.darEgresados().get(j).darNumeroPuesto();
				if(puestoI==puestoJ){
					distintos = false;
				}
			}
		}
		
		if(!distintos){
			fail("Los valores generados no son todos diferentes entre si.");
		}
		
		//Bloque de Verificación 2
		//Verificar que han sido asignados los puestos desde el 1 hasta el 200 (en este caso)
		boolean estanTodos = true;
		for(int puesto=1;puesto <= de.darEgresados().size() && estanTodos;puesto++){
			estanTodos = false;
			//buscar cada puesto en los egresados 
			for(int i=0;i < de.darEgresados().size(); i++){
				if(puesto==de.darEgresados().get(i).darNumeroPuesto()){
					estanTodos = true;
				}
			}
		}
		
		//La verificación que hace este método es suficiente únicamente con el segundo 
		//bloque pues si están todos los puestos asignados del 1 al 200 entonces no 
		//puede haber repetidos si solo hay 200 egresados.
		
		if(!estanTodos){
			fail("No se generan todos los valores de los puestos del 1 al "+de.darEgresados().size());
		}
	}
}
