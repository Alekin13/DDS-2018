package sge.modelos;

import sge.modelos.Observador;
import java.util.List;

public abstract class Observado {
	
public List<Observador> observadores;
	
	public void agregarObservador(Observador unObservador)
	{
		observadores.add(unObservador);
		
	}
	public void eliminarObservador(Observador unObservador)
	{
		observadores.remove(unObservador);
	}
	public void notificarObservadores(Integer valor)
	{
		for(Observador unObservador : observadores){
			unObservador.observadoActualizado(valor);
			
		}
	
	}

}
