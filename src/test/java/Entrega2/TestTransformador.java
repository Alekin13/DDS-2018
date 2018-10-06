package Entrega2;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import Helper.JsonHelper;
import Zona.Transformador;
import Zona.Zona;

public class TestTransformador {

	private static final String PATH_JSON_ZONA	= "src/test/resources/Data/Zonas.json";
	private static final String PATH_JSON_TRANSFORMADOR	= "src/test/resources/Data/Transformadores.json";
	private List<Transformador> transformadoresJson;
	private List<Zona> zonasJson;
	
	@Before
	public void transformadorEnZona(){
		int i;
		new JsonHelper();
		
		try {
		
			transformadoresJson = JsonHelper.extraerTransformadorJson(PATH_JSON_TRANSFORMADOR);
		
			for (i = 0; i < transformadoresJson.size(); i++) {
				System.out.println("Registro: " + (i + 1));
				System.out.println("Id Transformador: " + transformadoresJson.get(i).getId());
				System.out.println("Id Zona: " + transformadoresJson.get(i).getIdZona());
				System.out.println("Latitud: " + transformadoresJson.get(i).getLatitud());
				System.out.println("Longitud: " + transformadoresJson.get(i).getLongitud());
				System.out.println(" ------------------------");
			}

			zonasJson = JsonHelper.extraerZonasJson(PATH_JSON_ZONA);
			
			for (i = 0; i < zonasJson.size(); i++) {
				System.out.println("Registro: " + (i + 1));
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
		new JsonHelper();
		transformadoresJson = JsonHelper.extraerTransformadorJson(PATH_JSON_TRANSFORMADOR);
		assertEquals(2,transformadoresJson.get(1).getId());
		System.out.println(" Id Transformador: " + transformadoresJson.get(1).getId());
		System.out.println(" ------------------------");
    }
	
	@Test
    public void TestCargarZonasYAgregarTransformadores() throws IOException{  
		new JsonHelper();
		zonasJson = JsonHelper.extraerZonasJson(PATH_JSON_ZONA);
		transformadoresJson = JsonHelper.extraerTransformadorJson(PATH_JSON_TRANSFORMADOR);
		
		for (Zona zona : zonasJson) {
			System.out.println("ZONA LEIDA" + zona.getNombre());
			
			}
		}
		
    	
	}
