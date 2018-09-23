package sge.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import sge.categoria.Categoria;
import sge.dispositivo.Dispositivo;
import sge.mappers.JsonHelper;
import sge.usuario.Administrador;
import sge.usuario.Cliente;

public class TestJson {
	
	private static final String PATH_JSON_CLIENTES = "src/main/java/sge/data/Clientes.json";
	private static final String PATH_JSON_ADMINISTRADORES = "src/main/java/sge/data/Administradores.json";
	private static final String PATH_JSON_CATEGORIAS = "src/main/java/sge/data/Categorias.json";
	
    @Test
    public void debeDevolverJSONEnUnObjeto() throws IOException, ParseException {
    	List<Cliente> clientes = new ArrayList<Cliente>();
    	clientes = JsonHelper.extraerClientesJson(PATH_JSON_CLIENTES);
        assertEquals("Lista de clientes",2, clientes.size());
    }
    
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
	 */
	
	public void crearDatosDePrueba() throws Exception{
		
		fechaCliente1.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("22/04/2018"));
		//dispositivos1.add(new DispositivoInteligente("PS4 Sony Pro", 200.00f, null, null, 0, true, 0, "Consola", null));
		cliente1 = new Cliente("001_AlejandroMattioli", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", fechaCliente1, 
				"DNI", new Integer(38993333), new Integer(1551515555), categoria1);
		
		fechaCliente2.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("22/04/2018"));
		//dispositivos2.add(new DispositivoInteligente("Planchita Gama CP9", 40.00f, null, null, 0, true, 0, "Plancha Pelo", null));
		cliente2 = new Cliente("002_CamilaSerra", "123456", "Camila", "Serra", "Olleros 1500", fechaCliente2, 
				"DNI", new Integer(38993332), new Integer(1545352313), categoria2);
	
	}

	/**
	 * Se crean todas las entidades que se deberian crear en 
	 * memoria luego de parsear el archivo json. 
	 */
	
	@Test
	public void test01CargaObjetosJson() throws Exception {
			
		// Se obtiene lista de clientes mapeados desde archivo json
		List<Cliente> clientesJson  = JsonHelper.extraerClientesJson(PATH_JSON_CLIENTES);
		
		//Crea los casos de prueba a comparar
		crearDatosDePrueba();
		
		// Verifica que la lista de clientes no sea nula
		assertNotNull(clientesJson);
		
		// Verifica que se hayan mapeado bien las entidades obtenidas desde el archivo json
		assertEquals(cliente1.getNombre(), clientesJson.get(0).getNombre());
		assertEquals(cliente1.getApellido(), clientesJson.get(0).getApellido());
		assertEquals(cliente1.getTipoDoc(), clientesJson.get(0).getTipoDoc());
		assertEquals(cliente1.getNroDoc(), clientesJson.get(0).getNroDoc());
		assertEquals(cliente1.getDomicilio(), clientesJson.get(0).getDomicilio());
		//assertEquals(cliente1.getCategoria().getCategoria(), clientesJson.get(0).getCategoria().getCategoria());
		//assertEquals(cliente1.getDispositivos().get(0).getNombreDispositivo(), clientesJson.get(0).getDispositivos().get(0).getNombreDispositivo());

		
		assertEquals(cliente2.getNombre(), clientesJson.get(1).getNombre());
		assertEquals(cliente2.getApellido(), clientesJson.get(1).getApellido());
		assertEquals(cliente2.getTipoDoc(), clientesJson.get(1).getTipoDoc());
		assertEquals(cliente2.getNroDoc(), clientesJson.get(1).getNroDoc());
		assertEquals(cliente2.getDomicilio(), clientesJson.get(1).getDomicilio());
		//assertEquals(cliente2.getCategoria().getCategoria(), clientesJson.get(1).getCategoria().getCategoria());
		//assertEquals(cliente2.getDispositivos().get(0).getNombreDispositivo(), clientesJson.get(1).getDispositivos().get(0).getNombreDispositivo());

	}
	
	public static void TestImprimirCarga() {
		
		int i, j;
		JsonHelper mapper = new JsonHelper();
		
		//Clientes
		List<Cliente> clientesJson;

		try {
			clientesJson = JsonHelper.extraerClientesJson(PATH_JSON_CLIENTES);
			
			for (i = 0; i < clientesJson.size(); i++) {
				System.out.println("Cliente " + (i + 1));
				System.out.println("Usuario: " + clientesJson.get(i).getUsuario());
				System.out.println("Password: " + clientesJson.get(i).getPassword());
				System.out.println("Nombre: " + clientesJson.get(i).getNombre());
				System.out.println("Apellido: " + clientesJson.get(i).getApellido());
				System.out.println("Domicilio: " + clientesJson.get(i).getDomicilio());
				System.out.println("Fecha de Alta: " + clientesJson.get(i).getFecAlta().get(Calendar.DAY_OF_MONTH)
						+ "/" + clientesJson.get(i).getFecAlta().get(Calendar.MONTH) + "/"
						+ clientesJson.get(i).getFecAlta().get(Calendar.YEAR));
				System.out.println(
						"Documento: " + clientesJson.get(i).getTipoDoc() + " " + clientesJson.get(i).getNroDoc());
				System.out.println("Telefono: " + clientesJson.get(i).getTelefono());
				System.out.println("Categoria: " + clientesJson.get(i).getCategoria().getCategoria());
				System.out.println("Dispositivos:");

				for (j = 0; j < clientesJson.get(i).getDispositivos().size(); j++) {
					System.out.println("   Dispositivo " + (j + 1));
					System.out.println("   Tipo: " + clientesJson.get(i).getDispositivos().get(j).getTipoDispositivo());
					System.out.println("   Nombre: " + clientesJson.get(i).getDispositivos().get(j).getNombreDispositivo());
					System.out.println("   Consumo: " + clientesJson.get(i).getDispositivos().get(j).getConsumoKwH());
					System.out.println("------------------------------");
				}
			
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	//Administradores
	List<Administrador> administradoresJson;

	try {
		administradoresJson = mapper.extraerAdministradoresJson(PATH_JSON_ADMINISTRADORES);

		System.out.println("Administradores:");
		System.out.println("");
		for (i = 0; i < administradoresJson.size(); i++) {
			System.out.println("ID: " + administradoresJson.get(i).getIdAdmin());
			System.out.println("Usuario: " + administradoresJson.get(i).getUsuario());
			System.out.println("Password: " + administradoresJson.get(i).getPassword());
			System.out.println("Nombre: " + administradoresJson.get(i).getNombre());
			System.out.println("Apellido: " + administradoresJson.get(i).getApellido());
			System.out.println("Domicilio: " + administradoresJson.get(i).getDomicilio());
			System.out.println(
					"Fecha de Alta: " + administradoresJson.get(i).getFecAlta().get(Calendar.DAY_OF_MONTH) + "/"
							+ administradoresJson.get(i).getFecAlta().get(Calendar.MONTH) + "/"
							+ administradoresJson.get(i).getFecAlta().get(Calendar.YEAR));
			System.out.println("");
		}
		System.out.println("");

	} catch (Exception e1) {
		System.out.println(e1.getMessage());
	}

	//Categorias
	List<Categoria> categoriasJson;

	try {
		categoriasJson = JsonHelper.extraerCategoriasJson(PATH_JSON_CATEGORIAS);
		System.out.println("Categorias:");
		System.out.println("");
		for (i = 0; i < categoriasJson.size(); i++) {
			System.out.println("Categoria: " + categoriasJson.get(i).getCategoria());
			System.out.println("Cargo fijo: " + categoriasJson.get(i).getCargoFijo());
			System.out.println("Cargo variable: " + categoriasJson.get(i).getCargoVariable());
			System.out.println("");
		}
	} catch (Exception e2) {
		System.out.println(e2.getMessage());
	}

	}

    @Test
    public void Impresion() throws IOException, ParseException {
    	
    	TestJson.TestImprimirCarga();
    }

}
