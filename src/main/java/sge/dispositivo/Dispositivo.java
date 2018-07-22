package sge.dispositivo;

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
@JsonPropertyOrder({ "nombreDispositivo", "consumoKwh", "tipo", "fabricante"})

public abstract class Dispositivo {

	@JsonProperty("nombreDispositivo")
	private String nombreDispositivo;
	
	@JsonProperty("consumoKwh")
	private double consumoKwh;
	
	@JsonProperty("tipo")
	private String tipo;

	@JsonProperty("fabricante")
	private String fabricante;
	
	private Estado estado;

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
	public void setConsumoKwh(double consumoKwh) {
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
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public void convertirseEnInteligente() {
		this.tipo = "I";
		
	}

	public boolean esInteligente() {
		return (this.tipo=="I");
	}

	
	
}