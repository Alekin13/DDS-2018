package sge.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sge.persistencia.CapaPersistencia;

public class PersistirDispositivos {

	private static final String PATH_JSON_DISPOSITIVOS = "src/main/java/sge/data/Dispositivos.json";
	static CapaPersistencia dbhelper = new CapaPersistencia();

    @Test
	public void persistirTablaEntrega2() throws Exception {
		dbhelper.cargarTablaDispositivos(PATH_JSON_DISPOSITIVOS);

	}
}
