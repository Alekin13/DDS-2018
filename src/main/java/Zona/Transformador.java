package Zona;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import Usuario.Cliente;

@Entity
@Table(name="TRANSFORMADOR")
public class Transformador {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="latitud")
	private double latitud;
	@Column(name="longitud")
	private double longitud;
	@Column(name="consumo")
	private double consumo;
	@Column(name="idZona")
	private int idZona;	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
			
			this.setConsumo(consumoTotal);
		}
		return consumoTotal;
	}

	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}
}
