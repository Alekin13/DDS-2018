package sge.modelos;



import sge.modelos.Sensor;

public class TemperaturaMenor implements Condicion {
	private Sensor sensor;
	private Integer valor;
	

	public TemperaturaMenor(Sensor sensor, Integer valor) {
		this.sensor = sensor;
		this.valor = valor;
		
	}

	@Override
	public Boolean cumple() {
		return sensor.getMedicion() < valor;
	}

 
}
