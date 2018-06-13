package sge.modelos;

import sge.modelos.Condicion;
import sge.modelos.sensor.Sensor;



public class TemperaturaMayor implements Condicion {

	private Integer valor;
	
	
	public TemperaturaMayor(Sensor sensor, Integer valor) {
		
		this.valor = valor;
		
	}

	@Override
	public Boolean cumple(Integer medicion) {
		return  medicion > valor;
	}

	
}
