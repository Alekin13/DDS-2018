package sge.dispositivo;

import java.io.FileNotFoundException;
import java.io.IOException;

import sge.properties.ManejoProperties;
import sge.sensor.Sensor;
import sge.actuador.CommandActuadores;
import sge.estados.Apagado;
import sge.estados.Encendido;
import sge.estados.Estado;
import sge.estados.ModoAhorroEnergia;

public class DispositivoInteligente extends Dispositivo {

	private Long idDispositivo;
	private String nombreDispositivo;
	private double consumoKwH;
	private String tipoDispositivo;
	private Estado estado;
	private double consumidoKwH; //KWxH Consumido -> Aca se guarda lo consumido cuando cambia de estado
	private long tiempoEncendido;
	private String propiedad;
	private ManejoProperties accesoAProperties = new ManejoProperties();
	private double valorInherente;//Valor Inherente del Dispositivo: Seria el atributo que hace al dispositivo(Temperatura,Encendido,Apagado,etc.)
	private Sensor sensor;
	private CommandActuadores actuador;
	
	public DispositivoInteligente() {

	}

	public DispositivoInteligente(String nombreDispositivo, double consumoKwH, Estado estado){
		super();
		this.nombreDispositivo = nombreDispositivo;
		this.consumoKwH = consumoKwH;
		this.tipoDispositivo = "I";
		this.estado = estado;
	}
	
	public Long getIdDispositivo() {
		return idDispositivo;
	}
	
	public void setIdDispositivo(Long idDispositivo) {
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

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public CommandActuadores getActuador() {
		return actuador;
	}

	public void setActuador(CommandActuadores actuador) {
		this.actuador = actuador;
	}

	public long getTiempoEncendido() {
		return tiempoEncendido;
	}

	public void setTiempoEncendido(long tiempoEncendido) {
		this.tiempoEncendido = tiempoEncendido;
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
	
	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public void encenderDispositivo() {
		//ARREGLAR GENERA NULLPOINTERif(!this.estaEncendido(this)){
			this.setEstado(new Encendido());
			tiempoEncendido = System.currentTimeMillis();
		
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
	
	public boolean esInteligente() {
		return (this.tipoDispositivo == "I");
	}
	
	@Override
	public double obtenerCoeficiente() throws FileNotFoundException, IOException {
		return this.accesoAProperties.obtenerElCoeficienteFormatoDouble(this);
	}

	@Override
	public double obtenerUsoMensualMinHS() throws FileNotFoundException, IOException{
		return this.accesoAProperties.obtenerElUsoMensualMinHsFormatoDouble(this);
	}
	
	@Override
	public double obtenerUsoMensualMaxHS() throws FileNotFoundException, IOException{
		return this.accesoAProperties.obtenerElUsoMensualMaxHsFormatoDouble(this);
	}

	@Override
	public String obtenerNombreDispositivo() throws FileNotFoundException, IOException{
		return this.accesoAProperties.obtenerNombre(this);
	}
	
	public void convertirseAInteligente() {
		System.out.println("Este dispositivo ya es inteligente. No se realizarán cambios.");
	}
	
}