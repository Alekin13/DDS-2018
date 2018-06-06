package sge.modelos;



public class CambiarTemperatura implements Acciones{
	
	private ActuadorAire actuador;
	private Integer valor;

	public CambiarTemperatura(ActuadorAire actuador, Integer valor) {
		this.actuador = actuador;
		this.valor = valor;
	}
	
	@Override
	public void ejecutar() {
		actuador.cambiarTemperatura(valor);
	}

}
