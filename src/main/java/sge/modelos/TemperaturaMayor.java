package sge.modelos;

import sge.modelos.Condicion;



public class TemperaturaMayor implements Condicion {
	private Sensor sensor;
	private Integer valor;
	
	
	public TemperaturaMayor(Sensor sensor, Integer valor) {
		this.sensor = sensor;
		this.valor = valor;
		
	}

	@Override
	public Boolean cumple() {
		return sensor.getMedicion() > valor;
	}

	
}
