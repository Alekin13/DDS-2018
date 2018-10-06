package Usuario;

import java.time.LocalDateTime;
import java.time.Period;
import javax.persistence.*;

@Entity
@DiscriminatorValue("Administrador")
public class Administrador extends Usuario {

	@OneToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="id")
	private Usuario usuario;
	@Column(name="identificadorSistema")
	private int idAdmin;
	
	public Administrador() {
		super();
	}

	public Administrador(String usuario, String password, String nombre, String apellido, String domicilio, LocalDateTime fechaAlta, int idAdmin) { 
		super(usuario, password, nombre, apellido, domicilio, fechaAlta);
		this.idAdmin = idAdmin;
	}
		
	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public long antiguedadEnMeses(LocalDateTime fechaHasta){
		return Period.between(fechaHasta.toLocalDate(),LocalDateTime.now().toLocalDate()).toTotalMonths();
	}

}