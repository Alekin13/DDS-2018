package sge.dispositivo;

import java.io.FileNotFoundException;
import java.io.IOException;

import sge.estados.Estado;

public interface Dispositivo {

	public int getIdDispositivo();
	public void setIdDispositivo(int idDispositivo);
	
	public String getNombreDispositivo();
	public void setNombreDispositivo(String nombreDispositivo);
	
	public double getConsumoKwH();
	public void setConsumoKwH(double consumoKwH);
	
	public String getTipoDispositivo();
	public void setTipoDispositivo(String tipoDispositivo);
	
	public double getIdFabricante();
	public void setIdFabricante(double idFabricante);
	
	public Estado getEstado();
	public void setEstado(Estado estado);
	
	
	public boolean esInteligente();
	public void convertirseAInteligente();
	
	public double getIdAdaptador();
	public void setIdAdaptador(double idAdaptador);	
	
	public double obtenerCoeficiente() throws FileNotFoundException, IOException;
	
	public double obtenerUsoMensualMinHS() throws FileNotFoundException, IOException;
	
	public double obtenerUsoMensualMaxHS() throws FileNotFoundException, IOException;	
	
	public String getPropiedad();
}

/* Los tipos de dispositivo son por el momento:
 * I = Inteligente
 * A = Adaptado
 * E = Estandar
 * */
 