package SensorActuador;

import javax.persistence.Entity;

import Dispositivo.DispositivoInteligente;

@Entity
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
