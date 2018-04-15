package main.java.sge.models;

import java.util.Calendar;
import java.util.GregorianCalendar;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Clase Administrador Extends Usuario
 * @author Alejandro Mattioli
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idAdmin" })

public class Administrador extends Usuario {

	@JsonProperty("idAdmin")
	private Integer idAdmin;

	public Administrador() {
		super();
	}

	public Administrador(String valorUsuario, String valorPassword, String valorNombre, String valorApellido, String valorDomicilio, Calendar valorFechaAlta, Integer valorId) { 
		super(valorUsuario, valorPassword, valorNombre, valorApellido, valorDomicilio, valorFechaAlta);
		this.idAdmin = valorId;
	}

	/**
	 * @return the idAdmin
	 */
	public Integer getIdAdmin() {
		return idAdmin;
	}

	/**
	 * @param idAdmin the idAdmin to set
	 */
	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}
	

}