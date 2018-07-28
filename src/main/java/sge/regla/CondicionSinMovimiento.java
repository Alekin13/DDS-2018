package sge.regla;

import sge.dispositivo.DispositivoInteligente;

public class CondicionSinMovimiento implements Condicion{
	
	@Override
	public boolean cumpleCondicion(DispositivoInteligente dispositivo) {
		boolean cumpleCondicion = true;
		if(dispositivo.getSensor().getValor() > 0){
			cumpleCondicion = false;
		}
		return cumpleCondicion;
	}
}