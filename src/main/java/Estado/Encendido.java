package Estado;

import javax.persistence.*;

@Entity
public class Encendido extends Estado {
	
	public Encendido(){
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
		return "E";
	}

	@Override
	public String getDescripcion() {
		return "Encendido";
	}

}