package Entrega4;

import java.text.ParseException;
import java.time.LocalDateTime;

import org.junit.Test;

import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoInteligente;
import Helper.EntityManagerHelper;
import SensorActuador.ACT_Apagate;
import SensorActuador.ACT_CambiarTemperatura;
import SensorActuador.CondicionTemperaturaAlta;
import SensorActuador.Regla;
import SensorActuador.SensorTemperatura;
import Usuario.Cliente;

public class testEntrega4 {

	private static final String PATH_JSON_ESTADOS = "src/test/resources/Data/Estados.json";

	public void casoPrueba2() throws ParseException{

	EntityManagerHelper dbhelper = new EntityManagerHelper();
	DispositivoFactory fabricaDeDispositivos = new DispositivoFactory();
	DispositivoInteligente d1A = fabricaDeDispositivos.aireAcondicionado2200();
	DispositivoInteligente d2A = fabricaDeDispositivos.lamparaAlogena40w();
	DispositivoEstandar d3A = fabricaDeDispositivos.lavarropas5kgCalendadorDeAgua();
	DispositivoEstandar d4A = fabricaDeDispositivos.lavarropasSemiAutomatico5kg();
	DispositivoInteligente d5A = fabricaDeDispositivos.lamparaAlogena100w();
	DispositivoInteligente d6A = fabricaDeDispositivos.ventiladorDeTecho();
	DispositivoInteligente d7A = fabricaDeDispositivos.tvLED24();
	DispositivoInteligente d8A = fabricaDeDispositivos.heladera();
	DispositivoInteligente d9A = fabricaDeDispositivos.lamparaAlogena11w();
	DispositivoEstandar d10A = fabricaDeDispositivos.ventiladorDePie();
	
	dbhelper.cargarEstadosFromJson(PATH_JSON_ESTADOS);
	
	Cliente unCliente = new Cliente("Nicolas", "123456", "Nico ", "Cufre", "Lorca 385", LocalDateTime.now(), "DNI", 29760667, 45459595, "R1");
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
	
	DispositivoInteligente d1B = fabricaDeDispositivos.aireAcondicionado2200();
	DispositivoInteligente d2B = fabricaDeDispositivos.lamparaAlogena40w();
	DispositivoEstandar d3B = fabricaDeDispositivos.lavarropas5kgCalendadorDeAgua();
	DispositivoEstandar d4B = fabricaDeDispositivos.lavarropasSemiAutomatico5kg();
	DispositivoInteligente d5B = fabricaDeDispositivos.lamparaAlogena100w();
	DispositivoInteligente d6B = fabricaDeDispositivos.ventiladorDeTecho();
	DispositivoInteligente d7B = fabricaDeDispositivos.tvLED24();
	DispositivoInteligente d8B = fabricaDeDispositivos.heladera();
	DispositivoInteligente d9B = fabricaDeDispositivos.lamparaAlogena11w();
	DispositivoEstandar d10B = fabricaDeDispositivos.ventiladorDePie();
	
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

	d9B.setCambioEstado("A");
	dbhelper.modificar(d9B);
	d5B.setCambioEstado("A");
	dbhelper.modificar(d5B);
	d3B.setCambioEstado("M");
	dbhelper.modificar(d1B);
	d3B.setCambioEstado("E");
	dbhelper.modificar(d3B);

	ACT_Apagate actuador2 = new ACT_Apagate();
	dbhelper.agregar(actuador2);
	ACT_CambiarTemperatura actuador = new ACT_CambiarTemperatura();
	dbhelper.agregar(actuador);
	CondicionTemperaturaAlta condicion = new CondicionTemperaturaAlta();
	dbhelper.agregar(condicion);
	Regla regla = new Regla(condicion, actuador, d1B);
	dbhelper.agregar(regla);
	SensorTemperatura sensor = new SensorTemperatura(0, "C");
	sensor.addObserver(regla);
	dbhelper.agregar(sensor);
	d1B.setValorInherente(40);
	d1B.setSensor(sensor);
	dbhelper.modificar(d1B);
	}
	
	@Test
	public void test() throws ParseException{
	
		this.casoPrueba2();
		
	}
}