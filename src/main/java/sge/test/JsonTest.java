package main.java.sge.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import main.java.sge.modelos.Categoria;
import main.java.sge.modelos.Cliente;
import main.java.sge.modelos.Dispositivo;
import main.java.sge.mappers.UsuariosJsonMapper;

public class JsonTest {
	
	Cliente cliente1;
	Categoria categoria1 = new Categoria("R1", 18.76f, 0.644f);
	Calendar fechaCliente1 = new GregorianCalendar();
	List<Dispositivo> dispositivos1 = new ArrayList<Dispositivo>();

	Cliente cliente2;
	Categoria categoria2 = new Categoria("R2", 35.32f, 0.644f);
	Calendar fechaCliente2 = new GregorianCalendar();
	List<Dispositivo> dispositivos2 = new ArrayList<Dispositivo>();

	/**
	 * Se crean todas las entidades que se deberan crear en 
	 * memoria luego de parsear el archivo json. 
	 * @throws ParseException
	 */
	
	public void crearDatosDePrueba() throws Exception{
		
		
		fechaCliente1.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("22/04/2018"));
		dispositivos1.add(new Dispositivo("PS4 Sony Pro", 200.00f, true, "Consola"));
		cliente1 = new Cliente("001_AlejandroMattioli", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", fechaCliente1, 
				"DNI", new Integer(38993333), new Integer(1551515555), categoria1, dispositivos1, 200.00f);
		
		fechaCliente2.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("22/04/2018"));
		dispositivos2.add(new Dispositivo("Planchita Gama CP9", 40.00f, true, "Plancha Pelo"));
		cliente2 = new Cliente("002_CamilaSerra", "123456", "Camila", "Serra", "Olleros 1500", fechaCliente2, 
				"DNI", new Integer(38993332), new Integer(1545352313), categoria2, dispositivos2, 40.00f);
	
	}

	/**
	 * Se crean todas las entidades que se deberian crear en 
	 * memoria luego de parsear el archivo json. 
	 * @throws Exception 
	 * @throws ParseException
	 */
	
	@Test
	public void test01CargaObjetosJson() throws Exception {
		
		UsuariosJsonMapper mapper = new UsuariosJsonMapper();
		//TODO: Realizar test donde se obtengan los objetos del archivo json
		//y se los compare con los objetos que ya estan creados 
		
		// Se obtiene lista de clientes mapeados desde archivo json
		List<Cliente> clientesJson  = mapper.extraerClientesJson("src/main/java/sge/data/Clientes.json");
		
		crearDatosDePrueba();
		
		// Verifica que la lista de clientes no sea nula
		assertNotNull(clientesJson);
		System.out.println(cliente2.getDispositivos());
		
		// Verifica que se hayan mapeado bien las entidades obtenidas desde el archivo json
		assertEquals(cliente1.getNombre(), clientesJson.get(0).getNombre());
		assertEquals(cliente1.getApellido(), clientesJson.get(0).getApellido());
		assertEquals(cliente1.getTipoDoc(), clientesJson.get(0).getTipoDoc());
		assertEquals(cliente1.getNroDoc(), clientesJson.get(0).getNroDoc());
		assertEquals(cliente1.getDomicilio(), clientesJson.get(0).getDomicilio());
		assertEquals(cliente1.getCategoria().getCategoria(), clientesJson.get(0).getCategoria().getCategoria());
		assertEquals(cliente1.getDispositivos().get(0).getNombreDispositivo(), clientesJson.get(0).getDispositivos().get(0).getNombreDispositivo());

		
		assertEquals(cliente2.getNombre(), clientesJson.get(1).getNombre());
		assertEquals(cliente2.getApellido(), clientesJson.get(1).getApellido());
		assertEquals(cliente2.getTipoDoc(), clientesJson.get(1).getTipoDoc());
		assertEquals(cliente2.getNroDoc(), clientesJson.get(1).getNroDoc());
		assertEquals(cliente2.getDomicilio(), clientesJson.get(1).getDomicilio());
		assertEquals(cliente2.getCategoria().getCategoria(), clientesJson.get(1).getCategoria().getCategoria());
		assertEquals(cliente2.getDispositivos().get(0).getNombreDispositivo(), clientesJson.get(1).getDispositivos().get(0).getNombreDispositivo());

	}
}