package Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;

@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)	
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "rol")
	
public abstract class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	protected int id;
	@Column(name="usuario", unique = true)
	private String usuario;
	@Column(name="password")
	private String password;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="domicilio")
	private String domicilio;
	@Column(name="fecAlta")
	private String fecAlta;

	public Usuario() {
	}

	public Usuario(String usuario, String password, String nombre, String apellido, String domicilio, LocalDateTime fecAlta) {
		super();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.of(fecAlta.getYear(), fecAlta.getMonth(), fecAlta.getDayOfMonth(), fecAlta.getHour(), fecAlta.getMinute());
		String fecAltaDate = dateTime.format(formatter);
		
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.fecAlta = fecAltaDate;
	}

	public Usuario(String usuario2, String password2, String nombre2, String apellido2, String domicilio2, String fecAlta2) {
		super();
		this.usuario = usuario2;
		this.password = password2;
		this.nombre = nombre2;
		this.apellido = apellido2;
		this.domicilio = domicilio2;
		this.fecAlta = fecAlta2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public void setFecAlta(String fecAlta) {
		this.fecAlta = fecAlta;
	}

}