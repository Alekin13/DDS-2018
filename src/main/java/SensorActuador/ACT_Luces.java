package SensorActuador;

import javax.persistence.Entity;

import Dispositivo.DispositivoInteligente;

@Entity
public class ACT_Luces extends CommandActuadores {
	
	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		int estadoLuces = 0;
		dispositivo.setValorInherente(estadoLuces);
		
	}
}
