package sge.modelos.dispositivos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sge.modelos.estados.Apagado;
import sge.modelos.estados.Encendido;
import sge.modelos.estados.Estado;
import sge.modelos.estados.ModoAhorroEnergia;
import sge.modelos.sensor.Sensor;

public class DispositivoInteligente extends Dispositivo {

	private String nombreDispositivo;
	private double consumoKwh;
	private Estado estado = new Apagado();
	private List<Sensor> sensores;
	private long   tiempoEncendido;
	public boolean registrado = false;
	public double KwhConsumido;
	private String tipo;
	private String fabricante;
	
	
	public DispositivoInteligente() {

	}

	public DispositivoInteligente(String valorNombreDispositivo, double valorConsumoKwh, Estado valorEstado,
			List<Sensor> valorSensores, long valorTiempoEncendido, boolean valorRegistrado, 
			double valorKwhConsumido, String valorTipo, String valorFabricante) {
		super(valorNombreDispositivo, valorConsumoKwh, valorEstado, valorTipo);
		this.sensores = valorSensores;
		this.tiempoEncendido = valorTiempoEncendido;
		this.registrado = valorRegistrado;
		this.KwhConsumido = valorKwhConsumido;
		this.fabricante = valorFabricante;
	}

	public void encenderDispositivo() {
		this.estado = new Encendido();
		tiempoEncendido = System.currentTimeMillis();
	}
	
	public void apagarDispositivo() {
		this.estado = new Apagado();
		KwhConsumido = KwhConsumido + this.calcularConsumo(this,tiempoEncendido);
	}
	
	public void activaAhorroEnergia() {
		this.estado = new ModoAhorroEnergia();
	}

	public void apagarAhorroEnergia() {
		this.encenderDispositivo();
	}
	
	public String estadoDelDispositivo() {
		
		if(estado.estaEncendido())
		{
			return "El dispositivo se encuentra encendido";
		}
		else if(estado.estaApagado()){
			return "El dispositivo se encuentra apagado";
		}
		else{
			return "El dispositivo se encuentra en Modo de Ahorro";
		}
	}
	
	private double calcularConsumo(DispositivoInteligente dispositivoInteligente, long tiempoQueEstuvoEncendido) {
		return tiempoQueEstuvoEncendido * dispositivoInteligente.consumoKwh;
	}
	
	public boolean estaRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

}
