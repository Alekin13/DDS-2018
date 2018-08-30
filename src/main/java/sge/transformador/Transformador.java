package sge.transformador;

import java.util.List;
import sge.usuario.Cliente;

public class Transformador {

	private int id;
	private int idZona; 
	private double latitud;
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
