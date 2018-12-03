package Server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.math3.optim.PointValuePair;
import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstado;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoInteligente;
import Dispositivo.DispositivoMaestro;
import Helper.EntityManagerHelper;
import Reporte.Reporte;
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
		Reporte generarReportes = new Reporte();
		
		// Testing connection
		Spark.get("/hello", (req, res) -> "Hello World");
		
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

		
//////// Pagina principal, con acceso para el usuario y opcon de administrador //////////
		
		Spark.get("/PaginaSGE", (req,res) -> {
			return new ModelAndView(null, "Login.html");
		},engine);	
		
		
//////// LOGIN de USUARIO //////////
		
		Spark.post("/Home", (req,res) -> {
			String nombreUsuario = req.queryParams("nombre");
			String password = req.queryParams("password");
			
			// Need to preserve user when logged in  
			if (accesoBDD.controlLogin(nombreUsuario, password)) {
				Usuario incomingUser = accesoBDD.gettingUserFromDB();
				return new ModelAndView(incomingUser, "Home.html");
			} else { 
				Spark.halt(401,"Didnt recognised user");
				Spark.halt(401,"Contraseña inválida");
				return null; }
        },engine);

		
////////USUARIO: LISTAR DISPOSITIVOS //////////
		
		Spark.get("/MostrarDispositivosDelUsuario", (req,res) -> {
			Usuario incomingUser = accesoBDD.gettingUserFromDB();
			return new ModelAndView(incomingUser, "ListarLosDispositivosParaElCliente.html");
			}, engine);
		
		
		Spark.get("/MostrarConsumo", (req,res) -> {
			System.out.println(req.queryParams());
			String id = req.queryParams("id").toString();
			
			return null;
			}, engine);

		
//////// USUARIO: EJECUCION DEL SIMPLEX //////////
		
		Spark.get("/EjecutarSimplex", (req,res) -> {
			Cliente incomingUser = accesoBDD.getSessionUser();
			SimplexJob ejecucionDelSimplexInstance = new SimplexJob(incomingUser);
			PointValuePair solucion = ejecucionDelSimplexInstance.ejecutarPeticion();
			return new ModelAndView(incomingUser, "EjecucionSimplexActual.html");
		}, engine);

		
//////// USUARIO: CONSUMO POR PERIODO //////////
		
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
		
		
////////USUARIO: ESTADO POR DISPOSITIVO //////////		
		
		Spark.get("/EstadoPorDispositivo", (req,res) -> {
			Cliente incomingUser = accesoBDD.getSessionUser();
			
			return new ModelAndView(incomingUser, "EstadoPorDispositivo.html");
		}, engine);

		
////////USUARIO: REGLAS ACTIVAS //////////
		
		Spark.get("/ReglasActivas", (req,res) -> {
			Cliente incomingUser = accesoBDD.getSessionUser(); 
//			List<Dispositivo> dispCliene = incomingUser.getDispositivos();
//			List<Dispositivo> dispInteligentes = dispCliene.stream().filter(d -> d.tipoDispositivo == "I").collect(Collectors.toList()).size();
		
			return new ModelAndView(incomingUser, "ReglasActivas.html" );
		},engine);

		
////////USUARIO: ALTA DISPOSITIVO //////////	
		
		//by Gonzalo
		Spark.get("/AltaDispositivos", (req,res) -> {

			return new ModelAndView(null, "AltaDispositivos.html");
			}, engine);
		

////////USUARIO: ALTA DISPOSITIVO //////////
		
		//by Gonzalo
		Spark.post("/AltaDispositivos", (req,res) -> {
			Cliente incomingUser = (Cliente) accesoBDD.gettingUserFromDB();

			String ConsKWh;
			ConsKWh = req.queryParams("ConsumoKWh");
			double ConsKWhD;
			ConsKWhD = Double.parseDouble(ConsKWh);
			

			String minhs;
			minhs = req.queryParams("UsoMensualMin");			
			double minhsD;
			minhsD = Double.parseDouble(minhs);
			
			String maxhs;
			maxhs = req.queryParams("UsoMensualMax");			
			double maxhsD;
			maxhsD = Double.parseDouble(maxhs);			
			
			String tipoDisp;
			tipoDisp = req.queryParams("tipo").trim();			
			
			if(tipoDisp.equals(new String("I"))) {
				
				Dispositivo dispositivo = new DispositivoInteligente();
				
		        dispositivo.setEquipoConcreto(req.queryParams("EquipoConcreto"));
		        dispositivo.setNombreDispositivo(req.queryParams("NombreDispositivo"));
		        dispositivo.setTipoDispositivo("I");
		        dispositivo.setBajoConsumo(req.queryParams("lowC"));
		        dispositivo.setConsumoKwH(ConsKWhD);
		        dispositivo.setUsoMensualMinHs(minhsD);
		        dispositivo.setUsoMensualMaxHs(maxhsD);
		        dispositivo.setEstado("A");		

		        incomingUser.agregarDispositivo(dispositivo);
		        
				EntityManagerHelper dbhelper = new EntityManagerHelper();
				dbhelper.modificar(incomingUser);

				res.redirect("/Inteligente");
			}

			if(tipoDisp.equals(new String("E"))) {
				
				Dispositivo dispositivo = new DispositivoEstandar();

		        dispositivo.setEquipoConcreto(req.queryParams("EquipoConcreto"));
		        dispositivo.setNombreDispositivo(req.queryParams("NombreDispositivo"));
		        dispositivo.setTipoDispositivo("E");
		        dispositivo.setBajoConsumo(req.queryParams("lowC"));
		        dispositivo.setConsumoKwH(ConsKWhD);
		        dispositivo.setUsoMensualMinHs(minhsD);
		        dispositivo.setUsoMensualMaxHs(maxhsD);
		        dispositivo.setEstado("A");					
	
		        incomingUser.agregarDispositivo(dispositivo);
		        
				EntityManagerHelper dbhelper = new EntityManagerHelper();
				dbhelper.modificar(incomingUser);
		        
				res.redirect("/Estandar");				
			}

			return null;
			}, engine);			
		
		//by Gonzalo
		Spark.get("/Inteligente", (req, res) -> "Alta Dispositivo Inteligente exitosa");
		
		//by Gonzalo
		Spark.get("/Estandar", (req, res) -> "Alta Dispositivo Estandar exitosa");	
		
		Spark.post("/LoginAdmin", (req,res) -> {
			String nombreUsuario = req.queryParams("nombre");
			String password = req.queryParams("password");
			
			if (accesoBDD.controlLoginAdmin(nombreUsuario, password)) {
				Usuario incomingUser = accesoBDD.gettingAdminFromDB();
				return new ModelAndView(incomingUser, "HomeAdmin.html");
			} else { 
				Spark.halt(401,"Didnt recognised user");
				return null; }
		}, engine);
		
		
//////// LOGIN de ADMIN //////////
		
		Spark.get("/Admin", (req,res) -> {
			return new ModelAndView(null, "LoginAdmin.html");
		},engine);
		
		
//////// LOGIN de USUARIO //////////
		
		Spark.post("/LoginAdmin", (req,res) -> {
			String nombreUsuario = req.queryParams("nombre");
			String password = req.queryParams("password");
			
			// Need to preserve user when logged in  
			if (accesoBDD.controlLoginAdmin(nombreUsuario, password)) {
				Usuario incomingUser = accesoBDD.gettingAdminFromDB();
				return new ModelAndView(incomingUser,"HomeAdmin.html");
			} else { 
				Spark.halt(401,"Didnt recognised user");
				return null; }
		}, engine);

		
//////// ADMIN: CREAR DISPOSITIVO //////////
		
		Spark.get("/CrearDispositivo", (req,res) -> {
			return new ModelAndView(null, "CrearDispositivo.html");
		}, engine);

		
//////// ADMIN: CREAR DISPOSITIVO //////////
		
		Spark.post("/CrearDispositivo", (req,res) -> {

			String ConsKWh;
			ConsKWh = req.queryParams("ConsumoKWh");
			double ConsKWhD;
			ConsKWhD = Double.parseDouble(ConsKWh);
			
			String minhs;
			minhs = req.queryParams("UsoMensualMin");			
			double minhsD;
			minhsD = Double.parseDouble(minhs);
			
			String maxhs;
			maxhs = req.queryParams("UsoMensualMax");			
			double maxhsD;
			maxhsD = Double.parseDouble(maxhs);			
						
				DispositivoMaestro dispositivo = new DispositivoMaestro();
			
		        dispositivo.setEquipoConcreto(req.queryParams("EquipoConcreto"));
		        dispositivo.setNombreDispositivo(req.queryParams("NombreDispositivo"));
		        dispositivo.setTipoDispositivo(req.queryParams("tipo").trim());
		        dispositivo.setBajoConsumo(req.queryParams("lowC"));
		        dispositivo.setConsumoKwH(ConsKWhD);
		        dispositivo.setUsoMensualMinHs(minhsD);
		        dispositivo.setUsoMensualMaxHs(maxhsD);
					
                EntityManagerHelper dbhelper = new EntityManagerHelper();
				dbhelper.agregar(dispositivo);
				
				res.redirect("/Inteligente");
				return null;
		},engine);	
		
////////ADMIN: GENERAR REPORTES //////////
		
		Spark.get("/GenerarReportes", (req,res) -> {
			return new ModelAndView(null, "SeleccionPeriodoYReporte.html");
		}, engine);
		
		
////////ADMIN: GENERAR REPORTES - Consumo transformadores//////////
		
		Spark.post("/ReporteConsumoTransformador", (req,res) -> {
			//generarReportes
			
			
			
			return new ModelAndView(null, "SeleccionPeriodoYReporte.html");
		}, engine);
		
		
////////ADMIN: GENERAR REPORTES - Consumo hogares//////////
		
		Spark.post("/ReporteConsumoHogar", (req,res) -> {
			
			
			
			return new ModelAndView(null, "SeleccionPeriodoYReporte.html");
		}, engine);
		
		
////////ADMIN: GENERAR REPORTES - Consumo hogares//////////
		
		Spark.get("/ListarDispositivosPermitidos", (req,res) -> {
			List<DispositivoMaestro> dispHabilitados = accesoBDD.obtenerDispHabilitados();
			
			return new ModelAndView(dispHabilitados, "ListarDispHabilitadosAdmin.html");
		}, engine);		
		
		
////////ADMIN: CERRAR SESION USUARIO //////////
		
		Spark.get("/CerrarSesionUsuario", (req,res) -> {
			accesoBDD.CerrarSesionUsuario();
			
			res.redirect("/PaginaSGE");
			
			return null;
		}, engine);
		
////////ADMIN: CERRAR SESION ADMIN //////////
		
		Spark.get("/CerrarSesionAdmin", (req,res) -> {
			accesoBDD.CerrarSesionAmin();
			
			res.redirect("/PaginaSGE");
			
			return null;
		}, engine);

			
	}
}
