package sge.regla;


import java.util.ArrayList;
import sge.regla.CommandActuadores;
import sge.regla.Regla;

import java.util.List;



public class Regla  {
	
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
	
	public void observadoActualizado(Integer valor) {
		this.ejecutar(valor);
	
	}
	
	
	
	 
}
