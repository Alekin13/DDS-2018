package sge.modelos;

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
	
	
	//Cantidad de Meses del Admin: Dadas dos fechas devuelve la diferencia de meses
	//https://es.stackoverflow.com/questions/106342/c%C3%B3mo-obtener-los-meses-de-diferencia-entre-2-fechas-en-java
	public int antiguedadEnMeses(Calendar fechaAlta) {
		Calendar fechaHoy = new GregorianCalendar();
		int diferenciaAnio = fechaHoy.get(Calendar.YEAR) - fechaAlta.get(Calendar.YEAR);
		int diferenciaMeses = diferenciaAnio * 12 + fechaHoy.get(Calendar.MONTH) - fechaAlta.get(Calendar.MONTH);
		//System.out.println(diferenciaMeses);
		
		return diferenciaMeses;
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