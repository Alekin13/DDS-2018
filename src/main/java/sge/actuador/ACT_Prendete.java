package sge.actuador;

import sge.dispositivo.DispositivoInteligente;

public class ACT_Prendete implements CommandActuadores{
	
	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		dispositivo.encenderDispositivo();
	
	}	

}