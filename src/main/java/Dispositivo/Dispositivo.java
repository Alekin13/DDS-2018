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
@Table(name="DISPOSITIVO")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CLASE")
public abstract class Dispositivo {
	
	@Id
	@GeneratedValue
	@Column(name="DISP_ID")
	private int id;
	@Column(name="DISP_EQUIPO")
	private String equipoConcreto;
	@Column(name="DISP_NOMBRE")
	private String nombreDispositivo;
	@Column(name="DISP_TIPO")
	private String tipoDispositivo;
	@Column(name="DISP_BAJO_CONSUMO")
	private String bajoConsumo;
	@Column(name="DISP_CONSUMO_KWH")
	private double consumoKwH;
	@Column(name="DISP_USO_MENSUAL_MIN")
	private double usoMensualMinHs;
	@Column(name="DISP_USO_MENSUAL_MAX")
	private double usoMensualMaxHs;
	@Transient
	@Column(name="DISP_ESTADO")
	private Estado estado;
	@OneToMany
	@JoinColumn(name="DISP_ESTADO_ID", referencedColumnName="DISP_ID" , nullable=true)
	private List<DispositivoEstado> estados = new ArrayList<>();
	
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