package sge.actuador;

import sge.dispositivo.DispositivoInteligente;

public interface CommandActuadores {
	public abstract void ejecutar();

	public abstract void ejecutarAccion(DispositivoInteligente dispositivo);

}
