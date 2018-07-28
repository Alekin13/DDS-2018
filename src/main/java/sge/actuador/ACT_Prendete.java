package sge.actuador;

import sge.dispositivo.DispositivoInteligente;

public class ACT_Prendete implements CommandActuadores{
	
	private DispositivoInteligente dispositivo;

	public ACT_Prendete(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
		
	}

	public void ejecutar() {
		
		dispositivo.encenderDispositivo();
	}

	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		// TODO Auto-generated method stub
		
	}	
}