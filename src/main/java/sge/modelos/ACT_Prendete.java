package sge.modelos;

public class ACT_Prendete extends CA_Actuador{
	
	private DispositivoInteligente dispositivo;

	public ACT_Prendete(DispositivoInteligente dispositivo) {
		super(dispositivo);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		
		dispositivo.encender();
	}	
}