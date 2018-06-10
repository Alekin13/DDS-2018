package sge.modelos;

public class ACT_AhorroEnergia extends CA_Actuador {
	
	private DispositivoInteligente dispositivo;

	public ACT_AhorroEnergia(DispositivoInteligente dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}

	public void execute() {		
		dispositivo.activaAhorroEnergia();
	}	
}

/* Esto está perfecto, pero tiene que implementar ACCIONES */