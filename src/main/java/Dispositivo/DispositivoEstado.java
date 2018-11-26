package Dispositivo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/* Esta clase representa la tabla que rompe la relacion de "muchos a muchos" entre estado y dispositivo */

@Entity
@Table(name="DISPOSITIVO_ESTADOS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({@NamedQuery(name = "DispositivoEstado.getAll", query = "SELECT d from DispositivoEstado d")})
public class DispositivoEstado {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="idDispositivo")
	private int idDispositivo;
	@Column(name="estadoAnterior")
	private String estadoAnterior;
	@Column(name="estadoActual")
	private String estadoActual;
	@Column(name="fechaDeCambioDeEstado")
	private String fechaDeCambioDeEstado;
	@Column(name="consumoEstadoPasado")
	private double consumoEstadoPasado;
	
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
	public void setFechaDeCambioDeEstado() {
		fechaDeCambioDeEstado.toString();
	}
	public String getFechaDeCambioDeEstado() {
		return fechaDeCambioDeEstado;
	}
	public void setHoraDeCambioDeEstado(LocalDateTime horaDeCambioDeEstado) {
		this.fechaDeCambioDeEstado = horaDeCambioDeEstado.toString();
	}
	public double getConsumoEstadoPasado() {
		return consumoEstadoPasado;
	}
	public void setConsumoEstadoPasado(double consumoEstadoPasado) {
		this.consumoEstadoPasado = consumoEstadoPasado;
	}
	
	
}
