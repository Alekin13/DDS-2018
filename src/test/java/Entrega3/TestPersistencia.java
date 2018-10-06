package Entrega3;

import org.junit.Test;

import Helper.EntityManagerHelper;

public class TestPersistencia {
	
	private static final String PATH_JSON_CLIENTES = "src/test/resources/Data/Clientes.json";
	private static final String PATH_JSON_CATEGORIAS = "src/test/resources/Data/Categorias.json";
	private static final String PATH_JSON_ESTADOS = "src/test/resources/Data/Estados.json";
	private static final String PATH_JSON_ESTPORDISP = "src/test/resources/Data/estadosPorDispositivo.json";
	static EntityManagerHelper dbhelper = new EntityManagerHelper();

	    @Test
		public void persistirClientes() throws Exception {
	    	dbhelper.cargarEstadosFromJson(PATH_JSON_ESTADOS);
	    	dbhelper.cargarCategoriasFromJson(PATH_JSON_CATEGORIAS);
	    	dbhelper.cargarUsuarioFromJson(PATH_JSON_CLIENTES);
	    	dbhelper.cargarDispositivoEstadoFromJson(PATH_JSON_ESTPORDISP);
		}
	}

		