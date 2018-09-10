package sge.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sge.actuador.ACT_CambiarTemperatura;
import sge.actuador.CommandActuadores;
import sge.dispositivo.DispositivoInteligente;
import sge.regla.*;


public class TestRegla {

	@Test
	public void TestConstruccionRegla() {
		
		DispositivoInteligente unDispositivo = new DispositivoInteligente();
		
		CondicionTemperaturaAlta unaCondicionTempAlta = new CondicionTemperaturaAlta();
 		List <Condicion> condiciones = new ArrayList<Condicion>();
 		
 		ACT_CambiarTemperatura unCambioDeTemp = new ACT_CambiarTemperatura();
 		List<CommandActuadores> acciones = new ArrayList<CommandActuadores>();
 		
 		unDispositivo.setValorInherente(40);
 		
 		
 		condiciones.add(unaCondicionTempAlta);
 		acciones.add(unCambioDeTemp);
 		
 		//Regla unaRegla = new Regla(condiciones, acciones, unDispositivo);
 		
 		assertEquals(unaCondicionTempAlta.cumpleCondicion(unDispositivo),true);
 		
 		
	}

}