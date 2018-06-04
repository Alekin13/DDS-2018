package sge.modelos;

public class SensorTemperatura extends Sensor {

	
	public Float valor;
	
	public void agregarDispositivo(Dispositivo dispositivo) {
		super.agregarDispositivo(dispositivo);
		
	}
	
	public void  agregarObserver(Regla regla) {
		
		super.agregarObserver(regla);
	}

	public void eliminarObserver(Regla regla) {
		super.eliminarObserver(regla);
		
	}


	public void notificarObserver(Dispositivo dispositivo) {
		
		super.notificarObserver(dispositivo);

	}
	
	public float getValor(){
		return super.valor = valor;
		
	}
	public float medirTemperatura(Dispositivo dispositivo) {}

}
