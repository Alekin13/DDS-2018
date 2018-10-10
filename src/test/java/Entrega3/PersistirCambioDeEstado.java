package Entrega3;

import java.text.ParseException;
import java.time.LocalDateTime;

import org.junit.Test;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstado;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoFactory;
import Helper.EntityManagerHelper;
import Usuario.Cliente;

public class PersistirCambioDeEstado {

	@Test
	public void casoPrueba1() throws ParseException{
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();

		DispositivoFactory fabricaDeDispositivos = new DispositivoFactory();
		DispositivoEstandar unDispositivo = new DispositivoEstandar(); 
		Cliente unCliente = new Cliente("jey", "123456", "Jael", "Duran", "Av. Rivadavia 6000", LocalDateTime.now(), "DNI", 98745632, 45459595, "R1");
		dbhelper.persistirCliente(unCliente);
		
		unCliente.addDispositivo(fabricaDeDispositivos.aireAcondicionado2200());
		unCliente.addDispositivo(fabricaDeDispositivos.pcDeEscritorio());
		dbhelper.modificar(unCliente);
		
		//dbhelper.cargarEstadosFromJson("src/test/resources/Data/Estados.json");
		
		
		//Cliente otroCliente = new Cliente("Alekin", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", LocalDateTime.now(), "DNI", 38993333, 1551515555, "R1");
		
		//otroCliente.addDispositivo(fabricaDeDispositivos.microondas());
		
		
		
		
		
		
		//dbhelper.persistirDispositivo(unDispositivo);
		
		//dbhelper.persistirCliente(otroCliente);
		
		

		
		
	//	System.out.println(unDispositivo.getEstado().getDescripcion());
		
		//unDispositivo.setEstado("Apagado");
		
//		System.out.println(unDispositivo.getEstado().getDescripcion());

		
		
	}
	
}