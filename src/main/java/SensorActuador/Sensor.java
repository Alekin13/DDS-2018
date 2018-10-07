package SensorActuador;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import Dispositivo.DispositivoInteligente;

@Entity
@Table(name="SENSORES")
public abstract class Sensor {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="valor")
	private double valor;
	@Column(name="magnitud")
	private String magnitud;
	@OneToMany
	private List<Regla> reglas = new ArrayList<>();

	public Sensor() {
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
		if (this.reglas.size()>0){
			for (Regla regla : this.reglas) {
			regla.update(this.valor);
		}
	}

	}
	
	public String getMagnitud() {
		return magnitud;
	}
	
	public void setMagnitud(String magnitud) {
		this.magnitud = magnitud;
	}
	
	public List<Regla> getReglas() {
		return reglas;
	}

	public void setReglas(List<Regla> reglas) {
		this.reglas = reglas;
	}

	public void addObserver(Regla regla) {
    this.reglas.add(regla);
	}

	public void removeObserver(Regla regla) {
		this.reglas.remove(regla);
	}

	public void tomarMedicionDispositivo(DispositivoInteligente unDispositivo){
		this.setValor(unDispositivo.getValorInherente());
	}
	
	public Sensor determinarMagnitud(int valor, String magnitud){
		Sensor sensor = null;
		switch (magnitud){
		case "C": sensor = new SensorTemperatura(valor,magnitud);
			break;
		case "%": sensor = new SensorHumedad(valor, magnitud);
			break;
		case "Lumenes": sensor = new SensorLuminosidad(valor,magnitud);
			break;
		case "Movimiento": sensor = new SensorMovimiento(valor,magnitud);
			break;
		}
		return sensor;
	}
 
}