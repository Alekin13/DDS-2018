package sge.dispositivo;

import java.util.List;

import sge.actuador.Actuador;
import sge.estados.Apagado;
import sge.estados.Encendido;
import sge.estados.Estado;
import sge.estados.ModoAhorroEnergia;
import sge.sensor.Sensor;

public class DispositivoInteligente extends Dispositivo {

	private long tiempoEncendido;
	public boolean registrado = false;
	public double KwhConsumido;
	public Actuador actuador;
	private Sensor sensor;
	
	public DispositivoInteligente() {

	}

	public DispositivoInteligente(String valorNombreDispositivo, double valorConsumoKwh, Estado valorEstado,
			List<Sensor> valorSensores, long valorTiempoEncendido, boolean valorRegistrado, 
			double valorKwhConsumido, String valorTipo, String valorFabricante) {
		super(valorNombreDispositivo, valorConsumoKwh, valorEstado, valorTipo);
		this.tiempoEncendido = valorTiempoEncendido;
		this.registrado = valorRegistrado;
		this.KwhConsumido = valorKwhConsumido;
	}

	public void encenderDispositivo() {
		super.setEstado(new Encendido());
		tiempoEncendido = System.currentTimeMillis();
	}
	
	public void apagarDispositivo() {
		super.setEstado(new Apagado());
		KwhConsumido = KwhConsumido + this.calcularConsumo(this,tiempoEncendido);
	}
	
	public void activaAhorroEnergia() {
		super.setEstado(new ModoAhorroEnergia());
	}

	public void apagarAhorroEnergia() {
		this.encenderDispositivo();
	}
	
	
	public long getTiempoEncendido() {
		return tiempoEncendido;
	}

	public void setTiempoEncendido(long tiempoEncendido) {
		this.tiempoEncendido = tiempoEncendido;
	}

	public String estadoDelDispositivo() {
		
		if(super.getEstado().estaEncendido())
		{
			return "El dispositivo se encuentra encendido";
		}
		else if(super.getEstado().estaApagado()){
			return "El dispositivo se encuentra apagado";
		}
		else{
			return "El dispositivo se encuentra en Modo de Ahorro";
		}
	}
	
	private double calcularConsumo(DispositivoInteligente dispositivoInteligente, long tiempoQueEstuvoEncendido) {
		return tiempoQueEstuvoEncendido * dispositivoInteligente.getConsumoKwh();
	}
	
	public boolean estaRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

	public void cambiarTemperatura(Integer valor) {
		// TODO Auto-generated method stub
		
	}

	public double getKwhConsumido() {
		return KwhConsumido;
	}

	public void setKwhConsumido(double kwhConsumido) {
		KwhConsumido = kwhConsumido;
	}

	public Actuador getActuador() {
		return actuador;
	}

	public void setActuador(Actuador actuador) {
		this.actuador = actuador;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	
}
