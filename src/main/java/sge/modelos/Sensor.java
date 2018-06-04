package sge.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Sensor extends Observable{

	public float valor;
	
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	
	public void agregarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);
		
	}
	
	public void  agregarObserver(Regla regla) {
		
		this.addObserver(regla);
	}

	public void eliminarObserver(Regla regla) {
		this.deleteObserver(regla);
		
	}


	public void notificarObserver(Dispositivo dispositivo) {
		
		this.notifyObservers(dispositivo);

	}

	public float getValor(){
		return valor;
		
	}



}

