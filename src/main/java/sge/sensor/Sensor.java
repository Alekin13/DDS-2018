package sge.sensor;

import java.util.List;
import sge.regla.Regla;
import sge.dispositivo.DispositivoInteligente;

public abstract class Sensor {

	private double valor;
	private String magnitud;
	private DispositivoInteligente idDispositivo;
	private List<Regla> reglas;

	public Sensor() {
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
		for (Regla regla : this.reglas) {
			regla.update(this.valor);
		}
	}
	
	public String getMagnitud() {
		return magnitud;
	}
	
	public void setMagnitud(String magnitud) {
		this.magnitud = magnitud;
	}
	
	public DispositivoInteligente getDispositivo() {
		return idDispositivo;
	}

	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.idDispositivo = dispositivo;
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
		case "�C": sensor = new SensorTemperatura(valor,magnitud);
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