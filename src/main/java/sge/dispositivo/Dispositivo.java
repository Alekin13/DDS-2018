package sge.dispositivo;

import sge.estados.Estado;

/* Los tipos de dispositivo son por el momento:
 * I = Inteligente
 * A = Adaptado
 * E = Estandar
 */

public abstract class Dispositivo {

	private String tipoDispositivo;
	private Estado estado;
	private double consumoKwH;
	private String nombreDispositivo;
	
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
	
	
	/*
	public int getIdDispositivo();
	public void setIdDispositivo(int idDispositivo);
	
	
	

	
	public double getIdFabricante();
	public void setIdFabricante(double idFabricante);
	
	
	
	

	public void convertirseAInteligente();
	
	public double getIdAdaptador();
	public void setIdAdaptador(double idAdaptador);	
	
	public double obtenerCoeficiente() throws FileNotFoundException, IOException;
	
	public double obtenerUsoMensualMinHS() throws FileNotFoundException, IOException;
	
	public double obtenerUsoMensualMaxHS() throws FileNotFoundException, IOException;	
	
	public String obtenerNombreDispositivo() throws FileNotFoundException, IOException;
	
	public String getPropiedad();
}

*/
}