package sge.regla;

import sge.dispositivo.DispositivoInteligente;
import sge.sensor.Sensor;

public class CondicionTemperaturaAlta implements Condicion {

	@Override
	public boolean cumpleCondicion(DispositivoInteligente dispositivo) {
		boolean cumpleCondicion = true;
		Sensor unSensor = dispositivo.getSensor();
		
		if( unSensor.getValor() >= 35){
			cumpleCondicion = false;
		}
		return cumpleCondicion;
	}
	
}