package sge.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.quartz.JobExecutionException;

import sge.dispositivo.Dispositivo;
import sge.dispositivo.DispositivoEstandar;
import sge.dispositivo.DispositivoInteligente;
import sge.simplexSolver.SimplexJob;
import sge.usuario.Cliente;

public class TestSimplexJob {

	@Test
	public void test() throws JobExecutionException, FileNotFoundException, IOException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Cliente unCliente = new Cliente();
		
		//List<Dispositivo> dispositivosSobrepasados = new ArrayList<Dispositivo>();

	
		DispositivoInteligente aireAcondicionado2200 = new DispositivoInteligente();
		aireAcondicionado2200.setPropiedad("aireacondicionado2200");
		dispositivos.add(aireAcondicionado2200);		

		DispositivoInteligente lamparaAlogena11w = new DispositivoInteligente();
		lamparaAlogena11w.setPropiedad("lampara11w");
		dispositivos.add(lamparaAlogena11w);
		
		DispositivoInteligente tvLed40 = new DispositivoInteligente();
		tvLed40.setPropiedad("tvLED40p");
		dispositivos.add(tvLed40);
				
		DispositivoEstandar pcDeEscritorio = new DispositivoEstandar();
		pcDeEscritorio.setPropiedad("pcEscr");
		dispositivos.add(pcDeEscritorio);
				
		DispositivoEstandar lavarropasSemiAutomatico5kg = new DispositivoEstandar();
		lavarropasSemiAutomatico5kg.setPropiedad("lavarropasSemiAutomatico");
		dispositivos.add(lavarropasSemiAutomatico5kg);
		
		DispositivoEstandar microondas = new DispositivoEstandar();
		microondas.setPropiedad("microondas");
		dispositivos.add(microondas);
		
		
		DispositivoEstandar plancha = new DispositivoEstandar();
		plancha.setPropiedad("plancha");
		dispositivos.add(plancha);
		
		DispositivoInteligente ventiladorDeTecho = new DispositivoInteligente();
		ventiladorDeTecho.setPropiedad("ventiladorDeTecho");
		dispositivos.add(ventiladorDeTecho);
		
		DispositivoEstandar heladera = new DispositivoEstandar();
		heladera.setPropiedad("heladeraFreezer");
		dispositivos.add(heladera);
			
		unCliente.setDispositivos(dispositivos);
		
		SimplexJob unJobSimplex = new SimplexJob(1,unCliente);
		
		unJobSimplex.ejecutarPeticion();

		
	}

}
