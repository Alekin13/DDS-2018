package Usuario;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ADMINISTRADORES")
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

	public long antiguedadEnMeses(String fechaHastaString){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime fechaHasta = LocalDateTime.parse(fechaHastaString, formatter);
		return Period.between(fechaHasta.toLocalDate(),LocalDateTime.now().toLocalDate()).toTotalMonths();
	}

}