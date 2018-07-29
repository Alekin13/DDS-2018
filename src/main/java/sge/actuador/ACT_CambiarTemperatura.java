package sge.actuador;

import sge.dispositivo.DispositivoInteligente;

public class ACT_CambiarTemperatura implements CommandActuadores {

	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		int nuevaTemperatura = 0;
		dispositivo.setValorInherente(nuevaTemperatura);
		
	}

}
