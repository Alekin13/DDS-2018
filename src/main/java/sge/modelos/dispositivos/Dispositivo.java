package sge.modelos.dispositivos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import sge.modelos.estados.Apagado;
import sge.modelos.estados.Encendido;
import sge.modelos.estados.Estado;
import sge.modelos.sensor.Sensor;

/**
 * Clase que modela la entidad dispositivo
 * @author Alejandro
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nombreDispositivo", "consumoKwh", "estado", "tipo", "fabricante"})

public abstract class Dispositivo {

	@JsonProperty("nombreDispositivo")
	private String nombreDispositivo;
	
	@JsonProperty("consumoKwh")
	private double consumoKwh;
	
	//Esto seguramente cambiemos
	@JsonProperty("estado")
	private Estado estado;

	@JsonProperty("tipo")
	private String tipo;

	//Esto seguramente lo tranformemos en clase Fabricante
	@JsonProperty("fabricante")
	private String fabricante;
	
	//Esto seguramente lo tranformemos en clase Fabricante
	@JsonProperty("esInteligente")
	private boolean esInteligente;
	
	//Esto seguramente lo tranformemos en clase Fabricante
	@JsonProperty("fueAdaptado")
	private boolean fueAdaptado;

	//Por ahora sabemos que algun adaptador puede tener si es Estandar, sera una clase tambien posiblemente
	private String adaptador;
	
	public Dispositivo() {

	}

	public Dispositivo(String valorNombreDispositivo, double valorConsumo, Estado valorEstado, String valorTipo) {
		
		super();
		this.nombreDispositivo = valorNombreDispositivo;
		this.consumoKwh = valorConsumo;
		this.estado = valorEstado;
		this.tipo = valorTipo;
	}


	/**
	 * @return the nombreDispositivo
	 */
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}


	/**
	 * @param nombreDispositivo the nombreDispositivo to set
	 */
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}


	/**
	 * @return the consumoKwh
	 */
	public double getConsumoKwh() {
		return consumoKwh;
	}


	/**
	 * @param consumoKwh the consumoKwh to set
	 */
	public void setConsumoKwh(Float consumoKwh) {
		this.consumoKwh = consumoKwh;
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean estaEncendido() {
		return true;
	}

    /**
	 * @return the fabricante
	 */
	public String getFabricante() {
		return fabricante;
	}

	/**
	 * @param fabricante the fabricante to set
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	/**
	 * @return the adaptador
	 */
	public String getAdaptador() {
		return adaptador;
	}

	/**
	 * @param adaptador the adaptador to set
	 */
	public void setAdaptador(String adaptador) {
		this.adaptador = adaptador;
	}
	

	public boolean isEsInteligente() {
		return esInteligente;
	}

	public void setEsInteligente(boolean esInteligente) {
		this.esInteligente = esInteligente;
	}

	public boolean isFueAdaptado() {
		return fueAdaptado;
	}

	public void setFueAdaptado(boolean fueAdaptado) {
		this.fueAdaptado = fueAdaptado;
	}

	public void convertirseEnInteligente() {
		this.setFueAdaptado(true);		
	}

	public Object getEstado() {
		// TODO Auto-generated method stub
		return null;
	}
	
}