package SensorActuador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Dispositivo.DispositivoInteligente;

@Entity
@Table(name="REGLAS")
public class Regla implements Observer {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@ManyToOne
	private Condicion condicion;
	@ManyToOne
	private CommandActuadores accion;
	@ManyToOne
	private DispositivoInteligente dispositivo;
	@Column(name="EnUso")
	private Boolean enUso;
	
	public Regla(Condicion condicion, CommandActuadores accion, DispositivoInteligente unDispositivo){
		this.setAccion(accion);
		this.setCondicion(condicion);
		this.setDispositivo(unDispositivo);
		this.setEnUso(false);
	}
	
	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

	public CommandActuadores getAccion() {
		return accion;
	}

	public void setAccion(CommandActuadores accion) {
		this.accion = accion;
	}

	public DispositivoInteligente getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}

	public boolean cumpleCondicion(){
		boolean cumpleCondicion = true;
		System.out.println("Llego a cumpleCondicion");
			if(!this.condicion.cumpleCondicion(this.dispositivo))
				cumpleCondicion = false;
		
		return cumpleCondicion;
	}
	
	public void ejecutarAcciones(){
		if(!this.cumpleCondicion())
			this.accion.ejecutarAccion(this.getDispositivo());
	}
	
	public boolean evaluarDispositivo(){
		boolean cumpleCondicion = this.cumpleCondicion();
		if(!cumpleCondicion){
			System.out.println("No Cumple");
			this.ejecutarAcciones();
		}
		return cumpleCondicion;
	}

	public void update(double valor) {
		this.evaluarDispositivo();
		System.out.println("Llego al update");
	}
	
	public Boolean getEnUso() {
		return enUso;
	}

	public void setEnUso(Boolean enUso) {
		this.enUso = enUso;
	}

}