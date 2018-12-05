package Entrega2;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoInteligente;
import Usuario.Cliente;
import Zona.Transformador;
import Zona.Zona;


public class TestZona {

	@Test
	public void mostrarListaDeTransformadores() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		
		Cliente alejandro = new Cliente();
		DispositivoFactory factory = new DispositivoFactory();
		
		DispositivoInteligente tvLed40 = factory.tvLED40();
		dispositivos.add(tvLed40);
		DispositivoInteligente lamparaAlogena11w = factory.lamparaAlogena11w();
		dispositivos.add(lamparaAlogena11w);
		DispositivoEstandar lavarropasSemiAutomatico5kg = factory.lavarropasSemiAutomatico5kg();
		dispositivos.add(lavarropasSemiAutomatico5kg);
		DispositivoEstandar pcDeEscritorio = factory.pcDeEscritorio();
		dispositivos.add(pcDeEscritorio);

		alejandro.setDispositivos(dispositivos);
		
		List<Transformador> transformadores = new ArrayList<Transformador>();
		Transformador transformadorA = new Transformador();
		Transformador transformadorB = new Transformador();
		Transformador transformadorC = new Transformador();
		double resultadoObtenido = 0;
		Zona unaZona = new Zona();
		
		transformadorA.setConsumo(2000.0);
		transformadorB.setConsumo(10000.0);
		transformadorC.setConsumo(3000.0);
		
		transformadores.add(transformadorA);
		transformadores.add(transformadorB);
		transformadores.add(transformadorC);
		
		
		unaZona.setTransformadores(transformadores);
		unaZona.setClientes(clientes);
		
		resultadoObtenido = unaZona.getConsumoTotalDeLaZona();
		
		assertEquals(15000.0, resultadoObtenido, 0.1);
		
		
	}
	
	@Test
	public void mostrarCoordenadas() {
		// Aca vamos a setear las coordenadas de la UTN campus 
		// para corroborar que los datos lestan ok
		
		Zona zonaUTN = new Zona();
		zonaUTN.setLatitud(-34.59887);
		zonaUTN.setLongitud(-58.42015);
		
		zonaUTN.getLongitud();
		
		assertEquals(-34.59887, zonaUTN.getLatitud(), 0.1);
		assertEquals(-58.42015, zonaUTN.getLongitud(), 0.1);
		
		
	}

}
