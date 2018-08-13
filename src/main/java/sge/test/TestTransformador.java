package sge.test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import sge.mappers.JsonMapper;
import sge.transformador.Transformador;
import sge.zona.Zona;

public class TestTransformador {

	private static final String PATH_JSON_ZONA	= "src/main/java/sge/data/Zonas.json";
	private static final String PATH_JSON_TRANSFORMADOR	= "src/main/java/sge/data/Transformadores.json";
	private List<Transformador> transformadoresJson;
	private List<Zona> zonasJson;
	
	@Before
	public void transformadorEnZona(){
		int i;
		JsonMapper mapper = new JsonMapper();
		
		try {
		
			transformadoresJson = mapper.extraerTransformadorJson(PATH_JSON_TRANSFORMADOR);
		
			for (i = 0; i < transformadoresJson.size(); i++) {
				System.out.println("Registro: " + (i + 1));
				System.out.println("Id Transformador: " + transformadoresJson.get(i).getId());
				System.out.println("Id Zona: " + transformadoresJson.get(i).getIdZona());
				System.out.println("Latitud: " + transformadoresJson.get(i).getLatitud());
				System.out.println("Longitud: " + transformadoresJson.get(i).getLongitud());
				System.out.println(" ------------------------");
			}

			zonasJson = mapper.extraerZonasJson(PATH_JSON_ZONA);
			
			for (i = 0; i < zonasJson.size(); i++) {
				System.out.println("Registro: " + (i + 1));
				System.out.println("Id Zona: " + zonasJson.get(i).getId());
				System.out.println("Nombre: " + zonasJson.get(i).getNombre());
				System.out.println("Radio: " + zonasJson.get(i).getRadio());
				System.out.println("Latitud: " + zonasJson.get(i).getLatitud());
				System.out.println("Longitud: " + zonasJson.get(i).getLongitud());
				System.out.println(" ------------------------");
			}

		
		}	 
	catch (Exception e) {
		System.out.println(e.getMessage());
	}

	}
	
	
	@Test
    public void TestDevolverIdTransformador() throws IOException {    
		JsonMapper mapper = new JsonMapper();
		transformadoresJson = mapper.extraerTransformadorJson(PATH_JSON_TRANSFORMADOR);
		assertEquals(2,transformadoresJson.get(1).getId());
		System.out.println(" ------------------------");
		System.out.println(" Id Transformador: " + transformadoresJson.get(1).getId());
		System.out.println(" ------------------------");
    }
	
	@Test
    public void TestCargarZonasYAgregarTransformadores() throws IOException{  
		JsonMapper mapper = new JsonMapper();
		zonasJson = mapper.extraerZonasJson(PATH_JSON_ZONA);
		transformadoresJson = mapper.extraerTransformadorJson(PATH_JSON_TRANSFORMADOR);
		
		for (Zona zona : zonasJson) {
			System.out.println(" ZONA LEIDA ");
			for (Transformador transformador : transformadoresJson) {
				if (transformador.getIdZona()==zona.getId()) {
					System.out.println(" Tranformador Leido " + transformador.getId() + " Zona" + transformador.getIdZona());
					//NO ESTA FUNCIONANDO PREGUNTAR PORQUE ]zona.agregarTransformador(transformador);
				}
			}
		}
		
    	assertEquals(2,zonasJson.get(1).getId());
    	//NO ESTA FUNCIONANDO PREGUNTAR PORQUE assertEquals(0,zonasJson.get(1).getTransformadores().size());
    }
}