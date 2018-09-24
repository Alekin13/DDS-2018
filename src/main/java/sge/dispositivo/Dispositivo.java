package sge.dispositivo;

import java.io.FileNotFoundException;
import java.io.IOException;

import sge.estados.Estado;

/* Los tipos de dispositivo son por el momento:
 * I = Inteligente
 * A = Adaptado
 * E = Estandar
 */

public class Dispositivo {

	private String tipoDispositivo;
	private Estado estado;
	private double consumoKwH;
	private String nombreDispositivo;
	private String propiedad;
	private int dispositivo;
	private String idDispositivo;
	
	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public Estado getEstado() {
		return this.estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String getTipoDispositivo() {
		return this.tipoDispositivo;
	}
	
	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}
	
	public boolean esInteligente() {
		return (this.tipoDispositivo == "I");
	}
	
	public double getConsumoKwH() {
		return this.consumoKwH;
	}
	public void setConsumoKwH(double consumoKwH) {
		this.consumoKwH = consumoKwH;
	}

	public String getNombreDispositivo() {
		return this.nombreDispositivo;
	}
	
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}
	
	public String getPropiedad() {
		return this.propiedad;
	}
	
	public int getIdDispositivo() {
		return this.dispositivo;
	}
	
	public void setIdDispositivo(int idDispositivo) {
		this.dispositivo = idDispositivo;
	}

	public double obtenerCoeficiente() throws FileNotFoundException, IOException {
		return 0;
	}
	
	public double obtenerUsoMensualMinHS() throws FileNotFoundException, IOException {
		return 0;
	}
	
	public double obtenerUsoMensualMaxHS() throws FileNotFoundException, IOException {
		return 0;
	}	
	
	public String obtenerNombreDispositivo() throws FileNotFoundException, IOException {
		return null;
	}
	

}