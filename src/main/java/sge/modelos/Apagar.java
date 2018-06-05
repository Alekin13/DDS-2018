package sge.modelos;

import sge.modelos.DispositivoInteligente;

public class Apagar implements Acciones{

private DispositivoInteligente dispositivo;
	
	public Apagar(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}

	@Override
	public void ejecutar() {
		dispositivo.apagar();
	}
}
