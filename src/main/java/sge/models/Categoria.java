package main.java.sge.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Clase Categoría
 * 
 * @author Alejandro
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "categoria", "cargoFijo", "cargoVariable" })

public class Categoria {

	/**
	 * 
	 */
	@JsonProperty("categoria")
	private String categoria;

	@JsonProperty("cargoFijo")
	private Float cargoFijo;

	@JsonProperty("cargoVariable")
	private Float cargoVariable;

	public Categoria() {

	}

	public Categoria(String valorCategoria, Float valorCargoFijo, Float valorCargoVariable) {
		this.categoria = valorCategoria;
		this.cargoFijo = valorCargoFijo;
		this.cargoVariable = valorCargoVariable;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the cargoFijo
	 */
	public Float getCargoFijo() {
		return cargoFijo;
	}

	/**
	 * @param cargoFijo the cargoFijo to set
	 */
	public void setCargoFijo(Float cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	/**
	 * @return the cargoVariable
	 */
	public Float getCargoVariable() {
		return cargoVariable;
	}

	/**
	 * @param cargoVariable the cargoVariable to set
	 */
	public void setCargoVariable(Float cargoVariable) {
		this.cargoVariable = cargoVariable;
	}

	
}	