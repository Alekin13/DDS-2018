package sge.dispositivo;

import java.io.FileNotFoundException;
import java.io.IOException;
import sge.properties.ManejoProperties;

public class DispositivoEstandar extends Dispositivo {

	private Long idDispositivo;
	private String nombreDispositivo;
	private double consumoKwH;
	private String tipoDispositivo;
	private double cantidadHsUsoEstimada;
	private ManejoProperties accesoAProperties= new ManejoProperties();
	private String propiedad;
	
	public DispositivoEstandar() {
	
	}
	
	public DispositivoEstandar(String nombreDispositivo, double consumoKwH){
		super();
		this.nombreDispositivo = nombreDispositivo;
		this.consumoKwH = consumoKwH;
		this.tipoDispositivo = "E";
	}

	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public Long getIdDispositivo() {
		return this.idDispositivo;
	}

	public void setIdDispositivo(Long idDispositivo) {
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
		EstandarToInteligenteAdapter dispositivoAAdaptar = new EstandarToInteligenteAdapter(this.idDispositivo, this.nombreDispositivo, this.consumoKwH, this.tipoDispositivo);
		System.out.println("Se ha Adaptado el siguiente dispositivo: " + dispositivoAAdaptar.getNombreDispositivo());
	}
	
}