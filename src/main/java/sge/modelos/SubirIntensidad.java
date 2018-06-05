package sge.modelos;


public class SubirIntensidad implements Acciones {
	
	private ActuadorLuces actuador;
	private Integer valor;
	
	
	public SubirIntensidad(ActuadorLuces actuador, Integer valor) {
		this.actuador = actuador;
		this.valor = valor;
	}
	
	@Override
	public void ejecutar() {
		actuador.subirIntensidad(valor);
	}
	
}
