package sge.observer;

public interface Observer{

	// Cada clase que quiera observar el cambio del estado del sensor 
	//debé implementar la siguiente interface y darle lógica al método update
	public void observerActualizar();

}