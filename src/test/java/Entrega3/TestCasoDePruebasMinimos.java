package Entrega3;

import java.time.LocalDateTime;

import org.junit.Test;

import Helper.EntityManagerHelper;
import Usuario.Cliente;

public class TestCasoDePruebasMinimos {

	@Test
	public void casoPrueba1(){
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();
		
		Cliente alejandro = new Cliente("Alekin", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", LocalDateTime.now(), "DNI", 38993333, 1551515555, "R1");
		dbhelper.persistirCliente(alejandro);
		//recuperar Cliente e imprimir
		alejandro.setLatitud(20.59);
		alejandro.setLongitud(14.59);
		dbhelper.modificar(alejandro);
		//recuperar Cliente e imprimir
		
	}
	
}