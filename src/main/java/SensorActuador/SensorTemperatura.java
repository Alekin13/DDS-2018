package SensorActuador;

import javax.persistence.Entity;

import Dispositivo.DispositivoInteligente;

@Entity
public class SensorTemperatura extends Sensor {
	
	public SensorTemperatura(int unValor, String unaMagnitud){
		this.setValor(unValor);
		this.setMagnitud(unaMagnitud);
	}

	@Override
	public void tomarMedicionDispositivo(DispositivoInteligente unDispositivo){
		double numero = (Math.random() * 32) + 5;
		unDispositivo.setValorInherente(numero);
		this.setValor(numero);
	}
}	