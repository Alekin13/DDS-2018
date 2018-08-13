package sge.mappers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sge.categoria.Categoria;
import sge.transformador.Transformador;
import sge.usuario.Administrador;
import sge.usuario.Cliente;
import sge.zona.Zona;

public class JsonMapper {

	public JsonMapper() {

	}

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

	public List<Zona> extraerZonasJson(String nombreJsonArch) throws IOException {
		
		byte[] jsonData = Files.readAllBytes(Paths.get(nombreJsonArch));
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<Zona> zonas = objectMapper.readValue(jsonData, new TypeReference<List<Zona>>(){});
		
		return zonas;
	}

	public List<Transformador> extraerTransformadorJson(String nombreJsonArch) throws IOException {
		
		byte[] jsonData = Files.readAllBytes(Paths.get(nombreJsonArch));
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<Transformador> transformadores = objectMapper.readValue(jsonData, new TypeReference<List<Transformador>>(){});
		
		return transformadores;
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