package sge.actuador;

import sge.dispositivo.DispositivoInteligente;

public class ACT_Luces implements CommandActuadores {

	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		int estadoLuces = 0;
		dispositivo.setValorInherente(estadoLuces);
		
	}
}
