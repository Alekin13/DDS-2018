package sge.modelos;


import java.util.ArrayList;

import sge.modelos.Regla;
import sge.modelos.Acciones;
import java.util.List;



public class Regla implements Observador {
	
	private Condicion condicion;
	private List<Acciones> acciones = new ArrayList<Acciones>();;
	public Sensor sensor = null;
	
	public Regla(Condicion condicion, List<Acciones> accionesLista) {
		this.acciones = accionesLista;
		this.condicion = condicion;
		
	}
	
	public void ejecutar() {
		if (condicion.cumple()) {
			acciones.forEach(accion -> accion.ejecutar());
		}
	}
	
	public Regla agregarAccion(Acciones accion) {
		acciones.add(accion);
		return this;
	}
	
	@Override
	public void observadoActualizado() {
		this.ejecutar();
	
	}
	
	public void setSensor(Sensor s) {
		this.sensor = s;
	}
	

	
	
	 
}
