package Entrega1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Dispositivo.DispositivoAdaptador;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoFactory;

public class TestDispositivoAdaptado {
	
	@Test
	public void test01DispositivoEncendido(){
		
		DispositivoFactory DF = new DispositivoFactory();
		DispositivoEstandar DE = DF.lavarropasSemiAutomatico5kg();
		DispositivoAdaptador DA = new DispositivoAdaptador(DE);

		assertEquals(DA.estadoDelDispositivo(),"ENCENDIDO");
		
	}

}
