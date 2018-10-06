package Estado;

import javax.persistence.Entity;

@Entity
public class ModoAhorroEnergia extends Estado{

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
