package sge.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sge.mappers.JsonHelper;
import sge.persistencia.CapaPersistencia;
import sge.usuario.Cliente;

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

	