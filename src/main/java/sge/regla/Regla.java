package sge.regla;

import java.util.ArrayList;
import java.util.List;

import sge.actuador.CommandActuadores;
import sge.dispositivo.DispositivoInteligente;

public class Regla {

	private List <Condicion> condiciones;
	private List<CommandActuadores> acciones = new ArrayList<CommandActuadores>();
	private DispositivoInteligente dispositivo;
	
	public Regla(List<Condicion> condiciones, List<CommandActuadores> acciones,DispositivoInteligente unDispositivo){
		this.setAcciones(acciones);
		this.setCondiciones(condiciones);
		this.setDispositivo(unDispositivo);
	}
	
	public void recibirEstado(int estadoObserver) {
		//cambio el estado de Un sensor, lo comunica el sensor		
	}
	
	public boolean cumpleCondiciones(){
		boolean cumpleCondicion = true;
		for(Condicion unaCondicion : this.getCondiciones()){
			if(!unaCondicion.cumpleCondicion(this.getDispositivo())){
				cumpleCondicion = false;
			}
		}
		return cumpleCondicion;
	}
	
	public void ejecutarAcciones(){
		if(!this.cumpleCondiciones()){
			for(CommandActuadores unaAccion : this.getAcciones()){
				unaAccion.ejecutarAccion(this.getDispositivo());
			}
		}
	}
	
	public boolean evaluarDispositivo(){
		boolean cumpleCondicion = this.cumpleCondiciones();
		if(!cumpleCondicion){
			this.ejecutarAcciones();
		}
		return cumpleCondicion;
	}

	public List<Condicion> getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(List<Condicion> condiciones) {
		this.condiciones = condiciones;
	}
	public List<CommandActuadores> getAcciones() {
		return acciones;
	}
	public void setAcciones(List<CommandActuadores> acciones) {
		this.acciones = acciones;
	}
	
	public DispositivoInteligente getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}

	public void agregarCondicion(Condicion unaCondicion){
		condiciones.add(unaCondicion);
	}
	
	public void agregarAccion(CommandActuadores unaAccion){
		acciones.add(unaAccion);
	}
	
}