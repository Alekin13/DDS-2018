package Dispositivo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import Estado.Estado;

/* Esta clase representa la tabla que rompe la relacion de "muchos a muchos" entre estado y dispositivo */

@Entity
@Table(name="dispositivoEstados")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class DispositivoEstado {
	
	// Clave subrrogada para identificar el estado
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="idDispositivo")
	private int idDispositivo;
	@Column(name="estadoAnterior")
	private String estadoAnterior;
	@Column(name="estadoActual")
	private String estadoActual;
	@Column(name="fechaDeCambioDeEstado")
	private LocalDateTime fechaDeCambioDeEstado;
	@Column(name="consumoEstadoPasado")
	private LocalDateTime consumoEstadoPasado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public String getEstadoAnterior() {
		return estadoAnterior;
	}
	public void setEstadoAnterior(String estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}
	public String getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}
	public void setFechaActual() {
		fechaDeCambioDeEstado.toLocalDate();
	}
	public LocalDateTime getHoraDeCambioDeEstado() {
		return fechaDeCambioDeEstado;
	}
	public void setHoraDeCambioDeEstado(LocalDateTime horaDeCambioDeEstado) {
		this.fechaDeCambioDeEstado = horaDeCambioDeEstado;
	}
	public LocalDateTime getConsumoEstadoPasado() {
		return consumoEstadoPasado;
	}
	public void setConsumoEstadoPasado(LocalDateTime consumoEstadoPasado) {
		this.consumoEstadoPasado = consumoEstadoPasado;
	}
	
	
}
