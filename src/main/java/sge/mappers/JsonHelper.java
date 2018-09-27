package sge.mappers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sge.Entidades.Categoria;
import sge.usuario.Administrador;
import sge.usuario.Cliente;
import sge.usuario.Usuario;
import sge.Entidades.Transformador;
import sge.Entidades.Zona;
import sge.dispositivo.Dispositivo;
import sge.estados.Estado;

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
		// Obtengo el primer ObjetoJason
	   	JsonObject gsonObj1 = parser.parse(jsonClientes).getAsJsonObject();
	   	// Obtengo el array clientes
	   	JsonArray gsonArr = gsonObj1.get("clientes").getAsJsonArray();

	   	// Itero el array de clientes
	    for (JsonElement obj : gsonArr) {
	
	        // Obtengo el objeto Cliente
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        // Obtengo las primitivas del cliente
	        String unUsuario = gsonObj.get("usuario").getAsString();
	        String unaContrasena = gsonObj.get("password").getAsString();
	        String unNombre = gsonObj.get("nombre").getAsString();
	        String unApellido = gsonObj.get("apellido").getAsString();
	        String unDomicilio = gsonObj.get("domicilio").getAsString();
	        String unaFecha = gsonObj.get("fechaAlta").getAsString();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        Date date = sdf.parse(unaFecha);
	        Calendar unaFechaC = Calendar.getInstance();
	        unaFechaC.setTime(date);	        
	        String unTipoDoc = gsonObj.get("tipoDoc").getAsString(); 
	        Integer unNumDoc = gsonObj.get("nroDoc").getAsInt();
	        Integer unTelefono = gsonObj.get("telefono").getAsInt();
	        
	        /*
	         // Obtengo el array de dispositivos
	         
	        JsonArray dispositivos = gsonObj.get("dispositivos").getAsJsonArray();
	        List<Dispositivo> listDispositivo = new ArrayList<Dispositivo>();
	        
	        // Itero el array de dispositivos
	        for (JsonElement disp : dispositivos) {
	        	
	        	// Obtengo el objeto Dispositivo
	        	JsonObject di = disp.getAsJsonObject();
	        	
	        	// Obtengo las primitivas del Dispositivo
	        	String nombre_generico = di.get("nombre_generico").getAsString();
	            double consumoKWHora = di.get("consumoKWHora").getAsDouble();
	            int horasEncendido = di.get("horasEncendido").getAsInt();
	            DispositivoEstandar dispositivo = new DispositivoEstandar(nombre_generico,consumoKWHora,horasEncendido); 
	        	listDispositivo.add(dispositivo);
	        }
	        
	        JsonArray dispositivos_i = gsonObj.get("dispositivos_i").getAsJsonArray();
	        	        
	        // Itero el array de dispositivos
	        for (JsonElement disp : dispositivos_i) {
	        	
	        	// Obtengo el objeto Dispositivo
	        	JsonObject dis = disp.getAsJsonObject();
	        	
	        	// Obtengo las primitivas del Dispositivo
	        	String nombre_generico = dis.get("nombre_generico").getAsString();
	            double consumoKWHora = dis.get("consumoKWHora").getAsDouble();
	            String estado = dis.get("estado").getAsString();
	            Estado objEstado = seleccionarEstado(estado);
	            //String actuador = dis.get("actuador").getAsString();
	            
	            JsonArray sensores = dis.get("sensores").getAsJsonArray();
	            List<Sensor> listaDeSensores= new ArrayList<Sensor>();
	            for (JsonElement sens : sensores){
	            	JsonObject sen = sens.getAsJsonObject();
	            	
	            	// Obtengo las primitivas del Sensor
	            	int valor = sen.get("valor").getAsInt();
	            	String magnitud = sen.get("magnitud").getAsString();
	            	Sensor sensor = generarSensor(valor,magnitud);
	            	listaDeSensores.add(sensor);
	            }
	            JsonArray periodos = dis.get("periodos").getAsJsonArray();
	            List<Periodo> listaDePeriodos= new ArrayList<Periodo>();
	            for (JsonElement peri : periodos){
	            	JsonObject per = peri.getAsJsonObject();
	            	
	            	// Obtengo las primitivas del Sensor
	            	long inicio = per.get("inicio").getAsLong();
	            	long fin = per.get("fin").getAsLong();
	            	Periodo periodo = new Periodo(inicio,fin);
	            	listaDePeriodos.add(periodo);
	            }
	            
	        */
	        //Instancio el cliente
	        //clientes.add(new Cliente(unUsuario, unaContrasena, unNombre, unApellido, unDomicilio, LocalDateTime.now(), unTipoDoc,unNumDoc,unTelefono, null));
	     

	    }
	    
	    //Retorno el listado de clientes que obtuve del Jason
		return clientes;
	}

	public static List<Administrador> extraerAdministradorJson(String path) throws IOException, ParseException{
		
		String jsonAdministradores = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Administrador> administradores = new ArrayList<Administrador>();
		JsonArray gsonObj1 = parser.parse(jsonAdministradores).getAsJsonArray();

	   	for (JsonElement obj : gsonObj1) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        Administrador administrador = new Administrador();
	        administrador.setUsuario(gsonObj.get("usuario").getAsString());
	        administrador.setPassword(gsonObj.get("password").getAsString());
	        administrador.setNombre(gsonObj.get("nombre").getAsString());
	        administrador.setApellido(gsonObj.get("apellido").getAsString());
	        administrador.setIdAdmin(gsonObj.get("idAdmin").getAsInt());
	        
	        /* Extraigo la fecha */
	        String unaFecha = gsonObj.get("fechaAlta").getAsString();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        Date date = sdf.parse(unaFecha);
	        LocalDateTime unaFechaC = LocalDateTime.now();//Calendar.getInstance();
	        //unaFechaC.setTime(date);
	        //administrador.setFecAlta(unaFechaC);	        
	        
	        administradores.add(administrador);

	   	}
	   	
	   	return administradores;
	}

	/*	private static Estado seleccionarEstado(String estado) {
		if(estado.equals("Encendido")){
			return Encendido.class .getInstance();
		}
		else{
			if(estado.equals("ModoAhorro")){
				return AhorroDeEnergia.getInstance();
			}
			else{
				return Apagado.getInstance();
			}
		}
	}
*/	
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
	        zona.setId(gsonObj.get("id").getAsInt());
	        zona.setNombre(gsonObj.get("nombre").getAsString());
	        zona.setRadio(gsonObj.get("radio").getAsDouble());
	        zona.setLatitud(gsonObj.get("latitud").getAsDouble());
	        zona.setLongitud(gsonObj.get("longitud").getAsDouble());
	        zona.setTransformadores(new ArrayList<Transformador>());
	        
	        zonas.add(zona);

	   	}
	   	
	   	return zonas;
	}

	public List<Administrador> extraerAdministradoresJson(String pathJsonAdministradores) {
		return null;
	}

	
	public static List<Dispositivo> extraerDispositivosJson(String path) throws IOException{
		String jsonDispositivos = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		JsonObject gsonObj1 = parser.parse(jsonDispositivos).getAsJsonObject();
		JsonArray gsonArr = gsonObj1.get("dispositivos").getAsJsonArray();
		
	   	for (JsonElement obj : gsonArr) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        Dispositivo dispositivo = new Dispositivo();
	        
	        dispositivo.setNombreDispositivo(gsonObj.get("nombreDispositivo").getAsString());
	        dispositivo.setEquipoConcreto(gsonObj.get("equipoConcreto").getAsString());
	        dispositivo.setTipoDispositivo(gsonObj.get("tipoDispositivo").getAsString());
	        dispositivo.setBajoConsumo(gsonObj.get("bajoConsumo").getAsString());
	        dispositivo.setPropiedad(gsonObj.get("consumoKwH").getAsString());
	        dispositivo.setUsomensualminhs(gsonObj.get("usomensualminhs").getAsDouble());
	        dispositivo.setUsomensualmaxhs(gsonObj.get("usomensualmaxhs").getAsDouble());
	        
	        dispositivos.add(dispositivo);

	   	}
	   	
	   	return dispositivos;
	}
	
	public static List<Estado> extraerEstadosJson(String path) throws IOException{
		String jsonEstados = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Estado> estados = new ArrayList<Estado>();
		JsonObject gsonObj1 = parser.parse(jsonEstados).getAsJsonObject();
		JsonArray gsonArr = gsonObj1.get("estados").getAsJsonArray();
		
	   	for (JsonElement obj : gsonArr) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        Estado estado = new Estado();
	        
	        estado.setEncendido(gsonObj.get("encendido").getAsInt());
	        estado.setApagado(gsonObj.get("apagado").getAsInt());
	        estado.setAhorroEnergia(gsonObj.get("ahorroEnergia").getAsInt());
	        estado.setDescripcion(gsonObj.get("descripcion").getAsString());
	        
	        estados.add(estado);

	   	}
	   	
	   	return estados;
	}
	
	public static List<Usuario> extraerUsuariosJson(String path) throws IOException{
		String jsonUsuarios = JsonHelper.readFile(path);
		JsonParser parser = new JsonParser();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		JsonObject gsonObj1 = parser.parse(jsonUsuarios).getAsJsonObject();
		JsonArray gsonArr = gsonObj1.get("usuarios").getAsJsonArray();
		
	   	for (JsonElement obj : gsonArr) {
	   		
	        JsonObject gsonObj = obj.getAsJsonObject();
	
	        Usuario usuario = new Usuario();
	        
	        usuario.setUsuario(gsonObj.get("usuario").getAsString());
	        usuario.setPassword(gsonObj.get("password").getAsString());
	        usuario.setNombre(gsonObj.get("nombre").getAsString());
	        usuario.setApellido(gsonObj.get("apellido").getAsString());
	        usuario.setDomicilio(gsonObj.get("domicilio").getAsString());
	        usuario.setRol(gsonObj.get("rol").getAsString());
	        usuario.setFecAlta(gsonObj.get("fechaAlta").getAsString());
	        usuario.setTipoDoc(gsonObj.get("tipoDoc").getAsString());
	        usuario.setNroDoc(gsonObj.get("nroDoc").getAsString());
	        usuario.setTelefono(gsonObj.get("telefono").getAsInt());
	        
	        usuarios.add(usuario);

	   	}
	   	
	   	return usuarios;
	}
	
	
}
