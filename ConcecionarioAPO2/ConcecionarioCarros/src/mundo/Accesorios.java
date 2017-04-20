package mundo;

import java.io.Serializable;

public class Accesorios implements Serializable {

	private String nombre,descripcion, codigo, restriciones;
	private int costo;
	
	//constructor
	
	public Accesorios(String nombre,String descripcion, String codigo, String restriciones,
			int costo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.restriciones = restriciones;
		this.costo = costo;
	}
	
	//get & set
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getRestriciones() {
		return restriciones;
	}
	public void setRestriciones(String restriciones) {
		this.restriciones = restriciones;
	}
	public int getCosto() {
		return costo;
	}

	public String darDescripcion( ){
		return descripcion;
	}
	
	private void verificarInvariantes(){ assert nombre != null && !nombre.equals(""): "el nombre es vacio o nulo"; assert codigo != null && !codigo.equals(""): "el codigo es vacio o nulo"; assert restriciones != null && !restriciones.equals(""): "las restriciones son vacio"; assert !String.valueOf(costo).endsWith(""): "El costo es igual a 0";}
}
