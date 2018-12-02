package Entrega3;

import java.text.ParseException;
import java.time.LocalDateTime;

import org.junit.Test;

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
		DispositivoInteligente dispositivo = fabricaDeDispositivos.aireAcondicionado2200();
		DispositivoEstandar 	d1 = fabricaDeDispositivos.lavarropasSemiAutomatico5kg();
		DispositivoInteligente 	d2 = fabricaDeDispositivos.lamparaAlogena100w();
		DispositivoInteligente 	d3 = fabricaDeDispositivos.ventiladorDeTecho();
		DispositivoInteligente 	d4 = fabricaDeDispositivos.tvLED24();
		DispositivoInteligente 	d5 = fabricaDeDispositivos.heladera();
		DispositivoInteligente 	d6 = fabricaDeDispositivos.lamparaAlogena11w();
		DispositivoEstandar 	d7 = fabricaDeDispositivos.ventiladorDePie();


		dbhelper.cargarEstadosFromJson(PATH_JSON_ESTADOS);
		Cliente unCliente = new Cliente("jey", "123456", "Jael", "Duran", "Av. Rivadavia 6000", LocalDateTime.now(), "DNI", 98745632, 45459595, "R1");
		unCliente.agregarDispositivo(d1);
		unCliente.agregarDispositivo(d2);
		unCliente.agregarDispositivo(d3);
		unCliente.agregarDispositivo(d4);
		unCliente.agregarDispositivo(d5);
		unCliente.agregarDispositivo(d6);
		unCliente.agregarDispositivo(d7);
		
		dbhelper.persistirCliente(unCliente);

		System.out.println(dispositivo.getEstado().getDescripcion());
		dispositivo.setEstado("Apagado");
		System.out.println(dispositivo.getEstado().getDescripcion());
		dbhelper.modificar(dispositivo);
		
	}
	
}