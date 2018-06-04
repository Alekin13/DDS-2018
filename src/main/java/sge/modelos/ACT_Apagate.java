package sge.modelos;

public class ACT_Apagate extends CA_Actuador {
	
	private DispositivoInteligente dispositivo;

	public ACT_Apagate(DispositivoInteligente dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		
		dispositivo.apagar();
	}	

}