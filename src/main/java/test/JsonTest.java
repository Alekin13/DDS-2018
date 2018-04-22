package main.java.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.java.sge.mappers.UsuariosJsonMapper;
import main.java.sge.models.Cliente;
import main.java.sge.models.Dispositivo;

public class JsonTest {

	Cliente cliente1;
	Cliente cliente2;

	// Se crea lista de dispositivos para el primer cliente
	List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		

	/**
	 * Se crean todas las entidades que se deberían crear en 
	 * memoria luego de parsear el archivo json. 
	 * @throws ParseException
	 */
	
	@Test
	public void test01CargaObjetosJson() throws IOException {
		
		UsuariosJsonMapper mapper = new UsuariosJsonMapper();
		//TODO: Realizar test donde se obtengan los objetos del archivo json
		//y se los compare con los objetos que ya estan creados 
		
		// Se obtiene lista de clientes mapeados desde archivo json
		List<Cliente> clientesJson  = mapper.extraerClientesJson("src/main/java/sge/data/Clientes.json");

		// Verifica que la lista de clientes no sea nula
		assertNotNull(clientesJson);
		System.out.println(clientesJson.get(0).getApellido());
		
		// Verifica que se hayan mapeado bien las entidades obtenidas desde el archivo json
		//assertEquals(cliente1, clientesJson.get(0));
		// System.out.println("Prueba");
		//assertEquals(cliente2, clientesJson.get(1));

	}
}