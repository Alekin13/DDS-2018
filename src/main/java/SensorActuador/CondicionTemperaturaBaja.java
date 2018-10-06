package SensorActuador;

import javax.persistence.Entity;

import Dispositivo.DispositivoInteligente;

@Entity
public class CondicionTemperaturaBaja extends Condicion {

	@Override
	public boolean cumpleCondicion(DispositivoInteligente dispositivo) {
		boolean cumpleCondicion = true;
		if(dispositivo.getSensor().getValor() <= 15){
			cumpleCondicion = false;
		}
		return cumpleCondicion;
	}
	
}
