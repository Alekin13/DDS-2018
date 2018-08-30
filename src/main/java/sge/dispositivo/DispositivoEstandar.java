package sge.dispositivo;

import java.io.FileNotFoundException;
import java.io.IOException;
import sge.properties.ManejoProperties;

public class DispositivoEstandar extends Dispositivo {

	private int idDispositivo;
	private String nombreDispositivo;
	private double consumoKwH;
	private String tipoDispositivo;
	private double cantidadHsUsoEstimada;
	
	public DispositivoEstandar() {
	
	}
	
	public DispositivoEstandar(int idDispositivo, String nombreDispositivo, double consumoKwH){
		super();
		this.idDispositivo = idDispositivo;
		this.nombreDispositivo = nombreDispositivo;
		this.consumoKwH = consumoKwH;
		this.tipoDispositivo = "E";
	}

	public int getIdDispositivo() {
		return this.idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getNombreDispositivo() {
		return "Dispositivo Estandar";
	}

	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = "Dispositivo Estandar";
	}

	public double getConsumoKwH() {
		return this.consumoKwH;
	}

	public void setConsumoKwH(double consumoKwH) {
		this.consumoKwH = consumoKwH;
	}

	public String getTipoDispositivo() {
		return "E";
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = "E";
	}
	
	public double getCantidadHsUsoEstimada() {
		return cantidadHsUsoEstimada;
	}

	public void setCantidadHsUsoEstimada(double cantidadHsUsoEstimada) {
		this.cantidadHsUsoEstimada = cantidadHsUsoEstimada;
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@JsonProperty("idDispositivo")
	@JsonProperty("nombreDispositivo")
	@JsonProperty("consumoKwH")
	@JsonProperty("tipoDispositivo")
	@JsonProperty("idFabricante")
*/
	
	private double idFabricante;


	
	
	private ManejoProperties accesoAProperties= new ManejoProperties();

	private String propiedad;
	
	public DispositivoEstandar(int idDispositivo, String nombreDispositivo, double consumoKwH, double idFabricante){
		this.idDispositivo = idDispositivo;
		this.nombreDispositivo = nombreDispositivo;
		this.consumoKwH = consumoKwH;
		this.tipoDispositivo = "E";
		this.idFabricante = idFabricante;
	}
	
	public void convertirseAInteligente() {
		EstandarToInteligenteAdapter dispositivoAAdaptar = new EstandarToInteligenteAdapter(this.idDispositivo, this.nombreDispositivo, this.consumoKwH, this.tipoDispositivo);
		System.out.println("Se ha Adaptado el siguiente dispositivo: " + dispositivoAAdaptar.getNombreDispositivo());
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public double getIdFabricante() {
		return this.idFabricante;
	}

	
	public void setIdFabricante(double idFabricante) {
		this.idFabricante = idFabricante;
	}


	

	
	public double obtenerCoeficiente() throws FileNotFoundException, IOException {
		return this.accesoAProperties.obtenerElCoeficienteFormatoDouble(this);
	}

	
	public String getPropiedad() {
		return propiedad;
	}
	
	public double obtenerUsoMensualMinHS() throws FileNotFoundException, IOException{
		return this.accesoAProperties.obtenerElUsoMensualMinHsFormatoDouble(this);
	}
	
	public double obtenerUsoMensualMaxHS() throws FileNotFoundException, IOException{
		return this.accesoAProperties.obtenerElUsoMensualMaxHsFormatoDouble(this);
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public String obtenerNombreDispositivo() throws FileNotFoundException, IOException{
		return this.accesoAProperties.obtenerNombre(this);
	}	
}