package sge.regla;

import sge.dispositivo.DispositivoInteligente;

public class CondicionTemperaturaAlta implements Condicion {

	@Override
	public boolean cumpleCondicion(DispositivoInteligente dispositivo) {
		boolean cumpleCondicion = true;
		if(dispositivo.getSensor().getValor() >= 35){
			cumpleCondicion = false;
		}
		return cumpleCondicion;
	}
	
}