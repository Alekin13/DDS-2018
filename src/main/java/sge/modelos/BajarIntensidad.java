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

/* bajar intensidad es un accion que implementa acciones, está bien! pero el tema es que hay que crear
 * ActuadorLuces ordenando un poco la duplicidad que tienen en el codigo, crear UN SOLO COMMAND con su execute
 * para no confundir
 */
