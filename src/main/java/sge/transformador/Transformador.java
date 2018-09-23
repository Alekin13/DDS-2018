package sge.transformador;

import java.util.List;
import sge.usuario.Cliente;
import sge.zona.Zona;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transformador")
public class Transformador {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToMany(mappedBy="Cliente")
	private List<Cliente> clientes;
	
	@ManyToOne
	private Zona zona;
	
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
