package sge.properties;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import sge.dispositivo.*;

public class ManejoProperties {
	
	Properties archivoPropiedades = new Properties();
	
	public String obtenerElCoeficiente(Dispositivo d) throws FileNotFoundException, IOException {
		
		archivoPropiedades.load(new FileReader("src/main/java/restricciones.properties"));
		return archivoPropiedades.getProperty( d.getPropiedad() +".coeficiente" );
		
	}
	
	
	public double obtenerElCoeficienteFormatoDouble(Dispositivo d) throws FileNotFoundException, IOException {
		
		archivoPropiedades.load(new FileReader("src/main/java/sge/properties/restricciones.properties"));
		double transformado = Double.parseDouble(archivoPropiedades.getProperty( d.getPropiedad() +".coeficiente" ));
		return transformado;
	}
}
