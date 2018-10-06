package SensorActuador;

import javax.persistence.Entity;

import Dispositivo.DispositivoInteligente;

@Entity
public class SensorLuminosidad extends Sensor {

	public SensorLuminosidad(int unValor, String unaMagnitud) {
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
