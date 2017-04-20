package mundo;

public abstract class  Persona {
	
	public String nombre, apellido, numeroId, direccion, telefono , celular, ciudad,
	            pais, correo;
	
	
	//constructor
	 public Persona (String nombre, String apellido,String numeroId,String direccion,
			           String telefono ,String celular, String ciudad,String pais,
			           String correo){ 
		   
		 this.nombre = nombre;
		 this.apellido = apellido;
		 this.numeroId = numeroId;
		 this.direccion= direccion;
		 this.telefono= telefono; 
		 this.celular =  celular;
		 this.ciudad =  ciudad;
         this.pais =  pais;
         this.correo = correo;
	 }
	
	//get & set
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNumeroId() {
		return numeroId;
	}
	public void setNumeroId(String numeroId) {
		this.numeroId = numeroId;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	public void verificarInvariantes (){ assert nombre != null && !nombre.equals(""): "el nombre es vacia o nula"; assert apellido != null && !apellido.equals(""): "El apellido es vacio o nulo"; assert direccion != null && !direccion.equals(""): "la direccion es vacia o nula"; assert telefono != null && !telefono.equals(""): "el telefono es vacio o nulo"; assert celular != null && !celular.equals(""): "El celular es vacio o nulo"; assert ciudad != null && !ciudad.equals(""): "la ciudad es vacia o nula"; assert pais != null && !pais.equals(""): "el pais es vacio o nulo"; assert correo != null && !correo.equals(""): "el correo es vacio o nulo"; assert numeroId != null && !numeroId.equals(""): "el numero ID es vacio o nulo"; }
	

}
