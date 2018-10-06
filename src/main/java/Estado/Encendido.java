package Estado;


import javax.persistence.*;

@Entity
public class Encendido extends Estado {


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
