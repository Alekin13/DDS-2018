package sge.modelos;

public class SensorLuminosidad extends Sensor {

	public float valor;
	
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
		return super.valor= valor;
		
	}
	
	public float medirLuminosidad(Dispositivo dispositivo) {}
}
