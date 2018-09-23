package sge.usuario;

import java.util.Calendar;

public abstract class Usuario {
	
	private String usuario;
	private String password;
	private String nombre;
	private String apellido;
	private String domicilio;
	private Calendar fecAlta;

	public Usuario() {
	}
	
	public Usuario(String usuario, String password, String nombre, String apellido, String domicilio, Calendar fechaAlta) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.fecAlta = fechaAlta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Calendar getFecAlta() {
		return fecAlta;
	}

	public void setFecAlta(Calendar fecAlta) {
		this.fecAlta = fecAlta;
	}
	
}