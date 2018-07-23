package sge.modelos;


import java.util.ArrayList;

import sge.modelos.Regla;
import sge.observer.ObserverSensor;
import sge.modelos.CommandActuadores;
import java.util.List;



public class Regla implements ObserverSensor {
	
	private Condicion condicion;
	private List<CommandActuadores> actuadores = new ArrayList<CommandActuadores>();;
	
	public Regla(Condicion condicion, List<CommandActuadores> actuadoresLista) {
		this.actuadores = actuadoresLista;
		this.condicion = condicion;
		
	}
	
	public void ejecutar(Integer valor) {
		if (condicion.cumple(valor)) {
			actuadores.forEach(actuador -> actuador.ejecutar());
		}
	}
	
	public Regla agregarAccion(CommandActuadores actuador) {
		actuadores.add(actuador);
		return this;
	}
	
	@Override
	public void observadoActualizado(Integer valor) {
		this.ejecutar(valor);
	
	}
	
	
	
	 
}
