package mundo;

import java.io.Serializable;
import java.util.Date;

public class Empleado extends Persona  implements Serializable{
	
	
	private String numeroCuenta, tipoContrato, cargo;
	private Date fechaContratacion;

	
	public Empleado(String nombre, String apellido, String numeroId,
			String direccion, String telefono, String celular, String ciudad,
			String pais, String correo, String numeroCuenta, String tipoContrato, String cargo) {
		
		super(nombre, apellido, numeroId, direccion, telefono, celular, ciudad, pais,
				correo);
		
		this.numeroCuenta = numeroCuenta;
		this.tipoContrato= tipoContrato;
		this.cargo = cargo;
	}
	
	
	//get & set
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Date getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public void verificarInvariantes(){ assert numeroCuenta != null && !numeroCuenta.equals(""): "el numero de cuenta es vacio o nulo"; assert tipoContrato != null && !tipoContrato.equals(""): "el tipo contrato es vacio o nulo"; assert cargo != null && !cargo.equals(""): "el cargo es vacio o nulo"; }
	
}
