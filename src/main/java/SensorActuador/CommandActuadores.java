package SensorActuador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import Dispositivo.DispositivoInteligente;

@Entity
@Table(name="Actuador")
public abstract class CommandActuadores {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public abstract void ejecutarAccion(DispositivoInteligente dispositivo);

}
