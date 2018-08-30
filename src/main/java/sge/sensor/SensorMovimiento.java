package sge.sensor;

import sge.dispositivo.DispositivoInteligente;

public class SensorMovimiento extends Sensor {

	public SensorMovimiento(int unValor,String unaMagnitud){
		this.setValor(unValor);
		this.setMagnitud(unaMagnitud);
	}

	@Override
	public void tomarMedicionDispositivo(DispositivoInteligente unDispositivo){
		double numero = (Math.random() * 0);
		unDispositivo.setValorInherente(numero);
		this.setValor(numero);
	}
}
