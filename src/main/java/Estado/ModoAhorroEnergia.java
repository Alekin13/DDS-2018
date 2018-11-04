package Estado;

import javax.persistence.Entity;

@Entity
public class ModoAhorroEnergia extends Estado{

	public ModoAhorroEnergia(){
	}
	
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
	
	@Override
	public void setValores(String clave, String descripcion) {
		super.setClave(clave);
		super.setDescripcion(descripcion);
		
	}


	@Override
	public String getClave() {
		return "M";
	}

	@Override
	public String getDescripcion() {
		return "Modo Ahorro Energia";
	}
}