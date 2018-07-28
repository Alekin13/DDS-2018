package sge.actuador;

import sge.dispositivo.DispositivoInteligente;

public class ACT_AhorroEnergia implements CommandActuadores {
	
	private DispositivoInteligente dispositivo;

	public ACT_AhorroEnergia(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
		// TODO Auto-generated constructor stub
	}

	public void ejecutar() {
		
		dispositivo.activaAhorroEnergia();
	}

	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		// TODO Auto-generated method stub
		
	}	
}

/* Esto está perfecto, pero tiene que implementar ACCIONES */