package main.java.sge.modelos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Calendar;

/**
 * Clase Usuario
 * @author Alejandro Mattioli
 *
 */
 
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "usuario", "password", "nombre", "apellido", "domicilio", "fechaAlta"})

public abstract class Usuario {
	
	@JsonProperty("usuario")
	private String usuario;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("nombre")
	private String nombre;
	
	@JsonProperty("apellido")
	private String apellido;
	
	@JsonProperty("domicilio")
	private String domicilio;
	
	@JsonProperty("fechaAlta")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Calendar fecAlta;

	public Usuario() {

	}
	
	public Usuario(String valorUsuario, String valorpassword, String valorNombre, String valorApellido, String valorDomicilio, Calendar valorFechaAlta) {
		super();
		this.usuario = valorUsuario;
		this.password = valorpassword;
		this.nombre = valorNombre;
		this.apellido = valorApellido;
		this.domicilio = valorDomicilio;
		this.fecAlta = valorFechaAlta;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return the fecAlta
	 */
	public Calendar getFecAlta() {
		return fecAlta;
	}

	/**
	 * @param fecAlta the fecAlta to set
	 */
	public void setFecAlta(Calendar fecAlta) {
		this.fecAlta = fecAlta;
	}
	
}
