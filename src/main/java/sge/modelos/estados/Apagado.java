package sge.modelos.estados;

public class Apagado implements Estado {

	@Override
	public boolean estaEncendido() {
			return false;
	}

	@Override
	public boolean estaApagado() {
		return true;
	}

	@Override
	public double calcularConsumo() {
		return 0;
	}

}
