package SensorActuador;

import javax.persistence.Entity;
import Dispositivo.DispositivoInteligente;

@Entity
public class ACT_AhorroEnergia extends CommandActuadores {
	
	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		dispositivo.activaAhorroEnergia();
	}	
}