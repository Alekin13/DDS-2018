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

/*OJO este codigo no est� bien, porque CA_Actuador no es una acci�n, es un actuador
 * en esta clase, una acci�n deber�a implementar I_command y, el execute, deber�a implementar
 * los metodos de dispositivo que a vos te interesen... o sea, deber�a ser:
 * 
 * public abstract class EntrarEnAhorroEnergia implements I_command {
 * 		public void execute(){
 * 			dispositivo.apagarse();
 * 			dispositivo.encenderseEnAhorroEnergiA();
 * 		}
 * }
 * 
 * 	ya entendi donde est� el problema, tenemos que unificar Acciones/CA_Actuador, que quede uno solo!
 * que sea el command y que tenga el execute.
 * 
 * */