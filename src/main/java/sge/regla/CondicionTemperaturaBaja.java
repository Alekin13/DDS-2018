package sge.regla;

import sge.dispositivo.DispositivoInteligente;

public class CondicionTemperaturaBaja implements Condicion {

	@Override
	public boolean cumpleCondicion(DispositivoInteligente dispositivo) {
		boolean cumpleCondicion = true;
		if(dispositivo.getSensor().getValor() <= 15){
			cumpleCondicion = false;
		}
		return cumpleCondicion;
	}
	
}
