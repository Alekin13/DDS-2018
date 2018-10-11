package Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstado;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoInteligente;
import Estado.Apagado;
import Estado.Encendido;
import Estado.Estado;
import Estado.ModoAhorroEnergia;
import Usuario.Administrador;
import Usuario.Categoria;
import Usuario.Cliente;
import Zona.Transformador;
import Zona.Zona;
import Helper.JsonHelper;

public class JsonHelper {

	public static String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }

	        return stringBuilder.toString();
	    } finally {
	        reader.close();
	    }
	}

	public static List<Cliente> extraerClientesJson(String path) throws IOException, ParseException{
		
		String jsonClientes = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Cliente> clientes = new ArrayList<Cliente>();
	   	JsonObject gsonObj1 = parser.parse(jsonClientes).getAsJsonObject();
	   	JsonArray gsonArr = gsonObj1.get("clientes").getAsJsonArray();

	   	for (JsonElement obj : gsonArr) {
	
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        String unUsuario = gsonObj.get("usuario").getAsString();
	        String unaContrasena = gsonObj.get("password").getAsString();
	        String unNombre = gsonObj.get("nombre").getAsString();
	        String unApellido = gsonObj.get("apellido").getAsString();
	        String unDomicilio = gsonObj.get("domicilio").getAsString();
	        String unTipoDoc = gsonObj.get("tipoDoc").getAsString(); 
	        int unNumDoc = gsonObj.get("nroDoc").getAsInt();
	        int unTelefono = gsonObj.get("telefono").getAsInt();
	        String unaCategoria = gsonObj.get("categoria").getAsString();
	        
	        Cliente cliente = new Cliente(unUsuario, unaContrasena, unNombre, unApellido, unDomicilio, LocalDateTime.now(), unTipoDoc, unNumDoc, unTelefono, unaCategoria);
	        clientes.add(cliente);

	    }
	    
		return clientes;
	}

	public static List<Administrador> extraerAdministradorJson(String path) throws IOException, ParseException{
		
		String jsonAdministradores = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Administrador> administradores = new ArrayList<Administrador>();
		JsonObject gsonArr = parser.parse(jsonAdministradores).getAsJsonObject();
		JsonArray gsonObj1 = gsonArr.get("administradores").getAsJsonArray();
		
	   	for (JsonElement obj : gsonObj1) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        Administrador administrador = new Administrador();
	        administrador.setUsuario(gsonObj.get("usuario").getAsString());
	        administrador.setPassword(gsonObj.get("password").getAsString());
	        administrador.setNombre(gsonObj.get("nombre").getAsString());
	        administrador.setApellido(gsonObj.get("apellido").getAsString());
	        administrador.setIdAdmin(gsonObj.get("idAdmin").getAsInt());
	        administrador.setFecAlta(LocalDateTime.now());	        
	        
	        administradores.add(administrador);

	   	}
	   	
	   	return administradores;
	
	}

	public static List<Categoria> extraerCategoriasJson(String path) throws IOException{
		
		String jsonCategorias = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Categoria> categorias = new ArrayList<Categoria>();
		JsonObject gsonArr = parser.parse(jsonCategorias).getAsJsonObject();
		JsonArray gsonObj1 = gsonArr.get("categorias").getAsJsonArray();
	   	
	   	for (JsonElement obj : gsonObj1) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        Categoria categoria = new Categoria();
	        categoria.setCategoria(gsonObj.get("categoria").getAsString());
	        categoria.setCargoFijo(gsonObj.get("cargoFijo").getAsDouble());
	        categoria.setCargoVariable(gsonObj.get("cargoVariable").getAsDouble());

	        categorias.add(categoria);

	   	}
	   	
	   	return categorias;
	}

	
	@SuppressWarnings("null")
	public static List<Dispositivo> extraerDispositivosJson(String path) throws IOException{
		
		String jsonDispositivos = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		JsonObject gsonObj1 = parser.parse(jsonDispositivos).getAsJsonObject();
		JsonArray gsonArr = gsonObj1.get("dispositivos").getAsJsonArray();
		
	   	for (JsonElement obj : gsonArr) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        if(gsonObj.get("tipoDispositivo").getAsString() == "I"){
	        	Dispositivo dispositivo = new DispositivoInteligente();
		        
		        dispositivo.setEquipoConcreto(gsonObj.get("equipoConcreto").getAsString());
		        dispositivo.setNombreDispositivo(gsonObj.get("nombreDispositivo").getAsString());
		        dispositivo.setTipoDispositivo(gsonObj.get("tipoDispositivo").getAsString());
		        dispositivo.setBajoConsumo(gsonObj.get("bajoConsumo").getAsString());
		        dispositivo.setConsumoKwH(gsonObj.get("consumoKwH").getAsDouble());
		        dispositivo.setUsoMensualMinHs(gsonObj.get("usomensualminhs").getAsDouble());
		        dispositivo.setUsoMensualMaxHs(gsonObj.get("usomensualmaxhs").getAsDouble());
		        dispositivo.setEstado("A");
		        
		        dispositivos.add(dispositivo);
		        	
	        }
	        else{
	        	Dispositivo dispositivo = new DispositivoEstandar();
		        
		        dispositivo.setEquipoConcreto(gsonObj.get("equipoConcreto").getAsString());
		        dispositivo.setNombreDispositivo(gsonObj.get("nombreDispositivo").getAsString());
		        dispositivo.setTipoDispositivo(gsonObj.get("tipoDispositivo").getAsString());
		        dispositivo.setBajoConsumo(gsonObj.get("bajoConsumo").getAsString());
		        dispositivo.setConsumoKwH(gsonObj.get("consumoKwH").getAsDouble());
		        dispositivo.setUsoMensualMinHs(gsonObj.get("usomensualminhs").getAsDouble());
		        dispositivo.setUsoMensualMaxHs(gsonObj.get("usomensualmaxhs").getAsDouble());
		        dispositivo.setEstado("A");
		        
		        dispositivos.add(dispositivo);
		        	
	        }
	        
	        }
	   	
	   	return dispositivos;
	}

	public static List<Transformador> extraerTransformadorJson(String path) throws IOException{
		
		String jsonTransformadores = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Transformador> transformadores = new ArrayList<Transformador>();
		JsonArray gsonObj1 = parser.parse(jsonTransformadores).getAsJsonArray();

	   	for (JsonElement obj : gsonObj1) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        Transformador transformador = new Transformador();
	        transformador.setId(gsonObj.get("id").getAsInt());
	        transformador.setIdZona(gsonObj.get("idZona").getAsInt());
	        transformador.setLatitud(gsonObj.get("latitud").getAsDouble());
	        transformador.setLongitud(gsonObj.get("longitud").getAsDouble());
	    
	        transformadores.add(transformador);

	   	}
	   	
	   	return transformadores;
	}

	public static List<Zona> extraerZonasJson(String path) throws IOException{
		
		String jsonZonas = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Zona> zonas = new ArrayList<Zona>();
		JsonArray gsonObj1 = parser.parse(jsonZonas).getAsJsonArray();

	   	for (JsonElement obj : gsonObj1) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        Zona zona = new Zona();
	        zona.setNombre(gsonObj.get("nombre").getAsString());
	        zona.setRadio(gsonObj.get("radio").getAsDouble());
	        zona.setLatitud(gsonObj.get("latitud").getAsDouble());
	        zona.setLongitud(gsonObj.get("longitud").getAsDouble());
	        zona.setTransformadores(new ArrayList<Transformador>());
	        
	        zonas.add(zona);

	   	}
	   	
	   	return zonas;
	}

	public static List<Estado> extraerEstadosJson(String path) throws IOException{
		String jsonEstados = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Estado> estados = new ArrayList<Estado>();
		JsonObject gsonObj1 = parser.parse(jsonEstados).getAsJsonObject();
		JsonArray gsonArr = gsonObj1.get("estados").getAsJsonArray();
		
	   	for (JsonElement obj : gsonArr) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	        
	        if(gsonObj.get("clave").getAsCharacter() == 'E'){
	        	Estado estado = new Encendido();
	        	estado.setDescripcion((gsonObj.get("descripcion").getAsString()));
		        estado.setClave((gsonObj.get("clave").getAsString()));
		        
		        estados.add(estado);
	        }
	        else if(gsonObj.get("clave").getAsCharacter() == 'A'){
	        	Estado estado = new Apagado();
	        	estado.setDescripcion((gsonObj.get("descripcion").getAsString()));
		        estado.setClave((gsonObj.get("clave").getAsString()));
		        
		        estados.add(estado);
	        }
	        else{
	        	Estado estado = new ModoAhorroEnergia();
	        	estado.setDescripcion((gsonObj.get("descripcion").getAsString()));
		        estado.setClave((gsonObj.get("clave").getAsString()));
		        
		        estados.add(estado);
	        }

	   	}
	   	
	   	return estados;
	}


	public static List<DispositivoEstado> extraerEstadosPorDispJson(String path) throws IOException{
		
		String jsonEstadosPorDisp = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<DispositivoEstado> estPorDisps = new ArrayList<DispositivoEstado>();
		JsonArray gsonObj1 = parser.parse(jsonEstadosPorDisp).getAsJsonArray();

	   	for (JsonElement obj : gsonObj1) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        DispositivoEstado estPorDisp = new DispositivoEstado();
	        estPorDisp.setIdDispositivo(gsonObj.get("idDispositivo").getAsInt());
	        estPorDisp.setEstadoAnterior(gsonObj.get("estadoAnterior").getAsString());
	        estPorDisp.setEstadoActual(gsonObj.get("estadoActual").getAsString());
	        estPorDisp.setFechaActual();
	    
	        
	        estPorDisps.add(estPorDisp);

	   	}
	   	
	   	return estPorDisps;
	}
	
}
