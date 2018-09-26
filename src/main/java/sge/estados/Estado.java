package sge.estados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADOS")
public abstract class Estado {

	@Id
	@GeneratedValue
	private String idEstado;
	private String encendido;
	private String apagado;
	private String ahorroEnergia;
	private String descripcion;
	
	
	public String getEncendido() {
		return encendido;
	}
	public void setEncendido(String encendido) {
		this.encendido = encendido;
	}
	public String getApagado() {
		return apagado;
	}
	public void setApagado(String apagado) {
		this.apagado = apagado;
	}
	public String getAhorroEnergia() {
		return ahorroEnergia;
	}
	public void setAhorroEnergia(String ahorroEnergia) {
		this.ahorroEnergia = ahorroEnergia;
	}
	public boolean estaEncendido() {
		return false;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean estaApagado() {
		return false;
	}
	public boolean estaEnModoAhorro() {
		return false;
	}
	
}
