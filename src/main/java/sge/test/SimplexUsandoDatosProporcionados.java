package sge.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.optim.PointValuePair;
import org.junit.Assert;
import org.junit.Test;

import sge.dispositivo.Dispositivo;
import sge.dispositivo.DispositivoEstandar;
import sge.dispositivo.DispositivoInteligente;
import sge.procEjecSimplex.ProcesoEjecucionSimplex;
import sge.simplexSolver.SimplexFacade;
import sge.usuario.Cliente;

public class SimplexUsandoDatosProporcionados {

	@Test
	public void test() throws FileNotFoundException, IOException {
		FactoryDispositivos factory = new FactoryDispositivos();
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Cliente unCliente = new Cliente();
		
		//List<Dispositivo> dispositivosSobrepasados = new ArrayList<Dispositivo>();
		
		DispositivoInteligente tvLed40 = new DispositivoInteligente();
		tvLed40.setPropiedad("tvLED40p");
		dispositivos.add(tvLed40);
				
		DispositivoInteligente lamparaAlogena11w = new DispositivoInteligente();
		lamparaAlogena11w.setPropiedad("lampara11w");
		dispositivos.add(lamparaAlogena11w);		
		
		DispositivoEstandar lavarropasSemiAutomatico5kg = new DispositivoEstandar();
		lavarropasSemiAutomatico5kg.setPropiedad("lavarropasSemiAutomatico");
		dispositivos.add(lavarropasSemiAutomatico5kg);
		
		
		DispositivoEstandar pcDeEscritorio = new DispositivoEstandar();
		pcDeEscritorio.setPropiedad("pcEscr");
		dispositivos.add(pcDeEscritorio);
		
		DispositivoInteligente aireAcondicionado2200 = new DispositivoInteligente();
		aireAcondicionado2200.setPropiedad("aireacondicionado2200");
		dispositivos.add(aireAcondicionado2200);
				
		DispositivoEstandar microondas = new DispositivoEstandar();
		microondas.setPropiedad("microondas");
		dispositivos.add(microondas);
		
		
		DispositivoEstandar plancha = new DispositivoEstandar();
		plancha.setPropiedad("plancha");
		dispositivos.add(plancha);
		
		DispositivoInteligente ventiladorDeTecho = new DispositivoInteligente();
		ventiladorDeTecho.setPropiedad("ventiladorDeTecho");
		dispositivos.add(ventiladorDeTecho);
		
		
		
		unCliente.setDispositivos(dispositivos);
		
		ProcesoEjecucionSimplex ejecucionDelSimplexInstance = new ProcesoEjecucionSimplex(unCliente);
		ejecucionDelSimplexInstance.ejecutarPeticion();

	}

}
