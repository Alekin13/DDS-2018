package sge.usuario;

import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	private String usuario;
	private String password;
	private String nombre;
	private String apellido;
	private String domicilio;
	private String fecAlta;
	private String rol;
	private String tipoDoc; 
	private String nroDoc;
	private int telefono;
	
	public Usuario() {
	}
	
	public Usuario(String usuario, String password, String nombre, String apellido, String domicilio, String fechaAlta) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.fecAlta = fechaAlta;
	}

	
	
	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFecAlta() {
		return fecAlta;
	}

	public void setFecAlta(String unaFechaC) {
		this.fecAlta = unaFechaC;
	}
	
}