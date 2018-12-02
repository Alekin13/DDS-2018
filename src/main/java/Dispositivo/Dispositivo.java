package Dispositivo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.persistence.*;

import org.junit.Ignore;

import Estado.Apagado;
import Estado.Encendido;
import Estado.Estado;
import Estado.ModoAhorroEnergia;

@Entity(name = "Dispositivo")
@Table(name = "Dispositivo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "Tipo_Dispositivo")
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
	@Column(name="DISP_FH_ULTIMO_EST")
	private LocalDateTime FHUltimoCambioEstado;
	//@Column(name="DISP_ESTADO")
	@Transient
	private Estado estado = new Encendido();
	//@OneToMany
	//@JoinColumn(name="DISP_ESTADO_ID", referencedColumnName="DISP_ID" , nullable=true)
	@Column(name="HORAS_USO_RECOMENDADAS")
	private double horasRecomendadas;
	@Transient
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
		this.setFHUltimoCambioEstado(LocalDateTime.now());
		this.setHorasRecomendadas(0.0);
	};
	
	public String getEquipoConcreto() {
		return equipoConcreto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		if(estado == "E"){
			this.estado = new Encendido();
		} else if(estado == "A"){
			this.estado = new Apagado();
		} else {
			this.estado = new ModoAhorroEnergia();
		}
		
	}
		
	public LocalDateTime getFHUltimoCambioEstado() {
		return this.FHUltimoCambioEstado;
	}

	public void setFHUltimoCambioEstado(LocalDateTime fHUltimoCambioEstado) {
		this.FHUltimoCambioEstado = fHUltimoCambioEstado;
	}

	public abstract void setCambioEstado(String estado);
	
	public double getHorasRecomendadas() {
		return horasRecomendadas;
	}

	public void setHorasRecomendadas(double horasRecomendadas) {
		this.horasRecomendadas = horasRecomendadas;
	}

	public List<DispositivoEstado> getEstados() {
		return estados;
	}

	public void setEstados(List<DispositivoEstado> estados) {
		this.estados = estados;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String getUrlBorrar() {
		return "/cliente/dispositivos/" + id + "/borrar";
	}

	public String getUrlEditar() {
		return "/cliente/dispositivos/" + id + "/editar";
	}

	public String getUrlVerConsumo() {
		return "/administrador/hogares-consumos/" + id;
	}

	public double consumoTotalComprendidoEntre(LocalDateTime inicio, LocalDateTime fin) {
		return 0;
	}
	
}