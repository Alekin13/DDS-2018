package SensorActuador;

import javax.persistence.Entity;

import Dispositivo.DispositivoInteligente;

@Entity
public class CondicionSinMovimiento extends Condicion{
	
	@Override
	public boolean cumpleCondicion(DispositivoInteligente dispositivo) {
		boolean cumpleCondicion = true;
		if(dispositivo.getSensor().getValor() > 0){
			cumpleCondicion = false;
		}
		return cumpleCondicion;
	}
}