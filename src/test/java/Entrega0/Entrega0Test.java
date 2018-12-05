package Entrega0;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoInteligente;
import Usuario.Administrador;
import Usuario.Cliente;
import java.util.Date;

public class Entrega0Test {
	private Cliente cliente;

	@Before
	public void inicio() {
		String nombreUsuario = "JuanPerez";
		String password = "asd123";
		String nombre = "Juan";
		String apellido = "Perez";
		int numeroDocumento = 36123894;
		int telefonoContacto = 55555555;
		String domicilio = "Av. Rivadavia 1111, CABA, Buenos Aires";
		String categoria = "R1";
		
		this.cliente = new Cliente(nombreUsuario, password, nombre, apellido, domicilio, "", null, numeroDocumento, telefonoContacto, categoria);

		DispositivoFactory maestro = new DispositivoFactory();
		DispositivoInteligente heladera = maestro.heladeraFreezer();
		DispositivoInteligente tele = maestro.tvLED24();
		DispositivoEstandar lavarropas = maestro.lavarropas5kgCalendadorDeAgua();
		DispositivoInteligente aireAcondicionado = maestro.aireAcondicionado3500();
		this.cliente.agregarDispositivo(tele);
		this.cliente.agregarDispositivo(heladera);
		this.cliente.agregarDispositivo(lavarropas);
		this.cliente.agregarDispositivo(aireAcondicionado);

	}

	@Test
	public void clienteConUnDispositivoEncendido() {
		Assert.assertEquals(3, this.cliente.cantidadDispositivosEncencidos(this.cliente.getDispositivos()));
	}

	@Test
	public void clienteConUnDispositivoApagdo() {
		Assert.assertEquals(0, this.cliente.cantidadDispositivosApagados(this.cliente.getDispositivos()));
	}

	@Test
	public void clienteConAlgunDispositivoEncendido() {
		Assert.assertTrue(this.cliente.hayDispositivosEncendidos(this.cliente.getDispositivos()));
	}

	@Test
	public void clienteConCuatroDispositivosEnTotal() {
		Assert.assertEquals(4, this.cliente.cantidadTotalDispositivos());
	}

}
