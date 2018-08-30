package sge.regla;

import sge.actuador.CommandActuadores;
import sge.dispositivo.DispositivoInteligente;

public class Regla implements Observer {

	private Condicion condicion;
	private CommandActuadores accion;
	private DispositivoInteligente dispositivo;
	
	public Regla(Condicion condicion, CommandActuadores accion, DispositivoInteligente unDispositivo){
		this.setAccion(accion);
		this.setCondicion(condicion);
		this.setDispositivo(unDispositivo);
	}
	
	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

	public CommandActuadores getAccion() {
		return accion;
	}

	public void setAccion(CommandActuadores accion) {
		this.accion = accion;
	}

	public DispositivoInteligente getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}

	public boolean cumpleCondiciones(){
		boolean cumpleCondicion = true;
			if(!this.condicion.cumpleCondicion(this.dispositivo))
				cumpleCondicion = false;
		
		return cumpleCondicion;
	}
	
	public void ejecutarAcciones(){
		if(!this.cumpleCondiciones())
			this.accion.ejecutarAccion(this.getDispositivo());
	}
	
	public boolean evaluarDispositivo(){
		boolean cumpleCondicion = this.cumpleCondiciones();
		if(!cumpleCondicion){
			this.ejecutarAcciones();
		}
		return cumpleCondicion;
	}

	public void update(double valor) {
	}

}