package main.java.sge.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Clase que modela la entidad dispositivo
 * @author Alejandro
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nombreDispositivo", "consumoKwh", "estado", "tipo"})
public class Dispositivo {

	@JsonProperty("nombreDispositivo")
	private String nombreDispositivo;

	
	@JsonProperty("consumoKwh")
	private Float consumoKwh;
	
	@JsonProperty("estado")
	private Boolean estado;

	@JsonProperty("tipo")
	private String tipo;

	public Dispositivo() {

	}
	

	public Dispositivo(String valorNombreDispositivo, Float valorConsumo, Boolean valorEstado, String valorTipo) {
		super();
		this.nombreDispositivo = valorNombreDispositivo;
		this.consumoKwh = valorConsumo;
		this.estado = valorEstado;
		this.tipo = valorTipo;
	}


	/**
	 * @return the nombreDispositivo
	 */
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}


	/**
	 * @param nombreDispositivo the nombreDispositivo to set
	 */
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}


	/**
	 * @return the consumoKwh
	 */
	public Float getConsumoKwh() {
		return consumoKwh;
	}


	/**
	 * @param consumoKwh the consumoKwh to set
	 */
	public void setConsumoKwh(Float consumoKwh) {
		this.consumoKwh = consumoKwh;
	}


	/**
	 * @return the estado
	 */
	public Boolean getEstado() {
		return estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}