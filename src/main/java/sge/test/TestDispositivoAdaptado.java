package sge.test;
import static org.junit.Assert.*;

import org.junit.Test;

import sge.dispositivo.DispositivoEstandar;
import sge.dispositivo.EstandarToInteligenteAdapter;
import sge.dispositivo.FactoryDispositivos;

public class TestDispositivoAdaptado {
	
	@Test
	public void test01DispositivoEncendido(){
		
		FactoryDispositivos DF = new FactoryDispositivos();
		DispositivoEstandar DE = DF.lavarropasSemiAutomatico5kg();
		EstandarToInteligenteAdapter DA = new EstandarToInteligenteAdapter(DE.getIdDispositivo(), DE.getNombreDispositivo(), DE.getConsumoKwH(), "A");

		assertEquals(DA.estadoDelDispositivo(),"ENCENDIDO");
		
		
	}

}
