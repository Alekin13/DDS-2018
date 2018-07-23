package sge.modelos;



import sge.sensor.Sensor;

public class TemperaturaMenor implements Condicion {
	
	private Integer valor;
	

	public TemperaturaMenor(Sensor sensor, Integer valor) {

		this.valor = valor;
		
	}

	@Override
	public Boolean cumple(Integer medicion) {
		return medicion < valor;
	}

 
}
