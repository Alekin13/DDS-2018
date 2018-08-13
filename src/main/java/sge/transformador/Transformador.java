package sge.transformador;

import java.util.List;
import sge.usuario.Cliente;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "idZona", "latitud", "longitud"})
public class Transformador {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("idZona")
	private int idZona; 
	
	@JsonProperty("latitud")
	private double latitud;
	
	@JsonProperty("longitud")
	private double longitud;
	
	private double consumo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdZona() {
		return idZona;
	}
	
	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public double cantidadDeEnergiaSuministrada(List<Cliente> clientes){
		double consumoTotal = 0;
		for (Cliente unCliente : clientes) {
			consumoTotal += unCliente.consumoCliente();
		}
		return consumoTotal;
	}
}
