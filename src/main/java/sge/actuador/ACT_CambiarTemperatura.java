package sge.actuador;

import sge.dispositivo.DispositivoInteligente;
import sge.modelos.CommandActuadores;

public class ACT_CambiarTemperatura implements CommandActuadores {
	
	public DispositivoInteligente dispositivo;
	private Integer valor;

	public ACT_CambiarTemperatura(Integer valor) {
	
		this.valor = valor;
	}
	
	@Override
	public void ejecutar() {
		dispositivo.cambiarTemperatura(valor);
	}

}
