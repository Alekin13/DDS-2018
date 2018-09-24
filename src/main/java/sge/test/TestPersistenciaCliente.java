package sge.test;

import org.junit.Test;
import sge.persistencia.CapaPersistencia;

public class TestPersistenciaCliente {

	private static final String PATH_JSON_CLIENTES = "src/main/java/sge/data/Clientes.json";
	private static final String PATH_JSON_CATEGORIAS = "src/main/java/sge/data/Categorias.json";
	static CapaPersistencia dbhelper = new CapaPersistencia();

    @Test
	public void persistirClientes() throws Exception {
		dbhelper.cargarCategoriasFromJson(PATH_JSON_CATEGORIAS);
    	dbhelper.cargarUsuarioFromJson(PATH_JSON_CLIENTES);
	}
}

	