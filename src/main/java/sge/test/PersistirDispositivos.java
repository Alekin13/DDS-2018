package sge.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sge.persistencia.CapaPersistencia;

public class PersistirDispositivos {

	private static final String PATH_JSON_DISPOSITIVOS = "src/main/java/sge/data/Dispositivos.json";
	private static final String PATH_JSON_ESTADOS = "src/main/java/sge/data/Estados.json";
	private static final String PATH_JSON_USUARIOS = "src/main/java/sge/data/Usuarios.json";
	static CapaPersistencia dbhelper = new CapaPersistencia();

    @Test
	public void persistirTablaEntrega2() throws Exception {
		
    	dbhelper.cargarTablaEstados(PATH_JSON_ESTADOS);
    	dbhelper.cargarTablaDispositivos(PATH_JSON_DISPOSITIVOS);
    	dbhelper.cargarTablaUsuarios(PATH_JSON_USUARIOS);

	}
}
