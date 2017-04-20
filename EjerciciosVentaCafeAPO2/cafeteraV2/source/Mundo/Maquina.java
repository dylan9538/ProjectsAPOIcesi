package Mundo;

import java.util.ArrayList;

/**
 * Clase Maquina.
 *
 * @author JorgeAndres. Created 23/01/2016.
 */
public class Maquina {

	private ArrayList<MateriaPrima> inventario;

	private double dineroRecaudado;
	private int cantidadVentas;
	private String ubicacion;
	private String codigo;
	private String datosEstablecimiento;
	private String nombreTecnico;
	private String telTecnico;
	private int cafe15;
	private int cafe35;

	/**
	 * Metodo Construtor de Maquina.
	 *
	 */
	public Maquina() {

		modificarCafe15(0);
		modificarCafe35(0);
		modificarDineroRecaudado(0);
		modificarCantidadVentas(0);

		this.inventario = new ArrayList<MateriaPrima>();

		this.inventario.add(new MateriaPrima("Azucar", 100));
		this.inventario.add(new MateriaPrima("Cafe", 450));
		this.inventario.add(new MateriaPrima("Vasos", 50));
		this.inventario.add(new MateriaPrima("Pitillos", 50));
		this.inventario.add(new MateriaPrima("Agua", 18900));

	}

	public void venderCafeOpcional(int cantidad) {

		inventario.get(1).modificarCantidad(inventario.get(1).darCantidad() - cantidad);
		inventario.get(4).modificarCantidad(inventario.get(4).darCantidad() - 10);
		if (inventario.get(0).darCantidad() < 2) {
			if (inventario.get(0).darCantidad() == 1) {
				inventario.get(0).modificarCantidad(inventario.get(0).darCantidad() - 1);
			}
		} else {
			inventario.get(0).modificarCantidad(inventario.get(0).darCantidad() - 2);
		}

		cantidadVentas++;

		if (cantidad == 15) {
			cafe15++;
			modificarDineroRecaudado(dineroRecaudado + 1000);
		} else {
			cafe35++;
			modificarDineroRecaudado(dineroRecaudado + 1200);
		}

		if (inventario.get(3).darCantidad() != 0) {
			inventario.get(3).modificarCantidad(inventario.get(3).darCantidad() - 1);
		}
	}

	// if (inventario.get(1).darCantidad() - cantidad >= 0 &&
	// inventario.get(5).darCantidad() - 10 >= 0) {

	public void venderCafe(double cantidadCafe) throws VenderExepcion, VentaOpcionalExepcion {

		if (inventario.get(1).darCantidad() - cantidadCafe < 0) {
			throw new VenderExepcion("Error 1: Se acabo el cafe");
		} else if (inventario.get(4).darCantidad() - 10 < 0) {
			throw new VenderExepcion("Error 2 : Se acabo el agua");
		} else if (inventario.get(2).darCantidad() == 0) {
			throw new VenderExepcion("Error 3: Se acabaron los vasos");
		} else if (inventario.get(3).darCantidad() == 0 || inventario.get(0).darCantidad() < 2) {
			String mensaje = "";
			if (inventario.get(3).darCantidad() == 0) {
				mensaje = "No tenemos disponibles pitillos \n";
			}
			if (inventario.get(0).darCantidad() < 2) {
				if (inventario.get(0).darCantidad() == 1) {
					mensaje += "Solo tenemos un sobre de azucar disponible \n";
				} else {
					mensaje += "No Tenemos sobre de azucar disponibles \n";
				}
			}
			mensaje += "A pesar de ello ¿Desea comprar el cafe?";
			throw new VentaOpcionalExepcion(mensaje);
		} else {
			inventario.get(0).modificarCantidad(inventario.get(0).darCantidad() - 2);
			inventario.get(1).modificarCantidad(inventario.get(1).darCantidad() - cantidadCafe);
			inventario.get(2).modificarCantidad(inventario.get(2).darCantidad() - 1);
			inventario.get(3).modificarCantidad(inventario.get(3).darCantidad() - 1);
			inventario.get(4).modificarCantidad(inventario.get(4).darCantidad() - 10);

			cantidadVentas++;

			if (cantidadCafe == 15) {
				cafe15++;
				modificarDineroRecaudado(dineroRecaudado + 1000);
			} else {
				cafe35++;
				modificarDineroRecaudado(dineroRecaudado + 1200);
			}

		}

	}

	public String informacionInventario() {

		return inventario.get(0).darNombre() + " : " + inventario.get(0).darCantidad() + "\n"
				+ inventario.get(1).darNombre() + " : " + inventario.get(1).darCantidad() + "\n"
				+ inventario.get(2).darNombre() + " : " + inventario.get(2).darCantidad() + "\n"
				+ inventario.get(3).darNombre() + " : " + inventario.get(3).darCantidad() + "\n"
				+ inventario.get(4).darNombre() + " : " + inventario.get(4).darCantidad();

	}

	public String informacionVentas() {

		return "Total dinero Recaudado : " + dineroRecaudado + "\n" + "Total cafes 15 gr vendidos : " + cafe15 + "\n"
				+ "Total cafes 35 gr vendidos : " + cafe35;
	}

	/**
	 * 
	 * @param materia
	 * @param cantidad
	 * @throws MiPropiaExepcion
	 */
	public void recargarMateriaPrima(String materia, double cantidad) throws MiPropiaExepcion {

		boolean parar = false;

		for (int i = 0; i < inventario.size() && !parar; i++) {

			if (materia.equals(inventario.get(i).darNombre())) {

				if (inventario.get(i).darCantidad() + cantidad <= inventario.get(i).darCantidadMaxima()) {

					inventario.get(i).modificarCantidad(inventario.get(i).darCantidad() + cantidad);

				} else {

					throw new MiPropiaExepcion(
							"No es Posible recargar tal Cantidad por favor ingrese una menor o igual a :"
									+ (inventario.get(i).darCantidadMaxima() - inventario.get(i).darCantidad()));
				}

			}

		}

	}

	public double darDineroRecaudado() {
		return dineroRecaudado;
	}

	public void modificarDineroRecaudado(double dineroRecaudado) {
		this.dineroRecaudado = dineroRecaudado;
	}

	public int darCantidadVentas() {
		return cantidadVentas;
	}

	public void modificarCantidadVentas(int cantidadVentas) {
		this.cantidadVentas = cantidadVentas;
	}

	public String darCodigo() {
		return codigo;
	}

	public void modificarCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String darUbicacion() {
		return ubicacion;
	}

	public void modificarUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String darDatosEstablecimiento() {
		return datosEstablecimiento;
	}

	public void modificarDatosEstablecimiento(String datosEstablecimiento) {
		this.datosEstablecimiento = datosEstablecimiento;
	}

	public String darNombreTecnico() {
		return nombreTecnico;
	}

	public void modificarNombreTecnico(String nombreTecnico) {
		this.nombreTecnico = nombreTecnico;
	}

	public String darTelTecnico() {
		return telTecnico;
	}

	public void modificarTelTecnico(String telTecnico) {
		this.telTecnico = telTecnico;
	}

	public int darCafe15() {
		return cafe15;
	}

	public void modificarCafe15(int cafe15) {
		this.cafe15 = cafe15;
	}

	public int darCafe35() {
		return cafe35;
	}

	public void modificarCafe35(int cafe35) {
		this.cafe35 = cafe35;
	}

}
