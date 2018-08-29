package sge.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sge.mappers.JsonHelper;
import sge.usuario.Cliente;

public class TestJson {
	
    @Test
    public void debeDevolverJSONEnUnObjeto() throws IOException, ParseException {
    	List<Cliente> clientes = new ArrayList<Cliente>();
    	clientes = JsonHelper.extraerClientesJson("src/main/java/sge/data/Clientes.json");
        assertEquals("Lista de clientes",2, clientes.size());
    }
    
}
