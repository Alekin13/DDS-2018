package sge.modelos;
import sge.modelos.Sensor;

public interface Observador {
	
	
	public void observadoActualizado();
	public void setSensor(Sensor s);

	
}
