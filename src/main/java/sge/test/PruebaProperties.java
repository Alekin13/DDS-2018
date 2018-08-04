package sge.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class PruebaProperties {

	@Test
	public void test() throws FileNotFoundException, IOException {
		
		Properties archivoPropiedades = new Properties();
		archivoPropiedades.load(new FileReader("src/main/java/restricciones.properties"));
		System.out.println(archivoPropiedades.getProperty("aireacondicionado3500.coeficiente"));
		double doble = Double.parseDouble(archivoPropiedades.getProperty( "aireacondicionado3500"+".coeficiente"));
		
		System.out.println(doble);
		
		System.out.println(archivoPropiedades.getProperty("tvtubo21p.coeficiente"));
		doble = Double.parseDouble(archivoPropiedades.getProperty( "tvtubo21p"+".coeficiente"));
		
		System.out.println(doble);
		
	}

}
