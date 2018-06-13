package sge.modelos.dispositivos;

import java.util.List;

import sge.modelos.estados.Apagado;
import sge.modelos.estados.Estado;
import sge.modelos.sensor.Sensor;

public class DispositivoInteligente extends Dispositivo {

	private String nombreDeDispositivo;
	private double kwPorHora;
	private Estado estado = new Apagado();
	private List<Sensor> sensores;
	private long   tiempoEncenido;
	public boolean registrado = false;	
	
	//Temporal Hasta Implementar Estados 
	public boolean encendido = false;
	public boolean modoAhorroEnergia = false;

	public DispositivoInteligente() {

	}

	public DispositivoInteligente(String nombreGenerico, long idFabricante, boolean encendido, boolean modoAhorroEnergia, boolean registrado, long id) {
		this.encendido = encendido;
		this.modoAhorroEnergia = modoAhorroEnergia;
		this.registrado = registrado;
	}
	
	
	
	//	tiempoEncenido = System.currentTimeMillis();
	
	
	
	// Temporalmente Hasta Implementar Estados
	public void encender() {
		this.encendido = true;
	}

	public void apagar() {
		this.encendido = false;
	}

	public boolean isEncendido() {
		return encendido;
	}

	public boolean isModoAhorroEnergia() {
		return modoAhorroEnergia;
	}

	public void activaAhorroEnergia() {
		this.modoAhorroEnergia = true;
	}
	
	public void apagarAhorroEnergia() {
		this.modoAhorroEnergia = false;
	}

	public boolean estaRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

	public boolean estaApagado() {
		return !encendido;
	}

	public void cambiarTemperatura(Integer valor) {
		
	}

}
