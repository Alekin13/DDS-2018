package sge.observer;

import java.util.List;
import sge.sensor.Sensor;

public class ObserverSensor implements Observer {
	
	private int estadoObserver;
	private List<Sensor> sensoresObservados;
	
	public int getEstadoObserver() {
		return estadoObserver;
	}

	public void setEstadoObserver(int estadoObserver) {
		this.estadoObserver = estadoObserver;
	}

	public List<Sensor> getSensoresObservados() {
		return sensoresObservados;
	}

	public void setSensoresObservado(List<Sensor> sensoresObservados) {
		this.sensoresObservados = sensoresObservados;
	}

	public void agregarSensoresObservados(Sensor sensoresObservados){
		this.sensoresObservados.add(sensoresObservados);
	}

	public void eliminarSensoresObservados(Sensor unSensor){
		sensoresObservados.remove(unSensor);
	}

	@Override
	public void observerActualizar() {
		for(Sensor unSensor : this.getSensoresObservados()){
			unSensor.getDispositivo().apagarDispositivo();
			System.out.println("Se apagara el siguiente dispositivo: " + unSensor.getDispositivo().getNombreDispositivo());
		}
	
	}

}