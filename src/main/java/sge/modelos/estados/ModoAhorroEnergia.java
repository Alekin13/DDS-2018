package sge.modelos.estados;

public class ModoAhorroEnergia implements Estado{

	@Override
	public boolean estaEncendido() {
		return false;
	}

	@Override
	public boolean estaApagado() {
		return false;
	}

	@Override
	public boolean estaEnModoAhorro() {
		return true;
	}

}
