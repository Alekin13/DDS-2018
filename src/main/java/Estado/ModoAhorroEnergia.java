package Estado;

import javax.persistence.Entity;

@Entity
public class ModoAhorroEnergia extends Estado{

	public ModoAhorroEnergia(){
		this.setDescripcion("Modo Ahorro Energia");
		this.setClave("M");
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
	public void setClave(String clave) {
		super.setClave(clave);
	}
	
	@Override
	public void setDescripcion(String descripcion) {
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