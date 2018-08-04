package sge.dispositivo;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import Properties.ManejoProperties;
import sge.actuador.CommandActuadores;
import sge.estados.Apagado;
import sge.estados.Encendido;
import sge.estados.Estado;
import sge.estados.ModoAhorroEnergia;
import sge.sensor.*;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idDispositivo","nombreDispositivo", "consumoKwH", "tipoDispositivo", "idFabricante"})
public class DispositivoInteligente implements Dispositivo {

	@JsonProperty("idDispositivo")
	private int idDispositivo;

	@JsonProperty("nombreDispositivo")
	private String nombreDispositivo;

	@JsonProperty("consumoKwH")
	private double consumoKwH;

	@JsonProperty("tipoDispositivo")
	private String tipoDispositivo;

	@JsonProperty("idFabricante")
	private double idFabricante;

	//ID del Adaptador
	private double idAdaptador;

	//Estado del Dispositivo.
	private Estado estado;
	
	//Deshabilitado = Dispositivo no disponible -> esto seria cuando el estandar pasa a inteligente
	private boolean dispositivoHabilitado;
	
	//Valor Inherente del Dispositivo: Seria el atributo que hace al dispositivo(Temperatura,Encendido,Apagado,etc.)
	private double valorInherente;
	
	//KWxH Consumido -> Aca se guarda lo consumido cuando cambia de estado 
	private double consumidoKwH;
	
	//Esta variable va indicar cuanto tiempo estuvo encendido el dispositivo
	private long tiempoEncendido;

	//Actuador asociado al dispositivo
	private CommandActuadores actuador;
	
	//Sensor asociado al dispositivo
	private Sensor sensor;
	
	private double coeficiente;
	
	private String propiedad;
	
	private ManejoProperties accesoAProperties= new ManejoProperties();
	
	public DispositivoInteligente() {

	}

	public DispositivoInteligente(int idDispositivo, String nombreDispositivo, double consumoKwH, String tipoDispositivo, double idFabricante,
			double idAdaptador, Estado estado, double valorInherente, CommandActuadores actuador, Sensor sensor ){
		
		super();
		this.idDispositivo = idDispositivo;
		this.nombreDispositivo = nombreDispositivo;
		this.consumoKwH = consumoKwH;
		this.tipoDispositivo = tipoDispositivo;
		this.idFabricante = idFabricante;
		this.idAdaptador = idAdaptador;
		this.estado = estado;
		this.dispositivoHabilitado = true;
		this.valorInherente = valorInherente;
		this.consumidoKwH = 0;

		
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public void encenderDispositivo() {
		this.setEstado(new Encendido());
		tiempoEncendido = System.currentTimeMillis();
	}
	
	public void apagarDispositivo() {
		this.setEstado(new Apagado());
		consumidoKwH = consumidoKwH + this.calcularConsumo(this.getConsumoKwH(),this.tiempoEncendido);
	}
	
	private double calcularConsumo(double consumoKwHDispositivo, long tiempoQueEstuvoEncendido) {
		double consumoDelDispositivo = tiempoQueEstuvoEncendido * consumoKwHDispositivo;
		this.tiempoEncendido = 0;
		return consumoDelDispositivo;
	}
	
	public void activaAhorroEnergia() {
		if(this.getEstado().equals(new Apagado())){
			this.tiempoEncendido = System.currentTimeMillis();
		}
		this.setEstado(new ModoAhorroEnergia());
	}

	public void apagarAhorroEnergia() {
		this.encenderDispositivo();
	}
	
	public String estadoDelDispositivo() {
		
		if(this.getEstado().estaEncendido())
		{
			return "El dispositivo se encuentra encendido";
		}
		else if(this.getEstado().estaApagado()){
			return "El dispositivo se encuentra apagado";
		}
		else{
			return "El dispositivo se encuentra en Modo de Ahorro";
		}
	}
	
	public void cambiarTemperatura(Integer valor) {
		//Pone el aire a 24
		if(this.valorInherente < 21){
			this.valorInherente = 24;
		}
		this.valorInherente = 24;
	}

	public boolean isDispositivoHabilitado() {
		return dispositivoHabilitado;
	}

	public void setDispositivoHabilitado(boolean dispositivoHabilitado) {
		this.dispositivoHabilitado = dispositivoHabilitado;
	}

	public double getValorInherente() {
		return valorInherente;
	}

	public void setValorInherente(double valorInherente) {
		this.valorInherente = valorInherente;
	}

	public double getConsumidoKwH() {
		return consumidoKwH;
	}

	public void setConsumidoKwH(double consumidoKwH) {
		this.consumidoKwH = consumidoKwH;
	}

	public long getTiempoEncendido() {
		return tiempoEncendido;
	}

	public void setTiempoEncendido(long tiempoEncendido) {
		this.tiempoEncendido = tiempoEncendido;
	}

	public CommandActuadores getActuador() {
		return actuador;
	}

	public void setActuador(CommandActuadores actuador) {
		this.actuador = actuador;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public void convertirseAInteligente() {
		this.tipoDispositivo = "I";
		
	}

	@Override
	public boolean esInteligente() {
		return (this.tipoDispositivo == "I");
	}

	@Override
	public int getIdDispositivo() {
		return idDispositivo;
	}

	@Override
	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	@Override
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}

	@Override
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}

	@Override
	public double getConsumoKwH() {
		return consumoKwH;
	}

	@Override
	public void setConsumoKwH(double consumoKwH) {
		this.consumoKwH = consumoKwH;
	}

	@Override
	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	@Override
	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	@Override
	public double getIdFabricante() {
		return idFabricante;
	}

	@Override
	public void setIdFabricante(double idFabricante) {
		this.idFabricante = idFabricante;
	}

	@Override
	public Estado getEstado() {
		return estado;
	}

	@Override
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public double getIdAdaptador() {
		return idAdaptador;
	}

	@Override
	public void setIdAdaptador(double idAdaptador) {
		this.idAdaptador = idAdaptador;
	}

	public double obtenerCoeficiente() throws FileNotFoundException, IOException{
		return accesoAProperties.obtenerElCoeficienteFormatoDouble(this);
	}
}





















