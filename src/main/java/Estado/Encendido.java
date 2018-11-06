package Estado;

import javax.persistence.*;

@Entity
public class Encendido extends Estado {
	
	public Encendido(){
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
	public void setValores(String clave, String descripcion) {
		super.setClave(clave);
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
