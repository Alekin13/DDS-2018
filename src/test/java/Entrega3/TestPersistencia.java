package Entrega3;

import org.junit.Test;

import Helper.EntityManagerHelper;

public class TestPersistencia {
	
	private static final String PATH_JSON_CLIENTES = "src/test/resources/Data/Clientes.json";
	private static final String PATH_JSON_CATEGORIAS = "src/test/resources/Data/Categorias.json";
	private static final String PATH_JSON_ESTADOS = "src/test/resources/Data/Estados.json";
	//private static final String PATH_JSON_DISPOSITIVOS = "src/test/resources/Data/Dispositivos.json";
	private static final String PATH_JSON_ADMIN = "src/test/resources/Data/Administradores.json";
	private static final String PATH_JSON_ZONA	= "src/test/resources/Data/zonas.json";
	private static final String PATH_JSON_TRANSFORMADOR	= "src/test/resources/Data/Transformadores.json";

	static EntityManagerHelper dbhelper = new EntityManagerHelper();

	    @Test
		public void persistirClientes() throws Exception {
	    	dbhelper.cargarEstadosFromJson(PATH_JSON_ESTADOS);
	    	dbhelper.cargarCategoriasFromJson(PATH_JSON_CATEGORIAS);
	    	dbhelper.cargarUsuarioFromJson(PATH_JSON_CLIENTES);
	    	//dbhelper.cargarDispositivosFromJson(PATH_JSON_DISPOSITIVOS);
	    	dbhelper.cargarAdministradoresFromJson(PATH_JSON_ADMIN);
	    	dbhelper.cargarZonasFromJson(PATH_JSON_ZONA);
	    	dbhelper.cargarTransformadoresJson(PATH_JSON_TRANSFORMADOR);
		}
	}

		