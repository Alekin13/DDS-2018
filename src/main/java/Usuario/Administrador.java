package Usuario;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Administrador")
@Table(name = "Administrador")
@DiscriminatorValue("2")
public class Administrador extends Usuario {

	@Column(name="idAdmin")
	private int idAdmin;
	
	public Administrador() {
		super();
	}
	
	public Administrador(String usuario, String password, String nombre, String apellido, String domicilio, String fechaAlta, int idAdmin) {  
		super(usuario, password, nombre, apellido, domicilio, fechaAlta);
		this.idAdmin = idAdmin;
	}

	public long antiguedadEnMeses(String fechaHastaString){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime fechaHasta = LocalDateTime.parse(fechaHastaString, formatter);
		return Period.between(fechaHasta.toLocalDate(),LocalDateTime.now().toLocalDate()).toTotalMonths();
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

}