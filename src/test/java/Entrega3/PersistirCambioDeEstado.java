package Entrega3;

import java.text.ParseException;
import java.time.LocalDateTime;

import org.junit.Test;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoInteligente;
import Helper.EntityManagerHelper;
import Usuario.Cliente;

public class PersistirCambioDeEstado {

	private static final String PATH_JSON_ESTADOS = "src/test/resources/Data/Estados.json";
	
	@Test
	public void casoPrueba1() throws ParseException{
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();
		DispositivoFactory fabricaDeDispositivos = new DispositivoFactory();
		
		dbhelper.cargarEstadosFromJson(PATH_JSON_ESTADOS);
		//Cliente otroCliente = new Cliente("Alekin", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", LocalDateTime.now(), "DNI", 38993333, 1551515555, "R1");
		Cliente unCliente = new Cliente("jey", "123456", "Jael", "Duran", "Av. Rivadavia 6000", LocalDateTime.now(), "DNI", 98745632, 45459595, "R1");
		unCliente.addDispositivo(fabricaDeDispositivos.aireAcondicionado2200());
		dbhelper.persistirCliente(unCliente);
		
		
		
		//DispositivoInteligente disp = fabricaDeDispositivos.aireAcondicionado2200();
		
		//disp.setCliente(unCliente.getId());
		
		//dbhelper.modificar(disp);
		
		
		
		//dbhelper.persistirDispositivo(unDispositivo);
		
//		unCliente.addDispositivo(fabricaDeDispositivos.pcDeEscritorio());
////		dbhelper.modificar(unCliente);
		
		//dbhelper.cargarEstadosFromJson("src/test/resources/Data/Estados.json");
		
		
		//
		
		//otroCliente.addDispositivo(fabricaDeDispositivos.microondas());
		
		
		
		
		
		
		//
		
		//dbhelper.persistirCliente(otroCliente);
		
		

		
		
	//	System.out.println(unDispositivo.getEstado().getDescripcion());
		
		//unDispositivo.setEstado("Apagado");
		
//		System.out.println(unDispositivo.getEstado().getDescripcion());

		
		
	}
	
}