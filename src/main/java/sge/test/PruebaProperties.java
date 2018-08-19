package sge.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import sge.dispositivo.Dispositivo;
import sge.dispositivo.DispositivoInteligente;
import sge.procEjecSimplex.ProcesoEjecucionSimplex;
import sge.usuario.Cliente;

public class PruebaProperties {

	@Test
	public void test() throws FileNotFoundException, IOException {
		
		Properties archivoPropiedades = new Properties();
		archivoPropiedades.load(new FileReader("src/main/java/sge/properties/restricciones.properties"));
		System.out.println(archivoPropiedades.getProperty("aireacondicionado3500.coeficiente"));
		double doble = Double.parseDouble(archivoPropiedades.getProperty( "aireacondicionado3500"+".coeficiente"));
		
		System.out.println(doble);
		
		System.out.println(archivoPropiedades.getProperty("tvtubo21p.coeficiente"));
		doble = Double.parseDouble(archivoPropiedades.getProperty( "tvtubo21p"+".coeficiente"));
		
		System.out.println(doble);
		
		DispositivoInteligente d = new DispositivoInteligente();
		
		d.setPropiedad("lamparaH100w");
				
		System.out.println(d.obtenerCoeficiente());
		
		Cliente unCliente = new Cliente();
		
		List<Dispositivo> listaDispositivos = new ArrayList<Dispositivo>();
		
		DispositivoInteligente tv = new DispositivoInteligente();
		tv.setPropiedad("tvLCD40p");
		
		DispositivoInteligente lavarropa = new DispositivoInteligente();
		lavarropa.setPropiedad("lavarropasCalentamientoAgua");
		
		tv.setConsumoKwH(500);
		lavarropa.setConsumoKwH(800);
		
		listaDispositivos.add(tv);
		listaDispositivos.add(lavarropa);
		
		
		unCliente.setDispositivos(listaDispositivos);
		
		ProcesoEjecucionSimplex ejecucionDelSimplexInstance = new ProcesoEjecucionSimplex(5, unCliente);
		
		
		ejecucionDelSimplexInstance.ejecutarPorTiempo(10);
		ejecucionDelSimplexInstance.ejecutarPeticion();
		
		
		
	}

}
