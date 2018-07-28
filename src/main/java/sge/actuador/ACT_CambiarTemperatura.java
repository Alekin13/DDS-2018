package sge.actuador;

import sge.dispositivo.DispositivoInteligente;

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

	@Override
	public void ejecutarAccion(DispositivoInteligente dispositivo) {
		// TODO Auto-generated method stub
		
	}

}
