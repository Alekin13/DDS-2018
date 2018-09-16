package sge.usuario;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Administrador")
public class Administrador extends Usuario {
	@Id
	@GeneratedValue
	private int idAdmin;
	
	@OneToMany(mappedBy="Administrador")
	private List<Cliente> clientes;

	public Administrador() {
		super();
	}

	public Administrador(String usuario, String password, String nombre, String apellido, String domicilio, 
			Calendar fechaAlta, int valorId) { 
		super(usuario, password, nombre, apellido, domicilio, fechaAlta);
		this.idAdmin = valorId;
	}
	
	public int antiguedadEnMeses(Calendar fechaAlta) {
		Calendar fechaHoy = new GregorianCalendar();
		int diferenciaAnio = fechaHoy.get(Calendar.YEAR) - fechaAlta.get(Calendar.YEAR);
		int diferenciaMeses = diferenciaAnio * 12 + fechaHoy.get(Calendar.MONTH) - fechaAlta.get(Calendar.MONTH);
		
		return diferenciaMeses;
	}
	
	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

}