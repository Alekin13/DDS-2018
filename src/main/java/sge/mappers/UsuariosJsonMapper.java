package sge.mappers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import sge.modelos.Categoria;
import sge.usuario.Administrador;
import sge.usuario.Cliente;

/**
 * 
 * @author Alejandro
 *
 */
public class UsuariosJsonMapper {

	public UsuariosJsonMapper() {

	}

	/**
	 * El metodo se encarga de extraer la lista de clientes desde un archivo json
	 * 
	 */
	public List<Cliente> extraerClientesJson(String nombreJsonArch) throws IOException {
		// Lee archivo json
		byte[] jsonData = Files.readAllBytes(Paths.get(nombreJsonArch));
		
		//System.out.println(Paths.get(nombreJsonArch));

		ObjectMapper objectMapper = new ObjectMapper();

		// Obtiene Clientes
		List<Cliente> clientes = objectMapper.readValue(jsonData, new TypeReference<List<Cliente>>() {
		});

		// Devuelve la lista de objetos leídos
		return clientes;
	}

	public List<Administrador> extraerAdministradoresJson(String pathJsonAdministradores) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Categoria> extraerCategoriasJson(String pathJsonCategorias) {
		// TODO Auto-generated method stub
		return null;
	}
}