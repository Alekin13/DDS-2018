package sge.sensor;

public class SensorPresencia extends Sensor {

	public void SensorDeMovimiento(int unValor,String unaMagnitud){
		this.setValor(unValor);
		this.setMagnitud(unaMagnitud);
	}

}
