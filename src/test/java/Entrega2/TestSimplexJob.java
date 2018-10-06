package Entrega2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.quartz.JobExecutionException;
import Dispositivo.Dispositivo;
import Dispositivo.DispositivoFactory;
import Simplex.SimplexJob;
import Usuario.Cliente;

public class TestSimplexJob {

	@Test
	public void test() throws JobExecutionException, FileNotFoundException, IOException {
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
		
		SimplexJob unJobSimplex = new SimplexJob(unCliente);
		
		unJobSimplex.ejecutarPeticion();
		
	}

}
