package sge.zona;

import java.util.List;
import sge.transformador.Transformador;
import sge.usuario.Cliente;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "nombre", "radio", "latitud", "longitud"})
public class Zona {
	
	@JsonProperty("id")
	private int id;

	@JsonProperty("nombre")
	private String nombre;
	
	@JsonProperty("radio")
	private double radio;
	
	@JsonProperty("latitud")
	private double latitud;
	
	@JsonProperty("longitud")
	private double longitud;
	
	private List<Transformador> transformadores;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Transformador> getTransformadores() {
		return transformadores;
	}
	
	public void setTransformadores(List<Transformador> transformadores) {
		this.transformadores = transformadores;
	}
	
	public double getRadio() {
		return radio;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
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
	
	public void agregarTransformador (Transformador transformador) {
		this.transformadores.add(transformador);
	}
	
	public double getConsumoTotalDeLaZona(List<Cliente> clientes) {
		double consumoTotalDeLaZona = 0;
		
		for (Transformador transformador : this.transformadores) {
			consumoTotalDeLaZona += transformador.cantidadDeEnergiaSuministrada(getClientesDeLaZona(clientes));
		}
		return consumoTotalDeLaZona;
	}

	private List<Cliente> getClientesDeLaZona(List<Cliente> clientes) {
		double ZonaRadio = this.radio;
		double ZonaCoordenadaX = this.longitud;
		double ZonaCoordenadaY = this.latitud;
		
		for (Cliente unCliente : clientes) {
			
			//si la distancia del cliente al centro de la Zona es MAYOR al radio de la zona, el cliente no pertence a la misma
			if (Math.sqrt( Math.pow(ZonaCoordenadaX - unCliente.getLongitud(), 2) + Math.pow(ZonaCoordenadaY - unCliente.getLatitud() , 2)) > ZonaRadio){
				clientes.remove(unCliente);
				System.out.println ("El Cliente " + unCliente.getApellido() + " no pertenece a la Zona");
			}
			else{
				System.out.println ("El Cliente " + unCliente.getApellido() + " pertenece a la Zona");
			}
		}
		
		return clientes;
	}
	
}
