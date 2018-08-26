package sge.sensor;

public interface Observer{

	// Cada clase que quiera observar el cambio del estado del sensor 
	//deb� implementar la siguiente interface y darle l�gica al m�todo update
	public void observerActualizar();

}