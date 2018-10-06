package SensorActuador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Dispositivo.DispositivoInteligente;

@Entity
@Table(name="Regla")
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
	
	public Regla(Condicion condicion, CommandActuadores accion, DispositivoInteligente unDispositivo){
		this.setAccion(accion);
		this.setCondicion(condicion);
		this.setDispositivo(unDispositivo);
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
			this.ejecutarAcciones();
		}
		return cumpleCondicion;
	}

	public void update(double valor) {
		System.out.println(valor);
	}

}