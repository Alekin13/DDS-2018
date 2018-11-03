package Estado;

import javax.persistence.*;

@Entity
public class Encendido extends Estado {

	public void Encedido(){
		this.setDescripcion("Encendido");
		this.setClave("E");
	}
	
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
