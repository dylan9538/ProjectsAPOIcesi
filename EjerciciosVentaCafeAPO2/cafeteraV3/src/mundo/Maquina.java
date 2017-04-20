package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import mundo.PersistenciaException;
import mundo.MateriaPrima;

public class Maquina {

	// ----CONSTANTES---//
	public final static int PRECIO_CAFE_PEQUE = 1000;
	public final static int PRECIO_CAFE_GRANDE = 1200;

	// ------ATRIBUTOS-----//

	private int numeroCafeVend15;
	private int numeroCafeVend35;
	private int dineroRecibido;
	private String ruta;

	// ---RELACIONES----//

	public MateriaPrima materiaPrima;

	// -----CONSTRUCTOR DE LA CLASE----//

	/**
	 * Metodo constructor de clase Maquina
	 * 
	 * @param pNumeroCafeVend15
	 * @param pNumeroCafeVend35
	 * @param pDineroRecibido
	 * @param matePri
	 */

	public Maquina(String ru) throws PersistenciaException {
		ruta = ru;
		cargarInfoMaquinaSeria();
		materiaPrima = new MateriaPrima();
	}

	// -----METODOS-----//

	/**
	 * 
	 */

	public void actualizaAgua(int pAgua) {
		if (pAgua <= materiaPrima.AGUA) {
			materiaPrima.cambiarAgua(pAgua);
		}
	}

	public void actualizaAzucar(int pAzucar) {
		if (pAzucar <= materiaPrima.MAX_AZU) {
			materiaPrima.cambiarAzucar(pAzucar);
		}
	}

	public void actualizaVasos(int pVasos) {
		if (pVasos <= materiaPrima.MAX_VASOS) {
			materiaPrima.cambiarVasos(pVasos);
		}
	}

	public void actualizarCafe(int pCafe) {

		if (pCafe <= materiaPrima.MAX_CAFE) {
			materiaPrima.cambiarCafe(pCafe);
		}
	}

	public void actualizarPitillos(int pPitillos) {

		if (pPitillos <= materiaPrima.MAX_PITILLOS) {
			materiaPrima.cambiarPitillos(pPitillos);
		}
	}
	
	//venta de cafes

	public void venderCafes(int queCafe) throws ExceptionNueva {

		if (materiaPrima.darAgua() < 10) {
			throw new ExceptionNueva("No hay agua en la maquina");
		} else if (materiaPrima.darCafe() < 15.0) {
			throw new ExceptionNueva("No hay cafe en la maquina");
		} else if (materiaPrima.darVasos() < 1) {
			throw new ExceptionNueva("No hay vasos en la maquina");
		} else {
			materiaPrima.cambiarAgua(materiaPrima.darAgua() - 10);
			materiaPrima.cambiarCafe(materiaPrima.darCafe() - queCafe);
			materiaPrima.cambiarVasos(materiaPrima.darVasos() - 1);
			if (materiaPrima.darAzucar() >= 2 && materiaPrima.darPitillos() != 0) {
				materiaPrima.cambiarAzucar(materiaPrima.darAzucar() - 2);
				materiaPrima.cambiarPitillos(materiaPrima.darPitillos() - 1);
			}
			if (queCafe == 15) {
				numeroCafeVend15++;
				dineroRecibido += PRECIO_CAFE_PEQUE;
			} else {
				numeroCafeVend35++;
				dineroRecibido += PRECIO_CAFE_GRANDE;
			}

		}
	}

	public void actualizar(int agu, int azu, int cafe, int piti, int vasos, int cafeVed15, int cafeVend35, int dinero) {

		materiaPrima.cambiarAgua(agu);
		materiaPrima.cambiarCafe(cafe);
		materiaPrima.cambiarVasos(vasos);
		materiaPrima.cambiarAzucar(azu);
		materiaPrima.cambiarPitillos(piti);
		dineroRecibido = dinero;
		numeroCafeVend15 = cafeVed15;
		numeroCafeVend35 = cafeVend35;
	}

	// SERIALIZACION

	public void cargarInfoMaquinaSeria() throws PersistenciaException {
		File archivo = new File(ruta);
		if (archivo.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
				materiaPrima = (MateriaPrima) ois.readObject();
				ois.close();
			} catch (Exception e) {
				throw new PersistenciaException("Imposible restaurar el estado del programa (" + e.getMessage() + ")");
			}
		} else {
			materiaPrima = new MateriaPrima();
		}
	}

	// Salvar archivo
	public void salvarInfo() throws PersistenciaException {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));
			oos.writeObject(materiaPrima.darAgua());
			oos.writeObject(materiaPrima.darAzucar());
			oos.writeObject(materiaPrima.darCafe());
			oos.writeObject(materiaPrima.darPitillos());
			oos.writeObject(materiaPrima.darVasos());

			oos.close();
		} catch (IOException e) {
			throw new PersistenciaException("Error al salvar: ");
		}
	}

	// PRESISTENCIA
	// cargar
	public void cargarInfoMaquina(String ruta) throws IOException {
		File archivo = new File(ruta);
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);

		String lectura = br.readLine();
		String[] split = lectura.split(";");
		actualizar(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]),
				Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]),
				Integer.parseInt(split[6]), Integer.parseInt(split[7]));
		br.close();
		fr.close();
	}

	// guardar
	public void guardarInfoMaquina(String ruta) throws IOException {
		File file = new File(ruta);
		PrintWriter pw = new PrintWriter(file);
		pw.println(materiaPrima.darAgua() + ";" + materiaPrima.darAzucar() + ";" + materiaPrima.darCafe() + ";"
				+ materiaPrima.darPitillos() + ";" + materiaPrima.darVasos() + ";" + numeroCafeVend15 + ";"
				+ numeroCafeVend35 + ";" + dineroRecibido);
		pw.close();
	}

	// ---METODOS DAR Y CAMBIAR---//
	/**
	 * 
	 * @return el numero de cafes de 15gr vendidos
	 */

	public int darNumeroCafeVend15() {
		return numeroCafeVend15;
	}

	/**
	 * 
	 * @return el numero de cafes de 35gr vendidos
	 */
	public int darNumeroCafeVend35() {
		return numeroCafeVend35;
	}

	/**
	 * 
	 * @return el dinero recibido por las ventas
	 */

	public int darDineroRecibido() {
		return dineroRecibido;
	}

	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	/**
	 * 
	 * @param pNumeroCafe15
	 */

	public void cambiarNumeroCafeVend15(int pNumeroCafe15) {
		pNumeroCafe15 = numeroCafeVend15;
	}

	/**
	 * 
	 * @param pNumeroCafe35
	 */

	public void cambiarNumeroCafeVend35(int pNumeroCafe35) {
		pNumeroCafe35 = numeroCafeVend35;
	}

	/**
	 * 
	 * @param pDineroRecibido
	 */

	public void cambiarDineroRecibido(int pDineroRecibido) {
		pDineroRecibido = dineroRecibido;
	}

}
