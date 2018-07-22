package sge.actuador;

import sge.dispositivo.DispositivoInteligente;
import sge.modelos.CommandActuadores;

public class ACT_Prendete implements CommandActuadores{
	
	private DispositivoInteligente dispositivo;

	public ACT_Prendete(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
		
	}

	public void ejecutar() {
		
		dispositivo.encenderDispositivo();
	}	
}