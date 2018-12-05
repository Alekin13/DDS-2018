package SensorActuador;

import javax.persistence.Entity;
import Dispositivo.DispositivoInteligente;

@Entity
public class ACT_Prendete extends CommandActuadores{
	
	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		dispositivo.encenderDispositivo();
	
	}	

}