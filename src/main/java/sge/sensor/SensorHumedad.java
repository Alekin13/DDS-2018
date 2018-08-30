package sge.sensor;

import sge.dispositivo.DispositivoInteligente;

public class SensorHumedad extends Sensor{

	public SensorHumedad(int unValor,String unaMagnitud){
		this.setValor(unValor);
		this.setMagnitud(unaMagnitud);
	}

	@Override
	public void tomarMedicionDispositivo(DispositivoInteligente unDispositivo){
		double numero = (Math.random() * 30) + 1;
		unDispositivo.setValorInherente(numero);
		this.setValor(numero);
	}
}
