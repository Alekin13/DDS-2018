package Estado;

import javax.persistence.Entity;

@Entity
public class ModoAhorroEnergia extends Estado{

	public void ModoAhorroEnergia(){
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
