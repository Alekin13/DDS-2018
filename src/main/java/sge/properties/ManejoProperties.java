package sge.properties;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import sge.dispositivo.*;

public class ManejoProperties {
	
	Properties archivoPropiedades = new Properties();
	
	public String obtenerNombre(Dispositivo d) throws FileNotFoundException, IOException {
		archivoPropiedades.load(new FileReader("src/main/java/sge/properties/restricciones.properties"));
		return archivoPropiedades.getProperty( d.getPropiedad() +".dispositivo" );
	}
	
	
	public String obtenerElCoeficiente(Dispositivo d) throws FileNotFoundException, IOException {
		
		archivoPropiedades.load(new FileReader("src/main/java/sge/restricciones.properties"));
		return archivoPropiedades.getProperty( d.getPropiedad() +".coeficiente" );
		
	}
		
	
	public double obtenerElCoeficienteFormatoDouble(Dispositivo d) throws FileNotFoundException, IOException {
		archivoPropiedades.load(new FileReader("src/main/java/sge/properties/restricciones.properties"));
		double transformado = Double.parseDouble(archivoPropiedades.getProperty( d.getPropiedad() +".coeficiente" ));
		return transformado;
	}
	
	
	public String obtenerElUsoMensualMinHs(Dispositivo d) throws FileNotFoundException, IOException {
		archivoPropiedades.load(new FileReader("src/main/java/sge/restricciones.properties"));
		return archivoPropiedades.getProperty( d.getPropiedad() +".usomensualminhs" );
	}
	
	
	public double obtenerElUsoMensualMinHsFormatoDouble(Dispositivo d) throws FileNotFoundException, IOException {
		archivoPropiedades.load(new FileReader("src/main/java/sge/properties/restricciones.properties"));
		double transformado = Double.parseDouble(archivoPropiedades.getProperty( d.getPropiedad() +".usomensualminhs" ));
		return transformado;
	}
	
	
	public String obtenerElUsoMensualMaxHs(Dispositivo d) throws FileNotFoundException, IOException {
		archivoPropiedades.load(new FileReader("src/main/java/sge/restricciones.properties"));
		return archivoPropiedades.getProperty( d.getPropiedad() +".usomensualmaxhs" );
	}
	
	
	public double obtenerElUsoMensualMaxHsFormatoDouble(Dispositivo d) throws FileNotFoundException, IOException {
		archivoPropiedades.load(new FileReader("src/main/java/sge/properties/restricciones.properties"));
		double transformado = Double.parseDouble(archivoPropiedades.getProperty( d.getPropiedad() +".usomensualmaxhs" ));
		return transformado;
	}
	
	
	public double obtenerLimiteConsumoMensual() throws FileNotFoundException, IOException {
		archivoPropiedades.load(new FileReader("src/main/java/sge/properties/restricciones.properties"));
		double transformado = Double.parseDouble(archivoPropiedades.getProperty( "dispotivo.consumoLimiteMensual" ));
		return transformado;
	}
}
