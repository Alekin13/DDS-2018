package sge.dispositivo;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sge.estados.Estado;

/* Los tipos de dispositivo son por el momento:
 * I = Inteligente
 * A = Adaptado
 * E = Estandar
 */

@Entity
@Table(name = "DISPOSITIVOS")
public class Dispositivo {
	@ManyToOne(cascade = CascadeType.ALL, optional=true)
	private Estado estado;
	
	private String propiedad;
	
	@Id
	@GeneratedValue
	private Long idDispositivo;
	private String nombreDispositivo;
	private String equipoConcreto;
	private String tipoDispositivo;
	private String bajoConsumo;
	private double consumoKwH;
	
	
//	public int getDispositivo() {
//		return dispositivo;
//	}
//	public void setDispositivo(int dispositivo) {
//		this.dispositivo = dispositivo;
//	}
	public String getEquipoConcreto() {
		return equipoConcreto;
	}
	public void setEquipoConcreto(String equipoConcreto) {
		this.equipoConcreto = equipoConcreto;
	}
	public String getBajoConsumo() {
		return bajoConsumo;
	}
	public void setBajoConsumo(String bajoConsumo) {
		this.bajoConsumo = bajoConsumo;
	}
	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}
	public void setIdDispositivo(Long idDispositivo) {
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
	
//	public int getIdDispositivo() {
//		return this.idDispositivo;
//	}
//	
//	public void setIdDispositivo(int idDispositivo) {
//		this.idDispositivo = idDispositivo;
//	}

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