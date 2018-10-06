package SensorActuador;

import javax.persistence.Entity;
import Dispositivo.DispositivoInteligente;

@Entity
public class ACT_CambiarTemperatura extends CommandActuadores {

	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		int nuevaTemperatura = 23;
		dispositivo.setValorInherente(nuevaTemperatura);
		
	}

}
