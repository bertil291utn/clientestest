package testclientes01.model;

public class Cliente {
	protected int cod;
	protected int ci;
	protected String nombre;
	protected String apellido;
	protected String contrasena;
	protected String direccion;
	protected String estado;
	protected String mail;
	protected String telefono;

	public Cliente(int cod, int ci, String nombre, String apellido, String contrasena, String direccion, String estado,
			String mail, String telefono) {
		super();
		this.cod = cod;
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.estado = estado;
		this.mail = mail;
		this.telefono = telefono;
	}

	public Cliente(int ci, String nombre, String apellido, String contrasena, String direccion, String estado,
			String mail, String telefono) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.estado = estado;
		this.mail = mail;
		this.telefono = telefono;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}// end class
