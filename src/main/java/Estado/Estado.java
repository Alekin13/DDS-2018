package Estado;

import javax.persistence.*;

@Entity
@Table(name="ESTADOS")
public abstract class Estado {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="clave")
	private String clave;
	
	public Estado(){
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public abstract String getClave();
	public abstract String getDescripcion();
	public abstract boolean estaEncendido();
	public abstract boolean estaApagado();	
	public abstract boolean estaEnModoAhorro();

}