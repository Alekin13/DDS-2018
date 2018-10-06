package SensorActuador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import Dispositivo.DispositivoInteligente;

@Entity
@Table(name="Condicion")
public abstract class Condicion{
	
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	public abstract boolean cumpleCondicion(DispositivoInteligente dispositivoInteligente);

}