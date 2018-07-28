package sge.actuador;

import sge.dispositivo.DispositivoInteligente;

public class ACT_Apagate implements CommandActuadores {
	
	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
	dispositivo.apagarDispositivo();
	
	}	

}