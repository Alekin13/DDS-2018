package sge.modelos.sensor;

import java.util.ArrayList;
import java.util.List;

import sge.dispositivo.Dispositivo;
import sge.modelos.Observado;

public class Sensor extends Observado{

	public Integer ultimaMedicion;
	
	
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	
	
	public Sensor() {} //Falta el constructor

	//public Integer tomarMedicion(Dispositivo dispositivo) {} Cada un intervalo de tiempo


	public void agregarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);
		
		
		
	}
	
	public Integer getMedicion() {
		return this.ultimaMedicion;
		
	}
	
	@Override 
	public void notificarObservadores(Integer ultimaMedicion) {
	super.notificarObservadores(ultimaMedicion);

	
	}
	
}

