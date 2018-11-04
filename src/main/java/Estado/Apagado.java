package Estado;

import javax.persistence.Entity;

@Entity
public class Apagado extends Estado {

	public Apagado(){
	}
	
	@Override
	public boolean estaEncendido() {
			return false;
	}

	@Override
	public boolean estaApagado() {
		return true;
	}

	@Override
	public boolean estaEnModoAhorro() {
		return false;
	}

	@Override
	public void setValores(String clave, String descripcion) {
		super.setClave(clave);
		super.setDescripcion(descripcion);
		
	}

	@Override
	public String getClave() {
		return "A";
	}

	@Override
	public String getDescripcion() {
		return "Apagado";
	}
}
