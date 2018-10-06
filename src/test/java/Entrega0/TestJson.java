package Entrega0;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Helper.JsonHelper;
import Usuario.Administrador;
import Usuario.Categoria;
import Usuario.Cliente;

public class TestJson {
	
	private static final String PATH_JSON_CLIENTES = "src/test/resources/Data/Clientes.json";
	private static final String PATH_JSON_ADMINISTRADORES = "src/test/resources/Data/Administradores.json";
	private static final String PATH_JSON_CATEGORIAS = "src/test/resources/Data/Categorias.json";
	
	 @Test
	 public void CargaJsonClientes() throws IOException, ParseException {
		 List<Cliente> clientes = new ArrayList<Cliente>();
		 clientes = JsonHelper.extraerClientesJson(PATH_JSON_CLIENTES);
	     assertEquals("Lista de Clientes",2, clientes.size());
	 }

	 @Test
	 public void CargaJsonAdministradores() throws IOException, ParseException {
		 List<Administrador> administradores = new ArrayList<Administrador>();
		 administradores = JsonHelper.extraerAdministradorJson(PATH_JSON_ADMINISTRADORES);
	     assertEquals("Lista de Administradores",1, administradores.size());
	 }

	 @Test
	 public void CargaJsonCategorias() throws IOException, ParseException {
		 List<Categoria> categorias = new ArrayList<Categoria>();
		 categorias = JsonHelper.extraerCategoriasJson(PATH_JSON_CATEGORIAS);
	     assertEquals("Lista de Categorias",9, categorias.size());
	 }

}
