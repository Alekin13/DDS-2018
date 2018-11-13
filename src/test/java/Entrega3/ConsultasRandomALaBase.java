package Entrega3;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoInteligente;
import Helper.EntityManagerHelper;
import Usuario.Cliente;
import Usuario.Usuario;

public class ConsultasRandomALaBase {
	
	@Test
	public void casoPruebaConsulta(){

		EntityManagerHelper dbhelper = new EntityManagerHelper();
		

		DispositivoFactory fabricaDeDispositivos = new DispositivoFactory();
		DispositivoInteligente dispositivo = fabricaDeDispositivos.aireAcondicionado2200();
		
		Cliente unCliente = new Cliente("jey", "123456", "Jael", "Duran", "Av. Rivadavia 6000", LocalDateTime.now().toString(), "DNI", 98745632, 45459595, "R1");
		unCliente.addDispositivo(dispositivo);
		dbhelper.persistirCliente(unCliente);

		@SuppressWarnings("unchecked")
		
		
		Usuario user = dbhelper.buscar(Usuario.class, new ImmutablePair<>("usuario",unCliente.getUsuario()));
				
		System.out.println(user.getUsuario());

	}
	
}