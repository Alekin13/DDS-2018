package sge.modelos;

public abstract class CA_Actuador implements I_command {
	
	private DispositivoInteligente dispositivo; 
	
	public CA_Actuador (DispositivoInteligente dispositivo){
		this.dispositivo = dispositivo;
	}
	
	public void execute() {
		
		System.out.println("Para que sirve este execute?");
	}
}