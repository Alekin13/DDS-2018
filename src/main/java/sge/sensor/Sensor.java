package sge.sensor;

import java.util.ArrayList;
import java.util.List;
import sge.dispositivo.Dispositivo;
import sge.observer.Observer;
import sge.observer.ObserverSensor;

public abstract class Sensor extends Observer{

	private ObserverSensor observer;
	private int ultimaMedicion;
	private String magnitud;
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	
	public Sensor() {
	//Falta el constructor
	} 

	//public Integer tomarMedicion(Dispositivo dispositivo) {} Cada un intervalo de tiempo

	public void subscribir(ObserverSensor observer){
		setObserver(observer);
	}
	/*
	public void	notificar(){
		this.getObserver().actualizar(this);
	}
	
	public int medirMagnitud(){
		//realizar medicion...
		this.notificar();
		return this.getUltimaMedicion();
	}
	
	/*pubic Observado getObserver() {
		return observer;
	}
	*/
	public void setObserver(ObserverSensor observer) {
		this.observer = observer;
	}
	
	public int getUltimaMedicion() {
		return ultimaMedicion;
	}
	
	public void setUltimaMedicion(int ultimaMedicion) {
		this.ultimaMedicion = ultimaMedicion;
	}
	
	public String getMagnitud() {
		return magnitud;
	}
	
	public void setMagnitud(String magnitud) {
		this.magnitud = magnitud;
	}

	
	public void agregarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);
	}
		
	public void notificarObservadores(Integer ultimaMedicion) {
		super.notificarObservadores(ultimaMedicion);
	}

	public int getValor() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

