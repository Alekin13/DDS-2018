package sge.sensor;

import sge.dispositivo.DispositivoInteligente;
import sge.observer.ObserverSensor;


public abstract class Sensor{

	private double valor;
	private String magnitud;
	private ObserverSensor observer;
	private DispositivoInteligente dispositivo;
	
	public Sensor() {
	
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getMagnitud() {
		return magnitud;
	}
	
	public void setMagnitud(String magnitud) {
		this.magnitud = magnitud;
	}
	
	public ObserverSensor getObserver() {
		return observer;
	}

	public void setObserver(ObserverSensor observer) {
		this.observer = observer;
	}

	public DispositivoInteligente getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	
	public void subscribir(ObserverSensor observer){
		setObserver(observer);
	}	
	
	public void	notificarObservadores(){
		this.getObserver().observerActualizar();
	}	
	
	public double tomarMedicionDispositivo(DispositivoInteligente unDispositivo){
		double medicion = (unDispositivo.getTiempoEncendido() / 3600) * unDispositivo.getConsumoKwh();
		return medicion;
	} 
	
	public void medirMagnitud(){
		double unaMagnitud = tomarMedicionDispositivo(this.dispositivo);
		this.setValor(unaMagnitud);
		this.notificarObservadores();
	}
	
}

