package sge.modelos;
import java.util.Observer;

public class Regla implements Observer {
	
	
	public void evaluarCondicion(float valor, Dispositivo dispositivo) {}
	
	public void update(Sensor sensor, Dispositivo dispositivo) {
		
		this.evaluarCondicion(sensor.getValor(), dispositivo);
	
		
	}
	
	 
}
