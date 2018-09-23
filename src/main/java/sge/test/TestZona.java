package sge.test;
import java.util.List;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import sge.transformador.Transformador;
import sge.usuario.Cliente;
import sge.zona.Zona;


public class TestZona {

	@Test
	public void mostrarListaDeTransformadores() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Transformador> transformadores = new ArrayList<Transformador>();
		Transformador transformadorA = new Transformador();
		Transformador transformadorB = new Transformador();
		Transformador transformadorC = new Transformador();
		double resultadoObtenido = 0;
		Zona unaZona = new Zona();
		
		transformadorA.setConsumo(2000.0);
		transformadorB.setConsumo(10000.0);
		transformadorC.setConsumo(3000.0);
		
		transformadores.add(transformadorA);
		transformadores.add(transformadorB);
		transformadores.add(transformadorC);
		
		unaZona.setTransformadores(transformadores);
		
		resultadoObtenido = unaZona.getConsumoTotalDeLaZona(clientes);
		
		assertEquals(15000.0, resultadoObtenido, 0.1);
		
		
	}
	
	@Test
	public void mostrarCoordenadas() {
		// Aca vamos a setear las coordenadas de la UTN campus 
		// para corroborar que los datos lestan ok
		
		Zona zonaUTN = new Zona();
		zonaUTN.setLatitud(-34.59887);
		zonaUTN.setLongitud(-58.42015);
		
		zonaUTN.getLongitud();
		
		assertEquals(-34.59887, zonaUTN.getLatitud(), 0.1);
		assertEquals(-58.42015, zonaUTN.getLongitud(), 0.1);
		
		
	}

}
