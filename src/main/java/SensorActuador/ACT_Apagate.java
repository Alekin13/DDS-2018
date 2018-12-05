package SensorActuador;

import javax.persistence.Entity;
import Dispositivo.DispositivoInteligente;

@Entity
public class ACT_Apagate extends CommandActuadores {
	
	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		dispositivo.apagarDispositivo();
	}	

}