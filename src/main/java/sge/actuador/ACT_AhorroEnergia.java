package sge.actuador;

import sge.dispositivo.DispositivoInteligente;

public class ACT_AhorroEnergia implements CommandActuadores {
	
	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		dispositivo.activaAhorroEnergia();
	}	
}

/* Esto está perfecto, pero tiene que implementar ACCIONES */