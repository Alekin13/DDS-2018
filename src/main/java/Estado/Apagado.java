package Estado;

import javax.persistence.Entity;

@Entity
public class Apagado extends Estado {

	public void Apagado(){
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
	
	public String getDescripcion() {
		return super.getDescripcion();
	}
	
	public void setDescripcion(String descripcion) {
		super.setDescripcion(descripcion);
	}
	
	public String getClave() {
		return super.getClave();
	}
	
	public void setClave(String clave) {
		super.setClave(clave);
	}
	
	
}
