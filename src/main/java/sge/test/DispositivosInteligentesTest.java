package sge.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sge.dispositivo.DispositivoInteligente;
import sge.modelos.estados.Encendido;
import sge.modelos.estados.Estado;
import sge.modelos.sensor.Sensor;

public class DispositivosInteligentesTest {
	
	@Test
	public void test01DispositivoEncendido(){
		
		DispositivoInteligente Heladera = new DispositivoInteligente("Heladera Patrick", 150.2, new Encendido(),
				null, 190, false, 190.2, "I", "Patrick");
		
		
		assertEquals(Heladera.estadoDelDispositivo(),"El dispositivo se encuentra encendido");
		
		
	}

}
