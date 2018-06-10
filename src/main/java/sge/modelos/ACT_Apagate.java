package sge.modelos;

public class ACT_Apagate implements CommandActuadores {
	
private DispositivoInteligente dispositivo;
	
	public ACT_Apagate(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}

	@Override
	public void ejecutar() {
		dispositivo.apagar();
	}

}