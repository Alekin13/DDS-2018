package sge.test;
import static org.junit.Assert.*;

import org.junit.Test;

import sge.actuador.CommandActuadores;
import sge.dispositivo.DispositivoInteligente;
import sge.estados.Encendido;
import sge.estados.Estado;
import sge.sensor.Sensor;

public class DispositivosInteligentesTest {
	
	@Test
	public void test01DispositivoEncendido(){
		
		DispositivoInteligente Heladera = new DispositivoInteligente(1, "Heladera Patrick", 150.2, "I", 1, 0, new Encendido(), 1, null, null);		

		assertEquals(Heladera.estadoDelDispositivo(),"El dispositivo se encuentra encendido");
		
		
	}

}
