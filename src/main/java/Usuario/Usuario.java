package Usuario;

import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table(name="USUARIOS")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue(value="Usuario")
public abstract class Usuario {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="usuario")
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
	private LocalDateTime fecAlta;
	
	public Usuario() {
	}
	
	public Usuario(String usuario, String password, String nombre, String apellido, String domicilio, LocalDateTime fechaAlta) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.fecAlta = fechaAlta;
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

	public LocalDateTime getFecAlta() {
		return fecAlta;
	}

	public void setFecAlta(LocalDateTime fecAlta) {
		this.fecAlta = fecAlta;
	}
	
}