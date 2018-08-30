package sge.dispositivo;

import java.io.FileNotFoundException;
import java.io.IOException;

import sge.properties.ManejoProperties;
import sge.actuador.CommandActuadores;
import sge.estados.Apagado;
import sge.estados.Encendido;
import sge.estados.Estado;
import sge.estados.ModoAhorroEnergia;
import sge.sensor.*;

public class DispositivoInteligente extends Dispositivo {

	private int idDispositivo;
	private String nombreDispositivo;
	private double consumoKwH;
	private String tipoDispositivo;
	private Estado estado;
	private double consumidoKwH; //KWxH Consumido -> Aca se guarda lo consumido cuando cambia de estado
	private long tiempoEncendido;
	
	public DispositivoInteligente() {

	}

	public DispositivoInteligente(int idDispositivo, String nombreDispositivo, double consumoKwH, Estado estado){
		super();
		this.idDispositivo = idDispositivo;
		this.nombreDispositivo = nombreDispositivo;
		this.consumoKwH = consumoKwH;
		this.tipoDispositivo = "I";
		this.estado = estado;
	}
	
	public int getIdDispositivo() {
		return idDispositivo;
	}
	
	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}

	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}

	public double getConsumoKwH() {
		return consumoKwH;
	}
	
	public void setConsumoKwH(double consumoKwH) {
		this.consumoKwH = consumoKwH;
	}
	
	public String getTipoDispositivo() {
		return tipoDispositivo;
	}
	
	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String estadoDelDispositivo() {
		if(this.getEstado().estaEncendido())
			return "ENCENDIDO";
		else if(this.getEstado().estaApagado())
			return "APAGADO";
		else
			return "MODOAHORRO";
	}
	
	public boolean estaEncendido(Dispositivo unDispositivo) {
		return (this.estadoDelDispositivo()=="ENCENDIDO");
	}
	
	public boolean estaApagado(Dispositivo unDispositivo) {
		return (this.estadoDelDispositivo()=="APAGADO");
	}
	
	private double calcularConsumo(double consumoKwHDispositivo, long tiempoQueEstuvoEncendido) {
		double consumoDelDispositivo = tiempoQueEstuvoEncendido * consumoKwHDispositivo;
		this.tiempoEncendido = 0;
		return consumoDelDispositivo;
		//Cambiar cuando llegue la persistencia, 
		//1. Preguntar cuanto consumieron en n horas -> se va a guardar en una tabla los rangos
		//2. Preguntar el consumo de un periodo -> idem
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private double idFabricante;
	private double idAdaptador;
	
	
	//Deshabilitado = Dispositivo no disponible -> esto seria cuando el estandar pasa a inteligente
	private boolean dispositivoHabilitado;
	
	//Valor Inherente del Dispositivo: Seria el atributo que hace al dispositivo(Temperatura,Encendido,Apagado,etc.)
	private double valorInherente;
	

	//Actuador asociado al dispositivo
	private CommandActuadores actuador;
	
	//Sensor asociado al dispositivo
	private Sensor sensor;
	
	private double coeficiente;
	
	private String propiedad;
	
	private ManejoProperties accesoAProperties= new ManejoProperties();
	
	public DispositivoInteligente(int idDispositivo, String nombreDispositivo, double consumoKwH, double idFabricante,
			double idAdaptador, Estado estado, double valorInherente, CommandActuadores actuador, Sensor sensor ){
		
		super();
		this.idDispositivo = idDispositivo;
		this.nombreDispositivo = nombreDispositivo;
		this.consumoKwH = consumoKwH;
		this.tipoDispositivo = "I";
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
		if(!this.estaEncendido(this)){
			this.setEstado(new Encendido());
			tiempoEncendido = System.currentTimeMillis();
		}
	}
	
	public void apagarDispositivo() {
		if(!this.estaApagado(this)){
			this.setEstado(new Apagado());
			consumidoKwH = consumidoKwH + this.calcularConsumo(this.getConsumoKwH(),this.tiempoEncendido);
		}		
	}
	
	public void activaAhorroEnergia(){
		if(this.getEstado().equals(new Encendido())){
			this.tiempoEncendido = System.currentTimeMillis();
			this.setEstado(new ModoAhorroEnergia());
		}
	}

	public void apagarAhorroEnergia() {
		if(this.getEstado().equals(new ModoAhorroEnergia())){
			this.tiempoEncendido = System.currentTimeMillis();
			this.encenderDispositivo();
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

	
	public boolean esInteligente() {
		return (this.tipoDispositivo == "I");
	}


	
	public double getIdFabricante() {
		return idFabricante;
	}

	
	public void setIdFabricante(double idFabricante) {
		this.idFabricante = idFabricante;
	}

	
	public double getIdAdaptador() {
		return idAdaptador;
	}

	
	public void setIdAdaptador(double idAdaptador) {
		this.idAdaptador = idAdaptador;
	}

	public double obtenerCoeficiente() throws FileNotFoundException, IOException{
		return this.accesoAProperties.obtenerElCoeficienteFormatoDouble(this);
	}
	
	public double obtenerUsoMensualMinHS() throws FileNotFoundException, IOException{
		return this.accesoAProperties.obtenerElUsoMensualMinHsFormatoDouble(this);
	}
	
	public double obtenerUsoMensualMaxHS() throws FileNotFoundException, IOException{
		return this.accesoAProperties.obtenerElUsoMensualMaxHsFormatoDouble(this);
	}

	public String obtenerNombreDispositivo() throws FileNotFoundException, IOException{
		return this.accesoAProperties.obtenerNombre(this);
	}
	
	
	public void convertirseAInteligente() {
		System.out.println("Este dispositivo ya es inteligente. No se realizarán cambios.");
		
	}
	
	//@JsonPropertyOrder({ "idDispositivo","nombreDispositivo", "consumoKwH", "tipoDispositivo", "idFabricante"})
}