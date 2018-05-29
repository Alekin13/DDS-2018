package main.java.sge.view;

import java.util.Calendar;
import java.util.List;
import main.java.sge.modelos.Cliente;
import main.java.sge.mappers.UsuariosJsonMapper;

/**
 * Clase creada solo para mostrar un ejemplo de funcionamiento por consola.
 * @author Alejandro-PC
 *
 */

public class Presentacion {
	
	private static final String PATH_JSON_CLIENTES = "/src/main/java/sge/data/Clientes.json";
	//private static final String PATH_JSON_ADMINISTRADORES = "src/main/java/json/Administradores.json";
	//private static final String PATH_JSON_CATEGORIAS = "src/main/java/json/Categorias.json";
	
	public static void mostrarConsola() {
	
		int i, j;
		UsuariosJsonMapper mapper = new UsuariosJsonMapper();
		
		//Clientes
		List<Cliente> clientesJson;

		try {
			clientesJson = mapper.extraerClientesJson(PATH_JSON_CLIENTES);
			
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
					System.out.println("   Tipo: " + clientesJson.get(i).getDispositivos().get(j).getTipo());
					System.out.println("   Nombre: " + clientesJson.get(i).getDispositivos().get(j).getNombreDispositivo());
					System.out.println("   Consumo: " + clientesJson.get(i).getDispositivos().get(j).getConsumoKwh());
					System.out.println("------------------------------");
				}
			
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//System.out.println("");
	/**	
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
		categoriasJson = mapper.extraerCategoriasJson(PATH_JSON_CATEGORIAS);
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

*/
	}


}
