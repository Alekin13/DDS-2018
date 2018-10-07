package Dispositivo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import Estado.Apagado;
import Estado.Encendido;
import Estado.Estado;
import Estado.ModoAhorroEnergia;
import Helper.EntityManagerHelper;

@Entity
@Table(name="DISPOSITIVOS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public abstract class Dispositivo {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="equipoConcreto")
	private String equipoConcreto;
	@Column(name="nombreDispositivo")
	private String nombreDispositivo;
	@Column(name="tipoDispositivo")
	private String tipoDispositivo;
	@Column(name="bajoConsumo")
	private String bajoConsumo;
	@Column(name="consumoKwH")
	private double consumoKwH;
	@Column(name="usoMensualMinHs")
	private double usoMensualMinHs;
	@Column(name="usoMensualMaxHs")
	private double usoMensualMaxHs;
	@ManyToOne
	private Estado estado;
	@OneToMany
	@JoinColumn(name="idDispositivo", referencedColumnName="id")
	private List<DispositivoEstado> estados = new ArrayList<>();
	@Transient
	private String auxiliarDescripcionEstado;
	
	public Dispositivo(){
		
	};
	
	public Dispositivo(String equipoConcreto, String nombreDispositivo, String tipoDispositivo, String bajoConsumo, double consumoKwH, double usoMensualMinHs, double usoMensualMaxHs, String estado){
		super();
		this.setEquipoConcreto(equipoConcreto);
		this.setNombreDispositivo(nombreDispositivo);
		this.setTipoDispositivo(tipoDispositivo);
		this.setBajoConsumo(bajoConsumo);
		this.setConsumoKwH(consumoKwH);
		this.setUsoMensualMaxHs(usoMensualMaxHs);
		this.setUsoMensualMinHs(usoMensualMinHs);
		this.setEstado(estado);		
	};
	
	public String getEquipoConcreto() {
		return equipoConcreto;
	}

	public void setEquipoConcreto(String equipoConcreto) {
		this.equipoConcreto = equipoConcreto;
	}

	public String getNombreDispositivo() {
		return nombreDispositivo;
	}

	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public String getBajoConsumo() {
		return bajoConsumo;
	}

	public void setBajoConsumo(String bajoConsumo) {
		this.bajoConsumo = bajoConsumo;
	}

	public double getConsumoKwH() {
		return consumoKwH;
	}

	public void setConsumoKwH(double consumoKwH) {
		this.consumoKwH = consumoKwH;
	}

	public double getUsoMensualMinHs() {
		return usoMensualMinHs;
	}

	public void setUsoMensualMinHs(double usoMensualMinHs) {
		this.usoMensualMinHs = usoMensualMinHs;
	}

	public double getUsoMensualMaxHs() {
		return usoMensualMaxHs;
	}

	public void setUsoMensualMaxHs(double usoMensualMaxHs) {
		this.usoMensualMaxHs = usoMensualMaxHs;
	}

	public boolean esInteligente() {
		return (this.getTipoDispositivo() == "I");
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(String estado){
		if(estado == "E") {
			this.estado = new Encendido();
			this.estado.setDescripcion("Encendido");
		} else if(estado == "A") {
			this.estado = new Apagado();
			this.estado.setDescripcion("Apagado");
		} else {
			this.estado = new ModoAhorroEnergia();
			this.estado.setDescripcion("ModoAhorroDeEnergia");
		}
	}
	
	public void setCambioEstado(String estado){
		EntityManagerHelper persistenciaDispositivo = new EntityManagerHelper();
		DispositivoEstado nuevoEstado = new DispositivoEstado(); 
		LocalDateTime now = LocalDateTime.now(); 
		
		nuevoEstado.setEstadoAnterior(this.estado.getDescripcion());
		
		if(estado == "E") {
			this.estado = new Encendido();
			this.estado.setDescripcion("Encendido");
		} else if(estado == "A") {
			this.estado = new Apagado();
			this.estado.setDescripcion("Apagado");
		} else {
			this.estado = new ModoAhorroEnergia();
			this.estado.setDescripcion("ModoAhorroDeEnergia");
		}
		
		nuevoEstado.setIdDispositivo(this.id);
		nuevoEstado.setEstadoActual(this.estado.getDescripcion());
		nuevoEstado.setHoraDeCambioDeEstado(now);
		
		persistenciaDispositivo.persistirDispositivoEstado(nuevoEstado);
	}

}