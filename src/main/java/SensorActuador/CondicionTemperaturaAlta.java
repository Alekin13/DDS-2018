package SensorActuador;

import javax.persistence.Entity;

import Dispositivo.DispositivoInteligente;

@Entity
public class CondicionTemperaturaAlta extends Condicion {

	@Override
	public boolean cumpleCondicion(DispositivoInteligente dispositivo) {
		boolean cumpleCondicion = true;
		Sensor unSensor = dispositivo.getSensor();
		System.out.println("Llego a cumpleCondicion");
		if(unSensor.getValor() >= 35){
			cumpleCondicion = false;
		}
		return cumpleCondicion;
	}
	
}