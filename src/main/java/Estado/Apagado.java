package Estado;

import javax.persistence.Entity;

@Entity
public class Apagado extends Estado {

	public Apagado(){
		this.setDescripcion("Apagado");
		this.setClave("A");
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
	public void setClave(String clave) {
		super.setClave(clave);
	}

	@Override
	public void setDescripcion(String descripcion) {
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