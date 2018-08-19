package sge.test;
import static org.junit.Assert.*;

import org.junit.Test;

import sge.dispositivo.*;
import sge.estados.Encendido;

public class DispositivosInteligentesTest {
	
	@Test
	public void test01DispositivoEncendido(){
		
		//DispositivoInteligente Heladera = new DispositivoInteligente(1, "Heladera Patrick", 150.2, 1, 0, new Encendido(), 1, null, null);
		
		DispositivoEstandar unaHeladera = new DispositivoEstandar();
		
		EstandarToInteligenteAdapter heladeraAdaptada = new EstandarToInteligenteAdapter(unaHeladera);
		
		heladeraAdaptada.setEstado(new Encendido()); 
		/* utilizamos un estado heredado de dispositivo inteligente
		 * con esto probamos que se realizo la transformación 
		 */
		

		assertEquals(heladeraAdaptada.estadoDelDispositivo(),"El dispositivo se encuentra encendido");
		
		
	}

}
