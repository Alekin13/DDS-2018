package sge.modelos;

import sge.modelos.Observador;
import java.util.List;

public abstract class Observado {
	
public List<Observador> observadores;
	
	public void agregarObservador(Observador unObservador)
	{
		observadores.add(unObservador);
		
	}
	public void quitarObservador(Observador unObservador)
	{
		observadores.remove(unObservador);
	}
	public void notificarObservadores()
	{
		for(Observador unObservador : observadores){
			unObservador.observadoActualizado();
			
		}
	
	}

}
