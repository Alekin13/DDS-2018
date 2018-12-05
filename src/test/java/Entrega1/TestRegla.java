package Entrega1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Dispositivo.DispositivoInteligente;
import SensorActuador.ACT_CambiarTemperatura;
import SensorActuador.CondicionTemperaturaAlta;
import SensorActuador.Regla;
import SensorActuador.SensorTemperatura;


public class TestRegla {

	@Test
	public void TestConstruccionRegla() {
		
		DispositivoInteligente dispositivo = new DispositivoInteligente("Aire Acondicionado", "3500 frigorias", "I", "No", 1.613, 90, 360, "A");
		ACT_CambiarTemperatura actuador = new ACT_CambiarTemperatura();
		CondicionTemperaturaAlta condicion = new CondicionTemperaturaAlta();
		Regla regla = new Regla(condicion, actuador, dispositivo);
		SensorTemperatura sensor = new SensorTemperatura(0, "C");
		sensor.addObserver(regla);
		dispositivo.setValorInherente(40);
		dispositivo.setSensor(sensor);
		
		dispositivo.getSensor().tomarMedicionDispositivo(dispositivo);
		dispositivo.setActuador(actuador);

		//En que momento le mando 20.11094077788433 ?
		System.out.println("Dispositivo: " + dispositivo.getValorInherente());
		assertEquals(regla.cumpleCondicion(),true);
 		
 		
	}

}
