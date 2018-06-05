package sge.modelos;



public class BajarIntensidad implements Acciones {

	private ActuadorLuces actuador;
	private Integer valor;
	
	
	public BajarIntensidad(ActuadorLuces actuador, Integer valor) {
		this.actuador = actuador;
		this.valor = valor;
	}
	
	@Override
	public void ejecutar() {
		actuador.bajarIntensidad(valor);
	}
}
