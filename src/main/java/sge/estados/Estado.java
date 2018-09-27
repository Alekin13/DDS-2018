package sge.estados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADOS")
public class Estado {

	@Id
	@GeneratedValue
	private Long idEstado;
	private int encendido;
	private int apagado;
	private int ahorroEnergia;
	private String descripcion;
	
	
	public int getEncendido() {
		return encendido;
	}
	
	public void setEncendido(int encendido) {
		this.encendido = encendido;
	}
	
	public int getApagado() {
		return apagado;
	}
	
	public void setApagado(int apagado) {
		this.apagado = apagado;
	}
	public int getAhorroEnergia() {
		return ahorroEnergia;
	}
	public void setAhorroEnergia(int ahorroEnergia) {
		this.ahorroEnergia = ahorroEnergia;
	}
	public boolean estaEncendido() {
		return false;
	}
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
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
