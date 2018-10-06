package Entrega2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.optim.PointValuePair;
import org.junit.Assert;
import org.junit.Test;
import Dispositivo.Dispositivo;
import Dispositivo.DispositivoFactory;
import Simplex.SimplexJob;
import Usuario.Cliente;

public class TestSimplexUsandoDatosProporcionados {

	@Test
	public void test() throws FileNotFoundException, IOException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Cliente unCliente = new Cliente();
		
		DispositivoFactory factory = new DispositivoFactory();
		dispositivos.add(factory.aireAcondicionado2200());		
		dispositivos.add(factory.lamparaAlogena11w());
		dispositivos.add(factory.tvLED40());
		dispositivos.add(factory.pcDeEscritorio());
		dispositivos.add(factory.lavarropasSemiAutomatico5kg());
		dispositivos.add(factory.microondas());
		dispositivos.add(factory.plancha());
		dispositivos.add(factory.ventiladorDeTecho());
		dispositivos.add(factory.heladera());			
		unCliente.setDispositivos(dispositivos);
		
		SimplexJob ejecucionDelSimplexInstance = new SimplexJob(unCliente);
		
		PointValuePair solucion = ejecucionDelSimplexInstance.ejecutarPeticion();
		
		Assert.assertEquals(1875, solucion.getValue(), 0.01); 		
		Assert.assertEquals(360, solucion.getPoint()[0], 0.01); 	
		Assert.assertEquals(360, solucion.getPoint()[1], 0.01); 		
		Assert.assertEquals(360, solucion.getPoint()[2], 0.01); 		
		Assert.assertEquals(360, solucion.getPoint()[3], 0.01); 		
		Assert.assertEquals(30, solucion.getPoint()[4], 0.01);		
		Assert.assertEquals(15, solucion.getPoint()[5], 0.01); 	
		Assert.assertEquals(30, solucion.getPoint()[6], 0.01); 	
		Assert.assertEquals(360, solucion.getPoint()[7], 0.01); 		

	}

}
