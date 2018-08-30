package sge.actuador;

import sge.dispositivo.DispositivoInteligente;

public class ACT_CambiarTemperatura implements CommandActuadores {

	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		int nuevaTemperatura = 23;
		dispositivo.setValorInherente(nuevaTemperatura);
		
	}

}
