package sge.modelos;

public class ACT_AhorroEnergia implements CommandActuadores {
	
	private DispositivoInteligente dispositivo;

	public ACT_AhorroEnergia(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
		// TODO Auto-generated constructor stub
	}

	public void ejecutar() {
		
		dispositivo.activaAhorroEnergia();
	}	
}

/* Esto est� perfecto, pero tiene que implementar ACCIONES */