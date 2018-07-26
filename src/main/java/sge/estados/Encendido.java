package sge.estados;

public class Encendido implements Estado {

	@Override
	public boolean estaEncendido() {
		return true;
	}

	@Override
	public boolean estaApagado() {
		return false;
	}

	@Override
	public boolean estaEnModoAhorro() {
		return false;
	}

}
