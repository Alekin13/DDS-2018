package Server;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.math3.optim.PointValuePair;
import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstado;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoInteligente;
import Helper.EntityManagerHelper;
import Simplex.SimplexJob;
import Usuario.Cliente;
import Usuario.Usuario;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import spark.Spark;

public class Server {
	
	public static void main (String [ ] args) {
		// Spark configuration
		spark.debug.DebugScreen.enableDebugScreen();
		Spark.staticFileLocation("/public");
		Spark.port(8080);
		
		// useful initializations
		accesoServerBDD accesoBDD = new accesoServerBDD();
		
		// Testing connection
		Spark.get("/hello", (req, res) -> "Hello World");
		
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		
		Spark.get("/PaginaSGE", (req,res) -> {
			return new ModelAndView(null, "Login.html");
		},engine);	
		
		//Creating login: accessing 
		Spark.post("/Home", (req,res) -> {
			String nombreUsuario = req.queryParams("nombre");
			String password = req.queryParams("password");
			
			// Need to preserve user when logged in  
			if (accesoBDD.controlLogin(nombreUsuario, password)) {
				Usuario incomingUser = accesoBDD.gettingUserFromDB(nombreUsuario);
				return new ModelAndView(incomingUser, "Home.html");
			} else { 
				Spark.halt(401,"Didnt recognised user");
				Spark.halt(401,"Contraseña inválida");
				return null; }
        },engine);

		
		Spark.get("/EjecutarSimplex", (req,res) -> {
			Cliente incomingUser = accesoBDD.getSessionUser();
			SimplexJob ejecucionDelSimplexInstance = new SimplexJob(incomingUser);
			PointValuePair solucion = ejecucionDelSimplexInstance.ejecutarPeticion();
						
			return new ModelAndView(incomingUser, "EjecucionSimplexActual.html");
		}, engine);
		
		Spark.get("/ConsumoPorPeriodo", (req,res) -> {
			return new ModelAndView(null, "ConsumoPorPeriodo.html");
		},engine);	
		
		Spark.post("/ConsumoPorPeriodo", (req,res) -> {
			
			String fechaInicio = req.queryParams("datepicker");
			String fechaFin = req.queryParams("datepicker2");
			Cliente incomingUser = accesoBDD.getSessionUser();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date fechaInicio_ld = sdf.parse(fechaInicio);
			Date fechaFin_ld = sdf.parse(fechaFin);
			 
			double consumoTotal = 0.0;
			
			for (Dispositivo dispositivo : incomingUser.getDispositivos()) {
				for (DispositivoEstado dEstado : dispositivo.getEstados()) {
					Date cambioEstadoDispositivo = 
							sdf.parse(dEstado.getFechaDeCambioDeEstado());
					 
					if ( cambioEstadoDispositivo.compareTo(fechaInicio_ld) > 0 &&
						 cambioEstadoDispositivo.compareTo(fechaInicio_ld) < 0 ) {
						 
						consumoTotal = consumoTotal + dEstado.getConsumoEstadoPasado();
					}
				}				
				
			}
			incomingUser.setConsumoxPeriodo(consumoTotal);
			return new ModelAndView( incomingUser, "resultadoDelConsumoPeriodo.html");
		}, engine);
		
		Spark.get("/EstadoPorDispositivo", (req,res) -> {
			Cliente incomingUser = accesoBDD.getSessionUser();
			
			return new ModelAndView(incomingUser, "EstadoPorDispositivo.html");
		}, engine);
		
		Spark.get("/ReglasActivas", (req,res) -> {
			Cliente incomingUser = accesoBDD.getSessionUser(); 
//			List<Dispositivo> dispCliene = incomingUser.getDispositivos();
//			List<Dispositivo> dispInteligentes = dispCliene.stream().filter(d -> d.tipoDispositivo == "I").collect(Collectors.toList()).size();
		
			return new ModelAndView(incomingUser, "ReglasActivas.html" );
		},engine);

		//by Gonzalo
		Spark.get("/AltaDispositivos", (req,res) -> {

			return new ModelAndView(null, "AltaDispositivos.html");
			}, engine);
		
		//by Gonzalo
		Spark.post("/AltaDispositivos", (req,res) -> {

			//todo esto para obtener double
			String ConsKWh;
			ConsKWh = req.queryParams("ConsumoKWh");
			double ConsKWhD;
			ConsKWhD = Double.parseDouble(ConsKWh);
			
			//todo esto para obtener double
			String minhs;
			minhs = req.queryParams("UsoMensualMin");			
			double minhsD;
			minhsD = Double.parseDouble(minhs);
			
			//todo esto para obtener double
			String maxhs;
			maxhs = req.queryParams("UsoMensualMax");			
			double maxhsD;
			maxhsD = Double.parseDouble(maxhs);			
			
			String tipoDisp;
			tipoDisp = req.queryParams("tipo").trim();			
			
			if(tipoDisp == "I") {
				
				Dispositivo dispositivo = new DispositivoInteligente();
			
		        dispositivo.setEquipoConcreto(req.queryParams("EquipoConcreto"));
		        dispositivo.setNombreDispositivo(req.queryParams("NombreDispositivo"));
		        dispositivo.setTipoDispositivo("I");
		        dispositivo.setBajoConsumo(req.queryParams("lowC"));
		        dispositivo.setConsumoKwH(ConsKWhD);
		        dispositivo.setUsoMensualMinHs(minhsD);
		        dispositivo.setUsoMensualMaxHs(maxhsD);
		        dispositivo.setEstado("A");		
				
				res.redirect("/Inteligente");
				EntityManagerHelper dbhelper = new EntityManagerHelper();
				dbhelper.agregar(dispositivo);
				
			}
			
			//else { 
			if(tipoDisp == "E") {
				
				Dispositivo dispositivo = new DispositivoEstandar();

		        dispositivo.setEquipoConcreto(req.queryParams("EquipoConcreto"));
		        dispositivo.setNombreDispositivo(req.queryParams("NombreDispositivo"));
		        dispositivo.setTipoDispositivo("E");
		        dispositivo.setBajoConsumo(req.queryParams("lowC"));
		        dispositivo.setConsumoKwH(ConsKWhD);
		        dispositivo.setUsoMensualMinHs(minhsD);
		        dispositivo.setUsoMensualMaxHs(maxhsD);
		        dispositivo.setEstado("A");					
				
				res.redirect("/Estandar");
				
				EntityManagerHelper dbhelper = new EntityManagerHelper();
				dbhelper.agregar(dispositivo);
				
			}

			return null;
			}, engine);			
		
		//by Gonzalo
		Spark.get("/Inteligente", (req, res) -> "Alta Dispositivo Inteligente");
		
		//by Gonzalo
		Spark.get("/Estandar", (req, res) -> "Alta Dispositivo Estandar");	
		
		Spark.post("/LoginAdmin", (req,res) -> {
			String nombreUsuario = req.queryParams("nombre");
			String password = req.queryParams("password");
			
			// Need to preserve user when logged in  
			if (accesoBDD.controlLoginAdmin(nombreUsuario, password)) {
				Usuario incomingUser = accesoBDD.gettingAdminFromDB(nombreUsuario);
				return new ModelAndView(incomingUser, "HomeAdmin.html");
			} else { 
				Spark.halt(401,"Didnt recognised user");
				return null; }
		}, engine);
		
		Spark.get("/Admin", (req,res) -> {
			return new ModelAndView(null, "LoginAdmin.html");
		},engine);	
		

}

}
