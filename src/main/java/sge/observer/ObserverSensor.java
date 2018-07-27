package sge.observer;

import java.util.List;
import sge.observer.ObserverSensor;
import sge.regla.Regla;
import sge.sensor.Sensor;

public class ObserverSensor {
	
	private int estadoObserver;
	private List<Observer> subscriptores;
	
	public int getEstadoObserver() {
		return estadoObserver;
	}

	public void setEstadoObserver(int estadoObserver) {
		this.estadoObserver = estadoObserver;
	}

	public List<Observer> getSubscriptores() {
		return subscriptores;
	}

	public void setSubscriptores(List<Observer> subscriptores) {
		this.subscriptores = subscriptores;
	}

	public void agregarSubscriptor(Observer subscriptor){
		this.subscriptores.add(subscriptor);
	}

	public void eliminarSubscriptor(Observer unObservador){
		subscriptores.remove(unObservador);
	}

	public void notificarObservadores(Sensor sensor){
		for(Observer unObservador : this.getSubscriptores()){
			unObservador.observadoActualizado(sensor);
		}
	
	}

}