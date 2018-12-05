package Entrega5;

import java.text.ParseException;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoInteligente;
import Helper.EntityManagerHelper;
import Usuario.Administrador;
import Usuario.Cliente;

public class TestCargaEntregaFinal {

	public void CrearBase() throws ParseException{

		EntityManagerHelper dbhelper = new EntityManagerHelper();
		DispositivoFactory fabricaDeDispositivos = new DispositivoFactory();
		
		//Administradores
		Administrador admin1 = new Administrador("Faraona", "dino", "Martin", "Cirio", "Cabildo 500", "01/12/2018", 1);
		Administrador admin2 = new Administrador("Cono", "123456", "Guillermo", "Gonzalez", "Calle Falsa 123", "01/12/2018", 2);
		dbhelper.agregar(admin1);
		dbhelper.agregar(admin2);
		
		//Clientes
		Cliente unCliente1 = new Cliente("nicocufre", "123456", "Nico",   "Cufre", "Lorca 385", "01/01/2017", "DNI", 29760667, 45459595, "R1");
		Cliente unCliente2 = new Cliente("fetoabort",  "123456", "Jazmin", "Lopez", "Lorca 381","01/01/2017", "DNI", 37563623, 45459593, "R1");
		Cliente unCliente3 = new Cliente("belulun",   "123456", "Cara",   "Lexee", "Lorca 382", "01/01/2017", "DNI", 31760667, 45459592, "R1");
		Cliente unCliente4 = new Cliente("soyelcono", "123456", "Gonzalo","Guini", "Lorca 383", "01/01/2017", "DNI", 25760667, 45459591, "R1");
		Cliente unCliente5 = new Cliente("elcarolo",  "123456", "Pablo",  "Cesar", "Lorca 384", "01/01/2017", "DNI", 19760667, 45459590, "R1");
		
		
		DispositivoInteligente	d1 = fabricaDeDispositivos.aireAcondicionado2200();
		DispositivoInteligente 	d2 = fabricaDeDispositivos.lamparaAlogena40w();
		DispositivoEstandar    	d3 = fabricaDeDispositivos.lavarropas5kgCalendadorDeAgua();
		DispositivoEstandar    	d4 = fabricaDeDispositivos.lavarropasSemiAutomatico5kg();
		DispositivoInteligente 	d5 = fabricaDeDispositivos.lamparaAlogena100w();
		DispositivoInteligente 	d6 = fabricaDeDispositivos.ventiladorDeTecho();
		DispositivoInteligente 	d7 = fabricaDeDispositivos.tvLED24();
		DispositivoInteligente 	d8 = fabricaDeDispositivos.heladera();
		DispositivoInteligente 	d9 = fabricaDeDispositivos.lamparaAlogena11w();
		DispositivoEstandar 	d10 = fabricaDeDispositivos.ventiladorDePie();
		DispositivoInteligente 	d11 = fabricaDeDispositivos.aireAcondicionado2200();
		DispositivoInteligente 	d12 = fabricaDeDispositivos.lamparaAlogena40w();
		DispositivoEstandar 	d13 = fabricaDeDispositivos.lavarropas5kgCalendadorDeAgua();
		DispositivoEstandar 	d14 = fabricaDeDispositivos.lavarropasSemiAutomatico5kg();
		DispositivoInteligente 	d15 = fabricaDeDispositivos.lamparaAlogena100w();
		DispositivoInteligente 	d16 = fabricaDeDispositivos.ventiladorDeTecho();
		DispositivoInteligente 	d17 = fabricaDeDispositivos.tvLED24();
		DispositivoInteligente 	d8A = fabricaDeDispositivos.heladera();
		DispositivoInteligente 	d9A = fabricaDeDispositivos.lamparaAlogena11w();
		DispositivoEstandar 	d10A = fabricaDeDispositivos.ventiladorDePie();
		/*
		dbhelper.cargarEstadosFromJson(PATH_JSON_ESTADOS);
		
		unCliente.addDispositivo(d1A);
		unCliente.addDispositivo(d2A);
		unCliente.addDispositivo(d3A);
		unCliente.addDispositivo(d4A);
		unCliente.addDispositivo(d5A);
		unCliente.addDispositivo(d6A);
		unCliente.addDispositivo(d7A);
		unCliente.addDispositivo(d8A);
		unCliente.addDispositivo(d9A);
		unCliente.addDispositivo(d10A);
		
		dbhelper.persistirCliente(unCliente);

		d9A.setCambioEstado("A");
		dbhelper.modificar(d9A);
		d5A.setCambioEstado("A");
		dbhelper.modificar(d5A);
		d3A.setCambioEstado("M");
		dbhelper.modificar(d3A);
		d3A.setCambioEstado("E");
		dbhelper.modificar(d3A);
		
		
		Cliente unCliente2 = new Cliente("Cecilia", "123456", "Cecilia ", "Molina", "Riglos 385", LocalDateTime.now(), "DNI", 28763223, 45459595, "R2");
		unCliente2.addDispositivo(d1B);
		unCliente2.addDispositivo(d2B);
		unCliente2.addDispositivo(d3B);
		unCliente2.addDispositivo(d4B);
		unCliente2.addDispositivo(d5B);
		unCliente2.addDispositivo(d6B);
		unCliente2.addDispositivo(d7B);
		unCliente2.addDispositivo(d8B);
		unCliente2.addDispositivo(d9B);
		unCliente2.addDispositivo(d10B);
		
		dbhelper.agregar(unCliente2);

		*/
		
	}
	
}
